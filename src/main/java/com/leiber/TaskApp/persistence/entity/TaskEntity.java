package com.leiber.TaskApp.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "task")
@Getter
@Setter
@NoArgsConstructor
public class TaskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "id_task")
    private Integer taskId;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime startTime;

    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime alertTime;

    private Boolean state;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;
}
