package com.hashimathman.gms.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Optional;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
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

    @ManyToOne(targetEntity = Goal.class, cascade = CascadeType.ALL)
    @JoinColumn(
            name = "goal",
            referencedColumnName = "id"
    )
    private Optional<Goal> goal;


}

