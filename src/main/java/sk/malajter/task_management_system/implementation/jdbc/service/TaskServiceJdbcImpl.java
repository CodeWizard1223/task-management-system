package sk.malajter.task_management_system.implementation.jdbc.service;

import sk.malajter.task_management_system.api.ProjectService;
import sk.malajter.task_management_system.api.TaskService;
import sk.malajter.task_management_system.api.UserService;
import sk.malajter.task_management_system.api.request.TaskAddRequest;
import sk.malajter.task_management_system.api.request.TaskEditRequest;
import sk.malajter.task_management_system.domain.Task;
import sk.malajter.task_management_system.domain.TaskStatus;
import sk.malajter.task_management_system.implementation.jdbc.repository.TaskJdbcRepository;

import java.util.List;

public class TaskServiceJdbcImpl implements TaskService {

    private final TaskJdbcRepository repository;

    private final UserService userService;

    private final ProjectService projectService;

    public TaskServiceJdbcImpl(TaskJdbcRepository repository, UserService userService, ProjectService projectService) {
        this.repository = repository;
        this.userService = userService;
        this.projectService = projectService;
    }

    @Override
    public long add(TaskAddRequest request) {
        return 0;
    }

    @Override
    public void edit(long id, TaskEditRequest request) {

    }

    @Override
    public void changeStatus(long id, TaskStatus status) {

    }

    @Override
    public void assignProject(long taskId, long projectId) {

    }

    @Override
    public void delete(long id) {

    }

    @Override
    public Task get(long taskId) {
        return repository.getById(taskId);
    }

    @Override
    public List<Task> getAll() {
        return repository.getAll();
    }

    @Override
    public List<Task> getAllByUser(long userId) {
        if (userService.get(userId) != null) {
            return repository.getAllByUserId(userId);
        }

        return null;
    }

    @Override
    public List<Task> getAllByProject(long projectId) {
        if (userService.get(projectId) != null) {
            return repository.getAllByProject(projectId);
        }

        return null;
    }
}
