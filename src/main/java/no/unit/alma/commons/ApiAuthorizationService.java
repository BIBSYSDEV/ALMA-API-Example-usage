package no.unit.alma.commons;

import java.util.Objects;

import org.apache.commons.lang3.StringUtils;

import no.bibsys.vault.VaultClient;

public class ApiAuthorizationService {

    private final transient VaultClient vaultClient;
    private final transient String environment;

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

        private transient VaultClient builderVaultClient;
        private transient String builderEnvironment = "dev";

        private ApiAuthorizationServiceBuilder() {
        }

        public ApiAuthorizationServiceBuilder vaultClient(VaultClient vaultClient) {
            this.builderVaultClient = vaultClient;
            return this;
        }

        public ApiAuthorizationServiceBuilder environment(String environment) {
            this.builderEnvironment = environment;
            return this;
        }

        public ApiAuthorizationService build() {
            Objects.requireNonNull(builderVaultClient, "VaultClient cannot be null");
            if (StringUtils.isEmpty(builderEnvironment)) {
                throw new IllegalArgumentException("Environment is required. eg. dev");
            }
            return new ApiAuthorizationService(builderVaultClient, builderEnvironment);
        }
    }
}
