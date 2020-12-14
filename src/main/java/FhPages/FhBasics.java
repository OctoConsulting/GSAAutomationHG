package FhPages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import util.TestBase;

public class FhBasics extends TestBase {
	@FindBy(xpath = "//*[@id=\"main-container\"]/sam-t1-workspace/div/div[1]/sam-widget-space/div/sam-workspace-fh-widget/div/div[2]/label")
	WebElement FHfromWorkspace;
	@FindBy(id = "fh-search-link")
	WebElement FHbUTTONfromWorkspace;
	@FindBy(xpath="//*[@id=\"main-container\"]/sam-t1-workspace/div/div[1]/sam-widget-space/div/workspace-fh-widget/div/div[2]/div[3]/div[1]/div[2]")
	WebElement FHbUTTONfromWorkspaceCount;
	@FindBy(id = "fh-landing-link")
	WebElement FHbUTTONfromWorkspace2;
	@FindBy(xpath = "//button[text()='Create Dept/Ind Agency']")
	WebElement CreateDeptAgencytab;
	@FindBy(xpath = "//label[text()='Organizations that I administer']")
	WebElement NonPmoBanner;
	@FindBy(xpath = "//div[@class=\"usa-width-one-whole\"]")
	WebElement NonPmoBanner2;
	@FindBy(xpath = "//input[@aria-label=\"search federal hierarchy\"]")
	WebElement FHsEARCH;
	@FindBy(xpath = "//div[text()=' Showing  1-10  of  10  results ']")
	WebElement ResultDOD;

	@FindBy(xpath = "//div[text()=' Showing  1-2  of  2  results ']")
	WebElement ResultIAE;
	@FindBy(xpath = "//a[@href=\"/fh/300000001\"]")
	WebElement ResultLegislative;
	@FindBy(xpath = "/html/body/app/main/ng-component/div[1]/div/div[4]/div/div[2]/div/div[2]/div[1]/a")
	WebElement POLICEPROCUREMENT;
	@FindBy(xpath = "//*[@id=\"main-container\"]/ng-component/div[1]/div/div[4]/div/div[2]/div/div[2]/div[1]/a")
	WebElement ActionDep;
	@FindBy(xpath = "//*[@id=\"main-container\"]/ng-component/div[1]/div/div[4]/div/div[2]/div/div[2]/div[1]/a")
	WebElement USDep;
	@FindBy(xpath = "//*[@id=\"main-container\"]/ng-component/div[1]/div/div[4]/div/div[2]/div/div[2]/div[1]/a")
	WebElement DEPT26Dep;
	@FindBy(xpath = "//span[text()=' 47QDCA ']")
	WebElement ResultIAE2;
	@FindBy(xpath = "//*[text()='075']")
	WebElement ResultHHR;
	@FindBy(xpath = "//span[text()=' 1625RJ ']")
	WebElement ResultDOL;
	@FindBy(xpath = "//*[text()='4732']")
	WebElement ResultGSAL2;
	@FindBy(xpath = "//a[text()='Clear Filters']")
	WebElement ClearFH;
	@FindBy(id = "Active")
	WebElement active;
	@FindBy(id = "Inactive")
	WebElement inactivetab;
	@FindBy(id = "Dept/Ind Agency")
	WebElement DEPtab;
	@FindBy(id = "Sub-Tier")
	WebElement subtiertab;
	@FindBy(id = "Office")
	WebElement OFFICEtab;
	@FindBy(xpath = "//i[@class=\"fa fa-user ng-star-inserted\"]")
	WebElement AdministratorIcon;
	@FindBy(xpath = "//a[@href='/fh/100006809']")
	WebElement randomdep;
	@FindBy(xpath = "//button[text()=' Create Sub-Tier ']")
	WebElement CreateSubtierTab;
	@FindBy(xpath = "//a[text()='Sub-Tiers']")
	WebElement EnterSubtierTab;
	@FindBy(id = "undefined-select")
	WebElement ItemsPerPage;
	@FindBy(xpath = "//option[text()=' 10 ']")
	WebElement IPP10;
	@FindBy(xpath = "//option[text()=' 25 ']")
	WebElement IPP25;
	@FindBy(xpath = "//option[text()=' 50 ']")
	WebElement IPP50;
	@FindBy(xpath = "//span[text()=' 1 – 25 of 65 ']")
	WebElement IPP25Validation;
	@FindBy(xpath = "//span[text()=' 1 – 25 of 45 ']")
	WebElement IPP25Validation2;
	@FindBy(xpath = "//span[text()=' 1 – 50 of 83 ']")
	WebElement IPP50Validation;
	@FindBy(xpath = "//a[@title=\"sort\"]")
	WebElement Sorttab;
	@FindBy(xpath = "//a[@href=\"/fh/100128542\"]")
	WebElement SortValidation;
	@FindBy(xpath = "//a[@href=\"/fh/100170375\"]")
	WebElement SortValidation2;
	@FindBy(xpath = "//a[text()='3']")
	WebElement Page3;
	@FindBy(xpath = "//a[text()='1']")
	WebElement Page1;
	@FindBy(id = "sort-select")
	WebElement SortBy;
	@FindBy(xpath = "//*[text()='12K4']")
	WebElement SortByACvalidation;
	@FindBy(xpath = "//a[@href=\"/fh/100170377\"]")
	WebElement SortByACvalidation2;

