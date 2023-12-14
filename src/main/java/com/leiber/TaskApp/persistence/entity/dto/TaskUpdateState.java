package com.leiber.TaskApp.persistence.entity.dto;

import lombok.Data;
@Data
public class TaskUpdateState {
    private Integer taskId;
    private Boolean state;
}
