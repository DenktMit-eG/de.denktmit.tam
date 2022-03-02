package de.denktmit.tam.webapp.persistence;

import de.denktmit.tam.webapp.model.business.WorkRecordEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WorkRecordRepository extends CrudRepository<WorkRecordEntity, Long>, PagingAndSortingRepository<WorkRecordEntity, Long> {

    //Optional<WorkRecordEntity> findByFkContractIdAndBillingYearAndBillingMonth(Long fkContractId, Short
    // billingYear, Short billingMonth);
    List<WorkRecordEntity> findAllByOrderByIdAsc();

}
