package org.excelencryptor.service;

import org.excelencryptor.model.ConfidentialKeys;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.KeyPair;
import java.security.KeyPairGenerator;

public class KeysGenerator {

    private ConfidentialKeys confidentialKeys;

    public ConfidentialKeys generateRSA() throws Exception {
        if (confidentialKeys == null) {
            KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
            keyPairGen.initialize(2048);
            KeyPair keyPair = keyPairGen.generateKeyPair();
            confidentialKeys = new ConfidentialKeys(keyPair.getPublic(), keyPair.getPrivate());
        }
        return confidentialKeys;
    }

    public void generateAES() throws Exception {
        if (confidentialKeys == null) {
            throw new NullPointerException("ConfidentialKeys must be initialized with RSA keys first.");
        }
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(256);
        SecretKey secretKey = keyGen.generateKey();
        confidentialKeys.setSecretKey(secretKey);
    }

    public ConfidentialKeys getConfidentialKeys() {
        return confidentialKeys;
    }
}