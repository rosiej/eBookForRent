package pl.sdacademy;

import pl.sdacademy.domain.UserStorage;
import pl.sdacademy.login.LogInUi;
import pl.sdacademy.registration.RegistrationUi;
import pl.sdacademy.view.WelcomeMessage;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        UserStorage userStorage;
        userStorage = new UserStorage();

        Scanner scanner;
        scanner = new Scanner(System.in);

        RegistrationUi registrationUi;
        registrationUi = new RegistrationUi(userStorage);

        LogInUi logInUi;
        logInUi = new LogInUi(userStorage);

       new WelcomeMessage().welcomeMessage(registrationUi,logInUi,scanner);
    }
}
