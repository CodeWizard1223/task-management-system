package sk.malajter.task_management_system.api;

import sk.malajter.task_management_system.api.request.TaskAddRequest;
import sk.malajter.task_management_system.api.request.TaskEditRequest;
import sk.malajter.task_management_system.api.request.UserAddRequest;
import sk.malajter.task_management_system.domain.Task;
import sk.malajter.task_management_system.domain.TaskStatus;

import java.util.List;

public interface TaskService {

    long add(TaskAddRequest request);

    void edit(long id, TaskEditRequest request);

    void changeStatus(long id, TaskStatus status);

    void assignProject(long taskId, long projectId);

    void delete(long id);

    Task get(long id);

    List<Task> getAll();

    List<Task> getAllByUserId(long userId);

    List<Task> getAllByProjectId(long projectId);
}
