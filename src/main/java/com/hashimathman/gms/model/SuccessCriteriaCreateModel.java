package com.hashimathman.gms.model;

import com.hashimathman.gms.entity.SuccessCriteria;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SuccessCriteriaCreateModel {
    private SuccessCriteria success;
    private Long goal;
    private Long milestone;
    private Long task;
}
