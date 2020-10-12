package feedbackAndLearningcenterPages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import util.TestBase;

public class learningcenterPolicies extends TestBase{

	@FindBy(xpath="//a[@href=\"/help/policies\"]")
	WebElement Policies;
	@FindBy(xpath="//*[@id=\"main-container\"]/ng-component/page/div/div/div[2]/div[2]/ng-component/p[4]/a")
	WebElement BetaSam;
	
	
	
	
	public learningcenterPolicies() {
	
		PageFactory.initElements(driver, this);
	}



	public void Intopolicies() throws InterruptedException {
		((JavascriptExecutor) driver).executeScript("scroll(0,500)");
		Thread.sleep(500);
		Policies.click();
		Thread.sleep(1000);
		
	}

public void Intobetasam() throws InterruptedException {
		
		BetaSam.click();
		Thread.sleep(1000);
		
	}



































}
