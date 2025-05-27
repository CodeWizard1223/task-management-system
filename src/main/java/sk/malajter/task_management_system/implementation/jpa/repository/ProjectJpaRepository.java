package sk.malajter.task_management_system.implementation.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sk.malajter.task_management_system.implementation.jpa.entity.ProjectEntity;

import java.util.List;

@Repository
public interface ProjectJpaRepository extends JpaRepository<ProjectEntity, Long> {

    // @Query("select * from project where user_id = ?1")
    List<ProjectEntity> findAllByUserId(Long userId);
}
