package ru.solonchev.tasklist.web.controller.user;

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
import ru.solonchev.tasklist.web.dto.user.UserDto;
import ru.solonchev.tasklist.web.dto.validation.OnUpdate;

import java.util.List;

@RequestMapping("/api/v1/users")
public interface UserController {

    @Operation(
            summary = "Update user",
            description = "Updating already existing user with validation",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Successfully updated user",
                            content = @Content(schema = @Schema(implementation = UserDto.class))
                    )
            }
    )
    @PutMapping
    UserDto update(
            @Parameter(description = "User data transfer object", required = true,
                    schema = @Schema(implementation = UserDto.class), in = ParameterIn.DEFAULT
            )
            @Validated(OnUpdate.class)
            @RequestBody UserDto userDto
    );

    @Operation(
            summary = "Get user by id",
            description = "Get user by identifier",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Successfully retrieved user",
                            content = @Content(schema = @Schema(implementation = UserDto.class))
                    )
            }
    )
    @GetMapping("/{userId}")
    UserDto getById(
            @Parameter(description = "User identifier", required = true, in = ParameterIn.PATH)
            @PathVariable Long userId
    );

    @Operation(
            summary = "Delete user",
            description = "Delete user by identifier",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Successfully deleted user"
                    )
            }
    )
    @DeleteMapping("/{userId}")
    void delete(
            @Parameter(description = "User identifier", required = true, in = ParameterIn.PATH)
            @PathVariable Long userId
    );

    @Operation(
            summary = "Get tasks by user id",
            description = "Get all tasks by user identifier",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Successfully retrieved tasks",
                            content = @Content(schema = @Schema(implementation = UserDto.class))
                    )
            }
    )
    @GetMapping("/{userId}/tasks")
    List<TaskDto> getTasksByUserId(
            @Parameter(description = "User identifier", required = true, in = ParameterIn.PATH)
            @PathVariable Long userId
    );

    @Operation(
            summary = "Create task",
            description = "Create task for user",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Successfully created task",
                            content = @Content(schema = @Schema(implementation = TaskDto.class))
                    )
            }
    )
    @PutMapping("/{userId}/tasks")
    TaskDto createTask(
            @Parameter(description = "User identifier", required = true, in = ParameterIn.PATH)
            @PathVariable Long userId,
            @Parameter(description = "Task data transfer object", required = true,
                    schema = @Schema(implementation = TaskDto.class)
            )
            @Validated(OnUpdate.class)
            @RequestBody TaskDto taskDto
    );
}
