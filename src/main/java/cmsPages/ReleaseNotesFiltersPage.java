package cmsPages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import util.TestBase;

public class ReleaseNotesFiltersPage extends TestBase {

	@FindBy(xpath = "//strong[text()='Release Notes']")
	WebElement rnonworkspace;
	@FindBy(xpath = "//*[@id=\"New\"]")
	WebElement newfilter;
	@FindBy(xpath = "//div[text()='NEW']")
	WebElement isnewfilter;
	@FindBy(xpath = "//h1[@class=\"sam-ui header ng-star-inserted\"]")
	WebElement validateConstantfilter;

	@FindBy(xpath = "//*[@id=\"Published\"]")
	WebElement publishedfilter;
	@FindBy(xpath = "//*[@id=\"main-container\"]/ng-component/page/div/div/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div")
	WebElement validatepublishedfilter;
	@FindBy(xpath = "//*[@id=\"Draft\"]")
	WebElement draftfilter;
	@FindBy(xpath = "//*[@id=\"main-container\"]/ng-component/page/div/div/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div")
	WebElement validatedraftfilter;
	@FindBy(xpath = "//*[@id=\"Archived\"]")
	WebElement archivedfilter;
	@FindBy(xpath = "//*[@id=\"main-container\"]/ng-component/page/div/div/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div")
	WebElement validatearchivefilter;

	@FindBy(xpath = "//*[@id=\"search-term\"]")
	WebElement searchbox;
	@FindBy(xpath = "//a[text()='Clear Filter']")
	WebElement clearsearchbox;
	@FindBy(xpath = "//h4[@class=\"content-title-text ng-star-inserted\"]")
	WebElement searchboxvalue;
	@FindBy(xpath = "//a[@title=\"sort\"]")
	WebElement descendingorder;
	@FindBy(xpath = "//a[@title=\"sort\"]")
	WebElement ascendingorder;

	@FindBy(xpath = "//*[@id='main-container']/ng-component/page/div/div/div[1]/div/sam-breadcrumbs/ul/li[2]/span")
	WebElement CMSbreadcrumb;
	@FindBy(xpath="//a[@title=\"Release Notes\"]")
	WebElement releasenotespage;
	@FindBy(xpath = "//button[@aria-label=\"Expandable links menu. Collapsed. \"and @id=\"headerIconMenu\"]")
	WebElement ExpandableMenu;
	@FindBy(xpath = "//a[@id=\"header-link-workspace\"]")
	WebElement WorkspaceTab;
	@FindBy(xpath="//div[text()='ARCHIVED']")
	WebElement madeArchived;
	@FindBy(xpath="//a[text()='New Glossary']")
	WebElement CreatenewGlossary;
	@FindBy(xpath = "//a[@href=\"/cm/glossary?path=1\"]")
	WebElement backtohomepage;
	@FindBy(xpath = "//button[@id=\"question-done\"]")
	WebElement newfaqdone;
	public ReleaseNotesFiltersPage() {
		PageFactory.initElements(driver, this);
	}

	public void intoReleaseNotes() throws InterruptedException {
		
		rnonworkspace.click();
		Thread.sleep(2000);
	}
	

	// intializing the page objects/elements/
	// means DRIVER PLEASE INTILZE ALL THE GLOBAL VARIABLES ABOVE
	

	public boolean isCMSdisplayed() {
		return CMSbreadcrumb.isDisplayed();

	}
	
	public void clicknewfilter() throws InterruptedException {
		Thread.sleep(1000);
		((JavascriptExecutor) driver).executeScript("scroll(0,400)");
		Thread.sleep(1000);
		newfilter.isEnabled();
		Thread.sleep(1000);
		newfilter.click();

		Thread.sleep(2000);
	}

	public boolean isnewtitledisplayed() {
		return isnewfilter.isDisplayed();

	}

	public void unchecknewfiter() throws InterruptedException {
		Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("scroll(0,400)");
		Thread.sleep(5000);
		newfilter.click();
		Thread.sleep(2000);
	}

