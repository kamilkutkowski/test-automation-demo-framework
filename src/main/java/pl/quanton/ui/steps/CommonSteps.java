package pl.quanton.ui.steps;

import cucumber.api.PendingException;
import cucumber.runtime.CucumberException;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.Serenity;

import static org.assertj.core.api.Assertions.assertThat;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import pl.quanton.ui.pages.Google;
import pl.quanton.ui.pages.Wikipedia;
import pl.quanton.ui.pages.YouTube;

import java.util.HashMap;
import java.util.Map;

import static net.serenitybdd.core.Serenity.sessionVariableCalled;
import static net.serenitybdd.core.Serenity.setSessionVariable;

@Slf4j
public class CommonSteps extends PageObject {

    private Google google;
    private Wikipedia wikipedia;
    private YouTube youTube;
    private final static String PAGE = "page";

    @Step
    public void userIsOnMainPage(String pageName) {
        setSessionVariable(PAGE).to(pageName);
        setDefaultBaseUrl(pages().get(pageName.toLowerCase()));
        open();
    }

    @Step
    public void userSearchingCustomText(String customSearchingPhrase) {
        switch (sessionVariableCalled(PAGE)
                .toString()
                .toLowerCase()) {
            case "wikipedia":
                wikipedia.typeSearchingPhraseAndSubmit(customSearchingPhrase);
                break;
            case "google":
                google.typeSearchingPhraseAndSubmit(customSearchingPhrase);
                break;
            case "youtube":
                youTube.typeSearchingPhraseAndSubmit(customSearchingPhrase);
                break;
            default:
                throw new PendingException("Typed page is not supported");
        }
    }

    @Step
    public void confirmSucessfullSearching(String searchingPhrase) {
        switch (sessionVariableCalled(PAGE)
                .toString()
                .toLowerCase()) {
            case "wikipedia":
                assertThat(wikipedia.getMainHeaderText()).containsIgnoringCase(searchingPhrase);
                break;
            case "google":

                break;
            case "youtube":

                break;
            default:
                throw new PendingException("Typed page is not supported");
        }
    }

    @Step
    public void userClickOnFoundElement(WebElementFacade element) {
        element.waitUntilClickable()
                .click();
    }

    @Override
    public void setDefaultBaseUrl(String defaultBaseUrl) {
        super.setDefaultBaseUrl(defaultBaseUrl);
    }

    private Map<String, String> pages() {
        final HashMap<String, String> pages = new HashMap<>();
        pages.put("wikipedia", "https://pl.wikipedia.org/");
        pages.put("youtube", "https://www.youtube.com/");
        pages.put("google", "https://www.google.pl/");
        return pages;
    }

}
