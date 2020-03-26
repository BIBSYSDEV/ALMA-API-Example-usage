package no.unit.alma.commons;

import no.unit.alma.generated.error.WebServiceResult;
import java.io.IOException;

public class HttpStatusException extends IOException {

    private final transient int status;
    private final transient String statusText;
    private final transient String method;
    private final transient String url;
    private final transient String responseBody;
    private final transient WebServiceResult webServiceResult;

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
