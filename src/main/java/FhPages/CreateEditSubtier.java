package FhPages;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import util.TestBase;

public class CreateEditSubtier extends TestBase{
	static String randomSubtierTitle;
	@FindBy(xpath = "//a[text()='Federal Hierarchy']")
	WebElement FHBreadcrumbLink;
	@FindBy(xpath = "//input[@aria-label=\"search federal hierarchy\"]")
	WebElement FHSearch;
	@FindBy(xpath = "//a[@class=\"federal-hierarchy-org-item-title\"]")
	WebElement FHSearchDepAgency;
	@FindBy(xpath = "//button[text()=' Create Sub-Tier ']")
	WebElement CreateSubtier;
	@FindBy(id = "orgName-input")
	WebElement DeptAgencyName;
	@FindBy(id="org-start-date month required. Enter Month Here")
	WebElement DeptAgencyStartDate;
	@FindBy(id="org-start-date year required. Enter Year Here")
	WebElement DeptAgencyStartYear;
	@FindBy(id="org-start-date day required. Enter Day Here")
	WebElement DeptAgencyStartDay;
	@FindBy(id="org-start-date month required. Enter Month Here")
	WebElement DeptAgencyStartDate1;
	@FindBy(id="org-start-date year Enter Year Here")
	WebElement DeptAgencyStartYear2;
	@FindBy(id="org-start-date day Enter Day Here")
	WebElement DeptAgencyStartDay3;
	@FindBy(id="org-end-date month Enter Month Here")
	WebElement DeptAgencyEndDate;
	@FindBy(id="org-end-date day Enter Day Here")
	WebElement DeptAgencyEndDate2;
	@FindBy(id="org-end-date year Enter Year Here")
	WebElement DeptAgencyEndDate3;

	
	@FindBy(id="fpds-input")
	WebElement DeptAgencyAC;
	@FindBy(xpath = "//button[text()=' Confirm ']")
	WebElement DeptAgencyConfirm;
	@FindBy(id="orgShortName-input")
	WebElement SubtierShortName;
	@FindBy(xpath = "//button[text()=' Edit ']")
	WebElement DeptAgencyEditConfirmation;
	@FindBy(xpath = "//button[text()=' Submit ']")
	WebElement DeptAgencySubmit;
	@FindBy(id="editDetailsButton")
	WebElement EditSection;
	@FindBy(id = "Inactive")
	WebElement inactivetab;
	@FindBy(xpath = "//button[text()='Cancel']")
	WebElement CancelDepAgency;
	@FindBy(xpath = "//button[text()=' Edit ']")
	WebElement EditDepAgency;
	@FindBy(xpath = "//span[text()=' The start date of a sub-tier cannot be before the start date of a parent department. ']")
	WebElement ErrorMessage;
	@FindBy(xpath = "//span[text()=' The start date cannot be after the end date of a parent department. ']")
	WebElement ErrorMessage2;
	@FindBy(xpath = "//span[text()=' The start date cannot be after the end date. ']")
	WebElement ErrorMessage3;
	@FindBy(xpath = "//span[text()=' The end date of a sub-tier cannot be after the end date of a parent department. ']")
	WebElement ErrorMessage4;
	@FindBy(xpath = "//span[text()=' The end date of a sub-tier cannot be before the start date of a parent department. ']")
	WebElement ErrorMessage5;
	
	@FindBy(xpath = "//span[text()=' The end date can only be moved forward once an end date is provided. ']")
	WebElement ErrorMessage7;
	
	@FindBy(xpath = "//span[text()=' The end date cannot be earlier than or equal to the start date. ']")
	WebElement ErrorMessage6;
	
	
	@FindBy(xpath = "//span[text()=' The start date cannot be moved forward from the existing start date. It can only be moved back. ']")
	WebElement ErrorMessage8;
	@FindBy(xpath = "//span[text()=' There are 2 offices that are still active under this sub-tier. Please end date them before you end date this sub-tier. ']")
	WebElement ErrorMessage9;

	
	@FindBy(xpath = "//span[text()=' There are 2 offices that are scheduled to be active under this sub-tier. Please end date them before you end date this sub-tier. ']")
	WebElement ErrorMessage10;
	@FindBy(xpath = "//span[text()=' There are 2 offices that are still active and 2 offices that are scheduled to be active under this sub-tier. Please end date them before you end date this sub-tier. ']")
	WebElement ErrorMessage11;
	
