package pl.sdacademy.domain;

import org.junit.Test;
import pl.sdacademy.domain.User;
import pl.sdacademy.domain.UserAlreadyExistException;
import pl.sdacademy.domain.UserStorage;

public class UserStorageTest {
    @Test(expected = UserAlreadyExistException.class)
    public void containsUserWithTest() throws Exception{
        UserStorage userStorage = new UserStorage();
        User user1 = new User("login","password");
        User user2 = new User("login","password2");


       userStorage.addUser(user1);
       userStorage.addUser(user2);
    }



}