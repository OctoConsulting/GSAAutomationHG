package feedbackAndLearningcenterPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import util.TestBase;

public class cancelFillingfeedback extends TestBase{

	@FindBy(xpath = "//button[@class=\"usa-button-primary pull-left\"]")
	WebElement cancelfeedback;
	

public cancelFillingfeedback() {
	PageFactory.initElements(driver, this);

}
	
	

public void cancelprovidefeedback() throws InterruptedException {
cancelfeedback.click(); 
Thread.sleep(2000);
	
	
	
	
	
	
	
	
	
	
}

}
