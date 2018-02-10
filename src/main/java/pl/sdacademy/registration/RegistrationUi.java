package pl.sdacademy.registration;

import pl.sdacademy.communication.Response;
import pl.sdacademy.systeminterface.SystemInterface;


public class RegistrationUi {


    private RegistrationController registrationController;
    private SystemInterface systemInterface;

    public RegistrationUi(SystemInterface systemInterface, RegistrationController registrationController) {
        this.registrationController = registrationController;
        this.systemInterface = systemInterface;
    }


    public Response registrationUi() {
        systemInterface.display("Podaj login: ");
        String login = systemInterface.readInformation();

        systemInterface.display("Podaj hasło: ");
        String password = systemInterface.readInformation();

        Response response = registrationController.register(login, password);

        if(response.isSuccess()){
            systemInterface.display("Witaj, "+ login);
            systemInterface.display("");
        }else{
            systemInterface.display(response.getMessage());
            systemInterface.display("");
        }
        return response;


    }
}

