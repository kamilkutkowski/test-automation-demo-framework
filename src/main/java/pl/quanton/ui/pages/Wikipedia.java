package pl.quanton.ui.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class Wikipedia extends PageObject {

    @FindBy(css = "input[type='search']")
    private WebElementFacade searchingInputField;

    @FindBy(css = "h1[id='firstHeading']")
    private WebElementFacade mainHeader;

    @FindBy(css = "ul[class*='gallery']")
    private WebElementFacade gallery;

    @FindBy(css = "button[class='mw-mmv-close']")
    private WebElementFacade closePhoto;

    public void typeSearchingPhraseAndSubmit(String searchingPhrase) {
        searchingInputField
                .waitUntilVisible()
                .typeAndEnter(searchingPhrase);
    }

    public String getMainHeaderText() {
        return mainHeader
                .waitUntilVisible()
                .getText();
    }

    public List<WebElementFacade> openAllAvailablePhotos() {
        return gallery
                .waitUntilVisible()
                .thenFindAll(By.tagName("li"));
    }

    public void closePicture(){
        closePhoto
                .waitUntilClickable()
                .click();
    }
}
