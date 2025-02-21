package org.excelencryptor;

import java.security.PrivateKey;
import java.security.PublicKey;
import javax.crypto.SecretKey;

public class ConfidentialKeys {
    private final PublicKey publicKey;
    private final PrivateKey privateKey;
    private SecretKey secretKey;

    public ConfidentialKeys(PublicKey publicKey, PrivateKey privateKey) {
        this.privateKey = privateKey;
        this.publicKey = publicKey;
    }

    public PrivateKey getPrivateKey() {
        return privateKey;
    }

    public PublicKey getPublicKey() {
        return publicKey;
    }

    public void setSecretKey(SecretKey key) {
        this.secretKey = key;
    }

    public SecretKey getSecretKey() {
        return secretKey;
    }
}
