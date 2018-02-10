package pl.sdacademy.domain;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UserStorage {

    public UserStorage() throws FileNotFoundException {
    }
    public Map<String, User> getUsers() {
        return users;
    }

    private Map<String, User> users = new HashMap<String, User>();

    private UsersRecord usersRecord = new UsersRecord();

    Scanner scanner = new Scanner(new File("UsersRecord.txt"));

    public boolean containsUserWith(String login) {
        return users.containsKey(login);
    }

    public void uploadUsersList(){
        while(scanner.hasNext()){
            String[] user = scanner.nextLine().split(" ; ");
            users.put(user[0].toString(),new User(user[0].toString(),user[1].toString()));
        }
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