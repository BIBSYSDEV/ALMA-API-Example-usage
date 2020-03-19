package no.unit.alma.commons;

import com.typesafe.config.Config;
import no.unit.alma.acquisitions.AlmaVendorsService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.ws.rs.client.Client;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class AlmaServiceFactoryTest {

//
//    @Mock
//    Client client;
//    @Mock
//    AlmaClient almaClient;
//    @Mock
//    ApiAuthorizationService apiAuthorizationService;
//    @Mock
//    Config config;
//
//    @InjectMocks
//    AlmaServiceFactory almaServiceFactory;

    @Test
    void testGetAlmaVendors() {
//        AlmaServiceFactory almaServiceFactory = new AlmaServiceFactory(client,config, apiAuthorizationService);

//        when(almaServiceFactory.newAlmaClientInstance("b", AlmaStage.SANDBOX2)).thenReturn(almaClient);
//
//        almaServiceFactory = new AlmaServiceFactory(client, config, apiAuthorizationService);
//
//        AlmaVendorsService almaVendorsService = almaServiceFactory.getAlmaVendors("b", AlmaStage.SANDBOX1);
    }
}