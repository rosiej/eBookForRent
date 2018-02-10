package pl.sdacademy.login;

import org.junit.Test;
import pl.sdacademy.communication.Response;
import pl.sdacademy.domain.User;
import pl.sdacademy.domain.UserStorage;

import java.io.FileNotFoundException;

import static org.junit.Assert.*;

public class LogInControlerTest {

    @Test
    public void userShoulBeAbleToLogIn() throws FileNotFoundException {
        UserStorage userStorage = new UserStorage();
        userStorage.addUser(new User("login","password"));
        Response result = new LogInControler(userStorage).logIn("login","password");

        assertEquals(true, result.isSuccess());
    }
    @Test
    public void invalidPassword() throws FileNotFoundException {
        UserStorage userStorage = new UserStorage();
        userStorage.addUser(new User("login","pasword1"));
        Response result = new LogInControler(userStorage).logIn("login","password2");

        assertEquals(false, result.isSuccess());
        assertEquals("Niepoprawne hasło",result.getMessage());
    }
    @Test
    public void noSuchUserInDataBase() throws FileNotFoundException {
        UserStorage userStorage = new UserStorage();
        userStorage.addUser(new User("login","password"));
        Response result = new LogInControler(userStorage).logIn("login1","password");

        assertEquals(false,result.isSuccess());
        assertEquals("Użytkownik nie istnieje",result.getMessage());
    }


}