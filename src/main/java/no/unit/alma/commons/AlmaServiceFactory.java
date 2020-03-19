package no.unit.alma.commons;

import javax.ws.rs.client.Client;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

import no.bibsys.vault.AppRole;
import no.bibsys.vault.VaultClient;
import no.unit.alma.acquisitions.AlmaVendorsService;
import no.unit.alma.acquisitions.AlmaVendorsServiceImplementation;
import no.unit.alma.bibs.AlmaBibsService;
import no.unit.alma.bibs.AlmaBibsServiceImplementation;
import no.unit.alma.bibs.AlmaHoldingsService;
import no.unit.alma.bibs.AlmaHoldingsServiceImplementation;
import no.unit.alma.bibs.AlmaItemsService;
import no.unit.alma.bibs.AlmaItemsServiceImplementation;

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
                        .build());
    }

    public AlmaServiceFactory(Client client, Config config, VaultClient vaultClient) {
        this(client, config,
                ApiAuthorizationService.builder()
                        .vaultClient(vaultClient)
                        .environment(config.getString("environment"))
                        .build());
    }

    public AlmaServiceFactory(Client client, Config config, ApiAuthorizationService apiAuthorizationService) {
        this.config = config;
        this.apiAuthorizationService = apiAuthorizationService;
        this.client = client;
    }

    AlmaClient newAlmaClientInstance(String bibCode, AlmaStage almaStage) {
        return new AlmaClient(config, client, apiAuthorizationService.getApiAuthorization(almaStage, bibCode));
    }

    public AlmaBibsService getAlmaBibs(String bibCode, AlmaStage almaStage) {
        return new AlmaBibsServiceImplementation(newAlmaClientInstance(bibCode, almaStage));
    }

    public AlmaBibsService getAlmaBibs(String bibCode, String almaStage) {
        return new AlmaBibsServiceImplementation(
                newAlmaClientInstance(bibCode, AlmaStage.valueOf(almaStage.toUpperCase())));
    }

    public AlmaHoldingsService getAlmaHoldings(String bibCode, AlmaStage almaStage) {
        return new AlmaHoldingsServiceImplementation(newAlmaClientInstance(bibCode, almaStage));
    }

    public AlmaHoldingsService getAlmaHoldings(String bibCode, String almaStage) {
        return new AlmaHoldingsServiceImplementation(
                newAlmaClientInstance(bibCode, AlmaStage.valueOf(almaStage.toUpperCase())));
    }

    public AlmaItemsService getAlmaItems(String bibCode, AlmaStage almaStage) {
        return new AlmaItemsServiceImplementation(newAlmaClientInstance(bibCode, almaStage));
    }

    public AlmaItemsService getAlmaItems(String bibCode, String almaStage) {
        return new AlmaItemsServiceImplementation(
                newAlmaClientInstance(bibCode, AlmaStage.valueOf(almaStage.toUpperCase())));
    }

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
        return new AlmaVendorsServiceImplementation(
                newAlmaClientInstance(bibCode, AlmaStage.valueOf(almaStage.toUpperCase())));
    }
}
