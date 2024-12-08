package ru.solonchev.tasklist.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.solonchev.tasklist.domain.task.Task;
import ru.solonchev.tasklist.service.TaskService;
import ru.solonchev.tasklist.web.controller.task.TaskController;
import ru.solonchev.tasklist.web.dto.task.TaskDto;
import ru.solonchev.tasklist.web.dto.validation.OnUpdate;
import ru.solonchev.tasklist.web.mapper.TaskMapper;

@RestController
@RequiredArgsConstructor
@Validated
public class TaskControllerImpl implements TaskController {

    private final TaskService taskService;
    private final TaskMapper taskMapper;

    @Override
    public TaskDto update(
            @Validated(OnUpdate.class)
            @RequestBody TaskDto taskDto
    ) {
        Task task = taskMapper.toEntity(taskDto);
        Task updatedTask = taskService.update(task);
        return taskMapper.toDto(updatedTask);
    }

    @Override
    public TaskDto getById(@PathVariable Long taskId) {
        Task task = taskService.getById(taskId);
        return taskMapper.toDto(task);
    }

    @Override
    public void deleteById(@PathVariable Long taskId) {
        taskService.delete(taskId);
    }
}