	@FindBy(xpath = "//option[text()='Agency Code']")
	WebElement SortByAgencyCode;

	@FindBy(xpath = "//option[text()='AAC']")
	WebElement SortByAAC;
	@FindBy(xpath = "//a[@href=\"/fh/100077314\"]")
	WebElement RandomL2;

	@FindBy(xpath = "//button[text()=' Create Office ']")
	WebElement CreateOfficeTab;
	

	@FindBy(xpath = "//a[text()='Offices']")
	WebElement OfficeTab;
	@FindBy(xpath = "//a[@href=\"/fh/500001466\"]")
	WebElement RandomOffice;
	@FindBy(id="menuitem0")
	WebElement EditOfficeTab;
	@FindBy(xpath = "//a[@href=\"/fh/300000232\"]")
	WebElement IntoNEGOffice;
	@FindBy(xpath = "//a[@href=\"/fh/300000221\"]")
	WebElement GSAL2;

	@FindBy(xpath = "//a[text()='Federal Hierarchy']")
	WebElement FederalHierarchyBreadcrumb;
	@FindBy(xpath = "//a[@href=\"/fh/100120624\"]")
	WebElement FASL2;
	@FindBy(xpath = "//*[@id=\"main-container\"]/ng-component/page/div/div/div[2]/div[2]/section/ng-component/div/results/table/tbody/tr/td[1]/div[1]")
	WebElement EntityOcto;
	@FindBy(id="actionsButton")
	WebElement ActionsOffice;

	public FhBasics() {
		PageFactory.initElements(driver, this);
	}

	public void intoGSAL2() throws InterruptedException {
		((JavascriptExecutor) driver).executeScript("scroll(0,300)");
		Thread.sleep(2000);
		GSAL2.click();
		Thread.sleep(2000);

	}

	public void intoFederalHierarchybreadcrumb() throws InterruptedException {

		Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("scroll(0,-300)");

		FederalHierarchyBreadcrumb.click();
		Thread.sleep(2000);

	}

	public void intoFASL2() throws InterruptedException {

		Thread.sleep(2000);
		FASL2.click();
		Thread.sleep(2000);

	}

	public void intoNEGArAndomOffice() throws InterruptedException {

		Thread.sleep(2000);
		IntoNEGOffice.click();
		Thread.sleep(2000);

	}

	public boolean IsEditOfficeTabThere() throws InterruptedException {
		Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("scroll(0,300)");
		try {
			return EditOfficeTab.isDisplayed();
		} catch (Exception ex) {
			System.out.println("working as desired");
		}
		return false;
	}

