package pl.sdacademy.login;

import org.junit.Test;
import pl.sdacademy.communication.Response;
import pl.sdacademy.domain.User;
import pl.sdacademy.domain.UserStorage;
import pl.sdacademy.domain.UserStorageFactory;

import static org.junit.Assert.*;

public class LogInControlerTest {

    @Test
    public void userShoulBeAbleToLogIn() {
        UserStorage userStorage = new UserStorageFactory().createFileUserStorage();
        userStorage.addUser(new User("login","password"));
        Response result = new LogInControler(userStorage).logIn("login","password");

        assertEquals(true, result.isSuccess());
    }
    @Test
    public void invalidPassword() {
        UserStorage userStorage = new UserStorageFactory().createFileUserStorage();
        userStorage.addUser(new User("login","pasword1"));
        Response result = new LogInControler(userStorage).logIn("login","password2");

        assertEquals(false, result.isSuccess());
        assertEquals("Niepoprawne hasło",result.getMessage());
    }
    @Test
    public void noSuchUserInDataBase() {
        UserStorage userStorage = new UserStorageFactory().createFileUserStorage();
        userStorage.addUser(new User("login","password"));
        Response result = new LogInControler(userStorage).logIn("login1","password");

        assertEquals(false,result.isSuccess());
        assertEquals("Użytkownik nie istnieje",result.getMessage());
    }
}