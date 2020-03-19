package no.unit.alma.commons;

import com.typesafe.config.Config;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.ws.rs.client.Client;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AlmaClientTest {


    @Mock
    Client client;

    @Mock
    VaultApiAuthorization apiAuthorization;

    @Mock
    Config config;


    @Test
    void testInitAlmaClient() {
        when(client.property(any(), any())).thenReturn(client);
        when(client.register(any())).thenReturn(client);
        when(client.register(anyObject(), anyInt())).thenReturn(client);

        AlmaClient almaClient = new AlmaClient(config, client, apiAuthorization);
        assertEquals("CONTEXT", almaClient.getContext());
        //almaClient.getWebTarget();
        //almaClient.getAlmaStage();
        //almaClient.getContextValue();

    }
}