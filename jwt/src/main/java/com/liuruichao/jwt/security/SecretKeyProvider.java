package com.liuruichao.jwt.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.KeyPair;
import java.security.PublicKey;

/**
 * SecretKeyProvider
 *
 * @author liuruichao
 * Created on 2018/6/7 14:16
 */
@Component
public class SecretKeyProvider {
    @Value(value = "${jwt.key.store}")
    private String jwtKeyStore;

    @Value(value = "${jwt.key.pass}")
    private String jwtKeyPass;

    @Value(value = "${jwt.key.alias}")
    private String jwtKeyAlias;

    public String getSigningKey() {
        PublicKey publicKey = getKeyPair().getPublic();
        return new String(publicKey.getEncoded(), StandardCharsets.UTF_8);
    }

    public KeyPair getKeyPair() {
        KeyStoreKeyFactory keyStoreKeyFactory = new KeyStoreKeyFactory(
                new ClassPathResource(jwtKeyStore), jwtKeyPass.toCharArray());
        return keyStoreKeyFactory.getKeyPair(jwtKeyAlias);
    }
}
