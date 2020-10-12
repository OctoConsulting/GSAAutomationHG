package stepdefinitions;

import static org.junit.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import feedbackAndLearningcenterPages.cancelFillingfeedback;
import feedbackAndLearningcenterPages.enterallfeedback;
import feedbackAndLearningcenterPages.formapproved;
import login.govPages.homepage;
import feedbackAndLearningcenterPages.learningcenterAboutusUseraccounts;
import feedbackAndLearningcenterPages.learningcenterDatasets;
import feedbackAndLearningcenterPages.learningcenterPolicies;
import feedbackAndLearningcenterPages.learningcenterResources;
import login.govPages.loginGov;
import login.govPages.loginpage;
import feedbackAndLearningcenterPages.oneanswerfeedback;
import feedbackAndLearningcenterPages.withoutFillingfeedback;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import util.TestBase;

public class LearningCenterANDFeedbackSteps extends TestBase {
	loginpage LoginPage;
	loginGov LoginGov;
	homepage Homepage;
	withoutFillingfeedback WithoutFillingFeedback;
	cancelFillingfeedback CancelFillingFeedback;
	oneanswerfeedback Oneanswerfeedback;
	enterallfeedback Enterallfeedback;
	formapproved Formapproved;
	learningcenterAboutusUseraccounts LearningcenterAboutusUseraccounts;
	learningcenterDatasets LearningcenterDatasets;
	learningcenterResources LearningcenterResources;
	learningcenterPolicies LearningcenterPolicies;
	
	@Before
	public void Setup() throws IOException {
		LoginPage = new loginpage();
		LoginGov = new loginGov();
		WithoutFillingFeedback = new withoutFillingfeedback();
		CancelFillingFeedback = new cancelFillingfeedback();
		Oneanswerfeedback = new oneanswerfeedback();
		Enterallfeedback = new enterallfeedback();
		Formapproved = new formapproved();
		LearningcenterAboutusUseraccounts=new learningcenterAboutusUseraccounts();
		LearningcenterDatasets=new learningcenterDatasets ();
		LearningcenterResources=new learningcenterResources ();
		LearningcenterPolicies=new learningcenterPolicies ();
//		FileReader prop=new FileReader("config.properties");
//		Properties propfile=new Properties();
//		propfile.load(prop);
	}

	@Given("user opens browser")
	public void user_opens_browser() {
		TestBase.Initial();
	}

	@Then("user is on login page")
	public void user_is_on_login_page() {
		LoginPage = new loginpage();
		LoginPage.validateloginpage();

		// Assert.assertTrue(condition);
		// Assert.assertTrue(LoginPage.validateloginpage());
		String actualTitle = driver.getTitle();
		System.out.println(actualTitle);
		String expectedTitle = "beta.SAM.gov | Home";
		Assert.assertEquals(expectedTitle, actualTitle);

	}

	@Then("user clicks signin")
	public void user_clicks_signin() throws Throwable {
		Thread.sleep(5000);

		LoginPage.tryingtosignin();
		Thread.sleep(5000);
	}

	@Then("user closes the pop up")
	public void user_closes_the_pop_up() throws Throwable {
		LoginPage.closealert();

	}

	@Then("user gets otp")
	public void user_gets_otp() throws InterruptedException {
		LoginGov = new loginGov();
		LoginGov.enteremail("sanzedah.rahman+opfh@gsa.gov");
		LoginGov.enterpassword("trialanderror");
		LoginGov.clicknextbutton();
		String otp = loginGov.getotp("HDFG3SGELTYUO2T2");
		loginGov.enterOtp(otp);
		LoginGov.clickOtpSubmit();

		Thread.sleep(5000);
	}

	@Then("user is in workspace")
	public void user_is_in_workspace() throws InterruptedException {
		LoginGov.OnWorkspace();
	}
	@Then("user will click on FH")
	public void user_will_click_on_FH() throws Exception {
		Homepage = new homepage();
		Homepage.getintoFH();

		Thread.sleep(30);
		// driver.close();

	}

