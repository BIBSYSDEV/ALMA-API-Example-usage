package no.unit.alma.commons;

import com.typesafe.config.Config;
import no.bibsys.vault.VaultClient;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AlmaClientTest {

    @Mock
    Client client;

    @Mock
    VaultApiAuthorization vaultApiAuthorization;

    @Mock
    VaultClient mockVaultClient;

    @Mock
    ApiAuthorizationService apiAuthorizationService;

    @Mock
    Config config;

    @Mock
    WebTarget webTarget;

    public static final String BIBCODE = "b";
    public static final String CONTEXT = "bibsysBibKode";
    public static final String SERVICE_CONTEXT = "path1/path2";
    public static final String HOST = "example.com";
    public static final String EXPECTED = "https://example.com/path1/path2";
    public static final String STAGE = "alma-sandbox2";
    public static final String ORGANIZATION = "someOrg";

    @Test
    void testInitAlmaClient() {

        when(apiAuthorizationService.getApiAuthorization(anyString(),anyString())).thenReturn(vaultApiAuthorization);

        when(vaultApiAuthorization.getOrganization()).thenReturn(ORGANIZATION);
        when(vaultApiAuthorization.getAlmaHost()).thenReturn(HOST);

        when(config.getString(eq("almaServiceContext"))).thenReturn(SERVICE_CONTEXT);
        when(config.getString(eq("stage"))).thenReturn(STAGE);
        when(client.property(any(), any())).thenReturn(client);
        when(client.register(any())).thenReturn(client);
        when(client.register(any(AlmaAuthorizationRequestFilter.class), anyInt())).thenReturn(client);
        when(client.register(any(), anyInt())).thenReturn(client);
        when(client.target(anyString())).thenReturn(webTarget);

        AlmaClient almaClient = new AlmaClient(client,config, apiAuthorizationService, BIBCODE);

        assertEquals(CONTEXT, almaClient.getContext());
        assertEquals(webTarget, almaClient.getWebTarget());
        assertEquals(STAGE, almaClient.getAlmaStage());
        assertEquals(ORGANIZATION, almaClient.getContextValue());
    }

    @Test
    void testBuildAlmaUrl() {
        String result = AlmaClient.buildAlmaUrl(HOST, SERVICE_CONTEXT);
        assertEquals(EXPECTED, result);
    }


    @Test
    public void testWithVaultClientConstructor() {
        assertThrows(IllegalArgumentException.class, () -> new AlmaClient(client, config, mockVaultClient, BIBCODE));
    }

    @Test
    public void testWithDefaultConstructor() {
        assertThrows(IllegalArgumentException.class, () -> new AlmaClient(client, config, BIBCODE));
    }

}