package FhPages;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import util.TestBase;

public class GeneralFHPage extends TestBase {

	CreateOffice createOffice;
	OfficeMove moveOffice;

	public GeneralFHPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@aria-label='search federal hierarchy']")
	WebElement FhSearch;
	@FindBy(xpath = "//*[@class='ng-star-inserted']/div[2]/div/a")
	WebElement firstFHSearchResult;
	@FindBy(xpath = "//*[@id='primary-content']/strong")
	WebElement noPrivilege;
	@FindBy(xpath = "//*[text()='Sub-Tiers']")
	WebElement linkForSubtiers;
	@FindBy(linkText = "AUTOMATED_SUBTIER_TEST_1")
	WebElement firstSubtier;
	@FindBy(xpath = "//li[text()='Washington']")
	WebElement chooseCity;
	@FindBy(xpath = "//div[text()='AST2 - AUTOMATED_SUBTIER_TEST 2']")
	WebElement newSubtier;
	@FindBy(xpath = "//*[text()='The end date of the office cannot be after the end date of the new parent sub-tier. Please correct the end date of either the office or of the new parent sub-tier to complete the office move.']")
	WebElement OfficeEndDateCannotCompleteMove;
	@FindBy(xpath = "//*[text()='The end date(s) of any office type(s) cannot be after the end date of the new parent Sub-Tier. Please correct the end dates of either the office types or of the new parent sub-tier to complete the office move.']")
	WebElement OfficeTypeEndDateCannotCompleteMove;
	public String noPrivilegeMsg = "//*[@id='primary-content']/strong";

	public int noPrivilegeErrorMsg() {
		int noPrevelegeErrorMsgSize = driver.findElements(By.xpath(noPrivilegeMsg)).size();
		System.out.println("Error message size is : " + noPrevelegeErrorMsgSize);
		return noPrevelegeErrorMsgSize;
	}

	public boolean isNoPrivilegeErrorMsgPresent() {
		try {
			return OfficeTypeEndDateCannotCompleteMove.isDisplayed();
		} catch (Exception ex) {
			System.out.println("working as desired");
		}
		return false;
	}

	public void navigateToDepartment(String depName) throws InterruptedException {
		Thread.sleep(2000);
		FhSearch.clear();
		FhSearch.sendKeys(depName);
		Thread.sleep(2000);
		FhSearch.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		firstFHSearchResult.click();
		if (noPrivilegeErrorMsg() > 0) {
			driver.navigate().back();
			firstFHSearchResult.click();
		}
	}

	public void navigateToSubtier() throws InterruptedException {
		createOffice = new CreateOffice();
		linkForSubtiers.click();
		if (noPrivilegeErrorMsg() > 0) {
			driver.navigate().back();
			linkForSubtiers.click();
		}
		firstSubtier.click();
		if (noPrivilegeErrorMsg() > 0) {
			driver.navigate().back();
			firstSubtier.click();
		}
	}

	public void createNewOfficeWithEndDateWithoutOfficeType(String endDate) throws InterruptedException {
		Thread.sleep(2000);
		createOffice = new CreateOffice();
		try {
			createOffice.CreateOffice.click();
		} catch (Exception e) {
			driver.navigate().refresh();
			createOffice.CreateOffice.click();
		}
		((JavascriptExecutor) driver).executeScript("scroll(0,200)");
		Thread.sleep(2000);
		createOffice.Aac.sendKeys("99" + createRandomIntNumber());
		Thread.sleep(3000);

		String officeName = "HG Test Office " + createRandomFloatNumber();
		createOffice.ofcName.sendKeys(officeName);
		Thread.sleep(1000);

		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy ");
		Date date = new Date();
		createOffice.startdate1.sendKeys(dateFormat.format(date));
		Thread.sleep(1000);
		createOffice.enddate1.sendKeys(endDate);

		((JavascriptExecutor) driver).executeScript("scroll(0,600)");
		createOffice.Address.sendKeys("12345 Str");
		createOffice.country.click();
		createOffice.countryChoice.click();
		Thread.sleep(1000);
		createOffice.zip.sendKeys("20007");
		Thread.sleep(1000);
		createOffice.city.click();
		chooseCity.click();

		Thread.sleep(2000);
		createOffice.OfficeEditConfirmation.click();
		Thread.sleep(10000);
	}

	public void createNewOfficeWithOfficeType(String officeType, String endDate) throws InterruptedException {
		Thread.sleep(2000);
		createOffice = new CreateOffice();
		try {
			createOffice.CreateOffice.click();
		} catch (Exception e) {
			driver.navigate().refresh();
			createOffice.CreateOffice.click();
		}
		((JavascriptExecutor) driver).executeScript("scroll(0,200)");
		Thread.sleep(2000);
		createOffice.Aac.sendKeys("99" + createRandomIntNumber());
		Thread.sleep(3000);

		String officeName = "HG Test Office " + createRandomFloatNumber();
		createOffice.ofcName.sendKeys(officeName);
		Thread.sleep(1000);

		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy ");
		Date date = new Date();
		String StartDate = dateFormat.format(date);
		System.out.println(StartDate);
		createOffice.startdate1.sendKeys(StartDate);

		if (officeType.equalsIgnoreCase("Contract Awards")) {
			createOffice.ContractAwards.click();
			createOffice.ContractAwardsDate.sendKeys(StartDate);
			createOffice.ContractAwardsEndDate0.sendKeys(endDate);

		} else if (officeType.equalsIgnoreCase("Contract Funding")) {
			createOffice.ContractFunding.click();
			createOffice.ContractFundingStartDate.sendKeys(StartDate);
			createOffice.ContractFundingEndDates0.sendKeys(endDate);

		} else if (officeType.equalsIgnoreCase("Financial Assistance Awards")) {
			createOffice.FinancialAssistanceAwards.click();
			createOffice.FinancialAssistanceAwardsStartDate.sendKeys(StartDate);
			createOffice.FinancialAssistanceAwardsEnd0.sendKeys(endDate);

		} else if (officeType.equalsIgnoreCase("Financial Assistance Funding")) {
			createOffice.FinancialAssistanceFunding.click();
			createOffice.FinancialAssistanceFundingStartDate.sendKeys(StartDate);
			createOffice.FinancialAssistanceFundingEndDates0.sendKeys(endDate);

		} else {
			createOffice.ContractAwards.click();
			createOffice.ContractAwardsDate.sendKeys(StartDate);
			createOffice.ContractAwardsEndDate0.sendKeys(endDate);

			createOffice.ContractFunding.click();
			createOffice.ContractFundingStartDate.sendKeys(StartDate);
			createOffice.ContractFundingEndDates0.sendKeys(endDate);

			createOffice.FinancialAssistanceAwards.click();
			createOffice.FinancialAssistanceAwardsStartDate.sendKeys(StartDate);
			createOffice.FinancialAssistanceAwardsEnd0.sendKeys(endDate);

			createOffice.FinancialAssistanceFunding.click();
			createOffice.FinancialAssistanceFundingStartDate.sendKeys(StartDate);
			createOffice.FinancialAssistanceFundingEndDates0.sendKeys(endDate);
		}

		((JavascriptExecutor) driver).executeScript("scroll(0,600)");
		createOffice.Address.sendKeys("12345 Str");
		createOffice.country.click();
		createOffice.countryChoice.click();
		Thread.sleep(1000);
		createOffice.zip.sendKeys("20007");
		Thread.sleep(1000);
		createOffice.city.click();
		chooseCity.click();

		Thread.sleep(2000);
		createOffice.OfficeEditConfirmation.click();
		Thread.sleep(10000);
	}

	public void moveOfficeToNewSubtier() throws InterruptedException {
		moveOffice = new OfficeMove();
		Thread.sleep(5000);
		try {
			moveOffice.ActionsOffice.click();
		} catch (Exception e) {
			driver.navigate().refresh();
			Thread.sleep(3000);
			moveOffice.ActionsOffice.click();
		}
		Thread.sleep(2000);
		moveOffice.Move.click();
		Thread.sleep(2000);

		((JavascriptExecutor) driver).executeScript("scroll(0,900)");
		Thread.sleep(1000);
		moveOffice.FHMoveList.click();

		newSubtier.click();
		Thread.sleep(3000);
		moveOffice.MoveOffice.click();
	}

	public boolean validateCannotCompleteMoveWarningMsgForOfficeEndDate(String value) throws InterruptedException {
		Thread.sleep(2000);
		if (value.equalsIgnoreCase("Office end date")) {
			System.out.println("Warning message = " + OfficeEndDateCannotCompleteMove.getText());
		} else if (value.equalsIgnoreCase("Office type end date")) {
			System.out.println("Warning message = " + OfficeTypeEndDateCannotCompleteMove.getText());
		}

		try {
			if (value.equalsIgnoreCase("Office end date")) {
				return OfficeEndDateCannotCompleteMove.isDisplayed();

			} else if (value.equalsIgnoreCase("Office type end date")) {
				return OfficeTypeEndDateCannotCompleteMove.isDisplayed();
			}
		} catch (Exception ex) {
			System.out.println("working as desired");
		}
		return false;
	}

	public float createRandomFloatNumber() {
		Random rand = new Random();
		float result = rand.nextFloat();
		return result;
	}

	public float createRandomIntNumber() {
		Random rand = new Random();
		int result = rand.nextInt(100000);
		return result;
	}
}
