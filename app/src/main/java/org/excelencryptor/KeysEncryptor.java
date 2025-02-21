package org.excelencryptor;

import javax.crypto.Cipher;
import java.security.PublicKey;

public class KeysEncryptor {
    private ConfidentialKeys confidentialKeys;
    public KeysEncryptor(ConfidentialKeys confidentialKeys) {
        this.confidentialKeys = confidentialKeys;
    }

}
