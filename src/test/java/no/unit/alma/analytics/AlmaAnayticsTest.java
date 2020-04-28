package no.unit.alma.analytics;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AlmaAnayticsTest {

    final String reportPath = "/shared/Community/Reports/Shared Reports/Reports/Industry Standard Reports - BIBSYS/Legal Deposit/HistoryVersion2";

    @Mock
    AlmaAnalyticsService almaAnalyticsService;


    @Test
    void testGetAnalyticsReport() throws UnsupportedEncodingException {
        AlmaAnalyticsHelper almaAnalyticsHelper = new AlmaAnalyticsHelper(almaAnalyticsService);
        String mockedResponse = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                "    <report>\n" +
                "        <QueryResult>\n" +
                "            <IsFinished>true</IsFinished>\n" +
                "            <ResultXml>\n" +
                "              <rowset xmlns=\"urn:schemas-microsoft-com:xml-analysis:rowset\">\n" +
                "                <Row>\n" +
                "                  <Column0>0</Column0>\n" +
                "                  <Column1>9788230013762; 8230013764</Column1>\n" +
                "                  <Column3>Book</Column3>\n" +
                "                  <Column4>999919809503102205</Column4>\n" +
                "                  <Column6>Thembalethu</Column6>\n" +
                "                  <Column8>None</Column8>\n" +
                "                  <Column9>LEGAL_DEPOSIT</Column9>\n" +
                "                  <Column10>Yes</Column10>\n" +
                "                  <Column11>ACTIVE</Column11>\n" +
                "                  <Column12>pl_5298</Column12>\n" +
                "                  <Column13>Forlagssentralen ANS</Column13>\n" +
                "                  <Column14>2015</Column14>\n" +
                "                  <Column15>1</Column15>\n" +
                "                </Row>\n" +
                "                <Row>\n" +
                "                  <Column0>0</Column0>\n" +
                "                  <Column1>9788230013762; 8230013764</Column1>\n" +
                "                  <Column3>Book</Column3>\n" +
                "                  <Column4>999919816913402204</Column4>\n" +
                "                  <Column6>Thembalethu</Column6>\n" +
                "                  <Column8>None</Column8>\n" +
                "                  <Column9>LEGAL_DEPOSIT</Column9>\n" +
                "                  <Column10>Yes</Column10>\n" +
                "                  <Column11>ACTIVE</Column11>\n" +
                "                  <Column12>pl_5298</Column12>\n" +
                "                  <Column13>Forlagssentralen ANS</Column13>\n" +
                "                  <Column14>2015</Column14>\n" +
                "                  <Column15>1</Column15>\n" +
                "                </Row>\n" +
                "              </rowset>\n" +
                "            </ResultXml>\n" +
                "        </QueryResult>\n" +
                "    </report>";
        when(almaAnalyticsService.getAnalyticsReport(anyString(), anyString(), anyString())).thenReturn(mockedResponse);
        List<Map<String, String>> test = almaAnalyticsHelper.retrieveAnalyticsReport(reportPath, "");
        System.out.println(test.size());
        assert (test.size() == 2);
        //TODO: null-values, resumptiontoken, errors, wrong format, etc...
    }
}


