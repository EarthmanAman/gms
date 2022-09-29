package com.hashimathman.gms.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MilestoneCriteria {
    @Id
    @SequenceGenerator(
            name = "milestone_success_criteria",
            sequenceName = "milestone_success_criteria"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "milestone_success_criteria"
    )
    @Column(
            name = "id"
    )
    private Long milestoneCriteriaId;

    @OneToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "success_criteria",
            referencedColumnName = "id"
    )
    private SuccessCriteria successCriteria;

}
