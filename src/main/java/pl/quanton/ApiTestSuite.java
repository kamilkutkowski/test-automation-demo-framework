package pl.quanton;

import cucumber.api.cli.Main;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

import java.util.stream.Stream;

@RunWith(CucumberWithSerenity.class)
public class ApiTestSuite {

    public static void main(String[] args) throws Throwable {
        Stream<String> cucumberOptions = Stream.concat(Stream.of(DEFAULT_OPTIONS), Stream.of(args));
        Main.main(cucumberOptions.toArray(String[]::new));
    }

    private static String[] DEFAULT_OPTIONS = {
            "src/main/resources/features",
            "--plugin", "pretty",
            //"--tags", "@PL",
            "--glue", "pl.quanton"
    };
}
