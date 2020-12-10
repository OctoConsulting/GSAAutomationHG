package FhPages;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import util.TestBase;
import util.utils;

public class CreateOffice extends TestBase {

	static String randomOfficeTitle;
	static String randomAac;
	@FindBy(xpath = "//a[text()='Federal Hierarchy']")
	WebElement FHBreadcrumbLink;
	@FindBy(xpath = "//input[@aria-label=\"search federal hierarchy\"]")
	WebElement FHSearch;
	@FindBy(xpath = "//a[@class=\"federal-hierarchy-org-item-title\"]")
	WebElement FHSearchDepAgency;
	@FindBy(xpath = "//button[text()=' Create Office ']")
	WebElement CreateOffice;
	@FindBy(id="action_button")
	WebElement ActionsOffice;
	@FindBy(id = "ofcAAC-input")
	WebElement Aac;
	@FindBy(xpath= "//button[@class='sam-ui button primary']")
	WebElement submit;
	@FindBy(xpath = "//*[@id=\"ofcName-input\"]")
	WebElement ofcName;
	@FindBy(id="ofc-start-date month required. Enter Month Here")
	WebElement startdate1;
	@FindBy(id="ofc-start-date day required. Enter Day Here")
	WebElement startdate2;
	@FindBy(id="ofc-start-date year required. Enter Year Here")
	WebElement startdate3;
	@FindBy(id="ofc-end-date month Enter Month Here")
	WebElement enddate1;
	@FindBy(id="ofc-end-date day Enter Day Here")
	WebElement enddate2;
	@FindBy(id="ofc-end-date year Enter Year Here")
	WebElement enddate3;

	@FindBy(id = "street1-Mailing-Address")
	WebElement Address;
	@FindBy(id = "Mailing-Addresscountry")
	WebElement country;
	@FindBy(id = "Mailing-Addresszip")
	WebElement zip;
	@FindBy(id = "Mailing-Addresscity")
	WebElement city;
	@FindBy(id = "Mailing-Addressstate")
	WebElement state;
	@FindBy(xpath = "//button[text()=' Confirm ']")
	WebElement OfficeEditConfirmation;
	@FindBy(id = "resultItem_0")
	WebElement countryChoice;
	@FindBy(xpath = "//span[text()=' Please provide a valid TAS Code. ']")
	WebElement errormessageaac2;
	@FindBy(xpath = "//span[text()=' This field cannot be empty ']")
	WebElement blankerrormessage;
	@FindBy(xpath = "//span[text()=' Office name is required ']")
	WebElement blankerrormessageName;
	@FindBy(xpath = "//span[text()=' Office Activity Address Code (AAC) is required ']")
	WebElement blankerrormessageAac;
	@FindBy(xpath = "//span[text()=' Please provide a valid AAC. ']")
	WebElement errormessageaac1;
	@FindBy(xpath = "//h1[text()=' Create Office Confirmation ']")
	WebElement CreateConfirmationValidation;
	@FindBy(xpath = "//span[text()=' This AAC already exists. Please provide a unique AAC. ']")
	WebElement errormessageaac3;
	@FindBy(xpath = "//span[text()=' This name already exists. Please enter a different name. ']")
	WebElement NameError;
	@FindBy(xpath = "//li[text()=' Abbeville - AL ']")
	WebElement cityChoice;
	@FindBy(xpath = "//button[text()=' Edit ']")
	WebElement edit;
	@FindBy(xpath = "//span[text()=' The start date is a required field. ']")
	WebElement StartDateError;
	@FindBy(xpath = "//span[text()=' The start date cannot be before the start date of the parent department and the parent sub-tier. ']")
	WebElement StartDateError2;
	@FindBy(xpath = "//span[text()=' The start date of an office cannot be before the start date of a parent sub-tier. ']")
	WebElement StartDateError3;
	@FindBy(xpath = "//span[text()=' The start date of an office cannot be after the end date of a parent Department. ']")
	WebElement StartDateError4;
	@FindBy(xpath = "//*[@id=\"ofc-start-date\"]/sam-fieldset-wrapper/div/fieldset/span")
	WebElement StartDateError44;
	@FindBy(xpath = "//span[text()=' The start date of an office cannot be after the end date of a parent sub-tier. ']")
	WebElement StartDateError5;
	@FindBy(xpath = "//span[text()=' The end date cannot be earlier than or equal to the start date. ']")
	WebElement EndDateError1;
	@FindBy(xpath = "//span[text()=' The start date of an office type cannot be before the start date of an office. ']")
	WebElement TypeStartDateError2;
	@FindBy(xpath = "//span[text()=' The start date of an office type cannot be after the end date of an office. ']")
	WebElement TypeStartDateError3;
	@FindBy(xpath = "//span[text()=' The start date of an office type cannot be after the end date. ']")
	WebElement TypeStartDateError4;
	@FindBy(xpath = "//span[text()=' The end date of an office type cannot be before the start date of an office. ']")
	WebElement TypeStartDateError5;
	@FindBy(xpath = "//span[text()=' The end date of an office type cannot be after the end date of an office. ']")
	WebElement TypeStartDateError6;
	@FindBy(xpath = "//span[text()=' The end date cannot be earlier than or equal to the start date. ']")
	WebElement TypeStartDateError7;
	@FindBy(xpath = "//span[text()=' Financial Assistance Awards office type end date cannot be earlier than  office start date  ']")
	WebElement TypeStartDateError8;
	@FindBy(xpath = "//span[text()=' Financial Assistance Awards office type end date cannot be after office end date ']")
	WebElement TypeStartDateError9;
	@FindBy(xpath = "//span[text()=' Contract Funding office type end date cannot be earlier than office type start date ']")
	WebElement TypeStartDateError10;
	@FindBy(xpath = "//span[text()=' Contract Funding office type end date cannot be earlier than  office start date  ']")
	WebElement TypeStartDateError11;
	@FindBy(xpath = "//span[text()=' Contract Funding office type end date cannot be after office end date ']")
	WebElement TypeStartDateError12;
	@FindBy(xpath = "//span[text()=' Financial Assistance Funding office type end date cannot be earlier than office type start date ']")
	WebElement TypeStartDateError13;
	@FindBy(xpath = "//span[text()=' Financial Assistance Funding office type end date cannot be earlier than  office start date  ']")
	WebElement TypeStartDateError14;
	@FindBy(xpath = "//span[text()=' Financial Assistance Funding office type end date cannot be after office end date ']")
	WebElement TypeStartDateError15;
	@FindBy(xpath = "//span[text()=' The start date cannot be moved forward once an office type start date is provided ']")
	WebElement TypeStartDateError16;

	@FindBy(id = "ContractAwards")
	WebElement ContractAwards;
	@FindBy(id = "FinancialAssistanceAwards")
	WebElement FinancialAssistanceAwards;
	@FindBy(id = "ContractFunding")
	WebElement ContractFunding;
	@FindBy(id = "FinancialAssistanceFunding")
	WebElement FinancialAssistanceFunding;
	@FindBy(id="ContractAwardsStartDate month Enter Month Here")
	WebElement ContractAwardsDate;
	@FindBy(id = "ContractAwardsStartDate month Enter Month Here")
	WebElement ContractAwardsEndDate;
	@FindBy(id = "ContractAwardsStartDate month Enter Month Here")
	WebElement ContractAwardsStateDate;
	@FindBy(id = "ContractAwardsStartDate day Enter Day Here")
	WebElement ContractAwardsStateDate2;
	@FindBy(id = "ContractAwardsStartDate year Enter Year Here")
	WebElement ContractAwardsStateDate3;
	@FindBy(id = "ContractAwardsEndDate month Enter Month Here")
	WebElement ContractAwardsEndDate0;
	@FindBy(id = "ContractAwardsEndDate day Enter Day Here")
	WebElement ContractAwardsEndDate2;
	@FindBy(id = "ContractAwardsEndDate year Enter Year Here")
	WebElement ContractAwardsEndDate3;

	@FindBy(id = "FinancialAssistanceAwardsStartDate month Enter Month Here")
	WebElement FinancialAssistanceAwardsStartDate;
	@FindBy(id = "FinancialAssistanceAwardsStartDate day Enter Day Here")
	WebElement FinancialAssistanceAwardsStart2;
	@FindBy(id = "FinancialAssistanceAwardsStartDate year Enter Year Here")
	WebElement FinancialAssistanceAwardsStart3;
	@FindBy(id = "FinancialAssistanceAwardsEndDate month Enter Month Here")
	WebElement FinancialAssistanceAwardsEnd0;
	@FindBy(id = "FinancialAssistanceAwardsEndDate day Enter Day Here")
	WebElement FinancialAssistanceAwardsEnd2;
	@FindBy(id = "FinancialAssistanceAwardsEndDate year Enter Year Here")
	WebElement FinancialAssistanceAwardsEnd3;

