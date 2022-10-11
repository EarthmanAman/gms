package com.hashimathman.gms.service;

import com.hashimathman.gms.entity.BaseModel;
import com.hashimathman.gms.entity.Goal;
import com.hashimathman.gms.entity.Milestone;
import com.hashimathman.gms.model.MilestoneCreateModel;
import com.hashimathman.gms.repository.GoalRepository;
import com.hashimathman.gms.repository.MilestoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class MilestoneServiceImpl implements MilestoneService{

    @Autowired
    private MilestoneRepository milestoneRepository;

    @Autowired
    private GoalRepository goalRepository;

    @Override
    public Milestone createMilestone(Milestone milestone1) {
        return milestoneRepository.save(milestone1);
    }

    @Override
    public List<Milestone> getMilestone() {
        return milestoneRepository.findAll();
    }

    @Override
    public Milestone updateMilestone(Long id, MilestoneCreateModel milestone) {
        Milestone instance = milestoneRepository.findById(id).get();
        BaseModel base = new BaseModel();
        if(Objects.nonNull(milestone.getBase())){

            // Update start date
            if(Objects.nonNull(milestone.getBase().getStartDate())){
                base.setStartDate(milestone.getBase().getStartDate());
            }else {
                base.setStartDate(instance.getBase().getStartDate());
            }

            // Update Last date
            if(Objects.nonNull(milestone.getBase().getEndDate())){
                base.setEndDate(milestone.getBase().getEndDate());
            }else {
                base.setEndDate(instance.getBase().getEndDate());
            }

            //Update title
            if(Objects.nonNull(milestone.getBase().getTitle()) && !"".equals(milestone.getBase().getTitle())){
                base.setTitle(milestone.getBase().getTitle());
            }else {
                base.setTitle(instance.getBase().getTitle());
            }

            //Update Description
            if(Objects.nonNull(milestone.getBase().getDescription()) && !"".equals(milestone.getBase().getDescription())){
                base.setDescription(milestone.getBase().getDescription());
            }else {
                base.setDescription(instance.getBase().getDescription());
            }
            instance.setBase(base);
        }

        // Update goal
        if(Objects.nonNull(milestone.getGoal())){
            Goal goal = goalRepository.findById(milestone.getGoal()).get();
            instance.setGoal(goal);
        }

        return milestoneRepository.save(instance);
    }
}
