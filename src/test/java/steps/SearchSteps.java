package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import search.SearchPage;
import base.BaseTest;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import driver.MyDriver;

public class SearchSteps extends BaseTest {

    @Before
    public void setUp(){
        myBaseDriver = new MyDriver();
    }

    SearchPage searchPage;

    @Given("^I have access to ebay page$")
    public void openBrowser(){
        searchPage = new SearchPage(myBaseDriver.getDriver());
    }

    @When("^I enter the search (.*?)$")
    public void searchEbay(String search){
        searchPage.searchEbay(search);
    }

    @Then("I see the result shoes number$")
    public void numResult(){
        searchPage.numResult();
    }

    @And("I clic on checkbox PUMA")
    public void clickChbox() {
        searchPage.clickChbox();
    }

    @And("I select order by Price highest")
    public void orderBy() {
        searchPage.orderBy();
    }

    @After
    public void tearDown(){
        myBaseDriver.getDriver().close();
    }



}
