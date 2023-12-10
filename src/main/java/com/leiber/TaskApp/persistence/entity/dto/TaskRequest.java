package com.leiber.TaskApp.persistence.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TaskRequest {
    private String title;
    private String description;
    private LocalDateTime startTime;
    private LocalDateTime alertTime;
    private Boolean state;
    private Integer userId;
}
