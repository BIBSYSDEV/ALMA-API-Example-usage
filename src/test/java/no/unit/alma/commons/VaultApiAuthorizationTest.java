package no.unit.alma.commons;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import no.bibsys.vault.VaultClient;

@ExtendWith(MockitoExtension.class)
public class VaultApiAuthorizationTest {

    @Mock
    VaultClient vaultClient;

    public static final int MAGIC_HASHCODE = 1441007809;
    public static final String VAULTAPIAUTHORIZATION_TOSTRING =
            "ApiAuthorization{environment='%s', "
                    + "organization='%s'}";
    public static final String SECRET = "secret";
    public static final String ENVIRONMENT = "environment";
    public static final String ANOTHER_ENVIRONMENT = "another environment";
    public static final String ORGANIZATION = "organization";

    @Test
    public void testInstantiation() {
        when(vaultClient.read(anyString())).thenReturn(SECRET);
        VaultApiAuthorization vaultApiAuthorization =
                new VaultApiAuthorization(vaultClient,
                        ENVIRONMENT, ORGANIZATION);
        assertEquals(ORGANIZATION, vaultApiAuthorization.getOrganization());
        assertEquals(ENVIRONMENT, vaultApiAuthorization.getEnvironment());
        assertEquals(SECRET, vaultApiAuthorization.getAlmaHost());
        assertEquals("apikey " + SECRET, vaultApiAuthorization.asApiKey());
    }

    @Test
    public void test_throwsExceptions() {
        when(vaultClient.read(anyString())).thenReturn(null);
        assertThrows(RuntimeException.class, () -> new VaultApiAuthorization(vaultClient,
                ENVIRONMENT, ORGANIZATION));
        assertThrows(RuntimeException.class, () -> new VaultApiAuthorization(vaultClient,
                null, ORGANIZATION));
        assertThrows(RuntimeException.class, () -> new VaultApiAuthorization(vaultClient,
                ENVIRONMENT, null));
    }

    @Test
    public void testEquals() {
        when(vaultClient.read(anyString())).thenReturn(SECRET);
        VaultApiAuthorization vaultApiAuthorization1 =
                new VaultApiAuthorization(vaultClient,
                        ENVIRONMENT, ORGANIZATION);
        VaultApiAuthorization vaultApiAuthorization2 =
                new VaultApiAuthorization(vaultClient,
                        ENVIRONMENT, ORGANIZATION);
        assertTrue(vaultApiAuthorization1.equals(vaultApiAuthorization2));
        assertTrue(vaultApiAuthorization1.equals(vaultApiAuthorization1));
        assertFalse(vaultApiAuthorization1.equals(null));
        assertFalse(vaultApiAuthorization1.equals(""));
        VaultApiAuthorization vaultApiAuthorization3 =
                new VaultApiAuthorization(vaultClient,
                        ANOTHER_ENVIRONMENT, ORGANIZATION);
        assertFalse(vaultApiAuthorization1.equals(vaultApiAuthorization3));
        assertEquals(String.format(VAULTAPIAUTHORIZATION_TOSTRING, ENVIRONMENT, ORGANIZATION),
                vaultApiAuthorization1.toString());
        assertEquals(MAGIC_HASHCODE, vaultApiAuthorization1.hashCode());
    }

}
