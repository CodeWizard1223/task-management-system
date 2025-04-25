package sk.malajter.task_management_system.implementation.jdbc.service;

import org.springframework.stereotype.Service;
import sk.malajter.task_management_system.api.UserService;
import sk.malajter.task_management_system.api.request.UserAddRequest;
import sk.malajter.task_management_system.domain.User;
import sk.malajter.task_management_system.implementation.jdbc.repository.ProjectJdbcRepository;
import sk.malajter.task_management_system.implementation.jdbc.repository.TaskJdbcRepository;
import sk.malajter.task_management_system.implementation.jdbc.repository.UserJdbcRepository;

import java.util.List;

@Service
public class UserServiceJdbcImpl implements UserService {

    private final UserJdbcRepository repository;

    private final ProjectJdbcRepository projectJdbcRepository;

    private final TaskJdbcRepository taskJdbcRepository;

    public UserServiceJdbcImpl(UserJdbcRepository repository, ProjectJdbcRepository projectJdbcRepository, TaskJdbcRepository taskJdbcRepository) {
        this.repository = repository;
        this.projectJdbcRepository = projectJdbcRepository;
        this.taskJdbcRepository = taskJdbcRepository;
    }

    @Override
    public long add(UserAddRequest request) {
        return repository.add(request);
    }

    @Override
    public void delete(long id) {
        if (this.get(id) != null) {
            taskJdbcRepository.deleteAllByUser(id);
            projectJdbcRepository.deleteAllByUser(id);
            repository.delete(id);
        }
    }

    @Override
    public User get(long id) {
        return repository.getById(id);
    }

    @Override
    public List<User> getAll() {
        return repository.getAll();
    }
}
