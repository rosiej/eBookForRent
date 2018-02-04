package pl.sdacademy.registration;

import pl.sdacademy.communication.Response;
import pl.sdacademy.domain.UserStorage;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class RegistrationUi {


    private Scanner scanner = new Scanner(System.in);
    private RegistrationController registrationController;

    public RegistrationUi(UserStorage userStorage) throws FileNotFoundException {
        registrationController = new RegistrationController(userStorage);
    }


    public Response registrationUi() throws FileNotFoundException {
        System.out.println("podaj login: ");
        String login = scanner.nextLine();

        System.out.println("podaj hasło: ");
        String password = scanner.nextLine();

        Response response = registrationController.register(login, password);

        if(response.isSuccess()){
            System.out.println("Witaj, "+ login);
            System.out.println();
        }else{

            System.out.println(response.getMessage());
            System.out.println();
        }
        return response;


    }
}

