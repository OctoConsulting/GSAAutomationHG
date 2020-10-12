package cmsPages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import util.TestBase;

public class faqfilters extends TestBase {
	@FindBy(xpath = "//strong[text()='FAQs']")
	WebElement faqonworkspace;
	@FindBy(xpath = "//*[@id=\"New\"]")
	WebElement newfilter;
	@FindBy(xpath = "//div[text()='NEW']")
	WebElement isnewfilter;
	@FindBy(xpath = "//*[@id=\"main-container\"]/ng-component/page/div/div/div[2]/div[2]/div[1]/div[2]/div[4]/div[1]/div")
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
	WebElement faqbreadcrumb;

	// intializing the page objects/elements/
	// means DRIVER PLEASE INTILZE ALL THE GLOBAL VARIABLES ABOVE
	public faqfilters() {
		PageFactory.initElements(driver, this);
	}

	// METHODS/ACTIONS

	public void intofaq() throws InterruptedException {
		faqonworkspace.click();
		Thread.sleep(1000);
	}

	public boolean isfaqdisplayed() {
		return faqbreadcrumb.isDisplayed();

	}
	
	public void clicknewfilter() throws InterruptedException {
		Thread.sleep(1000);
		((JavascriptExecutor) driver).executeScript("scroll(0,800)");
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
		((JavascriptExecutor) driver).executeScript("scroll(0,800)");
		Thread.sleep(5000);
		newfilter.click();
		Thread.sleep(2000);
	}

	public boolean isnewnotdisplayed() {
		return validateConstantfilter.isDisplayed();

	}

	public void clickpublish() throws InterruptedException {
		((JavascriptExecutor) driver).executeScript("scroll(0,800)");
		publishedfilter.click();

		Thread.sleep(2000);
	}

	public boolean ispublisheddisplayed() {
		return validatepublishedfilter.isDisplayed();

	}

	public void uncheckpublishedfiter() throws InterruptedException {
		((JavascriptExecutor) driver).executeScript("scroll(0,800)");
		Thread.sleep(1000);
		publishedfilter.click();
		Thread.sleep(1000);
	}

	public boolean ispublishednotdisplayed() {
		return validatepublishedfilter.isDisplayed();
	}

	public void clickdraftfilter() throws InterruptedException {
		((JavascriptExecutor) driver).executeScript("scroll(0,800)");
		draftfilter.click();

		Thread.sleep(2000);
	}

	public boolean isdraftdisplayed() {
		return validatedraftfilter.isDisplayed();

	}

	public void uncheckdraftfiter() throws InterruptedException {
		((JavascriptExecutor) driver).executeScript("scroll(0,800)");
		draftfilter.click();
		Thread.sleep(2000);
	}

	public boolean isdraftnotdisplayed() {
		return validateConstantfilter.isDisplayed();
	}

	public void clickarchivedfilter() throws InterruptedException {
		((JavascriptExecutor) driver).executeScript("scroll(0,800)");
		archivedfilter.click();

		Thread.sleep(2000);
	}

	public boolean isarchiveddisplayed() {
		return validatearchivefilter.isDisplayed();

	}

	public void uncheckarchivefiter() throws InterruptedException {
		((JavascriptExecutor) driver).executeScript("scroll(0,800)");
		archivedfilter.click();
		Thread.sleep(2000);
	}

	public boolean isarchivednotdisplayed() {
		return validateConstantfilter.isDisplayed();
	}

	public void searchsamplefaq() throws InterruptedException {
		searchbox.sendKeys(prop.getProperty("FaqSearchbox"));
		searchbox.sendKeys(Keys.ENTER);
		Thread.sleep(1400);
	}

	public boolean issearchboxsamplethere() {
		return searchboxvalue.isDisplayed();

	}

	public void clearallfilters() {
		((JavascriptExecutor) driver).executeScript("scroll(0,800)");
		clearsearchbox.click();
	}

	public void sortascendingorder() {
		ascendingorder.click();

	}

	public void sortdescendingorder() {
		descendingorder.click();
	}

}
