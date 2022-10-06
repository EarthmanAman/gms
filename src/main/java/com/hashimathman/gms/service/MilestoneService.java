package com.hashimathman.gms.service;

import com.hashimathman.gms.entity.Milestone;

import java.util.List;

public interface MilestoneService {
    public Milestone createMilestone(Milestone milestone1);

    public List<Milestone> getMilestone();
}
