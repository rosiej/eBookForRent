package pl.sdacademy;

import pl.sdacademy.domain.EBookStorage;
import pl.sdacademy.domain.UserStorage;
import pl.sdacademy.domain.UsersRecord;
import pl.sdacademy.login.LogInUi;
import pl.sdacademy.registration.RegistrationController;
import pl.sdacademy.registration.RegistrationUi;
import pl.sdacademy.systeminterface.CliSystemInterface;
import pl.sdacademy.view.WelcomeMessage;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        EBookStorage eBookStorage;
        eBookStorage = new EBookStorage();

        UserStorage userStorage;
        userStorage = new UserStorage();

        Scanner scanner;
        scanner = new Scanner(System.in);

        RegistrationUi registrationUi;
        registrationUi = new RegistrationUi(new CliSystemInterface(scanner), new RegistrationController(userStorage));

        LogInUi logInUi;
        logInUi = new LogInUi(userStorage, new CliSystemInterface(scanner));

        UsersRecord usersRecord = new UsersRecord();

        userStorage.uploadUsersList();


       new WelcomeMessage().welcomeMessage(registrationUi,logInUi,scanner, usersRecord, eBookStorage);


    }
}
