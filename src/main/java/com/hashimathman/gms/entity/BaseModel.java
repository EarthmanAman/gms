package com.hashimathman.gms.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.MappedSuperclass;
import java.util.Date;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class BaseModel {
    private String title;
    private String description;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private Date createdDate;
    private Date startDate;

    @LastModifiedDate
    @Column(nullable = false, updatable = false)
    private Date modifiedDate;
    private Date endDate;
}
