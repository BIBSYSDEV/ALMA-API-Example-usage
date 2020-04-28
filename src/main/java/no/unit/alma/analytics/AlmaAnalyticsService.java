package no.unit.alma.analytics;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import no.unit.alma.commons.AlmaClient;
import no.unit.alma.commons.AlmaStatusResponseFilter;
import no.unit.alma.generated.vendors.Vendor;
import org.glassfish.jersey.client.JerseyClientBuilder;
import org.glassfish.jersey.moxy.xml.MoxyXmlFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.*;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.ws.rs.Priorities;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.*;
import javax.ws.rs.client.Entity;


public class AlmaAnalyticsService {

    public static final String ANALYTICS_PATH = "analytics";
    public static final String REPORT_PATH = "reports";

    private final transient WebTarget webTarget;
    private final String context;
    private final String contextValue;
    private final String almaStage;

    /**
     * Service for vendors.
     *
     * @param almaClient almaClient
     */
    public AlmaAnalyticsService(AlmaClient almaClient) {
        this.webTarget = almaClient.getWebTarget().path(ANALYTICS_PATH);
        this.context = almaClient.getContext();
        this.contextValue = almaClient.getContextValue();
        this.almaStage = almaClient.getAlmaStage();
    }


    public String getAnalyticsReport(String reportPath, String ObiFilter) throws UnsupportedEncodingException {
        Config config = ConfigFactory.defaultReference();//TODO: remove when prod-vault-issue is fixed

        return webTarget
                .path(REPORT_PATH)
                .queryParam("path", reportPath)
                .request()
                .header("Authorization", config.getString("apikey"))//TODO: remove when prod-vault-issue is fixed
                .accept(MediaType.APPLICATION_JSON)
                .get()
                .readEntity(String.class);
    }


//    private static final Logger logger = LoggerFactory.getLogger(AlmaAnalyticsService.class);
//    private static final String GET_REPORT_SERVICE_URL = BASE_URL + "/analytics/reports?path={path}&limit=500";
//    private static final String MY_NAMESPACE = " xmlns:saw=\"com.siebel.analytics.web/report/v1.1\" "
//        + "xmlns:sawx=\"com.siebel.analytics.web/expression/v1.1\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" "
//        + "xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" ";
//    private static final String UTF_8 = "UTF-8";
//
//    public AlmaAnalyticsService(String bibcode) {
//        super("bibsysBibKode", bibcode);
//    }
//
//    public static String createSingleValueFilter(String valueType, String value, String field, String operation, String operationType) {
//        return "<sawx:expr xsi:type=\"sawx:" + operationType + "\" op=\"" + operation + "\" " + MY_NAMESPACE + ">"
//            + "<sawx:expr xsi:type=\"sawx:sqlExpression\">"
//            + field
//            + "</sawx:expr> "
//            + "<sawx:expr xsi:type=\"xsd:" + valueType + "\">"
//            + value + "</sawx:expr> "
//            + "</sawx:expr>";
//    }
//
//    public static String createSingleValueFilter(String id, String field, String operation) {
//        return "<sawx:expr xsi:type=\"sawx:comparison\" op=\"" + operation + "\" xmlns:saw=\"com.siebel.analytics.web/report/v1.1\" "
//            + "xmlns:sawx=\"com.siebel.analytics.web/expression/v1.1\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" "
//            + "xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\"> <sawx:expr xsi:type=\"sawx:sqlExpression\">"
//            + field
//            + "</sawx:expr> "
//            + "<sawx:expr xsi:type=\"xsd:string\">"
//            + id
//            + "</sawx:expr> "
//            + "</sawx:expr>";
//    }
//
//    public static String createValueFilter(String valueType, String value1, String value2, String field, String operation, String operationType) {
//        return "<sawx:expr xsi:type=\"sawx:" + operationType + "\" op=\"" + operation + "\" " + MY_NAMESPACE + ">"
//            + "<sawx:expr xsi:type=\"sawx:sqlExpression\">"
//            + field
//            + "</sawx:expr> "
//            + "<sawx:expr xsi:type=\"xsd:" + valueType + "\">" + value1 + "</sawx:expr> "
//            + "<sawx:expr xsi:type=\"xsd:" + valueType + "\">" + value2 + "</sawx:expr> "
//            + "</sawx:expr>";
//    }
//
//    public static String createOperatorFilter(String operation, String anotherFilter) {
//        return "<sawx:expr xsi:type=\"sawx:logical\" op=\"" + operation + "\" " + MY_NAMESPACE + ">"
//            + anotherFilter
//            + "</sawx:expr>";
//    }
//
//    public List<Map<String, String>> retrieveAnalyticsReport(String path, String filter) {
//        List<Map<String, String>> report = new ArrayList<>();
//        try {
//            path = URLEncoder.encode(path, UTF_8);
//            filter = URLEncoder.encode(filter, UTF_8);
//        } catch (UnsupportedEncodingException e1) {
//            logger.error("ERROR: Could not encode URL " + e1.getMessage());
//        }
//
//        String baseUri = GET_REPORT_SERVICE_URL.replace("{path}", path);
//
//        if (filter != null && !filter.isEmpty()) {
//            baseUri += "&filter=" + filter;
//        }
//
//        // Add timestamp to avoid cache causing wrong data from Analytics API
//        baseUri += "&ts=" + System.currentTimeMillis();
//
//        boolean finished = false;
//        String token = "";
//        int errorCount = 0;
//        String uri = baseUri;
//        while (!finished && report.size() < 65000) {
//            List<Integer> endErrorCodes = Arrays.asList(new Integer[]{500});
//            AlmaResponse<String> almaResponse = callAlmaWithRetry(uri, 200, endErrorCodes, String.class, GET);
//
//            DocumentBuilder db;
//            try {
//                db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
//                InputSource is = new InputSource();
//                is.setCharacterStream(new StringReader(almaResponse.resultObject()));
//                Document doc = db.parse(is);
//                NodeList queryResultElements = doc.getElementsByTagName("QueryResult");
//                Element result = (Element) queryResultElements.item(0);
//                NodeList finishedElementNodeList = result.getElementsByTagName("IsFinished");
//                if (finishedElementNodeList.getLength() > 0) {
//                    finished = Boolean.valueOf(finishedElementNodeList.item(0).getTextContent());
//                } else {
//                    finished = true;
//                }
//                if (token.equals("")) {
//                    NodeList tokenNodeList = doc.getElementsByTagName("ResumptionToken");
//                    if (tokenNodeList.getLength() > 0) {
//                        token = tokenNodeList.item(0).getTextContent();
//                        uri = baseUri + "&token=" + token;
//                    }
//                }
//                NodeList rowset = result.getElementsByTagName("rowset");
//                if (rowset.getLength() > 0) {
//                    NodeList rowList = ((Element) rowset.item(0)).getElementsByTagName("Row");
//                    for (int i = 0; i < rowList.getLength(); i++) {
//                        Element row = (Element) rowList.item(i);
//                        NodeList childNodes = row.getChildNodes();
//                        Map<String, String> rowMap = new LinkedHashMap<>();
//                        report.add(rowMap);
//                        for (int j = 0; j < childNodes.getLength(); j++) {
//                            Node childNode = childNodes.item(j);
//                            if (childNode.getNodeType() == Node.ELEMENT_NODE) {
//                                Element column = (Element) childNode;
//                                rowMap.put(column.getNodeName(), column.getTextContent());
//                            }
//                        }
//                    }
//                }
//            } catch (ParserConfigurationException | SAXException | IOException e) {
//                finished = false;
//                if (errorCount++ > 3) {
//                    logger.error("Error getting report from Analytics", e);
//                    break;
//                }
//            }
//        }
//
//        return report;
//
//    }
        
