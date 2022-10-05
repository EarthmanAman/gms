package com.hashimathman.gms.entity;

import com.fasterxml.jackson.annotation.*;
import lombok.*;
import org.hibernate.annotations.LazyGroup;
import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

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


    @ToString.Exclude
    @OneToMany(
            mappedBy = "goal",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    @JsonManagedReference
    private List<SuccessCriteria> successCriteriaList;
}
