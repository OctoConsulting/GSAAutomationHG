package Runner;


import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
		plugin = { "pretty" }, 
		features = "src\\test\\resources\\features-Integration5\\integration-FH2\\OfficeMoveValidationsWithEndDate.feature",
		glue = {"stepdefinitions"},
		//tags =  {"@IntegrationTest"},
		monochrome = true,
        dryRun = false)

public class CucumberTestSuite {

}

