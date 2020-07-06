package pl.quanton.ui.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class YouTube extends PageObject {

    @FindBy(css = "input[id='search']")
    private WebElementFacade searchInputField;

    public void typeSearchingPhraseAndSubmit(String searchingPhrase) {
        searchInputField
                .waitUntilClickable()
                .typeAndEnter(searchingPhrase);
    }
}
