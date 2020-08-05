package pl.quanton.ui.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;

public class Allegro extends PageObject {

    @FindBy(xpath = "//div[@aria-labelledby='dialog-title']")
    WebElementFacade allegroPopUp;

    @FindBy(xpath = "//input[@type='search']")
    WebElementFacade allegroSearch;

    public boolean popUpVisibility() {
        return allegroPopUp.isVisible();
    }

    public void closeAllegroPopUp() {
        allegroPopUp
                .waitUntilVisible()
                .then(By.xpath("//button[@data-role='close-and-accept-consent']"))
                .waitUntilClickable()
                .click();
    }

    public void typeSearchPhraseAndSearch(String searchPhrase) {
        allegroSearch
                .waitUntilVisible()
                .typeAndEnter(searchPhrase);
    }
}

