package de.denktmit.tam.webapp.service;

import de.denktmit.tam.webapp.model.business.DocumentEntity;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;

@Service
public interface TimeSheetDocumentService {
    DocumentEntity saveNewTimeSheetDocument(String name, String externalIdentifier, @NotNull byte[] content);

}
