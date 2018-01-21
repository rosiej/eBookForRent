package pl.sdacademy.registration;

import java.util.HashMap;
import java.util.Map;

public class UserStorage {
    private Map<String, User> users = new HashMap<String, User>();

    public boolean containsUserWith(String login) {
        return users.containsKey(login);
    }

    public void addUser(User user) {
        if(containsUserWith(user.getLogin())){
            throw new UserAlreadyExistException(user.getLogin());
        }else{
            users.put(user.getLogin(), user);
        }
    }


}