package com.hashimathman.gms.controller;

import com.hashimathman.gms.entity.BaseModel;
import com.hashimathman.gms.entity.Goal;
import com.hashimathman.gms.entity.SuccessCriteria;
import com.hashimathman.gms.model.GoalCreateModel;
import com.hashimathman.gms.service.GoalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        List<Goal> goals = goalService.getGoals();
        return goals;
    }

    @GetMapping("/api/v1/goals/filter")
    public List<Goal> filterGoals(@RequestParam("done") String done){
        Boolean isDone = true;
        if (done.equals("false")) {
            isDone = false;
        }

        return goalService.filterGoals(isDone);
    }
}
