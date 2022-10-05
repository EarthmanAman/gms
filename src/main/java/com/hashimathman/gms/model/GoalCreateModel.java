package com.hashimathman.gms.model;

import com.hashimathman.gms.entity.BaseModel;
import com.hashimathman.gms.entity.SuccessCriteria;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoalCreateModel {
    private BaseModel base;
    private List<SuccessCriteria> successCriteriaList;
}
