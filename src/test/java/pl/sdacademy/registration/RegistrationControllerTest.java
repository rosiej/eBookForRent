
package pl.sdacademy.registration;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RegistrationControllerTest {

    @Test
    public void shouldRegisteredNewUser(){
        Response result = new RegistrationController().register("login","pasword");
        assertEquals(true,result.isSuccess());
    }


}
