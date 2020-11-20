package FhPages;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.server.handler.SubmitElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fasterxml.jackson.core.Version;

import util.TestBase;

public class OfficeMove extends TestBase {
	static String randomOfficeTitle;
	static String randomAac;
	@FindBy(id = "actionsButton")
	WebElement ActionsOffice;
	@FindBy(id = "menuitem1")
	WebElement Move;
	@FindBy(id = "federalHierarchy")
	WebElement FHMoveList;
	@FindBy(xpath = "//button[@aria-label=\"Federal hierarchy edit office cancel\"]")
	WebElement cancel;
	@FindBy(id = "federalHierarchy_500153662")
	WebElement SuperAdminChoice;
	@FindBy(xpath = "//a[@href=\"/fh/500155360\"]")
	WebElement Moveedit;

	@FindBy(id = "federalHierarchy_100120624")
	WebElement DepAdminChoice;
	@FindBy(xpath = "//input[@aria-label=\"search federal hierarchy\"]")
	WebElement FHsEARCH;
	@FindBy(xpath = "//a[@href=\"/fh/100180047\"]")
	WebElement gsaoffice;
	@FindBy(xpath = "//a[text()='Federal Hierarchy']")
	WebElement FHBreadcrumbLink;

	@FindBy(xpath = "//a[@href=\"/fh/500155234\"]")
	WebElement InactiveOFF;
	@FindBy(xpath = "//a[@href='/fh/500154944']")
	WebElement activeOFF;
	@FindBy(xpath = "//a[@href=\"/fh/500155263\"]")
	WebElement MoveSubtier;
	@FindBy(xpath = "//a[@href=\"/fh/300000221\"]")
	WebElement MoveSubtier2;
	@FindBy(xpath = "//a[@href=\"/fh/500154947\"]")
	WebElement ToBeOffice;

	@FindBy(xpath = "//a[@href=\"/fh/500155267\"]")
	WebElement MoveTest;
	@FindBy(id = "federalHierarchy-resultItem-2")
	WebElement SameParent;
	@FindBy(id = "federalHierarchy-resultItem-0")
	WebElement NewParent;
	@FindBy(id = "federalHierarchy-resultItem-1")
	WebElement NewParent2;
	@FindBy(xpath = "//option[text()='Current']")
	WebElement Current;
	@FindBy(xpath = "//button[text()=' Confirm Move ']")
	WebElement MoveOffice;
	@FindBy(xpath = "//button[text()=' Move Office ']")
	WebElement ConfirmMoveOffice;
	@FindBy(xpath = "//button[@aria-label=\"'Federal Hierarchy Move Office Confirm'\"]")
	WebElement ConfirmMove;
	@FindBy(xpath = "//button[text()=' Create Office ']")
	WebElement CreateOffice;
	@FindBy(id = "dialog-title")
	WebElement MoveNotice;
	@FindBy(xpath = "//*[@id=\"main-container\"]/fh-move-office/div/div/section/fh-move-office-review/sam-modal/div[2]/div/div[2]/div/sam-button[2]/button")
	WebElement NoticeYes;
	@FindBy(xpath = "//*[@id=\"ofcName-input\"]")
	WebElement ofcName;
	@FindBy(id = "ofc-start-date month required. Enter Month Here")
	WebElement startdate1;
	@FindBy(id = "ofc-start-date day required. Enter Day Here")
	WebElement startdate2;
	@FindBy(id = "ofc-start-date year required. Enter Year Here")
	WebElement startdate3;
	@FindBy(id = "ofc-end-date month Enter Month Here")
	WebElement enddate1;
	@FindBy(id = "ofc-end-date day Enter Day Here")
	WebElement enddate2;
	@FindBy(id = "ofc-end-date year Enter Year Here")
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
	@FindBy(xpath = "//li[text()='Abbeville']")
	WebElement cityChoice;
	@FindBy(xpath = "//li[text()='Clopton']")
	WebElement cityChoice2;
	@FindBy(xpath = "//button[text()=' Edit ']")
	WebElement edit;
	@FindBy(id = "menuitem0")
	WebElement edit2;
	@FindBy(id = "ContractAwards")
	WebElement ContractAwards;
	@FindBy(id = "ContractAwardsStartDate month Enter Month Here")
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
	@FindBy(id = "FinancialAssistanceAwards")
	WebElement FinancialAssistanceAwards;
	@FindBy(id = "ContractFunding")
	WebElement ContractFunding;
	@FindBy(id = "FinancialAssistanceFunding")
	WebElement FinancialAssistanceFunding;

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
	@FindBy(id = "ofcAAC-input")
	WebElement Aac;
	@FindBy(xpath = "//*[@id='selectOrgHistory']")
	WebElement History;
	@FindBy(xpath = "//button[@type='button']")
	WebElement submit;
	@FindBy(xpath = "//h3[text()='Success!']")
	WebElement SucessBanner2;
	@FindBy(xpath = "//*[@id=\"primary-content\"]/fh-office-profile-history/div/sam-alert/div/div/p")
	WebElement HistorySign;

	public OfficeMove() {
		PageFactory.initElements(driver, this);
	}

	public void MovePermission() throws InterruptedException {
		Thread.sleep(5000);
		ActionsOffice.click();
		
	}

	public boolean PermissionValidation1() throws InterruptedException {
		Thread.sleep(2000);
		try {

			return Move.isDisplayed();

		} catch (Exception ex) {
			System.out.println("working as desired");
		}
		return false;

	}

	public boolean ActionsOptions() throws InterruptedException {
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(2000);

		try {

			return ActionsOffice.isDisplayed();

		} catch (Exception ex) {
			System.out.println("working as desired");
		}
		return false;

	}

	public void AdminMovePermission() throws InterruptedException {
		Move.click();
		Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("scroll(0,900)");
		Thread.sleep(1000);
		FHMoveList.click();

	}

	public boolean PermissionValidation2() throws InterruptedException {
		try {

			return SuperAdminChoice.isDisplayed();

		} catch (Exception ex) {
			System.out.println("working as desired");
		}
		return false;

	}

	public boolean PermissionValidation3() throws InterruptedException {
		try {

			return DepAdminChoice.isDisplayed();

		} catch (Exception ex) {
			System.out.println("working as desired");
		}
		return false;

	}

	public void SearchGSAoFFICE() throws InterruptedException {
		FHsEARCH.clear();
		// ((JavascriptExecutor) driver).executeScript("scroll(0,-400)");
		FHsEARCH.sendKeys("ENVISION XPRESS #63");
		Thread.sleep(3000);
		FHsEARCH.sendKeys(Keys.ENTER);
		((JavascriptExecutor) driver).executeScript("scroll(0,200)");
		gsaoffice.click();
	}

