import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class EnterPage {

    private final WebDriver webDriver;
    private final WebDriverWait webDriverWait;

    public EnterPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(3));
    }

    private static final By FIELD_EMAIL = By.xpath("//label[text()='Email']/following-sibling::input");
    private static final By FIELD_PASSWORD = By.xpath("//form//input[@name='Пароль']");
    private static final By ENTER_BUTTON = By.xpath("//button[text() = 'Войти']");
    private static final By ENTER_TEXT = By.xpath("//h2[text() = 'Вход']");

    public boolean checkEnterTextIsVisible() {
        return webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(ENTER_TEXT)).isDisplayed();
    }

    public EnterPage fillEnterFields(String email, String password) {
        if (checkEnterTextIsVisible()) {
            WebElement emailField = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(FIELD_EMAIL));
            WebElement passwordField = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(FIELD_PASSWORD));
            emailField.sendKeys(email);
            passwordField.sendKeys(password);
        }
        return this;
    }

    public EnterPage clickEnterButton() {
        WebElement enterButton = webDriverWait.until(ExpectedConditions.elementToBeClickable(ENTER_BUTTON));
        enterButton.click();
        return this;
    }
}