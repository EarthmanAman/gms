package com.hashimathman.gms.controller;

import com.hashimathman.gms.entity.BaseModel;
import com.hashimathman.gms.entity.Goal;
import com.hashimathman.gms.entity.Milestone;
import com.hashimathman.gms.entity.SuccessCriteria;
import com.hashimathman.gms.model.GoalCreateModel;
import com.hashimathman.gms.service.GoalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class GoalController {
    @Autowired
    private GoalService goalService;

    @PostMapping(value = "/api/v1/goals")
    public Goal createGoal(@RequestBody Goal goal){
        System.out.println(goal);
        Goal goal1 = new Goal();
        goal1.setSuccessCriteriaList(goal.getSuccessCriteriaList());
        goal1.setMilestoneList(goal.getMilestoneList());
        goal1.setBase(goal.getBase());
        for (SuccessCriteria successCriteria : goal.getSuccessCriteriaList()) {
            successCriteria.setGoal(goal1);
        }
        for (Milestone milestone : goal.getMilestoneList()) {
            milestone.setGoal(goal1);
            for(SuccessCriteria successCriteria : milestone.getSuccessCriteriaList()){
                successCriteria.setMilestone(milestone);
            }
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

    @GetMapping("/api/v1/goals/month")
    public List<Goal> goalsEndInMonth(@RequestParam("done") String done, @RequestParam("date")
                                        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date date){

        Boolean isDone = true;
        if (done.equals("false")) {
            isDone = false;
        } else if (done.equals("all")) {
            return goalService.goalsEndInMonthAll(date);
        }
        return goalService.goalsEndInMonth(isDone, date);
    }

    @GetMapping("api/v1/goals/start_date")
    public List<Goal> goalsAfterStartDate(@RequestParam("done") String done,
                                          @RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date date){
        Boolean isDone = true;
        if (done.equals("false")) {
            isDone = false;
        } else if (done.equals("all")) {
            return goalService.goalsAfterStartDateAll(date);
        }
        return goalService.goalsAfterStartDate(isDone, date);
    }

    @GetMapping("/api/v1/goals/start_date/between")
    public List<Goal> goalsStartDateBetween(@RequestParam("done") String done,
                                            @RequestParam("start") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date start,
                                            @RequestParam("end") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date end){
        Boolean isDone = true;
        if(done.equals("false")){
            isDone = false;
        } else if (done.equals("all")) {
            return goalService.goalsStartDateBetweenAll(start, end);
        }
        return  goalService.goalsStartDateBetween(isDone, start, end);
    }

    @GetMapping("/api/v1/goals/end_date/between")
    public List<Goal> goalsEndDateBetween(@RequestParam("done") String done,
                                            @RequestParam("start") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date start,
                                            @RequestParam("end") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date end){
        Boolean isDone = true;
        if(done.equals("false")){
            isDone = false;
        } else if (done.equals("all")) {
            return goalService.goalsEndDateBetweenAll(start, end);
        }
        return  goalService.goalsEndDateBetween(isDone, start, end);
    }
}
