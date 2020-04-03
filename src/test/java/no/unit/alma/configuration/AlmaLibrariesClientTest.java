package no.unit.alma.configuration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import no.unit.alma.commons.AlmaClient;
import no.unit.alma.configuration.AlmaLibrariesService;
import no.unit.alma.generated.libraries.Libraries;
import no.unit.alma.generated.libraries.Library;

@ExtendWith(MockitoExtension.class)
class AlmaLibrariesClientTest {

    private static final String CONTEXT = "exampleContext";
    private static final String CONTEXT_VALUE = "exampleContextValue";
    private static final String STAGE = "alma-sandbox2";

    private static final Integer TOTAL_RECORD_COUNT = 1;
    private static final String LIBRARY_CODE = "library code";
    private static final String TEST_NAME = "library name";

    @Mock
    private AlmaClient mockAlmaApiClient;

    @Mock
    private WebTarget librariesWebTarget;

    @Mock
    private Builder librariesBuilder;

    @Mock
    private Invocation librariesInvocation;

    @BeforeEach
    void init() {
        mockAlmaApi();
    }

    @Test
    void testGetLibraries() {
        when(librariesWebTarget.path(any())).thenReturn(librariesWebTarget);
        when(librariesWebTarget.request()).thenReturn(librariesBuilder);
        when(librariesBuilder.accept(anyString())).thenReturn(librariesBuilder);
        when(librariesBuilder.buildGet()).thenReturn(librariesInvocation);
        Libraries tempLibraries = new Libraries();
        tempLibraries.setTotalRecordCount(TOTAL_RECORD_COUNT);
        when(librariesInvocation.invoke(Libraries.class)).thenReturn(tempLibraries);
        AlmaLibrariesService almaLibrariesService =
                new AlmaLibrariesService(mockAlmaApiClient);

        Libraries resultLibraries = almaLibrariesService.getLibraries();
        assertEquals(TOTAL_RECORD_COUNT, resultLibraries.getTotalRecordCount());

    }

    @Test
    void testGetLibrary() {
        when(librariesWebTarget.path(any())).thenReturn(librariesWebTarget);
        when(librariesWebTarget.request()).thenReturn(librariesBuilder);
        when(librariesBuilder.accept(anyString())).thenReturn(librariesBuilder);
        when(librariesBuilder.buildGet()).thenReturn(librariesInvocation);
        Library tempLibrary = new Library();
        tempLibrary.setName(TEST_NAME);
        when(librariesInvocation.invoke(Library.class)).thenReturn(tempLibrary);
        AlmaLibrariesService almaLibrariesService =
                new AlmaLibrariesService(mockAlmaApiClient);

        Library resultLibrary = almaLibrariesService.getLibrary(LIBRARY_CODE);
        assertEquals(TEST_NAME, resultLibrary.getName());
    }

    @Test
    void testGetAlmaStage() {
        AlmaLibrariesService almaLibrariesService =
                new AlmaLibrariesService(mockAlmaApiClient);
        assertEquals(STAGE, almaLibrariesService
                .getAlmaStage());
    }

    @Test
    void testGetContext() {
        AlmaLibrariesService almaLibrariesService =
                new AlmaLibrariesService(mockAlmaApiClient);
        assertEquals(CONTEXT, almaLibrariesService.getContext());
    }

    @Test
    void testGetContextValue() {
        AlmaLibrariesService almaLibrariesService =
                new AlmaLibrariesService(mockAlmaApiClient);
        assertEquals(CONTEXT_VALUE, almaLibrariesService.getContextValue());
    }

    private void mockAlmaApi() {

        when(mockAlmaApiClient.getWebTarget())
                .thenReturn(librariesWebTarget);
        when(mockAlmaApiClient.getAlmaStage()).thenReturn(STAGE);
        when(mockAlmaApiClient.getContext()).thenReturn(CONTEXT);
        when(mockAlmaApiClient.getContextValue()).thenReturn(CONTEXT_VALUE);
    }
}
