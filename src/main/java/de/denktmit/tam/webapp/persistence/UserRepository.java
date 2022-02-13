package de.denktmit.tam.webapp.persistence;

import de.denktmit.tam.webapp.model.business.UserEntity;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long>, PagingAndSortingRepository<UserEntity, Long> {

    Optional<UserEntity> findByLoginName(String loginName);

}
