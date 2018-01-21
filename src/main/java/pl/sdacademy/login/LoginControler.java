package pl.sdacademy.login;

import pl.sdacademy.communication.Response;
import pl.sdacademy.domain.User;
import pl.sdacademy.domain.UserStorage;

import java.util.Map;

public class LoginControler {

    private UserStorage userStorage;

    public LoginControler(UserStorage userStorage) {

        this.userStorage = userStorage;
    }


    public Response logIn(String login, String password) {

        Response response = new Response();

        if(userStorage.containsUserWith(login, password)) {
            response.setSuccess(true);
            response.setMessage("Zalogowałeś się!");
        }else if(userStorage.containsUserWith(login)&&!userStorage.containsUserWith(login,password)){
            response.setSuccess(false);
            response.setMessage("niepoprawne hasło");
        } else {
            response.setSuccess(false);
            response.setMessage("użytkownik nie istnieje");
        }
//        else {
//
//            Map users = userStorage.getUsers();
//            if(users.get(login).equals(new User(login,password)))
//            {
//                response.setSuccess(true);
//                response.setMessage("Zalogowałeś się!");
//
//            }
//            else {
//                response.setSuccess(false);
//                response.setMessage("niepoprawne hasło");
//            }
//
//        }
        return response;
    }
}
