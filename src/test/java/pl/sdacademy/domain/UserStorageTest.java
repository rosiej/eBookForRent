package pl.sdacademy.domain;

import org.junit.Test;

import java.io.File;
import java.util.Scanner;

public class UserStorageTest {
    @Test(expected = UserAlreadyExistException.class)
    public void containsUserWithTest() throws Exception{
        UserStorage userStorage = new FileUserStorage(new Scanner(new File("UsersRecord.txt")));
        User user1 = new User("login","password");
        User user2 = new User("login","password2");


       userStorage.addUser(user1);
       userStorage.addUser(user2);
    }



}