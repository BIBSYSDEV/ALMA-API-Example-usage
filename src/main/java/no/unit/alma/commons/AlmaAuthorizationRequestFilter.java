package no.unit.alma.commons;

import java.io.IOException;

import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientRequestFilter;

public class AlmaAuthorizationRequestFilter implements ClientRequestFilter {

    private final transient VaultApiAuthorization apiAuthorization;

    public AlmaAuthorizationRequestFilter(VaultApiAuthorization apiAuthorization) {
        this.apiAuthorization = apiAuthorization;
    }

    @Override
    public void filter(ClientRequestContext clientRequestContext) throws IOException {
        if (clientRequestContext == null || clientRequestContext.getHeaders() == null || apiAuthorization == null) {
            String errMsg =
                    String.format("Failed to add Authorization header to Alma request.\nMethod %s\nUri %s",
                            clientRequestContext.getMethod(), clientRequestContext.getUri().toString());
            throw new IOException(errMsg);
        }

        clientRequestContext.getHeaders().add("Authorization", apiAuthorization.asApiKey());
    }
}