	public void SearchActiveOffice() throws InterruptedException {
		FHBreadcrumbLink.click();
		Thread.sleep(1000);

		FHsEARCH.clear();
		FHsEARCH.sendKeys("OFFICE5");
		Thread.sleep(3000);
		FHsEARCH.sendKeys(Keys.ENTER);
		((JavascriptExecutor) driver).executeScript("scroll(0,400)");
		Thread.sleep(5000);
		activeOFF.click();
	}

	public void SearchInactiveOffice() throws InterruptedException {

		FHsEARCH.sendKeys("TEST OFFICE 0.028389096");
		Thread.sleep(3000);
		FHsEARCH.sendKeys(Keys.ENTER);
		((JavascriptExecutor) driver).executeScript("scroll(0,400)");
		driver.findElement(By.id("Inactive")).click();
		Thread.sleep(5000);
		InactiveOFF.click();
	}

	public void SearchToBeActiveOffice() throws InterruptedException {
		FHBreadcrumbLink.click();
		Thread.sleep(1000);

		FHsEARCH.clear();
		FHsEARCH.sendKeys("TEST10");
		Thread.sleep(3000);
		FHsEARCH.sendKeys(Keys.ENTER);
		((JavascriptExecutor) driver).executeScript("scroll(0,400)");
		driver.findElement(By.id("Inactive")).click();
		Thread.sleep(3000);
		ToBeOffice.click();
	}

	public void CheckOfficeMoveOptions() throws InterruptedException {
		FHBreadcrumbLink.click();
		Thread.sleep(1000);

		FHsEARCH.clear();
		FHsEARCH.sendKeys("TEST OFFICE FOR MOVE");
		Thread.sleep(3000);
		FHsEARCH.sendKeys(Keys.ENTER);
		((JavascriptExecutor) driver).executeScript("scroll(0,400)");
		Thread.sleep(3000);
		MoveTest.click();

	}

	public boolean ListValidation() {
		boolean verify;

		// VALIDATION FOR "YOU"
		WebElement locatorforWhereTEXTisPresentt5 = driver.findElement(By.id("federalHierarchy-listbox"));

		String Requesttext = locatorforWhereTEXTisPresentt5.getText();

		if (Requesttext.contains("JJDJ - MOVE TEST SUBTIER")) {
			verify = true;
		}

		else {
			verify = false;
		}

		System.out.println(Requesttext);
		return verify;
	}

	public boolean ListValidation2() {
		boolean verify;

		// VALIDATION FOR "YOU"
		WebElement locatorforWhereTEXTisPresentt5 = driver.findElement(By.id("federalHierarchy-listbox"));

		String Requesttext = locatorforWhereTEXTisPresentt5.getText();

		if (Requesttext.contains("JFFJ - TEST")) {
			verify = true;
		}

		else {
			verify = false;
		}

		System.out.println(Requesttext);
		return verify;
	}

	public boolean ListValidation3() {
		boolean verify;

		// VALIDATION FOR "YOU"
		WebElement locatorforWhereTEXTisPresentt5 = driver.findElement(By.id("federalHierarchy-listbox"));

		String Requesttext = locatorforWhereTEXTisPresentt5.getText();

		if (Requesttext.contains("INACTIVE OFFICE")) {
			verify = false;
		}

		else {
			verify = true;
		}

		System.out.println(Requesttext);
		return verify;
	}

	public boolean ListValidation4() {
		boolean verify;

		// VALIDATION FOR "YOU"
		WebElement locatorforWhereTEXTisPresentt5 = driver.findElement(By.id("federalHierarchy-listbox"));

		String Requesttext = locatorforWhereTEXTisPresentt5.getText();

		if (Requesttext.contains("TEST MOVE")) {
			verify = false;
		}

		else {
			verify = true;
		}

		System.out.println(Requesttext);
		return verify;
	}

	public boolean ListValidation5() {
		boolean verify;

		// VALIDATION FOR "YOU"
		WebElement locatorforWhereTEXTisPresentt5 = driver.findElement(By.id("federalHierarchy-listbox"));

		String Requesttext = locatorforWhereTEXTisPresentt5.getText();

		if (Requesttext.contains("VEST - SUBTIER")) {
			verify = true;
		}

		else {
			verify = false;
		}

		System.out.println(Requesttext);
		return verify;
	}

	public void Negmove() {

		SameParent.click();
		ConfirmMove.click();

	}

	public boolean NegValidation() {
		boolean verify;

		// VALIDATION FOR "YOU"
		WebElement locatorforWhereTEXTisPresentt5 = driver.findElement(By.id("federalHierarchy-error"));

		String Requesttext = locatorforWhereTEXTisPresentt5.getText();

		if (Requesttext.contains(
				"For this office move, please select a different parent sub-tier than the existing parent sub-tier.")) {
			verify = true;
		}

		else {
			verify = false;
		}

		System.out.println(Requesttext);
		return verify;
	}

	public void OfficeMoveFlowPOS() throws InterruptedException {

		FHBreadcrumbLink.click();
		Thread.sleep(1000);

		FHsEARCH.clear();
		FHsEARCH.sendKeys("JFFJ");
		Thread.sleep(3000);
		FHsEARCH.sendKeys(Keys.ENTER);
		((JavascriptExecutor) driver).executeScript("scroll(0,400)");
		Thread.sleep(3000);
		MoveSubtier.click();
		CreateOffice.click();

		Random rand = new Random();
		int result = rand.nextInt(10000);
		randomAac = "77" + result;
		Thread.sleep(2000);
		Aac.sendKeys(randomAac);
		Thread.sleep(3000);

		Random rand2 = new Random();
		float result2 = rand2.nextFloat();
		randomOfficeTitle = "Test Office for move " + result2;

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
		Date currentDatePlusThree = c.getTime();

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
		ContractAwardsStateDate.sendKeys((StartDate));
		ContractAwardsEndDate0.sendKeys(dateFormat.format(currentDatePlustwo));
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
		Thread.sleep(18000);
		Thread.sleep(3000);

		((JavascriptExecutor) driver).executeScript("scroll(0,700)");
		Thread.sleep(3000);

		submit.click();

		TimeUnit.SECONDS.sleep(10);

	}

