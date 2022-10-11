package com.hashimathman.gms.model;

import com.hashimathman.gms.entity.BaseModel;
import com.hashimathman.gms.entity.Milestone;
import com.hashimathman.gms.entity.SuccessCriteria;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskCreateModel {
    private BaseModel base;
    private List<SuccessCriteria> successCriteriaList;
    private List<Milestone> children;
    private List<Long> parents;
    private Long milestone;
}
