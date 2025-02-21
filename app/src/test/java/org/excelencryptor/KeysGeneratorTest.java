package org.excelencryptor;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.crypto.KeyGenerator;
import java.security.KeyPairGenerator;

import static org.junit.jupiter.api.Assertions.*;

class KeysGeneratorTest {

    private KeysGenerator keysGenerator;

    @BeforeEach
    void setUp() {
        keysGenerator = new KeysGenerator();
    }

    @Test
    void testGenerateRSA() throws Exception {
        var confidentialKeys = keysGenerator.generateRSA();
        assertNotNull(confidentialKeys);
        assertNotNull(confidentialKeys.getPublicKey());
        assertNotNull(confidentialKeys.getPrivateKey());
    }

    @Test
    void testGenerateAES() throws Exception {
        keysGenerator.generateRSA(); // Ensure confidentialKeys is initialized
        keysGenerator.generateAES();
        var confidentialKeys = keysGenerator.generateRSA();
        assertNotNull(confidentialKeys);
        assertNotNull(confidentialKeys.getPrivateKey());
        assertNotNull(confidentialKeys.getPublicKey());
        assertNotNull(confidentialKeys.getSecretKey());
    }

    @Test
    void testGenerateRSAWithoutInitialization() {
        assertThrows(NullPointerException.class, () -> keysGenerator.generateAES());
    }

    @Test
    void testGenerateAESWithoutRSA() {
        assertThrows(NullPointerException.class, () -> keysGenerator.generateAES());
    }

    @Test
    void testGenerateRSAWithInvalidKeySize() {
        assertThrows(Exception.class, () -> {
            var rsaKeyGen = KeyPairGenerator.getInstance("RSA");
            rsaKeyGen.initialize(1024); // Invalid key size for edge case
            rsaKeyGen.generateKeyPair();
        });
    }

    @Test
    void testGenerateAESWithInvalidKeySize() {
        assertThrows(Exception.class, () -> {
            var aesKeyGen = KeyGenerator.getInstance("AES");
            aesKeyGen.init(128); // Invalid key size for edge case
            aesKeyGen.generateKey();
        });
    }
}