package com.hashimathman.gms.service;

import com.hashimathman.gms.entity.SuccessCriteria;
import com.hashimathman.gms.repository.SuccessCriteriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SuccessCriteriaServiceImpl implements SuccessCriteriaService{
    @Autowired
    private SuccessCriteriaRepository successCriteriaRepository;
    @Override
    public SuccessCriteria createSuccessCriteria(SuccessCriteria successCriteria) {
        return successCriteriaRepository.save(successCriteria);
    }

    @Override
    public List<SuccessCriteria> getSuccess() {
        return successCriteriaRepository.findAll();
    }
}
