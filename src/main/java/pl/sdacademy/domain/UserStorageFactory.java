package pl.sdacademy.domain;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class UserStorageFactory {

    public UserStorage createFileUserStorage() {
        UserStorage userStorage = null;
        try {
            userStorage = new FileUserStorage(new Scanner(new File("UsersRecord.txt")));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        return userStorage;
    }
}