	public boolean IsEntityThere() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"profile-details-link\"]")).click();
		Thread.sleep(2000);
	//	driver.findElement(By.xpath("//*[@id=\"header-link-profile\"]")).click();
		//Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"main-container\"]/ng-component/page/div/div/div[2]/div[1]/sidebar/sam-sidenav/div/a[2]/div/div")).click();
	
		Thread.sleep(2000);
	
		((JavascriptExecutor) driver).executeScript("scroll(0,300)");
		try {
			return EntityOcto.isDisplayed();
		} catch (Exception ex) {
			System.out.println("working as desired");
		}
		return false;
	}

	public void intoArAndomOffice() throws InterruptedException {

		Thread.sleep(2000);
		RandomOffice.click();
		
		Thread.sleep(3000);
		ActionsOffice.click();
		

	}

	public void intoFH() throws InterruptedException {

		Thread.sleep(2000);
		FHbUTTONfromWorkspace.click();
		Thread.sleep(2000);
	}

	public boolean IsIPPworking() {
		return IPP10.isDisplayed();

	}

	public boolean IsIPPworking2() {
		return IPP25.isDisplayed();

	}

	public boolean IsIPPworking3() {
		return IPP50.isDisplayed();

	}

	public void IsIPPworking25() throws InterruptedException {

		Thread.sleep(4000);
		IPP25.click();
		Thread.sleep(4000);

		((JavascriptExecutor) driver).executeScript("scroll(0,20060)");
		Thread.sleep(4000);

	}

	public void IsIPPworking50() throws InterruptedException {

		Thread.sleep(4000);
		IPP50.click();
		Thread.sleep(4000);

		((JavascriptExecutor) driver).executeScript("scroll(0,20060)");
		Thread.sleep(4000);

	}

	public boolean IsIPPworking25Validation() {
		return IPP25Validation.isDisplayed();

	}

	public boolean IsIPPworking25Validation2() {
		return IPP25Validation2.isDisplayed();

	}

	public boolean IsIPPworking50Validation() {
		return IPP50Validation.isDisplayed();

	}

	public boolean IsFhLinkThereNONfh() {
		((JavascriptExecutor) driver).executeScript("scroll(0,-700)");
		try {
			return FHbUTTONfromWorkspace.isDisplayed();
		} catch (Exception ex) {
			System.out.println("working as desired");
		}
		return false;
	}

	public void intoFHnonFHmember() throws InterruptedException {
		((JavascriptExecutor) driver).executeScript("scroll(0,200)");
		Thread.sleep(2000);
		FHbUTTONfromWorkspace2.click();
		Thread.sleep(2000);
	}

	public void SearchDEFENSE() throws InterruptedException {
		FHsEARCH.sendKeys("department of defense");
		Thread.sleep(3000);
		FHsEARCH.sendKeys(Keys.ENTER);
		// ((JavascriptExecutor) driver).executeScript("scroll(0,200)");
		Thread.sleep(5000);
	}

	public void clearFH() throws InterruptedException {
		((JavascriptExecutor) driver).executeScript("scroll(0,200)");
		ClearFH.click();

		Thread.sleep(2000);
	}

	public void SearchIAE() throws InterruptedException {
		FHsEARCH.clear();
		// ((JavascriptExecutor) driver).executeScript("scroll(0,-400)");
		FHsEARCH.sendKeys("integrated award environment");
		Thread.sleep(3000);
		FHsEARCH.sendKeys(Keys.ENTER);
		((JavascriptExecutor) driver).executeScript("scroll(0,200)");
	}

	public void SearchHHR() throws InterruptedException {
		FHsEARCH.clear();
		// ((JavascriptExecutor) driver).executeScript("scroll(0,-400)");
		FHsEARCH.sendKeys("health and human services");
		Thread.sleep(3000);
		FHsEARCH.sendKeys(Keys.ENTER);
		((JavascriptExecutor) driver).executeScript("scroll(0,200)");
	}
	public void IntoHHR() throws InterruptedException {
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@href=\"/fh/100004222\"]")).click();
		;
	}
