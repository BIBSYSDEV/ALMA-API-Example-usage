package no.unit.alma.commons;

import com.typesafe.config.Config;
import org.glassfish.jersey.client.ClientProperties;
import org.glassfish.jersey.moxy.xml.MoxyXmlFeature;

import javax.ws.rs.Priorities;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import java.util.Objects;

public class AlmaClient {

    private final WebTarget webTarget;
    private final String contextValue;
    private final AlmaStage almaStage;

    private final static int connectTimeout = 10_000;
    private final static int readTimeout = 120_000;
    private final static String CONTEXT = "bibsysBibKode";

    public AlmaClient(Config config, Client client, VaultApiAuthorization apiAuthorization) {
        Objects.requireNonNull(apiAuthorization, "Alma API authorization is required");
        Objects.requireNonNull(client, "JAX-RS rest client must be provided");
        this.webTarget = client
                .property(ClientProperties.CONNECT_TIMEOUT, connectTimeout)
                .property(ClientProperties.READ_TIMEOUT, readTimeout)
                .register(MoxyXmlFeature.class)
                .register(new AlmaAuthorizationRequestFilter(apiAuthorization), Priorities.AUTHORIZATION)
                .register(new RequestResponseLogger(config.getString("app"), config.getString("stage")), 6000)
                .register(AlmaStatusResponseFilter.class, Priorities.ENTITY_CODER)
                .target(buildAlmaUrl(apiAuthorization.getAlmaHost(), config.getString("almaServiceContext")));
        this.almaStage = apiAuthorization.getAlmaStage();
        this.contextValue = apiAuthorization.getOrganization();
    }

    public WebTarget getWebTarget() {
        return webTarget;
    }

    public String getContext() {
        return CONTEXT;
    }

    public String getContextValue() {
        return contextValue;
    }

    public AlmaStage getAlmaStage() {
        return almaStage;
    }

    private String buildAlmaUrl(String host, String serviceContext) {
        return String.format("%s://%s/%s", "https", host, serviceContext);
    }
}




