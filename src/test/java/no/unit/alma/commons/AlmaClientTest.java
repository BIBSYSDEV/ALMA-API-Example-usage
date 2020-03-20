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
    Config config;

    @Mock
    WebTarget webTarget;

    @Test
    void testInitAlmaClient() {
        //final String ORGANIZATON = "someOrg";
        final AlmaStage STAGE = AlmaStage.SANDBOX2;
        final String HOST = "someHost";
        final String STAGE_STRING = AlmaStage.SANDBOX2.getVaultAlmaStageName();
        final String SERVICE_CONTEXT = "path1/path2";
        final String APP = "app";
        final String CONTEXT = "bibsysBibKode";


        //when(vaultApiAuthorization.getOrganization()).thenReturn(ORGANIZATON); //funker ikke pga @overide. mangler løsning
        when(vaultApiAuthorization.getAlmaHost()).thenReturn(HOST);
        when(vaultApiAuthorization.getAlmaStage()).thenReturn(STAGE);

        when(config.getString(eq("almaServiceContext"))).thenReturn(SERVICE_CONTEXT);
        when(config.getString(eq(APP))).thenReturn(APP);
        when(config.getString(eq("stage"))).thenReturn(STAGE_STRING);
        when(client.property(any(), any())).thenReturn(client);
        when(client.register(any())).thenReturn(client);
        when(client.register(any(AlmaAuthorizationRequestFilter.class), anyInt())).thenReturn(client);
        when(client.register(any(RequestResponseLogger.class), anyInt())).thenReturn(client);
        when(client.register(any(), anyInt())).thenReturn(client);
        when(client.target(anyString())).thenReturn(webTarget);

        AlmaClient almaClient = new AlmaClient(config, client, vaultApiAuthorization);

        assertEquals(CONTEXT, almaClient.getContext());
        assertEquals(webTarget, almaClient.getWebTarget());
        assertEquals(STAGE, almaClient.getAlmaStage());
        assertEquals(null, almaClient.getContextValue());
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