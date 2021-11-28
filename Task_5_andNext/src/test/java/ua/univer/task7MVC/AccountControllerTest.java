package ua.univer.task7MVC;

import org.junit.Test;


import static org.junit.Assert.*;

public class AccountControllerTest {


    @Test
    public void isActivated_account() {
        AccountController accountController = new AccountController(new AccountModel(),new AccountView());
        assertEquals("test failed", false,AccountController.isActivated_account());
    }

}