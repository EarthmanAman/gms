package com.hashimathman.gms.controller;

import com.hashimathman.gms.entity.SuccessCriteria;
import com.hashimathman.gms.model.SuccessCriteriaCreateModel;
import com.hashimathman.gms.service.SuccessCriteriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SuccessCriteriaController {
    @Autowired
    private SuccessCriteriaService successCriteriaService;
    @PostMapping("/api/v1/success")
    public SuccessCriteria createSuccess(@RequestBody SuccessCriteria successCriteria){
        System.out.println(successCriteria);
        return successCriteriaService.createSuccessCriteria(successCriteria);
    }
}
