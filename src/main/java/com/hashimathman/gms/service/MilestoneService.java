package com.hashimathman.gms.service;

import com.hashimathman.gms.entity.Milestone;
import com.hashimathman.gms.model.MilestoneCreateModel;

import java.util.List;

public interface MilestoneService {
    public Milestone createMilestone(Milestone milestone1);

    public List<Milestone> getMilestone();


    public Milestone updateMilestone(Long id, MilestoneCreateModel milestone);

    public void deleteMilestone(Long id);
}
