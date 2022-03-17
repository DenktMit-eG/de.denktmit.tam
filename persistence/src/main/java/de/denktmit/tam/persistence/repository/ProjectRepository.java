package de.denktmit.tam.persistence.repository;

import de.denktmit.tam.persistence.model.CustomerEntity;
import de.denktmit.tam.persistence.model.ProjectEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends CrudRepository<ProjectEntity, Long>,
        PagingAndSortingRepository<ProjectEntity, Long>{
    List<ProjectEntity> findProjectsByCustomer(CustomerEntity customer);
}
