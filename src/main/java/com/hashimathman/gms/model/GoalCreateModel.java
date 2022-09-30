package com.hashimathman.gms.model;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class GoalCreateModel {
    private Date startDate;
    private Date endDate;
    private String title;
    private String description;
}
