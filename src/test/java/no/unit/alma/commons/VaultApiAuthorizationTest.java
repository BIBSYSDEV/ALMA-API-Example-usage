package no.unit.alma.commons;

import no.bibsys.vault.VaultClient;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class VaultApiAuthorizationTest {

    @Mock
    VaultClient vaultClient;

    public static final int MAGIC_HASHCODE = -1746981218;
    public static final String VAULTAPIAUTHORIZATION_TOSTRING = "ApiAuthorization{environment='%s', almaStage=%s, "
            + "organization='%s'}";
    public static final String SECRET = "secret";
    public static final String ALMA_STAGE = "almaStage";
    public static final String ENVIRONMENT = "environment";
    public static final String ANOTHER_ENVIRONMENT = "another environment";
    public static final String ORGANIZATION = "organization";

    @Test
    public void testInstantiation() {
        when(vaultClient.read(anyString())).thenReturn(SECRET);
        VaultApiAuthorization vaultApiAuthorization = new VaultApiAuthorization(vaultClient,
                ENVIRONMENT, ALMA_STAGE, ORGANIZATION);
        assertEquals(ALMA_STAGE, vaultApiAuthorization.getAlmaStage());
        assertEquals(ORGANIZATION, vaultApiAuthorization.getOrganization());
        assertEquals(ENVIRONMENT, vaultApiAuthorization.getEnvironment());
        assertEquals(SECRET, vaultApiAuthorization.getAlmaHost());
        assertEquals("apikey " + SECRET, vaultApiAuthorization.asApiKey());
    }

    @Test
    public void test_throwsExceptions() {
        when(vaultClient.read(anyString())).thenReturn(null);
        assertThrows(RuntimeException.class, () -> new VaultApiAuthorization(vaultClient,
                ENVIRONMENT, ALMA_STAGE, ORGANIZATION));
        assertThrows(RuntimeException.class, () -> new VaultApiAuthorization(vaultClient,
                null, ALMA_STAGE, ORGANIZATION));
        assertThrows(RuntimeException.class, () -> new VaultApiAuthorization(vaultClient,
                ENVIRONMENT, ALMA_STAGE, null));
    }

    @Test
    public void testEquals() {
        when(vaultClient.read(anyString())).thenReturn(SECRET);
        VaultApiAuthorization vaultApiAuthorization1 = new VaultApiAuthorization(vaultClient,
                ENVIRONMENT, ALMA_STAGE, ORGANIZATION);
        VaultApiAuthorization vaultApiAuthorization2 = new VaultApiAuthorization(vaultClient,
                ENVIRONMENT, ALMA_STAGE, ORGANIZATION);
        assertTrue(vaultApiAuthorization1.equals(vaultApiAuthorization2));
        assertTrue(vaultApiAuthorization1.equals(vaultApiAuthorization1));
        assertFalse(vaultApiAuthorization1.equals(null));
        assertFalse(vaultApiAuthorization1.equals(""));
        VaultApiAuthorization vaultApiAuthorization3 = new VaultApiAuthorization(vaultClient,
                ANOTHER_ENVIRONMENT, ALMA_STAGE, ORGANIZATION);
        assertFalse(vaultApiAuthorization1.equals(vaultApiAuthorization3));
        assertEquals(String.format(VAULTAPIAUTHORIZATION_TOSTRING, ENVIRONMENT, ALMA_STAGE, ORGANIZATION),
                vaultApiAuthorization1.toString());
        assertEquals(MAGIC_HASHCODE, vaultApiAuthorization1.hashCode());
    }


}
