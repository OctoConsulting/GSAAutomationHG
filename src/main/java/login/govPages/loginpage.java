package login.govPages;

import org.jboss.aerogear.security.otp.Totp;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import util.TestBase;

public class loginpage extends TestBase {

	// locators WEBELEMENTS

	@FindBy(xpath = "//button[@id=\"signin-button\"]")
	WebElement signin;
	@FindBy(xpath = "//*[@id=\"mat-dialog-0\"]/sam-us-security-modal-v2/div/div[3]/button[2]")
	WebElement popup;
	
	@FindBy(id="login-proceed")
	WebElement popup2;
	

	// intializing the page objects/elements/
	// means DRIVER PLEASE INTILZE ALL THE GLOBAL VARIABLES ABOVE
	public loginpage() {
		PageFactory.initElements(driver, this);
	}

	// METHODS/ACTIONS

	public void validateloginpage() {
		driver.getTitle();

	}

	public void tryingtosignin() throws InterruptedException {
		signin.click();
		Thread.sleep(30);
	}

	public void closealert() throws InterruptedException {
		popup.click();
		//popup2.click();

		Thread.sleep(30);
	}

}
