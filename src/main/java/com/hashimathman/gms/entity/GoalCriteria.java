package com.hashimathman.gms.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoalCriteria {
    @Id
    @SequenceGenerator(
            name = "goal_criteria_sequence",
            sequenceName = "goal_criteria_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "goal_criteria_sequence"
    )
    @Column(name = "id")
    private Long goalCriteriaId;

    @OneToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "success_criteria",
            referencedColumnName = "id"
    )
    private SuccessCriteria successCriteria;
}
