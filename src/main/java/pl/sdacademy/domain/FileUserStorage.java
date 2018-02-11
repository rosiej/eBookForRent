package pl.sdacademy.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class FileUserStorage implements UserStorage {
    private Map<String, User> users = new HashMap<String, User>();
    private Scanner scanner;

    FileUserStorage(Scanner scanner) {
        this.scanner = scanner;
    }


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


    public boolean containsUserWith(String login, String password) {
        if(containsUserWith(login)) {
            User user = users.get(login);
            return user.hasTheSamePasswordAs(password);
        }

        return false;
    }
}