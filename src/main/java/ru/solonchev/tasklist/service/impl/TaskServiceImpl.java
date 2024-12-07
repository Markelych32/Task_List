package ru.solonchev.tasklist.service.impl;

import org.springframework.stereotype.Service;
import ru.solonchev.tasklist.domain.task.Task;
import ru.solonchev.tasklist.service.TaskService;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
    @Override
    public Task getById(Long taskId) {
        return null;
    }

    @Override
    public List<Task> getAllTask(Long userId) {
        return List.of();
    }

    @Override
    public Task update(Task task) {
        return null;
    }

    @Override
    public Task create(Task task) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
