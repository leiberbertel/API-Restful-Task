package com.leiber.TaskApp.persistence.entity.dto;

import io.swagger.v3.oas.annotations.media.Schema;
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

    @Schema(description = "task title", example = "programming")
    private String title;

    @Schema(description = "Task description", example = "Learn code")
    private String description;

    @Schema(description = "Time to alert for the task", example = "2023-11-07T16:30:00")
    private LocalDateTime alertTime;

    @Schema(description = "Task state", example = "true/false")
    private Boolean state;

    @Schema(description = "task owner id", example = "1")
    private Integer userId;
}
