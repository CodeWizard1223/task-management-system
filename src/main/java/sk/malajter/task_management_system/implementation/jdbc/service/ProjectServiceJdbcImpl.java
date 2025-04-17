package sk.malajter.task_management_system.implementation.jdbc.service;

import org.springframework.stereotype.Service;
import sk.malajter.task_management_system.api.ProjectService;
import sk.malajter.task_management_system.api.request.ProjectAddRequest;
import sk.malajter.task_management_system.api.request.ProjectEditRequest;
import sk.malajter.task_management_system.domain.Project;

import java.util.List;

@Service
public class ProjectServiceJdbcImpl implements ProjectService {
    @Override
    public Project get(long id) {
        return null;
    }

    @Override
    public List<Project> getAll() {
        return List.of();
    }

    @Override
    public List<Project> getAllByUser(long userId) {
        return List.of();
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
