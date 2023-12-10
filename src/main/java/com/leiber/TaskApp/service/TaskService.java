package com.leiber.TaskApp.service;


import com.leiber.TaskApp.persistence.entity.dto.TaskRequest;
import com.leiber.TaskApp.persistence.entity.dto.TaskUpdated;
import com.leiber.TaskApp.persistence.entity.TaskEntity;
import com.leiber.TaskApp.persistence.entity.UserEntity;
import com.leiber.TaskApp.persistence.repository.TaskRepository;
import com.leiber.TaskApp.persistence.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final UserRepository userRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository, UserRepository userRepository) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
    }

    public List<TaskEntity> getAll() {
        return this.taskRepository.findAll();
    }

    public TaskEntity getTask(int id) {
        return this.taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));
    }

    public void createTask(TaskRequest request, Integer userId) throws Exception {
        UserEntity userEntity = userRepository.findById(userId)
                .orElseThrow(() -> new Exception("User not found"));

        TaskEntity taskEntity = new TaskEntity();
        taskEntity.setTitle(request.getTitle());
        taskEntity.setDescription(request.getDescription());
        taskEntity.setStartTime(request.getStartTime());
        taskEntity.setAlertTime(request.getAlertTime());
        taskEntity.setState(request.getState());
        taskEntity.setUser(userEntity);

        taskRepository.save(taskEntity);
    }

    @Transactional
    public TaskEntity update(Integer taskId, TaskUpdated updateDTO) {
        TaskEntity task = taskRepository.findById(taskId)
                .orElseThrow(() -> new RuntimeException("Task not found"));

        if (updateDTO.getTitle() != null) {
            task.setTitle(updateDTO.getTitle());
        }
        if (updateDTO.getDescription() != null) {
            task.setDescription(updateDTO.getDescription());
        }
        if (updateDTO.getState() != null) {
            task.setState(updateDTO.getState());
        }
        if (updateDTO.getAlertTime() != null) {
            task.setAlertTime(updateDTO.getAlertTime());
        }

        return taskRepository.save(task);
    }

    public void delete(int id) {
        if(!this.taskRepository.existsById(id)) {
            throw new RuntimeException("Task not found");
        }
        this.taskRepository.deleteById(id);
    }

}