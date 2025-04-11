package sk.malajter.task_management_system.api;

import sk.malajter.task_management_system.api.request.UserAddRequest;
import sk.malajter.task_management_system.domain.User;

import java.util.List;

public interface UserService {

    long add(UserAddRequest request);

    void delete(long id);

    User get(long id);

    List<User> getAll();
}
