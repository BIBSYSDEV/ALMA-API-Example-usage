package no.unit.alma.bibs;

import no.bibsys.alma.rest.bibs.Bib;
import no.bibsys.alma.rest.bibs.Bibs;
import no.bibsys.alma.rest.representations.Representation;
import no.bibsys.alma.rest.representations.Representations;
import no.bibsys.alma.rest.user_request.UserRequests;
import no.unit.alma.commons.AlmaContext;

public interface AlmaBibsService extends AlmaContext {

    Bib getBib(String identifier, String availParams);

    void addBibToCollection(String mmsId, String collectionId);

    Bib createLinkedRecord(String mmsId);

    Bib updateBib(Bib bib);

    UserRequests getRequestsFromBib(String recordIdentifier, boolean deleted);

    Representation createRemotePresentation(String barcode, String access, String digitalRepositoryId, String url,
            String libraryCode);

    Representation createRemoteRepresentation(String mmsId, String barcode, String access, String digitalRepositoryId,
            String url, String libraryCode);

    Representation createRemoteRepresentation(long mmsId, String access, String remoteRepositoryId, String libraryCode,
            String url, String year, String month, String day, String volume, String issue, String number);

    Representation createRemoteRepresentation(String barcode, String access, String remoteRepositoryId,
            String libraryCode, String url, String year, String month, String day, String volume, String issue,
            String number);

    Representation createRemoteRepresentation(String barcode, String label, String access, String remoteRepositoryId,
            String libraryCode, String url, String year, String month, String day, String volume, String issue,
            String number);

    Representation getSingleRemoteRepresentationFromBarcode(String barcode, String representationId);

    Representation getSingleRemoteRepresentationFromMmsId(String mmsId, String representationId);

    Representations getRemoteRepresentationsFromMmsId(String mmsId, int limit, int offset);

    Bibs retrieveBibs(String mms_id, String ie_id, String holdings_id, String representation_id, String nz_mms_id,
            String view, String expand);
}
