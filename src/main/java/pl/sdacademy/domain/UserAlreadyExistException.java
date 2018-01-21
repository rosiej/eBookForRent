package pl.sdacademy.domain;

public class UserAlreadyExistException extends RuntimeException {
    public UserAlreadyExistException(String login) {
        super("User with login: " + login + "already exists.");
    }
}
