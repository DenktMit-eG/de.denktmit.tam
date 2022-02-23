package de.denktmit.tam.webapp.service;

import de.denktmit.tam.webapp.model.business.DocumentEntity;
import de.denktmit.tam.webapp.model.business.DocumentType;
import de.denktmit.tam.webapp.persistence.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.time.Instant;

@Service
public class TimeSheetDocumentService {

    DocumentRepository documentRepository;

    @Autowired
    public TimeSheetDocumentService(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    public DocumentEntity createTimeSheetDocument(String name, String externalIdentifier, @NotNull byte[] content,
                                                       String createdBy) {

        DocumentEntity timeSheetDocument = new DocumentEntity(UUIDService.getNewUUID(), name,
                DocumentType.TIMESHEET.getDocumentTypeName(), externalIdentifier, FileTypes.CSV,
                content, Instant.now(), createdBy, Instant.now(), createdBy);

        documentRepository.save(timeSheetDocument);

        return timeSheetDocument;
    }
}
