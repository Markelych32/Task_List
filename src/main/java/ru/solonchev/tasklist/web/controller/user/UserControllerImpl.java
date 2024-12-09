package ru.solonchev.tasklist.web.controller.user;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.solonchev.tasklist.domain.task.Task;
import ru.solonchev.tasklist.domain.user.User;
import ru.solonchev.tasklist.service.TaskService;
import ru.solonchev.tasklist.service.UserService;
import ru.solonchev.tasklist.web.dto.task.TaskDto;
import ru.solonchev.tasklist.web.dto.user.UserDto;
import ru.solonchev.tasklist.web.dto.validation.OnUpdate;
import ru.solonchev.tasklist.web.mapper.TaskMapper;
import ru.solonchev.tasklist.web.mapper.UserMapper;

import java.util.List;

@RestController
@Validated
public class UserControllerImpl implements UserController {

    private final UserService userService;
    private final TaskService taskService;

    private final UserMapper userMapper;
    private final TaskMapper taskMapper;

    public UserControllerImpl(UserService userService, TaskService taskService, UserMapper userMapper, TaskMapper taskMapper) {
        this.userService = userService;
        this.taskService = taskService;
        this.userMapper = userMapper;
        this.taskMapper = taskMapper;
    }

    @Override
    public UserDto update(
            @Validated(OnUpdate.class)
            @RequestBody UserDto userDto
    ) {
        User user = userMapper.toEntity(userDto);
        User updatedUser = userService.update(user);
        return userMapper.toDto(updatedUser);
    }

    @Override
    public UserDto getById(@PathVariable Long userId) {
        User user = userService.getById(userId);
        return userMapper.toDto(user);
    }

    @Override
    public void delete(@PathVariable Long userId) {
        userService.delete(userId);
    }

    @Override
    public List<TaskDto> getTasksByUserId(@PathVariable Long userId) {
        List<Task> tasks = taskService.getAllTask(userId);
        return taskMapper.toDto(tasks);
    }

    @Override
    public TaskDto createTask(
            @PathVariable Long userId,
            @Validated(OnUpdate.class) TaskDto taskDto
    ) {
        Task task = taskMapper.toEntity(taskDto);
        Task createdTask = taskService.create(task, userId);

        return taskMapper.toDto(createdTask);
    }
}
