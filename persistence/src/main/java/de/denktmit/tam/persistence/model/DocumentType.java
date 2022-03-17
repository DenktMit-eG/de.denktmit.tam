package de.denktmit.tam.persistence.model;

public enum DocumentType {
    INVOICE("invoice"),
    CREDITNOTE("creditnote"),
    TIMESHEET("timesheet");

    private final String documentTypeName;


    DocumentType(String documentTypeName) {
        this.documentTypeName = documentTypeName;
    }

    public String getDocumentTypeName() {
        return documentTypeName;
    }
}
