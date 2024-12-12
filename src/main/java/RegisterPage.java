import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterPage {

    private static final By REGISTER_PICTOGRAM = By.xpath(".//a[text() = 'Зарегистрироваться']");
    private static final By FIELD_NAME = By.xpath("//input[@name = 'name']");
    private static final By FIELD_EMAIL = By.xpath("//label[text()='Email']/following-sibling::input");
    private static final By FIELD_PASSWORD = By.xpath("//input[@name='Пароль']");
    private static final By REGISTER_BUTTON = By.xpath("//button[text() = 'Зарегистрироваться']");
    private static final By INCORRECT_PASSWORD_WARNING = By.xpath("//form//div//p[text() = 'Некорректный пароль']");
    private static final By RECOVERY_PASSWORD_PICTOGRAM = By.xpath("//a[text() = 'Восстановить пароль']");
    private static final By ENTER_PICTOGRAM = By.xpath("//a[text() = 'Войти']");
    private static final By EXIT_BUTTON = By.xpath("//button[text() = 'Выход']");

    private final WebDriver webDriver;
    private final WebDriverWait webDriverWait;

    public RegisterPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
    }

    public boolean checkIncorrectPasswordWarning() {
        WebElement warn = webDriverWait.until(ExpectedConditions.visibilityOf(webDriver.findElement(INCORRECT_PASSWORD_WARNING)));
        return warn.isDisplayed();
    }

    public RegisterPage clickRegisterPictogram() {
        webDriver.findElement(REGISTER_PICTOGRAM).click();
        return this;
    }

    public RegisterPage fillRegisterFields(String name, String email, String password) {
        webDriver.findElement(FIELD_NAME).sendKeys(name);
        webDriver.findElement(FIELD_EMAIL).sendKeys(email);
        webDriver.findElement(FIELD_PASSWORD).sendKeys(password);
        return this;
    }

    public RegisterPage clickRecoveryPasswordPictogram() {
        webDriver.findElement(RECOVERY_PASSWORD_PICTOGRAM).click();
        return this;
    }

    public RegisterPage clickEnterPictogram() {
        webDriver.findElement(ENTER_PICTOGRAM).click();
        return this;
    }

    public RegisterPage clickRegisterButton() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(REGISTER_BUTTON)));
        WebElement registerButton = webDriver.findElement(REGISTER_BUTTON);
        registerButton.click();
        return this;
    }

    public RegisterPage clickExitButton() {
        WebElement button = webDriverWait.until(ExpectedConditions.elementToBeClickable(EXIT_BUTTON));
        button.click();
        return this;
    }

    public boolean checkExitButton() {
        return webDriver.findElement(EXIT_BUTTON).isDisplayed();
    }
}
