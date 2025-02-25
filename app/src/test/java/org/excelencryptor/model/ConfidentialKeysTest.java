package org.excelencryptor.model;

    import org.junit.jupiter.api.BeforeEach;
    import org.junit.jupiter.api.Test;

    import javax.crypto.SecretKey;
    import java.security.KeyPair;
    import java.security.KeyPairGenerator;
    import java.security.PrivateKey;
    import java.security.PublicKey;

    import static org.junit.jupiter.api.Assertions.*;

    class ConfidentialKeysTest {

        private PublicKey publicKey;
        private PrivateKey privateKey;
        private ConfidentialKeys confidentialKeys;

        @BeforeEach
        void setUp() throws Exception {
            KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
            keyPairGen.initialize(2048);
            KeyPair keyPair = keyPairGen.generateKeyPair();
            publicKey = keyPair.getPublic();
            privateKey = keyPair.getPrivate();
            confidentialKeys = new ConfidentialKeys(publicKey, privateKey);
        }

        @Test
        void testConstructorAndGetters() {
            assertEquals(publicKey, confidentialKeys.getPublicKey());
            assertEquals(privateKey, confidentialKeys.getPrivateKey());
        }

        @Test
        void testSetAndGetSecretKey() throws Exception {
            SecretKey secretKey = javax.crypto.KeyGenerator.getInstance("AES").generateKey();
            confidentialKeys.setSecretKey(secretKey);
            assertNotNull(confidentialKeys.getSecretKey());
        }
    }