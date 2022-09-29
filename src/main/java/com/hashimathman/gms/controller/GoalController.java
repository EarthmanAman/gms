package com.hashimathman.gms.controller;

import com.hashimathman.gms.entity.Goal;
import com.hashimathman.gms.service.GoalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GoalController {
    @Autowired
    private GoalService goalService;

    @PostMapping("/api/v1/goals")
    public Goal createGoal(@RequestBody Goal goal){
        return goalService.createGoal(goal);
    }
}
