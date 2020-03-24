package no.unit.alma.user;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import javax.ws.rs.client.WebTarget;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import no.unit.alma.commons.AlmaClient;
import no.unit.alma.commons.AlmaStage;

@ExtendWith(MockitoExtension.class)
class AlmaUsersServiceImplementationTest {

    private static final String CONTEXT = "exampleContext";
    private static final String CONTEXT_VALUE = "exampleContextValue";
    private static final AlmaStage STAGE = AlmaStage.SANDBOX2;

    @Mock
    AlmaClient mockAlmaApiClient;

    @Mock
    WebTarget webTarget;

    @Test
    void testGetAlmaStage() {
        mockAlmaApi();
        AlmaUsersServiceImplementation almaBibsService =
                new AlmaUsersServiceImplementation(mockAlmaApiClient);
        assertEquals(STAGE.getVaultAlmaStageName(), almaBibsService
                .getAlmaStage().getVaultAlmaStageName());
    }

    @Test
    void testGetContext() {
        mockAlmaApi();
        AlmaUsersServiceImplementation almaBibsService =
                new AlmaUsersServiceImplementation(mockAlmaApiClient);
        assertEquals(CONTEXT, almaBibsService.getContext());
    }

    @Test
    void testGetContextValue() {
        mockAlmaApi();
        AlmaUsersServiceImplementation almaBibsService =
                new AlmaUsersServiceImplementation(mockAlmaApiClient);
        assertEquals(CONTEXT_VALUE, almaBibsService.getContextValue());
    }

    private void mockAlmaApi() {

        when(mockAlmaApiClient.getWebTarget())
                .thenReturn(webTarget);
        when(mockAlmaApiClient.getAlmaStage()).thenReturn(STAGE);
        when(mockAlmaApiClient.getContext()).thenReturn(CONTEXT);
        when(mockAlmaApiClient.getContextValue()).thenReturn(CONTEXT_VALUE);
    }

}
