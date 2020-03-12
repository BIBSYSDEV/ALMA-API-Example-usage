package no.unit.alma.bibs;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.typesafe.config.ConfigFactory;
import no.bibsys.alma.rest.items.Item;
import no.bibsys.vault.AppRole;
import no.bibsys.vault.VaultClient;
import no.unit.alma.commons.ApiAuthorization;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public interface AlmaBibService {

    AlmaBibRecord retrieveBibRecord(String recordId, String availParams, String context, String value);

    AlmaBibRecord updateBibRecord(AlmaBibRecord bibRecord, String context, String value);

    List<AlmaHoldingsRecord> retrieveHoldingsRecordList(String recordId, String context, String value);

    AlmaHoldingsRecord retrieveHoldingsRecord(String recordId, String holdingsId, String context, String value);

    AlmaHoldingsRecord updateHoldingsRecord(String recordId, AlmaHoldingsRecord holdingsRecord, String context, String value);

    List<AlmaItemRecord> retrieveItemRecordList(String mmsid, String HoldingsId, String context, String value);

    AlmaItemRecord retrieveItemRecord(String mmsid, String holdingsId, String itemId, String context, String value);

    AlmaItemRecord retrieveItemRecord(String barcode, String context, String value);

    AlmaItemRecord updateItemRecord(AlmaItemRecord itemRecord, String context, String value);


    boolean canBeDestroyed(String barcode, String context, String value, Set<String> validLibraries, int minimumAge, int minimumItems);

    boolean canBeDestroyed(Item item, String context, String value, Set<String> validLibraries, int minimumAge, int minimumItems);

    String createLabel(String enumerationA, String enumerationB, String enumerationC, String enumerationD, String chronologyI, String chronologyJ, String chronologyK, String chronologyL);

    String createLabel(Item item);


    class Factory {

        private static final transient Logger log = LoggerFactory.getLogger(AlmaBibService.Factory.class);

        private static final int TIMEOUT_AMOUNT = 10;
        private static final int TIMEOUT_FIELD = Calendar.MINUTE;

        private static String institutionServiceHost;
        private static String institutionServiceURL;
        private static Calendar clientExpireTime;

        static String roleId;
        static String secretId;
        static String environment; //alma environment

        private static VaultClient vaultClient;

        private static AlmaBibService serviceInstance;
        private static ConcurrentHashMap<String, String> contextCache;

        static {
            contextCache = new ConcurrentHashMap<>();
            roleId = ConfigFactory.load().getString("roleId");
            secretId = ConfigFactory.load().getString("secretId");
            environment = ConfigFactory.load().getString("environment");

            institutionServiceHost = ConfigFactory.load().getString("institutionServiceHost");
            institutionServiceURL = institutionServiceHost + ConfigFactory.load().getString("institutionServiceUrl");

            initInstitutionServiceHost(institutionServiceHost);

            clientExpireTime = Calendar.getInstance();
            clientExpireTime.add(TIMEOUT_FIELD, +TIMEOUT_AMOUNT);
        }

        public static AlmaBibService instance() {
            if (serviceInstance == null) {
                serviceInstance = new AlmaBibServiceImplementation(roleId, secretId, institutionServiceHost);
            }
            return serviceInstance;
        }

        public static ApiAuthorization createApiAuthorization(String context, String value) {

            // Possible values context: bibsysBibKode, libCode, feideRealm (afaik)

            if (context != null && !context.isEmpty() && value != null && !value.isEmpty()) {
                String bibsysBibKode = null;
                if (context.equals("bibsysBibKode")) {
                    bibsysBibKode = value;
                } else {
                    if (contextCache.containsKey(context)) {
                        bibsysBibKode = contextCache.get(context);
                    } else {
                        bibsysBibKode = findBibsysBibKodeUsingInstitutionService(context, value);

                        if(bibsysBibKode != null) {
                            contextCache.put(context, bibsysBibKode);
                        }
                    }
                }
                if (bibsysBibKode != null && !bibsysBibKode.isEmpty()) {
                    final String apiKey = getVaultClient().read("secret/service/alma/apikey/" + environment + "/" + bibsysBibKode + "#value");
                    if (apiKey != null) {
                        return new StaticApiAuthorization(bibsysBibKode, apiKey);
                    }
                }
            }
            log.debug("AlmaContext apikey not found for Context '{}', Value '{}'", context, value);
            throw new RuntimeException("Unable to retrieve AlmaContext API key. Context: '" + context + "', Value: '" + value + "'");
        }

        static VaultClient getVaultClient() {
            if (vaultClient == null) {
                initVaultClient(roleId, secretId);
            }
            return vaultClient;
        }

        private static String findBibsysBibKodeUsingInstitutionService(String context, String value) {
            final Client client = ClientBuilder.newClient();
            final String uri = institutionServiceURL + "mapping/" + context + "/" + value;
            final WebTarget webTarget = client.target(uri);
            final Invocation.Builder request = webTarget.request(MediaType.APPLICATION_JSON);
            final Response response = request.accept(MediaType.APPLICATION_JSON + ";charset=utf-8").get();
            log.debug("request to instService = {} ", webTarget.getUri());
            log.debug("response from instService = {}", response.getStatus());
            if (response.getStatus() == 200) {
                ObjectMapper mapper = new ObjectMapper();
                try {
                    String content = response.readEntity(String.class);
                    JsonNode jsonObject = mapper.readTree(content);

                    String type = jsonObject.get("type").textValue();
                    if ("institution".equals(type)) {
                        return findBibsysBibKode(jsonObject);
                    } else {
                        int id = jsonObject.get("id").asInt();

                        Set<Integer> identifierSet = new HashSet<>();
                        identifierSet.add(id);

                        Set<JsonNode> graph = followRelations(jsonObject, identifierSet);
                        for (JsonNode node : graph) {
                            String nodeType = node.get("type").asText();
                            if ("institution".equals(nodeType)) {
                                return findBibsysBibKode(node);
                            }
                        }
                    }
                } catch (IOException e) {
                    log.error("not working: ", e);
                }
            }
            return null;
        }

        private static String findBibsysBibKode(JsonNode jsonObject) {
            final List<JsonNode> bibKodeArray = jsonObject.get("attributes").findValues("bibsysBibKode");

            if (bibKodeArray.size() > 0) {
                return bibKodeArray.get(0).get(0).asText();
            }

            log.error("Unable to find bibsysBibKode");
            throw new RuntimeException("Unable to find bibsysBibKode for " + jsonObject);
        }


        private static Set<JsonNode> followRelations(JsonNode jsonObject, Set<Integer> identifierSet) {

            Set<JsonNode> relationSet = new HashSet<JsonNode>();

            int id = jsonObject.get("id").asInt();

            JsonNode relations = jsonObject.get("relations");
            for (JsonNode relation : relations) {
                int from = relation.get("from").asInt();
                int to = relation.get("to").asInt();

                int relationId = (id == from) ? to : from;

                if (!identifierSet.contains(relationId)) {
                    identifierSet.add(relationId);

                    final Client client = ClientBuilder.newClient();
                    final String uri = institutionServiceURL + relationId + ".json";
                    WebTarget webTarget = client.target(uri);
                    Response response = webTarget.request(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON + ";charset=utf-8").get();
                    log.debug("request to instService = {} ", webTarget.getUri());
                    log.debug("response from instService = {}", response.getStatus());
                    if (response.getStatus() == 200) {
                        ObjectMapper mapper = new ObjectMapper();
                        try {
                            String content = response.readEntity(String.class);
                            JsonNode relationJsonObject = mapper.readTree(content);
                            relationSet.add(relationJsonObject);

                            relationSet.addAll(followRelations(relationJsonObject, identifierSet));

                        } catch (IOException e) {
                            log.error("Could not read entity", e);
                        }
                    }
                }

            }

            return relationSet;
        }

        static void initVaultClient(String roleId, String secretId) {
            AlmaBibService.Factory.vaultClient = VaultClient
                .builder()
                .withCredentials(AppRole.from(roleId, secretId))
                .build();
        }

        static void initInstitutionServiceHost(String newInstitutionServiceHost) {
            log.info("new insitution service host = {}", newInstitutionServiceHost);
            newInstitutionServiceHost = (newInstitutionServiceHost.startsWith("http://") ? "" : "http://") + newInstitutionServiceHost + (newInstitutionServiceHost.endsWith("/") ? "" : "/");

            AlmaBibService.Factory.institutionServiceHost = newInstitutionServiceHost;
            AlmaBibService.Factory.institutionServiceURL = AlmaBibService.Factory.institutionServiceHost + ConfigFactory.load().getString("institutionServiceUrl");
            log.info("service url = {}", institutionServiceURL);
        }
    }
}