	@Given("^Environment (\\w+)$")
	public void Environment(String urlConstant) throws Throwable {
		TestBase.Initial();

	}

	@And("^Click on provide feed back on front page button$")
	public void Click_on_provide_feed_back_button() throws Throwable {
		WithoutFillingFeedback = new withoutFillingfeedback();
		((JavascriptExecutor) driver).executeScript("scroll(0,2000)");
		Thread.sleep(2000);
		WithoutFillingFeedback.providefeedbacklink();
		Thread.sleep(5000);
		// WithoutFillingFeedback.clicksubmitfeedback();

	}

	@Then("^Check the three question$")
	public void Check_the_three_question() {

		WithoutFillingFeedback.clickonquestion1();

		WithoutFillingFeedback.clicksecondquestion();
		WithoutFillingFeedback.clickthirdquestion();
	}

	@Then("^user click on submit button$")
	public void user_click_on_submit_button() throws InterruptedException {
		WithoutFillingFeedback.clicksubmitfeedback();
		Thread.sleep(100);
	}

	@Then("user click on submit button on learning center")
	public void user_click_on_submit_button_on_learning_center() {
		driver.findElement(By.xpath("//button[@class=\"usa-button-primary pull-right\"]")).click();

	}

	@And("^Click on learning center link$")
	public void Click_on_learn_center_link() throws Throwable {

		Thread.sleep(1000);
		WithoutFillingFeedback.clicklearningcenter();
		Thread.sleep(1000);
	}

	@Then("Click on learning center link as the first link")
	public void click_on_learning_center_link_as_the_first_link() throws InterruptedException {

		((JavascriptExecutor) driver).executeScript("scroll(0,3500)");
		Thread.sleep(1000);
		Formapproved = new formapproved();
		Formapproved.directlinktolearningcenter();
		Thread.sleep(1000);
	}

	@Then("Click on the provide feed back button")
	public void click_on_the_provide_feed_back_button() throws InterruptedException {
		// ((JavascriptExecutor) driver).executeScript("scroll(0,2000)");
		Enterallfeedback.learningcenterfeedback();

	}

	@And("^Navigate into New to beta.SAM.gov page$")
	public void Navigate_into_New_to_betaSAMgov_page() throws Throwable {
		String val = "While parts of this site are official, others are demonstration only and continue to be supported on one of our original websites shown below.";
		String val1 = driver.findElement(By.xpath(
				"//*[@id=\"main-container\"]/ng-component/page/div/div/div[2]/div[2]/ng-component/div[2]/div[2]/p[1]"))
				.getText();
		Thread.sleep(10000);
		// String val1 =
		// driver.findElement(By.xpath("//*[@id=\"main-container\"]/ng-component/page/div/div/div[2]/div[2]/ng-component/div[2]/div[2]/p[1]")).getText();
		Assert.assertEquals(val, val1);
	}

	@And("^User click on cancel button$")
	public void User_click_on_cancel_button() throws Throwable {
		CancelFillingFeedback = new cancelFillingfeedback();

		CancelFillingFeedback.cancelprovidefeedback();
		Thread.sleep(1000);

	}

	@And("^User enter like or dislike about beta.sam.gov$")
	public void User_enter_like_or_dislike_about_beta_sam_gov() throws Throwable {
		Oneanswerfeedback = new oneanswerfeedback();
		Oneanswerfeedback.fillingonefeedback();
	}

	@Then("^Click on confirm button$")
	public void Click_on_confirm_button() throws Throwable {

		Oneanswerfeedback.clickconfirm();

	}

	@Then("^Click cancel button in alert warning$")
	public void click_cancel_button_in_alert_warning() throws Throwable {
		Oneanswerfeedback.clickcanceloneanswer();

	}

	@And("^User enter what change or improvements would you suggest$")
	public void User_enter_what_change_or_improvements_would_you_suggest() throws Throwable {
		Enterallfeedback = new enterallfeedback();
		Enterallfeedback.entersecondquestion();
	}

