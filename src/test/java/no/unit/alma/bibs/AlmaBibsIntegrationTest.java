package no.unit.alma.bibs;

import org.glassfish.jersey.client.JerseyClientBuilder;
import org.junit.jupiter.api.Test;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

import no.unit.alma.commons.AlmaClient;

public class AlmaBibsIntegrationTest {

    private static final String bibIdentifier = "991334666044702202";

    @Test
    void testGetBib() {
        Config config = ConfigFactory.defaultReference();
        AlmaBibsService almaBibsService =
                new AlmaBibsService(new AlmaClient(JerseyClientBuilder.newClient(), config, "guest"));
        System.out.println("alma bibs service setup...");
        almaBibsService.getBib(bibIdentifier, "");
    }

}
