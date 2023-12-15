package com.leiber.TaskApp.persistence.repository;

import com.leiber.TaskApp.persistence.entity.TaskEntity;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface TaskRepository extends ListCrudRepository<TaskEntity, Integer> {
}
