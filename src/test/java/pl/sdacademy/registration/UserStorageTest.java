package pl.sdacademy.registration;

import org.junit.Test;

import static org.junit.Assert.*;

public class UserStorageTest {
    @Test(expected = UserAlreadyExistException.class)
    public void containsUserWithTest() throws Exception{
        UserStorage userStorage = new UserStorage();
        User user1 = new User("login","password");
        User user2 = new User("login","password2");


       userStorage.addUser(user1);
       userStorage.addUser(user2);
    }

//    @Test
//    public void addUser() throws Exception {
//    }

}