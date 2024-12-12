import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {

    private final WebDriver webDriver;
    private final WebDriverWait webDriverWait;

    private static final By ENTER_IN_ACCOUNT = By.xpath("//main/section//button[text() = 'Войти в аккаунт']");
    private static final By CREATE_ORDER = By.xpath("//button[text() = 'Оформить заказ']");
    private static final By PERSONAL_ACCOUNT = By.xpath("//a[normalize-space() = 'Личный Кабинет']");
    private static final By MAIN_LOGO = By.xpath("//div[@class = 'AppHeader_header__logo__2D0X2']//a/*[name() = 'svg']");
    private static final By CONSTRUCTOR_BUTTON = By.xpath("//p[text() = 'Конструктор']");
    private static final By CREATE_BURGER = By.xpath("//main//h1[text() = 'Соберите бургер']");

    public static final By SAUCE_HEADER = By.xpath("//div[contains(@class, 'tab_tab__1SPyG') and contains(@class, 'tab_tab_type_current__2BEPc')]//span[text()='Соусы']");
    public static final By FILLING_HEADER = By.xpath("//div[contains(@class, 'tab_tab__1SPyG') and contains(@class, 'tab_tab_type_current__2BEPc')]//span[text()='Начинки']");
    public static final By BUN_HEADER = By.xpath("//div[contains(@class, 'tab_tab__1SPyG') and contains(@class, 'tab_tab_type_current__2BEPc')]//span[text()='Булки']");

    public static final By bunSection = By.xpath("//h2[text() = 'Булки']");
    public static final By sauceSection = By.xpath("//h2[text() = 'Соусы']");
    public static final By fillingSection = By.xpath("//h2[text() = 'Начинки']");


    public MainPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(3));
    }


    public MainPage clickEnterAccountButton() {
        webDriverWait.until(ExpectedConditions.visibilityOf(webDriver.findElement(ENTER_IN_ACCOUNT)));
        webDriver.findElement(ENTER_IN_ACCOUNT).click();
        return this;
    }

    public boolean checkEnterInAccountButton() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(ENTER_IN_ACCOUNT));
         return webDriver.findElement(ENTER_IN_ACCOUNT).isDisplayed();
    }

    public MainPage clickPersonalAccountButton() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(PERSONAL_ACCOUNT));
        webDriver.findElement(PERSONAL_ACCOUNT).click();
        return this;
    }

    public MainPage clickMainLogo() {
        webDriver.findElement(MAIN_LOGO).click();
        return this;
    }

    public boolean checkCreateOrderButton() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(CREATE_ORDER));
        return webDriver.findElement(CREATE_BURGER).isDisplayed();
    }

    public MainPage clickConstructorButton() {
        webDriver.findElement(CONSTRUCTOR_BUTTON).click();
        return this;
    }

    public void scrollToSection(By section) {
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView();", webDriver.findElement(section));
    }

    public boolean checkToSection(By header) {
        webDriverWait.until(ExpectedConditions.visibilityOf(webDriver.findElement(header)));
        return webDriver.findElement(header).isDisplayed();
    }
}
