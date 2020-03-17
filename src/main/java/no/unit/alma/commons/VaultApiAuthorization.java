package no.unit.alma.commons;

import no.bibsys.vault.VaultClient;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

public class VaultApiAuthorization implements ApiAuthorization {

    private static final transient Logger log = LoggerFactory.getLogger(ApiAuthorizationService.class);

    private final VaultClient vaultClient;
    private final String environment;
    private final AlmaStage almaStage;
    private final String organization;

    public VaultApiAuthorization(VaultClient vaultClient, String environment, AlmaStage almaStage, String organization) {
        Objects.requireNonNull(vaultClient, "Vault client is required");
        if (StringUtils.isEmpty(environment)) {
            throw new NullPointerException("Environment is required");
        }
        if (StringUtils.isEmpty(organization)) {
            throw new NullPointerException("Organization is required");
        }
        Objects.requireNonNull(almaStage, "Alma stage is required");
        this.vaultClient = vaultClient;
        this.environment = environment;
        this.almaStage = almaStage;
        this.organization = organization;
        //make sure that we can retrieve the almaHost or fail fast
        getAlmaHost();
        //make sure that we can retrieve the apikey or fail fast
        getApiKey();
    }


    public String getEnvironment() {
        return environment;
    }

    public AlmaStage getAlmaStage() {
        return almaStage;
    }

    @Override
    public final String getOrganization() {
        return organization;
    }

    @Override
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
        String secretPath = String.format("secret/service/alma/apikey/%s/%s/%s#value", environment, almaStage.getVaultAlmaStageName(), key);
        log.trace("Vault secret path for Environment '{}', Alma stage '{}', Context '{}', Value '{}': {}", environment, almaStage, type, key, secretPath);
        final String secret = vaultClient.read(secretPath);
        if (secret == null) {
            throw new NullPointerException(String.format("Unable to retrieve AlmaContext secret. Environment: '%s', Alma stage: '%s', AlmaContext: '%s', Value: '%s'",
                environment, almaStage, type, key));
        }
        log.debug("AlmaContext secret found for Environment '{}', Alma stage '{}', Context '{}', Value '{}'", environment, almaStage, type, key);
        return secret;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
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
