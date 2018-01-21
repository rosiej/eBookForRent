package pl.sdacademy.userUi;

import pl.sdacademy.registration.RegistrationController;
import pl.sdacademy.registration.Response;
import pl.sdacademy.registration.UserStorage;

import java.util.Scanner;

public class RegistrationUi {


    private Scanner scanner = new Scanner(System.in);

    private RegistrationController registrationController = new RegistrationController(new UserStorage());

    public void welcomeMessage() {
        System.out.println("Witaj gościu! Zarejestruj się!");
        System.out.println("podaj login: ");
        String login = scanner.nextLine();

        System.out.println("podaj hasło: ");
        String password = scanner.nextLine();

        Response response = registrationController.register(login, password);

        if(response.isSuccess()){
            System.out.println("Witaj, "+ login);
        }else{

            System.out.println(response.getMessage());
        }


    }
}

