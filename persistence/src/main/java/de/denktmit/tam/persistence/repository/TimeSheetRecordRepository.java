package de.denktmit.tam.persistence.repository;

import de.denktmit.tam.persistence.model.TimeSheetRecordEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TimeSheetRecordRepository extends CrudRepository<TimeSheetRecordEntity, Long>, PagingAndSortingRepository<TimeSheetRecordEntity, Long>{

    List<TimeSheetRecordEntity> findAllByWorkRecordId(Long workRecordId);

    Optional<TimeSheetRecordEntity> findByWorkRecordIdAndPosition(Long workRecordId, Short Position);

    Long deleteByWorkRecordId(Long workRecordId);

}
