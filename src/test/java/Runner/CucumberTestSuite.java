package Runner;


import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(plugin = { "pretty" }, features = "src\\test\\resources\\features-Integration4\\integration-FH",
glue= {"stepdefinitions"},
//tags =  {"@Pos, @Neg"},]]
monochrome = true,
        dryRun=false)

public class CucumberTestSuite {

}

