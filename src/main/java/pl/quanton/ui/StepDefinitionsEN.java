package pl.quanton.ui;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import pl.quanton.ui.pages.Wikipedia;
import pl.quanton.ui.steps.CommonSteps;

public class StepDefinitionsEN {

    private Wikipedia wikipedia;

    @Steps
    private CommonSteps commonSteps;


    @Given("^I am on the (.*) main page$")
    public void iAmOnTheSpecificMainPage(String pageName) {
        commonSteps.userIsOnMainPage(pageName);
    }

    @When("^I type (.*) keyword and submit$")
    public void iTypeSpecoficKeyValueAndSubmit(String searchedPhrase) {
        commonSteps.userSearchingCustomText(searchedPhrase);
    }

    @Then("^I see the (.*) search result page$")
    public void iSeeSpecificWikiPage(String foundPage) {
        commonSteps.confirmSucessfullSearching(foundPage);
    }

    @Then("^I can open first four available elements$")
    public void iCanOpenEverySingleAvailablePhoto() {
        wikipedia.openAllAvailablePhotos().forEach(photo -> {
            commonSteps.userClickOnFoundElement(photo);
            wikipedia.closePicture();
        });

    }
}
