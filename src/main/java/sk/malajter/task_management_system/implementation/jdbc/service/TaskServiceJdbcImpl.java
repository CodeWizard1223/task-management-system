package sk.malajter.task_management_system.implementation.jdbc.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import sk.malajter.task_management_system.api.ProjectService;
import sk.malajter.task_management_system.api.TaskService;
import sk.malajter.task_management_system.api.UserService;
import sk.malajter.task_management_system.api.exception.BadRequestException;
import sk.malajter.task_management_system.api.request.TaskAddRequest;
import sk.malajter.task_management_system.api.request.TaskEditRequest;
import sk.malajter.task_management_system.domain.Project;
import sk.malajter.task_management_system.domain.Task;
import sk.malajter.task_management_system.domain.TaskStatus;
import sk.malajter.task_management_system.implementation.jdbc.repository.TaskJdbcRepository;

import java.util.List;

@Service
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
        return repository.add(request);
    }

    @Override
    public void edit(long taskId, TaskEditRequest request) {
        if (this.get(taskId) != null) {
            repository.update(taskId, request);
        }
    }

    @Override
    public void changeStatus(long taskId, TaskStatus status) {
        if (this.get(taskId) != null) {
            repository.updateStatus(taskId, status);
        }
    }

    @Override
    public void assignProject(long taskId, long projectId) {
        final Task task = this.get(taskId);
        final Project project = projectService.get(projectId);

        if (task != null && project != null) {
            if (task.getUserId() != project.getUserId()) {
                throw new BadRequestException("Task and project must belong to the same user.");
            }
            repository.updateProject(taskId, projectId);
        }
    }

    @Override
    public void delete(long taskId) {
        if (this.get(taskId) != null) {
            repository.delete(taskId);
        }
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
