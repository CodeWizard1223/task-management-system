package sk.malajter.task_management_system;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import sk.malajter.task_management_system.api.exception.BadRequestException;
import sk.malajter.task_management_system.api.exception.ResourceNotFoundException;
import sk.malajter.task_management_system.api.request.UserAddRequest;
import sk.malajter.task_management_system.domain.User;

import java.util.List;

public class UserIntegrationTests extends IntegrationTest {

    @Test
    public void getAll() {
        final ResponseEntity<List<User>> userResponse = restTemplate.exchange(
                "/user",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {}
        );

        Assertions.assertEquals(HttpStatus.OK, userResponse.getStatusCode());
        Assertions.assertNotNull(userResponse.getBody());
        Assertions.assertTrue(userResponse.getBody().size() >= 2);
    }

    @Test
    public void insert() {
        insertUser(generateRandomUser());
    }

    @Test
    public void getUser() {
        final UserAddRequest addRequest = generateRandomUser();
        final long id = insertUser(addRequest);

        final ResponseEntity<User> user = restTemplate.getForEntity(
                "/user/" + id,
                User.class
        );

        Assertions.assertEquals(HttpStatus.OK, user.getStatusCode());
        Assertions.assertNotNull(user.getBody());

        Assertions.assertEquals(id, user.getBody().getId());
        Assertions.assertEquals(addRequest.getName(), user.getBody().getName());
        Assertions.assertEquals(addRequest.getEmail(), user.getBody().getEmail());
    }

    @Test
    public void deleteUser() {
        final UserAddRequest request = generateRandomUser();
        final long id = insertUser(request);

        // Delete user.
        final ResponseEntity<Void> deleteResponse = restTemplate.exchange(
                "/user/" + id,
                HttpMethod.DELETE,
                null,
                Void.class
        );
        Assertions.assertEquals(HttpStatus.OK, deleteResponse.getStatusCode());

        // Deleted user should not be found.
        final ResponseEntity<ResourceNotFoundException> getResponse = restTemplate.getForEntity(
                "/user/" + id,
                ResourceNotFoundException.class
        );
        Assertions.assertEquals(HttpStatus.NOT_FOUND, getResponse.getStatusCode());
    }

    @Test
    public void insertEmailAlreadyExists() {
        final UserAddRequest request = generateRandomUser();
        final long id = insertUser(request);

        final ResponseEntity<BadRequestException> badRequest = restTemplate.postForEntity(
                "/user",
                request,
                BadRequestException.class
        );
        Assertions.assertEquals(HttpStatus.BAD_REQUEST, badRequest.getStatusCode());
    }

    private UserAddRequest generateRandomUser() {
        return new UserAddRequest(
                "test" + Math.random(),
                "email" + Math.random()
        );
    }

    private long insertUser(UserAddRequest request) {
        final ResponseEntity<Long> insertResponse = restTemplate.postForEntity(
                "/user",
                request,
                Long.class
        );

        Assertions.assertEquals(HttpStatus.CREATED, insertResponse.getStatusCode());
        Assertions.assertNotNull(insertResponse.getBody());

        return insertResponse.getBody();
    }
}
