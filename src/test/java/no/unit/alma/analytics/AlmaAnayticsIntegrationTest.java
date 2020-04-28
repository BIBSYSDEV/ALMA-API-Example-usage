package no.unit.alma.analytics;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import no.unit.alma.commons.AlmaClient;
import org.glassfish.jersey.client.JerseyClientBuilder;
import org.junit.jupiter.api.Test;

import java.io.UnsupportedEncodingException;

public class AlmaAnayticsIntegrationTest {

    final String reportPath = "/shared/Community/Reports/Shared Reports/Reports/Industry Standard Reports - BIBSYS/Legal Deposit/HistoryVersion2";

    @Test
    void testGetAnalyticsReport() throws UnsupportedEncodingException {
        Config config = ConfigFactory.defaultReference();
        AlmaAnalyticsService almaAnalyticsService =
                new AlmaAnalyticsService(new AlmaClient(JerseyClientBuilder.newClient(), config, "guest"));
        String result = almaAnalyticsService.getAnalyticsReport(reportPath, "", "");
        assert (result.length() > 0);
    }
}