	public CreateEditSubtier() {
		PageFactory.initElements(driver, this);
	}

	public void intoDept() throws InterruptedException {
		Thread.sleep(3000);
		FHSearch.sendKeys("Actions Testing 2.0");
		//TEST DEPARTMENT 0.21738142
		FHSearch.sendKeys(Keys.ENTER);
		FHSearchDepAgency.click();
		Thread.sleep(1000);

	}
	public void intoSubtier() throws InterruptedException {
		Thread.sleep(3000);
		FHSearch.sendKeys(randomSubtierTitle);
		FHSearch.sendKeys(Keys.ENTER);
		FHSearchDepAgency.click();
		Thread.sleep(1000);

	}
	public void AddEndDate() throws InterruptedException {
		Thread.sleep(2000);
		EditSection.click();
		Thread.sleep(2000);

		((JavascriptExecutor) driver).executeScript("scroll(0,300)");

		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy ");

		Date date = new Date();
		String EndDate = dateFormat.format(date);
	//	DeptAgencyEndDate.sendKeys(EndDate);
		Calendar c = Calendar.getInstance();
        c.setTime(date);

        // manipulate date
      
    c.add(Calendar.DATE, +1);

    // convert calendar to date
    Date currentDatePlusOne = c.getTime();

    System.out.println(dateFormat.format(currentDatePlusOne));
    DeptAgencyEndDate.sendKeys(dateFormat.format(currentDatePlusOne));
		
		DeptAgencySubmit.click();

		Thread.sleep(3000);

	}

