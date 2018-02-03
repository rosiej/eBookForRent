package pl.sdacademy;

import pl.sdacademy.domain.UserStorage;
import pl.sdacademy.login.LogInUi;
import pl.sdacademy.registration.RegistrationUi;
import pl.sdacademy.usersmenagment.UsersMenagmentUi;
import pl.sdacademy.view.WelcomeMessage;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        UserStorage userStorage;
        userStorage = new UserStorage();

        Scanner scanner;
        scanner = new Scanner(System.in);

        RegistrationUi registrationUi;
        registrationUi = new RegistrationUi(userStorage);

        UsersMenagmentUi usersMenagmentUi;
        usersMenagmentUi = new UsersMenagmentUi(userStorage);

        LogInUi logInUi;
        logInUi = new LogInUi(userStorage);

       new WelcomeMessage().welcomeMessage(registrationUi,logInUi,scanner, usersMenagmentUi);
    }
}
