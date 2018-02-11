
package pl.sdacademy.registration;

import org.junit.Test;
import pl.sdacademy.communication.Response;
import pl.sdacademy.domain.User;
import pl.sdacademy.domain.UserStorage;
import pl.sdacademy.domain.UserStorageFactory;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RegistrationControllerTest {

    @Test
    public void shouldRegisteredNewUser() {
        UserStorage userStorage = new UserStorageFactory().createFileUserStorage();

        Response result = new RegistrationController(userStorage).register("login", "pasword");

        assertEquals(true, result.isSuccess());
    }

    @Test
    public void passwordIsTooShort() {
        Response result = new RegistrationController(new UserStorageFactory().createFileUserStorage()).register("loginus", "pa");

        assertEquals(false, result.isSuccess());
        assertEquals("password is too short", result.getMessage());
    }

    @Test
    public void userAlreadyExist() {
        UserStorage userStorage = new UserStorageFactory().createFileUserStorage();
        userStorage.addUser(new User("login1","pasword"));

        Response result = new RegistrationController(userStorage).register("login1", "pasword");

        assertEquals(false, result.isSuccess());
        assertEquals("User already exist", result.getMessage());
        assertTrue(userStorage.containsUserWith("login1"));

    }
}
