package com.hashimathman.gms.service;

import com.hashimathman.gms.entity.BaseModel;
import com.hashimathman.gms.entity.Goal;
import com.hashimathman.gms.repository.GoalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

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

    @Override
    public List<Goal> goalsEndDateBetweenAll(Date start, Date end) {
        return goalRepository.findByBaseEndDateBetween(start, end);
    }

    @Override
    public List<Goal> goalsEndDateBetween(Boolean isDone, Date start, Date end) {
        return goalRepository.findByBaseIsDoneAndBaseEndDateBetween(isDone, start, end);
    }

    @Override
    public Goal updateGoal(Long id, Goal goal) {
        Goal instance = goalRepository.findById(id).get();
        BaseModel base = new BaseModel();
        if(Objects.nonNull(goal.getBase().getStartDate())){
            System.out.println("hereeeeeeeeeeeeeeeeeeeee");
            base.setStartDate(goal.getBase().getStartDate());
        }

        if(Objects.nonNull(goal.getBase().getEndDate()) ){
            base.setEndDate(goal.getBase().getEndDate());
        }

        if(Objects.nonNull(goal.getBase().getTitle()) && !"".equalsIgnoreCase(goal.getBase().getTitle())){
            base.setTitle(goal.getBase().getTitle());
        }
        if(Objects.nonNull(goal.getBase().getDescription()) && !"".equalsIgnoreCase(goal.getBase().getDescription())){
            base.setTitle(goal.getBase().getDescription());
        }

        if(Objects.nonNull(goal.getBase().getIsDone()) && !"".equals(goal.getBase().getIsDone())){
            base.setIsDone(goal.getBase().getIsDone());
        }

        instance.setBase(base);
        return goalRepository.save(instance);
    }
}
