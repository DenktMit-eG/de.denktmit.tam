package de.denktmit.tam.persistence.repository;

import de.denktmit.tam.persistence.model.DocumentEntity;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface DocumentRepository extends CrudRepository<DocumentEntity, Long>, PagingAndSortingRepository<DocumentEntity, Long>{

    Optional<DocumentEntity> findByDocUuid(UUID uuid);

}
