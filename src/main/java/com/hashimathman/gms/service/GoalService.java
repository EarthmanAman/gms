package com.hashimathman.gms.service;

import com.hashimathman.gms.entity.Goal;

import java.util.List;

public interface GoalService {
    public Goal createGoal(Goal goal);

    public List<Goal> getGoals();
}