	public void NEGCreateSubtier() throws InterruptedException {
		CreateSubtier.click();
		Thread.sleep(3000);
		((JavascriptExecutor) driver).executeScript("scroll(0,1500)");
		DeptAgencyConfirm.click();
	}
	public void NEGCreateSubtier2() throws InterruptedException {
		Thread.sleep(4000);
		Random rand = new Random();
		float result = rand.nextFloat();
		randomSubtierTitle = "Test Subtier " + result;

		DeptAgencyName.sendKeys(randomSubtierTitle);
		Thread.sleep(1000);
		DeptAgencyConfirm.click();
		Thread.sleep(4000);
	}
	public void NEGCreateSubtier6() throws InterruptedException {
		// get current date time with Date()
			
				DeptAgencyStartDate.sendKeys("10/11/1911");
				Thread.sleep(1000);

				((JavascriptExecutor) driver).executeScript("scroll(0,500)");
			DeptAgencyAC.sendKeys("444");
				DeptAgencyConfirm.click();
				Thread.sleep(4000);
				((JavascriptExecutor) driver).executeScript("scroll(0,600)");
				Thread.sleep(2000);
			
	}
	public void NEGCreateSubtier3() throws InterruptedException {
	//	((JavascriptExecutor) driver).executeScript("scroll(0,500)");
		//DeptAgencyAC.clear();
		
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy ");
		DeptAgencyStartDate.clear();
		DeptAgencyStartYear.clear();
		DeptAgencyStartDay.clear();
		// get current date time with Date()
		Date date = new Date();

		// Now format the date
		String StartDate = dateFormat.format(date);

		// Print the Date
		System.out.println(StartDate);
		DeptAgencyStartDate.sendKeys(StartDate);
		Thread.sleep(1000);

		((JavascriptExecutor) driver).executeScript("scroll(0,500)");
		Thread.sleep(1000);
		DeptAgencyAC.clear();
		Thread.sleep(1000);
driver.findElement(By.xpath("//*[@id=\"main-container\"]/ng-component/div/div/div[3]")).click();
		DeptAgencyAC.clear();
		Thread.sleep(1000);

		DeptAgencyAC.clear();
		Thread.sleep(1000);
		DeptAgencyAC.click();
		SubtierShortName.click();
		Thread.sleep(1000);
		
		DeptAgencyConfirm.click();
		Thread.sleep(4000);
		
	}
	public void NEGCreateSubtier7() throws InterruptedException {
		EditDepAgency.click();
		
		Thread.sleep(4000);
		((JavascriptExecutor) driver).executeScript("scroll(0,500)");

		DeptAgencyAC.clear();
		DeptAgencyAC.sendKeys("3@j");
		Thread.sleep(2000);

		DeptAgencyConfirm.click();
	Thread.sleep(2000);
	DeptAgencyAC.clear();

	DeptAgencyAC.sendKeys("9$j");
	
	DeptAgencyConfirm.click();
Thread.sleep(2000);
DeptAgencyAC.clear();
Thread.sleep(2000);

DeptAgencyAC.sendKeys("2*j");
Thread.sleep(2000);
DeptAgencyConfirm.click();
//DeptAgencyAC.clear();
Thread.sleep(2000);

	}
	public void NEGCreateSubtier4() throws InterruptedException {
		DeptAgencyAC.clear();
		Thread.sleep(2000);

		Random rand = new Random();
		int x = rand.nextInt(900) + 100;
		String randomAC = "v" + x;

		DeptAgencyAC.sendKeys(randomAC);
		DeptAgencyConfirm.click();
		Thread.sleep(6000);
		DeptAgencyEditConfirmation.click();
		Thread.sleep(9000);
		SubtierShortName.sendKeys("AT");
		Thread.sleep(9000);
		((JavascriptExecutor) driver).executeScript("scroll(0,-900)");
		DeptAgencyName.clear();
		driver.findElement(By.xpath("//*[@id=\"main-container\"]/ng-component/div/div/div[3]")).click();
		((JavascriptExecutor) driver).executeScript("scroll(0,500)");
		SubtierShortName.clear();
		
		Thread.sleep(9000);
	
		DeptAgencyConfirm.click();
		
		
	
	}
	public void NEGCreateSubtier5() throws InterruptedException {
		Thread.sleep(3000);

		EditDepAgency.click();
		Thread.sleep(3000);

		
	}

public void NEGCreateSubtier8() throws InterruptedException {
	Thread.sleep(3000);

	DeptAgencyStartDate.clear();
	DeptAgencyStartYear.clear();
	DeptAgencyStartDay.clear();

	DeptAgencyStartDate.sendKeys("01022010");
	
	((JavascriptExecutor) driver).executeScript("scroll(0,500)");
	Thread.sleep(3000);

	DeptAgencyConfirm.click();
	Thread.sleep(4000);
	
}
public void NEGCreateSubtier9() throws InterruptedException {
	Thread.sleep(3000);

	DeptAgencyStartDate.clear();
	DeptAgencyStartYear.clear();
	DeptAgencyStartDay.clear();

	DeptAgencyStartDate.sendKeys("01022030");
	
	((JavascriptExecutor) driver).executeScript("scroll(0,500)");
	Thread.sleep(3000);

	DeptAgencyConfirm.click();
	Thread.sleep(4000);
	
}
public void NEGCreateSubtier10() throws InterruptedException {
	Thread.sleep(3000);

	DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy ");
	DeptAgencyStartDate.clear();
	DeptAgencyStartYear.clear();
	DeptAgencyStartDay.clear();
	// get current date time with Date()
	Date date = new Date();

	// Now format the date
	String StartDate = dateFormat.format(date);

	DeptAgencyEndDate.sendKeys(StartDate);
	Calendar c = Calendar.getInstance();
    c.setTime(date);
	   
    c.add(Calendar.DATE, +1);

    // convert calendar to date
    Date currentDatePlusOne = c.getTime();

    System.out.println(dateFormat.format(currentDatePlusOne));
    DeptAgencyStartDate.sendKeys(dateFormat.format(currentDatePlusOne));

	
	((JavascriptExecutor) driver).executeScript("scroll(0,500)");
	Thread.sleep(3000);

	DeptAgencyConfirm.click();
	Thread.sleep(4000);
	
}
public void NEGCreateSubtier11() throws InterruptedException {
	Thread.sleep(3000);

	DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy ");
	DeptAgencyStartDate.clear();
	DeptAgencyStartYear.clear();
	DeptAgencyStartDay.clear();
	// get current date time with Date()
	Date date = new Date();
	DeptAgencyEndDate.clear();
	DeptAgencyEndDate2.clear();
	DeptAgencyEndDate3.clear();
	// Now format the date
	String StartDate = dateFormat.format(date);

	DeptAgencyStartDate.sendKeys(StartDate);
	Thread.sleep(3000);

	DeptAgencyEndDate.sendKeys("01022030");
	Thread.sleep(2000);

	((JavascriptExecutor) driver).executeScript("scroll(0,500)");
	Thread.sleep(3000);

	DeptAgencyConfirm.click();
	Thread.sleep(4000);
	
}
public void NEGCreateSubtier12() throws InterruptedException {
	
	Thread.sleep(3000);

    DeptAgencyEndDate.clear();
	DeptAgencyEndDate2.clear();
	DeptAgencyEndDate3.clear();

	DeptAgencyEndDate.sendKeys("01022020");
	Thread.sleep(2000);

	((JavascriptExecutor) driver).executeScript("scroll(0,500)");
	Thread.sleep(3000);

	DeptAgencyConfirm.click();
	Thread.sleep(4000);
	
}
public void NEGCreateSubtier13() throws InterruptedException {
	Thread.sleep(3000);

	DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy ");
	DeptAgencyEndDate.clear();
	DeptAgencyEndDate2.clear();
	DeptAgencyEndDate3.clear();
	// get current date time with Date()
	Date date = new Date();

	// Now format the date
	String StartDate = dateFormat.format(date);

	DeptAgencyEndDate.sendKeys(StartDate);



	
	((JavascriptExecutor) driver).executeScript("scroll(0,500)");
	Thread.sleep(3000);

	DeptAgencyConfirm.click();
	Thread.sleep(4000);
	
}
public void NEGCreateSubtier14() throws InterruptedException {
	Thread.sleep(3000);
FHBreadcrumbLink.click();
Thread.sleep(3000);
FHSearch.sendKeys("Act Sub-tier");
FHSearch.sendKeys(Keys.ENTER);
FHSearchDepAgency.click();
Thread.sleep(2000);
EditSection.click();
Thread.sleep(2000);

((JavascriptExecutor) driver).executeScript("scroll(0,200)");

	DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy ");
	DeptAgencyStartDate.clear();
	Thread.sleep(2000);

	DeptAgencyStartDay.clear();
	Thread.sleep(2000);

	DeptAgencyStartYear.clear();
	Thread.sleep(2000);

	
	// get current date time with Date()
	Date date = new Date();

	// Now format the date
	String StartDate = dateFormat.format(date);

	DeptAgencyStartDate1.sendKeys(StartDate);
	Thread.sleep(2000);
	((JavascriptExecutor) driver).executeScript("scroll(0,2000)");
	Thread.sleep(2000);

	DeptAgencySubmit.click();
	Thread.sleep(4000);
}
public void NEGCreateSubtier15() throws InterruptedException {
	Thread.sleep(3000);
FHBreadcrumbLink.click();
Thread.sleep(3000);
FHSearch.sendKeys("WEDW");
FHSearch.sendKeys(Keys.ENTER);
FHSearchDepAgency.click();
Thread.sleep(2000);
EditSection.click();
((JavascriptExecutor) driver).executeScript("scroll(0,3000)");

	DeptAgencyEndDate.clear();
	Thread.sleep(2000);

	DeptAgencyEndDate2.clear();
	Thread.sleep(2000);

	DeptAgencyEndDate.clear();
	Thread.sleep(2000);

	
	
	DeptAgencyEndDate.sendKeys("01172020");
	Thread.sleep(2000);
	((JavascriptExecutor) driver).executeScript("scroll(0,2000)");
	Thread.sleep(2000);

	DeptAgencySubmit.click();
	Thread.sleep(4000);
}
public void NEGCreateSubtier16() throws InterruptedException {
	Thread.sleep(3000);
FHBreadcrumbLink.click();
Thread.sleep(3000);
FHSearch.sendKeys("DATA SUBTIER");
FHSearch.sendKeys(Keys.ENTER);
FHSearchDepAgency.click();
Thread.sleep(2000);
EditSection.click();
((JavascriptExecutor) driver).executeScript("scroll(0,3000)");
Thread.sleep(2000);

	DeptAgencyEndDate.clear();
	Thread.sleep(2000);

	DeptAgencyEndDate2.clear();
	Thread.sleep(2000);

	DeptAgencyEndDate.clear();
	Thread.sleep(2000);
	DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy ");
	// get current date time with Date()
	Date date = new Date();

	// Now format the date
	String StartDate = dateFormat.format(date);

	
	
	DeptAgencyEndDate.sendKeys(StartDate);
	Thread.sleep(2000);
	((JavascriptExecutor) driver).executeScript("scroll(0,500)");
	Thread.sleep(2000);

	DeptAgencySubmit.click();
	Thread.sleep(6000);
}
public void NEGCreateSubtier17() throws InterruptedException {
	((JavascriptExecutor) driver).executeScript("scroll(0,-2000)");
	Thread.sleep(3000);
FHBreadcrumbLink.click();
Thread.sleep(3000);
FHSearch.sendKeys("SUBTIER TESTING");
FHSearch.sendKeys(Keys.ENTER);
FHSearchDepAgency.click();
Thread.sleep(2000);
EditSection.click();
//((JavascriptExecutor) driver).executeScript("scroll(0,3000)");

	DeptAgencyEndDate.clear();
	Thread.sleep(2000);

	DeptAgencyEndDate2.clear();
	Thread.sleep(2000);

	DeptAgencyEndDate.clear();
	Thread.sleep(2000);
	DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy ");
	// get current date time with Date()
	Date date = new Date();

	// Now format the date
	String StartDate = dateFormat.format(date);

	
	
	DeptAgencyEndDate.sendKeys(StartDate);
	Thread.sleep(2000);
	((JavascriptExecutor) driver).executeScript("scroll(0,3000)");
	Thread.sleep(2000);

	DeptAgencySubmit.click();
	Thread.sleep(4000);
	((JavascriptExecutor) driver).executeScript("scroll(0,-400)");
}
public void NEGCreateSubtier18() throws InterruptedException {
	Thread.sleep(3000);
FHBreadcrumbLink.click();
Thread.sleep(3000);
FHSearch.sendKeys("ACTION NON ACTIVE SUBTIER");
FHSearch.sendKeys(Keys.ENTER);
FHSearchDepAgency.click();
Thread.sleep(2000);
EditSection.click();
//((JavascriptExecutor) driver).executeScript("scroll(0,3000)");

	DeptAgencyEndDate.clear();
	Thread.sleep(2000);

	DeptAgencyEndDate2.clear();
	Thread.sleep(2000);

	DeptAgencyEndDate.clear();
	Thread.sleep(2000);
	DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy ");
	// get current date time with Date()
	Date date = new Date();

	// Now format the date
	String StartDate = dateFormat.format(date);

	
	
	DeptAgencyEndDate.sendKeys(StartDate);
	Thread.sleep(2000);
	

	DeptAgencySubmit.click();
	Thread.sleep(4000);
	//((JavascriptExecutor) driver).executeScript("scroll(0,-400)");
}


