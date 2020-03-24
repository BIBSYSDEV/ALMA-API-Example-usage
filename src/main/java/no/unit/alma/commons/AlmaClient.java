package no.unit.alma.commons;

import com.typesafe.config.Config;
import no.bibsys.vault.AppRole;
import no.bibsys.vault.VaultClient;
import org.glassfish.jersey.client.ClientProperties;
import org.glassfish.jersey.moxy.xml.MoxyXmlFeature;

import javax.ws.rs.Priorities;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import java.util.Objects;

public class AlmaClient {

    private final WebTarget webTarget;
    private final String contextValue;
    private final String almaStage;

    private final static int connectTimeout = 10_000;
    private final static int readTimeout = 120_000;
    private final static String CONTEXT = "bibsysBibKode";

    public AlmaClient(Client client, Config config, String bibCode) {
        this(client,
                config,
                VaultClient.builder()
                        .withCredentials(AppRole.from(config.getString("roleId"), config.getString("secretId")))
                        .build(),
                bibCode
        );
    }

    public AlmaClient(Client client, Config config, VaultClient vaultClient, String bibCode) {
        this(client,
                config,
                ApiAuthorizationService.builder()
                        .vaultClient(vaultClient)
                        .environment(config.getString("environment"))
                        .build(),
                bibCode
        );
    }

    public AlmaClient(Client client, Config config, ApiAuthorizationService apiAuthorizationService, String bibCode) {
        Objects.requireNonNull(client, "JAX-RS rest client must be provided");
        Objects.requireNonNull(apiAuthorizationService, "Alma API authorization is required");
        VaultApiAuthorization apiAuthorization = apiAuthorizationService.getApiAuthorization(config.getString("stage"), bibCode);

        this.webTarget = client
                .property(ClientProperties.CONNECT_TIMEOUT, connectTimeout)
                .property(ClientProperties.READ_TIMEOUT, readTimeout)
                .register(MoxyXmlFeature.class)
                .register(new AlmaAuthorizationRequestFilter(apiAuthorization), Priorities.AUTHORIZATION)
                .register(AlmaStatusResponseFilter.class, Priorities.ENTITY_CODER)
                .target(buildAlmaUrl(apiAuthorization.getAlmaHost(), config.getString("almaServiceContext")));
        this.almaStage = config.getString("stage");
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

    public String getAlmaStage() {
        return almaStage;
    }

    protected static  String buildAlmaUrl(String host, String serviceContext) {
        return String.format("%s://%s/%s", "https", host, serviceContext);
    }
}




