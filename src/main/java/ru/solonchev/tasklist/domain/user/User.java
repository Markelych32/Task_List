package ru.solonchev.tasklist.domain.user;

import lombok.Data;
import ru.solonchev.tasklist.domain.task.Task;

import java.util.List;
import java.util.Set;

@Data
public class User {
    private Long id;
    private String name;
    private String username;
    private String password;
    private String passwordConfirmation;
    private Set<Role> roles;
    private List<Task> tasks;
}
