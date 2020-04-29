package no.unit.alma.commons;

import java.util.Objects;

import org.apache.commons.lang3.StringUtils;

import no.bibsys.vault.VaultClient;

public class ApiAuthorizationService {

    private final transient VaultClient vaultClient;
    private final transient String environment;

    private ApiAuthorizationService(VaultClient vaultClient, String environment) {
        this.vaultClient = vaultClient;
        this.environment = environment;
    }

    public static ApiAuthorizationServiceBuilder builder() {
        return new ApiAuthorizationServiceBuilder();
    }

    public VaultApiAuthorization getApiAuthorization(String bibsysBibCode) {
        return new VaultApiAuthorization(vaultClient, environment, bibsysBibCode);
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

        /**
         * Build-method for ApiAuthorizationService using VaultClientBuilder and
         * environment variables.
         * 
         * @return an ApiAuthorizationService
         */
        public ApiAuthorizationService build() {
            Objects.requireNonNull(builderVaultClient, "VaultClient cannot be null");
            if (StringUtils.isEmpty(builderEnvironment)) {
                throw new IllegalArgumentException("Environment is required. eg. dev");
            }
            return new ApiAuthorizationService(builderVaultClient, builderEnvironment);
        }
    }
}
