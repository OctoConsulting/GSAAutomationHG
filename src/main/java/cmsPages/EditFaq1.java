package cmsPages;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import util.TestBase;

public class EditFaq1 extends TestBase {

	@FindBy(xpath = "//button[@aria-controls=\"name+'menu'\"and @aria-label=\"Actions\"]")
	WebElement actionsdropdown;
	@FindBy(xpath = "//span[text()='Publish']")
	WebElement actionsdropdownpublish;
	@FindBy(xpath = "//div[text()='PUBLISHED']")
	WebElement validatefaqpublished;
	@FindBy(xpath = "//span[text()='Edit']")
	WebElement actionsdropdownedit;
	@FindBy(xpath = "//*[@id=\"New\"]")
	WebElement newfilter;
	@FindBy(xpath = "//input[@id=\"title\"]")
	WebElement faqquestion;
	@FindBy(xpath = "//*[@id=\"definition\"]")
	WebElement faqresponse;
	@FindBy(xpath = "//input[@id=\"toggle faq\"]")
	WebElement displayonhomepage;
	@FindBy(xpath = "//button[@id=\"question-done\"]")
	WebElement newfaqdone;
	@FindBy(xpath = "//a[@href=\"/cm/faqs?path=1\"]")
	WebElement backtohomepage;
	@FindBy(xpath = "//div[text()='DRAFT']")
	WebElement validatefaqisdrafted;
	@FindBy(xpath = "//img[@class=\"sam-logo\"]")
	WebElement SamLogo;
	@FindBy(xpath = "//button[@aria-label=\"Expandable links menu. Collapsed. \"and @id=\"headerIconMenu\"]")
	WebElement ExpandableMenu;
	@FindBy(xpath = "//a[@id=\"header-link-workspace\"]")
	WebElement WorkspaceTab;
	@FindBy(xpath = "//*[@id=\"Published\"]")
	WebElement publishedfilter;
	public static String randomRNEditTitle;
	// intializing the page objects/elements/
	// means DRIVER PLEASE INTILZE ALL THE GLOBAL VARIABLES ABOVE
	public EditFaq1() {
		PageFactory.initElements(driver, this);
	}

	public void usingactions() throws InterruptedException {
		Thread.sleep(1400);
		actionsdropdown.click();
	}

	public void publishingfaq() throws InterruptedException {
		Thread.sleep(1000);
		((JavascriptExecutor) driver).executeScript("scroll(0,800)");
		Thread.sleep(1000);
		newfilter.isEnabled();
		Thread.sleep(1000);
		newfilter.click();

		Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("scroll(0,-900)");
		Thread.sleep(4000);
		actionsdropdown.click();
		Thread.sleep(2000);

		actionsdropdownpublish.click();
		Thread.sleep(2400);
		((JavascriptExecutor) driver).executeScript("scroll(0,800)");
		Thread.sleep(2000);

		newfilter.click();
		Thread.sleep(2000);

		publishedfilter.click();
		Thread.sleep(2000);

		((JavascriptExecutor) driver).executeScript("scroll(0,-900)");
		Thread.sleep(2000);

		
	}

	public boolean isfaqpublished() {
		return validatefaqpublished.isDisplayed();

	}

	public void IntoSAMhomepage() throws Exception {

		SamLogo.click();
		Thread.sleep(3000);
		((JavascriptExecutor) driver).executeScript("scroll(0,1800)");
		Thread.sleep(5000);

	}

	public void draftfaq() throws InterruptedException {
		Thread.sleep(1400);
		actionsdropdownedit.click();
		Thread.sleep(1400);

	}

	public void editgeneratedfaq() {
		((JavascriptExecutor) driver).executeScript("scroll(0,400)");
		faqquestion.clear();
	}
public void dropdownpublished() throws InterruptedException {
Thread.sleep(2000);

actionsdropdownpublish.click();
Thread.sleep(2400);
}
	public void editgeneratedquestion() throws InterruptedException {
		Random rand = new Random();
		float result = rand.nextFloat();
		randomRNEditTitle = "Updated CMS thats been edited for testing purpose" + result;
		faqquestion.sendKeys(randomRNEditTitle);
		setRandomRNEditTitle(randomRNEditTitle);
		((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
		Thread.sleep(5000);
	}

	public void enabledisplayfaq() throws InterruptedException {
		displayonhomepage.click();
		Thread.sleep(5000);
	}

	public void completeeditfaq() throws InterruptedException {
		newfaqdone.click();
		Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("scroll(0,-1000)");
	}

	public void returntofaqhomepage() throws InterruptedException {
		backtohomepage.click();
		Thread.sleep(1000);

	}

	public boolean isfaqdrafted() {
		return validatefaqisdrafted.isDisplayed();
	}

	public void BacktoWorkspaceFromSamHomepage() throws InterruptedException {
		((JavascriptExecutor) driver).executeScript("scroll(0,-1500)");
		ExpandableMenu.click();
		Thread.sleep(2000);
		WorkspaceTab.click();
	}

	public static String getRandomRNEditTitle() {
		return randomRNEditTitle;
	}

	public static void setRandomRNEditTitle(String randomRNEditTitle) {
		EditFaq1.randomRNEditTitle = randomRNEditTitle;
	}
	
	public  boolean isTitleVisible() {
		boolean flag = false;
		if(getRandomRNEditTitle()!=null) flag=true;
		return flag;
	}
	
	

}
