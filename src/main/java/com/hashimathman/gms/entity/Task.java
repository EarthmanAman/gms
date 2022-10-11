package com.hashimathman.gms.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @Embedded
    private BaseModel base;

    @JsonIgnore
    @ManyToMany(
            mappedBy = "parents",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Task> children;


    @ManyToMany(targetEntity = Task.class, fetch = FetchType.LAZY)
    @JoinTable(name = "task_parents",
            joinColumns = @JoinColumn(name = "children_id"),
            inverseJoinColumns = @JoinColumn(name = "parents_id")
    )
    private List<Task> parents;

    @OneToMany(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "task",
            referencedColumnName = "id"
    )
    private List<SuccessCriteria> successCriteriaList;
}
