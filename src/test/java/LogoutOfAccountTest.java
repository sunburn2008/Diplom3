import Controllers.AuthController;
import Controllers.UserController;
import Rules.Rules;
import org.junit.After;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

public class LogoutOfAccountTest {
    AuthController authController;
    UserController userController;

    @Rule
    public Rules rules = new Rules();

    @Test
    public void logoutOfAccount() {
        authController = new AuthController();
        userController = new UserController();

        RegisterPage registerPage = new RegisterPage(rules.getWebDriver());
        MainPage mainPageObject = new MainPage(rules.getWebDriver());
        EnterPage enterPage = new EnterPage(rules.getWebDriver());

        userController.postUser(Constants.RANDOM_EMAIL, Constants.RANDOM_PASSWORD, Constants.RANDOM_EMAIL);
        mainPageObject.clickEnterAccountButton();
        enterPage.fillEnterFields(Constants.RANDOM_EMAIL, Constants.RANDOM_PASSWORD)
                .clickEnterButton();
        mainPageObject.clickPersonalAccountButton();
        registerPage.clickExitButton();
        registerPage.checkExitButton();
        Assert.assertTrue(registerPage.checkExitButton());
    }

    @After
    public void tearDown() {
        String token = authController.getUserToken(Constants.RANDOM_EMAIL, Constants.RANDOM_PASSWORD);
        userController.deleteUser(token).then().statusCode(202);
    }
}
