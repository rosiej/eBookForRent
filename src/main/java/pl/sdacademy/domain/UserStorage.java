package pl.sdacademy.domain;

import java.util.HashMap;
import java.util.Map;

public class UserStorage {


    public Map<String, User> getUsers() {
        return users;
    }

    private Map<String, User> users = new HashMap<String, User>();

    public boolean containsUserWith(String login) {
        return users.containsKey(login);
    }

    public void addUser(User user) {
        if (containsUserWith(user.getLogin())) {
            throw new UserAlreadyExistException(user.getLogin());
        } else {
            users.put(user.getLogin(), user);
        }
    }


    public boolean containsUserWith(String login, String password) {
        if (containsUserWith(login)) {
            User user = users.get(login);
            return user.hasTheSamePasswordAs(password);
        }

        return false;
    }

    public void
    erase(String login) {
        if (users.containsKey(login)) {
            users.remove(login);
        } else {
            throw new ThereIsNoUserWithSuchLoginException(login);
        }
    }
}