package no.unit.alma.commons;

import no.unit.alma.generated.error.Error;
import no.unit.alma.generated.error.WebServiceResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class HttpStatusException extends IOException {

    private static final transient Logger log = LoggerFactory.getLogger(HttpStatusException.class);
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

    public HttpStatusException(int status, String statusText, String method, String url, String responseBody,
            WebServiceResult webServiceResult) {
        super(status + " " + statusText + " " + method + " " + url);
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
        if (this.isWebserviceResult() && this.webServiceResult.isErrorsExist()) {
            try {
                this.error = this.getWebServiceResult().getErrorList().getError().get(0);
            } catch (NullPointerException ex) {
                log.error(String.format("Malformed response from Alma: %s.", this.getResponseBody()));
            }
        }
    }

    public boolean hasError() {
        return this.error != null;
    }

    public String getAlmaErrorCode() {
        return this.error.getErrorCode();
    }

    public String getAlmaErrorMessage() {
        return this.error.getErrorMessage();
    }

    public String getAlmaErrorTrackingId() {
        return this.error.getTrackingId();
    }
}
