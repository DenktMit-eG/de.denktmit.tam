package de.denktmit.tam.webapp.service;

import de.denktmit.tam.webapp.model.business.DocumentEntity;
import de.denktmit.tam.webapp.persistence.DocumentRepository;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;

@Component
public interface TimeSheetDocumentService {
    DocumentEntity saveNewTimeSheetDocument(String name, String externalIdentifier, @NotNull byte[] content,
                                            String createdBy);

}
