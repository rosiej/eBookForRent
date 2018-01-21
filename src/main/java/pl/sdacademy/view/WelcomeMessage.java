package pl.sdacademy.view;

import pl.sdacademy.registration.RegistrationUi;

import java.util.Scanner;

public class WelcomeMessage {

    public void welcomeMessage(RegistrationUi registrationUi, Scanner scanner) {

        System.out.println("Menu: ");
        System.out.println("Wybierz opcję, \n Zarejstruj się - wciśnij 1 \n Zaloguj się - wciśnij 2 \n Wyłącz program - wciśnij 3");
        String choice = scanner.nextLine();
        if (choice.equals("1")) {
            registrationUi.registrationUi();
            welcomeMessage(registrationUi,scanner);
        }if (choice.equals("2")){
            welcomeMessage(registrationUi,scanner);
        }if (choice.equals("3")){
            System.out.println("Do zobaczenia!");
            return;
        }

    }
}
