package org.excelencryptor;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;

public class KeysGenerator {
    private ConfidentialKeys confidentialKeys;

    public ConfidentialKeys generateRSA() throws Exception {
        KeyPairGenerator rsaKeyGen = KeyPairGenerator.getInstance("RSA");
        rsaKeyGen.initialize(2048);
        KeyPair rsaKeyPair = rsaKeyGen.generateKeyPair();
        PublicKey publicKey = rsaKeyPair.getPublic();
        PrivateKey privateKey = rsaKeyPair.getPrivate();
        ConfidentialKeys confidentialKeys = new ConfidentialKeys(publicKey, privateKey);
        this.confidentialKeys = confidentialKeys;
        return confidentialKeys;
    }

    public void generateAES() throws Exception {
        KeyGenerator aesKeyGen = KeyGenerator.getInstance("AES");
        aesKeyGen.init(256);
        SecretKey aesKey = aesKeyGen.generateKey();
        confidentialKeys.setSecretKey(aesKey);
    }
}
