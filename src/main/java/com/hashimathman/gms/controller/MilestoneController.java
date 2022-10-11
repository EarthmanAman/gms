package com.hashimathman.gms.controller;

import com.hashimathman.gms.entity.Goal;
import com.hashimathman.gms.entity.Milestone;
import com.hashimathman.gms.entity.SuccessCriteria;
import com.hashimathman.gms.model.ChildMilestoneCreateModel;
import com.hashimathman.gms.model.MilestoneCreateModel;
import com.hashimathman.gms.repository.GoalRepository;
import com.hashimathman.gms.repository.MilestoneRepository;
import com.hashimathman.gms.service.MilestoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class MilestoneController {

    @Autowired
    private MilestoneService milestoneService;

    @Autowired
    private MilestoneRepository milestoneRepository;

    @Autowired
    private GoalRepository goalRepository;

    @PostMapping("/api/v1/milestone")
    public Milestone createMilestone(@RequestBody MilestoneCreateModel milestone){
        Milestone milestone1 = new Milestone();
        milestone1.setBase(milestone.getBase());
        milestone1.setSuccessCriteriaList(milestone.getSuccessCriteriaList());
        milestone1.setChildren(milestone.getChildren());

        for (SuccessCriteria successCriteria : milestone.getSuccessCriteriaList()) {
            successCriteria.setMilestone(milestone1);
        }
        List<Milestone> children = new ArrayList<>();
        if(milestone.getChildren() != null){
            for(Milestone child : milestone.getChildren()){
                children.add(child);
            }
            milestone1.setChildren(children);
        }


        Optional<Goal> optionalGoal = goalRepository.findById(milestone.getGoal());
        Goal goal = optionalGoal.get();
        milestone1.setGoal(goal);
        List<Milestone> parents = new ArrayList<>();
        if(milestone.getParents() != null) {
            for (Long parent : milestone.getParents()) {
                System.out.println(parent);
                System.out.println(milestone.getParents());
                Milestone parentMilestone = milestoneRepository.findById(parent).get();
                System.out.println(parentMilestone);
                parents.add(parentMilestone);
            }
            milestone1.setParents(parents);
        }


        return milestoneService.createMilestone(milestone1);
    }


    @PutMapping("/api/v1/milestone/{id}")
    public Milestone updateMilestone(@PathVariable("id") Long id, @RequestBody MilestoneCreateModel milestone){
        return milestoneService.updateMilestone(id, milestone);
    }

    @DeleteMapping("/api/v1/milestone/{id}")
    public String deleteMilestone(@PathVariable Long id){
        milestoneService.deleteMilestone(id);
        return "Milestone deleted successfully";
    }
    @GetMapping("/api/v1/milestone")
    public List<Milestone> getMilestone(){
        return milestoneService.getMilestone();
    }

    @PutMapping("/api/v1/milestone/{id}/parents")
    public Milestone updateMilestoneParents(@PathVariable("id") Long id, @RequestBody ChildMilestoneCreateModel childMilestoneCreateModel){
        return milestoneService.updateMilestoneParents(id, childMilestoneCreateModel);
    }
}
