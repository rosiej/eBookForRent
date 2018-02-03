package pl.sdacademy.domain;

public class ThereIsNoUserWithSuchLoginException extends RuntimeException {
    public ThereIsNoUserWithSuchLoginException(String login )  {
        super("User with login: " + login + "doesn't exists.");
    }
}
