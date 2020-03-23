package no.unit.alma.commons;

import no.bibsys.vault.VaultClient;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

public class ApiAuthorizationService {

    private final VaultClient vaultClient;
    private final String environment;

    public static ApiAuthorizationServiceBuilder builder() {
        return new ApiAuthorizationServiceBuilder();
    }

    private ApiAuthorizationService(VaultClient vaultClient, String environment) {
        this.vaultClient = vaultClient;
        this.environment = environment;
    }

    public VaultApiAuthorization getApiAuthorization(String almaStage, String bibsysBibCode) {
        return new VaultApiAuthorization(vaultClient, environment, almaStage, bibsysBibCode);
    }

    public static class ApiAuthorizationServiceBuilder {

        private VaultClient vaultClient;
        private String environment = "dev";

        private ApiAuthorizationServiceBuilder() { }

        public ApiAuthorizationServiceBuilder vaultClient(VaultClient vaultClient) {
            this.vaultClient = vaultClient;
            return this;
        }

        public ApiAuthorizationServiceBuilder environment(String environment) {
            this.environment = environment;
            return this;
        }

        public ApiAuthorizationService build() {
            Objects.requireNonNull(vaultClient, "VaultClient cannot be null");
            if (StringUtils.isEmpty(environment)) {
                throw new IllegalArgumentException("Environment is required. eg. dev");
            }
            return new ApiAuthorizationService(vaultClient, environment);
        }
    }
}
