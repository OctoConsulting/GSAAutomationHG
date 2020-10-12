package feedbackAndLearningcenterPages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import util.TestBase;

public class learningcenterAboutusUseraccounts extends TestBase {
	@FindBy(xpath ="//*[@id=\"main-container\"]/ng-component/page/div/div/div[2]/div[1]/sidebar/nav/ul/li[1]/ul/li[1]/a")
	WebElement AboutUS;
	@FindBy(xpath="//a[@class=\"block\" and @href=\"/help/user-accounts\"]")
	WebElement UserAccounts;		
public learningcenterAboutusUseraccounts() {
	PageFactory.initElements(driver, this);
	}
	
	public void Intoaboutus () throws InterruptedException {
		AboutUS.click();
		((JavascriptExecutor) driver).executeScript("scroll(0,500)");
		Thread.sleep(10000);
	}
	public void IntoUserAccounts() throws InterruptedException {
	UserAccounts.click();	
	Thread.sleep(10000);
	
	}
	
	
	
	
	
	
	
			
	
}