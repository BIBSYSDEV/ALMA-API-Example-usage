package no.unit.alma.analytics;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import no.unit.alma.commons.AlmaClient;
import org.glassfish.jersey.client.JerseyClientBuilder;
import org.junit.jupiter.api.Test;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.ResponseProcessingException;

import java.io.UnsupportedEncodingException;

import static org.junit.jupiter.api.Assertions.fail;

public class AlmaAnayticsIntegrationTest {

    final String ANALYTICS_PATH = "/shared/Community/Reports/Shared Reports/Reports/Industry Standard Reports - BIBSYS/Legal Deposit/HistoryVersion2";

    @Test
    void testGetAnalyticsReport() {
        Config config = ConfigFactory.defaultReference();
        AlmaAnalyticsService almaAnalyticsService =
                new AlmaAnalyticsService(new AlmaClient(JerseyClientBuilder.newClient(), config, "guest"));
        try {
            Entity response = almaAnalyticsService.getAnalyticsReport(ANALYTICS_PATH, "");
            System.out.println(response.toString());
        } catch (ResponseProcessingException | UnsupportedEncodingException err) {
            System.out.println("ERR");
            System.out.println(err);
            fail();
        }
        System.out.println("OK");
    }
}


