package no.unit.alma.commons;

import no.unit.alma.generated.error.WebServiceResult;
import java.io.IOException;

public class HttpStatusException extends IOException {

    private transient int status;
    private transient String statusText;
    private transient String method;
    private transient String url;
    private transient String responseBody;
    private transient WebServiceResult webServiceResult;

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
}
