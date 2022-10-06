package com.hashimathman.gms.repository;

import com.hashimathman.gms.entity.Goal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface GoalRepository extends JpaRepository<Goal, Long> {

    public List<Goal> findByBaseIsDone(Boolean isDone);

    public List<Goal> findByBaseIsDoneAndBaseEndDateBefore(Boolean isDone, Date endDate);

    public List<Goal> findByBaseEndDateBefore(Date endDate);

    public List<Goal> findByBaseIsDoneAndBaseStartDateAfter(Boolean isDone, Date startDate);
    public List<Goal> findByBaseStartDateAfter(Date endDate);

    public List<Goal> findByBaseIsDoneAndBaseStartDateBetween(Boolean isDone, Date start, Date end);

    public List<Goal> findByBaseStartDateBetween(Date start, Date end);

    public List<Goal> findByBaseIsDoneAndBaseEndDateBetween(Boolean isDone, Date start, Date end);

    public List<Goal> findByBaseEndDateBetween(Date start, Date end);
}
