package FhPages;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import util.TestBase;

public class FhOrgPickerValidation extends TestBase{

	@FindBy(id="create-contracting-button")
	WebElement CreateOpportunityTab;
	@FindBy(id="opp-type-select")
	WebElement CreateOpportunityType;
	@FindBy(id="deleteButton")
	WebElement delete;
	@FindBy(xpath="//option[text()='Special Notice']")
	WebElement CreateOpportunityTypeChoice;
	@FindBy(xpath="//button[text()=' Ok ']")
	WebElement ok;
	@FindBy(id="opp-title-input")
	WebElement CreateOpportunityTitle;
	
	@FindBy(id="opp-notice-id-input")
	WebElement CreateOpportunityNoticeId;
	@FindBy(id="agency-modal-button")
	WebElement CreateOpportunityAgency;
	@FindBy(id="dept")
	WebElement DEPT;
	@FindBy(id="subtier")
	WebElement SubtierTable;
	@FindBy(xpath="//*[@id=\"dept-resultItem-0\"]")
	WebElement DEPTArg;
	@FindBy(xpath="//*[@id=\"subtier-resultItem-0\"]/div[1]/div")
	WebElement Subtier;
	@FindBy(id="office")
	WebElement office;
	@FindBy(xpath="//div[text()='127289 - DAIRY BUSINESS INNOVATION']")
	WebElement officeChoice;
	@FindBy(id="500042783")
	WebElement officeChoiceSelected;
	@FindBy(xpath="//button[text()=' Select ']")
	WebElement Selected;
	@FindBy(id="fal-form-nav-done")
	WebElement done;
	@FindBy(xpath="//h3[text()='Success']")
	WebElement approved;
	
	
	public FhOrgPickerValidation() {
		PageFactory.initElements(driver, this);
	}
	
	
	public void IntoOpp() throws InterruptedException {
		CreateOpportunityTab.click();
		Thread.sleep(3000);
		
	}
	public void IntoOppType() throws InterruptedException {
		CreateOpportunityType.click();
		CreateOpportunityTypeChoice.click();
		Thread.sleep(3000);
		
	}
	public void OppGenerator() throws InterruptedException {
		((JavascriptExecutor) driver).executeScript("scroll(0,400)");
		Random rand = new Random();
		float result = rand.nextFloat();
		String randomOppTitle = "Test_OPP_PI<123>" + result;
		CreateOpportunityTitle.sendKeys(randomOppTitle);

		
		Thread.sleep(3000);
		
	}
	public void OppId() throws InterruptedException {
		Random rand = new Random();
		int result = rand.nextInt();
		CreateOpportunityNoticeId.sendKeys("ABC123"+result);
		CreateOpportunityAgency.click();
		Thread.sleep(3000);
		
	}
	public boolean L1Validation() {
		boolean verify;
		//VALIDATION FOR "YOU"
				WebElement locatorforWhereTEXTisPresent = driver.findElement(By.xpath(
						"//*[@id=\"dept-listbox\"]"));
		
				String Requesttext = locatorforWhereTEXTisPresent.getText();
		
				if (Requesttext.contains("Department/Ind. Agency"))  {
					verify = true;
				}
				
			else {
					verify = false;
						}
			
	System.out.println(Requesttext);
	return verify;
	}
	public boolean L1ValidationTable() {
		boolean verify;
		//VALIDATION FOR "YOU"
				WebElement locatorforWhereTEXTisPresent = driver.findElement(By.xpath(
						"//div[@class=\"agency-table\"]"));
		
				String Requesttext = locatorforWhereTEXTisPresent.getText();
		
				if (Requesttext.contains("012 AGRICULTURE, DEPARTMENT ")&&Requesttext.contains("12K2 AGRICULTURAL MARKETING SERVICE"))  {
					verify = true;
				}
				
			else {
					verify = false;
						}
			
	System.out.println(Requesttext);
	return verify;
	}
public void EnterDept() throws InterruptedException {
		
		DEPT.click();
		Thread.sleep(4000);
		
	}
public void EnterSubtier() throws InterruptedException {
	SubtierTable.click();
	Thread.sleep(3000);
	
}
public boolean L2Validation() {
	boolean verify;
	//VALIDATION FOR "YOU"
			WebElement locatorforWhereTEXTisPresent = driver.findElement(By.xpath(
					"//*[@id=\"subtier-listbox\"]"));
	
			String Requesttext = locatorforWhereTEXTisPresent.getText();
	
			if (Requesttext.contains("Sub-Tier"))  {
				verify = true;
			}
			
		else {
				verify = false;
					}
		
System.out.println(Requesttext);
return verify;
}
public boolean L2ValidationTable() {
	boolean verify;
	//VALIDATION FOR "YOU"
			WebElement locatorforWhereTEXTisPresent = driver.findElement(By.xpath(
					"//div[@class=\"agency-table\"]"));
	
			String Requesttext = locatorforWhereTEXTisPresent.getText();
	
			if (Requesttext.contains("12K2 AGRICULTURAL MARKETING SERVICE")&&Requesttext.contains("12K2 AGRICULTURAL MARKETING SERVICE"))  {
				verify = true;
			}
			
		else {
				verify = false;
					}
		
System.out.println(Requesttext);
return verify;
}
public boolean L2ValidationTable2() {
	boolean verify;
	//VALIDATION FOR "YOU"
			WebElement locatorforWhereTEXTisPresent = driver.findElement(By.xpath(
					"//div[@class=\"agency-table\"]"));
	
			String Requesttext = locatorforWhereTEXTisPresent.getText();
	
			if (Requesttext.contains("Major Command")&&Requesttext.contains("Sub Command"))  {
				verify = true;
			}
			
		else {
				verify = false;
					}
			
		
System.out.println(Requesttext);
return verify;
}
public void EnterDeptCHOICE() throws InterruptedException {
	DEPTArg.click();
	Thread.sleep(3000);
	
}
public void ChooseL2() throws InterruptedException {
	Subtier.click();
	Thread.sleep(3000);
	
}
public void ChooseOffice() throws InterruptedException {
	office.click();
	Thread.sleep(3000);
	
}
public void ChooseOfficeAs() throws InterruptedException {
	officeChoice.click();
	
	Thread.sleep(3000);
	
}

public void ChooseOfficeForSelection() throws InterruptedException {
	officeChoiceSelected.click();
	Selected.click();
	Thread.sleep(3000);
	
}
public void OpportunityDone() throws InterruptedException {
	done.click();

	Thread.sleep(3000);
	
}
public void OpportunityDeleted() throws InterruptedException {
	delete.click();

	Thread.sleep(3000);
	
}
public void OpportunityDeletedok() throws InterruptedException {
ok.click();

	Thread.sleep(3000);
	
}
public boolean Successisthere() {

	return approved.isDisplayed();
}

				}