package org.excelencryptor.model;

import org.excelencryptor.service.KeysEncryptor;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.SecretKey;

public class ConfidentialKeys {
    private final PublicKey publicKey;
    private final PrivateKey privateKey;
    private byte[] secretKey;

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
        try {
            this.secretKey = KeysEncryptor.encryptWithRSA(key, publicKey);
        } catch (Exception e) {
            Logger.getLogger(ConfidentialKeys.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public byte[] getSecretKey() {
        return this.secretKey;
    }
}
