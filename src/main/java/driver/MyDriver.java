package driver;

import configurations.PropertyManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class MyDriver {

    private WebDriver driver;

    public MyDriver() {

        String osPlatform = PropertyManager.getInstance().getOsPlatform();
        //Retrieve the name of the browser from properties file.
        String browser = PropertyManager.getInstance().getBrowser();

        switch (browser) {
            case "firefox":
                setFirefoxDriver(osPlatform);
                driver = new FirefoxDriver();
                break;
            case "chrome":
                setChromeDriver(osPlatform);
                driver = new ChromeDriver();
                break;
            default:
                System.setProperty("webdriver.ie.driver", "src/test/resources/drivers/MicrosoftWebDriver.exe");
                driver = new InternetExplorerDriver();
                break;
        }
    }

    private void setFirefoxDriver(String OS){
        if (OS.indexOf("Win") >= 0){
            System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver.exe");
        }else if(OS.indexOf("Mac") >=0)
            System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver");
    }

    private void setChromeDriver(String OS){
        if (OS.indexOf("Win") >= 0){
            System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        }else if(OS.indexOf("Mac") >=0)
            System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");
    }

    public WebDriver getDriver() {
        return driver;
    }

}
