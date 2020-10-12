package feedbackAndLearningcenterPages;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import util.TestBase;

public class enterallfeedback extends TestBase {


	public static String randomFeedbackTitle;


@FindBy(xpath="//*[@id=\"button-question-1\"]")
WebElement questionone;
@FindBy(xpath="//*[@id=\"question-1\"]/div/textarea")
WebElement questiononevalue;
@FindBy(xpath="//*[@id=\"button-question-2\"]")
WebElement questiontwo;
@FindBy(xpath="//*[@id=\"question-2\"]/div/div[1]/div[1]/label")
WebElement confirmyes;
@FindBy(xpath="/html/body/app/sam-feedback/div/div[2]/div[3]/div/button[2]")
WebElement disabled;
@FindBy(xpath="/html/body/app/sam-feedback/div/div[2]/div[2]/div/div[2]/textarea")
WebElement text;
@FindBy(xpath="//*[@id=\"main-container\"]/ng-component/page/div/div/div[2]/div[1]/sidebar/nav/sam-feedback-sidenav/div/ul/li/sam-feedback-button/div/button")
WebElement newprovidefeedback;
@FindBy(xpath="/html/body/app/sam-feedback/div/div/h1[2]")
WebElement feedbackconfirmation;
@FindBy(xpath="//button[text()='Submit']")
WebElement submittab;
@FindBy(xpath="//button[text()='Close']")
WebElement close;

public enterallfeedback() {
PageFactory.initElements(driver, this);

}

public boolean isSubmitDisabled() {
	try {
		return disabled.isDisplayed();
	} catch (Exception ex) {
		System.out.println("working as desired");
	}
	return true;
}
public void entertext(){
	Random rand = new Random();
	float result = rand.nextFloat();
	randomFeedbackTitle = "application is great" + " "+ result;
text.sendKeys(randomFeedbackTitle);
	
}
public boolean isSubmitEnabled() {
	try {
		return submittab.isDisplayed();
	} catch (Exception ex) {
		System.out.println("working as desired");
	}
	return false;
}
public void submitfeedback() throws InterruptedException {
	Thread.sleep(2000);
	submittab.click();
}
public void closefeedback() throws InterruptedException {
	Thread.sleep(2000);
	close.click();
}
public boolean confirmation() {
	try {
		return feedbackconfirmation.isDisplayed();
	} catch (Exception ex) {
		System.out.println("working as desired");
	}
	return false;
}



public void entersecondquestion() {
questionone.click();
questiononevalue.sendKeys("Hello");
}

public void enterthirdquestion() {
	questiontwo.click();
	confirmyes.click();
	
}
public void learningcenterfeedback() {
	newprovidefeedback.click();
}


















}