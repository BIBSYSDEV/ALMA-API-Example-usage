package no.unit.alma.partners;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import no.unit.alma.commons.AlmaClient;
import no.unit.alma.generated.partners.Partner;
import no.unit.alma.generated.partners.PartnerDetails;
import no.unit.alma.generated.partners.Partners;

@ExtendWith(MockitoExtension.class)
class AlmaPartnersServiceTest {

    private static final String TEST_ID = "123456";
    private static final String CONTEXT = "exampleContext";
    private static final String CONTEXT_VALUE = "exampleContextValue";
    public static final String EMPTY_STRING = "";

    @Mock
    private AlmaClient mockAlmaApiClient;
    @Mock
    private WebTarget webTarget;
    @Mock
    private Invocation.Builder builder;
    @Mock
    private Invocation invocation;
    @Mock
    Response response;

    @Test
    void testGetPartner() {
        mockAlmaApi();

        when(webTarget.path(any())).thenReturn(webTarget);
        when(webTarget.request()).thenReturn(builder);
        when(builder.accept(anyString())).thenReturn(builder);
        when(builder.buildGet()).thenReturn(invocation);
        Partner tempPartner = new Partner();
        PartnerDetails details = new PartnerDetails();
        details.setCode("test");
        tempPartner.setPartnerDetails(details);
        when(invocation.invoke((Class<Object>) any())).thenReturn(tempPartner);

        AlmaPartnersService almaPartnersService =
                new AlmaPartnersService(mockAlmaApiClient);
        Partner resultPartner = almaPartnersService.getPartner(TEST_ID);
        assertEquals(tempPartner.getPartnerDetails().getCode(), resultPartner.getPartnerDetails().getCode());
    }

    @Test
    void testDeletePartner() {
        mockAlmaApi();

        when(webTarget.path(any())).thenReturn(webTarget);
        when(webTarget.request()).thenReturn(builder);
        when(builder.accept(anyString())).thenReturn(builder);
        when(builder.buildDelete()).thenReturn(invocation);
        when(invocation.invoke()).thenReturn(response);
        doNothing().when(response).close();

        AlmaPartnersService almaPartnersService =
                new AlmaPartnersService(mockAlmaApiClient);
        almaPartnersService.deletePartner(TEST_ID);
    }

    @Test
    void testPostPartner() {
        mockAlmaApi();

        Partner partner = new Partner();
        PartnerDetails details = new PartnerDetails();
        details.setCode("test");
        partner.setPartnerDetails(details);

        when(webTarget.path(any())).thenReturn(webTarget);
        when(webTarget.request(anyString())).thenReturn(builder);
        when(builder.buildPost(Entity.xml(partner))).thenReturn(invocation);
        when(invocation.invoke((Class<Object>) any())).thenReturn(partner);

        AlmaPartnersService almaPartnersService =
                new AlmaPartnersService(mockAlmaApiClient);
        Partner resultPartner = almaPartnersService.postPartner(partner);
        assertEquals(partner.getPartnerDetails().getCode(), resultPartner.getPartnerDetails().getCode());

    }

    @Test
    void testUpdatePartner() {
        mockAlmaApi();

        Partner partner = new Partner();
        PartnerDetails details = new PartnerDetails();
        details.setCode("test");
        partner.setPartnerDetails(details);

        when(webTarget.path(any())).thenReturn(webTarget);
        when(webTarget.request(anyString())).thenReturn(builder);
        when(builder.accept(anyString())).thenReturn(builder);
        when(builder.buildPut(Entity.xml(partner))).thenReturn(invocation);
        when(invocation.invoke((Class<Object>) any())).thenReturn(partner);

        AlmaPartnersService almaPartnersService =
                new AlmaPartnersService(mockAlmaApiClient);
        Partner resultPartner = almaPartnersService.updatePartner(TEST_ID, partner);
        assertEquals(partner.getPartnerDetails().getCode(), resultPartner.getPartnerDetails().getCode());
    }

