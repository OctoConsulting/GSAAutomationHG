package FeedsPages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import util.TestBase;

public class RequestRejectFeedspage extends TestBase{
    WebDriverWait wait = new WebDriverWait(driver,40);
	@FindBy(id ="role-request-link")
	WebElement RequestRole;
	@FindBy(linkText = "My Roles")
	WebElement myroles;
	@FindBy(id="userPicker")
	WebElement searchindirectory;
	@FindBy(linkText = "Request Role")
	WebElement requestrole;
	@FindBy(id="supervisor-name")
	WebElement supervisorname;
	@FindBy(id="supervisor-email")
	WebElement supervisoremail;
	@FindBy(id="federalHierarchy")
	WebElement organizationame;
	@FindBy(id="federalHierarchy_100171752")
	WebElement GSAoption;
	@FindBy(id="headerIconRequests")
	WebElement FeedsMainDropdown;
	@FindBy(className="fa-chevron-circle-right")
	WebElement FeedsMainDropdownMORE;
	@FindBy(id="role-select")
	WebElement roleneeded;
	@FindBy(xpath="//label[@for=\"domain-ac-textarea\"]")
	WebElement departmentdropdown;
	@FindBy(xpath="//p[text()='Assistance Listing']")
	WebElement departmentoption;
	@FindBy(xpath="//textarea[@id=\"additional-details\"]")
	WebElement commentsforrequest;
	@FindBy(id="done-button")
	WebElement doneonrequest;
	@FindBy(linkText="Requests")
	WebElement Requesttab;
	@FindBy(xpath="//input[@id=\"Rejected\"]")
	WebElement Rejectedtab;
	@FindBy(xpath="//span[@class=\"usa-width-one-whole msg-feed-description\"]")
	WebElement RejectingRoleProcess;
	@FindBy(xpath="//textarea[@id=\"Additional Information\"]")
	WebElement additionalinfoforrejecting;
	@FindBy(xpath="//button[text()=' Reject ']")
	WebElement rejectbutton;
	@FindBy(xpath="//textarea[@id=\"access-org-pickerpicker-ac-textarea\"]")
	WebElement AssignRoleDEP;
	@FindBy(id="federalHierarchy")
	WebElement AssignRoleGSA;
	@FindBy(xpath="//*[@id=\"federalHierarchy-listbox\"]/li[1]/div[2]/div")
	WebElement AssignRoleGSAFULLY;
	@FindBy(id="role-select")
	WebElement RoleSelector;
	@FindBy(id="domain-ac-textarea")
	WebElement AssignDomainSelector;
	@FindBy(xpath="//p[text()='Contract Opportunities']")
	WebElement ContractRole;
	@FindBy(className="sam-text-area")
	WebElement CommentsforAssignedRole;
	@FindBy(xpath="//span[text()='View Access']")
	WebElement ViewAcess;
	@FindBy(xpath="//a[@aria-label=\"Delete Role Button\"]")
	WebElement DeleteRole;
	@FindBy(xpath="//button[text()=' Delete ']")
	WebElement confirmdelete;
	@FindBy(id="agency-modal-button")
	WebElement advanced;
	@FindBy(id="office")
	WebElement advancedOffice;
	@FindBy(xpath="//*[@id=\"office-listbox\"]/li")
	WebElement advancedOfficeOption;
	@FindBy(id="100188520")
	WebElement advancedOfficeConfirm;
	@FindBy(xpath="//button[text()=' Select ']")
	WebElement selectOffice;
	@FindBy(xpath="//*[@id=\"sanzedah.rahman+norole@gsa.gov-action-button\"]")
	WebElement actions;
	@FindBy(xpath="//span[text()='Assign Role']")
	WebElement assignrole;
// intializing the page objects/elements/
	// means DRIVER PLEASE INTILZE ALL THE GLOBAL VARIABLES ABOVE
	public RequestRejectFeedspage() {
		PageFactory.initElements(driver, this);
	}
//////////////////////////////////////////////////////////////////////////////////
	public void intoRequestPage() throws InterruptedException {
		 // explicit wait - to wait for the compose button to be click-able
		((JavascriptExecutor) driver).executeScript("scroll(0,1100)");
		            Thread.sleep(2000);
			RequestRole.click();
		Thread.sleep(1000);
		
	}
	