public void InGSA2() throws InterruptedException {
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@href=\"/fh/100120624\"]")).click();
		;
	}


	public void SearchDOLL3() throws InterruptedException {
		FHsEARCH.clear();
		// ((JavascriptExecutor) driver).executeScript("scroll(0,-400)");
		FHsEARCH.sendKeys("DOL(BLS) SAN FRANCISCO REGIONAL OFC");
		Thread.sleep(3000);
		FHsEARCH.sendKeys(Keys.ENTER);
		((JavascriptExecutor) driver).executeScript("scroll(0,200)");
	}

	public void SearchGSAL2() throws InterruptedException {
		FHsEARCH.clear();
		// ((JavascriptExecutor) driver).executeScript("scroll(0,-400)");
		FHsEARCH.sendKeys("FEDERAL ACQUISITION SERVICE");
		Thread.sleep(3000);
		FHsEARCH.sendKeys(Keys.ENTER);
		((JavascriptExecutor) driver).executeScript("scroll(0,200)");
	}
	
	public void SearchLegislativeBranch() throws InterruptedException {
		FHsEARCH.clear();
		// ((JavascriptExecutor) driver).executeScript("scroll(0,-400)");
		FHsEARCH.sendKeys("THE LEGISLATIVE BRANCH");
		Thread.sleep(3000);
		FHsEARCH.sendKeys(Keys.ENTER);
		((JavascriptExecutor) driver).executeScript("scroll(0,200)");
	}
	public void SearchPOLICEPROCUREMENT() throws InterruptedException {
		FHsEARCH.clear();
		// ((JavascriptExecutor) driver).executeScript("scroll(0,-400)");
		FHsEARCH.sendKeys("US CAPITOL POLICE PROCUREMENT");
		Thread.sleep(3000);
		FHsEARCH.sendKeys(Keys.ENTER);
		Thread.sleep(2000);

		((JavascriptExecutor) driver).executeScript("scroll(0,300)");
		inactivetab.click();
		active.click();
		Thread.sleep(4000);
	}
	public void SearchAction() throws InterruptedException {
		FHsEARCH.clear();
		// ((JavascriptExecutor) driver).executeScript("scroll(0,-400)");
		FHsEARCH.sendKeys("action");
		Thread.sleep(3000);
		FHsEARCH.sendKeys(Keys.ENTER);
		((JavascriptExecutor) driver).executeScript("scroll(0,200)");
	}
	public void SearchUS() throws InterruptedException {
		FHsEARCH.clear();
		// ((JavascriptExecutor) driver).executeScript("scroll(0,-400)");
		FHsEARCH.sendKeys("UNITED STATES TRADE AND DEVELOPMENT AGENCY");
		Thread.sleep(3000);
		FHsEARCH.sendKeys(Keys.ENTER);
		((JavascriptExecutor) driver).executeScript("scroll(0,200)");
	}
	public void SearchDEPT26() throws InterruptedException {
		FHsEARCH.clear();
		// ((JavascriptExecutor) driver).executeScript("scroll(0,-400)");
		FHsEARCH.sendKeys("DEPT_26'IP");
		Thread.sleep(3000);
		FHsEARCH.sendKeys(Keys.ENTER);
		((JavascriptExecutor) driver).executeScript("scroll(0,200)");
	}

	public boolean isFHthereFHuser() {
		((JavascriptExecutor) driver).executeScript("scroll(0,700)");
		try {

			return FHbUTTONfromWorkspace.isDisplayed();
		} catch (Exception ex) {
			System.out.println("working as desired");
		}
		return false;
	}
	public boolean isFhCountThere() {
		((JavascriptExecutor) driver).executeScript("scroll(0,700)");
		try {

			return FHbUTTONfromWorkspaceCount.isDisplayed();
		} catch (Exception ex) {
			System.out.println("working as desired");
		}
		return false;
	}
	public boolean PMOisthere() {

		return CreateDeptAgencytab.isDisplayed();
	}

	public boolean ADiconThere() {
		((JavascriptExecutor) driver).executeScript("scroll(0,5000)");
		try {

			return AdministratorIcon.isDisplayed();
		} catch (Exception ex) {
			System.out.println("working as desired");
		}
		return false;

	}

	public void IntoNextPage3() throws InterruptedException {
		Page3.click();
		Thread.sleep(3000);
		((JavascriptExecutor) driver).executeScript("scroll(0,500)");
	}

	public void IntoNextPage1() throws InterruptedException {
		Page1.click();
		Thread.sleep(3000);
		((JavascriptExecutor) driver).executeScript("scroll(0,500)");
	}

	public boolean Creat() {

		return CreateDeptAgencytab.isDisplayed();
	}

	public boolean IsDeptAdminSubTierAdmin() {
		((JavascriptExecutor) driver).executeScript("scroll(0,300)");
		try {
			return NonPmoBanner.isDisplayed();
		} catch (Exception ex) {
			System.out.println("working as desired");
		}
		return false;
	}

	public void FhNonPmoAdmin() {
		boolean verify;
		// VALIDATION FOR "YOU"
		WebElement locatorforWhereTEXTisPresent = driver
				.findElement(By.xpath("//div[@class=\"p_L-3x p_T-2x usa-width-one-whole\"]"));
		String BannerForNonPMO = locatorforWhereTEXTisPresent.getText();
		if (BannerForNonPMO.contains("Organizations that I administer")) {
			verify = true;
		}

		else {
			verify = false;
		}

	}

	public boolean NONfhUser() {
		boolean verify;
		// VALIDATION FOR "YOU"
		WebElement locatorforWhereTEXTisPresent = driver
				.findElement(By.xpath("//div[@class=\"p_L-3x p_T-2x usa-width-one-whole\"]"));
		String BannerForNonPMO = locatorforWhereTEXTisPresent.getText();
		if (BannerForNonPMO.contains("My Department")) {
			verify = true;
		}

		else {
			verify = false;
		}
		return verify;

	}

	public boolean DeptDefenseDataThere() {
		return ResultDOD.isDisplayed();
	}

	public boolean IAEDataThere() {
		try {
			return ResultIAE.isDisplayed();

		} catch (Exception ex) {
			System.out.println("working as desired");
		}
		return false;
	}
	public boolean LegislativeDataThere() {
		try {
			return ResultLegislative.isDisplayed();

		} catch (Exception ex) {
			System.out.println("working as desired");
		}
		return false;
	}
	public boolean POLICEPROCUREMENTDataThere() {
		try {
			return POLICEPROCUREMENT.isDisplayed();

		} catch (Exception ex) {
			System.out.println("working as desired");
		}
		return false;
	}
	public boolean ActionDataThere() {
		try {
			return ActionDep.isDisplayed();

		} catch (Exception ex) {
			System.out.println("working as desired");
		}
		return false;
	}
	public boolean USDataThere() {
		try {
			return USDep.isDisplayed();

		} catch (Exception ex) {
			System.out.println("working as desired");
		}
		return false;
	}
	public boolean DEPT26There() {
		try {
			return DEPT26Dep.isDisplayed();

		} catch (Exception ex) {
			System.out.println("working as desired");
		}
		return false;
	}
	public boolean HHRDataThere() {
		try {
			return ResultHHR.isDisplayed();

		} catch (Exception ex) {
			System.out.println("working as desired");
		}
		return false;
	}

	public boolean IAEDataThere2() {
		try {

			return ResultIAE2.isDisplayed();

		} catch (Exception ex) {
			System.out.println("working as desired");
		}
		return false;
	}

	public boolean DOLDataThere() {
		try {
			return ResultDOL.isDisplayed();

		} catch (Exception ex) {
			System.out.println("working as desired");
		}
		return false;
	}

	public boolean GSAL2DataThere() {
		try {
			return ResultGSAL2.isDisplayed();

		} catch (Exception ex) {
			System.out.println("working as desired");
		}
		return false;
	}

	public boolean DODValidation() {
		boolean verify;
		// VALIDATION FOR "YOU"
		WebElement locatorforWhereTEXTisPresent = driver
				.findElement(By.xpath("//*[@id=\"main-container\"]/ng-component/div[1]/div"));
		String BannerForNonPMO = locatorforWhereTEXTisPresent.getText();
		if (BannerForNonPMO.contains(" HHB2TX")) {
			verify = true;
		}

		else {
			verify = false;
		}

		System.out.println(BannerForNonPMO);
		return verify;

	}

	public void IntoRandomDepPMOvalidation() throws InterruptedException {
		((JavascriptExecutor) driver).executeScript("scroll(0,-200)");
		randomdep.click();
		Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("scroll(0,200)");
	}

	public void IntoRandomSubtier() throws InterruptedException {

		Thread.sleep(2000);
		EnterSubtierTab.click();

		((JavascriptExecutor) driver).executeScript("scroll(0,1000)");

	}

	public boolean isCreateSubtierThere() throws InterruptedException {
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(2000);

		try {
			return CreateSubtierTab.isDisplayed();

		} catch (Exception ex) {
			System.out.println("working as desired");
		}
		return false;

	}

	public void clickActive() throws InterruptedException {

		((JavascriptExecutor) driver).executeScript("scroll(0,300)");

		active.click();
		Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("scroll(0,300)");
	}

	public boolean FHaCTIVE() {
		boolean verify;
		// VALIDATION FOR "YOU"
		WebElement locatorforWhereTEXTisPresent = driver
				.findElement(By.xpath("//div[@class=\"p_L-3x p_T-2x usa-width-three-fourths\"]"));
		String BannerForNonPMO = locatorforWhereTEXTisPresent.getText();
		if (BannerForNonPMO.contains("Active")) {
			verify = true;
		}

		else {
			verify = false;
		}

		System.out.println(BannerForNonPMO);
		return verify;

	}

	public void clickInactive() throws InterruptedException {

		((JavascriptExecutor) driver).executeScript("scroll(0,400)");

		inactivetab.click();
		Thread.sleep(5000);
		((JavascriptExecutor) driver).executeScript("scroll(0,300)");
		Thread.sleep(5000);
	}

	public boolean FHInaCTIVE() {
		boolean verify;
		// VALIDATION FOR "YOU"
		WebElement locatorforWhereTEXTisPresent = driver
				.findElement(By.xpath("//div[@class=\"p_L-3x p_T-2x usa-width-three-fourths\"]"));
		String BannerForNonPMO = locatorforWhereTEXTisPresent.getText();
		if (BannerForNonPMO.contains("Inactive")) {
			verify = true;
		}

		else {
			verify = false;
		}

		System.out.println(BannerForNonPMO);
		return verify;

	}

	public void clickDepTab() throws InterruptedException {
		((JavascriptExecutor) driver).executeScript("scroll(0,100)");
		DEPtab.click();

		Thread.sleep(5000);
		((JavascriptExecutor) driver).executeScript("scroll(0,200)");
		Thread.sleep(2000);
	}

	public void clicksubtierTab() throws InterruptedException {
		((JavascriptExecutor) driver).executeScript("scroll(0,200)");
		subtiertab.click();

		Thread.sleep(5000);
		((JavascriptExecutor) driver).executeScript("scroll(0,200)");
		Thread.sleep(2000);

	}

	public void clickOfficeTab() throws InterruptedException {
		((JavascriptExecutor) driver).executeScript("scroll(0,300)");
		OFFICEtab.click();

		Thread.sleep(5000);
		((JavascriptExecutor) driver).executeScript("scroll(0,200)");
		Thread.sleep(2000);

	}

	public boolean FHDeptTab() throws InterruptedException {
		FHsEARCH.clear();
		FHsEARCH.sendKeys("dept of defense");
		Thread.sleep(3000);
		FHsEARCH.sendKeys(Keys.ENTER);
		// ((JavascriptExecutor) driver).executeScript("scroll(0,200)");
		Thread.sleep(3000);
		boolean verify;
		// VALIDATION FOR "YOU"
		WebElement locatorforWhereTEXTisPresent = driver
				.findElement(By.xpath("//div[@class=\"p_L-3x p_T-2x usa-width-three-fourths\"]"));
		String BannerForNonPMO = locatorforWhereTEXTisPresent.getText();
		if (BannerForNonPMO.contains("Department/Ind. Agency(L1)")) {
			verify = true;
		}

		else {
			verify = false;
		}

		System.out.println(BannerForNonPMO);
		return verify;

	}

	public boolean FHSubtierTab() {
		boolean verify;
		// VALIDATION FOR "YOU"
		WebElement locatorforWhereTEXTisPresent = driver
				.findElement(By.xpath("//div[@class=\"p_L-3x p_T-2x usa-width-three-fourths\"]"));
		String BannerForNonPMO = locatorforWhereTEXTisPresent.getText();
		if (BannerForNonPMO.contains("Sub-Tier(L2)")) {
			verify = true;
		}

		else {
			verify = false;
		}

		System.out.println(BannerForNonPMO);
		return verify;

	}

	public boolean FHOfficeTab() {
		boolean verify;
		// VALIDATION FOR "YOU"
		WebElement locatorforWhereTEXTisPresent = driver
				.findElement(By.xpath("//div[@class=\"p_L-3x p_T-2x usa-width-three-fourths\"]"));
		String BannerForNonPMO = locatorforWhereTEXTisPresent.getText();
		if (BannerForNonPMO.contains("OFFICE(L3)")) {
			verify = true;
		}

		else {
			verify = false;
		}

		System.out.println(BannerForNonPMO);
		return verify;

	}

	public void IntoItemsPerPage() {

		ItemsPerPage.click();
	}

	public void intoSort() throws InterruptedException {

		Thread.sleep(2000);
		Sorttab.click();
		Thread.sleep(3000);
	}

	public boolean isSortingWorking() {

		return SortValidation.isDisplayed();

	}

	public boolean isSortingWorking2() {

		return SortValidation2.isDisplayed();

	}

	public void intoSortBy() throws InterruptedException {

		Thread.sleep(2000);
		SortBy.click();
		Thread.sleep(3000);
	}

	public void intoSortAgencyCode() throws InterruptedException {

		Thread.sleep(2000);
		SortByAgencyCode.click();
		Thread.sleep(3000);
	}

	public void intoSortAAC() throws InterruptedException {

		Thread.sleep(2000);
		SortByAAC.click();
		Thread.sleep(3000);
	}

	public boolean isSortByACWorking() {

		return SortByACvalidation.isDisplayed();
	}

	public boolean isSortByACWorking2() {

		return SortByACvalidation2.isDisplayed();
	}

	public void intoRandomL3ForDEPTadmin() throws InterruptedException {

		Thread.sleep(2000);
		SortByACvalidation2.click();
		ActionsOffice.click();
		Thread.sleep(3000);
	}

	public void intoRandomL2() throws InterruptedException {

		Thread.sleep(2000);
		RandomL2.click();
		
		Thread.sleep(3000);
	
	}

	public boolean isCreateOfficeThere() throws InterruptedException {
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(2000);
		try {
			return CreateOfficeTab.isDisplayed();

		} catch (Exception ex) {
			System.out.println("working as desired");
		}
		return false;

	}

	public void intoRandomOffices() throws InterruptedException {

		Thread.sleep(2000);
		OfficeTab.click();
		Thread.sleep(3000);
		((JavascriptExecutor) driver).executeScript("scroll(0,2400)");
	}

}