	@FindBy(id = "ContractFundingStartDate month Enter Month Here")
	WebElement ContractFundingStartDate;
	@FindBy(id = "ContractFundingStartDate day Enter Day Here")
	WebElement ContractFundingStartDate2;
	@FindBy(id = "ContractFundingStartDate year Enter Year Here")
	WebElement ContractFundingStartDate3;
	@FindBy(id = "ContractFundingEndDate month Enter Month Here")
	WebElement ContractFundingEndDates0;
	@FindBy(id = "ContractFundingEndDate day Enter Day Here")
	WebElement ContractFundingEndDate2;
	@FindBy(id = "ContractFundingEndDate year Enter Year Here")
	WebElement ContractFundingEndDate3;

	@FindBy(id = "FinancialAssistanceFundingStartDate month Enter Month Here")
	WebElement FinancialAssistanceFundingStartDate;
	@FindBy(id = "FinancialAssistanceFundingStartDate day Enter Day Here")
	WebElement FinancialAssistanceFundingStartDate2;
	@FindBy(id = "FinancialAssistanceFundingStartDate year Enter Year Here")
	WebElement FinancialAssistanceFundingStartDate3;
	@FindBy(id = "FinancialAssistanceFundingEndDate month Enter Month Here")
	WebElement FinancialAssistanceFundingEndDates0;
	@FindBy(id = "FinancialAssistanceFundingEndDate day Enter Day Here")
	WebElement FinancialAssistanceFundingEndDate2;
	@FindBy(id = "FinancialAssistanceFundingEndDate year Enter Year Here")
	WebElement FinancialAssistanceFundingEndDate3;
	@FindBy(xpath="//span[text()=' No office types available ']")
	WebElement NoOfficeType;

	public CreateOffice() {
		PageFactory.initElements(driver, this);
	}

	public void intoSubtier() throws InterruptedException {
		Thread.sleep(3000);
		FHSearch.sendKeys("AUTOMATED_SUBTIER_TEST");
		FHSearch.sendKeys(Keys.ENTER);
	}

	public void intoSubtier2() throws InterruptedException {
		FHSearchDepAgency.click();
		Thread.sleep(1000);
	}

	public boolean IsSubtierThere() {
		try {

			return FHSearchDepAgency.isDisplayed();
		} catch (Exception ex) {
			System.out.println("working as desired");
		}
		return false;
	}

	public void CreateOfficeTab() throws InterruptedException {
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(2000);

		CreateOffice.click();
	}

	public void TestingAac() throws InterruptedException {
		((JavascriptExecutor) driver).executeScript("scroll(0,200)");
		Random rand = new Random();
		float result = rand.nextFloat();
		randomOfficeTitle = "Test Office " + result;

		ofcName.sendKeys(randomOfficeTitle);
		Thread.sleep(1000);

		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy ");

		// get current date time with Date()
		Date date = new Date();

		// Now format the date
		String StartDate = dateFormat.format(date);

		// Print the Date
		System.out.println(StartDate);
		startdate1.sendKeys(StartDate);

		Thread.sleep(1000);
		// enddate1.sendKeys(StartDate);

		((JavascriptExecutor) driver).executeScript("scroll(0,600)");
		Address.sendKeys("123 street");
		country.click();
		countryChoice.click();
		Thread.sleep(1000);
		zip.sendKeys("36310");

		city.click();
		cityChoice.click();

		OfficeEditConfirmation.click();
		Thread.sleep(2000);

	}

	public boolean isAACworking() {
		try {

			return errormessageaac1.isDisplayed();
		} catch (Exception ex) {
			System.out.println("working as desired");
		}
		return false;
	}

	public boolean isAACworking2() {
		try {

			return errormessageaac2.isDisplayed();
		} catch (Exception ex) {
			System.out.println("working as desired");
		}
		return false;
	}

	public boolean isAACworking3() {
		try {

			return errormessageaac3.isDisplayed();
		} catch (Exception ex) {
			System.out.println("working as desired");
		}
		return false;
	}

	public boolean BlankInputErrorMessage() {
		try {

			return blankerrormessage.isDisplayed();
		} catch (Exception ex) {
			System.out.println("working as desired");
		}
		return false;
	}

	public boolean BlankInputErrorMessageName() {
		try {

			return blankerrormessageName.isDisplayed();
		} catch (Exception ex) {
			System.out.println("working as desired");
		}
		return false;
	}

	public boolean BlankInputErrorMessageAac() {
		try {

			return blankerrormessageAac.isDisplayed();
		} catch (Exception ex) {
			System.out.println("working as desired");
		}
		return false;
	}

	public boolean OfficeConfirmationPageValidation() throws InterruptedException {
		Thread.sleep(7000);
		try {

			return CreateConfirmationValidation.isDisplayed();
		} catch (Exception ex) {
			System.out.println("working as desired");
		}
		return false;
	}

	public void TestingAac2() throws InterruptedException {

		Aac.sendKeys("0a123");
		OfficeEditConfirmation.click();

		Thread.sleep(2000);
	}

	public void TestingAac3() throws InterruptedException {
		Aac.clear();
		Aac.sendKeys("i239df");
		OfficeEditConfirmation.click();
		Thread.sleep(2000);
	}

	public void TestingAac4() throws InterruptedException {
		Aac.clear();
		Aac.sendKeys("22or44");
		OfficeEditConfirmation.click();
		Thread.sleep(2000);
	}

	public void TestingAac5() throws InterruptedException {
		Aac.clear();
		Aac.sendKeys("99o32d");
		OfficeEditConfirmation.click();
		Thread.sleep(2000);
	}

	public void TestingAac6() throws InterruptedException {
		Aac.clear();
		Aac.sendKeys("99jril");
		OfficeEditConfirmation.click();
		Thread.sleep(2000);
	}

	public void TestingAac7() throws InterruptedException {
		Aac.clear();
		Aac.sendKeys("47abcd");
		OfficeEditConfirmation.click();
		Thread.sleep(2000);
	}

	public void TestingAac8() throws InterruptedException {
		Aac.clear();
		Aac.sendKeys("99abcd");
		OfficeEditConfirmation.click();
		Thread.sleep(1000);
	}

	public void TestingAac9() throws InterruptedException {
		Aac.clear();
		Random rand = new Random();
		int result = rand.nextInt(100000);
		randomAac = "99" + result;
		Thread.sleep(1000);
		Aac.sendKeys(randomAac);
		Thread.sleep(2000);
		OfficeEditConfirmation.click();
		Thread.sleep(30000);
		Thread.sleep(5000);
	}

	public void TestingName() throws InterruptedException {
		edit.click();
		Thread.sleep(3000);
		ofcName.clear();
		ofcName.sendKeys("Office for data");
		((JavascriptExecutor) driver).executeScript("scroll(0,1100)");

		OfficeEditConfirmation.click();
		Thread.sleep(9000);
	}

	public void TestingName2() throws InterruptedException {
		ofcName.clear();
		ofcName.sendKeys("    ");
		((JavascriptExecutor) driver).executeScript("scroll(0,1100)");
		Thread.sleep(2000);
		OfficeEditConfirmation.click();
		((JavascriptExecutor) driver).executeScript("scroll(0,1100)");
		OfficeEditConfirmation.click();

	}

	public void TestingName3() throws InterruptedException {
		ofcName.clear();
		ofcName.sendKeys("Office Of ChildCare");
		Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("scroll(0,1100)");
		Thread.sleep(2000);
		OfficeEditConfirmation.click();
		Thread.sleep(17000);
		((JavascriptExecutor) driver).executeScript("scroll(0,700)");
		Thread.sleep(2000);
		edit.click();
		Thread.sleep(12000);
		ofcName.clear();
		ofcName.sendKeys("AUTOMATED_SUBTIER_TEST");
		Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("scroll(0,1100)");
		Thread.sleep(2000);
		OfficeEditConfirmation.click();
		Thread.sleep(17000);
	}