	public void RequestRoleDetails() throws InterruptedException {
			//myroles.click();
			//Thread.sleep(3000);
			//requestrole.click();
		
			Thread.sleep(2000);
			supervisorname.sendKeys("AJ");
			supervisoremail.sendKeys(prop.getProperty("AssistanceAdmin"));
			Thread.sleep(4000);
			((JavascriptExecutor) driver).executeScript("scroll(0,600)");
			organizationame.sendKeys("General");
			GSAoption.click();
			organizationame.sendKeys(Keys.ENTER);
			((JavascriptExecutor) driver).executeScript("scroll(0,600)");
			Thread.sleep(4000);
			roleneeded.sendKeys("Assistance User");
			Thread.sleep(4000);
			((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
			departmentdropdown.click();
			departmentoption.click();
			((JavascriptExecutor) driver).executeScript("scroll(0,100)");
			commentsforrequest.sendKeys("test comments");
			Thread.sleep(4000);
			((JavascriptExecutor) driver).executeScript("scroll(0,300)");
			doneonrequest.click();
			Thread.sleep(6000);
	}
	public void RequestRoleDetailsForContractingOpp() throws InterruptedException {
	//	myroles.click();
		Thread.sleep(3000);
	//	requestrole.click();
		Thread.sleep(2000);
		supervisorname.sendKeys("AJ");
		supervisoremail.sendKeys(prop.getProperty("ContractOppAdmin"));
		Thread.sleep(4000);
		((JavascriptExecutor) driver).executeScript("scroll(0,600)");
		organizationame.sendKeys("4764ED");
		
	driver.findElement(By.xpath("//*[@id=\"federalHierarchy_100176853\"]")).click();
		organizationame.sendKeys(Keys.ENTER);
		((JavascriptExecutor) driver).executeScript("scroll(0,600)");
		Thread.sleep(4000);
		roleneeded.sendKeys("Contracting Officer");
		Thread.sleep(4000);
		((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
		departmentdropdown.click();
		ContractRole.click();
		((JavascriptExecutor) driver).executeScript("scroll(0,100)");
		commentsforrequest.sendKeys("test comments");
		Thread.sleep(4000);
		((JavascriptExecutor) driver).executeScript("scroll(0,300)");
		doneonrequest.click();
		Thread.sleep(6000);
}
	public void RequestRoleDetailsForL3() throws InterruptedException {
		//myroles.click();
		//Thread.sleep(3000);
		//requestrole.click();
		Thread.sleep(2000);
		supervisorname.sendKeys("AJ");
		supervisoremail.sendKeys(prop.getProperty("ContractOppAdmin"));
		Thread.sleep(4000);
		((JavascriptExecutor) driver).executeScript("scroll(0,600)");
	    advanced.click();
		advancedOffice.sendKeys("47JH00");
		advancedOffice.sendKeys(Keys.ENTER);
		advancedOfficeOption.click();
		
		advancedOfficeConfirm.click();
		selectOffice.click();
		
		
//		organizationame.sendKeys("General");
//		GSAoption.click();
//		organizationame.sendKeys(Keys.ENTER);
		((JavascriptExecutor) driver).executeScript("scroll(0,600)");
		Thread.sleep(4000);
		roleneeded.sendKeys("Contracting Officer");
		Thread.sleep(4000);
		((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
		departmentdropdown.click();
		ContractRole.click();
		((JavascriptExecutor) driver).executeScript("scroll(0,100)");
		commentsforrequest.sendKeys("test comments");
		Thread.sleep(4000);
		((JavascriptExecutor) driver).executeScript("scroll(0,300)");
		doneonrequest.click();
		Thread.sleep(6000);
}
		public void RejectRole() throws InterruptedException {
		RejectingRoleProcess.click();
		Thread.sleep(6000);
		((JavascriptExecutor) driver).executeScript("scroll(0,300)");
		additionalinfoforrejecting.sendKeys("Testing so ive rejected");
		rejectbutton.click();
		Thread.sleep(10000);
		FeedsMainDropdown.click();
		Thread.sleep(3000);
		FeedsMainDropdownMORE.click();
		Thread.sleep(9000);
		Requesttab.click();

		Thread.sleep(4000);
		}
		public void filterRejected() throws InterruptedException {
		((JavascriptExecutor) driver).executeScript("scroll(0,800)");
		Thread.sleep(5000);
		Rejectedtab.click();
		Thread.sleep(4000);
		((JavascriptExecutor) driver).executeScript("scroll(0,-800)");
		Thread.sleep(4000);
	}
		public void AssignARole() throws InterruptedException {
			((JavascriptExecutor) driver).executeScript("scroll(0,500)");
			Thread.sleep(4000);
			AssignRoleGSA.click();
			AssignRoleGSA.sendKeys("General");
			AssignRoleGSAFULLY.click();
			driver.findElement(By.xpath("//*[@id=\"main-container\"]/ng-component/form-only/div/div/div/div[3]")).click();
			RoleSelector.sendKeys("Contracting Officer");
			AssignDomainSelector.click();
			ContractRole.click();
		((JavascriptExecutor) driver).executeScript("scroll(0,300)");
			Thread.sleep(4000);
			CommentsforAssignedRole.sendKeys("test comments");
			Thread.sleep(4000);
			doneonrequest.click();
			Thread.sleep(3000);
		}

		public static void searchUserInUserPicker(String user) throws InterruptedException {
			driver.findElement(By.id("userPicker")).sendKeys(user);
		Thread.sleep(3000);
			driver.findElement(By.id("userPicker-resultItem-0")).click();
			Thread.sleep(3000);
		}

		public void DeletingRole() throws InterruptedException {
			String noRoleUser = prop.getProperty("NoRole");
			
			searchindirectory.click();
			
			searchUserInUserPicker(noRoleUser);
		
			Thread.sleep(5000);
			//driver.findElement(By.xpath("//*[@id=\"sanzedah.rahman+norole@gsa.gov-action-0\"]")).click();
			Thread.sleep(9000);
			actions.click();
			ViewAcess.click();
			Thread.sleep(7000);
			DeleteRole.click();
			Thread.sleep(9000);
			confirmdelete.click();
		}
		
		public void feedValidation(String userIdenity,String roleName, String orgName,String domainName) {
			boolean verify;
			//VALIDATION FOR "YOU"
					WebElement locatorforWhereTEXTisPresent = driver.findElement(By.xpath(
							"//*[@id=\"main-container\"]/msg-feed-container/msg-feed-requests/page/div/div/div[2]/div[2]/div[1]/div[3]/div[1]"));
			
					String Requesttext = locatorforWhereTEXTisPresent.getText();
			
					if (Requesttext.contains(userIdenity) && Requesttext.contains(roleName) && Requesttext.contains(orgName) && Requesttext.contains(domainName) )  {
						verify = true;
					}
					
				else {
						verify = false;
							}
				
		System.out.println(Requesttext);
		}
		public void OFFICEValidation() {
			boolean verify;
			//VALIDATION FOR "YOU"
					WebElement locatorforWhereTEXTisPresent = driver.findElement(By.xpath(
							"//*[@id='main-container']/msg-feed-container/msg-feed-requests/page/div/div/div[2]/div[2]/div[1]/div[3]/div[1]"));
			
					String Requesttext = locatorforWhereTEXTisPresent.getText();
			
					if (Requesttext.contains("OIG OFC OF INVESTIGATIONS"))  {
						verify = true;
					}
					
				else {
						verify = false;
							}
				
		System.out.println(Requesttext);
		}
	
	public boolean NEGfeedValidation(String userIdenity, String roleName, String orgName, String domainName) {
		boolean verify;
		// VALIDATION FOR "YOU"
		WebElement locatorforWhereTEXTisPresent = driver.findElement(By.xpath(
				"//*[@id='main-container']/msg-feed-container/msg-feed-requests/page/div/div/div[2]/div[2]/div[1]/div[3]/div[1]"));

		String Requesttext = locatorforWhereTEXTisPresent.getText();

		if (Requesttext.contains(userIdenity) && Requesttext.contains(roleName) && Requesttext.contains(orgName)
				&& Requesttext.contains(domainName)) {
			verify = false;
		}

		else {
			verify = true;
		}

		System.out.println(Requesttext);
		return verify;
	}
}		