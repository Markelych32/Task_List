package ru.solonchev.tasklist.service.impl;

import org.springframework.stereotype.Service;
import ru.solonchev.tasklist.service.AuthService;
import ru.solonchev.tasklist.web.dto.jwt.JwtRequest;
import ru.solonchev.tasklist.web.dto.jwt.JwtResponse;

@Service
public class AuthServiceImpl implements AuthService {
    @Override
    public JwtResponse login(JwtRequest loginRequest) {
        return null;
    }

    @Override
    public JwtResponse refresh(String refreshToken) {
        return null;
    }
}
