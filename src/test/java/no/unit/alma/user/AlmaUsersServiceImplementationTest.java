package no.unit.alma.user;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import javax.ws.rs.client.WebTarget;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import no.unit.alma.commons.AlmaClient;

@ExtendWith(MockitoExtension.class)
class AlmaUsersServiceImplementationTest {

    private static final String CONTEXT = "exampleContext";
    private static final String CONTEXT_VALUE = "exampleContextValue";

    @Mock
    AlmaClient mockAlmaApiClient;

    @Mock
    WebTarget webTarget;

    @Test
    void testGetContext() {
        mockAlmaApi();
        AlmaUsersService almaBibsService =
                new AlmaUsersService(mockAlmaApiClient);
        assertEquals(CONTEXT, almaBibsService.getContext());
    }

    @Test
    void testGetContextValue() {
        mockAlmaApi();
        AlmaUsersService almaBibsService =
                new AlmaUsersService(mockAlmaApiClient);
        assertEquals(CONTEXT_VALUE, almaBibsService.getContextValue());
    }

    private void mockAlmaApi() {

        when(mockAlmaApiClient.getWebTarget())
                .thenReturn(webTarget);
        when(mockAlmaApiClient.getContext()).thenReturn(CONTEXT);
        when(mockAlmaApiClient.getContextValue()).thenReturn(CONTEXT_VALUE);
    }

}
