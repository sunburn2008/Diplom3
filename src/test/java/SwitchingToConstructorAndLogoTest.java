import Rules.Rules;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

public class SwitchingToConstructorAndLogoTest {

    @Rule
    public Rules rules = new Rules();

    @Test
    public void checkSwitchingToConstructor() {
        MainPage mainPageObject = new MainPage(rules.getWebDriver());
        mainPageObject.clickPersonalAccountButton();
        mainPageObject.clickConstructorButton();
        mainPageObject.checkEnterInAccountButton();
        Assert.assertTrue(mainPageObject.checkEnterInAccountButton());
    }

    @Test
    public void checkSwitchingToLogo() {
        MainPage mainPageObject = new MainPage(rules.getWebDriver());
        mainPageObject.clickPersonalAccountButton()
                .clickMainLogo()
                .checkEnterInAccountButton();
        Assert.assertTrue(mainPageObject.checkEnterInAccountButton());
    }
}
