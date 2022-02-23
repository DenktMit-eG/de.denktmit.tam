package de.denktmit.tam.webapp.persistence;

import de.denktmit.tam.webapp.model.business.DocumentEntity;
import de.denktmit.tam.webapp.model.business.DocumentType;
import de.denktmit.tam.webapp.model.business.TimeSheetRecordEntity;
import de.denktmit.tam.webapp.model.business.UserEntity;
import de.denktmit.tam.webapp.service.UUIDService;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;
import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface DocumentRepository extends CrudRepository<DocumentEntity, Long>, PagingAndSortingRepository<DocumentEntity, Long>{

    Optional<DocumentEntity> findByDocUuid(UUID uuid);

}
