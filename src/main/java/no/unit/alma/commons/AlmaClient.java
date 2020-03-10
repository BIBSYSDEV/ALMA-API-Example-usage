package no.unit.alma.commons;

import java.net.http.HttpClient;
import java.util.Objects;

public class AlmaClient {

    private final HttpClient webTarget;
    private final String context;
    private final String contextValue;
    private final AlmaStage almaStage;

    public static AlmaClientConfigurationBuilder builder() {
        return new AlmaClientConfigurationBuilder();
    }

    public AlmaClient(HttpClient webTarget, String context, String contextValue, AlmaStage almaStage) {
        this.webTarget = webTarget;
        this.context = context;
        this.contextValue = contextValue;
        this.almaStage = almaStage;
    }

    public HttpClient getWebTarget() {
        return webTarget;
    }

    public String getContext() {
        return context;
    }

    public String getContextValue() {
        return contextValue;
    }

    public AlmaStage getAlmaStage() {
        return almaStage;
    }

    public static class AlmaClientConfigurationBuilder {

        private HttpClient client;
        private int connectTimeout = 10_000;
        private int readTimeout = 120_000;
        private String app;
        private String stage;
        private boolean ssl = true;
        private String serviceContext;
        private VaultApiAuthorization apiAuthorization;


        private AlmaClientConfigurationBuilder() { }

        public AlmaClientConfigurationBuilder client(HttpClient client) {
            this.client = client;
            return this;
        }

        public AlmaClientConfigurationBuilder connectTimeout(int connectTimeout) {
            this.connectTimeout = connectTimeout;
            return this;
        }

        public AlmaClientConfigurationBuilder readTimeout(int readTimeout) {
            this.readTimeout = readTimeout;
            return this;
        }

        public AlmaClientConfigurationBuilder app(String app) {
            this.app = app;
            return this;
        }

        public AlmaClientConfigurationBuilder stage(String stage) {
            this.stage = stage;
            return this;
        }

        public AlmaClientConfigurationBuilder ssl(boolean ssl) {
            this.ssl = ssl;
            return this;
        }

        public AlmaClientConfigurationBuilder serviceContext(String serviceContext) {
            this.serviceContext = serviceContext;
            return this;
        }

        public AlmaClientConfigurationBuilder apiAuthorization(VaultApiAuthorization apiAuthorization) {
            this.apiAuthorization = apiAuthorization;
            return this;
        }

        public AlmaClient build() {
            Objects.requireNonNull(client, "JAX-RS rest client must be provided");
            Objects.requireNonNull(apiAuthorization, "Alma API authorization is required");
            return null;
//            return new AlmaClient(
//                client
//                    .property(ClientProperties.CONNECT_TIMEOUT, connectTimeout)
//                    .property(ClientProperties.READ_TIMEOUT, readTimeout)
//                    .register(MoxyXmlFeature.class)
//                    .register(new AlmaAuthorizationRequestFilter(apiAuthorization), Priorities.AUTHORIZATION)
//                    .register(new RequestResponseLogger(app, stage), 6000)
//                    .register(AlmaStatusResponseFilter.class, Priorities.ENTITY_CODER)
//                    .target(buildAlmaUrl(ssl, apiAuthorization.getAlmaHost(), serviceContext)),
//                "bibsysBibKode",
//                apiAuthorization.getOrganization(),
//                apiAuthorization.getAlmaStage()
//            );
        }

        private String buildAlmaUrl(boolean ssl, String host, String serviceContext) {
            return String.format("%s://%s/%s", ssl ? "https" : "http", host, serviceContext);
        }
    }
}
