package pl.sdacademy;

import pl.sdacademy.domain.*;
import pl.sdacademy.login.LogInControler;
import pl.sdacademy.login.LogInUi;
import pl.sdacademy.registration.RegistrationController;
import pl.sdacademy.registration.RegistrationUi;
import pl.sdacademy.systeminterface.CliSystemInterface;
import pl.sdacademy.view.WelcomeMessage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        EBookStorage eBookStorage = null;
        try {
            eBookStorage = new FileEBookStorage();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        UserStorage userStorage = new UserStorageFactory().createFileUserStorage();

        Scanner scanner;
        scanner = new Scanner(System.in);

        RegistrationUi registrationUi;
        registrationUi = new RegistrationUi(new CliSystemInterface(scanner), new RegistrationController(userStorage));

        LogInUi logInUi;
        logInUi = new LogInUi(new CliSystemInterface(scanner), new LogInControler(userStorage));

        UsersRecord usersRecord = null;
        try {
            usersRecord = new UsersRecord();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            new WelcomeMessage().welcomeMessage(registrationUi,logInUi,scanner, usersRecord, eBookStorage);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }
}
