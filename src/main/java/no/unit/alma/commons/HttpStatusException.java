package no.unit.alma.commons;

import no.unit.alma.generated.error.Error;
import no.unit.alma.generated.error.WebServiceResult;

import java.io.IOException;

public class HttpStatusException extends IOException {

    public static final String EMPTY_STRING = "";
    private transient int status;
    private transient String statusText;
    private transient String method;
    private transient String url;
    private transient String responseBody;
    private transient WebServiceResult webServiceResult;
    private transient Error error;

    public HttpStatusException(int status, String statusText, String method, String url, String responseBody) {
        this(status, statusText, method, url, responseBody, null);
    }

    /**
     * The HttpStatusException is called as a filter on communication with AlmaClient in order to catch
     * WebServiceResults, containing the error-details from Alma. The HttpServiceException will be caught be a
     * ResponseProcessingException. Catching that, will enable you to access the almaErrorCode etc. pp..
     *
     * @param status Status number
     * @param statusText Status message
     * @param method HttpMethod
     * @param url request url
     * @param responseBody responseBody
     * @param webServiceResult webServiceResult object from AlmaŒŒ
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
                && this.getWebServiceResult().getErrorList().getError() != null
                && !this.getWebServiceResult().getErrorList().getError().isEmpty()) {

            this.error = this.getWebServiceResult().getErrorList().getError().get(0);
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
