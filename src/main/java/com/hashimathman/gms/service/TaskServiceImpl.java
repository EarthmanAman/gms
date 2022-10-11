package com.hashimathman.gms.service;

import com.hashimathman.gms.entity.Milestone;
import com.hashimathman.gms.entity.Task;
import com.hashimathman.gms.model.TaskCreateModel;
import com.hashimathman.gms.repository.MilestoneRepository;
import com.hashimathman.gms.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TaskServiceImpl implements TaskService{

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private MilestoneRepository milestoneRepository;
    @Override
    public Task createTask(TaskCreateModel taskCreateModel) {

        Task task = new Task();
        if(Objects.nonNull(taskCreateModel.getMilestone())){
            Milestone milestone = milestoneRepository.findById(taskCreateModel.getMilestone()).get();
            task.setMilestone(milestone);
        }
        if(Objects.nonNull(taskCreateModel.getBase())){
            task.setBase(taskCreateModel.getBase());
        }

        if(Objects.nonNull(taskCreateModel.getParents())){
            List<Task> parents = new ArrayList<>();
            for(Long parentId : taskCreateModel.getParents()){
                Task parent = taskRepository.findById(parentId).get();
                parents.add(parent);
            }
            task.setParents(parents);
        }
        if(Objects.nonNull(taskCreateModel.getSuccessCriteriaList())){
            task.setSuccessCriteriaList(taskCreateModel.getSuccessCriteriaList());
        }
        return  taskRepository.save(task);
    }
}
