package ru.solonchev.tasklist.web.dto.jwt;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class JwtRequest {

    @NotNull(message = "Username must not be null.")
    private String username;

    @NotNull(message = "Password must be not null.")
    private String password;
}
