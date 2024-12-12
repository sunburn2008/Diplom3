import Rules.Rules;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;

@RunWith(Parameterized.class)
public class SwitchBetweenSectionsTest {

    private final By header;
    private final By section;

    @Rule
    public Rules rules = new Rules();

    public SwitchBetweenSectionsTest(By header, By section) {
        this.header = header;
        this.section = section;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][]{
                {MainPage.SAUCE_HEADER, MainPage.sauceSection},
                {MainPage.FILLING_HEADER, MainPage.fillingSection},
                {MainPage.BUN_HEADER, MainPage.bunSection},
        };
    }

    @Test
    public void transitionsToFillingSections() {
        MainPage mainPage = new MainPage(rules.getWebDriver());
        mainPage.scrollToSection(section);
        Assert.assertTrue(mainPage.checkToSection(header));
    }
}
