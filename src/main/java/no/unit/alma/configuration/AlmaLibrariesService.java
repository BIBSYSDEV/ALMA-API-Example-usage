package no.unit.alma.configuration;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import no.unit.alma.commons.AlmaClient;
import no.unit.alma.generated.libraries.Libraries;
import no.unit.alma.generated.libraries.Library;

/**
 * This client implements an integration to the /almaws/v1/bibs/mmsId/conf
 * service.
 */
public class AlmaLibrariesService {

    private final transient WebTarget confTarget;
    private final String context;
    private final String contextValue;
    private final String almaStage;

    /**
     * Create new AlmaLibrariesService.
     * 
     * @param almaClient almaClient
     */
    public AlmaLibrariesService(AlmaClient almaClient) {
        this.confTarget = almaClient.getWebTarget().path("conf");
        this.context = almaClient.getContext();
        this.contextValue = almaClient.getContextValue();
        this.almaStage = almaClient.getAlmaStage();
    }

    /**
     * Get Libraries.
     * 
     * @return Libraries object
     */
    public Libraries getLibraries() {
        return confTarget
                .path("libraries")
                .request()
                .accept(MediaType.APPLICATION_XML)
                .buildGet()
                .invoke(Libraries.class);
    }

    /**
     * Get Library.
     * 
     * @param libraryCode libraryCode
     * @return Library object
     */
    public Library getLibrary(String libraryCode) {
        return confTarget
                .path("libraries")
                .path(libraryCode)
                .request()
                .accept(MediaType.APPLICATION_XML)
                .buildGet()
                .invoke(Library.class);
    }

    public String getContext() {
        return context;
    }

    public String getContextValue() {
        return contextValue;
    }

    public String getAlmaStage() {
        return almaStage;
    }
}
