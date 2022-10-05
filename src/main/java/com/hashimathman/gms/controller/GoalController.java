package com.hashimathman.gms.controller;

import com.hashimathman.gms.entity.BaseModel;
import com.hashimathman.gms.entity.Goal;
import com.hashimathman.gms.entity.SuccessCriteria;
import com.hashimathman.gms.model.GoalCreateModel;
import com.hashimathman.gms.service.GoalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GoalController {
    @Autowired
    private GoalService goalService;

    @PostMapping("/api/v1/goals")
    public Goal createGoal(@RequestBody Goal goal){
        Goal goal1 = new Goal();
        goal1.setSuccessCriteriaList(goal.getSuccessCriteriaList());
        goal1.setBase(goal.getBase());
        for (SuccessCriteria successCriteria : goal.getSuccessCriteriaList()) {
            successCriteria.setGoal(goal1);
        }
        return goalService.createGoal(goal1);
    }

    @GetMapping("/api/v1/goals")
    public List<Goal> getGoals(){
        System.out.println("heloooooooo");
        List<Goal> goals = goalService.getGoals();
        System.out.println(goals);
        return goals;
    }
}
