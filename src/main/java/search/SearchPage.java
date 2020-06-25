package search;

import base.BasePage;
import configurations.PropertyManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class SearchPage extends BasePage {

    public SearchPage(WebDriver pDriver) {
        super(pDriver);
        String baseURL = PropertyManager.getInstance().getURL();
        pDriver.get(baseURL);
    }

    By searchInput      = By.id("gh-ac");
    By searchButton     = By.id("gh-btn");
    By searchResult     = By.cssSelector("");
    By searchChkBox     = By.xpath("[aria-label=PUMA]");
    By searchDropDown   = By.cssSelector("srp-controls__sort srp-controls__control");

    public void searchEbay(String search){
        getDriver().findElement(searchInput).sendKeys(search);
        getDriver().findElement(searchButton).click();

    }

    public void numResult(){
        getDriver().findElement(searchResult);
        System.out.println(searchResult + "Find shoes");
    }

    public void clickChbox(){
        getDriver().findElement(searchChkBox).click();
    }

    public void orderBy(){
        Select dropdown = new Select(getDriver().findElement(searchDropDown));
        dropdown.selectByIndex(5);
    }
}
