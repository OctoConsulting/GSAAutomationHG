package FhPages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import util.TestBase;

public class MoveOffice extends TestBase

{
	
	@FindBy(xpath="//span[text()=' No office types available ']")
	WebElement NoOfficeType;

	public MoveOffice() {
		PageFactory.initElements(driver, this);
	}

	public void intoSubtier() throws InterruptedException {
		Thread.sleep(3000);
		
		((JavascriptExecutor) driver).executeScript("scroll(0,200)");

	}

		}
