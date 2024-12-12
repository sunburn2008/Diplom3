package Rules;

import org.junit.rules.ExternalResource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Rules extends ExternalResource {
    public static final String URL = "https://stellarburgers.nomoreparties.site";
    private WebDriver webDriver;

    protected void before() {

        ChromeOptions options = new ChromeOptions();

        if ("yandex".equals(System.getProperty("browser"))) {
            String driverPath = System.getenv("yandexDriver");
            String binaryPath = System.getenv("yandexBrowser");
            System.setProperty(System.getProperty("webdriver.chrome.driver"), driverPath);
            options.setBinary(binaryPath);
        } else {
            options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        }
        webDriver = new ChromeDriver(options);
        webDriver.get(URL);
    }

    protected void after() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }
}
