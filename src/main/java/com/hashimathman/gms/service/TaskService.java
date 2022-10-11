package com.hashimathman.gms.service;

import com.hashimathman.gms.entity.Task;
import com.hashimathman.gms.model.TaskCreateModel;

public interface TaskService {
    public Task createTask(TaskCreateModel taskCreateModel);

    public Task updateTask(Long id, TaskCreateModel taskCreateModel);


    public void deleteTask(Long id);
}
