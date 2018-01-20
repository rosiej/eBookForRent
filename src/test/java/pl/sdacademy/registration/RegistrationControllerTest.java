
package pl.sdacademy.registration;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RegistrationControllerTest {

    @Test
    public void shouldRegisteredNewUser(){
        Response result = new RegistrationController().register("login","pasword");
        assertEquals(true,result.isSuccess());
    }
    
    @Test
    public void passwordIsTooShort(){
        Response result = new RegistrationController().register("login","pa");
        assertEquals(false,result.isSuccess());
        assertEquals("password is too short",result.getMessage());
    }

    /**
     * OK & NO user
     * Resp {success:true}
     *
     * OK & user exist
     * Resp {success:false, msg: user exist}
     *
     * WRONG
     * Resp {success:false, msg: pass too short}
     *
     *
     */



}
