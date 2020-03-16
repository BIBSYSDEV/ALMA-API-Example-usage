package no.unit.alma.commons;

import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientRequestFilter;
import java.io.IOException;


public class AlmaAuthorizationRequestFilter implements ClientRequestFilter {


    private final VaultApiAuthorization apiAuthorization;

    public AlmaAuthorizationRequestFilter(VaultApiAuthorization apiAuthorization) {
        this.apiAuthorization = apiAuthorization;
    }

    @Override
    public void filter(ClientRequestContext clientRequestContext) throws IOException {
        try {
            clientRequestContext.getHeaders().add("Authorization", apiAuthorization.asAPIKey());
        } catch (NullPointerException npe) {
            String errMsg = String.format("Failed to add Authorization header to Alma request.\nMethod %s\nUri %s",
                clientRequestContext.getMethod(), clientRequestContext.getUri().toString());
            throw new IOException(errMsg, npe);
        }
    }
}
