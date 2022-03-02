package de.denktmit.tam.webapp.persistence;

import de.denktmit.tam.webapp.model.business.CustomerEntity;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends CrudRepository<CustomerEntity, Long>,
        PagingAndSortingRepository<CustomerEntity, Long>{

    Optional<CustomerEntity> getById(Long id);

    List<CustomerEntity> findAll(Sort sort);

}
