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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import util.TestBase;

public class EditOffice extends TestBase {

	static String randomOfficeTitle;
	static String randomAac;
	@FindBy(id="editCodesButton")
	WebElement ProfileEditCode;
	@FindBy(xpath = "//*[@id=\"main-container\"]/ng-component/div/aside/div/ul/li[2]/a")
	WebElement subtierlink;
	@FindBy(xpath = "//*[@id=\"hierarchy-content\"]/div/div[4]/div[1]/a")
	WebElement officelink;
	@FindBy(xpath = "//*[@id=\"primary-content\"]/ng-component/div/div[1]/div[1]/button")
	WebElement createlink;
	@FindBy(id="tas2-input")
	WebElement Tas;
	@FindBy(xpath = "//a[text()='Federal Hierarchy']")
	WebElement FHBreadcrumbLink;
	@FindBy(xpath = "//input[@aria-label=\"search federal hierarchy\"]")
	WebElement FHSearch;
	@FindBy(xpath = "//a[@class=\"federal-hierarchy-org-item-title\"]")
	WebElement FHSearchDepAgency;
	@FindBy(xpath = "//a[@href=\"/fh/500154753\"]")
	WebElement FHSearchDepAgency2;
	@FindBy(xpath = "//button[text()=' Create Office ']")
	WebElement CreateOffice;
	@FindBy(id = "ofcAAC-input")
	WebElement Aac;
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
	@FindBy(id="result_0")
	WebElement cityChoice;
	@FindBy(xpath = "//button[text()= ' Edit ']")
	WebElement edit;
	@FindBy(id="menuitem0")
	WebElement edit2;
	@FindBy(xpath = "//span[text()=' The start date is a required field. ']")
	WebElement StartDateError;
	@FindBy(xpath = "//div[text()=' Showing  1-1  of  1  results ']")
	WebElement ValidationForsearch;
	@FindBy(xpath = "//span[text()=' Office name is required ']")
	WebElement BlankError;
	@FindBy(xpath = "//h1[text()=' Edit Office Confirmation ']")
	WebElement EditOfficeConfirm;
	@FindBy(xpath = "//span[text()=' Date is required ']")
	WebElement DateBlankError;
	@FindBy(xpath = "//span[text()=' The end date of an office type cannot be after the end date of a parent department or a sub-tier ']")
	WebElement EndDateError;
	@FindBy(xpath = "//span[text()=' The end date of an office type cannot be after the end date of a parent sub-tier ']")
	WebElement EndDateErrornew;
	@FindBy(xpath = "//span[text()=' The end date of an office type cannot be after the end date of a parent department ']")
	WebElement TypeEndDateError3;
	@FindBy(xpath = "//span[text()=' The start date is a required field. ']")
	WebElement DateBlankError2;
	@FindBy(xpath = "//span[text()=' The start date cannot be moved forward from the existing start date. It can only be moved back. ']")
	WebElement StartDateError1;
	@FindBy(xpath = "//span[text()=' The start date cannot be before the start date of the parent department and the parent sub-tier. ']")
	WebElement StartDateError2;
	@FindBy(xpath = "//span[text()=' The TAS-2 Code for the parent department has changed. Please  work with your Federal Hierarchy administrator to update the AAC for this office. ']")
	WebElement TASerror;
	@FindBy(xpath = "//span[text()=' This department has offices(s) with AAC codes that do not start with the provided TAS-2 Code. ']")
	WebElement TASerror2;
	@FindBy(xpath = "//span[text()=' The start date of an office cannot be before the start date of a parent sub-tier. ']")
	WebElement StartDateError3;
	@FindBy(xpath = "//span[text()=' The start date cannot be moved forward from the existing start date. It can only be moved back. ']")
	WebElement StartDateError4;
	@FindBy(xpath = "//span[text()=' The end date can only be the current date or in the future. ']")
	WebElement EndDateError1;
	@FindBy(xpath = "//span[text()=' The end date of an office cannot be after the end date of a parent department. ']")
	WebElement EndDateError1New;
	@FindBy(xpath = "//span[text()=' The end date of an office cannot be after the end date of a parent department or a sub-tier ']")
	WebElement EndDateError2New;
	@FindBy(xpath = "//span[text()=' The end date of an office cannot be after the end date of a parent sub-tier. ']")
	WebElement EndDateError3New;
	@FindBy(xpath = "//span[text()=' The end date cannot be earlier than or equal to the start date. ']")
	WebElement EndDateError2;
	@FindBy(xpath = "//span[text()=' The end date of an office cannot be after the end date of a parent department or a sub-tier ']")
	WebElement EndDateError3;
	@FindBy(xpath = "//span[text()=' The end date of an office cannot be after the end date of a parent department. ']")
	WebElement EndDateError4;
	@FindBy(xpath = "//span[text()=' The end date can only be moved forward once an end date is provided. ']")
	WebElement EndDateError5;
	@FindBy(xpath = "//span[text()=' The end date can only be moved forward once an end date is provided. ']")
	WebElement EndDateError6;
	@FindBy(xpath = "//button[text()=' Submit ']")
	WebElement Submit;
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
	@FindBy(xpath = "//span[text()=' The start date cannot be moved forward once an office type start date is provided. ']")
	WebElement TypeStartDateError16;
	@FindBy(xpath = "//span[text()=' The end date of an office type cannot be after the end date of an office. ']")
	WebElement TypeEndDateError6;
	@FindBy(xpath = "//span[text()=' The end date can only be moved forward once an end date is provided. ']")
	WebElement TypeEndDateError7;
	@FindBy(xpath = "//span[text()=' All date fields are required ']")
	WebElement EmptyDate;
	@FindBy(id="actionsButton")
	WebElement ActionsOffice;
	@FindBy(xpath = "//a[@href=\"/fh/300000001\"]")
	WebElement ResultLegislative;
	@FindBy(xpath = "//a[@href=\"/fh/500155318\"]")
	WebElement Office;
	@FindBy(xpath = "/html/body/app/main/ng-component/div[1]/div/div[4]/div/div[2]/div/div[2]/div[1]/a")
	WebElement POLICEPROCUREMENT;
	@FindBy(xpath = "//*[@id=\"main-container\"]/ng-component/div[1]/div/div[4]/div/div[2]/div/div[2]/div[1]/a")
	WebElement ActionDep;
	@FindBy(xpath = "//*[@id=\"main-container\"]/ng-component/div[1]/div/div[4]/div/div[2]/div/div[2]/div[1]/a")
	WebElement USDep;
	@FindBy(xpath = "//*[@id=\"main-container\"]/ng-component/div[1]/div/div[4]/div/div[2]/div/div[2]/div[1]/a")
	WebElement DEPT26Dep;
	@FindBy(id="ofcRegion-input")
	WebElement RegionCode;

