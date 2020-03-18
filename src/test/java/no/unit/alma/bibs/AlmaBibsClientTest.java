package no.unit.alma.bibs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.io.IOException;

import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.Invocation.Builder;
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

    @Mock
    private Builder builder;

    @Mock
    private Invocation invocation;

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
        when(webTarget.path(any())).thenReturn(webTarget);
        when(webTarget.request()).thenReturn(builder);
        when(builder.accept(anyString())).thenReturn(builder);
        when(builder.buildGet()).thenReturn(invocation);
        Bib tempBib = new Bib();
        tempBib.setTitle("test");
        when(invocation.invoke((Class<Object>) any())).thenReturn(tempBib);
        AlmaBibsServiceImplementation almaBibsServiceImplementation =
                new AlmaBibsServiceImplementation(mockAlmaApiClient);

        Bib bib = almaBibsServiceImplementation.getBib(TEST_MMS_ID, "");
        assertEquals("test", bib.getTitle());
    }

}