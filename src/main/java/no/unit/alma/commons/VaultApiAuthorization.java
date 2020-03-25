package no.unit.alma.commons;

import java.util.Objects;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import no.bibsys.vault.VaultClient;

public class VaultApiAuthorization {

    private static final transient Logger log = LoggerFactory.getLogger(VaultApiAuthorization.class);

    private final transient VaultClient vaultClient;
    private final String environment;
    private final String almaStage;
    private final String organization;

    public VaultApiAuthorization(VaultClient vaultClient, String environment, String almaStage, String organization) {
        Objects.requireNonNull(vaultClient, "Vault client is required");
        if (StringUtils.isEmpty(environment)) {
            throw new RuntimeException("Environment is required");
        }
        if (StringUtils.isEmpty(organization)) {
            throw new RuntimeException("Organization is required");
        }
        Objects.requireNonNull(almaStage, "Alma stage is required");
        this.vaultClient = vaultClient;
        this.environment = environment;
        this.almaStage = almaStage;
        this.organization = organization;
        // make sure that we can retrieve the almaHost or fail fast
        getSecret("almaHost", "host");
        // make sure that we can retrieve the apikey or fail fast
        getSecret("apiKey", organization);
    }

    public String getEnvironment() {
        return environment;
    }

    public String getAlmaStage() {
        return almaStage;
    }

    public String getOrganization() {
        return organization;
    }

    public String asAPIKey() {
        return "apikey " + getApiKey();
    }

    public String getAlmaHost() {
        return getSecret("almaHost", "host");
    }

    private String getApiKey() {
        return getSecret("apiKey", organization);
    }

    private String getSecret(String type, String key) {
        String secretPath = String.format("secret/service/alma/apikey/%s/%s/%s#value", environment, almaStage, key);
        log.trace("Vault secret path for Environment '{}', Alma stage '{}', Context '{}', Value '{}': {}", environment,
                almaStage, type, key, secretPath);
        final String secret = vaultClient.read(secretPath);
        if (secret == null) {
            throw new RuntimeException(String.format(
                    "Unable to retrieve AlmaContext secret. Environment: '%s', Alma stage: '%s', AlmaContext: '%s', Value: '%s'",
                    environment, almaStage, type, key));
        }
        log.debug("AlmaContext secret found for Environment '{}', Alma stage '{}', Context '{}', Value '{}'",
                environment, almaStage, type, key);
        return secret;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        VaultApiAuthorization that = (VaultApiAuthorization) o;
        return Objects.equals(organization, that.organization) &&
                Objects.equals(environment, that.environment) &&
                almaStage == that.almaStage &&
                Objects.equals(getAlmaHost(), that.getAlmaHost()) &&
                Objects.equals(getApiKey(), that.getApiKey());
    }

    @Override
    public int hashCode() {
        return Objects.hash(organization, environment, getAlmaHost(), getApiKey(), almaStage);
    }

    @Override
    public String toString() {
        return "ApiAuthorization{" +
                "environment='" + environment + '\'' +
                ", almaStage=" + almaStage +
                ", organization='" + organization + '\'' +
                '}';
    }
}
