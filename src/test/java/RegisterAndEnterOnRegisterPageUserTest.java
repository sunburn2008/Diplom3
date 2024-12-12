import Controllers.AuthController;
import Controllers.UserController;
import Rules.Rules;
import org.junit.After;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

public class RegisterAndEnterOnRegisterPageUserTest {
    AuthController authController;
    UserController userController;

    @Rule
    public Rules rules = new Rules();

    @Test
    public void registerUser() {
        authController = new AuthController();
        userController = new UserController();

        RegisterPage registerPage = new RegisterPage(rules.getWebDriver());
        MainPage mainPageObject = new MainPage(rules.getWebDriver());
        EnterPage enterPage = new EnterPage(rules.getWebDriver());

        mainPageObject.clickEnterAccountButton();
        registerPage.clickRegisterPictogram()
                .fillRegisterFields(Constants.RANDOM_USER_NAME, Constants.RANDOM_EMAIL, Constants.RANDOM_PASSWORD)
                .clickRegisterButton();
        enterPage.fillEnterFields(Constants.RANDOM_EMAIL, Constants.RANDOM_PASSWORD)
                .clickEnterButton();
        mainPageObject.checkCreateOrderButton();
        Assert.assertTrue(mainPageObject.checkCreateOrderButton());
    }

    @After
    public void tearDown() {
        String token = authController.getUserToken(Constants.RANDOM_EMAIL, Constants.RANDOM_PASSWORD);
        userController.deleteUser(token).then().statusCode(202);
    }
}