	public boolean isnewnotdisplayed() {
		return validateConstantfilter.isDisplayed();

	}

	public void clickpublish() throws InterruptedException {
		((JavascriptExecutor) driver).executeScript("scroll(0,400)");
		publishedfilter.click();

		Thread.sleep(2000);
	}

	public boolean ispublisheddisplayed() {
		return validatepublishedfilter.isDisplayed();

	}

	public void uncheckpublishedfiter() throws InterruptedException {
		((JavascriptExecutor) driver).executeScript("scroll(0,400)");
		publishedfilter.click();
	}

	public boolean ispublishednotdisplayed() {
		return validatepublishedfilter.isDisplayed();
	}

	public void clickdraftfilter() throws InterruptedException {
		((JavascriptExecutor) driver).executeScript("scroll(0,400)");
		draftfilter.click();

		Thread.sleep(2000);
	}

	public boolean isdraftdisplayed() {
		return validatedraftfilter.isDisplayed();

	}

	public void uncheckdraftfiter() throws InterruptedException {
		((JavascriptExecutor) driver).executeScript("scroll(0,400)");
		draftfilter.click();
		Thread.sleep(2000);
	}

	public boolean isdraftnotdisplayed() {
		return validateConstantfilter.isDisplayed();
	}

	public void clickarchivedfilter() throws InterruptedException {
		((JavascriptExecutor) driver).executeScript("scroll(0,400)");
		archivedfilter.click();

		Thread.sleep(2000);
	}

	public boolean isarchiveddisplayed() {
		return validatearchivefilter.isDisplayed();

	}

	public void uncheckarchivefiter() throws InterruptedException {
		((JavascriptExecutor) driver).executeScript("scroll(0,400)");
		archivedfilter.click();
		Thread.sleep(2000);
	}

	public boolean isarchivednotdisplayed() {
		return validateConstantfilter.isDisplayed();
	}

	public void searchsampleRN() throws InterruptedException {
		searchbox.sendKeys(prop.getProperty("RnSearchbox"));
		searchbox.sendKeys(Keys.ENTER);
		Thread.sleep(1400);
	}

	public boolean issearchboxsamplethere() {
		return searchboxvalue.isDisplayed();

	}

	public void clearallfilters() {
		((JavascriptExecutor) driver).executeScript("scroll(0,400)");
		clearsearchbox.click();
	}

	public void sortascendingorder() throws InterruptedException {
		ascendingorder.click();
		Thread.sleep(2000);

	}

	public void sortdescendingorder() throws InterruptedException {
		descendingorder.click();
		Thread.sleep(2000);
	}

	public void intoReleaseHomepage() throws InterruptedException {
		Thread.sleep(5000);
		((JavascriptExecutor) driver).executeScript("scroll(0,2000)");
		releasenotespage.click();
		Thread.sleep(5000);
		((JavascriptExecutor) driver).executeScript("scroll(0,400)");
	}
	public void workspacefromRNpage() throws InterruptedException {
		Thread.sleep(5000);
		ExpandableMenu.click();
		WorkspaceTab.click();
	}
	public boolean isMadeArchived() {
		((JavascriptExecutor) driver).executeScript("scroll(0,500)");
		return madeArchived.isDisplayed();
	}
	
	public void searchsampleGlossary() throws InterruptedException {
		
		searchbox.sendKeys(prop.getProperty("GlossarySearchbox"));
		searchbox.sendKeys(Keys.ENTER);
		Thread.sleep(1400);
	
	}
	public void intocreatenewsampleGlossary() throws InterruptedException {
		CreatenewGlossary.click();
		Thread.sleep(1000);
	}
	public void returntoGlossaryhomepage() throws InterruptedException {
		backtohomepage.click();
		Thread.sleep(1000);
}
	public void completeeditGlossary() throws InterruptedException {
		newfaqdone.click();
		Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("scroll(0,-1000)");
	}
	
}
