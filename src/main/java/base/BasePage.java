package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class BasePage {

    private WebDriver driver;
    private WebDriverWait wait;

    public BasePage(WebDriver pDriver) {
        wait = new WebDriverWait(pDriver, 10);
        driver = pDriver;
    }

    public String getURL() {
        return driver.getCurrentUrl();
    }

    public WebDriverWait getWait() {
        return wait;
    }

    public void getWaitSeconds(Integer seconds) {
        driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void dispose() {
        if (driver != null) {
            driver.quit();
        }
    }
}
