package pl.sdacademy.registration;

public class UserAlreadyExistException extends RuntimeException {
    public UserAlreadyExistException(String login) {
        super("User with login: " + login + "already exists.");
    }
}
