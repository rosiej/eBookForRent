package pl.sdacademy.login;

import pl.sdacademy.communication.Response;
import pl.sdacademy.systeminterface.SystemInterface;

public class LogInUi {

    private LogInControler logInControler;
    private SystemInterface systemInterface;


    public LogInUi(SystemInterface systemInterface, LogInControler logInControler) {
       this.logInControler = logInControler;
        this.systemInterface = systemInterface;
    }
    public Response logInUi(){
        systemInterface.display("Podaj login:");
        String login = systemInterface.readInformation();

        systemInterface.display("Podaj hasło:");
        String password = systemInterface.readInformation();

        Response response = logInControler.logIn(login,password);

        if(response.isSuccess()){
            systemInterface.display("Zalogowany: "+login);
            systemInterface.display("");
        }else{
            systemInterface.display(response.getMessage());
        }
        return response;
    }
}

