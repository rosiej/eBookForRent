package pl.sdacademy.usersmenagment;


import pl.sdacademy.communication.Response;
import pl.sdacademy.domain.User;
import pl.sdacademy.domain.UserStorage;

import java.util.Map;
import java.util.Set;

public class UsersMenagmentControl {
    private UserStorage userStorage;

    public UsersMenagmentControl(UserStorage userStorage) {

        this.userStorage = userStorage;

    }

    public Response printUsersList() {

        StringBuilder usersList = new StringBuilder();

        String begining = "Lista użytkowników: \n" +
                "login / hasło:\n";

        usersList.append(begining);

        Response response = new Response();
        Set<Map.Entry<String,User>> usersSet = new UsersMenagmentControl(userStorage).userStorage.getUsers().entrySet();

        int i = 1;
        for( Map.Entry<String, User> user: usersSet){
            usersList.append(i+") ").append(user.getValue().getLogin()).append(" / ").append(user.getValue().getPassword()).append("\n");
            i++;
        }
        response.setSuccess(true);
        response.setMessage(usersList.toString());


        return response;
    }

    public Response deleteAnUser(String login) {

        Response response = new Response();

        userStorage.erase(login);

        response.setMessage("Użytkownik "+login+", został usunięty");
        response.setSuccess(true);
        return response;
    }
}
