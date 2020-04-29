package no.unit.alma.analytics;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import no.unit.alma.commons.AlmaClient;
import org.glassfish.jersey.client.JerseyClientBuilder;
import org.junit.jupiter.api.Test;

import java.io.UnsupportedEncodingException;

public class AlmaAnayticsIntegrationTest {

    final String reportPath = "/shared/Community/Reports/Shared Reports/Reports/Industry Standard Reports - BIBSYS/Legal Deposit/HistoryVersion2";
    String filter = "<sawx:expr xsi:type=\"sawx:logical\" op=\"and\"  xmlns:saw=\"com.siebel.analytics.web/report/v1.1\" xmlns:sawx=\"com.siebel.analytics.web/expression/v1.1\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" ><sawx:expr xsi:type=\"sawx:logical\" op=\"and\"  xmlns:saw=\"com.siebel.analytics.web/report/v1.1\" xmlns:sawx=\"com.siebel.analytics.web/expression/v1.1\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" ><sawx:expr xsi:type=\"sawx:comparison\" op=\"between\"  xmlns:saw=\"com.siebel.analytics.web/report/v1.1\" xmlns:sawx=\"com.siebel.analytics.web/expression/v1.1\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" ><sawx:expr xsi:type=\"sawx:sqlExpression\">\"Physical Item Details\".\"Expected Arrival Date\"</sawx:expr> <sawx:expr xsi:type=\"xsd:dateTime\">2019-12-29T00:00:00</sawx:expr> <sawx:expr xsi:type=\"xsd:dateTime\">2020-04-29T23:59:59</sawx:expr> </sawx:expr></sawx:expr><sawx:expr xsi:type=\"sawx:comparison\" op=\"null\"  xmlns:saw=\"com.siebel.analytics.web/report/v1.1\" xmlns:sawx=\"com.siebel.analytics.web/expression/v1.1\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" ><sawx:expr xsi:type=\"sawx:sqlExpression\">\"Physical Item Details\".\"Receiving   Date\"</sawx:expr> <sawx:expr xsi:type=\"xsd:string\"></sawx:expr> </sawx:expr></sawx:expr>";

    //@Test
    void testGetAnalyticsReport() throws UnsupportedEncodingException {
        Config config = ConfigFactory.defaultReference();
        AlmaAnalyticsService almaAnalyticsService =
                new AlmaAnalyticsService(new AlmaClient(JerseyClientBuilder.newClient(), config, "guest"));
        String result = almaAnalyticsService.getAnalyticsReport(reportPath, filter, "");
        System.out.println(result);
        assert (result.length() > 0);
    }
}


