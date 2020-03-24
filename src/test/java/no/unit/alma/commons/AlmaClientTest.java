package no.unit.alma.commons;

import com.typesafe.config.Config;
import org.glassfish.jersey.client.ClientProperties;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AlmaClientTest {

    @Mock
    Client client;

    @Mock
    VaultApiAuthorization vaultApiAuthorization;


    @Mock
    ApiAuthorizationService apiAuthorizationService;

    @Mock
    Config config;

    @Mock
    WebTarget webTarget;

    @Test
    void testInitAlmaClient() {
        final String ORGANIZATION = "someOrg";
        final String STAGE = "alma-sandbox2";
        final String HOST = "someHost";
        final String SERVICE_CONTEXT = "path1/path2";
        final String APP = "app";
        final String CONTEXT = "bibsysBibKode";
        final String BIBCODE = "b";

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

        AlmaClient almaClient = new AlmaClient( client,config,  apiAuthorizationService, BIBCODE);

        assertEquals(CONTEXT, almaClient.getContext());
        assertEquals(webTarget, almaClient.getWebTarget());
        assertEquals(STAGE, almaClient.getAlmaStage());
        assertEquals(ORGANIZATION, almaClient.getContextValue());
    }

    @Test
    void testBuildAlmaUrl() {
        final String EXPECTED = "https://example.com/path1/path2";
        final String HOST = "example.com";
        final String SERVICE_CONTEXT = "path1/path2";

        String result = AlmaClient.buildAlmaUrl(HOST, SERVICE_CONTEXT);
        assertEquals(EXPECTED, result);
    }


}