	@And("^may we contact you if we have question about your feedback$")
	public void User_select_may_we_contact_you_if_we_have_question_about_your_feedback() throws Throwable {
		Enterallfeedback.enterthirdquestion();

	}

	@And("^User enter email id$")
	public void User_enter_email_id() {
		driver.findElement(By.xpath("//input[@aria-describedby=\"input-email-address\"]"))
				.sendKeys("sanzedah.rahman@gsa.gov");

	}

	@Then("^Click on the provide feed back link$")
	public void Click_on_the_provide_feed_back_link() throws Throwable {

		Formapproved.clickingprovidefeedback();
		Thread.sleep(2000);

	}

	@Then("^Navigate to policies page$")
	public void Navigate_to_policies_page() throws InterruptedException {
		Formapproved.formapprovedenter();
		Thread.sleep(1000);

	}

	@Then("The user clicks on about us tab")
	public void the_user_clicks_on_about_us_tab() throws InterruptedException {
		LearningcenterAboutusUseraccounts=new learningcenterAboutusUseraccounts();
		LearningcenterAboutusUseraccounts.Intoaboutus();
		
	}

	@Then("User successfully navigates into about us page")
	public void user_successfully_navigates_into_about_us_page() throws InterruptedException {
		String val = "Learning Center";
		String val1 = driver
				.findElement(By
						.xpath("//*[@id=\"main-container\"]/ng-component/page/div/div/div[1]/div/sam-breadcrumbs/ul/li[1]/a"))
				.getText();
		Thread.sleep(10);
		Assert.assertEquals(val, val1);

		String beta = "About Us";
		String beta1 = driver.findElement(By.xpath("//*[@id=\"main-container\"]/ng-component/page/div/div/div[1]/div/sam-breadcrumbs/ul/li[2]/span")).getText();
		Thread.sleep(3000);
		Assert.assertEquals(beta, beta1);
	}

	@Then("The user clicks on User Accounts tab")
	public void the_user_clicks_on_User_Accounts_tab() throws InterruptedException {
		LearningcenterAboutusUseraccounts.IntoUserAccounts();
	}

	@Then("User successfully navigates into User Accounts page")
	public void user_successfully_navigates_into_User_Accounts_page() throws InterruptedException {
		String val = "Learning Center";
		String val1 = driver
				.findElement(By
						.xpath("//*[@id=\"main-container\"]/ng-component/page/div/div/div[1]/div/sam-breadcrumbs/ul/li[1]/a"))
				.getText();
		Thread.sleep(10);
		Assert.assertEquals(val, val1);

		String beta = "User Accounts";
		String beta1 = driver.findElement(By.xpath("//*[@id=\"main-container\"]/ng-component/page/div/div/div[1]/div/sam-breadcrumbs/ul/li[2]/span")).getText();
		Thread.sleep(3000);
		Assert.assertEquals(beta, beta1);
	}
	@Then("The user clicks on Data Sets tab")
	public void the_user_clicks_on_Data_Sets_tab() throws InterruptedException {
		LearningcenterDatasets=new learningcenterDatasets();
		LearningcenterDatasets.Intodatasets();
		Thread.sleep(1000);
	}

	@Then("User successfully navigates into Data Sets page")
	public void user_successfully_navigates_into_Data_Sets_page() throws InterruptedException {
		((JavascriptExecutor) driver).executeScript("scroll(0,500)");
		Thread.sleep(1000);
	}

	@Then("The user clicks on Entity Information tab")
	public void the_user_clicks_on_Entity_Information_tab() throws InterruptedException {
		LearningcenterDatasets.Intoentityinfo();
	}

	@Then("User successfully navigates into Entity Information page")
	public void user_successfully_navigates_into_Entity_Information_page() {
	   
	}

	@Then("The user click on Federal Hierarchy tab")
	public void the_user_click_on_Federal_Hierarchy_tab() {
		LearningcenterDatasets.IntoFh();
	}

