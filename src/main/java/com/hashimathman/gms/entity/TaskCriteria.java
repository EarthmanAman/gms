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
public class TaskCriteria {
    @Id
    @SequenceGenerator(
            name = "task_criteria_sequence",
            sequenceName = "task_criteria_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "task_criteria_sequence"
    )
    @Column(
            name = "id"
    )
    private Long taskCriteriaId;

    @OneToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "success_criteria",
            referencedColumnName = "id"
    )
    private SuccessCriteria successCriteriaList;
}
