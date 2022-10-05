package com.hashimathman.gms.entity;

import com.fasterxml.jackson.annotation.*;
import lombok.*;

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

    @JsonIgnore
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "goal",
            referencedColumnName = "id"
    )
    private Goal goal;

}

