package no.unit.alma.analytics;

import no.unit.alma.commons.AlmaClient;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

public class AlmaAnalyticsService {

    static final String ANALYTICS_PATH = "analytics";
    static final String REPORT_PATH = "reports";
    static final int REPORT_RESULT_LIMIT = 500;

    private final transient WebTarget webTarget;
    private final String context;
    private final String contextValue;
    private final String almaStage;

    /**
     * Service for Alma Analytics.
     *
     * @param almaClient almaClient
     */
    public AlmaAnalyticsService(AlmaClient almaClient) {
        this.webTarget = almaClient.getWebTarget().path(ANALYTICS_PATH);
        this.context = almaClient.getContext();
        this.contextValue = almaClient.getContextValue();
        this.almaStage = almaClient.getAlmaStage();
    }

    String getAnalyticsReport(String reportPath, String obiFilter, String resumptionToken) {
        return webTarget
                .path(REPORT_PATH)
                .queryParam("path", reportPath)
                .queryParam("limit", REPORT_RESULT_LIMIT)
                .queryParam("filter", obiFilter)
                .queryParam("token", resumptionToken)
                .queryParam("ts", System.currentTimeMillis()) // Adding timestamp to avoid caching
                .request()
                .accept(MediaType.APPLICATION_XML)
                .get()
                .readEntity(String.class);
    }

    public String getContext() {
        return context;
    }

    public String getContextValue() {
        return contextValue;
    }

    public String getAlmaStage() {
        return almaStage;
    }
}


