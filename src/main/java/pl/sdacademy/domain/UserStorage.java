package pl.sdacademy.domain;

public interface UserStorage {

    boolean containsUserWith(String login);

    void addUser(User user);

    boolean containsUserWith(String login, String password);
}
