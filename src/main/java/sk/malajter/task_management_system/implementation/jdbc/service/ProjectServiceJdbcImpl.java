package sk.malajter.task_management_system.implementation.jdbc.service;

import org.springframework.stereotype.Service;
import sk.malajter.task_management_system.api.ProjectService;
import sk.malajter.task_management_system.api.request.ProjectAddRequest;
import sk.malajter.task_management_system.api.request.ProjectEditRequest;
import sk.malajter.task_management_system.domain.Project;
import sk.malajter.task_management_system.implementation.jdbc.repository.ProjectJdbcRepository;
import sk.malajter.task_management_system.implementation.jdbc.repository.UserJdbcRepository;

import java.util.List;

@Service
public class ProjectServiceJdbcImpl implements ProjectService {

    private final ProjectJdbcRepository projectJdbcRepository;

    private final UserJdbcRepository userJdbcRepository;

    public ProjectServiceJdbcImpl(ProjectJdbcRepository projectJdbcRepository, UserJdbcRepository userJdbcRepository) {
        this.projectJdbcRepository = projectJdbcRepository;
        this.userJdbcRepository = userJdbcRepository;
    }

    @Override
    public Project get(long id) {
        return projectJdbcRepository.getById(id);
    }

    @Override
    public List<Project> getAll() {
        return projectJdbcRepository.getAll();
    }

    @Override
    public List<Project> getAllByUser(long userId) {
        if (userJdbcRepository.getById(userId) != null) {
            return projectJdbcRepository.getAllByUserId(userId);
        }

        // It cannot happen because if condition above returns null, it throws exceptions anyway.
        return null;
    }

    @Override
    public void delete(long id) {
    }

    @Override
    public long add(ProjectAddRequest request) {
        return 0;
    }

    @Override
    public void edit(long id, ProjectEditRequest request) {

    }
}