	@Then("User successfully navigates into Federal Hierarchy page")
	public void user_successfully_navigates_into_Federal_Hierarchy_page() throws InterruptedException {
		
	}
	@Then("The user click on Resources tab")
	public void the_user_click_on_Resources_tab() throws InterruptedException {
		LearningcenterResources=new learningcenterResources();
		LearningcenterResources.Intoresources();
	}

	@Then("User successfully navigates into Resources page")
	public void user_successfully_navigates_into_Resources_page() throws InterruptedException {
		String val = "Learning Center";
		String val1 = driver
				.findElement(By
						.xpath("//*[@id=\"main-container\"]/ng-component/page/div/div/div[1]/div/sam-breadcrumbs/ul/li[1]/a"))
				.getText();
		Thread.sleep(10);
		Assert.assertEquals(val, val1);
		String beta = "Resources";
		String beta1 = driver.findElement(By.xpath("//*[@id=\"main-container\"]/ng-component/page/div/div/div[1]/div/sam-breadcrumbs/ul/li[2]/span")).getText();
		Thread.sleep(3000);
		Assert.assertEquals(beta, beta1);
	}

	@Then("The user click on Assistance tab")
	public void the_user_click_on_Assistance_tab() throws InterruptedException {
		LearningcenterResources.Intoassistance();
		 Thread.sleep(1000);
	}

	@Then("User successfully navigates into Assistance page")
	public void user_successfully_navigates_into_Assistance_page() throws InterruptedException {
		String val = "Learning Center";
		String val1 = driver
				.findElement(By
						.xpath("//*[@id=\"main-container\"]/ng-component/page/div/div/div[1]/div/sam-breadcrumbs/ul/li[1]/a"))
				.getText();
		Thread.sleep(10);
		Assert.assertEquals(val, val1);

		String beta = "Assistance";
		String beta1 = driver.findElement(By.xpath("//*[@id=\"main-container\"]/ng-component/page/div/div/div[1]/div/sam-breadcrumbs/ul/li[2]/span")).getText();
		Thread.sleep(3000);
		Assert.assertEquals(beta, beta1);
	}

	@Then("The user click on Chief Financial Officers link")
	public void the_user_click_on_Chief_Financial_Officers_link() throws InterruptedException {
		LearningcenterResources.Intochieffinancial();
		 Thread.sleep(1000);
	}

	@Then("User successfully navigates into Chief Financial Officers page")
	public void user_successfully_navigates_into_Chief_Financial_Officers_page() throws InterruptedException {
		String winHandleBefore = driver.getWindowHandle();
		// Perform the click operation that opens new window

		// Switch to new window opened
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}

		String beta = "Welcome to CFO.gov";
		String beta1 = driver.findElement(By.xpath("//*[@id=\"navigation00\"]/div/h1")).getText();
		Thread.sleep(3000);
		Assert.assertEquals(beta, beta1);

		// Perform the actions on new window

		// Close the new window, if that window no more required
		driver.close();

