package no.unit.alma.commons;

import no.unit.alma.generated.error.Error;
import no.unit.alma.generated.error.WebServiceResult;

import java.io.IOException;

public class HttpStatusException extends IOException {

    public static final String EMPTY_STRING = "";
    private final transient int status;
    private final transient String statusText;
    private final transient String method;
    private final transient String url;
    private final transient String responseBody;
    private final transient WebServiceResult webServiceResult;
    private transient Error error;

    /**
     * HttpStatusException wraps alma responses in an exception.
     *
     * @param status            Status as int
     * @param statusText        Status as String
     * @param method            method as String
     * @param url               url as String
     * @param responseBody      responseBody as String
     * @param webServiceResult  Result as WebServiceResult
     */
    public HttpStatusException(int status, String statusText, String method, String url, String responseBody,
                               WebServiceResult webServiceResult) {
        super(String.format("%s %s %s %s", status, statusText, method, url));
        this.status = status;
        this.statusText = statusText;
        this.method = method;
        this.url = url;
        this.responseBody = responseBody;
        this.webServiceResult = webServiceResult;
        this.setError();
    }

    public int getStatus() {
        return status;
    }

    public String getStatusText() {
        return statusText;
    }

    public String getMethod() {
        return method;
    }

    public String getUrl() {
        return url;
    }

    public String getResponseBody() {
        return responseBody;
    }

    public boolean isWebserviceResult() {
        return webServiceResult != null;
    }

    public WebServiceResult getWebServiceResult() {
        return webServiceResult;
    }

    private void setError() {
        if (webServiceResult != null && this.webServiceResult.isErrorsExist()
                && this.getWebServiceResult().getErrorList() != null
                && this.getWebServiceResult().getErrorList().getErrors() != null
                && !this.getWebServiceResult().getErrorList().getErrors().isEmpty()) {

            this.error = this.getWebServiceResult().getErrorList().getErrors().get(0);
        }
    }

    public boolean hasError() {
        return this.error != null;
    }

    public String getAlmaErrorCode() {
        return this.error == null ? EMPTY_STRING : this.error.getErrorCode();
    }

    public String getAlmaErrorMessage() {
        return this.error == null ? EMPTY_STRING : this.error.getErrorMessage();
    }

    public String getAlmaErrorTrackingId() {
        return this.error == null ? EMPTY_STRING : this.error.getTrackingId();
    }
}
