package FhPages;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

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
	@FindBy(xpath = "//a[@href='/fh/500153279/hierarchy']")
	WebElement linkForSubtiers;
	@FindBy(xpath = "//a[@href='/fh/500153662']")
	WebElement firstSubtier;
	@FindBy(xpath = "//div[text()='AST2 - AUTOMATED_SUBTIER_TEST 2']")
	WebElement newSubtier;
	@FindBy(xpath = "//*[text()='The end date of the office cannot be after the end date of the new parent sub-tier. Please correct the end date of either the office or of the new parent sub-tier to complete the office move.']")
	WebElement OfficeEndDateCannotCompleteMove;
	@FindBy(xpath = "//*[text()='The end date(s) of any office type(s) cannot be after the end date of the new parent Sub-Tier. Please correct the end dates of either the office types or of the new parent sub-tier to complete the office move.']")
	WebElement OfficeTypeEndDateCannotCompleteMove;

	public void navigateToDepartment(String depName) throws InterruptedException {
		Thread.sleep(2000);
		FhSearch.clear();
		FhSearch.sendKeys(depName);
		Thread.sleep(2000);
		FhSearch.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		firstFHSearchResult.click();
	}

	public void navigateToSubtier() throws InterruptedException {
		createOffice = new CreateOffice();
		linkForSubtiers.click();
		firstSubtier.click();
	}

	public void createAndSubmitNewOfficeWithEndDateWithoutOfficeType(String endDate) throws InterruptedException {
		Thread.sleep(2000);
		createOffice = new CreateOffice();
		createOffice.CreateOffice.click();

		((JavascriptExecutor) driver).executeScript("scroll(0,200)");

		String randomAac = "99" + createRandomIntNumber();
		Thread.sleep(2000);
		createOffice.Aac.sendKeys(randomAac);
		Thread.sleep(3000);

		String officeName = "HG Test Office " + createRandomFloatNumber();
		createOffice.ofcName.sendKeys(officeName);
		Thread.sleep(1000);

		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy ");
		// get current date time with Date()
		Date date = new Date();

		// Now format the date
		String StartDate = dateFormat.format(date);

		// Print the Date
		System.out.println(StartDate);
		createOffice.startdate1.sendKeys(StartDate);

		Thread.sleep(1000);
		createOffice.enddate1.sendKeys(endDate);

		((JavascriptExecutor) driver).executeScript("scroll(0,600)");
		createOffice.Address.sendKeys("123 street");
		createOffice.country.click();
		createOffice.countryChoice.click();
		Thread.sleep(1000);
		createOffice.city.click();
		createOffice.cityChoice.click();
		createOffice.zip.sendKeys("36310");

		Thread.sleep(2000);
		createOffice.OfficeEditConfirmation.click();
		Thread.sleep(10000);

		((JavascriptExecutor) driver).executeScript("scroll(0,500)");
		Thread.sleep(5000);
		createOffice.submit.click();
		Thread.sleep(5000);
	}

	public void moveOfficeToNewSubtier() throws InterruptedException {
		moveOffice = new OfficeMove();
		Thread.sleep(5000);
		driver.navigate().refresh();
		Thread.sleep(2000);
		moveOffice.ActionsOffice.click();
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

	public boolean validateCannotCompleteMoveWarningMsgForOfficeEndDate() throws InterruptedException {
		Thread.sleep(2000);
		System.out.println("Warning message = " + OfficeEndDateCannotCompleteMove.getText());
		try {
			return OfficeEndDateCannotCompleteMove.isDisplayed();

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