	public void CreateSubtier() throws InterruptedException {
		CreateSubtier.click();
		Thread.sleep(3000);
		((JavascriptExecutor) driver).executeScript("scroll(0,200)");
		Random rand = new Random();
		float result = rand.nextFloat();
		randomSubtierTitle = "Test Subtier " + result;

		DeptAgencyName.sendKeys(randomSubtierTitle);
		Thread.sleep(1000);

		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy ");

		// get current date time with Date()
		Date date = new Date();

		// Now format the date
		String StartDate = dateFormat.format(date);

		// Print the Date
		System.out.println(StartDate);
		DeptAgencyStartDate.sendKeys(StartDate);
		Thread.sleep(1000);

		((JavascriptExecutor) driver).executeScript("scroll(0,400)");
	
		int x = rand.nextInt(900) + 100;
		String randomAC = "p" + x;

		DeptAgencyAC.sendKeys(randomAC);
		DeptAgencyConfirm.click();
		Thread.sleep(3000);
		DeptAgencyEditConfirmation.click();
		Thread.sleep(2000);
		SubtierShortName.sendKeys("T");
		DeptAgencyConfirm.click();
		Thread.sleep(3000);
	//	DeptAgencyEditConfirmation.click();
		Thread.sleep(2000);
	
		DeptAgencySubmit.click();
	
	}

