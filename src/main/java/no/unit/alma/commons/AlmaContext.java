package no.unit.alma.commons;

public interface AlmaContext {

    String getContext();
    String getContextValue();
    default AlmaStage getAlmaStage() {
        throw new UnsupportedOperationException("Alma stage has not been implemented. Implement it if you need it!");
    }
}
