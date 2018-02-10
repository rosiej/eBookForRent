package pl.sdacademy.registration;

import org.junit.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import pl.sdacademy.communication.Response;
import pl.sdacademy.systeminterface.SystemInterface;

import static org.mockito.Mockito.mock;

public class RegistrationUiTest {

    public static final String LOGIN = "login";
    public static final String PASSWORD = "password";
    private static final String FAILURE = "failure message";
    private SystemInterface systemInterface = mock(SystemInterface.class);
    private RegistrationController registrationController = mock(RegistrationController.class);
    private RegistrationUi registrationUi = new RegistrationUi(systemInterface, registrationController);

    @Test
    public void shouldRegisterNewUser() {
        BDDMockito.given(systemInterface.readInformation()).willReturn(LOGIN, PASSWORD);
        BDDMockito.given(registrationController.register(LOGIN, PASSWORD)).willReturn(Response.isSuccessful());

        registrationUi.registrationUi();

        Mockito.verify(systemInterface).display("Witaj, " + LOGIN);
    }

    @Test
    public void shouldNotRegisterNewUser() {
        BDDMockito.given(systemInterface.readInformation()).willReturn(LOGIN, PASSWORD);
        BDDMockito.given(registrationController.register(LOGIN,PASSWORD)).willReturn(Response.isNotSuccessful(FAILURE));

        registrationUi.registrationUi();

        Mockito.verify(systemInterface).display(FAILURE);
    }


}