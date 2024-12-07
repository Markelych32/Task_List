package ru.solonchev.tasklist.repository.impl;

import org.springframework.stereotype.Repository;
import ru.solonchev.tasklist.domain.task.Task;
import ru.solonchev.tasklist.repository.TaskRepository;

import java.util.List;
import java.util.Optional;

@Repository
public class TaskRepositoryImpl implements TaskRepository {
    @Override
    public Optional<Task> findById(Long taskId) {
        return Optional.empty();
    }

    @Override
    public List<Task> findAllTask(Long userId) {
        return List.of();
    }

    @Override
    public void assignToUserById(Long taskId, Long userId) {

    }

    @Override
    public void update(Task task) {

    }

    @Override
    public void create(Task task) {

    }

    @Override
    public void delete(Long id) {

    }
}
