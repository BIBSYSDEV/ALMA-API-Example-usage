package no.unit.alma.analytics;

import no.unit.alma.acquisitions.AlmaVendorsService;
import no.unit.alma.commons.AlmaClient;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AlmaAnalyticsServiceTest {

    private static final String CONTEXT = "exampleContext";
    private static final String CONTEXT_VALUE = "exampleContextValue";
    private static final String STAGE = "alma-sandbox2";

    @Mock
    private AlmaClient mockAlmaApiClient;
    @Mock
    private WebTarget webTarget;
    @Mock
    private Invocation.Builder builder;
    @Mock
    private Response response;

    @Test
    void testGetVendor() {
        String returnString = "result";
        mockAlmaApi();
        when(webTarget.path(anyString())).thenReturn(webTarget);
        when(webTarget.queryParam(anyString(), any())).thenReturn(webTarget);
        when(webTarget.request()).thenReturn(builder);
        when(builder.accept(anyString())).thenReturn(builder);
        when(builder.get()).thenReturn(response);
        when(response.readEntity(String.class)).thenReturn(returnString);

        AlmaAnalyticsService almaAnalyticsService =
                new AlmaAnalyticsService(mockAlmaApiClient);
        String result = almaAnalyticsService.getAnalyticsReport("anyString", "anyString", "anyString");
        assertEquals(result, returnString);
    }


    @Test
    void testGetContext() {
        mockAlmaApi();
        AlmaVendorsService almaVendorsService =
                new AlmaVendorsService(mockAlmaApiClient);
        assertEquals(CONTEXT, almaVendorsService.getContext());
    }

    @Test
    void testGetContextValue() {
        mockAlmaApi();
        AlmaVendorsService almaVendorsService =
                new AlmaVendorsService(mockAlmaApiClient);
        assertEquals(CONTEXT_VALUE, almaVendorsService.getContextValue());
    }

    private void mockAlmaApi() {
        when(this.mockAlmaApiClient.getWebTarget())
                .thenReturn(webTarget);
        when(mockAlmaApiClient.getAlmaStage()).thenReturn(STAGE);
        when(mockAlmaApiClient.getContext()).thenReturn(CONTEXT);
        when(mockAlmaApiClient.getContextValue()).thenReturn(CONTEXT_VALUE);
    }


}