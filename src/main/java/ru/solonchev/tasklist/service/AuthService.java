package ru.solonchev.tasklist.service;

import ru.solonchev.tasklist.web.dto.jwt.JwtRequest;
import ru.solonchev.tasklist.web.dto.jwt.JwtResponse;

public interface AuthService {

    JwtResponse login(JwtRequest loginRequest);

    JwtResponse refresh(String refreshToken);
}
