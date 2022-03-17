package de.denktmit.tam.persistence.repository;

import de.denktmit.tam.persistence.model.CustomerEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository
        extends CrudRepository<CustomerEntity, Long>,
                PagingAndSortingRepository<CustomerEntity, Long> {

    CustomerEntity save(CustomerEntity customerEntity);

    Optional<CustomerEntity> getById(Long id);

    Optional<CustomerEntity> getByCompanyName(String companyName);

    List<CustomerEntity> findAll();
    
    List<CustomerEntity> findAll(Sort sort);

    Page<CustomerEntity> findAll(Pageable pageable);

}