	public void OfficeMoveFlowPOS0() throws InterruptedException {

		Thread.sleep(1000);

		FHsEARCH.sendKeys("JFFJ");
		Thread.sleep(3000);
		FHsEARCH.sendKeys(Keys.ENTER);
		((JavascriptExecutor) driver).executeScript("scroll(0,400)");
		Thread.sleep(3000);
		MoveSubtier.click();
		CreateOffice.click();

		Random rand = new Random();
		int result = rand.nextInt(100000);
		randomAac = "77" + result;
		Thread.sleep(2000);
		Aac.sendKeys(randomAac);
		Thread.sleep(3000);

		Random rand2 = new Random();
		float result2 = rand2.nextFloat();
		randomOfficeTitle = "Test Office for move " + result2;

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
		Date currentDatePlusThree = c.getTime();

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
		ContractAwardsStateDate.sendKeys((StartDate));
		ContractAwardsEndDate0.sendKeys(dateFormat.format(currentDatePlustwo));
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
		Thread.sleep(18000);
		Thread.sleep(3000);

		((JavascriptExecutor) driver).executeScript("scroll(0,900)");
		Thread.sleep(3000);

		submit.click();

		TimeUnit.SECONDS.sleep(10);

	}

	public void OfficeMoveFlowPOS00() throws InterruptedException {

		Thread.sleep(1000);

		FHsEARCH.sendKeys("4700");
		Thread.sleep(3000);
		FHsEARCH.sendKeys(Keys.ENTER);
		((JavascriptExecutor) driver).executeScript("scroll(0,400)");
		Thread.sleep(3000);
		MoveSubtier2.click();
		CreateOffice.click();

		Random rand = new Random();
		int result = rand.nextInt(10000);
		randomAac = "47" + result;
		Thread.sleep(2000);
		Aac.sendKeys(randomAac);
		Thread.sleep(3000);

		Random rand2 = new Random();
		float result2 = rand2.nextFloat();
		randomOfficeTitle = "Test Office for move " + result2;

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
		Date currentDatePlusThree = c.getTime();

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
		ContractAwardsStateDate.sendKeys((StartDate));
		ContractAwardsEndDate0.sendKeys(dateFormat.format(currentDatePlustwo));
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
		Thread.sleep(18000);
		Thread.sleep(3000);

		((JavascriptExecutor) driver).executeScript("scroll(0,700)");
		Thread.sleep(3000);

		submit.click();

		TimeUnit.SECONDS.sleep(10);

	}

	public boolean NewOfficeVersion() {

		try {

			return Current.isDisplayed();

		} catch (Exception ex) {
			System.out.println("working as desired");
		}
		return false;

	}

	public void OfficeMoveFlowPOS2() throws InterruptedException {
		NewParent.click();
		Thread.sleep(3000);
		MoveOffice.click();
	}

	public boolean ConfirmationValidation() {
		boolean verify;
		((JavascriptExecutor) driver).executeScript("scroll(0,400)");
		// VALIDATION FOR "YOU"
		WebElement locatorforWhereTEXTisPresentt5 = driver.findElement(By
				.xpath("//*[@id=\"main-container\"]/fh-move-office/div/div/section/fh-move-office-review/div[2]/div"));

		String Requesttext = locatorforWhereTEXTisPresentt5.getText();

		if (Requesttext.contains("JJDJ")) {
			verify = true;
		}

		else {
			verify = false;
		}

		System.out.println(Requesttext);
		return verify;
	}

	public void MoveOfficeFinal() {
		((JavascriptExecutor) driver).executeScript("scroll(0,500)");
		ConfirmMoveOffice.click();
	}

	public boolean MoveValidation() throws InterruptedException {
		try {

			return MoveNotice.isDisplayed();

		} catch (Exception ex) {
			System.out.println("working as desired");
		}
		return false;

	}

	public void OfficeMoveFlowPOS3() throws InterruptedException {
		NoticeYes.click();

	}

	public boolean isSuccessBannerThere() throws InterruptedException {
		Thread.sleep(3000);
		return SucessBanner2.isDisplayed();
	}

	public boolean isHistorical() throws InterruptedException {
		Thread.sleep(3000);
		try {

			return HistorySign.isDisplayed();
		} catch (Exception ex) {
			System.out.println("working as desired");
		}
		return false;
	}

	public boolean BreadcrumbValidationPostMove() {
		boolean verify;

		// VALIDATION FOR "YOU"
		WebElement locatorforWhereTEXTisPresentt5 = driver
				.findElement(By.xpath("//*[@id=\"main-container\"]/ng-component/div/sam-breadcrumbs/ul"));

		String Requesttext = locatorforWhereTEXTisPresentt5.getText();

		if (Requesttext.contains("MOVE TEST SUBTIER")) {
			verify = true;
		}

		else {
			verify = false;
		}

		System.out.println(Requesttext);
		return verify;
	}

	public boolean BreadcrumbValidationPostMove2() {
		boolean verify;
		driver.findElement(By.xpath("//*[@id=\"primary-content\"]/ng-component/div/div[1]")).click();
		// VALIDATION FOR "YOU"
		WebElement locatorforWhereTEXTisPresentt5 = driver
				.findElement(By.xpath("//*[@id=\"main-container\"]/ng-component/div/sam-breadcrumbs/ul"));

		String Requesttext = locatorforWhereTEXTisPresentt5.getText();

		if (Requesttext.contains("SUBTIER")) {
			verify = true;
		}

		else {
			verify = false;
		}

		System.out.println(Requesttext);
		return verify;
	}

	public boolean NameValidationPostMove() {
		boolean verify;
		((JavascriptExecutor) driver).executeScript("scroll(0,400)");
		// VALIDATION FOR "YOU"
		WebElement locatorforWhereTEXTisPresentt5 = driver
				.findElement(By.xpath("//*[@id=\"primary-content\"]/ng-component/div/div[1]"));

		String Requesttext = locatorforWhereTEXTisPresentt5.getText();

		if (Requesttext.contains("MOVE TEST SUBTIER")) {
			verify = true;
		}

		else {
			verify = false;
		}

		System.out.println(Requesttext);
		return verify;
	}

	public void OfficeMoveFlowPOS4() throws InterruptedException {
		History.click();
	}

	public boolean HistoryValidation() {
		boolean verify;

		// VALIDATION FOR "YOU"
		WebElement locatorforWhereTEXTisPresentt5 = driver.findElement(By.id("selectOrgHistory"));

		String Requesttext = locatorforWhereTEXTisPresentt5.getText();

		if (Requesttext.contains("Current")) {
			verify = true;
		}

		else {
			verify = false;
		}

		System.out.println(Requesttext);
		return verify;
	}

	public boolean HistoryValidation4() {
		boolean verify;

		// VALIDATION FOR "YOU"
		driver.findElement(By.id("selectOrgHistory")).click();
		WebElement locatorforWhereTEXTisPresentt5 = driver.findElement(By.id("selectOrgHistory"));

		String Requesttext = locatorforWhereTEXTisPresentt5.getText();

		if (Requesttext.contains("Moved")) {
			verify = true;
		}

		else {
			verify = false;
		}

		System.out.println(Requesttext);
		return verify;
	}