    /* Often ALMA REST API Analytics fails even with a HTTP response code 200.

    Here is the typical invalid response where it says an empty ResultXml, IsFinished is false and with a resumptionToken :
    <report>
        <QueryResult>
            <ResumptionToken>5514B8CE1BB0CBF68781B2DB54F0135132BD803B68E1925014B2793448540607967A74E50AECA3074E758E52BBB76CA1677D3AD05EDC3CA7F06182E34E9D7A2F</ResumptionToken>
            <IsFinished>false</IsFinished>
            <ResultXml/>
        </QueryResult>
    </report>


    Here is a valid response:
    <?xml version="1.0" encoding="UTF-8" standalone="yes"?>
    <report>
        <QueryResult>
            <IsFinished>true</IsFinished>
            <ResultXml>
              <rowset xmlns="urn:schemas-microsoft-com:xml-analysis:rowset">
                <Row>
                  <Column0>0</Column0>
                  <Column1>9788230013762; 8230013764</Column1>
                  <Column3>Book</Column3>
                  <Column4>999919809503102205</Column4>
                  <Column6>Thembalethu</Column6>
                  <Column8>None</Column8>
                  <Column9>LEGAL_DEPOSIT</Column9>
                  <Column10>Yes</Column10>
                  <Column11>ACTIVE</Column11>
                  <Column12>pl_5298</Column12>
                  <Column13>Forlagssentralen ANS</Column13>
                  <Column14>2015</Column14>
                  <Column15>1</Column15>
                </Row>
                <Row>
                  <Column0>0</Column0>
                  <Column1>9788230013762; 8230013764</Column1>
                  <Column3>Book</Column3>
                  <Column4>999919816913402204</Column4>
                  <Column6>Thembalethu</Column6>
                  <Column8>None</Column8>
                  <Column9>LEGAL_DEPOSIT</Column9>
                  <Column10>Yes</Column10>
                  <Column11>ACTIVE</Column11>
                  <Column12>pl_5298</Column12>
                  <Column13>Forlagssentralen ANS</Column13>
                  <Column14>2015</Column14>
                  <Column15>1</Column15>
                </Row>
              </rowset>
            </ResultXml>
        </QueryResult>
    </report>
    */

    public String getContext() {
        return context;
    }


    public String getContextValue() {
        return contextValue;
    }


    public String getAlmaStage() {
        return almaStage;
    }
}
