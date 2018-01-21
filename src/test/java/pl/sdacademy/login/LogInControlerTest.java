package pl.sdacademy.login;

import org.junit.Test;
import pl.sdacademy.communication.Response;
import pl.sdacademy.domain.User;
import pl.sdacademy.domain.UserStorage;

import static org.junit.Assert.*;

public class LogInControlerTest {

    @Test
    public void userShoulBeAbleToLogIn(){
        UserStorage userStorage = new UserStorage();
        userStorage.addUser(new User("login","password"));
        Response result = new LogInControler(userStorage).logIn("login","password");

        assertEquals(true, result.isSuccess());
    }
    @Test
    public void invalidPassword() {
        UserStorage userStorage = new UserStorage();
        userStorage.addUser(new User("login","pasword1"));
        Response result = new LogInControler(userStorage).logIn("login","password2");

        assertEquals(false, result.isSuccess());
        assertEquals("niepoprawne hasło",result.getMessage());
    }
    @Test
    public void noSuchUserInDataBase(){
        UserStorage userStorage = new UserStorage();
        userStorage.addUser(new User("login","password"));
        Response result = new LogInControler(userStorage).logIn("login1","password");

        assertEquals(false,result.isSuccess());
        assertEquals("użytkownik nie istnieje",result.getMessage());
    }


}