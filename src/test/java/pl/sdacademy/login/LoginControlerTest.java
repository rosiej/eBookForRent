package pl.sdacademy.login;

import pl.sdacademy.domain.User;
import pl.sdacademy.domain.UserStorage;

import static org.junit.Assert.*;

public class LoginControlerTest {

    public void userShoulBeAbleToLogIn(){
        UserStorage userStorage = new UserStorage();
        userStorage.addUser(new User("login","password"));
        LoginControler loginControler = new LoginControler();
        assertTrue(loginControler.logIn());
    }

}