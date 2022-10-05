package com.hashimathman.gms.service;

import com.hashimathman.gms.entity.SuccessCriteria;
import org.springframework.stereotype.Service;

import java.util.List;


public interface SuccessCriteriaService {
    public SuccessCriteria createSuccessCriteria(SuccessCriteria successCriteria);

    public List<SuccessCriteria> getSuccess();
}
