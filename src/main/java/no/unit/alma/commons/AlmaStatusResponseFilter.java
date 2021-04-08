package no.unit.alma.commons;

import no.unit.alma.generated.error.WebServiceResult;
import org.apache.commons.lang3.StringUtils;

import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientResponseContext;
import javax.ws.rs.client.ClientResponseFilter;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response.Status.Family;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;


public class AlmaStatusResponseFilter implements ClientResponseFilter {

    private static final Logger log = Logger.getLogger(AlmaStatusResponseFilter.class.getName());

    public static final String API_KEY_ = "apikey ";
    public static final String STAR_MASK = "********************************";

    @Override
    public void filter(ClientRequestContext clientRequestContext,
                       ClientResponseContext clientResponseContext) throws IOException {

        String authorization = clientRequestContext.getHeaders().get("Authorization").toString();
        if (authorization.contains(API_KEY_)) {
            String toMask = authorization.substring(API_KEY_.length() + 1, authorization.length() - 5);
            authorization = authorization.replace(toMask, STAR_MASK);
        }
        log.log(Level.INFO, clientRequestContext.getMethod());
        log.log(Level.INFO, clientRequestContext.getUri().toString());
        log.log(Level.INFO, authorization);

        if (clientResponseContext.getStatusInfo().getFamily() != Family.SUCCESSFUL) {
            String responseBody = unmarshalResponseEntity(clientResponseContext);
            log.log(Level.SEVERE, String.format("Response from alma is marked as unsuccessful.\nUri: {}\nMethod: {}\nResponse code: {}",
                clientRequestContext.getUri(), clientRequestContext.getMethod(), clientResponseContext.getStatus()));
            MediaType mediaType = clientResponseContext.getMediaType();
            WebServiceResult webServiceResult =
                    MediaType.APPLICATION_XML_TYPE.getType().equals(mediaType.getType())
                            && MediaType.APPLICATION_XML_TYPE.getSubtype().equals(mediaType.getSubtype())
                            ? unmarshalWebServiceResult(responseBody)
                            : null;

            throw new HttpStatusException(clientResponseContext.getStatus(),
                    clientResponseContext.getStatusInfo().getReasonPhrase(),
                    clientRequestContext.getMethod(),
                    clientRequestContext.getUri().toString(),
                    responseBody,
                    webServiceResult
            );
        }
    }

    private WebServiceResult unmarshalWebServiceResult(String xmlEntity) {
        if (StringUtils.isEmpty(xmlEntity)) {
            log.log(Level.SEVERE, "Xml entity is empty. Skipping");
            return null;
        }
        try (StringReader reader = new StringReader(xmlEntity)) {
            JAXBContext jaxbContext = JAXBContext.newInstance(WebServiceResult.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            return (WebServiceResult) unmarshaller.unmarshal(reader);
        } catch (JAXBException e) {
            log.log(Level.SEVERE, "Failed to unmarshal xml entity", e);
            return null;
        }
    }

    private String unmarshalResponseEntity(ClientResponseContext clientResponseContext) {
        if (!clientResponseContext.hasEntity()) {
            return null;
        }
        try (InputStream entityStream = clientResponseContext.getEntityStream()) {
            return new BufferedReader(new InputStreamReader(entityStream))
                    .lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            log.log(Level.SEVERE, "Failed to unmarshal error message body from alma", e);
            return null;
        }
    }


}
