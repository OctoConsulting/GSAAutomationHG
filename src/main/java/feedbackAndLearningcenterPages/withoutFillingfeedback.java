package feedbackAndLearningcenterPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import util.TestBase;

public class withoutFillingfeedback extends TestBase {

	@FindBy(xpath = "//h4[text()='Provide Feedback']")
	WebElement providefeedback;
	@FindBy(id="button-question-0")
	WebElement firstquestion;
	@FindBy(id="button-question-1")
	WebElement secondquestion;
	@FindBy(id="button-question-2")
	WebElement thirdquestion;
	@FindBy(xpath="//button[text()='Submit']")
	WebElement submitfeedback;
	@FindBy(xpath="//a[@title=\"Learning Center\"]")
	WebElement learningcenter;

	// intializing the page objects/elements/
	// means DRIVER PLEASE INTILZE ALL THE GLOBAL VARIABLES ABOVE
	public withoutFillingfeedback() {
		PageFactory.initElements(driver, this);
	}
	
	
	
	public void providefeedbacklink() {
	providefeedback.click();
	}
	public void clickonquestion1() {
		firstquestion.click();
	}
	public void clicksecondquestion() {
		secondquestion.click();
		
	}
	public void clickthirdquestion() {
		thirdquestion.click();
		
	}
		
	public void clicksubmitfeedback() {
		submitfeedback.click();
	}
	public void clicklearningcenter() {
		learningcenter.click();
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
