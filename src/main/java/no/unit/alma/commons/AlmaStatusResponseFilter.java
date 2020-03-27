package no.unit.alma.commons;

import com.google.gson.Gson;
import no.unit.alma.generated.error.WebServiceResult;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientResponseContext;
import javax.ws.rs.client.ClientResponseFilter;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response.Status.Family;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;


public class AlmaStatusResponseFilter implements ClientResponseFilter {

    private static final transient Logger log = LoggerFactory.getLogger(AlmaStatusResponseFilter.class);

    @Override
    public void filter(ClientRequestContext clientRequestContext,
                       ClientResponseContext clientResponseContext) throws IOException {
        if (clientResponseContext.getStatusInfo().getFamily() != Family.SUCCESSFUL) {
            log.trace("Response from alma is marked as unsuccessful.\nUri: {}\nMethod: {}\nResponse code: {}",
                clientRequestContext.getUri(), clientRequestContext.getMethod(), clientResponseContext.getStatus());

            String responseBody = unmarshalResponseEntity(clientResponseContext);
            MediaType mediaType = clientResponseContext.getMediaType();
            WebServiceResult webServiceResult =
                    (MediaType.APPLICATION_JSON_TYPE.getType().equals(mediaType.getType())
                            && MediaType.APPLICATION_JSON_TYPE.getSubtype().equals(mediaType.getSubtype()))
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

    private WebServiceResult unmarshalWebServiceResult(String jsonEntity) {
        if (StringUtils.isEmpty(jsonEntity)) {
            log.warn("Xml entity is empty. Skipping");
            return null;
        }
        return new Gson().fromJson(jsonEntity, WebServiceResult.class);
    }

    private String unmarshalResponseEntity(ClientResponseContext clientResponseContext) {
        if (!clientResponseContext.hasEntity()) {
            return null;
        }
        try (InputStream entityStream = clientResponseContext.getEntityStream()) {
            return new BufferedReader(new InputStreamReader(entityStream))
                .lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            log.error("Failed to unmarshal error message body from alma", e);
            return null;
        }
    }


}
