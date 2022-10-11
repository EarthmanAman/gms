package com.hashimathman.gms.controller;

import com.hashimathman.gms.entity.Task;
import com.hashimathman.gms.model.TaskCreateModel;
import com.hashimathman.gms.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {

    @Autowired
    private TaskService taskService;
    @PostMapping("/api/v1/tasks")
    public Task createTask(@RequestBody TaskCreateModel taskCreateModel){
        return taskService.createTask(taskCreateModel);
    }

    @PutMapping("/api/v1/tasks/{id}/parents")
    public Task updateTask(@PathVariable("id") Long id, @RequestBody TaskCreateModel taskCreateModel){
        return taskService.updateTask(id, taskCreateModel);
    }
}
