
package pl.sdacademy.registration;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RegistrationControllerTest {

    @Test
    public void shouldRegisteredNewUser() {
        Response result = new RegistrationController().register("login", "pasword");
        assertEquals(true, result.isSuccess());
    }

    @Test
    public void passwordIsTooShort() {
        Response result = new RegistrationController().register("loginus", "pa");
        assertEquals(false, result.isSuccess());
        assertEquals("password is too short", result.getMessage());
    }

    @Test
    public void userAlreadyExist() {
        Response result = new RegistrationController().register("login1", "pasword");
        UserStorage userStorage = new UserStorage();
        userStorage.users.put("login1","pasword");
        userStorage.containsUserWith("login1");
        assertEquals(false, result.isSuccess());
        assertEquals("User already exist", result.getMessage());

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
}