	public void EditCodes() throws InterruptedException {
		//((JavascriptExecutor) driver).executeScript("scroll(0,3500)");
		driver.findElement(By.xpath("//*[@id=\"editDetailsButton\"]")).click();
		SubtierShortName.clear();

		SubtierShortName.sendKeys("OC");
		Thread.sleep(3000);
		DeptAgencySubmit.click();
		Thread.sleep(3000);

	}

	public void BacktoFH() throws InterruptedException {
		Thread.sleep(3000);
	((JavascriptExecutor) driver).executeScript("scroll(0,-3800)");
	FHBreadcrumbLink.click();
	Thread.sleep(2000);
}
	public void ValidateEndDateEdit() throws InterruptedException {
		
		((JavascriptExecutor) driver).executeScript("scroll(0,-500)");
		FHBreadcrumbLink.click();

		Thread.sleep(2000);

		FHSearch.sendKeys(randomSubtierTitle);

		FHSearch.sendKeys(Keys.ENTER);
		((JavascriptExecutor) driver).executeScript("scroll(0,500)");
		inactivetab.click();
		Thread.sleep(2000);
		FHSearchDepAgency.click();
		Thread.sleep(1000);
	}

	public boolean NEGValidation1() {
		boolean verify;

		// VALIDATION FOR "YOU"
		WebElement locatorforWhereTEXTisPresentt5 = driver.findElement(By.xpath(
				"//*[@id=\"main-container\"]/ng-component/div/div/div[2]/create-org-form/div/div[2]/div/div[1]/form/section[1]/div/sam-text/sam-label-wrapper/div"));

		String Requesttext = locatorforWhereTEXTisPresentt5.getText();

		if (Requesttext.contains("Sub-Tier name field is required.")) {
			verify = true;
		}

		else {
			verify = false;
		}

		System.out.println(Requesttext);
		return verify;
	}
	public boolean NEGValidation4() {
		boolean verify;

		// VALIDATION FOR "YOU"
		WebElement locatorforWhereTEXTisPresentt5 = driver.findElement(By.xpath(
				"//*[@id=\"main-container\"]/ng-component/div/div/div[2]/page/div/div/div[2]/div/create-org-form/div/div[2]/div/div[2]/section/form/div"));

		String Requesttext = locatorforWhereTEXTisPresentt5.getText();

		if (Requesttext.contains("This field cannot be empty")) {
			verify = true;
		}

		else {
			verify = false;
		}

		System.out.println(Requesttext);
		return verify;
	}
	public boolean NEGValidation2() {
		boolean verify;

		// VALIDATION FOR "YOU"
		WebElement locatorforWhereTEXTisPresentt5 = driver.findElement(By.xpath(
				"//*[@id=\"main-container\"]/ng-component/div/div/div[2]/create-org-form/div/div[2]/div/div[1]/form/div[1]"));

		String Requesttext = locatorforWhereTEXTisPresentt5.getText();

		if (Requesttext.contains("Date is required")) {
			verify = true;
		}

		else {
			verify = false;
		}

		System.out.println(Requesttext);
		return verify;
	}

