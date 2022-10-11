package com.hashimathman.gms.service;

import com.hashimathman.gms.entity.Goal;

import java.util.Date;
import java.util.List;

public interface GoalService {
    public Goal createGoal(Goal goal);

    public List<Goal> getGoals();

    public List<Goal> filterGoals(Boolean isDone);

    public List<Goal> goalsEndInMonth(Boolean isDone, Date date);

    public List<Goal> goalsEndInMonthAll(Date date);

    public List<Goal> goalsAfterStartDateAll(Date date);

    public List<Goal> goalsAfterStartDate(Boolean isDone, Date date);

    public List<Goal> goalsStartDateBetweenAll(Date start, Date end);

    public List<Goal> goalsStartDateBetween(Boolean isDone, Date start, Date end);

    public List<Goal> goalsEndDateBetweenAll(Date start, Date end);

    public List<Goal> goalsEndDateBetween(Boolean isDone, Date start, Date end);

    public Goal updateGoal(Long id, Goal goal);

    public void deleteGoal(Long id);
}
