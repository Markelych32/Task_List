package ru.solonchev.tasklist.web.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import ru.solonchev.tasklist.domain.task.Task;
import ru.solonchev.tasklist.web.dto.task.TaskDto;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface TaskMapper {

    TaskDto toDto(Task task);

    List<TaskDto> toDto(List<Task> taskList);

    Task toEntity(TaskDto taskDto);

}
