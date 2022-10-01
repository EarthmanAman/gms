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
            mappedBy = "goal",
            cascade = CascadeType.ALL
    )
    private List<SuccessCriteria> successCriteriaList;
}
