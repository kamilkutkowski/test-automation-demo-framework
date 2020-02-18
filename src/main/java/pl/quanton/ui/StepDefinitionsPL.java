package pl.quanton.ui;

import cucumber.api.java.pl.Kiedy;
import cucumber.api.java.pl.Mając;
import cucumber.api.java.pl.Wtedy;
import net.thucydides.core.annotations.Steps;
import pl.quanton.ui.steps.CommonSteps;

public class StepDefinitionsPL {

    @Steps
    private CommonSteps commonSteps;

    @Mając("^otworzoną główną stronę portalu (.*)$")
    public void iAmOnTheSpecificMainPage(String pageName) {
        commonSteps.userIsOnMainPage(pageName);
    }

    @Kiedy("^wprowadzam hasło (.*) i potwierdzam wyszkiwanie$")
    public void iTypeSpecoficKeyValueAndSubmit(String searchedPhrase) {
        commonSteps.userSearchingCustomText(searchedPhrase);
    }

    @Wtedy("^otrzymuję liste wyników dla hasła (.*)$")
    public void iCanSeeSpecificWikiPage(String foundPage) {
        commonSteps.confirmSucessfullSearching(foundPage);
    }

    @Wtedy("^mogę zobaczyć znalezione elementy$")
    public void iCanOpenEverySingleAvailablePhoto() {
        commonSteps.userClickOnFirstFourElements();
    }
}
