package login;

import base.TestBase;
import org.junit.jupiter.api.Test;
import pageobjects.Login;

public class LoginTest extends TestBase {

    @Test
    public void testLogin()
    {
        Login login = new Login();
        login.login("Admin","admin123");
    }
}
