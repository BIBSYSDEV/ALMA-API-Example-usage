package no.unit.alma.bibs;

import no.unit.alma.commons.HttpStatusException;
import no.unit.alma.generated.bibs.Bib;
import org.glassfish.jersey.client.JerseyClientBuilder;
import org.junit.jupiter.api.Test;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

import no.unit.alma.commons.AlmaClient;

import javax.ws.rs.client.ResponseProcessingException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.fail;

public class AlmaBibsIntegrationTest {

    private static final String bibIdentifier = "991334666044702202";
    private static final String bad_bibIdentifier = "999999999999999999";
    public static final String NOT_FOUND_ALMA_ERROR_CODE = "402203";
    public static final String NOT_FOUND_ALMA_ERROR_MESSAGE = "Input parameters mmsId %s is not valid.";

    @Test
    void testGetBib_not_found() {
        Config config = ConfigFactory.defaultReference();
        AlmaBibsService almaBibsService =
                new AlmaBibsService(new AlmaClient(JerseyClientBuilder.newClient(), config, "guest"));
        System.out.println("alma bibs service setup...");
        Bib bib = null;
        try {
            bib = almaBibsService.getBib(bad_bibIdentifier, "");
        } catch (ResponseProcessingException e) {
            if (e.getCause() instanceof HttpStatusException) {
                HttpStatusException httpStatusException = (HttpStatusException) e.getCause();
                if (httpStatusException.hasError()) {
                    System.out.println(String.format("%s : %s -- %s", httpStatusException.getAlmaErrorCode(),
                            httpStatusException.getAlmaErrorMessage(),
                            httpStatusException.getAlmaErrorTrackingId()));
                    assertEquals(NOT_FOUND_ALMA_ERROR_CODE, httpStatusException.getAlmaErrorCode());
                    assertEquals(String.format(NOT_FOUND_ALMA_ERROR_MESSAGE, bad_bibIdentifier),
                            httpStatusException.getAlmaErrorMessage());
                }
            } else {
                fail();
            }
        }
        assertNull(bib);
    }

}