	public boolean NEGValidation3() {
		boolean verify;

		// VALIDATION FOR "YOU"
		WebElement locatorforWhereTEXTisPresentt5 = driver.findElement(By.xpath(
				"//*[@id=\"main-container\"]/ng-component/div/div/div[2]/page/div/div/div[2]/div/create-org-form/div/div[2]/div/div[2]/section/form/div"));

		String Requesttext = locatorforWhereTEXTisPresentt5.getText();

		if (Requesttext.contains("This field cannot be empty")) {
			verify = true;
		}

		else {
			verify = false;
		}

		System.out.println(Requesttext);
		return verify;
	}
	public boolean NEGValidation6() {
		boolean verify;

		// VALIDATION FOR "YOU"
		WebElement locatorforWhereTEXTisPresentt5 = driver.findElement(By.xpath(
				"//*[@id=\"main-container\"]/ng-component/div/div/div[2]/page/div/div/div[2]/div/create-org-form/div/div[2]/div/div[1]/form/div[1]"));

		String Requesttext = locatorforWhereTEXTisPresentt5.getText();

		if (Requesttext.contains("Date is required")) {
			verify = true;
		}

		else {
			verify = false;
		}

		System.out.println(Requesttext);
		return verify;
	}
	public boolean NEGValidation8() {
		boolean verify;

		// VALIDATION FOR "YOU"
		WebElement locatorforWhereTEXTisPresentt5 = driver.findElement(By.xpath(
				"//*[@id=\"main-container\"]/ng-component/div/div/div[2]/create-org-form/div/div[2]/div/div[1]/form/div[1]"));

		String Requesttext = locatorforWhereTEXTisPresentt5.getText();

		if (Requesttext.contains("The start date of a sub-tier cannot be before the start date of a parent department.")) {
			verify = true;
		}

		else {
			verify = false;
		}

		System.out.println(Requesttext);
		return verify;
	}
	public boolean NEGValidation7() {
		boolean verify;

		// VALIDATION FOR "YOU"
		WebElement locatorforWhereTEXTisPresentt5 = driver.findElement(By.xpath(
				"//*[@id=\"main-container\"]/ng-component/div/div/div[2]/create-org-form/div/div[2]/div/div[2]/section/form/div"));

		String Requesttext = locatorforWhereTEXTisPresentt5.getText();

		if (Requesttext.contains("Please enter only alphanumeric values")) {
			verify = true;
		}

		else {
			verify = false;
		}

		System.out.println(Requesttext);
		return verify;
	}
	public boolean StartDate1() throws InterruptedException {
		Thread.sleep(5000);
		try {
			return ErrorMessage.isDisplayed();
		} catch (Exception ex) {
			System.out.println("working as desired");
		}
		return false;
	}
	public boolean StartDate2() throws InterruptedException {
		Thread.sleep(5000);
		try {
			return ErrorMessage2.isDisplayed();
		} catch (Exception ex) {
			System.out.println("working as desired");
		}
		return false;
	}
	public boolean StartDate3() throws InterruptedException {
		Thread.sleep(5000);
		try {
			return ErrorMessage3.isDisplayed();
		} catch (Exception ex) {
			System.out.println("working as desired");
		}
		return false;
	}
	public boolean StartDate4() throws InterruptedException {
	
		Thread.sleep(5000);
		((JavascriptExecutor) driver).executeScript("scroll(0,-500)");
		try {
			return ErrorMessage8.isDisplayed();
		} catch (Exception ex) {
			System.out.println("working as desired");
		}
		return false;
	}
	public boolean EndDate1() throws InterruptedException {
		Thread.sleep(5000);
		try {
			return ErrorMessage4.isDisplayed();
		} catch (Exception ex) {
			System.out.println("working as desired");
		}
		return false;
	}
	public boolean EndDate2() throws InterruptedException {
		Thread.sleep(5000);
		try {
			return ErrorMessage5.isDisplayed();
		} catch (Exception ex) {
			System.out.println("working as desired");
		}
		return false;
	}
	public boolean EndDate3() throws InterruptedException {
		Thread.sleep(5000);
		try {
			return ErrorMessage6.isDisplayed();
		} catch (Exception ex) {
			System.out.println("working as desired");
		}
		return false;
	}
	
	public boolean EndDate4() throws InterruptedException {

		Thread.sleep(5000);
		((JavascriptExecutor) driver).executeScript("scroll(0,-500)");
		try {
			return ErrorMessage7.isDisplayed();
		} catch (Exception ex) {
			System.out.println("working as desired");
		}
		return false;
	}
	public boolean EndDate5() throws InterruptedException {

		Thread.sleep(8000);
		//((JavascriptExecutor) driver).executeScript("scroll(0,700)");
		Thread.sleep(2000);

		try {
			return ErrorMessage9.isDisplayed();
		} catch (Exception ex) {
			System.out.println("working as desired");
		}
		return false;
	}
	public boolean EndDate6() throws InterruptedException {

		Thread.sleep(4000);
		
	

		try {
			return ErrorMessage10.isDisplayed();
		} catch (Exception ex) {
			System.out.println("working as desired");
		}
		return false;
	}

	public boolean EndDate7() throws InterruptedException {

		Thread.sleep(4000);
		
				
		try {
			return ErrorMessage11.isDisplayed();
		} catch (Exception ex) {
			System.out.println("working as desired");
		}
		return false;
	}
}

