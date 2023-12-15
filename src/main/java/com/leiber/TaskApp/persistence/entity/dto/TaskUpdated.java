package com.leiber.TaskApp.persistence.entity.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TaskUpdated {

    @Schema(description = "updated task title", example = "cook")
    private String title;

    @Schema(description = "updated task description", example = "Clean the house")
    private String description;

    @Schema(description = "updated task state", example = "false/true")
    private Boolean state;

    @Schema(description = "updated task alert time", example = "2023-11-07T16:30:00")
    private LocalDateTime alertTime;
}