    @Test
    void testRetrievePartners() {
        mockAlmaApi();
        Partners partners = new Partners();
        partners.setTotalRecordCount(12);

        when(webTarget.queryParam(anyString(), any())).thenReturn(webTarget);
        when(webTarget.path(any())).thenReturn(webTarget);
        when(webTarget.request()).thenReturn(builder);
        when(builder.accept(anyString())).thenReturn(builder);
        when(builder.buildGet()).thenReturn(invocation);
        when(invocation.invoke((Class<Object>) any())).thenReturn(partners);

        AlmaPartnersService almaPartnersService = new AlmaPartnersService(mockAlmaApiClient);

        final int limit = 0;
        final int offset = 10;
        String status = "status";
        String emptyQueryString = "query";
        String type = "some_type";
        Partners resultPartners = almaPartnersService.retrievePartners(emptyQueryString, status, type, limit, offset);
        assertEquals(partners.getTotalRecordCount(), resultPartners.getTotalRecordCount());

        status = EMPTY_STRING;
        emptyQueryString = "query";
        type = "some_type";
        resultPartners = almaPartnersService.retrievePartners(emptyQueryString, status, type, limit, offset);
        assertEquals(partners.getTotalRecordCount(), resultPartners.getTotalRecordCount());

        status = EMPTY_STRING;
        emptyQueryString = EMPTY_STRING;
        type = "some_type";
        resultPartners = almaPartnersService.retrievePartners(emptyQueryString, status, type, limit, offset);
        assertEquals(partners.getTotalRecordCount(), resultPartners.getTotalRecordCount());

        status = EMPTY_STRING;
        emptyQueryString = EMPTY_STRING;
        type = EMPTY_STRING;
        resultPartners = almaPartnersService.retrievePartners(emptyQueryString, status, type, limit, offset);
        assertEquals(partners.getTotalRecordCount(), resultPartners.getTotalRecordCount());

        status = EMPTY_STRING;
        emptyQueryString = "query";
        type = EMPTY_STRING;
        resultPartners = almaPartnersService.retrievePartners(emptyQueryString, status, type, limit, offset);
        assertEquals(partners.getTotalRecordCount(), resultPartners.getTotalRecordCount());

        status = "status";
        emptyQueryString = EMPTY_STRING;
        type = EMPTY_STRING;
        resultPartners = almaPartnersService.retrievePartners(emptyQueryString, status, type, limit, offset);
        assertEquals(partners.getTotalRecordCount(), resultPartners.getTotalRecordCount());

        status = "status";
        emptyQueryString = "query";
        type = EMPTY_STRING;
        resultPartners = almaPartnersService.retrievePartners(emptyQueryString, status, type, limit, offset);
        assertEquals(partners.getTotalRecordCount(), resultPartners.getTotalRecordCount());

        status = "status";
        emptyQueryString = EMPTY_STRING;
        type = "type";
        resultPartners = almaPartnersService.retrievePartners(emptyQueryString, status, type, limit, offset);
        assertEquals(partners.getTotalRecordCount(), resultPartners.getTotalRecordCount());


    }

    @Test
    void testRetrieveAllPartners() {
        mockAlmaApi();

        final int limit = 10;
        final int offset = 10;
        final String emptyStatus = "";
        final String emptyQueryString = "";
        final String type = "";

        Partners partners = new Partners();
        partners.setTotalRecordCount(12);

        when(webTarget.path(any())).thenReturn(webTarget);
        when(webTarget.request()).thenReturn(builder);
        when(builder.accept(anyString())).thenReturn(builder);
        when(builder.buildGet()).thenReturn(invocation);
        when(invocation.invoke((Class<Object>) any())).thenReturn(partners);

        AlmaPartnersService almaPartnersService =
                new AlmaPartnersService(mockAlmaApiClient);
        Partners resultPartners =
                almaPartnersService.retrievePartners(emptyQueryString, emptyStatus, type, limit, offset);
        assertEquals(partners.getTotalRecordCount(), resultPartners.getTotalRecordCount());
    }

    @Test
    void testSearchPartners() {
        mockAlmaApi();

        final int resultCount = 121;
        final String queryString = "test";

        Partners partners = new Partners();
        partners.setTotalRecordCount(resultCount);

        when(webTarget.queryParam(anyString(), any())).thenReturn(webTarget);
        when(webTarget.path(any())).thenReturn(webTarget);
        when(webTarget.request()).thenReturn(builder);
        when(builder.accept(anyString())).thenReturn(builder);
        when(builder.buildGet()).thenReturn(invocation);
        when(invocation.invoke((Class<Object>) any())).thenReturn(partners);

        AlmaPartnersService almaPartnersService =
                new AlmaPartnersService(mockAlmaApiClient);
        Partners resultPartners = almaPartnersService.searchPartner(queryString);
        assertEquals(partners.getTotalRecordCount(), resultPartners.getTotalRecordCount());
    }

    @Test
    void testGetContext() {
        mockAlmaApi();
        AlmaPartnersService almaPartnersService =
                new AlmaPartnersService(mockAlmaApiClient);
        assertEquals(CONTEXT, almaPartnersService.getContext());
    }

    @Test
    void testGetContextValue() {
        mockAlmaApi();
        AlmaPartnersService almaPartnersService =
                new AlmaPartnersService(mockAlmaApiClient);
        assertEquals(CONTEXT_VALUE, almaPartnersService.getContextValue());
    }

    private void mockAlmaApi() {
        when(this.mockAlmaApiClient.getWebTarget())
                .thenReturn(webTarget);
        when(mockAlmaApiClient.getContext()).thenReturn(CONTEXT);
        when(mockAlmaApiClient.getContextValue()).thenReturn(CONTEXT_VALUE);
    }

}