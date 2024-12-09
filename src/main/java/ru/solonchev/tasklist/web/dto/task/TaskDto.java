package ru.solonchev.tasklist.web.dto.task;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import ru.solonchev.tasklist.domain.task.TaskStatus;
import ru.solonchev.tasklist.web.dto.validation.OnCreate;
import ru.solonchev.tasklist.web.dto.validation.OnUpdate;

import java.time.LocalDateTime;

@Data
@Schema(description = "Task data transfer object.")
public class TaskDto {

    @NotNull(message = "Id must be not null.", groups = OnUpdate.class)
    @Schema(description = "Task identifier.", example = "1")
    private Long id;

    @NotNull(message = "Id must be not null.", groups = {OnCreate.class, OnUpdate.class})
    @Size(max = 255, message = "Title must be less than 255 characters.", groups = {OnCreate.class, OnUpdate.class})
    @Schema(description = "Task title.", example = "Task title")
    private String title;

    @Size(max = 255, message = "Title must be less than 255 characters.", groups = {OnCreate.class, OnUpdate.class})
    @Schema(description = "Task description.", example = "Task description")
    private String description;

    @Schema(description = "Task status.", example = "CREATED", allowableValues = {"CREATED", "IN_PROGRESS", "COMPLETED"})
    private TaskStatus taskStatus;

    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @Schema(description = "Task creation date.", example = "2021-12-31T23:59")
    private LocalDateTime expirationDate;
}
