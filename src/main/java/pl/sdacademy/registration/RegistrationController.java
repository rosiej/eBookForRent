package pl.sdacademy.registration;

public class RegistrationController {


    public Response register(String login, String pasword) {

        Response response = new Response();

        response.setSuccess(true);

        UserStorage userStorage = new UserStorage();

        if(pasword.length()<=6){
            response.setSuccess(false);
            response.setMessage("password is too short");
        }
        if(userStorage.containsUserWith(login)){
            response.setSuccess(false);
            response.setMessage("User already exist");
        }

        return response;
    }
}
