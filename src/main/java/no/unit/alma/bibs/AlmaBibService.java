package no.unit.alma.bibs;

import java.util.Calendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.typesafe.config.ConfigFactory;

import no.bibsys.vault.AppRole;
import no.bibsys.vault.VaultClient;
import no.unit.alma.commons.AlmaClient;
import no.unit.alma.commons.AlmaStage;

public interface AlmaBibService {

    AlmaBibRecord retrieveBibRecord(String recordId, String availParams, String context, String value);

    // AlmaBibRecord updateBibRecord(AlmaBibRecord bibRecord, String context, String
    // value);
    //
    // List<AlmaHoldingsRecord> retrieveHoldingsRecordList(String recordId, String
    // context, String value);
    //
    // AlmaHoldingsRecord retrieveHoldingsRecord(String recordId, String holdingsId,
    // String context, String value);
    //
    // AlmaHoldingsRecord updateHoldingsRecord(String recordId, AlmaHoldingsRecord
    // holdingsRecord, String context, String value);
    //
    // List<AlmaItemRecord> retrieveItemRecordList(String mmsid, String HoldingsId,
    // String context, String value);
    //
    // AlmaItemRecord retrieveItemRecord(String mmsid, String holdingsId, String
    // itemId, String context, String value);
    //
    // AlmaItemRecord retrieveItemRecord(String barcode, String context, String
    // value);
    //
    // AlmaItemRecord updateItemRecord(AlmaItemRecord itemRecord, String context,
    // String value);

//    boolean canBeDestroyed(String barcode, String context, String value, Set<String> validLibraries, int minimumAge,
//            int minimumItems);
//
//    boolean canBeDestroyed(Item item, String context, String value, Set<String> validLibraries, int minimumAge,
//            int minimumItems);
//
//    String createLabel(String enumerationA, String enumerationB, String enumerationC, String enumerationD,
//            String chronologyI, String chronologyJ, String chronologyK, String chronologyL);
//
//    String createLabel(Item item);

    String getContext();

    String getContextValue();

    AlmaStage getAlmaStage();

    class Factory {

        private static final transient Logger log = LoggerFactory.getLogger(AlmaBibService.Factory.class);

        private static final int TIMEOUT_AMOUNT = 10;
        private static final int TIMEOUT_FIELD = Calendar.MINUTE;

//        private static String institutionServiceHost;
//        private static String institutionServiceURL;
        private static Calendar clientExpireTime;

        static String roleId;
        static String secretId;
        static String environment; // alma environment

        private static VaultClient vaultClient;

        private static AlmaBibService serviceInstance;
//        private static ConcurrentHashMap<String, String> contextCache;

        static {
//            contextCache = new ConcurrentHashMap<>();
            roleId = ConfigFactory.load().getString("roleId");
            secretId = ConfigFactory.load().getString("secretId");
            environment = ConfigFactory.load().getString("environment");

//            institutionServiceHost = ConfigFactory.load().getString("institutionServiceHost");
//            institutionServiceURL = institutionServiceHost + ConfigFactory.load().getString("institutionServiceUrl");
//
//            initInstitutionServiceHost(institutionServiceHost);

            clientExpireTime = Calendar.getInstance();
            clientExpireTime.add(TIMEOUT_FIELD, +TIMEOUT_AMOUNT);
        }

        public static AlmaBibService instance(AlmaClient almaClient) {
            if (serviceInstance == null) {
                serviceInstance = new AlmaBibServiceImplementation(almaClient);
            }
            return serviceInstance;
        }

//        public static ApiAuthorization createApiAuthorization(String bibsysBibKode) {
//
//            if (bibsysBibKode != null && !bibsysBibKode.isEmpty()) {
//                return new VaultApiAuthorization(vaultClient, environment, almaStage, bibsysBibKode);
//            }
//            log.debug("AlmaContext apikey not found for Context '{}', Value '{}'", context, value);
//            throw new RuntimeException(
//                    "Unable to retrieve AlmaContext API key. Context: '" + context + "', Value: '" + value + "'");
//        }

        static VaultClient getVaultClient() {
            if (vaultClient == null) {
                initVaultClient(roleId, secretId);
            }
            return vaultClient;
        }

        static void initVaultClient(String roleId, String secretId) {
            AlmaBibService.Factory.vaultClient =
                    VaultClient.builder().withCredentials(AppRole.from(roleId, secretId))
                            .build();
        }

//        static void initInstitutionServiceHost(String newInstitutionServiceHost) {
//            log.info("new insitution service host = {}", newInstitutionServiceHost);
//            newInstitutionServiceHost =
//                    (newInstitutionServiceHost.startsWith("http://") ? "" : "http://")
//                            + newInstitutionServiceHost + (newInstitutionServiceHost.endsWith("/") ? "" : "/");
//
//            AlmaBibService.Factory.institutionServiceHost = newInstitutionServiceHost;
//            AlmaBibService.Factory.institutionServiceURL =
//                    AlmaBibService.Factory.institutionServiceHost
//                            + ConfigFactory.load().getString("institutionServiceUrl");
//            log.info("service url = {}", institutionServiceURL);
//        }
    }
}
