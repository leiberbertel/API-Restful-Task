package com.leiber.TaskApp.persistence.entity.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
@Data
public class TaskUpdateState {

    @Schema(description = "id of the task to be updated", example = "12")
    private Integer taskId;

    @Schema(description = "updated state task", example = "false")
    private Boolean state;
}
