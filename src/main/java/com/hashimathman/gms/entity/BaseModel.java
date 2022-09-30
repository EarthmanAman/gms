package com.hashimathman.gms.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.Instant;
import java.util.Date;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@MappedSuperclass

public class BaseModel {
    private String title;
    private String description;
    private Date createdDate;
    private Date startDate;
    private Date modifiedDate;
    private Date endDate;
    private Boolean isDone;
    @PrePersist
    public void onPrePersist(){
        Date date = new Date();
        setCreatedDate(date);
        setModifiedDate(date);
    }

    @PreUpdate
    public void onPreUpdate(){
        setModifiedDate(new Date());
    }
}
