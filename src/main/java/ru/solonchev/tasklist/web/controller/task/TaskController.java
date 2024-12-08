package ru.solonchev.tasklist.web.controller.task;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.solonchev.tasklist.web.dto.task.TaskDto;
import ru.solonchev.tasklist.web.dto.validation.OnUpdate;

@RequestMapping("/api/v1/tasks")
public interface TaskController {

    @Operation(
            summary = "Update task",
            description = "Updating already existing task with validation",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Successfully updated task",
                            content = @Content(schema = @Schema(implementation = TaskDto.class))
                    )
            }
    )
    @PutMapping
    TaskDto update(
            @Parameter(description = "Task data transfer object to update.", required = true,
                    schema = @Schema(implementation = TaskDto.class)
            )
            @Validated(OnUpdate.class)
            @RequestBody
            TaskDto taskDto
    );

    @Operation(
            summary = "Get task by id",
            description = "Get task by identifier",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Successfully retrieved task",
                            content = @Content(schema = @Schema(implementation = TaskDto.class))
                    )
            }
    )
    @GetMapping("/{taskId}")
    TaskDto getById(
            @Parameter(description = "Task identifier", required = true, in = ParameterIn.PATH)
            @PathVariable
            Long taskId
    );

    @Operation(
            summary = "Delete task by id",
            description = "Delete task by identifier",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Successfully deleted task"
                    )
            }
    )
    @DeleteMapping("/{taskId}")
    void deleteById(
            @Parameter(description = "Task identifier", required = true, in = ParameterIn.PATH)
            @PathVariable
            Long taskId
    );
}
