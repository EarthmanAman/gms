package com.hashimathman.gms.service;

import com.hashimathman.gms.entity.Goal;
import com.hashimathman.gms.repository.GoalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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

    @Override
    public List<Goal> filterGoals(Boolean isDone) {
        return goalRepository.findByBaseIsDone(isDone);
    }

    @Override
    public List<Goal> goalsEndInMonth(Boolean isDone, Date date) {
        return goalRepository.findByBaseIsDoneAndBaseEndDateBefore(isDone, date);
    }

    @Override
    public List<Goal> goalsEndInMonthAll(Date date) {
        return goalRepository.findByBaseEndDateBefore(date);
    }

    @Override
    public List<Goal> goalsAfterStartDateAll(Date date) {
        return goalRepository.findByBaseStartDateAfter(date);
    }

    @Override
    public List<Goal> goalsAfterStartDate(Boolean isDone, Date date) {
        return goalRepository.findByBaseIsDoneAndBaseStartDateAfter(isDone, date);
    }

    @Override
    public List<Goal> goalsStartDateBetweenAll(Date start, Date end) {
        return goalRepository.findByBaseStartDateBetween(start, end);
    }

    @Override
    public List<Goal> goalsStartDateBetween(Boolean isDone, Date start, Date end) {
        return goalRepository.findByBaseIsDoneAndBaseStartDateBetween(isDone, start, end);
    }
}
