package pl.sdacademy.login;

import pl.sdacademy.communication.Response;
import pl.sdacademy.domain.UserStorage;

import java.util.Scanner;

public class LogInUi {

    private Scanner scanner = new Scanner(System.in);
    private LogInControler logInControler;


    public LogInUi(UserStorage userStorage) {
       logInControler = new LogInControler(userStorage);
    }
    public void logInUi(){
        System.out.println("podaj login:");
        String login = scanner.nextLine();

        System.out.println("podaj hasło:");
        String password = scanner.nextLine();

        Response response = logInControler.logIn(login,password);

        if(response.isSuccess()){
            System.out.println("zalogowany: "+login);
            System.out.println();
        }else{
            System.out.println(response.getMessage());
        }
    }
}

