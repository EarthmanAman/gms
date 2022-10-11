package com.hashimathman.gms.service;

import com.hashimathman.gms.entity.BaseModel;
import com.hashimathman.gms.entity.Milestone;
import com.hashimathman.gms.entity.Task;
import com.hashimathman.gms.model.TaskCreateModel;
import com.hashimathman.gms.repository.MilestoneRepository;
import com.hashimathman.gms.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
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

    @Override
    public Task updateTask(Long id, TaskCreateModel taskCreateModel) {
        Task instance = taskRepository.findById(id).get();
        if(Objects.nonNull(taskCreateModel.getBase())){
            BaseModel base = new BaseModel();
            if(Objects.nonNull(taskCreateModel.getBase().getTitle()) && !"".equals(taskCreateModel.getBase().getTitle())){
                base.setTitle(taskCreateModel.getBase().getTitle());
            }else {
                base.setTitle(instance.getBase().getTitle());
            }

            // Change description
            if(Objects.nonNull(taskCreateModel.getBase().getDescription()) && !"".equals(taskCreateModel.getBase().getDescription())){
                base.setDescription(taskCreateModel.getBase().getDescription());
            }else {
                base.setDescription(instance.getBase().getDescription());
            }

            // Change start date
            if(Objects.nonNull(taskCreateModel.getBase().getStartDate())){
                base.setStartDate(taskCreateModel.getBase().getStartDate());
            }else {
                base.setStartDate(instance.getBase().getStartDate());
            }

            // Change end date
            if(Objects.nonNull(taskCreateModel.getBase().getEndDate())){
                base.setEndDate(taskCreateModel.getBase().getEndDate());
            }else {
                base.setEndDate(instance.getBase().getEndDate());
            }

            // Change is done
            if(Objects.nonNull(taskCreateModel.getBase().getIsDone())){
                base.setIsDone(taskCreateModel.getBase().getIsDone());
            }else {
                base.setIsDone(instance.getBase().getIsDone());
            }
            base.setCreatedDate(instance.getBase().getCreatedDate());
            instance.setBase(base);
        }

        if(Objects.nonNull(taskCreateModel.getParents()) && taskCreateModel.getParents().size() > 0){
            List<Task> parents = new ArrayList<>();
            for(Long parentId : taskCreateModel.getParents()){
                Task parent = taskRepository.findById(parentId).get();
                parents.add(parent);
            }
            instance.setParents(parents);
        }

        if(Objects.nonNull(taskCreateModel.getMilestone())){
            Milestone milestone = milestoneRepository.findById(taskCreateModel.getMilestone()).get();
            instance.setMilestone(milestone);
        }

        return taskRepository.save(instance);
    }
}
