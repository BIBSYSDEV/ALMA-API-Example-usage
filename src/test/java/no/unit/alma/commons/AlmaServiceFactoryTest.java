package no.unit.alma.commons;

import com.typesafe.config.Config;
import no.unit.alma.acquisitions.AlmaVendorsService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.ws.rs.client.Client;


@ExtendWith(MockitoExtension.class)
class AlmaServiceFactoryTest {


    @Mock
    Client client;

    @Mock
    ApiAuthorizationService apiAuthorizationService;

    @Mock
    Config config;


    @Test
    void testGetAlmaVendors() {
        AlmaServiceFactory almaServiceFactory = new AlmaServiceFactory(client, config, apiAuthorizationService);
        AlmaVendorsService almaVendorsService = almaServiceFactory.getAlmaVendors("b", AlmaStage.SANDBOX1);
    }
}