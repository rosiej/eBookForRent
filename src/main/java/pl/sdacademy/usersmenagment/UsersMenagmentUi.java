package pl.sdacademy.usersmenagment;

import pl.sdacademy.communication.Response;
import pl.sdacademy.domain.UserStorage;

import java.util.Scanner;

public class UsersMenagmentUi {

    private Scanner scanner = new Scanner(System.in);
    private UsersMenagmentControl usersMenagmentControl;

    public UsersMenagmentUi(UserStorage userStorage) {
        usersMenagmentControl = new UsersMenagmentControl(userStorage);
    }

    public void printListOfUsers() {
            Response response = usersMenagmentControl.printUsersList();
            System.out.println(response.getMessage());
            if (response.isSuccess()) {
                System.out.println(response.getMessage());
            } else {
                System.out.println("coś poszlo nie tak");
            }
        }

    public void eraseUser() {
        System.out.println("wpisz login użytkownika, którego chcesz usunąć");
        String login = scanner.nextLine();
        Response response = usersMenagmentControl.deleteAnUser(login);
        if(response.isSuccess()){
            System.out.println("Użytkownik "+login+", został usunięty");
        }
    }


}
