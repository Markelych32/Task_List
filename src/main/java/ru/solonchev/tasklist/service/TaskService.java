package ru.solonchev.tasklist.service;

import ru.solonchev.tasklist.domain.task.Task;

import java.util.List;

public interface TaskService {

    Task getById(Long taskId);

    List<Task> getAllTask(Long userId);

    Task update(Task task);

    Task create(Task task, Long userId);

    void delete(Long id);
}
