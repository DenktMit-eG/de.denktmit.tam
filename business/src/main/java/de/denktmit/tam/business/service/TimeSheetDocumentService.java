package de.denktmit.tam.business.service;

import de.denktmit.tam.persistence.model.DocumentEntity;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;

@Service
public interface TimeSheetDocumentService {
    DocumentEntity saveNewTimeSheetDocument(String name, String externalIdentifier, @NotNull byte[] content);

}
