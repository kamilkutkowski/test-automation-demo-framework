package pl.quanton.ui;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinitionsUi {

    @Given("^I am on the (.*) main page$")
    public void iAmOnTheSpecificMainPage(String pageName) {

    }

    @When("^I type (.*) keyword and submit$")
    public void iTypeSpecoficKeyValueAndSubmit(String searchedPhrase) {

    }

    @Then("^I see the (.*) wiki page$")
    public void iSeeSpecificWikiPage(String foundPage) {

    }

    @Then("^I can open every single available photo$")
    public void iCanOpenEverySingleAvailablePhoto() {

    }
}
