package ru.solonchev.tasklist.repository;

import ru.solonchev.tasklist.domain.user.Role;
import ru.solonchev.tasklist.domain.user.User;

import java.util.Optional;

public interface UserRepository {
    Optional<User> findById(Long id);

    Optional<User> findByUsername(String username);

    void update(User user);

    void create(User user);

    void insertUserRole(Long useId, Role role);

    boolean isTaskOwner(Long userId, Long taskId);

    void delete(Long userId);
}
