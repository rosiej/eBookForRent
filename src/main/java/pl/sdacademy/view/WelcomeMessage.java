package pl.sdacademy.view;

import pl.sdacademy.domain.UsersRecord;
import pl.sdacademy.login.LogInUi;
import pl.sdacademy.registration.RegistrationUi;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class WelcomeMessage {
    public enum State{
        INIT,
        LOGGED,
        EXIT,
        ADMIN;

    }

    public enum State {
        INIT,
        LOGGING,
        LOGGED,
        REGISTRATING,
        EXIT;
    }

    public void welcomeMessage(RegistrationUi registrationUi, LogInUi logInUi, Scanner scanner, UsersRecord usersRecord) throws FileNotFoundException {

        State state = State.INIT;

        while(true) {
            switch (state) {
                case INIT:
                    System.out.println("Menu ");
                    System.out.println("Wybierz opcję: \n Zarejstruj się - wciśnij 1 \n Zaloguj się - wciśnij 2 \n Wyłącz program - wciśnij 3");
                    String choice = scanner.nextLine();
                    if (choice.equals("1")) {
                        if(registrationUi.registrationUi().isSuccess()) {
                            registrationUi.registrationUi();
                            state = State.LOGGED;
                        } else {
                            state = State.INIT;
                        }
                        break;

                    }
                    if (choice.equals("2")) {
                        if (logInUi.logInUi().isSuccess()) {
                            logInUi.logInUi();
                            state = State.LOGGED;
                        } else {
                            state = State.INIT;
                        }
                        break;
                    }
//                    if (choice.equals("3")) {
//                        usersRecord.readingRecord();
//                        welcomeMessage(registrationUi, logInUi, scanner, usersRecord);
//                    }
                    if (choice.equals("3")) {
                        state = State.EXIT;
                        break;
                    }

                case EXIT:
                    System.out.println("Do zobaczenia!");
                    return;

                case LOGGED:
                    System.out.println("Menu ");
                    System.out.println("Wybierz opcję: \n Wypożycz eBook - 1 \n Twoje eBooki  \n Wyłącz program - wciśnij 3");
                    String loggedChoice = scanner.nextLine();

                    if(loggedChoice.equals("1")){
                        break;
                    }
                    if(loggedChoice.equals("2")){
                        break;
                    }
                    if (loggedChoice.equals("3")){
                        state = State.EXIT;
                        break;
                    }
            }
        }

    }
}
