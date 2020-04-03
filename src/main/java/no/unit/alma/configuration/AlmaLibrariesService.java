package no.unit.alma.configuration;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import no.unit.alma.commons.AlmaClient;
import no.unit.alma.generated.libraries.Libraries;
import no.unit.alma.generated.libraries.Library;

public class AlmaLibrariesService {

    private final WebTarget confTarget;
    private final String context;
    private final String contextValue;
    private final String almaStage;

    public AlmaLibrariesService(AlmaClient almaClient) {
        this.confTarget = almaClient.getWebTarget().path("conf");
        this.context = almaClient.getContext();
        this.contextValue = almaClient.getContextValue();
        this.almaStage = almaClient.getAlmaStage();
    }

    public Libraries getLibraries() {
        return confTarget
                .path("libraries")
                .request()
                .accept(MediaType.APPLICATION_XML)
                .buildGet()
                .invoke(Libraries.class);
    }

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
