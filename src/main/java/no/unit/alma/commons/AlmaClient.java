package no.unit.alma.commons;

import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.Priorities;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Feature;

import org.glassfish.jersey.client.ClientProperties;
import org.glassfish.jersey.logging.LoggingFeature;
import org.glassfish.jersey.moxy.xml.MoxyXmlFeature;

import com.typesafe.config.Config;

import no.bibsys.vault.AppRole;
import no.bibsys.vault.VaultClient;

public class AlmaClient {

    private final WebTarget webTarget;
    private final String contextValue;

    private static final int connectTimeout = 10_000;
    private static final int readTimeout = 120_000;
    private static final String context = "bibsysBibKode";

    /**
     * Alma Client default constructor.
     *
     * @param client  A WS-RS-client
     * @param config  Application config
     * @param bibCode An instituition bibCode
     */
    public AlmaClient(Client client, Config config, String bibCode) {
        this(client,
                config,
                VaultClient.builder()
                        .withCredentials(AppRole.from(config.getString("roleId"), config.getString("secretId")))
                        .build(),
                bibCode);
    }

    /**
     * Alma Client constructor with VaultClient.
     *
     * @param client      A WS-RS-client
     * @param config      Application config
     * @param vaultClient VaultClient
     * @param bibCode     An instituition bibCode
     */
    public AlmaClient(Client client, Config config, VaultClient vaultClient, String bibCode) {
        this(client, config,
                ApiAuthorizationService.builder()
                        .vaultClient(vaultClient)
                        .environment(config.getString("environment"))
                        .build(),
                bibCode);
    }

    /**
     * Alma Client constructor with ApiAuthorizationService. *
     * 
     * @param client                  A WS-RS-client
     * @param config                  Application config
     * @param apiAuthorizationService ApiAuthorizationService
     * @param bibCode                 An instituition bibCode
     */
    public AlmaClient(Client client, Config config, ApiAuthorizationService apiAuthorizationService, String bibCode) {
        Objects.requireNonNull(client, "JAX-RS rest client must be provided");
        Objects.requireNonNull(apiAuthorizationService, "Alma API authorization is required");
        VaultApiAuthorization apiAuthorization =
                apiAuthorizationService.getApiAuthorization(bibCode);

        Logger logger = Logger.getLogger(getClass().getName());
        Feature loggerFeature = new LoggingFeature(logger, Level.INFO, null, null);

        this.webTarget =
                client
                        .property(ClientProperties.CONNECT_TIMEOUT, connectTimeout)
                        .property(ClientProperties.READ_TIMEOUT, readTimeout)
                        .register(MoxyXmlFeature.class)
                        .register(loggerFeature)
                        //.register(new AlmaAuthorizationRequestFilter(apiAuthorization), Priorities.AUTHORIZATION)//TODO: comment in back when prod-vault-issue is fixed
                        .register(AlmaStatusResponseFilter.class, Priorities.ENTITY_CODER)
                        .target(config.getString("almaBaseUrl"));
        this.contextValue = apiAuthorization.getOrganization();
    }

    public WebTarget getWebTarget() {
        return webTarget;
    }

    public String getContext() {
        return context;
    }

    public String getContextValue() {
        return contextValue;
    }
}
