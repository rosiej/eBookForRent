package pl.sdacademy.domain;

public class User {
    String login;
    String password;

    public String getPassword() {
        return password;
    }

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }
}
