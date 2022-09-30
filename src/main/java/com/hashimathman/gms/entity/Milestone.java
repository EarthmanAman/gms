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
public class Milestone{

    @Id
    @SequenceGenerator(
            name = "milestone_sequence",
            sequenceName = "milestone_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "milestone_sequence"
    )
    @Column(
            name = "id"
    )
    private Long milestoneId;

    @Embedded
    private BaseModel base;

    @OneToMany(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "milestone",
            referencedColumnName = "id"
    )
    private List<SuccessCriteria> successCriteriaList;

    @OneToMany(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            referencedColumnName = "id"
    )
    private List<Milestone> precedence;
}
