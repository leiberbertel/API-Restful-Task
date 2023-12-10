package com.leiber.TaskApp.persistence.repository;

import com.leiber.TaskApp.persistence.entity.UserEntity;
import org.springframework.data.repository.ListCrudRepository;

import java.util.Optional;

public interface UserRepository extends ListCrudRepository<UserEntity, Integer> {
    Optional<UserEntity> findByUsername(String username);
}
