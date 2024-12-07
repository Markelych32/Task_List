package ru.solonchev.tasklist.web.dto.task;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import ru.solonchev.tasklist.domain.task.Status;
import ru.solonchev.tasklist.web.dto.validation.OnCreate;
import ru.solonchev.tasklist.web.dto.validation.OnUpdate;

import java.time.LocalDateTime;

@Data
public class TaskDto {

    @NotNull(message = "Id must be not null.", groups = OnUpdate.class)
    private Long id;

    @NotNull(message = "Id must be not null.", groups = {OnCreate.class, OnUpdate.class})
    @Size(max = 255, message = "Title must be less than 255 characters.", groups = {OnCreate.class, OnUpdate.class})
    private String title;

    @Size(max = 255, message = "Title must be less than 255 characters.", groups = {OnCreate.class, OnUpdate.class})
    private String description;

    private Status status;

    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime expirationDate;
}
