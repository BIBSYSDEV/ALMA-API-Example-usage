package no.unit.alma.commons;


import no.bibsys.vault.VaultClient;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ApiAuthorizationServiceTest {

    public static final String ENVIRONMENT = "environment";
    public static final String STAGE = "stage";
    public static final String BIBCODE = "bibcode";
    public static final String SECRET = "secret";
    public static final String EMPTY_STRING = "";

    @Mock
    VaultClient mockVaultClient;
    @Mock
    VaultApiAuthorization mockVaultApiAuthorization;

    @Test
    public void testBuilder() {
        ApiAuthorizationService.ApiAuthorizationServiceBuilder apiAuthorizationServiceBuilder =
                ApiAuthorizationService.builder();
        assertNotNull(apiAuthorizationServiceBuilder);
        apiAuthorizationServiceBuilder.environment(ENVIRONMENT);
        apiAuthorizationServiceBuilder.vaultClient(mockVaultClient);
        ApiAuthorizationService apiAuthorizationService = apiAuthorizationServiceBuilder.build();

        assertNotNull(apiAuthorizationService);
    }

    @Test
    public void testBuilder_emptyEnvironment() {
        ApiAuthorizationService.ApiAuthorizationServiceBuilder apiAuthorizationServiceBuilder =
                ApiAuthorizationService.builder();
        assertNotNull(apiAuthorizationServiceBuilder);
        apiAuthorizationServiceBuilder.environment(EMPTY_STRING);
        apiAuthorizationServiceBuilder.vaultClient(mockVaultClient);
        assertThrows(IllegalArgumentException.class, () -> apiAuthorizationServiceBuilder.build());
    }

}
