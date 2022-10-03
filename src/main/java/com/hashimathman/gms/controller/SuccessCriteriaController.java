package com.hashimathman.gms.controller;

import com.hashimathman.gms.entity.Goal;
import com.hashimathman.gms.entity.SuccessCriteria;
import com.hashimathman.gms.model.SuccessCriteriaCreateModel;
import com.hashimathman.gms.repository.GoalRepository;
import com.hashimathman.gms.service.SuccessCriteriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class SuccessCriteriaController {
    @Autowired
    private SuccessCriteriaService successCriteriaService;

    @Autowired
    private GoalRepository goalRepository;
    @PostMapping("/api/v1/success")
    public SuccessCriteria createSuccess(@RequestBody SuccessCriteriaCreateModel successCriteriaCreateModel){

        SuccessCriteria successCriteria = successCriteriaCreateModel.getSuccess();
        Optional<Goal> goal = goalRepository.findById(successCriteriaCreateModel.getGoal());
        successCriteria.setGoal(goal);
        return successCriteriaService.createSuccessCriteria(successCriteria);
    }
}
