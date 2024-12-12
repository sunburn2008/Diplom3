import Rules.Rules;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

public class RegisterWithIncorrectPasswordTest {

    @Rule
    public Rules rules = new Rules();

    @Test
    public void registerUser() {
        RegisterPage registerPage = new RegisterPage(rules.getWebDriver());
        MainPage mainPageObject = new MainPage(rules.getWebDriver());


        mainPageObject.clickEnterAccountButton();
        registerPage.clickRegisterPictogram()
                .fillRegisterFields(Constants.RANDOM_USER_NAME, Constants.RANDOM_EMAIL, Constants.INCORRECT_PASSWORD);
        registerPage.clickRegisterButton();
                registerPage.checkIncorrectPasswordWarning();
        Assert.assertTrue(registerPage.checkIncorrectPasswordWarning());
    }
}
