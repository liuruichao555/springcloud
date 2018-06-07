package com.liuruichao.jwt.security;

import com.liuruichao.jwt.service.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

import javax.annotation.Resource;

/**
 * com.liuruichao.jwt.config.OAuth2AuthorizationServerConfig
 *
 * @author liuruichao
 * Created on 2018/6/7 10:13
 */
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {
    @Value(value = "${security.oauth2.resource.id}")
    private String resourceId;

    @Value("${access_token.validity_period}")
    private int accessTokenValiditySeconds;

    @Value("${refresh_token.validity_period}")
    private int refreshTokenValiditySeconds;

    @Resource
    private AuthenticationManager authenticationManager;

    @Resource
    private SecretKeyProvider secretKeyProvider;

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        /*TokenEnhancerChain tokenEnhancerChain = new TokenEnhancerChain();
        tokenEnhancerChain.setTokenEnhancers(Arrays.asList(tokenEnhancer(), accessTokenConverter()));*/

        endpoints
                .authenticationManager(this.authenticationManager)
                .tokenServices(tokenServices())
                .tokenStore(tokenStore())
                .accessTokenConverter(accessTokenConverter());
//                .tokenEnhancer(tokenEnhancerChain);
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
        /*oauthServer
                .passwordEncoder(passwordEncoder())
                .allowFormAuthenticationForClients()
                .tokenKeyAccess("isAnonymous() || hasAuthority('ROLE_TRUSTED_CLIENT')")
                .checkTokenAccess("hasAuthority('ROLE_TRUSTED_CLIENT')");*/
        oauthServer
                .tokenKeyAccess("isAnonymous() || hasAuthority('ROLE_TRUSTED_CLIENT')")
                .checkTokenAccess("hasAuthority('ROLE_TRUSTED_CLIENT')");
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                .withClient("normal-app")
                .authorizedGrantTypes("authorization_code", "implicit")
                .authorities("ROLE_CLIENT")
                .scopes("read", "write")
                .resourceIds(resourceId)
                .accessTokenValiditySeconds(accessTokenValiditySeconds)
                .refreshTokenValiditySeconds(refreshTokenValiditySeconds)
                .and()
                .withClient("trusted-app")
                .authorizedGrantTypes("client_credentials", "password", "refresh_token")
                .authorities("ROLE_TRUSTED_CLIENT")
                .scopes("read", "write")
                .resourceIds(resourceId)
                .accessTokenValiditySeconds(accessTokenValiditySeconds)
                .refreshTokenValiditySeconds(refreshTokenValiditySeconds)
                .secret("secret")
                .and()
                .withClient("register-app")
                .authorizedGrantTypes("client_credentials")
                .authorities("ROLE_REGISTER")
                .scopes("read")
                .resourceIds(resourceId)
                .secret("secret")
                .and()
                .withClient("my-client-with-registered-redirect")
                .authorizedGrantTypes("authorization_code")
                .authorities("ROLE_CLIENT")
                .scopes("read", "trust")
                .resourceIds("oauth2-resource")
                .redirectUris("http://anywhere?key=value");
    }

    @Bean
    @Primary
    public DefaultTokenServices tokenServices() {
        final DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
        defaultTokenServices.setTokenStore(tokenStore());
        defaultTokenServices.setSupportRefreshToken(true);
        defaultTokenServices.setTokenEnhancer(accessTokenConverter());
        return defaultTokenServices;
    }

    @Bean
    public TokenStore tokenStore() {
        return new JwtTokenStore(accessTokenConverter());
    }

    @Bean
    public JwtAccessTokenConverter accessTokenConverter() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        converter.setSigningKey(secretKeyProvider.getSigningKey());
        converter.setKeyPair(secretKeyProvider.getKeyPair());
        return converter;
    }

    @Bean
    public UserDetailsService userDetailsService(){
        return new UserService();
    }
}