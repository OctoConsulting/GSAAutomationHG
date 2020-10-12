package feedbackAndLearningcenterPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import util.TestBase;

public class oneanswerfeedback extends TestBase{

	@FindBy(xpath="//button[@class=\"sam-ui button secondary\" and @type=\"button\"]")
	WebElement confirmbutton;
	@FindBy(xpath="//button[@class=\"sam-ui button basic blue\"and @type=\"button\"]")
	WebElement cancelbutton;
	@FindBy(xpath="//p[text()='You have feedback that is not submitted. Do you want to proceed ahead?']")
	WebElement cancelnotification;

public oneanswerfeedback() {
	PageFactory.initElements(driver, this);

}
public boolean confirmationCancel() {
	try {
		return cancelnotification.isDisplayed();
	} catch (Exception ex) {
		System.out.println("working as desired");
	}
	return false;
}

	

public void fillingonefeedback() throws InterruptedException {
	driver.findElement(By.xpath("//*[@id=\"question-0\"]/div/textarea")).sendKeys("Hi");
	Thread.sleep(1000);
}
public void clickconfirm() {
	confirmbutton.click();
}

public void clickcanceloneanswer() {
	cancelbutton.click();
	
}
	
	
	
	
	
	
	
	
	
	
	


}


