package com.hashimathman.gms.service;

import com.hashimathman.gms.entity.Goal;
import com.hashimathman.gms.repository.GoalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoalServiceImpl implements GoalService {
    @Autowired
    private GoalRepository goalRepository;
    @Override
    public Goal createGoal(Goal goal) {
        return goalRepository.save(goal);
    }

    @Override
    public List<Goal> getGoals() {
        return goalRepository.findAll();
    }
}
