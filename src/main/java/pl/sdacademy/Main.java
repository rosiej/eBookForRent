package pl.sdacademy;

import pl.sdacademy.domain.UserStorage;
import pl.sdacademy.registration.RegistrationUi;
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

       new WelcomeMessage().welcomeMessage(registrationUi,scanner);
    }
}
