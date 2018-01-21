package pl.sdacademy.registration;

public class RegistrationController {


    private UserStorage userStorage;

    public RegistrationController(UserStorage userStorage) {

        this.userStorage = userStorage;
    }

    public Response register(String login, String pasword) {

        Response response = new Response();

        if(userStorage.containsUserWith(login)) {
            response.setSuccess(false);
            response.setMessage("User already exist");

        }else if(pasword.length()<=6){
            response.setSuccess(false);
            response.setMessage("password is too short");
        }else{
            response.setSuccess(true);
            User user = new User(login, pasword);
        }

        return response;
    }

}
