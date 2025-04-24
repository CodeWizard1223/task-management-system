package sk.malajter.task_management_system.implementation.jdbc.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import sk.malajter.task_management_system.api.exception.InternalErrorException;
import sk.malajter.task_management_system.api.exception.ResourceNotFoundException;
import sk.malajter.task_management_system.domain.Task;
import sk.malajter.task_management_system.implementation.jdbc.mapper.TaskRowMapper;

import java.util.List;

@Repository
public class TaskJdbcRepository {

    private final JdbcTemplate jdbcTemplate;

    private final TaskRowMapper taskRowMapper;

    public TaskJdbcRepository(JdbcTemplate jdbcTemplate, TaskRowMapper taskRowMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.taskRowMapper = taskRowMapper;
    }

    private static final Logger logger;

    private static final String GET_ALL;

    private static final String GET_BY_ID;

    private static final String GET_ALL_BY_USER;

    private static final String GET_ALL_BY_PROJECT;

    static {
        logger = LoggerFactory.getLogger(TaskJdbcRepository.class);
        GET_ALL = "SELECT * FROM task";
        GET_BY_ID = "SELECT * FROM task WHERE id = ?";
        GET_ALL_BY_USER = "SELECT * FROM task WHERE user_id = ?";
        GET_ALL_BY_PROJECT = "SELECT * FROM task WHERE project_id = ?";
    }

    public List<Task> getAll() {
        try {
            return jdbcTemplate.query(GET_ALL, taskRowMapper);
        } catch (DataAccessException e) {
            logger.error("Error while getting all tasks.", e);
            throw new InternalErrorException("Error while getting all tasks.");
        }
    }

    public Task getById(long id) {
        try {
            return jdbcTemplate.queryForObject(GET_BY_ID, taskRowMapper, id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("User with id: " + id + " was not found.");
        } catch (DataAccessException e) {
            logger.error("Error while getting task.", e);
            throw new InternalErrorException("Error while getting task.");
        }
    }

    public List<Task> getAllByUserId(long userId) {
        try {
            return jdbcTemplate.query(GET_ALL_BY_USER, taskRowMapper, userId);
        } catch (DataAccessException e) {
            logger.error("Error while getting all tasks by userId.", e);
            throw new InternalErrorException("Error while getting all tasks by userId.");
        }
    }

    public List<Task> getAllByProject(long projectId) {
        try {
            return jdbcTemplate.query(GET_ALL_BY_PROJECT, taskRowMapper, projectId);
        } catch (DataAccessException e) {
            logger.error("Error while getting all tasks by projectId.", e);
            throw new InternalErrorException("Error while getting all tasks by projectId.");
        }
    }
}
