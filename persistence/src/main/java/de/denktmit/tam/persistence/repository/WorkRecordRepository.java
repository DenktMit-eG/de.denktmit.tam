package de.denktmit.tam.persistence.repository;

import de.denktmit.tam.persistence.model.WorkRecordEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkRecordRepository
        extends CrudRepository<WorkRecordEntity, Long>,
                PagingAndSortingRepository<WorkRecordEntity, Long> {

    List<WorkRecordEntity> findAllByOrderByIdAsc();
}