		// Switch back to original browser (first window)
		driver.switchTo().window(winHandleBefore);
	}

	@Then("The user click on Benefit Finder link")
	public void the_user_click_on_Benefit_Finder_link() throws InterruptedException {
	 LearningcenterResources.Intobeneiftfinder();
	 Thread.sleep(1000);
	}

	@Then("User successfully navigates into Benefit Finder page")
	public void user_successfully_navigates_into_Benefit_Finder_page() throws InterruptedException {
		String winHandleBefore = driver.getWindowHandle();

		// Perform the click operation that opens new window

		// Switch to new window opened
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}

		String beta = "Benefit Finder";
		String beta1 = driver.findElement(By.xpath("//h1[text()='Benefit Finder']")).getText();
		Thread.sleep(3000);
		Assert.assertEquals(beta, beta1);
		
		// Perform the actions on new window

		// Close the new window, if that window no more required
		driver.close();

		// Switch back to original browser (first window)
		driver.switchTo().window(winHandleBefore);
	}

	@Then("The user click on Wage Determinations tab")
	public void the_user_click_on_Wage_Determinations_tab() throws InterruptedException {
		LearningcenterResources.Intowagedetermination();
		 Thread.sleep(1000);
	}

	@Then("User successfully navigates into Wage Determinations page")
	public void user_successfully_navigates_into_Wage_Determinations_page() throws InterruptedException {
		String val = "Learning Center";
		String val1 = driver
				.findElement(By
						.xpath("//*[@id=\"main-container\"]/ng-component/page/div/div/div[1]/div/sam-breadcrumbs/ul/li[1]/a"))
				.getText();
		Thread.sleep(10);
		Assert.assertEquals(val, val1);

		String beta = "Wage Determinations";
		String beta1 = driver.findElement(By.xpath("//*[@id=\"main-container\"]/ng-component/page/div/div/div[1]/div/sam-breadcrumbs/ul/li[2]/span")).getText();
		Thread.sleep(3000);
		Assert.assertEquals(beta, beta1);
		

		}
		


	@Then("The user click on service contract Act link")
	public void the_user_click_on_service_contract_Act_link() throws InterruptedException {
	   LearningcenterResources.Intoservicecontract();
	   Thread.sleep(10000);
	}

	@Then("User successfully navigates into service contract Act page")
	public void user_successfully_navigates_into_service_contract_Act_page() throws InterruptedException {
		String winHandleBefore = driver.getWindowHandle();
		// Perform the click operation that opens new window

		// Switch to new window opened
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		// Perform the actions on new window

				// Close the new window, if that window no more required
				driver.close();

				// Switch back to original browser (first window)
				driver.switchTo().window(winHandleBefore);
	}

	@Then("The user click on Conformances under the Davis-Bacon Act link")
	public void the_user_click_on_Conformances_under_the_Davis_Bacon_Act_link() throws InterruptedException {
		((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
		LearningcenterResources.Intoconformances();
	    Thread.sleep(1000);
	}

	@Then("User successfully navigates into Conformances under the Davis-Bacon Act page")
	public void user_successfully_navigates_into_Conformances_under_the_Davis_Bacon_Act_page() throws InterruptedException {

		((JavascriptExecutor) driver).executeScript("scroll(0,800)");
	}

	@Then("The user click on Partners tab")
	public void the_user_click_on_Partners_tab() throws InterruptedException {
	   LearningcenterResources.Intopartners();
	}

	@Then("User successfully navigates into Partners page")
	public void user_successfully_navigates_into_Partners_page() throws InterruptedException {
		String val = "Learning Center";
		String val1 = driver
				.findElement(By
						.xpath("//*[@id=\"main-container\"]/ng-component/page/div/div/div[1]/div/sam-breadcrumbs/ul/li[1]/a"))
				.getText();
		Thread.sleep(10);
		Assert.assertEquals(val, val1);

		String beta = "Partners";
		String beta1 = driver.findElement(By.xpath("//*[@id=\"main-container\"]/ng-component/page/div/div/div[1]/div/sam-breadcrumbs/ul/li[2]/span")).getText();
		Thread.sleep(3000);
		Assert.assertEquals(beta, beta1);
		((JavascriptExecutor) driver).executeScript("scroll(0,600)");
		
	}

	@Then("The user click on Disaster Assistance link")
	public void the_user_click_on_Disaster_Assistance_link() throws InterruptedException {
		   LearningcenterResources.Intodisaster();
	}

	@Then("User successfully navigates into Disaster Assistance page")
	public void user_successfully_navigates_into_Disaster_Assistance_page() {

		String winHandleBefore = driver.getWindowHandle();
		// Perform the click operation that opens new window
		// Switch to new window opened
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
			
		}

		String beta = "Find Assistance";
		String beta1 = driver.findElement(By.xpath("//*[@id=\"block-imagelinksblock\"]/div/div/a[1]/div/h3")).getText();
		Assert.assertEquals(beta, beta1);
		
		// Perform the actions on new window

		// Close the new window, if that window no more required
		driver.close();

		// Switch back to original browser (first window)
		driver.switchTo().window(winHandleBefore);
	}

	@Then("user click on Policies tab")
	public void user_click_on_Policies_tab() throws InterruptedException {
		LearningcenterPolicies=new learningcenterPolicies ();
		LearningcenterPolicies.Intopolicies();
		
	}

	@Then("User successfully navigates into Policies page")
	public void user_successfully_navigates_into_Policies_page() throws InterruptedException {
		String val = "Learning Center";
		String val1 = driver
				.findElement(By
						.xpath("//*[@id=\"main-container\"]/ng-component/page/div/div/div[1]/div/sam-breadcrumbs/ul/li[1]/a"))
				.getText();
		Thread.sleep(10);
		Assert.assertEquals(val, val1);

		String beta = "Policies";
		String beta1 = driver.findElement(By.xpath("//*[@id=\"main-container\"]/ng-component/page/div/div/div[1]/div/sam-breadcrumbs/ul/li[2]/span")).getText();
		Thread.sleep(2000);
		Assert.assertEquals(beta, beta1);
	
		String paragraph = "The feedback surveys on beta.SAM.gov (information collections) meet the requirements of 44 U.S.C. § 3507, as amended by section 2 of the Paperwork Reduction Act of 1995. You do not need to answer these questions unless we display a valid Office of Management and Budget (OMB) control number. The OMB control number for our collections is 3090-0297. We estimate that it will take 3 minutes to read the instructions, gather the facts, and answer the questions. Send only comments relating to our time estimate, including suggestions for reducing this burden, or any other aspects of this collection of information to: General Services Administration, Regulatory Secretariat Division (MVCB), ATTN: Division Director/IC 3090-0297, 1800 F Street, NW, Washington, DC 20405.";

		String paragraph1 = driver
				.findElement(By
						.xpath("//*[@id=\"main-container\"]/ng-component/page/div/div/div[2]/div[2]/ng-component/p[1]"))
				.getText();
		Assert.assertEquals(paragraph, paragraph1);
	}

	@Then("User click on beta sam link")
	public void user_click_on_beta_sam_link() throws InterruptedException {
	    LearningcenterPolicies.Intobetasam();
	    
	}


	@And("^Browser close$")
	public void Browser_close() throws InterruptedException {
		Thread.sleep(1000);
		driver.quit();
	}

@Then("^the submit button will be disabled$")
public void the_submit_button_will_be_disabled() throws Exception {
	Enterallfeedback=new enterallfeedback();
	Enterallfeedback.submitfeedback();
	assertTrue("FEEDBACK IS NOT DISABLED1", Enterallfeedback.isSubmitDisabled());
}

@When("^user enters fields for feedback$")
public void user_enters_fields_for_feedback() throws Exception {
	Enterallfeedback.entertext();
}

@Then("^the submit button is enabled to be submitted$")
public void the_submit_button_is_enabled_to_be_submitted() throws Exception {
	assertTrue("FEEDBACK IS NOT DISABLED1", Enterallfeedback.isSubmitEnabled());
	Enterallfeedback.submitfeedback();
	assertTrue("FEEDBACK IS NOT DISABLED2", Enterallfeedback.confirmation());
	Enterallfeedback.closefeedback();

	
}
@Then("^user will confirm the cancelation$")
public void user_will_confirm_the_cancelation() throws Exception {
	Oneanswerfeedback=new 	oneanswerfeedback();
	assertTrue("FEEDBACK notification not there",Oneanswerfeedback.confirmationCancel());
	Oneanswerfeedback.clickconfirm();
}


@Then("^the user will validate that data has been stored in the backend using a GET call$")
public void the_user_will_validate_that_data_has_been_stored_in_the_backend_using_a_GET_call() throws Exception {
 
	given().
  when().
  get("https://50samfeedbackminc.apps.prod-iae.bsp.gsa.gov/feedback/v1/feedback").then().body(containsString(Enterallfeedback.randomFeedbackTitle));
	System.out.println("PASSED ENDPOINT because API data was found in backend as "+ Enterallfeedback.randomFeedbackTitle);
}

}
