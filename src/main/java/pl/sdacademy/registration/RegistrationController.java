package pl.sdacademy.registration;

public class RegistrationController {


    public Response register(String login, String pasword) {


        Response response = new Response();
        response.setSuccess(true);

        if(pasword.length()<=6){
            response.setSuccess(false);
            response.setMessage("password is too short");
        }

        return response;
    }
}
