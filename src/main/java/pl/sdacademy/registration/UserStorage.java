package pl.sdacademy.registration;

import java.util.HashMap;
import java.util.Map;

public class UserStorage {

    UserStorage() {

    }

    Map <String, String> users = new HashMap<String, String>();
    {


    }

    public boolean containsUserWith(String login) {

        return users.containsKey(login);
    }
}