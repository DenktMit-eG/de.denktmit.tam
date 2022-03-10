package de.denktmit.tam.webapp.persistence;

import de.denktmit.tam.webapp.model.business.CustomerEntity;
import de.denktmit.tam.webapp.model.business.ProjectEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends CrudRepository<ProjectEntity, Long>,
        PagingAndSortingRepository<ProjectEntity, Long>{
    List<ProjectEntity> findProjectsByCustomer(CustomerEntity customer);
}
