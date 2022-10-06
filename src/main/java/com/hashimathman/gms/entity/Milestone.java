package com.hashimathman.gms.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

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

    @ToString.Exclude
    @OneToMany(
            mappedBy = "milestone",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<SuccessCriteria> successCriteriaList;

    @ToString.Exclude
    @OneToMany(
            mappedBy = "parent",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    @JsonIgnore
    private List<Milestone> children;

    @JsonIgnore
    @ManyToOne(targetEntity = Milestone.class, fetch = FetchType.LAZY)
    @JoinColumn(
            name = "parent",
            referencedColumnName = "id"
    )
    private Milestone parent;


    @JsonIgnore
    @ManyToOne(targetEntity = Goal.class, fetch = FetchType.LAZY)
    @JoinColumn(
            name = "goal",
            referencedColumnName = "id"
    )
    private Goal goal;
}
