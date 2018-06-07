package com.liuruichao.jwt.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.web.util.matcher.RequestMatcher;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * OAuth2ResourceServerConfig
 *
 * @author liuruichao
 * Created on 2018/6/7 10:34
 */
@Configuration
@EnableResourceServer
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ResourceConfig extends ResourceServerConfigurerAdapter {
    @Value(value = "${security.oauth2.resource.id}")
    private String resourceId;

    @Resource
    private DefaultTokenServices tokenServices;

    @Resource
    private TokenStore tokenStore;

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources
                .resourceId(resourceId)
                .tokenServices(tokenServices)
                .tokenStore(tokenStore);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.requestMatcher(new OAuthRequestedMatcher())
                .anonymous().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.OPTIONS).permitAll()
                //.antMatchers("/api/hello").access("hasAnyRole('USER')")
                //.antMatchers("/api/hello2").access("hasAnyRole('ADMIN')")
                .antMatchers("/api/hello").hasAnyAuthority("USER")
                .antMatchers("/api/hello2").hasAnyAuthority("HEHE")
                .antMatchers("/api/me").hasAnyRole("USER", "ADMIN")
                .antMatchers("/api/register").hasAuthority("ROLE_REGISTER");
    }

    private static class OAuthRequestedMatcher implements RequestMatcher {
        public boolean matches(HttpServletRequest request) {
            String auth = request.getHeader("Authorization");
            // Determine if the client request contained an OAuth Authorization
            boolean haveOauth2Token = (auth != null) && auth.startsWith("Bearer");
            boolean haveAccessToken = request.getParameter("access_token")!=null;
            return haveOauth2Token || haveAccessToken;
        }
    }
}
