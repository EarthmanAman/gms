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

    @JsonIgnore
    @ManyToMany(
            mappedBy = "parents",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Milestone> children;


    @ManyToMany(targetEntity = Milestone.class, fetch = FetchType.LAZY)
    @JoinTable(name = "milestone_parents",
            joinColumns = @JoinColumn(name = "children_id"),
            inverseJoinColumns = @JoinColumn(name = "parents_id")
    )
    private List<Milestone> parents;


    @JsonIgnore
    @ToString.Exclude
    @ManyToOne(targetEntity = Goal.class, fetch = FetchType.LAZY)
    @JoinColumn(
            name = "goal",
            referencedColumnName = "id"
    )
    private Goal goal;
}
