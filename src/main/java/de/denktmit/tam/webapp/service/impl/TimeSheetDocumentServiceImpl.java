package de.denktmit.tam.webapp.service.impl;

import de.denktmit.tam.webapp.model.business.DocumentEntity;
import de.denktmit.tam.webapp.model.business.DocumentType;
import de.denktmit.tam.webapp.persistence.DocumentRepository;
import de.denktmit.tam.webapp.service.TimeSheetDocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.time.Instant;

@Service
public class TimeSheetDocumentServiceImpl implements TimeSheetDocumentService {

    private DocumentRepository documentRepository;

    @Autowired
    public TimeSheetDocumentServiceImpl(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    public DocumentEntity saveNewTimeSheetDocument(String name, String externalIdentifier, @NotNull byte[] content) {

        DocumentEntity timeSheetDocument = new DocumentEntity(UUIDService.getNewUUID(), name,
                DocumentType.TIMESHEET.getDocumentTypeName(), externalIdentifier, FileTypes.CSV,
                content);

        documentRepository.save(timeSheetDocument);

        return timeSheetDocument;
    }
}
