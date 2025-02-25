package org.excelencryptor.service;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import java.security.PublicKey;

public class KeysEncryptor {

    public static byte[] encryptWithRSA(SecretKey aesKey, PublicKey publicKey) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        return cipher.doFinal(aesKey.getEncoded());
    }

    public static byte[] decryptWithRSA(byte[] encryptedKey, SecretKey aesKey) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.DECRYPT_MODE, aesKey);
        return cipher.doFinal(encryptedKey);
    }
}
