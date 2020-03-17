package no.unit.alma.bibs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.io.IOException;

import javax.ws.rs.client.WebTarget;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import no.bibsys.alma.rest.bibs.Bib;
import no.unit.alma.commons.AlmaClient;
import no.unit.alma.commons.AlmaStage;

@ExtendWith(MockitoExtension.class)
class AlmaBibsClientTest {

    private static final String TEST_MMS_ID = "123456";

    @Mock
    private AlmaClient mockAlmaApiClient;

    @Mock
    private WebTarget webTarget;

    @Test
    void testGetBib() throws IOException, InterruptedException {
        // setup
//        Client client = JerseyClientBuilder.newClient();
//        WebTarget webTarget = client.target("http://www.example.com/");

        // mock almaClient-methods
        when(this.mockAlmaApiClient.getWebTarget())
                .thenReturn(webTarget);
        when(mockAlmaApiClient.getAlmaStage()).thenReturn(AlmaStage.SANDBOX2);
        when(mockAlmaApiClient.getContext()).thenReturn("");
        when(mockAlmaApiClient.getContextValue()).thenReturn("");
        when(webTarget.path(any())).thenReturn(webTarget);
        AlmaBibsService almaVendorsServiceImplementation =
                new AlmaBibsServiceImplementation(mockAlmaApiClient);

        Bib bib = almaVendorsServiceImplementation.getBib(TEST_MMS_ID, "");
        assertEquals("test", bib.getTitle());
    }

}