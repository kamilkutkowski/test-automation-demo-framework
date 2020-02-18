package pl.quanton;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        //tags = "@PL",
        plugin = {"pretty"},
        features = "src/main/resources/features"
)
public class UiTestSuite {
}
