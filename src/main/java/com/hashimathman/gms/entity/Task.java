package com.hashimathman.gms.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task {
    @Id
    @SequenceGenerator(
            name = "task_sequence",
            sequenceName = "task_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "task_sequence"
    )
    @Column(
            name = "id"
    )
    private Long taskId;

    @OneToMany(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "subtask",
            referencedColumnName = "id"
    )
    private List<Task> subtasks;

    @OneToMany(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "task",
            referencedColumnName = "id"
    )
    private List<SuccessCriteria> successCriteriaList;
}
