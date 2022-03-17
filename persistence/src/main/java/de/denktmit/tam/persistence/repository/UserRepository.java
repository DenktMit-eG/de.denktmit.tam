package de.denktmit.tam.persistence.repository;

import de.denktmit.tam.persistence.model.UserEntity;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long>, PagingAndSortingRepository<UserEntity, Long> {

    Optional<UserEntity> findByLoginName(String loginName);

}
