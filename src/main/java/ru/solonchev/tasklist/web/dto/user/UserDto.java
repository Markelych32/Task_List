package ru.solonchev.tasklist.web.dto.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import ru.solonchev.tasklist.web.dto.validation.OnCreate;
import ru.solonchev.tasklist.web.dto.validation.OnUpdate;


@Data
@Schema(description = "User data transfer object")
public class UserDto {

    @NotNull(message = "Id must be not null.", groups = OnUpdate.class)
    @Schema(description = "User identifier", example = "1")
    private Long id;

    @NotNull(message = "Name must be not null.", groups = {OnCreate.class, OnUpdate.class})
    @Size(max = 255, message = "Name must be less than 255 characters.", groups = {OnCreate.class, OnUpdate.class})
    @Schema(description = "User name", example = "John Doe")
    private String name;

    @NotNull(message = "Username must be not null.", groups = {OnCreate.class, OnUpdate.class})
    @Size(max = 255, message = "Username must be less than 255 characters.", groups = {OnCreate.class, OnUpdate.class})
    @Schema(description = "User username", example = "john@gmail.com")
    private String username;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotNull(message = "Password must be not null.", groups = {OnCreate.class, OnUpdate.class})
    @Schema(description = "User password", example = "password")
    private String password;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotNull(message = "Confirmation must be not null.", groups = {OnCreate.class})
    @Schema(description = "User password confirmation", example = "password")
    private String passwordConfirmation;
}
