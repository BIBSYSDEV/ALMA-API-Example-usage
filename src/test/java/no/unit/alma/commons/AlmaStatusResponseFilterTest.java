package no.unit.alma.commons;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientResponseContext;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AlmaStatusResponseFilterTest {

    @Mock
    ClientRequestContext clientRequestContext;

    @Mock
    ClientResponseContext clientResponseContext;

    @Mock
    Response.StatusType statusInfo;

    @Test
    void testFilterWhenUnmarshallingFailes() throws IOException, URISyntaxException {
        String initialString = "not xml";
        URI url = new URI("https://www.example.com");
        int status = 121;
        String method = "method";
        String statusText = "status text";

        InputStream inputStream = new ByteArrayInputStream(initialString.getBytes());
        Response.Status.Family value = Response.Status.Family.SERVER_ERROR;

        when(statusInfo.getFamily()).thenReturn(value);
        when(statusInfo.getReasonPhrase()).thenReturn(statusText);


        when(clientResponseContext.getStatusInfo()).thenReturn(statusInfo);

        when(clientResponseContext.getMediaType()).thenReturn(MediaType.APPLICATION_XML_TYPE);
        when(clientResponseContext.hasEntity()).thenReturn(true);
        when(clientResponseContext.getEntityStream()).thenReturn(inputStream);
        when(clientResponseContext.getStatusInfo()).thenReturn(statusInfo);
        when(clientResponseContext.getStatus()).thenReturn(status);

        when(clientRequestContext.getMethod()).thenReturn(method);
        when(clientRequestContext.getUri()).thenReturn(url);

        AlmaStatusResponseFilter almaStatusResponseFilter = new AlmaStatusResponseFilter();
        try {
            almaStatusResponseFilter.filter(clientRequestContext, clientResponseContext);
        } catch (HttpStatusException e) {
            assertEquals(method, e.getMethod());
            assertEquals(statusText, e.getStatusText());
            assertEquals(status, e.getStatus());
        }

    }

//    @Test
//    void testFilterWhenResponseIsNotXML() throws IOException, URISyntaxException {
//        Response.Status.Family value = Response.Status.Family.SERVER_ERROR;
//        int status = 1;
//        URI url = new URI("https://www.example.com");
//
//        when(clientResponseContext.getStatusInfo()).thenReturn(statusInfo);
//        when(clientResponseContext.getStatus()).thenReturn(status);
//        when(statusInfo.getFamily()).thenReturn(value);
//        when(clientResponseContext.getMediaType()).thenReturn(MediaType.APPLICATION_JSON_TYPE);
//        when(clientRequestContext.getUri()).thenReturn(url);
//        when(clientRequestContext.getMethod()).thenReturn("method");
//
//        AlmaStatusResponseFilter almaStatusResponseFilter = new AlmaStatusResponseFilter();
//        almaStatusResponseFilter.filter(clientRequestContext, clientResponseContext);
//    }




}