package no.unit.alma.bibs;

import org.glassfish.jersey.client.JerseyClientBuilder;
import org.junit.jupiter.api.Test;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

import no.unit.alma.commons.AlmaClient;

public class AlmaBibsIntegrationTest {

    private static final String bibIdentifier = "99939650000541";

    @Test
    void testGetBib() {
        System.setProperty("java.net.preferIPv4Stack", "true");
        Config config = ConfigFactory.defaultReference();
        AlmaBibsService almaBibsService =
                new AlmaBibsService(new AlmaClient(JerseyClientBuilder.newClient(), config, "zz"));
        System.out.println("alma bibs service setup...");
        almaBibsService.getBib(bibIdentifier, "");
    }

}
