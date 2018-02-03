package pl.sdacademy.view;

import pl.sdacademy.login.LogInUi;
import pl.sdacademy.registration.RegistrationUi;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class WelcomeMessage {

    public void welcomeMessage(RegistrationUi registrationUi, LogInUi logInUi, Scanner scanner) throws FileNotFoundException {

        System.out.println("Menu ");
        System.out.println("Wybierz opcję: \n Zarejstruj się - wciśnij 1 \n Zaloguj się - wciśnij 2 \n Wyłącz program - wciśnij 3");
        String choice = scanner.nextLine();
        if (choice.equals("1")) {
            registrationUi.registrationUi();
            welcomeMessage(registrationUi,logInUi,scanner);
        }if (choice.equals("2")){
            logInUi.logInUi();
            welcomeMessage(registrationUi,logInUi,scanner);
        }if (choice.equals("3")){
            System.out.println("Do zobaczenia!");
            return;
        }

    }
}