	public boolean HistoryValidation2() {
		boolean verify;

		// VALIDATION FOR "YOU"
		driver.findElement(By.id("selectOrgHistory")).click();
		List<WebElement> locatorforWhereTEXTisPresentt5 = driver
				.findElements(By.xpath("//*[@id='selectOrgHistory']/option"));

		List<String> Requesttext = new ArrayList<>();

		for (WebElement element : locatorforWhereTEXTisPresentt5) {
			Requesttext.add(element.getText());
		}
		System.out.println("Dropdawn menu text is ==== " + Requesttext);

		if (Requesttext.toString().contains("Updated")) {
			verify = true;
		}

		else {
			verify = false;
		}

		return verify;
	}

	public boolean HistoryValidation3() {
		boolean verify;

		// VALIDATION FOR "YOU"
		WebElement locatorforWhereTEXTisPresentt5 = driver.findElement(By.id("selectOrgHistory"));

		String Requesttext = locatorforWhereTEXTisPresentt5.getText();

		if (Requesttext.contains("Created")) {
			verify = true;
		}

		else {
			verify = false;
		}

		System.out.println(Requesttext);
		return verify;
	}

	public boolean HistoryValidationEdit() {
		boolean verify;

		// VALIDATION FOR "YOU"
		WebElement locatorforWhereTEXTisPresentt5 = driver
				.findElement(By.xpath("//*[@id=\"main-container\"]/ng-component/div"));

		String Requesttext = locatorforWhereTEXTisPresentt5.getText();

		if (Requesttext.contains("Abbeville AL 36310")) {
			verify = true;
		}

		else {
			verify = false;
		}

		System.out.println(Requesttext);
		return verify;
	}

	public boolean HistoryValidationBeforeEdit() {
		boolean verify;

		// VALIDATION FOR "YOU"
		WebElement locatorforWhereTEXTisPresentt5 = driver
				.findElement(By.xpath("//*[@id=\"main-container\"]/ng-component/div"));

		String Requesttext = locatorforWhereTEXTisPresentt5.getText();

		if (Requesttext.contains("Clopton, AL 36317")) {
			verify = true;
		}

		else {
			verify = false;
		}

		System.out.println(Requesttext);
		return verify;
	}

	public void MoveEdit() throws InterruptedException {
		FHsEARCH.sendKeys("90DKJV");
		Thread.sleep(3000);
		FHsEARCH.sendKeys(Keys.ENTER);
		((JavascriptExecutor) driver).executeScript("scroll(0,400)");
		Thread.sleep(3000);
		Moveedit.click();
		Thread.sleep(1000);
		driver.navigate().refresh();
		Thread.sleep(2000);
		ActionsOffice.click();
		edit2.click();
		// validate
		// ContractAwardsStateDate.clear();
		// ContractAwardsStateDate.sendKeys("0");
		boolean fname = ContractAwardsStateDate.isEnabled();
		System.out.print(fname);
		Thread.sleep(2000);

		((JavascriptExecutor) driver).executeScript("scroll(0,-800)");

		// startdate1.clear();
		// startdate1.sendKeys("0");
		boolean fname2 = startdate1.isEnabled();
		System.out.print(fname2);

		((JavascriptExecutor) driver).executeScript("scroll(0,800)");
		if (fname2 == true) {
			FHBreadcrumbLink.click();

			Thread.sleep(3000);

			((JavascriptExecutor) driver).executeScript("scroll(0,700)");
			Thread.sleep(3000);

			// validate error message
			// For offices that are moved, do not allow editing of start date for office and
			// office types (Disable the input date field). The end dates can be modified
			// anytime as long as the end date’s hierarchical logic is followed.
		}
	}

	public void MoveEdit2() throws InterruptedException {

		Thread.sleep(1000);

		FHsEARCH.clear();
		FHsEARCH.sendKeys("JFFJ");
		Thread.sleep(3000);
		FHsEARCH.sendKeys(Keys.ENTER);
		((JavascriptExecutor) driver).executeScript("scroll(0,400)");
		Thread.sleep(3000);
		MoveSubtier.click();
		Thread.sleep(3000);
		driver.navigate().refresh();
		CreateOffice.click();

		Random rand = new Random();
		int result = rand.nextInt(10000);
		randomAac = "77" + result;
		Thread.sleep(2000);
		Aac.sendKeys(randomAac);
		Thread.sleep(3000);

		Random rand2 = new Random();
		float result2 = rand2.nextFloat();
		randomOfficeTitle = "Test Office for move " + result2;

		ofcName.sendKeys(randomOfficeTitle);
		Thread.sleep(1000);

		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy ");

		// get current date time with Date()
		Date date = new Date();
		String StartDate = dateFormat.format(date);
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DATE, -2);
		Date currentDatePlusOne = c.getTime();

		startdate1.sendKeys(dateFormat.format(currentDatePlusOne));

		// convert calendar to date
		c.add(Calendar.DATE, +5);
		Date currentDatePlus5 = c.getTime();

		enddate1.sendKeys(dateFormat.format(currentDatePlus5));
		Thread.sleep(3000);
		// manipulate date

		c.add(Calendar.DATE, -4);
		Date currentDateMinus1 = c.getTime();

		c.add(Calendar.DATE, +2);
		Date currentDatePlus = c.getTime();

		// convert calen

		// convert calendar to date

		// convert calendar to date

		ContractAwards.click();
		ContractAwardsStateDate.sendKeys((StartDate));
		ContractAwardsEndDate0.sendKeys(dateFormat.format(currentDatePlus5));

		FinancialAssistanceAwards.click();
		FinancialAssistanceAwardsStartDate.sendKeys(dateFormat.format(currentDatePlus));
		FinancialAssistanceAwardsEnd0.sendKeys(dateFormat.format(currentDatePlus5));
		ContractFunding.click();
		// ContractFundingStartDate.sendKeys(dateFormat.format(currentDatePlusOne));
		// ContractFundingEndDates0.sendKeys(dateFormat.format(currentDatePlustwo));
		ContractFundingStartDate.sendKeys(dateFormat.format(currentDatePlusOne));

		ContractFundingEndDates0.sendKeys(dateFormat.format(currentDateMinus1));
		FinancialAssistanceFunding.click();
		FinancialAssistanceFundingStartDate.sendKeys(dateFormat.format(currentDatePlus));
		FinancialAssistanceFundingEndDates0.sendKeys(dateFormat.format(currentDatePlus5));
		Thread.sleep(2000);

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

