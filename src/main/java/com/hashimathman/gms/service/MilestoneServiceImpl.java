package com.hashimathman.gms.service;

import com.hashimathman.gms.entity.Milestone;
import com.hashimathman.gms.repository.MilestoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MilestoneServiceImpl implements MilestoneService{

    @Autowired
    private MilestoneRepository milestoneRepository;

    @Override
    public Milestone createMilestone(Milestone milestone1) {
        return milestoneRepository.save(milestone1);
    }

    @Override
    public List<Milestone> getMilestone() {
        return milestoneRepository.findAll();
    }
}