	public void TestingStartDate() throws InterruptedException {
		Thread.sleep(5000);
		((JavascriptExecutor) driver).executeScript("scroll(0,7000)");
		edit.click();
		Thread.sleep(7000);
		ofcName.clear();
		ofcName.sendKeys(randomOfficeTitle);
		Thread.sleep(1000);
		startdate1.clear();
		startdate2.clear();
		startdate3.clear();
		Thread.sleep(4000);
		((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
		OfficeEditConfirmation.click();

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()=' Create Office ']")));
		Thread.sleep(15000);

		((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
		Thread.sleep(10000);

	}

	public void TestingStartDate2() throws InterruptedException {
		Thread.sleep(2000);
		startdate1.sendKeys("01122020");
		Thread.sleep(4000);
		
		((JavascriptExecutor) driver).executeScript("scroll(0,6000)");
		Thread.sleep(3000);
		OfficeEditConfirmation.click();
		Thread.sleep(15000);
	
		Thread.sleep(3000);
	
	
	}

	public void TestingStartDate3() throws InterruptedException {
		startdate1.clear();
		startdate2.clear();
		startdate3.clear();

		startdate1.sendKeys("01212020");
Thread.sleep(4000);
		
		((JavascriptExecutor) driver).executeScript("scroll(0,6000)");
		Thread.sleep(3000);
		OfficeEditConfirmation.click();
		Thread.sleep(15000);
	
		Thread.sleep(3000);
	
	
	}

	public void TestingStartDate4() throws InterruptedException {
		startdate1.clear();
		startdate2.clear();
		startdate3.clear();
		Thread.sleep(1000);
		startdate1.sendKeys("01142022");
Thread.sleep(4000);
		
		((JavascriptExecutor) driver).executeScript("scroll(0,6000)");
		Thread.sleep(3000);
		OfficeEditConfirmation.click();
		Thread.sleep(15000);
	
		Thread.sleep(3000);
	
	
	}

	public void TestingStartDate5() throws InterruptedException {
		startdate1.clear();
		startdate2.clear();
		startdate3.clear();
		Thread.sleep(3000);
		startdate1.sendKeys("01232022");
Thread.sleep(4000);
		
		((JavascriptExecutor) driver).executeScript("scroll(0,6000)");
		Thread.sleep(3000);
		OfficeEditConfirmation.click();
		Thread.sleep(15000);
	
		Thread.sleep(3000);
	
	
	}

	public void TestingEndDateCreationFlow() throws InterruptedException {
		startdate1.clear();
		startdate2.clear();
		startdate3.clear();
		Thread.sleep(1000);
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy ");

		Date date = new Date();

		// Now format the date
		String StartDate = dateFormat.format(date);

		// Print the Date
		System.out.println(StartDate);
		startdate1.sendKeys(StartDate);
		enddate1.clear();
		enddate2.clear();
		enddate3.clear();
		enddate1.sendKeys("01222018");
		((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
		OfficeEditConfirmation.click();
		Thread.sleep(5000);

	}

	public void OfficeTypes() throws InterruptedException {

		enddate1.clear();
		enddate2.clear();
		enddate3.clear();
		((JavascriptExecutor) driver).executeScript("scroll(0,4000)");
		ContractAwards.click();
		Thread.sleep(1000);
		((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
		Thread.sleep(2000);
		OfficeEditConfirmation.click();
		Thread.sleep(4000);
		OfficeEditConfirmation.click();
		Thread.sleep(5000);
		//((JavascriptExecutor) driver).executeScript("scroll(0,500)");

	}

	

	public void TestingContractAwards() throws InterruptedException {
		//
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy ");

		// get current date time with Date()
		Date date = new Date();

		// Now format the date
		String StartDate = dateFormat.format(date);
		enddate1.sendKeys("01112021");
		ContractAwardsDate.sendKeys("02212018");
		((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
		OfficeEditConfirmation.click();
		Thread.sleep(11000);
		((JavascriptExecutor) driver).executeScript("scroll(0,900)");
		// check
	}

	public void TestingContractAwards2() throws InterruptedException {
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy ");

		// get current date time with Date()
		Date date = new Date();

		// Now format the date
		String StartDate = dateFormat.format(date);
		ContractAwardsStateDate.clear();
		ContractAwardsStateDate2.clear();
		ContractAwardsStateDate3.clear();
		ContractAwardsDate.sendKeys("02212023");
		((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
		OfficeEditConfirmation.click();
		Thread.sleep(4000);
		((JavascriptExecutor) driver).executeScript("scroll(0,900)");
		Thread.sleep(1000);
//
//		((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
//		OfficeEditConfirmation.click();
//		Thread.sleep(4000);
//		
//		((JavascriptExecutor) driver).executeScript("scroll(0,900)");
		// check
	}

	public void TestingContractAwards3() throws InterruptedException {
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy ");

		// get current date time with Date()
		Date date = new Date();

		// Now format the date
		String StartDate = dateFormat.format(date);
		ContractAwardsStateDate.clear();
		ContractAwardsStateDate2.clear();
		ContractAwardsStateDate3.clear();

		Calendar c = Calendar.getInstance();
		c.setTime(date);

		// manipulate date

		c.add(Calendar.DATE, +1);

		// convert calendar to date
		Date currentDatePlusOne = c.getTime();

		System.out.println(dateFormat.format(currentDatePlusOne));
		ContractAwardsDate.sendKeys(dateFormat.format(currentDatePlusOne));
		Thread.sleep(3000);
		ContractAwardsEndDate0.sendKeys(StartDate);
		Thread.sleep(7000);

		((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
		OfficeEditConfirmation.click();
		Thread.sleep(17000);
		((JavascriptExecutor) driver).executeScript("scroll(0,900)");

		// DONT THINK I NEED THIS
		// ((JavascriptExecutor) driver).executeScript("scroll(0,900)");
		// check
	}

	public void TestingContractAwards4() throws InterruptedException {
		ContractAwardsEndDate0.clear();
		ContractAwardsEndDate2.clear();
		ContractAwardsEndDate3.clear();
		ContractAwardsEndDate0.sendKeys("02212018");
		((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
		OfficeEditConfirmation.click();
		Thread.sleep(17000);

		// DONT THINK I NEED THIS
		((JavascriptExecutor) driver).executeScript("scroll(0,900)");

		// check
	}
	public void TestingContractAwardsx() throws InterruptedException {
		Thread.sleep(5000);
		((JavascriptExecutor) driver).executeScript("scroll(0,-500)");

		Thread.sleep(1000);
		((JavascriptExecutor) driver).executeScript("scroll(0,500)");
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy ");

		// get current date time with Date()
		Date date = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(date);

		// manipulate date

		c.add(Calendar.DATE, -4);

		// convert calendar to date
		Date currentDatePlusMinusFour = c.getTime();

		// Now format the date
		String StartDate = dateFormat.format(date);
		startdate1.clear();
		startdate2.clear();
		startdate3.clear();
		Thread.sleep(1000);
		startdate1.sendKeys(dateFormat.format(currentDatePlusMinusFour));
		Thread.sleep(1000);
		((JavascriptExecutor) driver).executeScript("scroll(0,500)");
		ContractAwardsStateDate.clear();
		ContractAwardsStateDate2.clear();
		ContractAwardsStateDate3.clear();

		Calendar d = Calendar.getInstance();
		d.setTime(date);

		// manipulate date

		d.add(Calendar.DATE, -2);

		// convert calendar to date
		Date currentDatePlusMinusTwo = d.getTime();

		System.out.println(dateFormat.format(currentDatePlusMinusTwo));
		ContractAwardsDate.sendKeys(dateFormat.format(currentDatePlusMinusTwo));
		Thread.sleep(3000);
		Calendar e = Calendar.getInstance();
		e.setTime(date);

		// manipulate date

		e.add(Calendar.DATE, -1);

		// convert calendar to date
		Date currentDatePlusMinusOne = e.getTime();
		System.out.println(dateFormat.format(currentDatePlusMinusOne));
		Thread.sleep(3000);
		ContractAwardsEndDate0.clear();
		ContractAwardsEndDate2.clear();
		ContractAwardsEndDate3.clear();
		Thread.sleep(3000);
		ContractAwardsEndDate0.sendKeys(dateFormat.format(currentDatePlusMinusOne));
		Thread.sleep(3000);

		((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
		Thread.sleep(3000);
		
		System.out.println("WORKED");
		OfficeEditConfirmation.click();
		Thread.sleep(17000);
		
	}
	public void TestingContractAwards5() throws InterruptedException {
		
		Thread.sleep(5000);
		((JavascriptExecutor) driver).executeScript("scroll(0,9000)");

		edit.click();
		Thread.sleep(9000);
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy ");

		Date date = new Date();

		// Now format the date
		String StartDate = dateFormat.format(date);
		ContractAwardsStateDate.clear();
		ContractAwardsStateDate2.clear();
		ContractAwardsStateDate3.clear();

		Calendar c = Calendar.getInstance();
		c.setTime(date);

		// manipulate date

		c.add(Calendar.DATE, +1);

		// convert calendar to date
		Date currentDatePlusOne = c.getTime();

		System.out.println(dateFormat.format(currentDatePlusOne));
		ContractAwardsDate.sendKeys(dateFormat.format(currentDatePlusOne));
		Thread.sleep(3000);
		ContractAwardsEndDate0.clear();
		ContractAwardsEndDate2.clear();
		ContractAwardsEndDate3.clear();
		ContractAwardsEndDate0.sendKeys("02212023");
		Thread.sleep(6000);

		ContractAwardsEndDate0.clear();
		ContractAwardsEndDate2.clear();
		ContractAwardsEndDate3.clear();
		ContractAwardsEndDate0.sendKeys("02212023");
		Thread.sleep(6000);
		((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
		OfficeEditConfirmation.click();

		// OfficeEditConfirmation.click();
		Thread.sleep(17000);
		((JavascriptExecutor) driver).executeScript("scroll(0,9000)");
	}

	public void TestingContractAwards6() throws InterruptedException {

		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy ");

		Date date = new Date();

		// Now format the date
		String StartDate = dateFormat.format(date);
		Calendar c = Calendar.getInstance();
		c.setTime(date);

		// manipulate date

		c.add(Calendar.DATE, +1);

		// convert calendar to date
		Date currentDatePlusOne = c.getTime();
		((JavascriptExecutor) driver).executeScript("scroll(0,900)");
		// DONT THINK I NEED THIS
		// ((JavascriptExecutor) driver).executeScript("scroll(0,500)");
		// check
		ContractAwardsEndDate0.clear();
		ContractAwardsEndDate2.clear();
		ContractAwardsEndDate3.clear();

		ContractAwardsEndDate0.sendKeys(dateFormat.format(currentDatePlusOne));
		Thread.sleep(3000);
		((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
		ContractAwardsEndDate0.clear();
		ContractAwardsEndDate2.clear();
		ContractAwardsEndDate3.clear();

		ContractAwardsEndDate0.sendKeys(dateFormat.format(currentDatePlusOne));
		Thread.sleep(3000);
		OfficeEditConfirmation.click();
		Thread.sleep(17000);
		((JavascriptExecutor) driver).executeScript("scroll(0,9000)");
	}

	public void TestingContractAwards7() throws InterruptedException {
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy ");

		Date date = new Date();

		// Now format the date
		String StartDate = dateFormat.format(date);
		Calendar c = Calendar.getInstance();
		c.setTime(date);

		// manipulate date

		c.add(Calendar.DATE, +1);

		// convert calendar to date
		Date currentDatePlusOne = c.getTime();
		c.add(Calendar.DATE, +2);

		// convert calendar to date
		Date currentDatePlustwo = c.getTime();
		((JavascriptExecutor) driver).executeScript("scroll(0,500)");
		// DONT THINK I NEED THIS
		// ((JavascriptExecutor) driver).executeScript("scroll(0,500)");
		// check
		ContractAwardsEndDate0.clear();
		ContractAwardsEndDate2.clear();
		ContractAwardsEndDate3.clear();

		ContractAwardsEndDate0.sendKeys(dateFormat.format(currentDatePlustwo));
		Thread.sleep(3000);
		((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
		OfficeEditConfirmation.click();
		Thread.sleep(17000);
		((JavascriptExecutor) driver).executeScript("scroll(0,9000)");
	}

	public void TestingFinancialAssistanceAwards() throws InterruptedException {
		edit.click();
		Thread.sleep(9000);
		((JavascriptExecutor) driver).executeScript("scroll(0,5000)");
		FinancialAssistanceAwards.click();
		Thread.sleep(5000);
		((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
		Thread.sleep(5000);
		OfficeEditConfirmation.click();
		Thread.sleep(17000);

		((JavascriptExecutor) driver).executeScript("scroll(0,5000)");
		// check for date is requried
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy ");

		// get current date time with Date()
		Date date = new Date();

		// Now format the date
		String StartDate = dateFormat.format(date);

		FinancialAssistanceAwardsStartDate.sendKeys("02212018");
		Thread.sleep(7000);
		//((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
		//Thread.sleep(2000);
		OfficeEditConfirmation.click();
		Thread.sleep(17000);
		((JavascriptExecutor) driver).executeScript("scroll(0,900)");
		// check
	}

	public void TestingFinancialAssistanceAwards2() throws InterruptedException {
		FinancialAssistanceAwardsStartDate.clear();
		FinancialAssistanceAwardsStart2.clear();
		FinancialAssistanceAwardsStart3.clear();
		Thread.sleep(3000);
		FinancialAssistanceAwardsStartDate.sendKeys("02212023");
		Thread.sleep(1000);
		((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
		Thread.sleep(2000);
		OfficeEditConfirmation.click();
//		Thread.sleep(1000);
//		((JavascriptExecutor) driver).executeScript("scroll(0,900)");
//
//		// check
//		Thread.sleep(1000);
//
//		((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
//		Thread.sleep(1000);
//
//		OfficeEditConfirmation.click();
		Thread.sleep(4000);
		
		((JavascriptExecutor) driver).executeScript("scroll(0,900)");
	}

	public void TestingFinancialAssistanceAwards3() throws InterruptedException {
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy ");

		// get current date time with Date()
		Date date = new Date();

		// Now format the date
		String StartDate = dateFormat.format(date);

		FinancialAssistanceAwardsStartDate.clear();
		FinancialAssistanceAwardsStart2.clear();
		FinancialAssistanceAwardsStart3.clear();

		Calendar c = Calendar.getInstance();
		c.setTime(date);

		// manipulate date

		c.add(Calendar.DATE, +1);

		// convert calendar to date
		Date currentDatePlusOne = c.getTime();

		System.out.println(dateFormat.format(currentDatePlusOne));
		FinancialAssistanceAwardsStartDate.sendKeys(dateFormat.format(currentDatePlusOne));
		Thread.sleep(3000);
		FinancialAssistanceAwardsEnd0.sendKeys(StartDate);
		Thread.sleep(7000);

		((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
		OfficeEditConfirmation.click();
		Thread.sleep(17000);
		((JavascriptExecutor) driver).executeScript("scroll(0,900)");

		// DONT THINK I NEED THIS
		((JavascriptExecutor) driver).executeScript("scroll(0,500)");
		// check
	}

	public void TestingFinancialAssistanceAwards4() throws InterruptedException {

		FinancialAssistanceAwardsEnd0.clear();
		FinancialAssistanceAwardsEnd2.clear();
		FinancialAssistanceAwardsEnd3.clear();
		FinancialAssistanceAwardsEnd0.sendKeys("02212018");
		Thread.sleep(7000);
		((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
		OfficeEditConfirmation.click();
		Thread.sleep(17000);
		((JavascriptExecutor) driver).executeScript("scroll(0,900)");

		// DONT THINK I NEED THIS
		// ((JavascriptExecutor) driver).executeScript("scroll(0,500)");
		// check
	}

	public void TestingFinancialAssistanceAwards5() throws InterruptedException {

		FinancialAssistanceAwardsEnd0.clear();
		FinancialAssistanceAwardsEnd2.clear();
		FinancialAssistanceAwardsEnd3.clear();
		FinancialAssistanceAwardsEnd0.sendKeys("02212023");
		Thread.sleep(6000);

		FinancialAssistanceAwardsEnd0.clear();
		FinancialAssistanceAwardsEnd2.clear();
		FinancialAssistanceAwardsEnd3.clear();
		FinancialAssistanceAwardsEnd0.sendKeys("02212023");
		Thread.sleep(6000);
		((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
		OfficeEditConfirmation.click();
		Thread.sleep(17000);
		((JavascriptExecutor) driver).executeScript("scroll(0,900)");

	}

	public void TestingFinancialAssistanceAwards6() throws InterruptedException {
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy ");

		Date date = new Date();

		// Now format the date
		String StartDate = dateFormat.format(date);
		Calendar c = Calendar.getInstance();
		c.setTime(date);

		// manipulate date

		c.add(Calendar.DATE, +1);

		// convert calendar to date
		Date currentDatePlusOne = c.getTime();
		((JavascriptExecutor) driver).executeScript("scroll(0,500)");
		// DONT THINK I NEED THIS
		// ((JavascriptExecutor) driver).executeScript("scroll(0,500)");
		// check
		FinancialAssistanceAwardsEnd0.clear();
		FinancialAssistanceAwardsEnd2.clear();
		FinancialAssistanceAwardsEnd3.clear();

		FinancialAssistanceAwardsEnd0.sendKeys(dateFormat.format(currentDatePlusOne));
		FinancialAssistanceAwardsEnd0.clear();
		FinancialAssistanceAwardsEnd2.clear();
		FinancialAssistanceAwardsEnd3.clear();
		FinancialAssistanceAwardsEnd0.sendKeys(dateFormat.format(currentDatePlusOne));
		Thread.sleep(3000);
		((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
		OfficeEditConfirmation.click();
		Thread.sleep(17000);
		((JavascriptExecutor) driver).executeScript("scroll(0,9000)");
		// this assertion isnt going to work yet, should not work. The end date is
		// before the start date of an office type OR is equal to the start date.The end
		// date cannot be earlier than or equal to the start date.
		// FOR NOW SHOULD TAKE YOU TO CONFIRMATION but after error message should show.
	}

	public void TestingFinancialAssistanceAwards7() throws InterruptedException {

		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy ");

		Date date = new Date();

		// Now format the date
		String StartDate = dateFormat.format(date);
		Calendar c = Calendar.getInstance();
		c.setTime(date);

		c.add(Calendar.DATE, +2);

		// convert calendar to date
		Date currentDatePlustwo = c.getTime();
		((JavascriptExecutor) driver).executeScript("scroll(0,500)");
		// DONT THINK I NEED THIS
		// ((JavascriptExecutor) driver).executeScript("scroll(0,500)");
		// check
		FinancialAssistanceAwardsEnd0.clear();
		FinancialAssistanceAwardsEnd2.clear();
		FinancialAssistanceAwardsEnd3.clear();

		FinancialAssistanceAwardsEnd0.sendKeys(dateFormat.format(currentDatePlustwo));
		FinancialAssistanceAwardsEnd0.clear();
		FinancialAssistanceAwardsEnd2.clear();
		FinancialAssistanceAwardsEnd3.clear();
		FinancialAssistanceAwardsEnd0.sendKeys(dateFormat.format(currentDatePlustwo));
		Thread.sleep(3000);
		((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
		OfficeEditConfirmation.click();
		Thread.sleep(17000);
		((JavascriptExecutor) driver).executeScript("scroll(0,9000)");
	}

	public void TestingContractFunding() throws InterruptedException {
		((JavascriptExecutor) driver).executeScript("scroll(0,9000)");
		Thread.sleep(7000);
		edit.click();
		Thread.sleep(6000);
		((JavascriptExecutor) driver).executeScript("scroll(0,5000)");
		Thread.sleep(3000);
		ContractFunding.click();
		Thread.sleep(3000);
		((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
		Thread.sleep(4000);
		OfficeEditConfirmation.click();
		Thread.sleep(17000);

		((JavascriptExecutor) driver).executeScript("scroll(0,9000)");
		// check for date is requried
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy ");

		// get current date time with Date()
		Date date = new Date();

		// Now format the date
		String StartDate = dateFormat.format(date);

		ContractFundingStartDate.sendKeys("02212018");
		
		Thread.sleep(2000);

		((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
		
		Thread.sleep(3000);
		
		OfficeEditConfirmation.click();
		Thread.sleep(17000);
		((JavascriptExecutor) driver).executeScript("scroll(0,900)");
		// check
	}

	public void TestingContractFunding2() throws InterruptedException {

		ContractFundingStartDate.clear();
		ContractFundingStartDate2.clear();
		ContractFundingStartDate3.clear();
		
		Thread.sleep(2000);
		ContractFundingStartDate.sendKeys("02212023");
		Thread.sleep(3000);
		((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
		Thread.sleep(3000);
		OfficeEditConfirmation.click();
//		Thread.sleep(1000);
//		((JavascriptExecutor) driver).executeScript("scroll(0,900)");
//
//		// check
//		Thread.sleep(1000);
//
//		((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
//		Thread.sleep(1000);
//
//		OfficeEditConfirmation.click();
		Thread.sleep(4000);
		
		((JavascriptExecutor) driver).executeScript("scroll(0,900)");
	}

	public void TestingContractFunding3() throws InterruptedException {
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy ");

		Date date = new Date();

		// Now format the date
		String StartDate = dateFormat.format(date);
		Calendar c = Calendar.getInstance();
		c.setTime(date);

		ContractFundingStartDate.clear();
		ContractFundingStartDate2.clear();
		ContractFundingStartDate3.clear();

		// Calendar c = Calendar.getInstance();
		// c.setTime(date);

		// manipulate date

		c.add(Calendar.DATE, +1);

		// convert calendar to date
		Date currentDatePlusOne = c.getTime();

		System.out.println(dateFormat.format(currentDatePlusOne));
		ContractFundingStartDate.sendKeys(dateFormat.format(currentDatePlusOne));
		Thread.sleep(3000);
		ContractFundingEndDates0.sendKeys(StartDate);
		Thread.sleep(7000);

		((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
		Thread.sleep(3000);
		OfficeEditConfirmation.click();
		Thread.sleep(17000);
		((JavascriptExecutor) driver).executeScript("scroll(0,900)");

		// DONT THINK I NEED THIS
		((JavascriptExecutor) driver).executeScript("scroll(0,500)");
		// check
	}

	public void TestingContractFunding4() throws InterruptedException {

		ContractFundingEndDates0.clear();
		ContractFundingEndDate2.clear();
		ContractFundingEndDate3.clear();
		
		Thread.sleep(2000);
		ContractFundingEndDates0.sendKeys("02212018");
		((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
		Thread.sleep(3000);
		OfficeEditConfirmation.click();
		Thread.sleep(17000);
		((JavascriptExecutor) driver).executeScript("scroll(0,9000)");
	}

	// DONT THINK I NEED THIS
	// ((JavascriptExecutor) driver).executeScript("scroll(0,500)");
	// check
	public void TestingContractFunding5() throws InterruptedException {

		ContractFundingEndDates0.clear();
		ContractFundingEndDate2.clear();
		ContractFundingEndDate3.clear();
		
		Thread.sleep(2000);
		ContractFundingEndDates0.sendKeys("02212023");
		Thread.sleep(6000);

		ContractFundingEndDates0.clear();
		ContractFundingEndDate2.clear();
		ContractFundingEndDate3.clear();
		
		Thread.sleep(2000);
		ContractFundingEndDates0.sendKeys("02212023");
		Thread.sleep(6000);
		((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
		Thread.sleep(3000);
		OfficeEditConfirmation.click();

		// OfficeEditConfirmation.click();
		Thread.sleep(17000);
		((JavascriptExecutor) driver).executeScript("scroll(0,9000)");
	}

	public void TestingContractFunding6() throws InterruptedException {
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy ");

		Date date = new Date();

		// Now format the date
		String StartDate = dateFormat.format(date);
		Calendar c = Calendar.getInstance();
		c.setTime(date);

		// manipulate date

		c.add(Calendar.DATE, +1);

		// convert calendar to date
		Date currentDatePlusOne = c.getTime();
		((JavascriptExecutor) driver).executeScript("scroll(0,500)");
		// DONT THINK I NEED THIS
		// ((JavascriptExecutor) driver).executeScript("scroll(0,500)");
		// check
		ContractFundingEndDates0.clear();
		ContractFundingEndDate2.clear();
		ContractFundingEndDate3.clear();
		
		Thread.sleep(2000);
		ContractFundingEndDates0.sendKeys(dateFormat.format(currentDatePlusOne));
		Thread.sleep(3000);
		((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
		Thread.sleep(3000);
		OfficeEditConfirmation.click();
		Thread.sleep(17000);
		((JavascriptExecutor) driver).executeScript("scroll(0,9000)");
		// this assertion isnt going to work yet, should not work. The end date is
		// before the start date of an office type OR is equal to the start date.The end
		// date cannot be earlier than or equal to the start date.
		// FOR NOW SHOULD TAKE YOU TO CONFIRMATION but after error message should show.
	}

	public void TestingContractFunding7() throws InterruptedException {
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy ");

		Date date = new Date();

		// Now format the date
		String StartDate = dateFormat.format(date);
		Calendar c = Calendar.getInstance();
		c.setTime(date);

		c.add(Calendar.DATE, +2);

		// convert calendar to date
		Date currentDatePlustwo = c.getTime();
		((JavascriptExecutor) driver).executeScript("scroll(0,500)");
		// DONT THINK I NEED THIS
		// ((JavascriptExecutor) driver).executeScript("scroll(0,500)");
		// check
		ContractFundingEndDates0.clear();
		ContractFundingEndDate2.clear();
		ContractFundingEndDate3.clear();
		
		Thread.sleep(2000);
		ContractFundingEndDates0.sendKeys(dateFormat.format(currentDatePlustwo));
		Thread.sleep(3000);
		((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
		Thread.sleep(3000);
		OfficeEditConfirmation.click();
		Thread.sleep(17000);
		((JavascriptExecutor) driver).executeScript("scroll(0,9000)");
	}

	public void TestingFinancialAssistanceFunding() throws InterruptedException {
		((JavascriptExecutor) driver).executeScript("scroll(0,9000)");
		Thread.sleep(9000);
		edit.click();
		Thread.sleep(9000);
		((JavascriptExecutor) driver).executeScript("scroll(0,5000)");
		Thread.sleep(3000);
		FinancialAssistanceFunding.click();
		Thread.sleep(3000);
		((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
		Thread.sleep(3000);
		OfficeEditConfirmation.click();
		Thread.sleep(17000);

		((JavascriptExecutor) driver).executeScript("scroll(0,5000)");
		// check for date is requried
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy ");

		// get current date time with Date()
		Date date = new Date();

		// Now format the date
		String StartDate = dateFormat.format(date);

		FinancialAssistanceFundingStartDate.sendKeys("02212018");
		Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
		Thread.sleep(3000);
		OfficeEditConfirmation.click();
		Thread.sleep(17000);
		((JavascriptExecutor) driver).executeScript("scroll(0,900)");
		// check
	}

	public void TestingFinancialAssistanceFunding2() throws InterruptedException {

		FinancialAssistanceFundingStartDate.clear();
		FinancialAssistanceFundingStartDate2.clear();
		FinancialAssistanceFundingStartDate3.clear();
		
		Thread.sleep(2000);
		FinancialAssistanceFundingStartDate.sendKeys("02212023");
		
		Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
		Thread.sleep(3000);
		OfficeEditConfirmation.click();
		Thread.sleep(1000);
//		((JavascriptExecutor) driver).executeScript("scroll(0,900)");
//
//		// check
//		Thread.sleep(1000);
//
//		((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
//		Thread.sleep(1000);
//
//		OfficeEditConfirmation.click();
		Thread.sleep(4000);
		
		((JavascriptExecutor) driver).executeScript("scroll(0,900)");
	}

	public void TestingFinancialAssistanceFunding3() throws InterruptedException {
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy ");

		// get current date time with Date()
		Date date = new Date();

		// Now format the date
		String StartDate = dateFormat.format(date);
		FinancialAssistanceFundingStartDate.clear();
		FinancialAssistanceFundingStartDate2.clear();
		FinancialAssistanceFundingStartDate3.clear();

		Calendar c = Calendar.getInstance();
		c.setTime(date);

		// manipulate date

		c.add(Calendar.DATE, +1);

		// convert calendar to date
		Date currentDatePlusOne = c.getTime();

		System.out.println(dateFormat.format(currentDatePlusOne));
		FinancialAssistanceFundingStartDate.sendKeys(dateFormat.format(currentDatePlusOne));
		Thread.sleep(3000);
		FinancialAssistanceFundingEndDates0.sendKeys(StartDate);
		Thread.sleep(7000);

		((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
		Thread.sleep(5000);
		OfficeEditConfirmation.click();

		Thread.sleep(17000);

		// DONT THINK I NEED THIS
		((JavascriptExecutor) driver).executeScript("scroll(0,900)");
		// check
	}

	public void TestingFinancialAssistanceFunding4() throws InterruptedException {

		FinancialAssistanceFundingEndDates0.clear();
		FinancialAssistanceFundingEndDate2.clear();
		FinancialAssistanceFundingEndDate3.clear();
		
		Thread.sleep(2000);
		FinancialAssistanceFundingEndDates0.sendKeys("02212018");
		
		Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
		Thread.sleep(3000);
		OfficeEditConfirmation.click();

	
		Thread.sleep(17000);

		// DONT THINK I NEED THIS
		// ((JavascriptExecutor) driver).executeScript("scroll(0,500)");
		// check
		((JavascriptExecutor) driver).executeScript("scroll(0,900)");
	}

	public void TestingFinancialAssistanceFunding5() throws InterruptedException {

		FinancialAssistanceFundingEndDates0.clear();
		FinancialAssistanceFundingEndDate2.clear();
		FinancialAssistanceFundingEndDate3.clear();
		
		Thread.sleep(2000);
		FinancialAssistanceFundingEndDates0.sendKeys("02212023");
		Thread.sleep(6000);

		FinancialAssistanceFundingEndDates0.clear();
		FinancialAssistanceFundingEndDate2.clear();
		FinancialAssistanceFundingEndDate3.clear();
		
		Thread.sleep(2000);
		FinancialAssistanceFundingEndDates0.sendKeys("02212023");
		Thread.sleep(6000);
		((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
		Thread.sleep(3000);
		OfficeEditConfirmation.click();
		Thread.sleep(17000);

		((JavascriptExecutor) driver).executeScript("scroll(0,9000)");

	}

	public void TestingFinancialAssistanceFunding6() throws InterruptedException {
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy ");

		Date date = new Date();

		// Now format the date
		String StartDate = dateFormat.format(date);
		Calendar c = Calendar.getInstance();
		c.setTime(date);

		// manipulate date

		c.add(Calendar.DATE, +1);

		// convert calendar to date
		Date currentDatePlusOne = c.getTime();
		((JavascriptExecutor) driver).executeScript("scroll(0,500)");
		// DONT THINK I NEED THIS
		// ((JavascriptExecutor) driver).executeScript("scroll(0,500)");
		// check
		FinancialAssistanceFundingEndDates0.clear();
		FinancialAssistanceFundingEndDate2.clear();
		FinancialAssistanceFundingEndDate3.clear();
		
		Thread.sleep(2000);
		FinancialAssistanceFundingEndDates0.sendKeys(dateFormat.format(currentDatePlusOne));
		Thread.sleep(3000);
		((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
		Thread.sleep(3000);
		OfficeEditConfirmation.click();
		Thread.sleep(17000);
		((JavascriptExecutor) driver).executeScript("scroll(0,9000)");
		// this assertion isnt going to work yet, should not work. The end date is
		// before the start date of an office type OR is equal to the start date.The end
		// date cannot be earlier than or equal to the start date.
		// FOR NOW SHOULD TAKE YOU TO CONFIRMATION but after error message should show.
	}

	public void TestingFinancialAssistanceFunding7() throws InterruptedException {
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy ");

		Date date = new Date();

		// Now format the date
		String StartDate = dateFormat.format(date);
		Calendar c = Calendar.getInstance();
		c.setTime(date);

		c.add(Calendar.DATE, +2);

		// convert calendar to date
		Date currentDatePlustwo = c.getTime();
		((JavascriptExecutor) driver).executeScript("scroll(0,500)");
		// DONT THINK I NEED THIS
		// ((JavascriptExecutor) driver).executeScript("scroll(0,500)");
		// check
		FinancialAssistanceFundingEndDates0.clear();
		FinancialAssistanceFundingEndDate2.clear();
		FinancialAssistanceFundingEndDate3.clear();
		
		Thread.sleep(2000);
		FinancialAssistanceFundingEndDates0.sendKeys(dateFormat.format(currentDatePlustwo));
		Thread.sleep(3000);
		((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
		Thread.sleep(3000);
		OfficeEditConfirmation.click();
		Thread.sleep(17000);
		((JavascriptExecutor) driver).executeScript("scroll(0,7000)");

	}

	public void OfficeTypes2() throws InterruptedException {

		ContractAwards.click();
		Thread.sleep(1000);
		FinancialAssistanceAwards.click();
		((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
		OfficeEditConfirmation.click();
		Thread.sleep(5000);

	}

	public void OfficeTypes3() throws InterruptedException {

		FinancialAssistanceAwards.click();
		Thread.sleep(1000);
		ContractFunding.click();
		((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
		OfficeEditConfirmation.click();
		Thread.sleep(5000);
	}

	public void OfficeTypes4() throws InterruptedException {

		ContractFunding.click();
		Thread.sleep(1000);
		FinancialAssistanceFunding.click();
		((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
		OfficeEditConfirmation.click();
		Thread.sleep(5000);
		//////////////////////////////////////////////////

		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy ");
		Date date = new Date();

		Calendar c = Calendar.getInstance();
		c.setTime(date);

		// manipulate date

		c.add(Calendar.DATE, -1);

		// convert calendar to date
		Date currentDatePlusOne = c.getTime();

		System.out.println(dateFormat.format(currentDatePlusOne));
		///////////////////////////////////////////////////////////////
	}

	public boolean IsNameWorking() throws InterruptedException {
		Thread.sleep(4000);
		((JavascriptExecutor) driver).executeScript("scroll(0,400)");
		Thread.sleep(2000);
		try {

			return NameError.isDisplayed();
		} catch (Exception ex) {
			System.out.println("working as desired");
		}
		return false;
	}

	public boolean StartDateValidation() throws InterruptedException {
		Thread.sleep(5000);
		((JavascriptExecutor) driver).executeScript("scroll(0,700)");
		Thread.sleep(5000);
		try {

			return StartDateError.isDisplayed();
		} catch (Exception ex) {
			System.out.println("working as desired");
		}
		return false;
	}

	public boolean StartDateValidation2() throws InterruptedException {
		Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("scroll(0,700)");
		Thread.sleep(2000);
		try {

			return StartDateError2.isDisplayed();
		} catch (Exception ex) {
			System.out.println("working as desired");
		}
		return false;
	}

	public boolean StartDateValidation3() throws InterruptedException {
		// ((JavascriptExecutor) driver).executeScript("scroll(0,700)");
		Thread.sleep(5000);
		try {

			return StartDateError3.isDisplayed();
		} catch (Exception ex) {
			System.out.println("working as desired");
		}
		return false;
	}

	public boolean StartDateValidation4() throws InterruptedException {
		// ((JavascriptExecutor) driver).executeScript("scroll(0,700)");
		Thread.sleep(2000);
		try {

			return StartDateError44.isDisplayed();
		} catch (Exception ex) {
			System.out.println("working as desired");
		}
		return false;
	}

	public boolean StartDateValidation5() throws InterruptedException {
		// ((JavascriptExecutor) driver).executeScript("scroll(0,700)");
		Thread.sleep(2000);
		try {

			return StartDateError5.isDisplayed();
		} catch (Exception ex) {
			System.out.println("working as desired");
		}
		return false;
	}

	public boolean EndDateValidation00() throws InterruptedException {
		Thread.sleep(9000);
		((JavascriptExecutor) driver).executeScript("scroll(0,600)");

		Thread.sleep(5000);
		try {

			return EndDateError1.isDisplayed();
		} catch (Exception ex) {
			System.out.println("working as desired");
		}
		return false;
	}

	public boolean EndDateValidation1() throws InterruptedException {
		Thread.sleep(7000);

		((JavascriptExecutor) driver).executeScript("scroll(0,900)");
		Thread.sleep(2000);
		try {

			return TypeStartDateError2.isDisplayed();
		} catch (Exception ex) {
			System.out.println("working as desired");
		}
		return false;
	}

	public boolean EndDateValidation2() throws InterruptedException {

		Thread.sleep(7000);

		((JavascriptExecutor) driver).executeScript("scroll(0,900)");
		Thread.sleep(2000);
		try {

			return TypeStartDateError3.isDisplayed();
		} catch (Exception ex) {
			System.out.println("working as desired");
		}
		return false;
	}

	public boolean EndDateValidation3() throws InterruptedException {
		Thread.sleep(11000);

		((JavascriptExecutor) driver).executeScript("scroll(0,900)");
		Thread.sleep(2000);
		try {

			return TypeStartDateError4.isDisplayed();

		} catch (Exception ex) {
			System.out.println("working as desired");
		}
		return false;
	}

	public boolean EndDateValidation6() throws InterruptedException {
		Thread.sleep(7000);

		((JavascriptExecutor) driver).executeScript("scroll(0,900)");
		Thread.sleep(2000);
		try {

			return TypeStartDateError7.isDisplayed();

		} catch (Exception ex) {
			System.out.println("working as desired");
		}
		return false;
	}

	public boolean EndDateValidation7() throws InterruptedException {
		Thread.sleep(7000);

		((JavascriptExecutor) driver).executeScript("scroll(0,900)");
		Thread.sleep(2000);
		try {

			return TypeStartDateError8.isDisplayed();

		} catch (Exception ex) {
			System.out.println("working as desired");
		}
		return false;
	}

	public boolean EndDateValidation8() throws InterruptedException {
		Thread.sleep(7000);

		((JavascriptExecutor) driver).executeScript("scroll(0,900)");
		Thread.sleep(2000);
		try {

			return TypeStartDateError9.isDisplayed();

		} catch (Exception ex) {
			System.out.println("working as desired");
		}
		return false;
	}

	public boolean EndDateValidation9() throws InterruptedException {
		Thread.sleep(7000);

		((JavascriptExecutor) driver).executeScript("scroll(0,900)");
		Thread.sleep(2000);
		try {

			return TypeStartDateError10.isDisplayed();

		} catch (Exception ex) {
			System.out.println("working as desired");
		}
		return false;
	}

	public boolean EndDateValidation10() throws InterruptedException {
		Thread.sleep(7000);

		((JavascriptExecutor) driver).executeScript("scroll(0,900)");
		Thread.sleep(2000);
		try {

			return TypeStartDateError11.isDisplayed();

		} catch (Exception ex) {
			System.out.println("working as desired");
		}
		return false;
	}

	public boolean EndDateValidation11() throws InterruptedException {
		Thread.sleep(7000);

		((JavascriptExecutor) driver).executeScript("scroll(0,900)");
		Thread.sleep(2000);
		try {

			return TypeStartDateError12.isDisplayed();

		} catch (Exception ex) {
			System.out.println("working as desired");
		}
		return false;
	}

	public boolean EndDateValidation12() throws InterruptedException {
		Thread.sleep(7000);

		((JavascriptExecutor) driver).executeScript("scroll(0,900)");
		Thread.sleep(2000);
		try {

			return TypeStartDateError13.isDisplayed();

		} catch (Exception ex) {
			System.out.println("working as desired");
		}
		return false;
	}

	public boolean EndDateValidation13() throws InterruptedException {
		Thread.sleep(7000);

		((JavascriptExecutor) driver).executeScript("scroll(0,900)");
		Thread.sleep(2000);
		try {

			return TypeStartDateError14.isDisplayed();

		} catch (Exception ex) {
			System.out.println("working as desired");
		}
		return false;
	}

	public boolean EndDateValidation14() throws InterruptedException {
		Thread.sleep(7000);

		((JavascriptExecutor) driver).executeScript("scroll(0,900)");
		Thread.sleep(2000);
		try {

			return TypeStartDateError15.isDisplayed();

		} catch (Exception ex) {
			System.out.println("working as desired");
		}
		return false;
	}

	public boolean EndDateValidation4() throws InterruptedException {
		Thread.sleep(11000);

		((JavascriptExecutor) driver).executeScript("scroll(0,900)");
		Thread.sleep(2000);
		try {

			return TypeStartDateError5.isDisplayed();
		} catch (Exception ex) {
			System.out.println("working as desired");
		}
		return false;
	}

	public boolean EndDateValidation5() throws InterruptedException {
		Thread.sleep(7000);

		((JavascriptExecutor) driver).executeScript("scroll(0,900)");
		Thread.sleep(2000);
		try {

			return TypeStartDateError6.isDisplayed();
		} catch (Exception ex) {
			System.out.println("working as desired");
		}
		return false;
	}

	public boolean EndDateValidationSame() throws InterruptedException {
		Thread.sleep(11000);

		((JavascriptExecutor) driver).executeScript("scroll(0,900)");
		Thread.sleep(2000);
		try {

			return TypeStartDateError7.isDisplayed();
		} catch (Exception ex) {
			System.out.println("working as desired");
		}
		return false;
	}

	public boolean EndDateValidation() throws InterruptedException {
		// ((JavascriptExecutor) driver).executeScript("scroll(0,700)");
		Thread.sleep(2000);
		try {

			return StartDateError2.isDisplayed();
		} catch (Exception ex) {
			System.out.println("working as desired");
		}
		return false;
	}

	public void CreatePosFlow() throws InterruptedException {

		Random rand = new Random();
		int result = rand.nextInt(10000);
		randomAac = "99" + result;
		Thread.sleep(1000);
		Aac.sendKeys(randomAac);
		Thread.sleep(1000);

		Random rand2 = new Random();
		float result2 = rand2.nextFloat();
		randomOfficeTitle = "Test Office " + result2;

		ofcName.sendKeys(randomOfficeTitle);
		Thread.sleep(1000);

		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy ");

		// get current date time with Date()
		Date date = new Date();

		String StartDate = dateFormat.format(date);
		startdate1.sendKeys(StartDate);

		Calendar c = Calendar.getInstance();
		c.setTime(date);
		// convert calendar to date
		c.add(Calendar.DATE, +3);
				Date currentDatePlusThree= c.getTime();
			

				enddate1.sendKeys(dateFormat.format(currentDatePlusThree));
				Thread.sleep(3000);
		// manipulate date

		c.add(Calendar.DATE, -2);

		// convert calendar to date
		Date currentDatePlusOne = c.getTime();
		c.add(Calendar.DATE, +1);

		// convert calendar to date
		Date currentDatePlustwo = c.getTime();
		Thread.sleep(1000);
		((JavascriptExecutor) driver).executeScript("scroll(0,500)");
		ContractAwards.click();
		ContractAwardsStateDate.sendKeys(dateFormat.format(currentDatePlusOne));
		ContractAwardsEndDate0.sendKeys(dateFormat.format(currentDatePlustwo));
		FinancialAssistanceAwards.click();
		FinancialAssistanceAwardsStartDate.sendKeys(dateFormat.format(currentDatePlusOne));
		FinancialAssistanceAwardsEnd0.sendKeys(dateFormat.format(currentDatePlustwo));
		ContractFunding.click();
		ContractFundingStartDate.sendKeys(dateFormat.format(currentDatePlusOne));
		ContractFundingEndDates0.sendKeys(dateFormat.format(currentDatePlustwo));
		FinancialAssistanceFunding.click();
		FinancialAssistanceFundingStartDate.sendKeys(dateFormat.format(currentDatePlusOne));
		FinancialAssistanceFundingEndDates0.sendKeys(dateFormat.format(currentDatePlustwo));
		Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("scroll(0,200)");
		Address.sendKeys("123 street");
		country.click();
		countryChoice.click();
		Thread.sleep(1000);
		zip.sendKeys("36310");

		city.click();
		cityChoice.click();

		Thread.sleep(3000);
		OfficeEditConfirmation.click();
		Thread.sleep(15000);
		((JavascriptExecutor) driver).executeScript("scroll(0,9000)");
	
		
	}
	public void CreatePosFlowMail1() throws InterruptedException {

		Random rand = new Random();
		int result = rand.nextInt(10000);
		randomAac = "99" + result;
		Thread.sleep(2000);
		Aac.sendKeys(randomAac);
		Thread.sleep(2000);

		Random rand2 = new Random();
		float result2 = rand2.nextFloat();
		randomOfficeTitle = "Test Office " + result2;

		ofcName.sendKeys(randomOfficeTitle);
		Thread.sleep(1000);

		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy ");

		// get current date time with Date()
		Date date = new Date();

		String StartDate = dateFormat.format(date);
		startdate1.sendKeys(StartDate);

		Calendar c = Calendar.getInstance();
		c.setTime(date);
		// convert calendar to date
		c.add(Calendar.DATE, +3);
				Date currentDatePlusThree= c.getTime();
			

				enddate1.sendKeys(dateFormat.format(currentDatePlusThree));
				Thread.sleep(3000);
		// manipulate date

		c.add(Calendar.DATE, -2);

		// convert calendar to date
		Date currentDatePlusOne = c.getTime();
		c.add(Calendar.DATE, +1);

		// convert calendar to date
		Date currentDatePlustwo = c.getTime();
		Thread.sleep(1000);
		((JavascriptExecutor) driver).executeScript("scroll(0,500)");
		
		Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("scroll(0,200)");
		Address.sendKeys("123 street");
		country.click();
		countryChoice.click();
		Thread.sleep(1000);
		zip.sendKeys("36310");

		city.click();
		cityChoice.click();

		Thread.sleep(3000);
		OfficeEditConfirmation.click();
		Thread.sleep(15000);
		Thread.sleep(2000);

	
		
	}
	public void CreatePosFlowEmail2() throws InterruptedException {

		Random rand = new Random();
		int result = rand.nextInt(10000);
		randomAac = "47" + result;
		Thread.sleep(2000);
		Aac.sendKeys(randomAac);
		Thread.sleep(2000);

		Random rand2 = new Random();
		float result2 = rand2.nextFloat();
		randomOfficeTitle = "Test Office " + result2;

		ofcName.sendKeys(randomOfficeTitle);
		Thread.sleep(1000);

		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy ");

		// get current date time with Date()
		Date date = new Date();

		String StartDate = dateFormat.format(date);
		startdate1.sendKeys(StartDate);

		Calendar c = Calendar.getInstance();
		c.setTime(date);
		// convert calendar to date
		c.add(Calendar.DATE, +3);
				Date currentDatePlusThree= c.getTime();
			

				enddate1.sendKeys(dateFormat.format(currentDatePlusThree));
				Thread.sleep(3000);
		// manipulate date

		c.add(Calendar.DATE, -2);

		// convert calendar to date
		Date currentDatePlusOne = c.getTime();
		c.add(Calendar.DATE, +1);

		// convert calendar to date
		Date currentDatePlustwo = c.getTime();
		Thread.sleep(1000);
		((JavascriptExecutor) driver).executeScript("scroll(0,500)");
		
		Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("scroll(0,200)");
		Address.sendKeys("123 street");
		country.click();
		countryChoice.click();
		Thread.sleep(1000);
		zip.sendKeys("36310");

		city.click();
		cityChoice.click();

		Thread.sleep(3000);
		OfficeEditConfirmation.click();
		Thread.sleep(15000);
	
	}
	public void SubmitOffice() throws InterruptedException {
		Thread.sleep(3000);
		((JavascriptExecutor) driver).executeScript("scroll(0,900)");
		Thread.sleep(3000);

		submit.click();
		Thread.sleep(3000);

		TimeUnit.SECONDS.sleep(120);


	}
	public boolean ValidateNoOfficeTypeOnProfilePage() throws InterruptedException {
	
		((JavascriptExecutor) driver).executeScript("scroll(0,500)");
		try {

			return NoOfficeType.isDisplayed();
		
		} catch (Exception ex) {
			System.out.println("working as desired");
		}
		return false;

	}
	public void EditOfficeName () throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.id("actionsButton")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("menuitem0")).click();
		Thread.sleep(2000);
		ofcName.sendKeys("edited");
		Thread.sleep(1000);
		((JavascriptExecutor) driver).executeScript("scroll(0,900)");
		OfficeEditConfirmation.click();
		Thread.sleep(15000);
	
		
	}
public void EditStart () throws InterruptedException {
	Thread.sleep(3000);
	driver.findElement(By.id("actionsButton")).click();
	Thread.sleep(1000);
	driver.findElement(By.id("menuitem0")).click();
	Thread.sleep(2000);
		startdate1.clear();
		startdate2.clear();
		startdate1.clear();
		Thread.sleep(1000);
	
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy ");

		// get current date time with Date()
		Date date = new Date();

		Calendar c = Calendar.getInstance();
		c.setTime(date);
		// convert calendar to date
		c.add(Calendar.DATE, -1);
				Date currentDateminus= c.getTime();
			

				startdate1.sendKeys(dateFormat.format(currentDateminus));
				Thread.sleep(3000);
				((JavascriptExecutor) driver).executeScript("scroll(0,900)");
				OfficeEditConfirmation.click();
				Thread.sleep(15000);
		
	}
public void EditOfficeShort () throws InterruptedException {
	Thread.sleep(3000);
	driver.findElement(By.id("actionsButton")).click();
	Thread.sleep(1000);
	driver.findElement(By.id("menuitem0")).click();
	Thread.sleep(2000);;
	((JavascriptExecutor) driver).executeScript("scroll(0,400)");

	driver.findElement(By.id("ofcShortName-input")).sendKeys("testemail");
	Thread.sleep(1000);
	((JavascriptExecutor) driver).executeScript("scroll(0,900)");
	OfficeEditConfirmation.click();
	Thread.sleep(15000);

	
}
public void EditOfficeRegion () throws InterruptedException {
	Thread.sleep(3000);
	driver.findElement(By.id("actionsButton")).click();
	Thread.sleep(1000);
	driver.findElement(By.id("menuitem0")).click();
	Thread.sleep(2000);
	((JavascriptExecutor) driver).executeScript("scroll(0,400)");

	driver.findElement(By.id("ofcRegion-input")).sendKeys("00");
	Thread.sleep(1000);
	((JavascriptExecutor) driver).executeScript("scroll(0,900)");
	OfficeEditConfirmation.click();
	Thread.sleep(15000);

	
}
public void EditOfficeAddress () throws InterruptedException {
	Thread.sleep(3000);
	driver.findElement(By.id("actionsButton")).click();
	Thread.sleep(1000);
	driver.findElement(By.id("menuitem0")).click();
	Thread.sleep(2000);
	((JavascriptExecutor) driver).executeScript("scroll(0,700)");
	Address.clear();
	Address.sendKeys("test street");
	Thread.sleep(1000);
	((JavascriptExecutor) driver).executeScript("scroll(0,200)");
	OfficeEditConfirmation.click();
	Thread.sleep(15000);

	
}
public void EditOfficeAddType () throws InterruptedException {
	Thread.sleep(3000);
	driver.findElement(By.id("actionsButton")).click();
	Thread.sleep(1000);
	driver.findElement(By.id("menuitem0")).click();
	Thread.sleep(2000);
	((JavascriptExecutor) driver).executeScript("scroll(0,500)");
	ContractAwards.click();

	DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy ");

	// get current date time with Date()
	Date date = new Date();



	Calendar c = Calendar.getInstance();
	c.setTime(date);
	

	// convert calendar to date
	Date currentDatePlusOne = c.getTime();
	c.add(Calendar.DATE, +1);
	Date currentDatePlustwo = c.getTime();
	Thread.sleep(1000);
	ContractAwardsStateDate.sendKeys(dateFormat.format(currentDatePlusOne));
	ContractAwardsEndDate0.sendKeys(dateFormat.format(currentDatePlustwo));
	Thread.sleep(2000);
	Thread.sleep(1000);
	((JavascriptExecutor) driver).executeScript("scroll(0,2000)");
	OfficeEditConfirmation.click();
	Thread.sleep(15000);

	
}
public void EditOfficeAddTypeNeg () throws InterruptedException {
	Thread.sleep(3000);
	driver.findElement(By.id("actionsButton")).click();
	Thread.sleep(1000);
	driver.findElement(By.id("menuitem0")).click();
	Thread.sleep(2000);
	((JavascriptExecutor) driver).executeScript("scroll(0,500)");
	FinancialAssistanceFunding.click();

	DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy ");

	// get current date time with Date()
	Date date = new Date();



	Calendar c = Calendar.getInstance();
	c.setTime(date);
	

	// convert calendar to date
	Date currentDatePlusOne = c.getTime();
	c.add(Calendar.DATE, +1);
	Date currentDatePlustwo = c.getTime();
	Thread.sleep(1000);
	FinancialAssistanceFundingStartDate.sendKeys(dateFormat.format(currentDatePlusOne));
	FinancialAssistanceFundingEndDates0.sendKeys(dateFormat.format(currentDatePlustwo));
	Thread.sleep(2000);
	Thread.sleep(1000);
	((JavascriptExecutor) driver).executeScript("scroll(0,2000)");
	OfficeEditConfirmation.click();
	Thread.sleep(15000);

	
}
	
}