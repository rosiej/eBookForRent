package pl.sdacademy.domain;

import pl.sdacademy.domain.User;
import pl.sdacademy.domain.UserAlreadyExistException;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

public class UserStorage {

    public UserStorage() throws FileNotFoundException {
    }

    public Map<String, User> getUsers() {
        return users;
    }

    private Map<String, User> users = new HashMap<String, User>();

    private UsersRecord usersRecord = new UsersRecord();

    public boolean containsUserWith(String login) {
        return users.containsKey(login);
    }

    public void addUser(User user) throws FileNotFoundException {
        if(containsUserWith(user.getLogin())){
            throw new UserAlreadyExistException(user.getLogin());
        }else{
            users.put(user.getLogin(), user);
            usersRecord.addingRecord(user);
        }
    }


    public boolean containsUserWith(String login, String password) {
        if(containsUserWith(login)) {
            User user = users.get(login);
            return user.hasTheSamePasswordAs(password);
        }

        return false;
    }
}