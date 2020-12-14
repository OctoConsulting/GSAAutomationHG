package cmsPages;

import java.util.List;
import java.util.Random;

import javax.management.RuntimeErrorException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import util.TestBase;

public class CreateNewFaq extends TestBase

{


	public static  String randomCMSTitle;

	@FindBy(xpath = "//a[text()='New FAQ']")
	WebElement Createnewfaq;
	@FindBy(xpath = "//span[text()='New FAQ']")
	WebElement validatenewfaq;
	@FindBy(xpath = "//*[@id=\"title\"]")
	WebElement faqquestion;
	@FindBy(xpath="/html/body/app/main/ng-component/page/div/div/div[2]/div/form-only/div/div/div/div[2]/div[2]/sam-tabs/sam-tab[1]/div/form/div/sam-rich-text-editor/sam-label-wrapper/div/ckeditor/div/div/div/div/div")
	WebElement faqresponse;
	@FindBy(xpath = "//*[@id=\"keywords-ac-textarea\"]")
	WebElement faqkeyword;
	@FindBy(xpath = "//input[@id=\"toggle faq\"]")
	WebElement displayonhomepage;
	@FindBy(xpath = "//button[@id=\"question-done\"]")
	WebElement newfaqdone;
	@FindBy(xpath = "//a[@href=\"/cm/faqs?path=1\"]")
	WebElement backtohomepage;
	@FindBy(xpath = "//a[@href=\"/cm/faqs/detail?id=901&display=1\"]")
	WebElement validategeneratedfaq;
	@FindBy(xpath = "//*[@id=\"search-term\"]")
	WebElement searchbox;
	@FindBy(xpath = "//h4[@class=\"content-title-text ng-star-inserted\"]")
	WebElement diplayedFaqTitle;
	@FindBy(xpath = "//span[@id=\"title-error\"]")
	WebElement Titleerror;

// intializing the page objects/elements/
	// means DRIVER PLEASE INTILZE ALL THE GLOBAL VARIABLES ABOVE
	public CreateNewFaq() {
		
		PageFactory.initElements(driver, this);
	}

	public void intocreatenewsamplefaq() throws InterruptedException {
		Createnewfaq.click();
		Thread.sleep(1000);
	}

	public boolean iscreatefaqpageenabled() {
		return validatenewfaq.isDisplayed();

	}

	public void generatefaq() throws InterruptedException {

		((JavascriptExecutor) driver).executeScript("scroll(0,200)");
		Random rand = new Random();
		float result = rand.nextFloat();
		randomCMSTitle = "DEV_CMS_PI<123>" + result;
		faqquestion.sendKeys(randomCMSTitle);

	}

	public void generatefaqresponse() {
		faqresponse.sendKeys(prop.getProperty("CmsResponse"));
				

	}

	public void generatekeyword() {
		((JavascriptExecutor) driver).executeScript("scroll(0,600)");
		faqkeyword.click();

		faqkeyword.sendKeys("CMS");
		faqkeyword.sendKeys(Keys.ENTER);
		faqkeyword.sendKeys(Keys.TAB);

	}

	public void enabledisplayfaq() throws InterruptedException {

		displayonhomepage.click();
		Thread.sleep(3000);
	}

	public void completenewfaq() throws InterruptedException {
		newfaqdone.click();
		Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("scroll(0,-1000)");
	}

	public void returntofaqhomepage() throws InterruptedException {
		backtohomepage.click();
		Thread.sleep(1000);

	}

	public boolean isfaqgenerated() {
		return validategeneratedfaq.isDisplayed();
	}

	public String getPreviouslySubmittedFaqTitle() {

		return randomCMSTitle;
	}
	
	

	public void searchTheFaqWith(String randomFaqTitle2) {
		searchbox.sendKeys(randomFaqTitle2);

	}

	public static String getRandomCMSTitle() {
		return randomCMSTitle;
	}

	public void searchTheRandomFaqTitle() {
		searchbox.sendKeys(randomCMSTitle);
		searchbox.sendKeys(Keys.ENTER);
	}
	

	public Object getDisplayedFaqTitle() {

		return diplayedFaqTitle.getText();
	}

	public void NegCreateFaq() throws InterruptedException {
		((JavascriptExecutor) driver).executeScript("scroll(0,900)");
		newfaqdone.click();
		Thread.sleep(4000);
		((JavascriptExecutor) driver).executeScript("scroll(0,300)");
		Thread.sleep(5000);
	}

	public boolean isCreateFaqFailed() {
		return Titleerror.isDisplayed();
	}

	public boolean isFaqDisplayedOnHomePage(String expectedFaqTitle) {
		if(expectedFaqTitle==null) {
			throw new RuntimeException("Expected title is null");
		}
		List<WebElement> fAQElements = driver
				.findElements(By.xpath("//p[contains(text(),'GSA is merging')]/following-sibling::ul/li/a"));
		for (WebElement Element : fAQElements) {
			if (Element.getText().equalsIgnoreCase(expectedFaqTitle)) {
				return true;
			}
		}
		return false;
	}
}
