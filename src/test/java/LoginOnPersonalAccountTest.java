import Controllers.AuthController;
import Controllers.UserController;
import Rules.Rules;
import org.junit.After;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

public class LoginOnPersonalAccountTest {
    AuthController authController;
    UserController userController;

    @Rule
    public Rules rules = new Rules();

    @Test
    public void registerUser() {
        authController = new AuthController();
        userController = new UserController();

        MainPage mainPageObject = new MainPage(rules.getWebDriver());
        EnterPage enterPage = new EnterPage(rules.getWebDriver());

        userController.postUser(Constants.RANDOM_EMAIL, Constants.RANDOM_PASSWORD, Constants.RANDOM_EMAIL);
        mainPageObject.clickPersonalAccountButton();
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