		Thread.sleep(4000);
		((JavascriptExecutor) driver).executeScript("scroll(0,400)");
		Thread.sleep(5000);
	}

	public boolean valStartDate() {
		boolean verify;

		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy ");

		// get current date time with Date()
		Date date = new Date();
		String StartDate = dateFormat.format(date);
		System.out.println(StartDate);
		Date todaysDate = new Date();

		DateFormat df6 = new SimpleDateFormat("MMM dd, yyyy");
		String str5 = df6.format(todaysDate);
		System.out.println("String in E dd, yyyy format is: " + str5);

		// VALIDATION FOR "YOU"
		WebElement locatorforWhereTEXTisPresentt5 = driver.findElement(By
				.xpath("//*[@id=\"main-container\"]/fh-move-office/div/div/section/fh-move-office-review/div[2]/div"));

		String Requesttext = locatorforWhereTEXTisPresentt5.getText();

		if (Requesttext.contains(str5)) {
			verify = true;
		}

		else {
			verify = false;
		}

		System.out.println(Requesttext);
		return verify;
	}

	public boolean val() throws InterruptedException {
		boolean verify;
		Thread.sleep(4000);
		((JavascriptExecutor) driver).executeScript("scroll(0,600)");

		// VALIDATION FOR "YOU"
		WebElement locatorforWhereTEXTisPresentt5 = driver.findElement(By.xpath(
				"/html/body/app/main/ng-component/div/div/div[2]/page/div/div/div[2]/div/div[1]/div[2]/div/div[1]/div[2]/table/tr[2]"));

		String Requesttext = locatorforWhereTEXTisPresentt5.getText();
		System.out.println("Validate status is === " + Requesttext);
		if (Requesttext.contains("ACTIVE")) {
			verify = true;
		}

		else {
			verify = false;
		}

		System.out.println(Requesttext);
		return verify;
	}

	public boolean val6() {
		boolean verify;
		((JavascriptExecutor) driver).executeScript("scroll(0,600)");

		// VALIDATION FOR "YOU"
		WebElement locatorforWhereTEXTisPresentt5 = driver
				.findElement(By.xpath("//*[@id=\"primary-content\"]/ng-component/div/div[1]/table"));

		String Requesttext = locatorforWhereTEXTisPresentt5.getText();

		if (Requesttext.contains("ACTIVE") && Requesttext.contains("INACTIVE")) {
			verify = true;
		}

		else {
			verify = false;
		}

		System.out.println(Requesttext);
		return verify;
	}

	public boolean valMove() {
		boolean verify;
		((JavascriptExecutor) driver).executeScript("scroll(0,600)");

		// VALIDATION FOR "YOU"
		WebElement locatorforWhereTEXTisPresentt5 = driver.findElement(By.xpath(
				"//*[@id=\"main-container\"]/fh-move-office/div/div/section/fh-move-office-review/div[3]/table/tr[2]"));

		String Requesttext = locatorforWhereTEXTisPresentt5.getText();

		if (Requesttext.contains("ACTIVE")) {
			verify = true;
		}

		else {
			verify = false;
		}

		System.out.println(Requesttext);
		return verify;
	}

	public boolean val2() {
		boolean verify;

		// VALIDATION FOR "YOU"
		WebElement locatorforWhereTEXTisPresentt5 = driver.findElement(By.xpath(
				"//*[@id=\"main-container\"]/ng-component/div/div/div[2]/page/div/div/div[2]/div/div[1]/div[2]/div/div[1]/div[2]/table/tr[3]"));

		String Requesttext = locatorforWhereTEXTisPresentt5.getText();

		if (Requesttext.contains("INACTIVE")) {
			verify = true;
		}

		else {
			verify = false;
		}

		System.out.println(Requesttext);
		return verify;
	}

	public boolean val2Move() {
		boolean verify;

		// VALIDATION FOR "YOU"
		WebElement locatorforWhereTEXTisPresentt5 = driver.findElement(By.xpath(
				"//*[@id=\"main-container\"]/fh-move-office/div/div/section/fh-move-office-review/div[3]/table/tr[3]"));

		String Requesttext = locatorforWhereTEXTisPresentt5.getText();

		if (Requesttext.contains("INACTIVE")) {
			verify = true;
		}

		else {
			verify = false;
		}

		System.out.println(Requesttext);
		return verify;
	}

	public boolean val3() {
		boolean verify;

		// VALIDATION FOR "YOU"
		WebElement locatorforWhereTEXTisPresentt5 = driver.findElement(By.xpath(
				"//*[@id=\"main-container\"]/ng-component/div/div/div[2]/page/div/div/div[2]/div/div[1]/div[2]/div/div[1]/div[2]/table/tr[4]"));

		String Requesttext = locatorforWhereTEXTisPresentt5.getText();

		if (Requesttext.contains("EXPIRED")) {
			verify = true;
		}

		else {
			verify = false;
		}

		System.out.println(Requesttext);
		return verify;
	}

	public boolean val4() {
		boolean verify;

		// VALIDATION FOR "YOU"
		WebElement locatorforWhereTEXTisPresentt5 = driver.findElement(By.xpath(
				"//*[@id=\"main-container\"]/ng-component/div/div/div[2]/page/div/div/div[2]/div/div[1]/div[2]/div/div[1]/div[2]/table/tr[5]"));

		String Requesttext = locatorforWhereTEXTisPresentt5.getText();

		if (Requesttext.contains("INACTIVE")) {
			verify = true;
		}

		else {
			verify = false;
		}

		System.out.println(Requesttext);
		return verify;
	}

	public boolean val4Move() {
		boolean verify;

		// VALIDATION FOR "YOU"
		WebElement locatorforWhereTEXTisPresentt5 = driver.findElement(By.xpath(
				"//*[@id=\"main-container\"]/fh-move-office/div/div/section/fh-move-office-review/div[3]/table/tr[4]"));

		String Requesttext = locatorforWhereTEXTisPresentt5.getText();

		if (Requesttext.contains("INACTIVE")) {
			verify = true;
		}

		else {
			verify = false;
		}

		System.out.println(Requesttext);
		return verify;
	}

	public boolean val5() {
		boolean verify;

		// VALIDATION FOR "YOU"
		WebElement locatorforWhereTEXTisPresentt5 = driver.findElement(By.xpath(
				"//*[@id=\"main-container\"]/fh-move-office/div/div/section/fh-move-office-review/div[3]/table"));

		String Requesttext = locatorforWhereTEXTisPresentt5.getText();

		if (Requesttext.contains("Contract Funding")) {
			verify = false;
		}

		else {
			verify = true;
		}

		System.out.println(Requesttext);
		return verify;
	}

	public void MoveEdit3() throws InterruptedException {

		((JavascriptExecutor) driver).executeScript("scroll(0,200)");

		submit.click();

		TimeUnit.SECONDS.sleep(10);

		Thread.sleep(2000);
		ActionsOffice.click();
		Move.click();
		Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("scroll(0,900)");
		Thread.sleep(1000);
		FHMoveList.click();

		NewParent.click();
		Thread.sleep(3000);
		MoveOffice.click();
	}

	public void MoveEdit4() throws InterruptedException {

		((JavascriptExecutor) driver).executeScript("scroll(0,500)");
		ConfirmMoveOffice.click();
		NoticeYes.click();
		History.click();
	}

	public void MoveEdit5() throws InterruptedException {

		ActionsOffice.click();
		edit2.click();
		// validate

		boolean fname4 = ContractAwardsStateDate.isEnabled();
		System.out.print(fname4);
		Thread.sleep(2000);

		((JavascriptExecutor) driver).executeScript("scroll(0,-800)");

		boolean fname3 = startdate1.isEnabled();
		System.out.print(fname3);

		if (fname3 == false) {
			Thread.sleep(3000);

			((JavascriptExecutor) driver).executeScript("scroll(0,800)");
			OfficeEditConfirmation.click();
			Thread.sleep(3000);

			((JavascriptExecutor) driver).executeScript("scroll(0,700)");
			Thread.sleep(3000);
			((JavascriptExecutor) driver).executeScript("scroll(0,200)");

			submit.click();

			TimeUnit.SECONDS.sleep(10);

			Thread.sleep(2000);
			ActionsOffice.click();
			Move.click();
			Thread.sleep(2000);
			((JavascriptExecutor) driver).executeScript("scroll(0,900)");
			Thread.sleep(1000);
			FHMoveList.click();

			NewParent2.click();
			Thread.sleep(3000);
			MoveOffice.click();
		}

	}

	public void MoveEdit6() throws InterruptedException {
		Thread.sleep(4000);
		Thread.sleep(4000);
		((JavascriptExecutor) driver).executeScript("scroll(0,300)");
		Thread.sleep(3000);
		submit.click();

		TimeUnit.SECONDS.sleep(10);

		Thread.sleep(2000);

		boolean fname3 = History.isEnabled();
		System.out.print(fname3);

		if (fname3 == false) {
			Thread.sleep(3000);
		}

	}

	public void MoveEdit7() throws InterruptedException {
		ActionsOffice.click();
		edit2.click();
		((JavascriptExecutor) driver).executeScript("scroll(0,700)");
		zip.clear();
		zip.sendKeys("36317");
		city.click();
		cityChoice2.click();
		Thread.sleep(3000);
		OfficeEditConfirmation.click();

//	((JavascriptExecutor) driver).executeScript("scroll(0,400)");
		Thread.sleep(3000);
		submit.click();
		Thread.sleep(3000);
		History.click();
	}

	public void MoveEdit8() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"selectOrgHistory\"]/option[1]")).click();
		Thread.sleep(2000);
		ActionsOffice.click();
		Move.click();
		Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("scroll(0,900)");
		Thread.sleep(1000);
		FHMoveList.click();

		NewParent.click();
		Thread.sleep(3000);
		MoveOffice.click();
	}

	public void fh() {
		FHBreadcrumbLink.click();
	}

	public void VersionClick() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"selectOrgHistory\"]/option[2]")).click();
		Thread.sleep(3000);
	}

	public void VersionClick2() {
		driver.findElement(By.xpath("//*[@id=\"selectOrgHistory\"]/option[3]")).click();
	}

	public void VersionClick3() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"selectOrgHistory\"]/option[1]")).click();
		Thread.sleep(3000);
	}

	public void NoEndDateVal() throws InterruptedException {

		Thread.sleep(1000);

		FHsEARCH.clear();
		FHsEARCH.sendKeys("JFFJ");
		Thread.sleep(3000);
		FHsEARCH.sendKeys(Keys.ENTER);
		((JavascriptExecutor) driver).executeScript("scroll(0,400)");
		Thread.sleep(5000);
		MoveSubtier.click();
		CreateOffice.click();

		Random rand = new Random();
		int result = rand.nextInt(10000);
		randomAac = "77" + result;
		Thread.sleep(2000);
		Aac.sendKeys(randomAac);
		Thread.sleep(3000);

		Random rand2 = new Random();
		float result2 = rand2.nextFloat();
		randomOfficeTitle = "Test Office for move " + result2;

		ofcName.sendKeys(randomOfficeTitle);
		Thread.sleep(1000);

		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy ");

		// get current date time with Date()
		Date date = new Date();
		String StartDate = dateFormat.format(date);
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DATE, -2);
		Date currentDatePlusOne = c.getTime();

		startdate1.sendKeys(dateFormat.format(currentDatePlusOne));

		// convert calendar to date
		c.add(Calendar.DATE, +5);
		Date currentDatePlus5 = c.getTime();

		// enddate1.sendKeys(dateFormat.format(currentDatePlus5));
		Thread.sleep(3000);
		// manipulate date

		c.add(Calendar.DATE, -4);
		Date currentDateMinus1 = c.getTime();

		c.add(Calendar.DATE, +2);
		Date currentDatePlus = c.getTime();

		// convert calen

		// convert calendar to date

		// convert calendar to date

		ContractAwards.click();
		ContractAwardsStateDate.sendKeys((StartDate));
		// ContractAwardsEndDate0.sendKeys(dateFormat.format(currentDatePlus5));

		FinancialAssistanceAwards.click();
		FinancialAssistanceAwardsStartDate.sendKeys(dateFormat.format(currentDatePlus));
		// FinancialAssistanceAwardsEnd0.sendKeys(dateFormat.format(currentDatePlus5));
		ContractFunding.click();
		// ContractFundingStartDate.sendKeys(dateFormat.format(currentDatePlusOne));
		// ContractFundingEndDates0.sendKeys(dateFormat.format(currentDatePlustwo));
		ContractFundingStartDate.sendKeys(dateFormat.format(currentDatePlusOne));

		// ContractFundingEndDates0.sendKeys(dateFormat.format(currentDateMinus1));
		FinancialAssistanceFunding.click();
		FinancialAssistanceFundingStartDate.sendKeys(dateFormat.format(currentDatePlus));
		// FinancialAssistanceFundingEndDates0.sendKeys(dateFormat.format(currentDatePlus5));
		Thread.sleep(2000);

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

		Thread.sleep(4000);
		((JavascriptExecutor) driver).executeScript("scroll(0,400)");
		Thread.sleep(4000);
	}

	public void NoEndDateVal2() throws InterruptedException {
		((JavascriptExecutor) driver).executeScript("scroll(0,200)");
		Thread.sleep(4000);

		submit.click();

		TimeUnit.SECONDS.sleep(10);

		Thread.sleep(2000);
	}

	public boolean NoEndDateVal3() throws InterruptedException {

		boolean verify;

		// VALIDATION FOR "YOU"
		WebElement locatorforWhereTEXTisPresentt5 = driver.findElement(By.id("Contract_Awards"));

		String Requesttext = locatorforWhereTEXTisPresentt5.getText();

		if (Requesttext.contains("//*[@id=\"Contract_Awards\"]/td[3]")) {
			verify = false;
		}

		else {
			verify = true;
		}

		System.out.println(Requesttext);
		return verify;
	}

	public boolean NoEndDateVal4() throws InterruptedException {

		boolean verify;

		// VALIDATION FOR "YOU"
		WebElement locatorforWhereTEXTisPresentt5 = driver.findElement(By.id("Financial_Assistance_Awards"));

		String Requesttext = locatorforWhereTEXTisPresentt5.getText();

		if (Requesttext.contains("//*[@id=\"Financial_Assistance_Awards\"]/td[3]")) {
			verify = false;
		}

		else {
			verify = true;
		}

		System.out.println(Requesttext);
		return verify;

	}

	public boolean NoEndDateVal5() throws InterruptedException {

		boolean verify;

		// VALIDATION FOR "YOU"
		WebElement locatorforWhereTEXTisPresentt5 = driver.findElement(By.id("Contract_Funding"));

		String Requesttext = locatorforWhereTEXTisPresentt5.getText();

		if (Requesttext.contains("//*[@id=\"Contract_Funding\"]/td[3]")) {
			verify = false;
		}

		else {
			verify = true;
		}

		System.out.println(Requesttext);
		return verify;

	}

	public boolean NoEndDateVal6() throws InterruptedException {

		boolean verify;

		// VALIDATION FOR "YOU"
		WebElement locatorforWhereTEXTisPresentt5 = driver.findElement(By.id("Financial_Assistance_Funding"));

		String Requesttext = locatorforWhereTEXTisPresentt5.getText();

		if (Requesttext.contains("//*[@id=\"Financial_Assistance_Funding\"]/td[3]")) {
			verify = false;
		}

		else {
			verify = true;
		}

		System.out.println(Requesttext);
		return verify;

	}

	public boolean NoEndDateVal7() throws InterruptedException {
		((JavascriptExecutor) driver).executeScript("scroll(0,300)");
		Thread.sleep(2000);
		boolean verify;

		// VALIDATION FOR "YOU"
		WebElement locatorforWhereTEXTisPresentt5 = driver
				.findElement(By.xpath("//*[@id='primary-content']/ng-component/div/div[1]/div[5]/div[3]"));

		String Requesttext = locatorforWhereTEXTisPresentt5.getText();

		if (Requesttext.contains("No End Date Available")) {
			verify = true;
		}

		else {
			verify = false;
		}

		System.out.println(Requesttext);
		return verify;

	}

	public boolean NoEndDateVal70() throws InterruptedException {
		((JavascriptExecutor) driver).executeScript("scroll(0,300)");
		Thread.sleep(2000);
		boolean verify;

		// VALIDATION FOR "YOU"
		WebElement locatorforWhereTEXTisPresentt5 = driver.findElement(By.id("primary-content"));

		String Requesttext = locatorforWhereTEXTisPresentt5.getText();

		if (Requesttext.contains("No End Date Available")) {
			verify = true;
		}

		else {
			verify = false;
		}

		System.out.println(Requesttext);
		return verify;

	}

	public boolean NoEndDateVal8() throws InterruptedException {

		boolean verify;

		// VALIDATION FOR "YOU"
		WebElement locatorforWhereTEXTisPresentt5 = driver.findElement(By.id("selectOrgHistory"));

		String Requesttext = locatorforWhereTEXTisPresentt5.getText();

		if (Requesttext.contains("Current")) {
			verify = true;
		}

		else {
			verify = false;
		}

		System.out.println(Requesttext);
		return verify;
	}

	public boolean BreadcrumbValidationPreMove() {
		boolean verify;

		// VALIDATION FOR "YOU"
		WebElement locatorforWhereTEXTisPresentt5 = driver
				.findElement(By.xpath("//*[@id=\"main-container\"]/ng-component/div/sam-breadcrumbs/ul"));

		String Requesttext = locatorforWhereTEXTisPresentt5.getText();

		if (Requesttext.contains("TEST")) {
			verify = true;
		}

		else {
			verify = false;
		}

		System.out.println(Requesttext);
		return verify;
	}

	public void NoEndDateMove() throws InterruptedException {
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(2000);
		ActionsOffice.click();
		Move.click();
		Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("scroll(0,900)");
		Thread.sleep(1000);
		FHMoveList.click();

		NewParent.click();
		Thread.sleep(3000);
		MoveOffice.click();

		((JavascriptExecutor) driver).executeScript("scroll(0,500)");
	}

	public void NoEndDateMove0() throws InterruptedException {
		ActionsOffice.click();
		Move.click();
		Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("scroll(0,900)");
		Thread.sleep(1000);
		FHMoveList.click();

		NewParent2.click();
		Thread.sleep(3000);
		MoveOffice.click();

		((JavascriptExecutor) driver).executeScript("scroll(0,500)");
	}

	public void NoEndDateMove2() throws InterruptedException {
		ConfirmMoveOffice.click();
		NoticeYes.click();
		Thread.sleep(3000);
		History.click();
	}

	public boolean valStartDateNeg() {
		boolean verify;

		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy ");

		// get current date time with Date()
		Date date = new Date();
		String StartDate = dateFormat.format(date);
		System.out.println(StartDate);
		Date todaysDate = new Date();

		DateFormat df6 = new SimpleDateFormat("MMM dd, yyyy");
		String str5 = df6.format(todaysDate);
		System.out.println("String in E dd, yyyy format is: " + str5);

		// VALIDATION FOR "YOU"
		WebElement locatorforWhereTEXTisPresentt5 = driver.findElement(By
				.xpath("//*[@id=\"main-container\"]/fh-move-office/div/div/section/fh-move-office-review/div[2]/div"));

		String Requesttext = locatorforWhereTEXTisPresentt5.getText();

		if (Requesttext.contains(str5)) {
			verify = true;
		}

		else {
			verify = false;
		}

		System.out.println(Requesttext);
		return verify;
	}

	public boolean Newl2() {
		boolean verify;

		// VALIDATION FOR "YOU"
		WebElement locatorforWhereTEXTisPresentt5 = driver.findElement(By
				.xpath("//*[@id=\"main-container\"]/fh-move-office/div/div/section/fh-move-office-review/div[2]/div"));

		String Requesttext = locatorforWhereTEXTisPresentt5.getText();

		if (Requesttext.contains("VEST") && Requesttext.contains("SUBTIER")) {
			verify = true;
		}

		else {
			verify = false;
		}

		System.out.println(Requesttext);
		return verify;
	}

	public boolean valStartDateNoEndDate() {
		boolean verify;

		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy ");

		// get current date time with Date()
		Date date = new Date();
		String StartDate = dateFormat.format(date);
		System.out.println(StartDate);
		Date todaysDate = new Date();

		DateFormat df6 = new SimpleDateFormat("MMM dd, yyyy");
		String str5 = df6.format(todaysDate);
		System.out.println("String in E dd, yyyy format is: " + str5);

		// VALIDATION FOR "YOU"
		WebElement locatorforWhereTEXTisPresentt5 = driver.findElement(
				By.xpath("//*[@id=\"main-container\"]/fh-move-office/div/div/section/fh-move-office-review/div[3]"));

		String Requesttext = locatorforWhereTEXTisPresentt5.getText();

		if (Requesttext.contains(str5)) {
			verify = true;
		}

		else {
			verify = false;
		}

		System.out.println(Requesttext);
		return verify;
	}

	public boolean valStartDateNoEndDate2() {
		boolean verify;

		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy ");

		// get current date time with Date()
		Date date = new Date();
		String StartDate = dateFormat.format(date);
		System.out.println(StartDate);
		Date todaysDate = new Date();

		DateFormat df6 = new SimpleDateFormat("MMM dd, yyyy");
		String str5 = df6.format(todaysDate);
		System.out.println("String in E dd, yyyy format is: " + str5);

		// VALIDATION FOR "YOU"
		WebElement locatorforWhereTEXTisPresentt5 = driver.findElement(
				By.xpath("//*[@id=\"main-container\"]/fh-move-office/div/div/section/fh-move-office-review/div[2]"));

		String Requesttext = locatorforWhereTEXTisPresentt5.getText();

		if (Requesttext.contains(str5)) {
			verify = true;
		}

		else {
			verify = false;
		}

		System.out.println(Requesttext);
		return verify;
	}

	public boolean valStartDateNoEndDate3() {
		boolean verify;

		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy ");

		// get current date time with Date()
		Date date = new Date();
		String StartDate = dateFormat.format(date);
		System.out.println(StartDate);
		Date todaysDate = new Date();

		DateFormat df6 = new SimpleDateFormat("MMM dd, yyyy");
		String str5 = df6.format(todaysDate);
		System.out.println("String in E dd, yyyy format is: " + str5);

		// VALIDATION FOR "YOU"
		WebElement locatorforWhereTEXTisPresentt5 = driver
				.findElement(By.xpath("//*[@id=\"primary-content\"]/ng-component/div/div[1]/table"));

		String Requesttext = locatorforWhereTEXTisPresentt5.getText();

		if (Requesttext.contains(str5)) {
			verify = true;
		}

		else {
			verify = false;
		}

		System.out.println(Requesttext);
		return verify;
	}

	public boolean valStartDateNoEndDate4() {
		boolean verify;

		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy ");

		// get current date time with Date()
		Date date = new Date();
		String StartDate = dateFormat.format(date);
		System.out.println(StartDate);
		Date todaysDate = new Date();

		DateFormat df6 = new SimpleDateFormat("MMM dd, yyyy");
		String str5 = df6.format(todaysDate);
		System.out.println("String in E dd, yyyy format is: " + str5);

		// VALIDATION FOR "YOU"
		WebElement locatorforWhereTEXTisPresentt5 = driver
				.findElement(By.xpath("//*[@id=\"primary-content\"]/ng-component/div/div[1]/div[5]/div[2]/span[2]"));

		String Requesttext = locatorforWhereTEXTisPresentt5.getText();

		if (Requesttext.contains(str5)) {
			verify = true;
		}

		else {
			verify = false;
		}

		System.out.println(Requesttext);
		return verify;
	}

	public boolean valStartDateNeg2() {
		boolean verify;

		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy ");

		// get current date time with Date()
		Date date = new Date();
		String StartDate = dateFormat.format(date);
		System.out.println(StartDate);
		Date todaysDate = new Date();

		DateFormat df6 = new SimpleDateFormat("MMM dd, yyyy");
		String str5 = df6.format(todaysDate);
		System.out.println("String in E dd, yyyy format is: " + str5);

		// VALIDATION FOR "YOU"
		WebElement locatorforWhereTEXTisPresentt5 = driver
				.findElement(By.xpath("//*[@id=\"primary-content\"]/fh-office-profile-history/div/div[3]/div[8]"));

		String Requesttext = locatorforWhereTEXTisPresentt5.getText();

		if (Requesttext.contains(str5)) {
			verify = false;
		}

		else {
			verify = true;
		}

		System.out.println(Requesttext);
		return verify;
	}

	public boolean valStartDateNeg3() {
		boolean verify;

		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy ");

		// get current date time with Date()
		Date date = new Date();
		String StartDate = dateFormat.format(date);
		System.out.println(StartDate);
		Date todaysDate = new Date();

		DateFormat df6 = new SimpleDateFormat("MMM dd, yyyy");
		String str5 = df6.format(todaysDate);
		System.out.println("String in E dd, yyyy format is: " + str5);

		// VALIDATION FOR "YOU"
		WebElement locatorforWhereTEXTisPresentt5 = driver
				.findElement(By.xpath("//*[@id=\"primary-content\"]/fh-office-profile-history/div/div[3]/div[10]"));

		String Requesttext = locatorforWhereTEXTisPresentt5.getText();

		if (Requesttext.contains(str5)) {
			verify = true;
		}

		else {
			verify = false;
		}

		System.out.println(Requesttext);
		return verify;
	}

	public boolean UpdatedVal() {

		boolean verify;
		((JavascriptExecutor) driver).executeScript("scroll(0,500)");

		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy ");

		// get current date time with Date()
		Date date = new Date();
		String StartDate = dateFormat.format(date);
		System.out.println(StartDate);
		Date todaysDate = new Date();

		DateFormat df6 = new SimpleDateFormat("MMM dd, yyyy");
		String str5 = df6.format(todaysDate);
		System.out.println("String in E dd, yyyy format is: " + str5);

		// VALIDATION FOR "YOU"
		WebElement locatorforWhereTEXTisPresentt5 = driver
				.findElement(By.xpath("//*[@id=\"primary-content\"]/fh-office-profile-history/div/div[5]/table/tr[2]"));

		String Requesttext = locatorforWhereTEXTisPresentt5.getText();

		if (Requesttext.contains(str5) && Requesttext.contains("EXPIRED")) {
			verify = true;
		}

		else {
			verify = false;
		}

		System.out.println(Requesttext);
		return verify;
	}
}
