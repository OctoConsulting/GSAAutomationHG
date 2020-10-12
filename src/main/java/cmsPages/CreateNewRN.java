package cmsPages;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import util.TestBase;


public class CreateNewRN extends TestBase{
	public static String randomRNTitle = null;
	@FindBy(xpath = "//a[text()='New Release Note']")
	WebElement CreatenewRN;
	@FindBy(xpath = "//span[text()='New Release Note']")
	WebElement validatenewRN;
	@FindBy(xpath = "//*[@id=\"title\"]")
	WebElement RNquestion;
	@FindBy(xpath = "//*[@id=\"overview\"]")
	WebElement RNresponse;
	@FindBy(xpath = "//*[@id=\"cke_1_contents\"]/div")
	WebElement overview;
	@FindBy(xpath = "//input[@id=\"toggle faq\"]")
	WebElement displayonhomepage;
	@FindBy(xpath = "//*[@id=\"question-done\"]")
	WebElement newRNdone;
	@FindBy(xpath = "//*[@href=\"/cm/release?path=1\"]")
	WebElement backtohomepage;
	@FindBy(xpath = "//a[@href=\"/cm/release?path=1\"]")
	WebElement validategeneratedfaq;
	@FindBy(xpath = "//*[@id=\"search-term\"]")
	WebElement searchbox;
	@FindBy(xpath = "//h4[@class=\"content-title-text ng-star-inserted\"]")
	WebElement diplayedFaqTitle;
	@FindBy(xpath = "//span[@id=\"title-error\"]")
	WebElement Titleerror;

// intializing the page objects/elements/
	// means DRIVER PLEASE INTILZE ALL THE GLOBAL VARIABLES ABOVE
	public CreateNewRN() {
		PageFactory.initElements(driver, this);
	}

	public void intocreatenewsampleRN() throws InterruptedException {
		CreatenewRN.click();
		Thread.sleep(1000);
	}

	public boolean iscreateRnpageenabled() {
		return validatenewRN.isDisplayed();

	}

	public void generateRN() throws InterruptedException {

		((JavascriptExecutor) driver).executeScript("scroll(0,200)");
		Random rand = new Random();
		float result = rand.nextFloat();
		randomRNTitle = "DEV_ReleaseNote_PI<123>" + result;
		RNquestion.sendKeys(randomRNTitle);
		setRandomRNTitle(randomRNTitle);

	}
	public void generatefaqresponse() {
		RNresponse.sendKeys(prop.getProperty("CmsResponse"));
				

	}
	public void enteroverview() {
		overview.sendKeys(prop.getProperty("CmsOverview"));
	}

	public void editdetails() throws InterruptedException {
		((JavascriptExecutor) driver).executeScript("scroll(0,800)");
		overview.sendKeys(prop.getProperty("CmsOverview"));
		
		Thread.sleep(5000);
		
	}



	public void completenewRN() throws InterruptedException {
		Thread.sleep(5000);
	
		newRNdone.click();
		Thread.sleep(3000);
		((JavascriptExecutor) driver).executeScript("scroll(0,-1000)");
	}

	public void returntoRNhomepage() throws InterruptedException {
		Thread.sleep(1000);

		backtohomepage.click();
		Thread.sleep(1000);

	}





	public void NegCreateRN() throws InterruptedException {
		((JavascriptExecutor) driver).executeScript("scroll(0,900)");
		newRNdone.click();
		Thread.sleep(4000);
		((JavascriptExecutor) driver).executeScript("scroll(0,300)");
		Thread.sleep(5000);
	}

	public boolean isCreateRNFailed() {
		return Titleerror.isDisplayed();
	}

	public static String getRandomRNTitle() {
		return randomRNTitle;
	}

	public static void setRandomRNTitle(String randomRNTitle) {
		CreateNewRN.randomRNTitle = randomRNTitle;
	}
	
	public  boolean isTitleVisible() {
		boolean flag = false;
		if(getRandomRNTitle()!=null) flag=true;
		return flag;
	}
	
	


	
}

