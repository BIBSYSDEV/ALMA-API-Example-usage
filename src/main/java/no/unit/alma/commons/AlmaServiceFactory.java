package no.unit.alma.commons;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import no.bibsys.vault.AppRole;
import no.bibsys.vault.VaultClient;
import no.unit.alma.acquisitions.AlmaVendorsService;
import no.unit.alma.acquisitions.AlmaVendorsServiceImplementation;

import javax.ws.rs.client.Client;

public class AlmaServiceFactory {

    private final Config config;
    private final ApiAuthorizationService apiAuthorizationService;
    private final Client client;

    public AlmaServiceFactory(Client client) {
        this(client, ConfigFactory.load());
    }

    public AlmaServiceFactory(Client client, Config config) {
        this(client, config,
                VaultClient.builder()
                        .withCredentials(AppRole.from(config.getString("roleId"), config.getString("secretId")))
                        .build()
        );
    }

    public AlmaServiceFactory(Client client, Config config, VaultClient vaultClient) {
        this(client, config,
                ApiAuthorizationService.builder()
                        .vaultClient(vaultClient)
                        .environment(config.getString("environment"))
                        .build()
        );
    }

    public AlmaServiceFactory(Client client, Config config, ApiAuthorizationService apiAuthorizationService) {
        this.config = config;
        this.apiAuthorizationService = apiAuthorizationService;
        this.client = client;
    }

    private AlmaClient newAlmaClientInstance(String bibCode, AlmaStage almaStage) {
        return AlmaClient.builder()
                .client(client)
                .app(config.getString("app"))
                .stage(config.getString("stage"))
                .apiAuthorization(apiAuthorizationService.getApiAuthorization(almaStage, bibCode))
                .ssl(config.getBoolean("useSsl"))
                .serviceContext(config.getString("almaServiceContext"))
                .build();
    }

//    public AlmaBibs getAlmaBibs(String bibCode, AlmaStage almaStage) {
//        return new AlmaBibsClient(newAlmaClientInstance(bibCode, almaStage));
//    }
//
//    public AlmaBibs getAlmaBibs(String bibCode, String almaStage) {
//        return new AlmaBibsClient(newAlmaClientInstance(bibCode, AlmaStage.valueOf(almaStage.toUpperCase())));
//    }
//
//    public AlmaConf getAlmaConf(String bibCode, AlmaStage almaStage) {
//        return new AlmaConfClient(newAlmaClientInstance(bibCode, almaStage));
//    }
//
//    public AlmaConf getAlmaConf(String bibCode, String almaStage) {
//        return new AlmaConfClient(newAlmaClientInstance(bibCode, AlmaStage.valueOf(almaStage.toUpperCase())));
//    }
//
//    public AlmaFunds getAlmaFunds(String bibCode, AlmaStage almaStage) {
//        return new AlmaFundsClient(newAlmaClientInstance(bibCode, almaStage));
//    }
//
//    public AlmaFunds getAlmaFunds(String bibCode, String almaStage) {
//        return new AlmaFundsClient(newAlmaClientInstance(bibCode, AlmaStage.valueOf(almaStage.toUpperCase())));
//    }
//
//    public AlmaHoldings getAlmaHoldings(String bibCode, AlmaStage almaStage) {
//        return new AlmaHoldingsClient(newAlmaClientInstance(bibCode, almaStage));
//    }
//
//    public AlmaHoldings getAlmaHoldings(String bibCode, String almaStage) {
//        return new AlmaHoldingsClient(newAlmaClientInstance(bibCode, AlmaStage.valueOf(almaStage.toUpperCase())));
//    }
//
//    public AlmaInvoices getAlmaInvoices(String bibCode, AlmaStage almaStage) {
//        return new AlmaInvoicesClient(newAlmaClientInstance(bibCode, almaStage));
//    }
//
//    public AlmaInvoices getAlmaInvoices(String bibCode, String almaStage) {
//        return new AlmaInvoicesClient(newAlmaClientInstance(bibCode, AlmaStage.valueOf(almaStage.toUpperCase())));
//    }
//
//    public AlmaPartners getAlmaPartners(String bibCode, AlmaStage almaStage) {
//        return new AlmaPartnersClient(newAlmaClientInstance(bibCode, almaStage));
//    }
//
//    public AlmaPartners getAlmaPartners(String bibCode, String almaStage) {
//        return new AlmaPartnersClient(newAlmaClientInstance(bibCode, AlmaStage.valueOf(almaStage.toUpperCase())));
//    }
//
//    public AlmaPoLines getAlmaPoLines(String bibCode, AlmaStage almaStage) {
//        return new AlmaPoLinesClient(newAlmaClientInstance(bibCode, almaStage));
//    }
//
//    public AlmaPoLines getAlmaPoLines(String bibCode, String almaStage) {
//        return new AlmaPoLinesClient(newAlmaClientInstance(bibCode, AlmaStage.valueOf(almaStage.toUpperCase())));
//    }
//
//    public AlmaUsersClient getAlmaUsersClient(String bibCode, AlmaStage almaStage) {
//        return new AlmaUsersClient(newAlmaClientInstance(bibCode, almaStage));
//    }
//
//    public AlmaUsersClient getAlmaUsersClient(String bibCode, String almaStage) {
//        return new AlmaUsersClient(newAlmaClientInstance(bibCode, AlmaStage.valueOf(almaStage.toUpperCase())));
//    }
//
    public AlmaVendorsService getAlmaVendors(String bibCode, AlmaStage almaStage) {
        return new AlmaVendorsServiceImplementation(newAlmaClientInstance(bibCode, almaStage));
    }

    public AlmaVendorsService getAlmaVendors(String bibCode, String almaStage) {
        return new AlmaVendorsServiceImplementation(newAlmaClientInstance(bibCode, AlmaStage.valueOf(almaStage.toUpperCase())));
    }
//
//    public AlmaItems getAlmaItems(String bibCode, AlmaStage almaStage) {
//        return new AlmaItemsClient(newAlmaClientInstance(bibCode, almaStage));
//    }
//
//    public AlmaItems getAlmaItems(String bibCode, String almaStage) {
//        return new AlmaItemsClient(newAlmaClientInstance(bibCode, AlmaStage.valueOf(almaStage.toUpperCase())));
//    }
}
