package no.unit.alma.analytics;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class AlmaAnalyticsHelper {

    private static final transient Logger log = LoggerFactory.getLogger(AlmaAnalyticsService.class);

    static final int REPORT_SIZE = 65_000;
    public static final String QUERY_RESULT_TAG = "QueryResult";
    public static final String FINISHED_TAG = "IsFinished";
    public static final String RESUMPTION_TOKEN_TAG = "ResumptionToken";
    public static final String ROWSET_TAG = "rowset";
    public static final String ROW_TAG = "Row";
    public static final int RETRIES = 3;
    private final AlmaAnalyticsService almaAnalyticsService;

    public AlmaAnalyticsHelper(AlmaAnalyticsService almaAnalyticsService) {
        this.almaAnalyticsService = almaAnalyticsService;
    }

    private static final String NAMESPACE = " xmlns:saw=\"com.siebel.analytics.web/report/v1.1\" "
            + "xmlns:sawx=\"com.siebel.analytics.web/expression/v1.1\" "
            + "xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" "
            + "xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" ";


    public static String createSingleValueFilter(String valueType, String value, String field, String operation,
                                                 String operationType) {
        return "<sawx:expr xsi:type=\"sawx:" + operationType + "\" op=\"" + operation + "\" " + NAMESPACE + ">"
                + "<sawx:expr xsi:type=\"sawx:sqlExpression\">"
                + field
                + "</sawx:expr> "
                + "<sawx:expr xsi:type=\"xsd:" + valueType + "\">"
                + value + "</sawx:expr> "
                + "</sawx:expr>";
    }

    public static String createSingleValueFilter(String id, String field, String operation) {
        return "<sawx:expr xsi:type=\"sawx:comparison\" op=\"" + operation
                + "\" xmlns:saw=\"com.siebel.analytics.web/report/v1.1\" "
                + "xmlns:sawx=\"com.siebel.analytics.web/expression/v1.1\" "
                + "xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" "
                + "xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\"> <sawx:expr xsi:type=\"sawx:sqlExpression\">"
                + field
                + "</sawx:expr> "
                + "<sawx:expr xsi:type=\"xsd:string\">"
                + id
                + "</sawx:expr> "
                + "</sawx:expr>";
    }

    public static String createValueFilter(String valueType, String value1, String value2, String field,
                                           String operation, String operationType) {
        return "<sawx:expr xsi:type=\"sawx:" + operationType + "\" op=\"" + operation + "\" " + NAMESPACE + ">"
                + "<sawx:expr xsi:type=\"sawx:sqlExpression\">"
                + field
                + "</sawx:expr> "
                + "<sawx:expr xsi:type=\"xsd:" + valueType + "\">" + value1 + "</sawx:expr> "
                + "<sawx:expr xsi:type=\"xsd:" + valueType + "\">" + value2 + "</sawx:expr> "
                + "</sawx:expr>";
    }

    public static String createOperatorFilter(String operation, String anotherFilter) {
        return "<sawx:expr xsi:type=\"sawx:logical\" op=\"" + operation + "\" " + NAMESPACE + ">"
                + anotherFilter
                + "</sawx:expr>";
    }

    public List<Map<String, String>> retrieveAnalyticsReport(String reportPath, String filter) {
        List<Map<String, String>> report = new ArrayList<>();
        boolean finished = false;
        String token = "";
        int errorCount = 0;
        while (!finished && report.size() < REPORT_SIZE) {
            String response = almaAnalyticsService.getAnalyticsReport(reportPath, filter, token);
            DocumentBuilder db;
            try {
                db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
                InputSource is = new InputSource();
                is.setCharacterStream(new StringReader(response));
                Document doc = db.parse(is);
                NodeList queryResultElements = doc.getElementsByTagName(QUERY_RESULT_TAG);
                Element result = (Element) queryResultElements.item(0);
                NodeList finishedElementNodeList = result.getElementsByTagName(FINISHED_TAG);
                if (finishedElementNodeList.getLength() > 0) {
                    finished = Boolean.parseBoolean(finishedElementNodeList.item(0).getTextContent());
                } else {
                    finished = true;
                }
                if (token.equals("")) {
                    NodeList tokenNodeList = doc.getElementsByTagName(RESUMPTION_TOKEN_TAG);
                    if (tokenNodeList.getLength() > 0) {
                        token = tokenNodeList.item(0).getTextContent();
                    }
                }
                NodeList rowSet = result.getElementsByTagName(ROWSET_TAG);
                if (rowSet.getLength() > 0) {
                    NodeList rowList = ((Element) rowSet.item(0)).getElementsByTagName(ROW_TAG);
                    for (int i = 0; i < rowList.getLength(); i++) {
                        Element row = (Element) rowList.item(i);
                        NodeList childNodes = row.getChildNodes();
                        Map<String, String> rowMap = new LinkedHashMap<>();
                        report.add(rowMap);
                        for (int j = 0; j < childNodes.getLength(); j++) {
                            Node childNode = childNodes.item(j);
                            if (childNode.getNodeType() == Node.ELEMENT_NODE) {
                                Element column = (Element) childNode;
                                rowMap.put(column.getNodeName(), column.getTextContent());
                            }
                        }
                    }
                } else if (!finished) {  //Often ALMA REST API returns a HTTP response code 200 with no results.
                    if (errorCount++ >= RETRIES) {
                        log.error("Looping over empty results. Aborting");
                        return report;
                    }
                }
            } catch (ParserConfigurationException | SAXException | IOException e) {
                finished = false;
                if (errorCount++ >= RETRIES) {
                    log.error("Error getting report from Analytics", e);
                    break;
                }
            }
        }
        return report;
    }
}
