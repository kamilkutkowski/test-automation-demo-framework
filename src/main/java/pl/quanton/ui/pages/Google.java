package pl.quanton.ui.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class Google extends PageObject {

    @FindBy(css = "input[title='Szukaj']")
    private WebElementFacade searchingInputField;

    @FindBy(css = "input[type='submit']")
    private WebElementFacade submitSearchingButton;

    public void typeSearchingPhraseAndSubmit(String searchingPhrase) {
        searchingInputField
                .waitUntilVisible()
                .typeAndEnter(searchingPhrase);
    }

//    public void clickInSearchButton(){
//        submitSearchingButton
//                .waitUntilClickable()
//                .click();
//    }
}
