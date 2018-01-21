package pl.sdacademy.login;

import org.junit.Test;
import pl.sdacademy.communication.Response;
import pl.sdacademy.domain.User;
import pl.sdacademy.domain.UserStorage;

import static org.junit.Assert.*;

public class LoginControlerTest {

    @Test
    public void userShoulBeAbleToLogIn(){
        UserStorage userStorage = new UserStorage();
        userStorage.addUser(new User("login","password"));
        Response result = new LoginControler (userStorage).logIn("login","password");

        assertEquals(true, result.isSuccess());
    }

}