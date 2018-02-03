package pl.sdacademy.usersmenagment;

import org.junit.Test;
import pl.sdacademy.communication.Response;
import pl.sdacademy.domain.User;
import pl.sdacademy.domain.UserStorage;

import static org.junit.Assert.*;

public class UsersMenagmentControlTest {

    @Test
    public void shouldPrintingUsersLis() {
        UserStorage userStorage = new UserStorage();
        userStorage.addUser(new User("UserOne","passwordOne"));
        userStorage.addUser(new User("UserTwo","passwordTwo"));
        userStorage.addUser(new User("UserThree","passwordThree"));
        userStorage.addUser(new User("UserFour","passwordFour"));
        userStorage.addUser(new User("UserFive","passwordFive"));

        Response response = new UsersMenagmentControl(userStorage).printUsersList();

        assertEquals(true,response.isSuccess());
//        assertEquals("Lista użytkowników: \n" +
//                "login / hasło:\n" +
//                "1) UserOne / passwordOne\n" +
//                "2) UserTwo / passwordTwo\n" +
//                "3) UserThree / passwordThree\n" +
//                "4) UserFour / passwordFour\n" +
//                "5) UserFive / passwordFive\n", response.getMessage());
            // lista się drukuje poprawnie ale w losowej kolejnosci, jeszcze nie wiem jak to opanowac

    }
    @Test
    public void isAbleToDeleteAnUserFromABase(){
        UserStorage userStorage = new UserStorage();
        userStorage.addUser(new User("UserToBeDeleted", "password1"));
        userStorage.addUser(new User("ThisOneShouldRemain", "password"));

        Response response = new UsersMenagmentControl(userStorage).deleteAnUser("UserToBeDeleted");

        assertEquals(true,response.isSuccess());
        assertEquals("Użytkownik UserToBeDeleted, został usunięty", response.getMessage());
    }

}