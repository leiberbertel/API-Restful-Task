package com.leiber.TaskApp.persistence.entity.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TaskUpdated {
    private String title;
    private String description;
    private Boolean state;
    private LocalDateTime alertTime;
}
