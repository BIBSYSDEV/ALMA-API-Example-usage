package no.unit.alma.analytics;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AlmaAnalyticsHelperTest {

    @Mock
    AlmaAnalyticsService almaAnalyticsService;

    @Test
    void testGetAnalyticsReport() throws IOException {
        AlmaAnalyticsHelper almaAnalyticsHelper = new AlmaAnalyticsHelper(almaAnalyticsService);
        String mockedResponse = readMockedResponseFromFile("analytics_response_valid.xml");
        when(almaAnalyticsService.getAnalyticsReport(anyString(), anyString(), anyString())).thenReturn(mockedResponse);
        List<Map<String, String>> response = almaAnalyticsHelper.retrieveAnalyticsReport("somePath", "someFilter");
        assertEquals(2, response.size());
    }

    @Test
    void testGetAnalyticsReportTagMissing() throws IOException {
        AlmaAnalyticsHelper almaAnalyticsHelper = new AlmaAnalyticsHelper(almaAnalyticsService);
        String mockedResponse = readMockedResponseFromFile("analytics_response_valid_finished_missing.xml");
        when(almaAnalyticsService.getAnalyticsReport(anyString(), anyString(), anyString())).thenReturn(mockedResponse);
        List<Map<String, String>> response = almaAnalyticsHelper.retrieveAnalyticsReport("somePath", "someFilter");
        assertEquals(2, response.size());
    }

    @Test
    void testGetAnalyticsReportWithPagination() throws IOException {
        AlmaAnalyticsHelper almaAnalyticsHelper = new AlmaAnalyticsHelper(almaAnalyticsService);
        String mockedResponse1 = readMockedResponseFromFile("analytics_response_valid_first_page.xml");
        String mockedResponse2 = readMockedResponseFromFile("analytics_response_valid_last_page.xml");
        when(almaAnalyticsService.getAnalyticsReport(anyString(), anyString(), anyString()))
            .thenReturn(mockedResponse1)
            .thenReturn(mockedResponse2);
        List<Map<String, String>> response2 = almaAnalyticsHelper.retrieveAnalyticsReport("somePath", "someFilter");
        assertEquals(123, response2.size());

    }

    @Test
    void testGetInvalidAnalyticsReport() throws IOException {
        AlmaAnalyticsHelper almaAnalyticsHelper = new AlmaAnalyticsHelper(almaAnalyticsService);
        String mockedResponse = readMockedResponseFromFile("analytics_response_invalid.xml");
        when(almaAnalyticsService.getAnalyticsReport(anyString(), anyString(), anyString())).thenReturn(mockedResponse);
        List<Map<String, String>> response = almaAnalyticsHelper.retrieveAnalyticsReport("any string", "any string");
        assert (response.size() == 0);
    }


    @Test
    void testGetCrashedAnalyticsReport() throws IOException {
        AlmaAnalyticsHelper almaAnalyticsHelper = new AlmaAnalyticsHelper(almaAnalyticsService);
        String mockedResponse = readMockedResponseFromFile("analytics_response_really_invalid.xml");
        when(almaAnalyticsService.getAnalyticsReport(anyString(), anyString(), anyString())).thenReturn(mockedResponse);
        List<Map<String, String>> response = almaAnalyticsHelper.retrieveAnalyticsReport("any string", "any string");
        assert (response.size() == 0);
    }

    @Test
    void testCreateFilterMethodsExistsAndReturnsSomething() {
        String result1 = AlmaAnalyticsHelper.createOperatorFilter("", "");
        assert (result1.contains("<sawx"));
        String result2 = AlmaAnalyticsHelper.createSingleValueFilter("", "", "");
        assert (result2.contains("<sawx"));
        String result3 = AlmaAnalyticsHelper.createSingleValueFilter("", "", "");
        assert (result3.contains("<sawx"));
        String result4 = AlmaAnalyticsHelper.createSingleValueFilter("", "", "", "", "");
        assert (result4.contains("<sawx"));
        String result5 = AlmaAnalyticsHelper.createValueFilter("", "", "", "", "", "");
        assert (result5.contains("<sawx"));
    }


    private String readMockedResponseFromFile(String s) throws IOException {
        return new String(Objects.requireNonNull(getClass()
            .getClassLoader()
            .getResourceAsStream(s))
            .readAllBytes()
        );
    }

}



