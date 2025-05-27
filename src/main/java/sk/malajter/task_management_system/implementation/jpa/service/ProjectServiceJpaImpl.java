package sk.malajter.task_management_system.implementation.jpa.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import sk.malajter.task_management_system.api.ProjectService;
import sk.malajter.task_management_system.api.request.ProjectAddRequest;
import sk.malajter.task_management_system.api.request.ProjectEditRequest;
import sk.malajter.task_management_system.domain.Project;
import sk.malajter.task_management_system.implementation.jpa.entity.ProjectEntity;
import sk.malajter.task_management_system.implementation.jpa.repository.ProjectJpaRepository;

import java.util.List;

@Service
@Primary
public class ProjectServiceJpaImpl implements ProjectService {

    private final ProjectJpaRepository repository;

    public ProjectServiceJpaImpl(ProjectJpaRepository repository) {
        this.repository = repository;
    }

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

    private Project mapProjectEntityToProject(ProjectEntity entity) {
        return new Project(
                entity.getId(),
                entity.getUser().getId(),
                entity.getName(),
                entity.getDescription(),
                entity.getCreatedAt()
        );
    }
}
