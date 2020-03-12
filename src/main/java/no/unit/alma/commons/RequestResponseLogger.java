package no.unit.alma.commons;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientRequestFilter;
import javax.ws.rs.client.ClientResponseContext;
import javax.ws.rs.client.ClientResponseFilter;
import java.net.URI;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class RequestResponseLogger implements ClientRequestFilter, ClientResponseFilter {

    private final static Logger logger = LoggerFactory.getLogger(RequestResponseLogger.class);
    private final static String fish_bones = ">++('>";
    private final String stage;
    private final String app;
    private final Set<String> mdcKeys = new HashSet<>();


    public RequestResponseLogger(String app, String stage) {
        this.app = app;
        this.stage = stage;
    }

    @Override
    public void filter(ClientRequestContext clientRequestContext) {
        clientRequestContext.setProperty("startTime", System.currentTimeMillis());
    }

    @Override
    public void filter(ClientRequestContext requestContext, ClientResponseContext responseContext) {
        final long endTime = System.currentTimeMillis();
        final long startTime = (long) requestContext.getProperty("startTime");
        final long duration = endTime - startTime;
        mdc("req_duration", duration);
        mdc("uuid", UUID.randomUUID().toString().substring(0, 8));
        mdc("app", app);
        mdc("stage", stage);
        mdc_request(requestContext.getMethod(), requestContext.getUri());
        mdc_expected_status(requestContext.getMethod());

        final String authorization = requestContext.getHeaderString("Authorization");
        final String requestHeaders = authorization == null ? requestContext.getStringHeaders().toString() : requestContext.getStringHeaders().toString().replace(authorization, (authorization.toLowerCase().contains("apikey") ? "apikey " + fish_bones : fish_bones));

        mdc("req_headers", requestHeaders);

        if (requestContext.hasEntity()) {
            mdc("req_entity", requestContext.getEntity());
            mdc("req_entityType", requestContext.getEntityType().getTypeName());
            mdc("req_entityClass", requestContext.getEntityClass());
        }

        mdc("res_status", responseContext.getStatus());
        mdc("res_statusClass", responseContext.getStatusInfo().getFamily());
        mdc("res_statusText", responseContext.getStatusInfo().getReasonPhrase());
        mdc("res_headers", responseContext.getHeaders());

        final String logMessage = asLogMessage(requestContext.getUri(), requestContext, responseContext);
        switch (responseContext.getStatusInfo().getFamily()) {
            case CLIENT_ERROR:
                logger.warn(logMessage);
                break;
            case SERVER_ERROR:
                logger.error(logMessage);
                break;
            default:
                logger.info(logMessage);
        }
        //we want to be a good citizen and clean up after ourselves so we don't interfere witch log setups in client applications
        removeMdc();
    }

    String asLogMessage(URI uri, ClientRequestContext requestContext, ClientResponseContext responseContext) {
        final StringBuilder message = new StringBuilder()
            .append(requestContext.getMethod()).append(" ")
            .append(uri.toString()).append(" ")
            .append(responseContext.getStatus()).append(" ")
            .append(responseContext.getStatusInfo().getReasonPhrase());
        return message.toString();
    }

    private synchronized void removeMdc() {
        for (String mdcKey : mdcKeys) {
            MDC.remove(mdcKey);
        }
        mdcKeys.clear();
    }

    private void mdc_expected_status(String method) {
        switch (method) {
            case "DELETE":
                mdc("expectedStatus", 204);
                break;
            default:
                mdc("expectedStatus", 200);
                break;
        }
    }

    private void mdc_request(String method, URI uri) {
        mdc("req_method", method);
        mdc("req_uri", uri.toString());
        mdc("req_host", uri.getHost());
        mdc("req_port", uri.getPort());
        mdc("req_scheme", uri.getScheme());
        mdc("req_path", uri.getPath());
        mdc("req_query", uri.getQuery());
    }

    private void mdc(String key, Object value) {
        if (value != null && key != null) {
            MDC.put(key, value.toString());
            mdcKeys.add(key);
        }
    }
}
