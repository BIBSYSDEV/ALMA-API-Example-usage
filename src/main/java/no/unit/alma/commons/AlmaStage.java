package no.unit.alma.commons;

public enum AlmaStage {

    SANDBOX1("alma-sandbox1"),
    SANDBOX2("alma-sandbox2"),
    PROD("alma-prod");

    private String vaultAlmaStageName;

    AlmaStage(String vaultAlmaStageName) {
        this.vaultAlmaStageName = vaultAlmaStageName;
    }

    public String getVaultAlmaStageName() {
        return vaultAlmaStageName;
    }
}


