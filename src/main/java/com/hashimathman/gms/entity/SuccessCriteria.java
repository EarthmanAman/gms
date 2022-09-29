package com.hashimathman.gms.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SuccessCriteria {
    @Id
    @SequenceGenerator(
            name = "success_criteria_sequence",
            sequenceName = "success_criteria_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "success_criteria_sequence"
    )
    @Column(name = "id")
    private Long successCriteriaId;
    private String title;
    private String description;

    @OneToOne(
            mappedBy = "successCriteria"
    )
    private GoalCriteria goalCriteria;
}

