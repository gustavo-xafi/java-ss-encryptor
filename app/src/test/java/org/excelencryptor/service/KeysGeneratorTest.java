package org.excelencryptor.service;

        import org.excelencryptor.model.ConfidentialKeys;
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
                ConfidentialKeys confidentialKeys = keysGenerator.generateRSA();
                assertNotNull(confidentialKeys);
                assertNotNull(confidentialKeys.getPublicKey());
                assertNotNull(confidentialKeys.getPrivateKey());
            }

            @Test
            void testGenerateAES() throws Exception {
                ConfidentialKeys confidentialKeys = keysGenerator.generateRSA();
                keysGenerator.generateAES();
                assertNotNull(confidentialKeys);
                assertNotNull(confidentialKeys.getSecretKey());
            }

            @Test
            void testGenerateAESWithoutRSA() {
                assertThrows(NullPointerException.class, () -> keysGenerator.generateAES());
            }
        }