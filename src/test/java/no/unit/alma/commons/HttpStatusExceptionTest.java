package no.unit.alma.commons;

import no.unit.alma.generated.error.WebServiceResult;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


class HttpStatusExceptionTest {


    @Test
    void testHttpStatusException() {
        int status = 23;
        String statusText = "sample status text";
        String method = "sample method";
        String url = "https://www.example.com";
        String responseBody = "sample body";
        String resultAsString = "sample result string";
        WebServiceResult webServiceResult  = new WebServiceResult();
        webServiceResult.setResult(resultAsString);

        HttpStatusException httpStatusException = new HttpStatusException(status, statusText, method, url, responseBody, webServiceResult);

        assertEquals(status, httpStatusException.getStatus());
        assertEquals(statusText, httpStatusException.getStatusText());
        assertEquals(method, httpStatusException.getMethod());
        assertEquals(url, httpStatusException.getUrl());
        assertEquals(responseBody, httpStatusException.getResponseBody());
        assertEquals(webServiceResult.getResult(), httpStatusException.getWebServiceResult().getResult());
        assertTrue(httpStatusException.isWebserviceResult());
    }

}