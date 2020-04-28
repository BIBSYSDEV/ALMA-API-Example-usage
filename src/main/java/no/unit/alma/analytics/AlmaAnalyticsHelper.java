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
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class AlmaAnalyticsHelper {

    private static final transient Logger log = LoggerFactory.getLogger(AlmaAnalyticsService.class);

    //static final int REPORT_SIZE = 65_000;
    static final int REPORT_SIZE = 1_500;
    private final AlmaAnalyticsService almaAnalyticsService;

    public AlmaAnalyticsHelper(AlmaAnalyticsService almaAnalyticsService) {
        this.almaAnalyticsService = almaAnalyticsService;
    }

    private static final String NAMESPACE = " xmlns:saw=\"com.siebel.analytics.web/report/v1.1\" "
            + "xmlns:sawx=\"com.siebel.analytics.web/expression/v1.1\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" "
            + "xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" ";


    public static String createSingleValueFilter(String valueType, String value, String field, String operation, String operationType) {
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

    public static String createValueFilter(String valueType, String value1, String value2, String field, String operation, String operationType) {
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
        //TODO: trengs dette ?
        //            path = URLEncoder.encode(path, UTF_8);
        //            filter = URLEncoder.encode(filter, UTF_8);
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
                NodeList queryResultElements = doc.getElementsByTagName("QueryResult");
                Element result = (Element) queryResultElements.item(0);
                NodeList finishedElementNodeList = result.getElementsByTagName("IsFinished");
                if (finishedElementNodeList.getLength() > 0) {
                    finished = Boolean.valueOf(finishedElementNodeList.item(0).getTextContent());
                } else {
                    finished = true;
                }
                if (token.equals("")) {
                    NodeList tokenNodeList = doc.getElementsByTagName("ResumptionToken");
                    if (tokenNodeList.getLength() > 0) {
                        token = tokenNodeList.item(0).getTextContent();
                    }
                }
                NodeList rowset = result.getElementsByTagName("rowset");
                if (rowset.getLength() > 0) {
                    NodeList rowList = ((Element) rowset.item(0)).getElementsByTagName("Row");
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
                }
            } catch (ParserConfigurationException | SAXException | IOException e) {
                finished = false;
                if (errorCount++ > 3) {
                    log.error("Error getting report from Analytics", e);
                    break;
                }
            }
        }
        return report;
    }

 /* Often ALMA REST API Analytics fails even with a HTTP response code 200.

    Here is the typical invalid response where it says an empty ResultXml,
     IsFinished is false and with a resumptionToken :
    <report>
        <QueryResult>
            <ResumptionToken>5514B8CE1BB0CBF68781B2DB54F0135132BD803B68E1925014B279344854
            0607967A74E50AECA3074E758E52BBB76CA1677D3AD05EDC3CA7F06182E34E9D7A2F</ResumptionToken>
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

}
