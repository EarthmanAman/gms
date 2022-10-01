package com.hashimathman.gms.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Goal{
    @Embedded
    private BaseModel base;

    @Id
    @SequenceGenerator(
            name = "goal_sequence",
            sequenceName = "goal_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "goal_sequence"
    )
    @Column(name = "id")
    private Long goalId;


    @OneToMany(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "goal",
            referencedColumnName = "id"
    )
    private List<SuccessCriteria> successCriteriaList;
}
