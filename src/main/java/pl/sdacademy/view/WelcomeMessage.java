package pl.sdacademy.view;

import pl.sdacademy.login.LogInUi;
import pl.sdacademy.registration.RegistrationUi;
import pl.sdacademy.usersmenagment.UsersMenagmentUi;

import java.util.Scanner;

public class WelcomeMessage {

    public void welcomeMessage(RegistrationUi registrationUi, LogInUi logInUi, Scanner scanner, UsersMenagmentUi usersMenagmentUi) {

        System.out.println("Menu ");
        System.out.println("Wybierz opcję: \n " +
                "Zarejstruj się - wciśnij 1 \n " +
                "Zaloguj się - wciśnij 2 \n" +
                "Wydrukuj listę użytkowników - wciśnij 3 \n" +
                "Usuń użytkownika - wciśnij 4\n"+
                "Wyłącz program - wciśnij 5 \n");
        String choice = scanner.nextLine();
        if (choice.equals("1")) {
            registrationUi.registrationUi();
            welcomeMessage(registrationUi,logInUi,scanner,usersMenagmentUi);
        }if (choice.equals("2")){
            logInUi.logInUi();
            welcomeMessage(registrationUi,logInUi,scanner,usersMenagmentUi);
        }if (choice.equals("3")){
            usersMenagmentUi.printListOfUsers();
            welcomeMessage(registrationUi,logInUi,scanner,usersMenagmentUi);
        }if (choice.equals("4")){
            usersMenagmentUi.eraseUser();
            welcomeMessage(registrationUi,logInUi,scanner,usersMenagmentUi);
        }if (choice.equals("5")){
            System.out.println("Do zobaczenia!");
            return;
        }

    }
}