	public EditOffice() {
		PageFactory.initElements(driver, this);
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

	
			((JavascriptExecutor) driver).executeScript("scroll(0,700)");
			Address.sendKeys("123 street");
			country.click();
			countryChoice.click();
			Thread.sleep(1000);
			zip.sendKeys("36310");

			city.click();
			cityChoice.click();

			Thread.sleep(3000);
			OfficeEditConfirmation.click();
			Thread.sleep(17000);
			

		}
		public void intoOffice() throws InterruptedException {
			Thread.sleep(3000);
			FHSearch.sendKeys("OFFICEFORDATA2");
			FHSearch.sendKeys(Keys.ENTER);
		}
		public void intoOffice2() throws InterruptedException {
			FHSearchDepAgency.click();
			Thread.sleep(1000);
			ActionsOffice.click();
			edit2.click();
			Thread.sleep(3000);
		}
		public void testingEditName() throws InterruptedException {
			((JavascriptExecutor) driver).executeScript("scroll(0,500)");
			Thread.sleep(3000);
			ofcName.clear();
			ofcName.sendKeys("    ");
			((JavascriptExecutor) driver).executeScript("scroll(0,1100)");
			Thread.sleep(2000);
			OfficeEditConfirmation.click();
			Thread.sleep(5000);
	
		}
		public void testingEditName2() throws InterruptedException {
		//	((JavascriptExecutor) driver).executeScript("scroll(0,300)");
			Thread.sleep(3000);
			ofcName.sendKeys("Office for data");
			((JavascriptExecutor) driver).executeScript("scroll(0,1100)");

			OfficeEditConfirmation.click();
			Thread.sleep(4000);
	}
		public void testingEditName3() throws InterruptedException {
			((JavascriptExecutor) driver).executeScript("scroll(0,7000)");
			Thread.sleep(5000);
			edit.click();
			Thread.sleep(5000);
			((JavascriptExecutor) driver).executeScript("scroll(0,500)");
			Thread.sleep(3000);
			ofcName.clear();
			ofcName.sendKeys("Office for data2");
			((JavascriptExecutor) driver).executeScript("scroll(0,1100)");

			OfficeEditConfirmation.click();
			Thread.sleep(4000);
	}
		public void TestingStartDate() throws InterruptedException {
			Thread.sleep(2000);
			((JavascriptExecutor) driver).executeScript("scroll(0,7000)");
			edit.click();
			Thread.sleep(3000);
			((JavascriptExecutor) driver).executeScript("scroll(0,5000)");
			startdate1.clear();
			startdate2.clear();
			startdate3.clear();
			Thread.sleep(4000);
			((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
			OfficeEditConfirmation.click();

			Thread.sleep(3000);
			Thread.sleep(4000);
			((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
			OfficeEditConfirmation.click();

			Thread.sleep(3000);

		}

		public void TestingStartDate2() throws InterruptedException {
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
			startdate1.sendKeys(dateFormat.format(currentDatePlusOne));
		
			Thread.sleep(4000);

			((JavascriptExecutor) driver).executeScript("scroll(0,9000)");

			OfficeEditConfirmation.click();
		
			Thread.sleep(3000);
		}

		public void TestingStartDate3() throws InterruptedException {
			Thread.sleep(3000);
			startdate1.clear();
			startdate2.clear();
			startdate3.clear();

			DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy ");

			Date date = new Date();

			// Now format the date
			String StartDate = dateFormat.format(date);
			Calendar c = Calendar.getInstance();
			c.setTime(date);

			// manipulate date

			c.add(Calendar.DATE, -1);

			// convert calendar to date
			Date currentDateMinusOne = c.getTime();
			((JavascriptExecutor) driver).executeScript("scroll(0,500)");
			// DONT THINK I NEED THIS
			// ((JavascriptExecutor) driver).executeScript("scroll(0,500)");
			// check
			startdate1.sendKeys(dateFormat.format(currentDateMinusOne));
		
			
			Thread.sleep(3000);
			
			((JavascriptExecutor) driver).executeScript("scroll(0,9000)");
			Thread.sleep(3000);
			OfficeEditConfirmation.click();

			Thread.sleep(3000);
		
		}
		public void TestingStartDate00() throws InterruptedException {
			startdate1.clear();
			startdate2.clear();
			startdate3.clear();
			Thread.sleep(1000);
			startdate1.sendKeys("02242020");
			Thread.sleep(3000);
			((JavascriptExecutor) driver).executeScript("scroll(0,9000)");
			OfficeEditConfirmation.click();
			Thread.sleep(3000);
		}
		

		public void TestingStartDate4() throws InterruptedException {
			((JavascriptExecutor) driver).executeScript("scroll(0,5000)");
			edit.click();
			Thread.sleep(4000);
			((JavascriptExecutor) driver).executeScript("scroll(0,5000)");
			startdate1.clear();
			startdate2.clear();
			startdate3.clear();
			Thread.sleep(1000);
			startdate1.sendKeys("01012020");
			Thread.sleep(3000);
			((JavascriptExecutor) driver).executeScript("scroll(0,9000)");
			OfficeEditConfirmation.click();
			Thread.sleep(3000);
		}

		public void TestingStartDate5() throws InterruptedException {
			Thread.sleep(4000);
			//((JavascriptExecutor) driver).executeScript("scroll(0,5000)");
			startdate1.clear();
			startdate2.clear();
			startdate3.clear();
			Thread.sleep(1000);
			startdate1.sendKeys("01212020");
			Thread.sleep(3000);
			((JavascriptExecutor) driver).executeScript("scroll(0,9000)");
			OfficeEditConfirmation.click();
			Thread.sleep(3000);

		}
		public void TestingStartDate6() throws InterruptedException {
		startdate1.clear();
		startdate2.clear();
		startdate3.clear();
		Thread.sleep(1000);
		startdate1.sendKeys("01132020");
		Thread.sleep(3000);
		((JavascriptExecutor) driver).executeScript("scroll(0,9000)");
		OfficeEditConfirmation.click();
		Thread.sleep(3000);
	
}
		public void TestingStartDate7() throws InterruptedException {
			startdate1.clear();
			startdate2.clear();
			startdate3.clear();
			Thread.sleep(1000);
			startdate1.sendKeys("01222020");
			Thread.sleep(3000);
			((JavascriptExecutor) driver).executeScript("scroll(0,9000)");
			OfficeEditConfirmation.click();
			Thread.sleep(3000);
		}
		public void TestingStartDate8() throws InterruptedException {
			((JavascriptExecutor) driver).executeScript("scroll(0,5000)");
			edit.click();
			Thread.sleep(4000);
			((JavascriptExecutor) driver).executeScript("scroll(0,5000)");
			DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy ");

			Date date = new Date();

			// Now format the date
			String StartDate = dateFormat.format(date);
			Calendar c = Calendar.getInstance();
			c.setTime(date);

			// manipulate date

			c.add(Calendar.DATE, +2);

			// convert calendar to date
			Date currentDateplus2 = c.getTime();
			((JavascriptExecutor) driver).executeScript("scroll(0,500)");
			// DONT THINK I NEED THIS
			// ((JavascriptExecutor) driver).executeScript("scroll(0,500)");
			// check
			startdate1.clear();
			startdate2.clear();
			startdate3.clear();
			startdate1.sendKeys(dateFormat.format(currentDateplus2));
		
			Thread.sleep(4000);

			((JavascriptExecutor) driver).executeScript("scroll(0,9000)");

			OfficeEditConfirmation.click();
		
			Thread.sleep(3000);
		}
			public void TestingStartDate9() throws InterruptedException {
				Thread.sleep(4000);
				((JavascriptExecutor) driver).executeScript("scroll(0,5000)");
				DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy ");

				Date date = new Date();

				// Now format the date
				String StartDate = dateFormat.format(date);
				Calendar c = Calendar.getInstance();
				c.setTime(date);

				// manipulate date

				c.add(Calendar.DATE, -2);

				// convert calendar to date
				Date currentDateMinus2 = c.getTime();
				((JavascriptExecutor) driver).executeScript("scroll(0,500)");
				// DONT THINK I NEED THIS
				// ((JavascriptExecutor) driver).executeScript("scroll(0,500)");
				// check
				startdate1.clear();
				startdate2.clear();
				startdate3.clear();
				startdate1.sendKeys("02242020");
			
				Thread.sleep(4000);

				((JavascriptExecutor) driver).executeScript("scroll(0,9000)");

				OfficeEditConfirmation.click();
			
				Thread.sleep(3000);
			}
			public void TestingStartDate10() throws InterruptedException {
				Thread.sleep(4000);
				((JavascriptExecutor) driver).executeScript("scroll(0,5000)");
				edit.click();
				Thread.sleep(4000);
				//((JavascriptExecutor) driver).executeScript("scroll(0,5000)");
				((JavascriptExecutor) driver).executeScript("scroll(0,5000)");
				DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy ");

				Date date = new Date();

				// Now format the date
				String StartDate = dateFormat.format(date);
				Calendar c = Calendar.getInstance();
				c.setTime(date);

				// manipulate date

				c.add(Calendar.DATE, -2);

				// convert calendar to date
				Date currentDateMinus2 = c.getTime();
				//((JavascriptExecutor) driver).executeScript("scroll(0,500)");
				// DONT THINK I NEED THIS
				// ((JavascriptExecutor) driver).executeScript("scroll(0,500)");
				// check
				
				startdate1.clear();
				startdate2.clear();
				startdate3.clear();
				startdate1.sendKeys("02252020");
			
				Thread.sleep(4000);

				((JavascriptExecutor) driver).executeScript("scroll(0,9000)");

				OfficeEditConfirmation.click();
			
				Thread.sleep(3000);
			}
			
			public void TestingEndDate() throws InterruptedException {
				((JavascriptExecutor) driver).executeScript("scroll(0,5000)");
				edit.click();
				Thread.sleep(4000);
				((JavascriptExecutor) driver).executeScript("scroll(0,7000)");
				DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy ");

				Date date = new Date();

				// Now format the date
				String StartDate = dateFormat.format(date);
				Calendar c = Calendar.getInstance();
				c.setTime(date);

				// manipulate date

				c.add(Calendar.DATE, -1);

				// convert calendar to date
				Date currentDateMinusOne = c.getTime();
				((JavascriptExecutor) driver).executeScript("scroll(0,500)");
				// DONT THINK I NEED THIS
				// ((JavascriptExecutor) driver).executeScript("scroll(0,500)");
				// check
				enddate1.sendKeys(dateFormat.format(currentDateMinusOne));
			
				Thread.sleep(4000);

				((JavascriptExecutor) driver).executeScript("scroll(0,9000)");

				OfficeEditConfirmation.click();
			
				Thread.sleep(3000);
			}
			public void TestingEndDate2() throws InterruptedException {
				
			
				((JavascriptExecutor) driver).executeScript("scroll(0,500)");
			
				enddate1.clear();
				enddate2.clear();
				enddate3.clear();
				enddate1.sendKeys("02242020");
			
				Thread.sleep(4000);

				((JavascriptExecutor) driver).executeScript("scroll(0,9000)");

				OfficeEditConfirmation.click();
			
				Thread.sleep(3000);
	}
	public void TestingEndDate3() throws InterruptedException {
				
				DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy ");

				Date date = new Date();

				// Now format the date
				String StartDate = dateFormat.format(date);
				Calendar c = Calendar.getInstance();
				c.setTime(date);

				// manipulate date

				c.add(Calendar.DATE, +2);

				// convert calendar to date
				Date currentDateMinus2 = c.getTime();
				((JavascriptExecutor) driver).executeScript("scroll(0,500)");
				// DONT THINK I NEED THIS
				// ((JavascriptExecutor) driver).executeScript("scroll(0,500)");
				// check
				startdate1.clear();
				startdate2.clear();
				startdate3.clear();
				Thread.sleep(1000);
				startdate1.sendKeys(dateFormat.format(currentDateMinus2));
			

				((JavascriptExecutor) driver).executeScript("scroll(0,9000)");

				OfficeEditConfirmation.click();
			
				Thread.sleep(3000);
	}
	public void TestingEndDate4() throws InterruptedException {
		
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy ");

		Date date = new Date();

		// Now format the date
		String StartDate = dateFormat.format(date);
		Calendar c = Calendar.getInstance();
		c.setTime(date);

		((JavascriptExecutor) driver).executeScript("scroll(0,500)");
		// DONT THINK I NEED THIS
		// ((JavascriptExecutor) driver).executeScript("scroll(0,500)");
		// check
		startdate1.clear();
		startdate2.clear();
		startdate3.clear();
		Thread.sleep(1000);
		startdate1.sendKeys("02242020");
		Thread.sleep(1000);
		enddate1.clear();
		enddate2.clear();
		enddate3.clear();
		enddate1.sendKeys("01222023");
		((JavascriptExecutor) driver).executeScript("scroll(0,9000)");

		OfficeEditConfirmation.click();
	
		Thread.sleep(3000);
}
public void TestingEndDate5() throws InterruptedException {
		

		Thread.sleep(1000);
		enddate1.clear();
		enddate2.clear();
		enddate3.clear();
		enddate1.sendKeys("01222022");
		((JavascriptExecutor) driver).executeScript("scroll(0,9000)");

		OfficeEditConfirmation.click();
	
		Thread.sleep(3000);
}
public void TestingEndDate6() throws InterruptedException {
	

	Thread.sleep(1000);
	enddate1.clear();
	enddate2.clear();
	enddate3.clear();
	enddate1.sendKeys("01132022");
	((JavascriptExecutor) driver).executeScript("scroll(0,9000)");

	OfficeEditConfirmation.click();

	Thread.sleep(3000);
}
public void TestingEndDate6comp() throws InterruptedException {
	

	Thread.sleep(1000);
	enddate1.clear();
	enddate2.clear();
	enddate3.clear();
	enddate1.sendKeys("01132021");
	((JavascriptExecutor) driver).executeScript("scroll(0,9000)");

	OfficeEditConfirmation.click();

	Thread.sleep(3000);
}
public void TestingEndDate7() throws InterruptedException {
	((JavascriptExecutor) driver).executeScript("scroll(0,5000)");
	edit.click();
	Thread.sleep(4000);
	((JavascriptExecutor) driver).executeScript("scroll(0,7000)");

	Thread.sleep(1000);
	enddate1.clear();
	enddate2.clear();
	enddate3.clear();
	enddate1.sendKeys("02252020");
	((JavascriptExecutor) driver).executeScript("scroll(0,9000)");

	OfficeEditConfirmation.click();

	Thread.sleep(3000);
}
public void TestingEndNew00() throws InterruptedException {

	Thread.sleep(1000);
	enddate1.clear();
	enddate2.clear();
	enddate3.clear();
	enddate1.sendKeys("01142022");
	((JavascriptExecutor) driver).executeScript("scroll(0,9000)");

	OfficeEditConfirmation.click();

	Thread.sleep(3000);
}
public void TestingEndDateNew1() throws InterruptedException {
	FHBreadcrumbLink.click();
	
	Thread.sleep(3000);
	FHSearch.sendKeys("HIERARCHY OFFICE");
	FHSearch.sendKeys(Keys.ENTER);
	Thread.sleep(1000);
	Office.click();
	Thread.sleep(1000);
	ActionsOffice.click();
	Thread.sleep(1000);
	edit2.click();
	Thread.sleep(3000);

	enddate1.clear();
	enddate2.clear();
	enddate3.clear();
	enddate1.sendKeys("06072024");
	((JavascriptExecutor) driver).executeScript("scroll(0,9000)");

	OfficeEditConfirmation.click();

	Thread.sleep(3000);
}
public void TestingEndDateNew2() throws InterruptedException {
	
	Thread.sleep(1000);
	enddate1.clear();
	enddate2.clear();
	enddate3.clear();
	enddate1.sendKeys("06082024");
	((JavascriptExecutor) driver).executeScript("scroll(0,9000)");

	OfficeEditConfirmation.click();

	Thread.sleep(3000);
}
public void TestingEndDateNew3() throws InterruptedException {
	
	Thread.sleep(1000);
	enddate1.clear();
	enddate2.clear();
	enddate3.clear();
	enddate1.sendKeys("03042023");
	((JavascriptExecutor) driver).executeScript("scroll(0,9000)");

	OfficeEditConfirmation.click();

	Thread.sleep(3000);
}
public void TestingEndDate8() throws InterruptedException {
	DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy ");

	Date date = new Date();

	// Now format the date
	String StartDate = dateFormat.format(date);
	Thread.sleep(1000);
	enddate1.clear();
	enddate2.clear();
	enddate3.clear();
	enddate1.sendKeys(StartDate);
	((JavascriptExecutor) driver).executeScript("scroll(0,9000)");

	OfficeEditConfirmation.click();

	Thread.sleep(3000);
}
public void TestingEndDate9() throws InterruptedException {
	Thread.sleep(1000);
	enddate1.clear();
	enddate2.clear();
	enddate3.clear();
	enddate1.sendKeys("03022021");
	((JavascriptExecutor) driver).executeScript("scroll(0,9000)");

	OfficeEditConfirmation.click();

	Thread.sleep(3000);
}
public void TestingEndDate9comp() throws InterruptedException {
	Thread.sleep(1000);
	enddate1.clear();
	enddate2.clear();
	enddate3.clear();
	enddate1.sendKeys("01212021");
	((JavascriptExecutor) driver).executeScript("scroll(0,9000)");

	OfficeEditConfirmation.click();

	Thread.sleep(3000);
}
public boolean StartDateValidation() throws InterruptedException {
	Thread.sleep(11000);

	((JavascriptExecutor) driver).executeScript("scroll(0,900)");
	Thread.sleep(2000);
	try {

		return StartDateError1.isDisplayed();
	} catch (Exception ex) {
		System.out.println("working as desired");
	}
	return false;
}
public boolean StartDateValidation2() throws InterruptedException {
	Thread.sleep(11000);

	((JavascriptExecutor) driver).executeScript("scroll(0,900)");
	Thread.sleep(2000);
	try {

		return StartDateError2.isDisplayed();
	} catch (Exception ex) {
		System.out.println("working as desired");
	}
	return false;
}
public boolean StartDateValidation3() throws InterruptedException {
	Thread.sleep(11000);

	((JavascriptExecutor) driver).executeScript("scroll(0,900)");
	Thread.sleep(2000);
	try {

		return StartDateError3.isDisplayed();
	} catch (Exception ex) {
		System.out.println("working as desired");
	}
	return false;
}
public boolean StartDateValidation4() throws InterruptedException {
	Thread.sleep(11000);

	((JavascriptExecutor) driver).executeScript("scroll(0,900)");
	Thread.sleep(2000);
	try {

		return StartDateError4.isDisplayed();
	} catch (Exception ex) {
		System.out.println("working as desired");
	}
	return false;
}
public boolean DateValidation() throws InterruptedException {
	Thread.sleep(11000);

	((JavascriptExecutor) driver).executeScript("scroll(0,900)");
	Thread.sleep(2000);
	try {

		return DateBlankError.isDisplayed();
	} catch (Exception ex) {
		System.out.println("working as desired");
	}
	return false;
}
public boolean DateValidation2() throws InterruptedException {
	Thread.sleep(11000);

	((JavascriptExecutor) driver).executeScript("scroll(0,900)");
	Thread.sleep(2000);
	try {

		return DateBlankError2.isDisplayed();
	} catch (Exception ex) {
		System.out.println("working as desired");
	}
	return false;
}
public boolean NameValidation() throws InterruptedException {
	Thread.sleep(2000);

	((JavascriptExecutor) driver).executeScript("scroll(0,900)");
	Thread.sleep(2000);
	try {

		return BlankError.isDisplayed();
	} catch (Exception ex) {
		System.out.println("working as desired");
	}
	return false;
}
public boolean Confirm() throws InterruptedException {
	Thread.sleep(3000);

	((JavascriptExecutor) driver).executeScript("scroll(0,1200)");
	Thread.sleep(2000);
	try {

		return EditOfficeConfirm.isDisplayed();
	} catch (Exception ex) {
		System.out.println("working as desired");
	}
	return false;
}
public boolean NewEndDateError() throws InterruptedException {
	Thread.sleep(3000);

	((JavascriptExecutor) driver).executeScript("scroll(0,1200)");
	Thread.sleep(2000);
	try {

		return EndDateError.isDisplayed();
	} catch (Exception ex) {
		System.out.println("working as desired");
	}
	return false;
}
public boolean NewEndDateError3() throws InterruptedException {
	Thread.sleep(3000);

	((JavascriptExecutor) driver).executeScript("scroll(0,1200)");
	Thread.sleep(2000);
	try {

		return TypeEndDateError3.isDisplayed();
	} catch (Exception ex) {
		System.out.println("working as desired");
	}
	return false;
}
public boolean NewEndDateError2() throws InterruptedException {
	Thread.sleep(3000);

	((JavascriptExecutor) driver).executeScript("scroll(0,1200)");
	Thread.sleep(2000);
	try {

		return EndDateErrornew.isDisplayed();
	} catch (Exception ex) {
		System.out.println("working as desired");
	}
	return false;
}


public boolean Confirm2() throws InterruptedException {
	Thread.sleep(3000);

	((JavascriptExecutor) driver).executeScript("scroll(0,-200)");
	Thread.sleep(2000);
	try {

		return CreateConfirmationValidation.isDisplayed();
	} catch (Exception ex) {
		System.out.println("working as desired");
	}
	return false;
}
public boolean OfficeSearch() throws InterruptedException {
	Thread.sleep(3000);

	((JavascriptExecutor) driver).executeScript("scroll(0,900)");
	Thread.sleep(2000);
	try {

		return ValidationForsearch.isDisplayed();
	} catch (Exception ex) {
		System.out.println("working as desired");
	}
	return false;
}
public boolean EndDate() throws InterruptedException {
	Thread.sleep(3000);

	((JavascriptExecutor) driver).executeScript("scroll(0,900)");
	Thread.sleep(2000);
	try {

		return EndDateError1.isDisplayed();
	} catch (Exception ex) {
		System.out.println("working as desired");
	}
	return false;
}
public boolean EndDateNewError() throws InterruptedException {
	Thread.sleep(3000);

	((JavascriptExecutor) driver).executeScript("scroll(0,900)");
	Thread.sleep(2000);
	try {

		return EndDateError1New.isDisplayed();
	} catch (Exception ex) {
		System.out.println("working as desired");
	}
	return false;
}
public boolean EndDateNewError2() throws InterruptedException {
	Thread.sleep(3000);

	((JavascriptExecutor) driver).executeScript("scroll(0,900)");
	Thread.sleep(2000);
	try {

		return EndDateError2New.isDisplayed();
	} catch (Exception ex) {
		System.out.println("working as desired");
	}
	return false;
}
public boolean EndDateNewError3() throws InterruptedException {
	Thread.sleep(3000);

	((JavascriptExecutor) driver).executeScript("scroll(0,900)");
	Thread.sleep(2000);
	try {

		return EndDateError3New.isDisplayed();
	} catch (Exception ex) {
		System.out.println("working as desired");
	}
	return false;
}
public boolean EndDate2() throws InterruptedException {
	Thread.sleep(4000);

	((JavascriptExecutor) driver).executeScript("scroll(0,900)");
	Thread.sleep(2000);
	try {

		return EndDateError2.isDisplayed();
	} catch (Exception ex) {
		System.out.println("working as desired");
	}
	return false;
}
public boolean EndDate3() throws InterruptedException {
	Thread.sleep(4000);

	((JavascriptExecutor) driver).executeScript("scroll(0,900)");
	Thread.sleep(2000);
	try {

		return EndDateError3.isDisplayed();
		
	} catch (Exception ex) {
		System.out.println("working as desired");
	}
	return false;
}
public boolean EndDate4() throws InterruptedException {
	Thread.sleep(17000);

	((JavascriptExecutor) driver).executeScript("scroll(0,1200)");
	Thread.sleep(2000);
	try {

		return EndDateError4.isDisplayed()||EndDateError4.isDisplayed();
		
	} catch (Exception ex) {
		System.out.println("working as desired");
	}
	return false;
}
public boolean EndDate5() throws InterruptedException {
	Thread.sleep(7000);

	((JavascriptExecutor) driver).executeScript("scroll(0,1500)");
	Thread.sleep(2000);
	((JavascriptExecutor) driver).executeScript("scroll(0,500)");
	try {

		return EndDateError5.isDisplayed();
	} catch (Exception ex) {
		System.out.println("working as desired");
	}
	return false;
}
public boolean EndDate6() throws InterruptedException {
	Thread.sleep(7000);

	((JavascriptExecutor) driver).executeScript("scroll(0,1500)");
	Thread.sleep(2000);
	((JavascriptExecutor) driver).executeScript("scroll(0,500)");
	try {

		return EndDateError5.isDisplayed();
	} catch (Exception ex) {
		System.out.println("working as desired");
	}
	return false;
}
public void SubmitingOffice() throws InterruptedException {
	Submit.click();
	Thread.sleep(8000);
	edit2.click();
	Thread.sleep(4000);

	
	
}
public void intoOffice3() throws InterruptedException {
	Thread.sleep(3000);
	FHSearch.sendKeys("OFFICE FOR DATA 3");
	FHSearch.sendKeys(Keys.ENTER);
}
public void intoOffice4() throws InterruptedException {
	FHSearchDepAgency2.click();
	Thread.sleep(1000);
	ActionsOffice.click();
	edit2.click();
	Thread.sleep(3000);
}
public void EditNameContinued() throws InterruptedException {
	edit.click();
	Thread.sleep(3000);
	ofcName.clear();
	ofcName.sendKeys("Office for data3");
	((JavascriptExecutor) driver).executeScript("scroll(0,1100)");

	OfficeEditConfirmation.click();
	Thread.sleep(4000);
}
public void clearEndDate() throws InterruptedException {

	
	((JavascriptExecutor) driver).executeScript("scroll(0,5000)");
	edit.click();
	Thread.sleep(4000);
	((JavascriptExecutor) driver).executeScript("scroll(0,7000)");
	DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy ");

	Date date = new Date();

	// Now format the date
	String StartDate = dateFormat.format(date);
	Calendar c = Calendar.getInstance();
	c.setTime(date);

	// manipulate date

	c.add(Calendar.DATE, -1);

	// convert calendar to date
	Date currentDateMinusOne = c.getTime();
	((JavascriptExecutor) driver).executeScript("scroll(0,500)");
	// DONT THINK I NEED THIS
	// ((JavascriptExecutor) driver).executeScript("scroll(0,500)");
	// check
	enddate1.clear();
	enddate2.clear();
	enddate3.clear();
	enddate1.sendKeys(dateFormat.format(currentDateMinusOne));

	Thread.sleep(4000);

	((JavascriptExecutor) driver).executeScript("scroll(0,9000)");

	OfficeEditConfirmation.click();

	Thread.sleep(3000);
}
public void EditOfficeTypes34() throws InterruptedException {
	
	edit.click();
	Thread.sleep(4000);
	((JavascriptExecutor) driver).executeScript("scroll(0,5000)");

		
	FinancialAssistanceFundingStartDate.clear();
	FinancialAssistanceFundingStartDate2.clear();
	FinancialAssistanceFundingStartDate3.clear();
	FinancialAssistanceFundingEndDates0.clear();
	FinancialAssistanceFundingEndDate2.clear();
	FinancialAssistanceFundingEndDate3.clear();
		//

	FinancialAssistanceFundingStartDate.sendKeys("02212018");
		((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
		OfficeEditConfirmation.click();
		Thread.sleep(1000);
		((JavascriptExecutor) driver).executeScript("scroll(0,900)");
		Thread.sleep(4000);
		((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
		OfficeEditConfirmation.click();
		Thread.sleep(5000);
		((JavascriptExecutor) driver).executeScript("scroll(0,900)");
		// check
	}
public void EditOfficeTypes35() throws InterruptedException {
	
	Thread.sleep(4000);

		
	FinancialAssistanceFundingStartDate.clear();
	FinancialAssistanceFundingStartDate2.clear();
	FinancialAssistanceFundingStartDate3.clear();
	FinancialAssistanceFundingEndDates0.clear();
		Thread.sleep(2000);

		
		FinancialAssistanceFundingEndDate2.clear();
		Thread.sleep(2000);

		FinancialAssistanceFundingEndDate3.clear();
		Thread.sleep(2000);

		//

		FinancialAssistanceFundingStartDate.sendKeys("02262020");
		Thread.sleep(1000);
		((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
		Thread.sleep(1000);

		OfficeEditConfirmation.click();
		Thread.sleep(1000);
	((JavascriptExecutor) driver).executeScript("scroll(0,900)");
		Thread.sleep(1000);
		((JavascriptExecutor) driver).executeScript("scroll(0,2000)");
		Thread.sleep(1000);

		OfficeEditConfirmation.click();
		Thread.sleep(5000);
		((JavascriptExecutor) driver).executeScript("scroll(0,900)");

		// check
	}
public void EditOfficeTypes36() throws InterruptedException {
edit.click();
Thread.sleep(4000);
((JavascriptExecutor) driver).executeScript("scroll(0,5000)");

Thread.sleep(4000);

	
FinancialAssistanceFundingStartDate.clear();
FinancialAssistanceFundingStartDate2.clear();
FinancialAssistanceFundingStartDate3.clear();
	//

FinancialAssistanceFundingStartDate.sendKeys("02232020");
	((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
	OfficeEditConfirmation.click();
	Thread.sleep(11000);
	((JavascriptExecutor) driver).executeScript("scroll(0,900)");
	// check
}
public void EditOfficeTypes37() throws InterruptedException {

Thread.sleep(4000);

	
FinancialAssistanceFundingStartDate.clear();
FinancialAssistanceFundingStartDate2.clear();
FinancialAssistanceFundingStartDate3.clear();

	//

	((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
	OfficeEditConfirmation.click();
	Thread.sleep(5000);
	((JavascriptExecutor) driver).executeScript("scroll(0,900)");
	Thread.sleep(5000);
	((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
	OfficeEditConfirmation.click();
	Thread.sleep(5000);
	((JavascriptExecutor) driver).executeScript("scroll(0,900)");
	// check
}
public void EditOfficeTypes38() throws InterruptedException {

Thread.sleep(4000);


FinancialAssistanceFundingStartDate.sendKeys("02272020");
	((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
	OfficeEditConfirmation.click();
	Thread.sleep(11000);
	((JavascriptExecutor) driver).executeScript("scroll(0,900)");
	// check
}
public void EditOfficeTypes39() throws InterruptedException {
edit.click();
Thread.sleep(4000);
((JavascriptExecutor) driver).executeScript("scroll(0,5000)");

Thread.sleep(4000);
FinancialAssistanceFundingEndDates0.clear();
FinancialAssistanceFundingEndDate2.clear();
FinancialAssistanceFundingEndDate3.clear();
FinancialAssistanceFundingEndDates0.sendKeys("02262020");

((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
OfficeEditConfirmation.click();
Thread.sleep(11000);
((JavascriptExecutor) driver).executeScript("scroll(0,900)");
}
public void EditOfficeTypes40() throws InterruptedException {
Thread.sleep(4000);
FinancialAssistanceFundingEndDates0.clear();
FinancialAssistanceFundingEndDate2.clear();
FinancialAssistanceFundingEndDate3.clear();
FinancialAssistanceFundingEndDates0.sendKeys("02272020");

((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
OfficeEditConfirmation.click();
Thread.sleep(11000);
((JavascriptExecutor) driver).executeScript("scroll(0,900)");
}
public void EditOfficeTypes41() throws InterruptedException {
Thread.sleep(4000);
FinancialAssistanceFundingEndDates0.clear();
FinancialAssistanceFundingEndDate2.clear();
FinancialAssistanceFundingEndDate3.clear();
FinancialAssistanceFundingEndDates0.sendKeys("01142022");

((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
OfficeEditConfirmation.click();
Thread.sleep(11000);
((JavascriptExecutor) driver).executeScript("scroll(0,900)");
}
public void EditOfficeTypes42() throws InterruptedException {
Thread.sleep(4000);

FinancialAssistanceFundingStartDate.clear();
FinancialAssistanceFundingStartDate2.clear();
FinancialAssistanceFundingStartDate3.clear();
FinancialAssistanceFundingStartDate.sendKeys("02262020");
FinancialAssistanceFundingEndDates0.clear();
FinancialAssistanceFundingEndDate2.clear();
FinancialAssistanceFundingEndDate3.clear();
FinancialAssistanceFundingEndDates0.sendKeys("02272020");


((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
OfficeEditConfirmation.click();
Thread.sleep(11000);
((JavascriptExecutor) driver).executeScript("scroll(0,900)");
}
public void EditOfficeTypes43() throws InterruptedException {
Thread.sleep(4000);
FinancialAssistanceFundingEndDates0.clear();
FinancialAssistanceFundingEndDate2.clear();
FinancialAssistanceFundingEndDate3.clear();
FinancialAssistanceFundingEndDates0.sendKeys("0306222");

((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
OfficeEditConfirmation.click();
Thread.sleep(11000);
((JavascriptExecutor) driver).executeScript("scroll(0,900)");
}
public void EditOfficeTypes44() throws InterruptedException {
Thread.sleep(4000);
FinancialAssistanceFundingEndDates0.clear();
FinancialAssistanceFundingEndDate2.clear();
FinancialAssistanceFundingEndDate3.clear();
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
	

		FinancialAssistanceFundingEndDates0.sendKeys(dateFormat.format(currentDatePlusThree));
		Thread.sleep(3000);

((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
OfficeEditConfirmation.click();
Thread.sleep(11000);
((JavascriptExecutor) driver).executeScript("scroll(0,900)");
}
	public void EditOfficeTypes23() throws InterruptedException {
		
		edit.click();
		Thread.sleep(4000);
		((JavascriptExecutor) driver).executeScript("scroll(0,5000)");

			
			ContractFundingStartDate.clear();
			ContractFundingStartDate2.clear();
			ContractFundingStartDate3.clear();
			ContractFundingEndDates0.clear();
			ContractFundingEndDate2.clear();
			ContractFundingEndDate3.clear();
			//

			ContractFundingStartDate.sendKeys("02212018");
			((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
			OfficeEditConfirmation.click();
			Thread.sleep(5000);
			((JavascriptExecutor) driver).executeScript("scroll(0,900)");
			Thread.sleep(5000);
			((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
			OfficeEditConfirmation.click();
			Thread.sleep(5000);
			// check
		}
public void EditOfficeTypes24() throws InterruptedException {
		
		Thread.sleep(4000);

			

		ContractFundingStartDate.clear();
		ContractFundingStartDate2.clear();
		ContractFundingStartDate3.clear();
		ContractFundingEndDates0.clear();
			Thread.sleep(2000);

			
			ContractFundingEndDate2.clear();
			Thread.sleep(2000);

			ContractFundingEndDate3.clear();
			Thread.sleep(2000);

			//

			ContractFundingStartDate.sendKeys("02262020");
			Thread.sleep(1000);

			((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
			Thread.sleep(1000);

			OfficeEditConfirmation.click();
			Thread.sleep(1000);
			((JavascriptExecutor) driver).executeScript("scroll(0,900)");
			
			// check
			Thread.sleep(1000);

			((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
			OfficeEditConfirmation.click();
			Thread.sleep(4000);
			
			((JavascriptExecutor) driver).executeScript("scroll(0,900)");
		}
public void EditOfficeTypes25() throws InterruptedException {
	edit.click();
	Thread.sleep(4000);
	((JavascriptExecutor) driver).executeScript("scroll(0,5000)");

	Thread.sleep(4000);

		
	ContractFundingStartDate.clear();
	ContractFundingStartDate2.clear();
	ContractFundingStartDate3.clear();
		
		//

	ContractFundingStartDate.sendKeys("02232020");
		((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
		OfficeEditConfirmation.click();
		Thread.sleep(11000);
		((JavascriptExecutor) driver).executeScript("scroll(0,900)");
		// check
	}
public void EditOfficeTypes26() throws InterruptedException {
	
	Thread.sleep(4000);

		
	ContractFundingStartDate.clear();
	ContractFundingStartDate2.clear();
	ContractFundingStartDate3.clear();
	
		//

		((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
		OfficeEditConfirmation.click();
		Thread.sleep(5000);
		((JavascriptExecutor) driver).executeScript("scroll(0,900)");
		Thread.sleep(5000);

		((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
		OfficeEditConfirmation.click();
		Thread.sleep(5000);
		
		// check
	}
public void EditOfficeTypes27() throws InterruptedException {
	
	Thread.sleep(4000);


	ContractFundingStartDate.sendKeys("02272020");
		((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
		OfficeEditConfirmation.click();
		Thread.sleep(11000);
		((JavascriptExecutor) driver).executeScript("scroll(0,900)");
		// check
	}
public void EditOfficeTypes28() throws InterruptedException {
	edit.click();
	Thread.sleep(4000);
	((JavascriptExecutor) driver).executeScript("scroll(0,5000)");

	Thread.sleep(4000);
	ContractFundingEndDates0.clear();
	ContractFundingEndDate2.clear();
	ContractFundingEndDate3.clear();
	ContractFundingEndDates0.sendKeys("02262020");

	((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
	OfficeEditConfirmation.click();
	Thread.sleep(11000);
	((JavascriptExecutor) driver).executeScript("scroll(0,900)");
}
public void EditOfficeTypes29() throws InterruptedException {
	Thread.sleep(4000);
	ContractFundingEndDates0.clear();
	ContractFundingEndDate2.clear();
	ContractFundingEndDate3.clear();
	ContractFundingEndDates0.sendKeys("02272020");

	((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
	OfficeEditConfirmation.click();
	Thread.sleep(11000);
	((JavascriptExecutor) driver).executeScript("scroll(0,900)");
}
public void EditOfficeTypes30() throws InterruptedException {
	Thread.sleep(4000);
	ContractFundingEndDates0.clear();
	ContractFundingEndDate2.clear();
	ContractFundingEndDate3.clear();
	ContractFundingEndDates0.sendKeys("01142022");

	((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
	OfficeEditConfirmation.click();
	Thread.sleep(11000);
	((JavascriptExecutor) driver).executeScript("scroll(0,900)");
}
public void EditOfficeTypes31() throws InterruptedException {
	Thread.sleep(4000);
	
	ContractFundingStartDate.clear();
	ContractFundingStartDate2.clear();
	ContractFundingStartDate3.clear();;
	
	ContractFundingStartDate.sendKeys("02262020");
	ContractFundingEndDates0.clear();
	ContractFundingEndDate2.clear();
	ContractFundingEndDate3.clear();
	ContractFundingEndDates0.sendKeys("02272020");

	((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
	OfficeEditConfirmation.click();
	Thread.sleep(11000);
	((JavascriptExecutor) driver).executeScript("scroll(0,900)");
}
public void EditOfficeTypes32() throws InterruptedException {
	Thread.sleep(4000);
	ContractFundingEndDates0.clear();
	ContractFundingEndDate2.clear();
	ContractFundingEndDate3.clear();
	ContractFundingEndDates0.sendKeys("0306222");

	((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
	OfficeEditConfirmation.click();
	Thread.sleep(11000);
	((JavascriptExecutor) driver).executeScript("scroll(0,900)");
}
public void EditOfficeTypes33() throws InterruptedException {
	Thread.sleep(4000);
	ContractFundingEndDates0.clear();
	ContractFundingEndDate2.clear();
	ContractFundingEndDate3.clear();
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
		

			ContractFundingEndDates0.sendKeys(dateFormat.format(currentDatePlusThree));
			Thread.sleep(3000);

	((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
	OfficeEditConfirmation.click();
	Thread.sleep(11000);
	((JavascriptExecutor) driver).executeScript("scroll(0,900)");
}




public void EditOfficeTypes() throws InterruptedException {
	Thread.sleep(4000);
	edit.click();
	Thread.sleep(4000);
	((JavascriptExecutor) driver).executeScript("scroll(0,5000)");

		
		ContractAwardsStateDate.clear();
		ContractAwardsStateDate2.clear();
		ContractAwardsStateDate3.clear();
		ContractAwardsEndDate0.clear();
		ContractAwardsEndDate2.clear();
		ContractAwardsEndDate3.clear();
		//

		ContractAwardsDate.sendKeys("02212018");
		((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
		OfficeEditConfirmation.click();
		Thread.sleep(1000);
		((JavascriptExecutor) driver).executeScript("scroll(0,900)");
		Thread.sleep(5000);

		((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
		OfficeEditConfirmation.click();
		Thread.sleep(5000);
		((JavascriptExecutor) driver).executeScript("scroll(0,900)");
		// check
	}
public void EditOfficeTypes2() throws InterruptedException {
	
	Thread.sleep(4000);

		
		ContractAwardsStateDate.clear();
		ContractAwardsStateDate2.clear();
		ContractAwardsStateDate3.clear();
		ContractAwardsEndDate0.clear();
		Thread.sleep(2000);

		
		ContractAwardsEndDate2.clear();
		Thread.sleep(2000);

		ContractAwardsEndDate3.clear();
		Thread.sleep(2000);

		//

		ContractAwardsDate.sendKeys("02262020");
		((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
		OfficeEditConfirmation.click();
		Thread.sleep(1000);
		((JavascriptExecutor) driver).executeScript("scroll(0,900)");
		Thread.sleep(1000);
		((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
		OfficeEditConfirmation.click();
		Thread.sleep(5000);
		((JavascriptExecutor) driver).executeScript("scroll(0,900)");
		// check
	}
public void EditOfficeTypes3() throws InterruptedException {
edit.click();
Thread.sleep(4000);
((JavascriptExecutor) driver).executeScript("scroll(0,5000)");

Thread.sleep(4000);

	
	ContractAwardsStateDate.clear();
	ContractAwardsStateDate2.clear();
	ContractAwardsStateDate3.clear();
	
	//

	ContractAwardsDate.sendKeys("02232020");
	((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
	OfficeEditConfirmation.click();
	Thread.sleep(11000);
	((JavascriptExecutor) driver).executeScript("scroll(0,900)");
	// check
}
public void EditOfficeTypes4() throws InterruptedException {

Thread.sleep(4000);

	
	ContractAwardsStateDate.clear();
	ContractAwardsStateDate2.clear();
	ContractAwardsStateDate3.clear();

	//

	((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
	OfficeEditConfirmation.click();
	Thread.sleep(5000);
	((JavascriptExecutor) driver).executeScript("scroll(0,900)");
	Thread.sleep(5000);

	((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
	OfficeEditConfirmation.click();
	Thread.sleep(5000);
	((JavascriptExecutor) driver).executeScript("scroll(0,900)");
	// check
}
public void EditOfficeTypes5() throws InterruptedException {

Thread.sleep(4000);


	ContractAwardsDate.sendKeys("02272020");
	Thread.sleep(2000);
	((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
	Thread.sleep(2000);

	OfficeEditConfirmation.click();
	Thread.sleep(11000);
	((JavascriptExecutor) driver).executeScript("scroll(0,900)");
	// check
}
public void EditOfficeTypes6() throws InterruptedException {
edit.click();
Thread.sleep(4000);
((JavascriptExecutor) driver).executeScript("scroll(0,5000)");

Thread.sleep(4000);
ContractAwardsEndDate0.clear();
ContractAwardsEndDate2.clear();
ContractAwardsEndDate3.clear();
ContractAwardsEndDate0.sendKeys("02262020");

((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
OfficeEditConfirmation.click();
Thread.sleep(11000);
((JavascriptExecutor) driver).executeScript("scroll(0,900)");
}
public void EditOfficeTypes7() throws InterruptedException {
Thread.sleep(4000);
ContractAwardsEndDate0.clear();
ContractAwardsEndDate2.clear();
ContractAwardsEndDate3.clear();
ContractAwardsEndDate0.sendKeys("02272020");
Thread.sleep(2000);
((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
Thread.sleep(2000);
OfficeEditConfirmation.click();
Thread.sleep(11000);
((JavascriptExecutor) driver).executeScript("scroll(0,900)");
}
public void EditOfficeTypes8() throws InterruptedException {
Thread.sleep(4000);
ContractAwardsEndDate0.clear();
ContractAwardsEndDate2.clear();
ContractAwardsEndDate3.clear();
ContractAwardsEndDate0.sendKeys("01142022");
Thread.sleep(1000);
((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
Thread.sleep(1000);
//OfficeEditConfirmation.click();
//Thread.sleep(1000);
//((JavascriptExecutor) driver).executeScript("scroll(0,900)");
//Thread.sleep(1000);
//
//((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
OfficeEditConfirmation.click();
Thread.sleep(4000);

((JavascriptExecutor) driver).executeScript("scroll(0,900)");
}
public void EditOfficeTypesNew() throws InterruptedException {
	enddate1.clear();
	Thread.sleep(1000);

	enddate2.clear();
	Thread.sleep(1000);

	enddate3.clear();
	Thread.sleep(1000);

	
	((JavascriptExecutor) driver).executeScript("scroll(0,7000)");
	OfficeEditConfirmation.click();
	Thread.sleep(2000);

	((JavascriptExecutor) driver).executeScript("scroll(0,900)");
	OfficeEditConfirmation.click();
	Thread.sleep(4000);
	edit.click();
	Thread.sleep(4000);
	((JavascriptExecutor) driver).executeScript("scroll(0,5000)");

Thread.sleep(4000);
ContractAwards.click();
ContractAwardsStateDate.sendKeys("08102020");
ContractAwardsEndDate0.clear();
ContractAwardsEndDate2.clear();
ContractAwardsEndDate3.clear();
ContractAwardsEndDate0.sendKeys("06262025");
Thread.sleep(1000);
((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
Thread.sleep(1000);
//OfficeEditConfirmation.click();
//Thread.sleep(1000);
//((JavascriptExecutor) driver).executeScript("scroll(0,900)");
//Thread.sleep(1000);
//
//((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
OfficeEditConfirmation.click();
Thread.sleep(2000);

((JavascriptExecutor) driver).executeScript("scroll(0,900)");

}
public void EditOfficeTypesNew2() throws InterruptedException {
Thread.sleep(4000);

ContractAwardsEndDate0.clear();
ContractAwardsEndDate2.clear();
ContractAwardsEndDate3.clear();
ContractAwardsEndDate0.sendKeys("03262023");
Thread.sleep(1000);
((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
Thread.sleep(1000);
//OfficeEditConfirmation.click();
//Thread.sleep(1000);
//((JavascriptExecutor) driver).executeScript("scroll(0,900)");
//Thread.sleep(1000);
//
//((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
OfficeEditConfirmation.click();
Thread.sleep(4000);

((JavascriptExecutor) driver).executeScript("scroll(0,900)");
}
public void EditOfficeTypesNew3() throws InterruptedException {
	ContractAwards.click();
Thread.sleep(4000);
FinancialAssistanceAwards.click();
FinancialAssistanceAwardsStartDate.sendKeys("08102020");
FinancialAssistanceAwardsEnd0.clear();
FinancialAssistanceAwardsEnd2.clear();
FinancialAssistanceAwardsEnd3.clear();
FinancialAssistanceAwardsEnd0.sendKeys("06262025");
Thread.sleep(1000);
((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
Thread.sleep(1000);

OfficeEditConfirmation.click();
Thread.sleep(2000);

((JavascriptExecutor) driver).executeScript("scroll(0,900)");

}
public void EditOfficeTypesNew4() throws InterruptedException {
Thread.sleep(4000);

FinancialAssistanceAwardsEnd0.clear();
FinancialAssistanceAwardsEnd2.clear();
FinancialAssistanceAwardsEnd3.clear();
FinancialAssistanceAwardsEnd0.sendKeys("03262023");
Thread.sleep(1000);
((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
Thread.sleep(1000);

OfficeEditConfirmation.click();
Thread.sleep(4000);

((JavascriptExecutor) driver).executeScript("scroll(0,900)");
}
public void EditOfficeTypesNew5() throws InterruptedException {
	
	FinancialAssistanceAwards.click();
	
Thread.sleep(4000);
ContractFunding.click();
ContractFundingStartDate.sendKeys("08102020");
ContractFundingEndDates0.clear();
ContractFundingEndDate2.clear();
ContractFundingEndDate3.clear();
ContractFundingEndDates0.sendKeys("06262025");
Thread.sleep(1000);
((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
Thread.sleep(1000);

OfficeEditConfirmation.click();
Thread.sleep(2000);

((JavascriptExecutor) driver).executeScript("scroll(0,900)");

}
public void EditOfficeTypesNew6() throws InterruptedException {
Thread.sleep(4000);

ContractFundingEndDates0.clear();
ContractFundingEndDate2.clear();
ContractFundingEndDate3.clear();
ContractFundingEndDates0.sendKeys("03262023");
Thread.sleep(1000);
((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
Thread.sleep(1000);

OfficeEditConfirmation.click();
Thread.sleep(4000);

((JavascriptExecutor) driver).executeScript("scroll(0,900)");
}
public void EditOfficeTypesNew7() throws InterruptedException {
	
	ContractFunding.click();
	
Thread.sleep(4000);
FinancialAssistanceFunding.click();
FinancialAssistanceFundingStartDate.sendKeys("08102020");
FinancialAssistanceFundingEndDates0.clear();
FinancialAssistanceFundingEndDate2.clear();
FinancialAssistanceFundingEndDate3.clear();
FinancialAssistanceFundingEndDates0.sendKeys("06262025");
Thread.sleep(1000);
((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
Thread.sleep(1000);

OfficeEditConfirmation.click();
Thread.sleep(2000);

((JavascriptExecutor) driver).executeScript("scroll(0,900)");

}
public void EditOfficeTypesNew8() throws InterruptedException {
Thread.sleep(4000);

FinancialAssistanceFundingEndDates0.clear();
FinancialAssistanceFundingEndDate2.clear();
FinancialAssistanceFundingEndDate3.clear();
FinancialAssistanceFundingEndDates0.sendKeys("03262023");
Thread.sleep(1000);
((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
Thread.sleep(1000);

OfficeEditConfirmation.click();
Thread.sleep(4000);

((JavascriptExecutor) driver).executeScript("scroll(0,900)");
}
public void EditOfficeTypes9() throws InterruptedException {
Thread.sleep(4000);

ContractAwardsStateDate.clear();
ContractAwardsStateDate2.clear();
ContractAwardsStateDate3.clear();
ContractAwardsStateDate.sendKeys("02262020");
ContractAwardsEndDate0.clear();
ContractAwardsEndDate2.clear();
ContractAwardsEndDate3.clear();
ContractAwardsEndDate0.sendKeys("02272020");
Thread.sleep(2000);

((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
Thread.sleep(1000);

//OfficeEditConfirmation.click();
//Thread.sleep(1000);
//((JavascriptExecutor) driver).executeScript("scroll(0,900)");
//Thread.sleep(1000);
//
//((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
//Thread.sleep(1000);

OfficeEditConfirmation.click();
Thread.sleep(5000);
((JavascriptExecutor) driver).executeScript("scroll(0,900)");
}
public void EditOfficeTypes10() throws InterruptedException {
Thread.sleep(4000);
ContractAwardsEndDate0.clear();
ContractAwardsEndDate2.clear();
ContractAwardsEndDate3.clear();
ContractAwardsEndDate0.sendKeys("0306222");

((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
OfficeEditConfirmation.click();
Thread.sleep(11000);
((JavascriptExecutor) driver).executeScript("scroll(0,900)");
}
public void EditOfficeTypes11() throws InterruptedException {
Thread.sleep(4000);
ContractAwardsEndDate0.clear();
ContractAwardsEndDate2.clear();
ContractAwardsEndDate3.clear();
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
	

		ContractAwardsEndDate0.sendKeys(dateFormat.format(currentDatePlusThree));
		Thread.sleep(3000);

((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
OfficeEditConfirmation.click();
Thread.sleep(11000);
((JavascriptExecutor) driver).executeScript("scroll(0,900)");
}
public void EditOfficeTypes12() throws InterruptedException {
	
	edit.click();
	Thread.sleep(4000);
	((JavascriptExecutor) driver).executeScript("scroll(0,5000)");

		
		FinancialAssistanceAwardsStartDate.clear();
		FinancialAssistanceAwardsStart2.clear();
		FinancialAssistanceAwardsStart3.clear();
		FinancialAssistanceAwardsEnd0.clear();
		FinancialAssistanceAwardsEnd2.clear();
		FinancialAssistanceAwardsEnd3.clear();
		//

		FinancialAssistanceAwardsStartDate.sendKeys("02212018");
		((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
		OfficeEditConfirmation.click();
		Thread.sleep(5000);
		((JavascriptExecutor) driver).executeScript("scroll(0,900)");
		Thread.sleep(5000);
		((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
		OfficeEditConfirmation.click();
		Thread.sleep(5000);

		// check
	}
public void EditOfficeTypes13() throws InterruptedException {
	
	Thread.sleep(4000);

		
	FinancialAssistanceAwardsStartDate.clear();
	FinancialAssistanceAwardsStart2.clear();
	FinancialAssistanceAwardsStart3.clear();
	FinancialAssistanceAwardsEnd0.clear();
		Thread.sleep(2000);

		
		FinancialAssistanceAwardsEnd2.clear();
		Thread.sleep(2000);

		FinancialAssistanceAwardsEnd3.clear();
		Thread.sleep(2000);

		//

		FinancialAssistanceAwardsStartDate.sendKeys("02262020");
		Thread.sleep(1000);

		((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
		Thread.sleep(1000);

		OfficeEditConfirmation.click();
		Thread.sleep(1000);
		((JavascriptExecutor) driver).executeScript("scroll(0,900)");
//		// check
		Thread.sleep(1000);
//
		((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
		OfficeEditConfirmation.click();
		Thread.sleep(4000);
		
		((JavascriptExecutor) driver).executeScript("scroll(0,900)");
	}
public void EditOfficeTypes14() throws InterruptedException {
edit.click();
Thread.sleep(4000);
((JavascriptExecutor) driver).executeScript("scroll(0,5000)");

Thread.sleep(4000);

	
FinancialAssistanceAwardsStartDate.clear();
FinancialAssistanceAwardsStart2.clear();
FinancialAssistanceAwardsStart3.clear();
	
	//

FinancialAssistanceAwardsStartDate.sendKeys("02232020");
	((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
	OfficeEditConfirmation.click();
	Thread.sleep(4000);
	((JavascriptExecutor) driver).executeScript("scroll(0,900)");
	// check
	Thread.sleep(4000);

	((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
	OfficeEditConfirmation.click();
	Thread.sleep(4000);
	
	((JavascriptExecutor) driver).executeScript("scroll(0,900)");
}
public void EditOfficeTypes15() throws InterruptedException {

Thread.sleep(4000);

	
FinancialAssistanceAwardsStartDate.clear();
FinancialAssistanceAwardsStart2.clear();
FinancialAssistanceAwardsStart3.clear();

	//

	((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
	OfficeEditConfirmation.click();
	Thread.sleep(5000);
	((JavascriptExecutor) driver).executeScript("scroll(0,900)");
	Thread.sleep(5000);
	((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
	OfficeEditConfirmation.click();
	Thread.sleep(4000);
	((JavascriptExecutor) driver).executeScript("scroll(0,900)");
	// check
	Thread.sleep(4000);

	((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
	OfficeEditConfirmation.click();
	Thread.sleep(4000);
	
	((JavascriptExecutor) driver).executeScript("scroll(0,900)");
}
public void EditOfficeTypes16() throws InterruptedException {

Thread.sleep(4000);


FinancialAssistanceAwardsStartDate.sendKeys("02272020");
Thread.sleep(1000);
	((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
	OfficeEditConfirmation.click();
	Thread.sleep(11000);
	((JavascriptExecutor) driver).executeScript("scroll(0,900)");
	// check
}
public void EditOfficeTypes17() throws InterruptedException {
edit.click();
Thread.sleep(4000);
((JavascriptExecutor) driver).executeScript("scroll(0,5000)");

Thread.sleep(4000);
FinancialAssistanceAwardsEnd0.clear();
FinancialAssistanceAwardsEnd2.clear();
FinancialAssistanceAwardsEnd3.clear();;
FinancialAssistanceAwardsEnd0.sendKeys("02262020");

((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
OfficeEditConfirmation.click();
Thread.sleep(11000);
((JavascriptExecutor) driver).executeScript("scroll(0,900)");
}
public void EditOfficeTypes18() throws InterruptedException {
Thread.sleep(4000);
FinancialAssistanceAwardsEnd0.clear();
FinancialAssistanceAwardsEnd2.clear();
FinancialAssistanceAwardsEnd3.clear();
FinancialAssistanceAwardsEnd0.sendKeys("02272020");

((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
OfficeEditConfirmation.click();
Thread.sleep(11000);
((JavascriptExecutor) driver).executeScript("scroll(0,900)");
}
public void EditOfficeTypes19() throws InterruptedException {
Thread.sleep(4000);
FinancialAssistanceAwardsEnd0.clear();
FinancialAssistanceAwardsEnd2.clear();
FinancialAssistanceAwardsEnd3.clear();
FinancialAssistanceAwardsEnd0.sendKeys("01142022");

((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
OfficeEditConfirmation.click();
Thread.sleep(11000);
((JavascriptExecutor) driver).executeScript("scroll(0,900)");
}

public void EditOfficeTypes20() throws InterruptedException {
Thread.sleep(4000);

FinancialAssistanceAwardsStartDate.clear();
FinancialAssistanceAwardsStart2.clear();
FinancialAssistanceAwardsStart3.clear();
FinancialAssistanceAwardsStartDate.sendKeys("02262020");
FinancialAssistanceAwardsEnd0.clear();
FinancialAssistanceAwardsEnd2.clear();
FinancialAssistanceAwardsEnd3.clear();
FinancialAssistanceAwardsEnd0.sendKeys("02272020");

((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
OfficeEditConfirmation.click();
Thread.sleep(11000);
((JavascriptExecutor) driver).executeScript("scroll(0,900)");
}
public void EditOfficeTypes21() throws InterruptedException {
Thread.sleep(4000);
FinancialAssistanceAwardsEnd0.clear();
FinancialAssistanceAwardsEnd2.clear();
FinancialAssistanceAwardsEnd3.clear();
		FinancialAssistanceAwardsEnd0.sendKeys("0306222");

((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
OfficeEditConfirmation.click();
Thread.sleep(11000);
((JavascriptExecutor) driver).executeScript("scroll(0,900)");
}
public void EditOfficeTypes22() throws InterruptedException {
Thread.sleep(4000);
FinancialAssistanceAwardsEnd0.clear();
FinancialAssistanceAwardsEnd2.clear();
FinancialAssistanceAwardsEnd3.clear();
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
	

		FinancialAssistanceAwardsEnd0.sendKeys(dateFormat.format(currentDatePlusThree));
		Thread.sleep(3000);

((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
OfficeEditConfirmation.click();
Thread.sleep(11000);
((JavascriptExecutor) driver).executeScript("scroll(0,900)");
}
public boolean StartDateValidation1() throws InterruptedException {
	Thread.sleep(7000);

	((JavascriptExecutor) driver).executeScript("scroll(0,900)");
	Thread.sleep(2000);
	try {

		return TypeStartDateError16.isDisplayed();

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

		return  TypeEndDateError6.isDisplayed();

	} catch (Exception ex) {
		System.out.println("working as desired");
	}
	return false;
}
public boolean EndDateValidation3() throws InterruptedException {
	Thread.sleep(7000);

	((JavascriptExecutor) driver).executeScript("scroll(0,900)");
	Thread.sleep(2000);
	try {

		return  TypeEndDateError7.isDisplayed();

	} catch (Exception ex) {
		System.out.println("working as desired");
	}
	return false;

}
public boolean DateError() throws InterruptedException {
	Thread.sleep(7000);

	((JavascriptExecutor) driver).executeScript("scroll(0,900)");
	Thread.sleep(2000);
	try {

		return  EmptyDate.isDisplayed();

	} catch (Exception ex) {
		System.out.println("working as desired");
	}
	return false;
}
public void extra() throws InterruptedException {
	
	edit.click();
	Thread.sleep(4000);
	((JavascriptExecutor) driver).executeScript("scroll(0,5000)");

}
public void extra2() throws InterruptedException {
	Thread.sleep(3000);
	((JavascriptExecutor) driver).executeScript("scroll(0,-5000)");

	FHBreadcrumbLink.click();
	Thread.sleep(1000);

	FHSearch.sendKeys("OFFICEFORDATA2");
	FHSearch.sendKeys(Keys.ENTER);

	FHSearchDepAgency.click();
	Thread.sleep(1000);
	ActionsOffice.click();
	edit2.click();
	Thread.sleep(3000);
	

	enddate1.clear();
	enddate2.clear();
	enddate3.clear();
	
	
	
	
	Thread.sleep(4000);
	
	((JavascriptExecutor) driver).executeScript("scroll(0,5000)");
	ContractAwards.click();
		
		ContractAwardsStateDate.clear();
		ContractAwardsStateDate2.clear();
		ContractAwardsStateDate3.clear();
		ContractAwardsEndDate0.clear();
		ContractAwardsEndDate2.clear();
		ContractAwardsEndDate3.clear();
		//

		ContractAwardsDate.sendKeys("02212018");
		((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
		OfficeEditConfirmation.click();
		Thread.sleep(4000);
		
		((JavascriptExecutor) driver).executeScript("scroll(0,900)");
		Thread.sleep(4000);

		((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
		OfficeEditConfirmation.click();
		Thread.sleep(4000);
		
		((JavascriptExecutor) driver).executeScript("scroll(0,900)");
		// check
	
}
public void extra3() throws InterruptedException {

	edit.click();
	Thread.sleep(4000);
	((JavascriptExecutor) driver).executeScript("scroll(0,5000)");

	FinancialAssistanceAwards.click();
		
	
FinancialAssistanceAwardsStartDate.clear();
FinancialAssistanceAwardsStart2.clear();
FinancialAssistanceAwardsStart3.clear();
FinancialAssistanceAwardsEnd0.clear();
FinancialAssistanceAwardsEnd2.clear();
FinancialAssistanceAwardsEnd3.clear();
		//

FinancialAssistanceAwardsStartDate.sendKeys("02212018");
		((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
		OfficeEditConfirmation.click();
		Thread.sleep(1000);
		((JavascriptExecutor) driver).executeScript("scroll(0,900)");
		// check
		Thread.sleep(4000);

		((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
		OfficeEditConfirmation.click();
		Thread.sleep(4000);
		
		((JavascriptExecutor) driver).executeScript("scroll(0,900)");
	
}
public void extra4() throws InterruptedException {

	edit.click();
	Thread.sleep(4000);
	((JavascriptExecutor) driver).executeScript("scroll(0,5000)");


	ContractFunding.click();		
	ContractFundingStartDate.clear();
	ContractFundingStartDate2.clear();
	ContractFundingStartDate3.clear();
	ContractFundingEndDates0.clear();
	ContractFundingEndDate2.clear();
	ContractFundingEndDate3.clear();
		//

	ContractFundingStartDate.sendKeys("02212018");
		((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
		OfficeEditConfirmation.click();
		Thread.sleep(1000);
		((JavascriptExecutor) driver).executeScript("scroll(0,900)");
		// check
		Thread.sleep(4000);

		((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
		OfficeEditConfirmation.click();
		Thread.sleep(4000);
		
		((JavascriptExecutor) driver).executeScript("scroll(0,900)");
	
}
public void extra5() throws InterruptedException {

	edit.click();
	Thread.sleep(4000);
	((JavascriptExecutor) driver).executeScript("scroll(0,5000)");


	
	Thread.sleep(4000);
	

	FinancialAssistanceFunding.click();	
	FinancialAssistanceFundingStartDate.clear();
	FinancialAssistanceFundingStartDate2.clear();
	FinancialAssistanceFundingStartDate3.clear();
	FinancialAssistanceFundingEndDates0.clear();
	FinancialAssistanceFundingEndDate2.clear();
	FinancialAssistanceFundingEndDate3.clear();
		//

		FinancialAssistanceFundingStartDate.sendKeys("02212018");
		((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
		OfficeEditConfirmation.click();
		Thread.sleep(1000);
		((JavascriptExecutor) driver).executeScript("scroll(0,900)");
		// check
		Thread.sleep(4000);

		((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
		OfficeEditConfirmation.click();
		Thread.sleep(4000);
		
		((JavascriptExecutor) driver).executeScript("scroll(0,900)");
}
	
	public void intoLegislativeDep() {
		ResultLegislative.click();
		
	}
	public void intoActionDep() {
		ActionDep.click();
		
	}
	public void intoUSDep() {
		USDep.click();
		
	}
	public void intoDEP26Dep() {
		DEPT26Dep.click();
		
	}
	public void intoInactiveOffice() throws InterruptedException {
		POLICEPROCUREMENT.click();
		ActionsOffice.click();
		Thread.sleep(1000);

		edit2.click();
		Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("scroll(0,600)");
		enddate1.clear();
		enddate2.clear();
		enddate3.clear();
		Thread.sleep(2000);

		((JavascriptExecutor) driver).executeScript("scroll(0,9000)");

		OfficeEditConfirmation.click();
	
		Thread.sleep(2000);

		((JavascriptExecutor) driver).executeScript("scroll(0,9000)");

		OfficeEditConfirmation.click();
	
		Thread.sleep(3000);

	}
	public boolean TASValidation() throws InterruptedException {
		
		Thread.sleep(2000);
		try {

			return TASerror.isDisplayed();
		} catch (Exception ex) {
			System.out.println("working as desired");
		}
		return false;
	}
public boolean TASValidation2() throws InterruptedException {
		
		Thread.sleep(2000);
		try {

			return TASerror2.isDisplayed();
		} catch (Exception ex) {
			System.out.println("working as desired");
		}
		return false;
	}
	
	public void EditTas() throws InterruptedException {
		Thread.sleep(3000);
		
		((JavascriptExecutor) driver).executeScript("scroll(0,500)");
		ProfileEditCode.click();
		Tas.clear();
		Tas.sendKeys("98");
		Submit.click();		
	}
	public void EditTas2() throws InterruptedException {
		Thread.sleep(3000);
		
		((JavascriptExecutor) driver).executeScript("scroll(0,500)");
		ProfileEditCode.click();
		Tas.clear();
		Tas.sendKeys("88");
		Submit.click();		
	}
	public void EditTas4() throws InterruptedException {
		Thread.sleep(3000);
		
		((JavascriptExecutor) driver).executeScript("scroll(0,500)");
		ProfileEditCode.click();
		Tas.clear();
		Tas.sendKeys("02");
		Submit.click();		
	}
	public void EditTas3() throws InterruptedException {
		Thread.sleep(3000);
		
		//((JavascriptExecutor) driver).executeScript("scroll(0,500)");
	//	ProfileEditCode.click();
		Tas.clear();
		Tas.sendKeys("88");
		Submit.click();		
	}
	public void OfficeTasValidation() throws InterruptedException {
		Thread.sleep(3000);
		subtierlink.click();
		Thread.sleep(1000);
		officelink.click();
		Thread.sleep(1000);
		createlink.click();
		Thread.sleep(1000);
		Aac.sendKeys("353421");
		Random rand = new Random();
		int result = rand.nextInt(10000);
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


		((JavascriptExecutor) driver).executeScript("scroll(0,700)");
		Address.sendKeys("123 street");
		country.click();
		countryChoice.click();
		Thread.sleep(1000);
		zip.sendKeys("36310");

		city.click();
		cityChoice.click();

		Thread.sleep(3000);
		OfficeEditConfirmation.click();
		Thread.sleep(4000);
		((JavascriptExecutor) driver).executeScript("scroll(0,-200)");
		Thread.sleep(3000);

	}
	public void OfficeTasValidation2() throws InterruptedException {
		Aac.clear();
		Aac.sendKeys("883421");
		((JavascriptExecutor) driver).executeScript("scroll(0,900)");

		OfficeEditConfirmation.click();
		Thread.sleep(17000);
		((JavascriptExecutor) driver).executeScript("scroll(0,-200)");
		Thread.sleep(3000);
		
	}
	
	public boolean TASValidation3() throws InterruptedException {
	
		Thread.sleep(2000);
		try {

			return  errormessageaac2.isDisplayed();

		} catch (Exception ex) {
			System.out.println("working as desired");
		}
		return false;
	}
	public void EditRegionCodeNeg2() throws InterruptedException {

		edit.click();
		Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("scroll(0,500)");
		RegionCode.sendKeys("1234");
		Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
		OfficeEditConfirmation.click();
		Thread.sleep(2000);
		
		((JavascriptExecutor) driver).executeScript("scroll(0,700)");
	}
	public void EditRegionCodePos() throws InterruptedException {
		
		edit.click();
		Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("scroll(0,500)");
		RegionCode.clear();
		RegionCode.sendKeys("12");
		Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
		OfficeEditConfirmation.click();
		Thread.sleep(2000);
		
		((JavascriptExecutor) driver).executeScript("scroll(0,700)");
		
	}
	public void EditRegionCodePos2() throws InterruptedException {
		
		edit.click();
		Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("scroll(0,500)");
		RegionCode.clear();
		RegionCode.sendKeys("AB");
		Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
		OfficeEditConfirmation.click();
		Thread.sleep(2000);
		
		((JavascriptExecutor) driver).executeScript("scroll(0,900)");
		
	}
	public void EditRegionCodePos3() throws InterruptedException {
		
		edit.click();
		Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("scroll(0,500)");
		RegionCode.clear();
		RegionCode.sendKeys("ab");
		Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
		OfficeEditConfirmation.click();
		Thread.sleep(2000);
		
		((JavascriptExecutor) driver).executeScript("scroll(0,900)");
		
	}
	public void EditRegionCodePos4() throws InterruptedException {
		
		edit.click();
		Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("scroll(0,500)");
		RegionCode.clear();
		RegionCode.sendKeys("@@");
		Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
		OfficeEditConfirmation.click();
		Thread.sleep(2000);
		
		((JavascriptExecutor) driver).executeScript("scroll(0,900)");
		
	}
	public void EditRegionCodePos5() throws InterruptedException {
		
		edit.click();
		Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("scroll(0,500)");
		RegionCode.clear();
		RegionCode.sendKeys("$$");
		Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
		OfficeEditConfirmation.click();
		Thread.sleep(2000);
		
		((JavascriptExecutor) driver).executeScript("scroll(0,900)");
		
	}
	public void EditRegionCodeNeg() throws InterruptedException {
		
	
		Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("scroll(0,500)");
	
	

		((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
		OfficeEditConfirmation.click();
		Thread.sleep(2000);
		
		((JavascriptExecutor) driver).executeScript("scroll(0,900)");
		
	}
}
	
	
	
	
