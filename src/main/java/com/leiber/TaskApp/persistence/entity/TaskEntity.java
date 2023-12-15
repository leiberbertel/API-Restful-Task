package com.leiber.TaskApp.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "task")
@Getter
@Setter
@NoArgsConstructor
public class TaskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "id_task")
    @Schema(description = "Unique ID of the task", example = "10")
    private Integer taskId;

    @Column(nullable = false)
    @Schema(description = "task title", example = "learn English")
    private String title;

    @Column(nullable = false)
    @Schema(description = "task description", example = "this task is important")
    private String description;

    @Column(columnDefinition = "DATE")
    @Schema(description = "Time to alert for the task", example = "2023-11-07")
    private LocalDate alertTime;

    @Schema(description = "Task status", example = "false/true")
    private Boolean state;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;
}
