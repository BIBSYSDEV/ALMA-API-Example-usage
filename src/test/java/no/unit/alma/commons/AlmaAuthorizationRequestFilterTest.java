package no.unit.alma.commons;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AlmaAuthorizationRequestFilterTest {

    public static final String METHOD = "METHOD";
    public static final String URI = "http://unit.no";
    @Mock
    VaultApiAuthorization mockVaultApiAuthorization;

    @Test
    void testFilterThrowsIOException() throws URISyntaxException {
        AlmaAuthorizationRequestFilter mockFilter = new AlmaAuthorizationRequestFilter(mockVaultApiAuthorization);
        ClientRequestContext clientRequestContext = mock(ClientRequestContext.class);
        when(clientRequestContext.getMethod()).thenReturn(METHOD);
        when(clientRequestContext.getUri()).thenReturn(new URI(URI));
        assertThrows(IOException.class, () -> mockFilter.filter(clientRequestContext));
    }

    @Test
    void testFilterClientIsNull() {
        AlmaAuthorizationRequestFilter mockFilter = new AlmaAuthorizationRequestFilter(mockVaultApiAuthorization);
        assertThrows(IOException.class, () -> mockFilter.filter(null));
    }

    @Test
    void testFilterApiAuthorizationIsNull() throws URISyntaxException {
        AlmaAuthorizationRequestFilter mockFilter = new AlmaAuthorizationRequestFilter(null);
        MultivaluedHashMap<String, Object> headers = new MultivaluedHashMap<>();
        ClientRequestContext clientRequestContext = mock(ClientRequestContext.class);
        when(clientRequestContext.getHeaders()).thenReturn(headers);
        when(clientRequestContext.getMethod()).thenReturn(METHOD);
        when(clientRequestContext.getUri()).thenReturn(new URI(URI));
        assertThrows(IOException.class, () -> mockFilter.filter(clientRequestContext));
    }

    @Test
    void testFilter() throws IOException {
        AlmaAuthorizationRequestFilter mockFilter = new AlmaAuthorizationRequestFilter(mockVaultApiAuthorization);
        ClientRequestContext clientRequestContext = mock(ClientRequestContext.class);
        MultivaluedHashMap<String, Object> headers = new MultivaluedHashMap<>();
        when(clientRequestContext.getHeaders()).thenReturn(headers);
        mockFilter.filter(clientRequestContext);
        assertTrue(clientRequestContext.getHeaders().size() > 0);
    }

}
