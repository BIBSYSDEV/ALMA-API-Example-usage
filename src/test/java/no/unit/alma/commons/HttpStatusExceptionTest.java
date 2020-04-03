package no.unit.alma.commons;

import no.unit.alma.generated.error.Error;
import no.unit.alma.generated.error.ErrorList;
import no.unit.alma.generated.error.WebServiceResult;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;


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

        HttpStatusException httpStatusException = new HttpStatusException(status, statusText,method, url,
                responseBody,webServiceResult);

        assertEquals(status, httpStatusException.getStatus());
        assertEquals(statusText, httpStatusException.getStatusText());
        assertEquals(method, httpStatusException.getMethod());
        assertEquals(url, httpStatusException.getUrl());
        assertEquals(responseBody, httpStatusException.getResponseBody());
        assertEquals(webServiceResult.getResult(), httpStatusException.getWebServiceResult().getResult());
        assertTrue(httpStatusException.isWebserviceResult());
    }

    @Test
    void testHttpStatusExceptionWhenWebServiceResultIsNull() {
        int status = 23;
        String statusText = "sample status text";
        String method = "sample method";
        String url = "https://www.example.com";
        String responseBody = "sample body";
        WebServiceResult webServiceResult  = null;
        HttpStatusException httpStatusException = new HttpStatusException(status, statusText, method, url,
                responseBody, webServiceResult);
        assertFalse(httpStatusException.isWebserviceResult());

    }


    @Test
    public void testHttpStatusExceptionWithErrors() {
        int status = 23;
        String statusText = "sample status text";
        String method = "sample method";
        String url = "https://www.example.com";
        String responseBody = "sample body";
        String resultAsString = "sample result string";
        WebServiceResult webServiceResult  = new WebServiceResult();
        webServiceResult.setResult(resultAsString);
        webServiceResult.setErrorsExist(true);
        Error error = new Error();
        String errorCode = "errorCode";
        error.setErrorCode(errorCode);
        String errorMessage = "errorMessage";
        error.setErrorMessage(errorMessage);
        String trackingID = "trackingID";
        error.setTrackingId(trackingID);
        ErrorList errorList = new ErrorList();
        errorList.getErrors().add(error);
        webServiceResult.setErrorList(errorList);

        HttpStatusException httpStatusException = new HttpStatusException(status, statusText,method, url,
                responseBody,webServiceResult);

        assertEquals(status, httpStatusException.getStatus());
        assertEquals(statusText, httpStatusException.getStatusText());
        assertEquals(method, httpStatusException.getMethod());
        assertEquals(url, httpStatusException.getUrl());
        assertEquals(responseBody, httpStatusException.getResponseBody());
        assertEquals(webServiceResult.getResult(), httpStatusException.getWebServiceResult().getResult());
        assertTrue(httpStatusException.isWebserviceResult());
        assertTrue(httpStatusException.hasError());
        assertEquals(errorCode, httpStatusException.getAlmaErrorCode());
        assertEquals(errorMessage, httpStatusException.getAlmaErrorMessage());
        assertEquals(trackingID, httpStatusException.getAlmaErrorTrackingId());
    }


}