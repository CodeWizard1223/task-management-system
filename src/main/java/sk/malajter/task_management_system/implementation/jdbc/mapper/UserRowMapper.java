package sk.malajter.task_management_system.implementation.jdbc.mapper;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import sk.malajter.task_management_system.domain.User;

import java.sql.ResultSet;
import java.sql.SQLException;

// create bean
@Component
public class UserRowMapper implements RowMapper<User> {

    // We have mapped a line through a mapper on a user - domain class.
    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new User(
                rs.getLong("id"),
                rs.getString("name"),
                rs.getString("email")
        );
    }
}
