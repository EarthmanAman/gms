package com.hashimathman.gms.repository;

import com.hashimathman.gms.entity.Goal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoalRepository extends JpaRepository<Goal, Long> {

    public List<Goal> findByBaseIsDone(Boolean isDone);
}
