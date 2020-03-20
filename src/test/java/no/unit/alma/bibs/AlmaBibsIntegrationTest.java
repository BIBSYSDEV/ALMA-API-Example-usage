package no.unit.alma.bibs;

import org.glassfish.jersey.client.JerseyClientBuilder;
import org.junit.jupiter.api.Test;

import no.unit.alma.commons.AlmaServiceFactory;
import no.unit.alma.commons.AlmaStage;

public class AlmaBibsIntegrationTest {

    private static final AlmaServiceFactory almaServiceFactory =
            new AlmaServiceFactory(JerseyClientBuilder.newClient());
    private static final String bibIdentifier = "99939650000541";

    @Test
    void testGetBib() {
        System.setProperty("java.net.preferIPv4Stack", "true");
        AlmaBibsService almaBibsService = almaServiceFactory.getAlmaBibs("zz", AlmaStage.SANDBOX2);
        System.out.println("alma bibs service setup...");
        almaBibsService.getBib(bibIdentifier, "");
    }

}
