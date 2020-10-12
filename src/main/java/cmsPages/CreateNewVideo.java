package cmsPages;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;

import util.TestBase;

public class CreateNewVideo extends TestBase {
	public static String randomCMSTitle;

	@FindBy(xpath = "//a[text()='New Video']")
	WebElement CreatenewVideo;
	@FindBy(xpath = "//a[text()='New Video']")
	WebElement validatenewVideo;
	@FindBy(xpath = "//*[@id=\"title\"]")
	WebElement faqquestion;
	@FindBy(xpath="/html/body/app/main/ng-component/page/div/div/div[2]/div/form-only/div/div/div/div[2]/div[2]/sam-tabs/sam-tab[1]/div/form/div/sam-rich-text-editor/sam-label-wrapper/div/ckeditor/div/div/div/div/div")
	WebElement faqresponse;
	@FindBy(id="search-term")
	WebElement faqkeyword;
	@FindBy(xpath = "//input[@id=\"toggle faq\"]")
	WebElement displayonhomepage;
	@FindBy(xpath = "//button[@id=\"question-done\"]")
	WebElement newfaqdone;

	@FindBy(xpath = "//a[@href=\"/cm/faqs/detail?id=901&display=1\"]")
	WebElement validategeneratedfaq;
	@FindBy(xpath = "//*[@id=\"search-term\"]")
	WebElement searchbox;
	@FindBy(xpath = "//h4[@class=\"content-title-text ng-star-inserted\"]")
	WebElement diplayedFaqTitle;
	@FindBy(xpath = "//span[@id=\"title-error\"]")
	WebElement Titleerror;
	@FindBy(xpath = "//strong[text()='Videos']")
	WebElement videos;
	@FindBy(xpath = "//a[text()='Video']")
	WebElement backtohomepage;
	@FindBy(id="upload")
	WebElement browsevideo;
	@FindBy(xpath="//input[@id=\"upload\"and @accept=\".vtt\"]")
	WebElement browsecaption;
	@FindBy(xpath = "//*[@id=\"primary-content\"]/div/h1")
	WebElement validateConstantfilter;
	@FindBy(xpath = "//span[@class=\"fa fa-warning\"]")
	WebElement validateVideoUpload;
	@FindBy(xpath = "//img[@alt=\"beta.sam.gov logo.\"]")
	WebElement samhomepage;
	@FindBy(xpath = "//a[text()='More FAQs']")
	WebElement cmspage;
	@FindBy(xpath = "//*[@id=\"faq\"]")
	WebElement faq;
	@FindBy(xpath = "//*[@id=\"video\"]")
	WebElement video;
	@FindBy(xpath = "//button[text()=' Publish ']")
	WebElement publish;
	@FindBy(id="learning-center-autocomplete")
	WebElement searchingCMS;
	
// intializing the page objects/elements/
	// means DRIVER PLEASE INTILZE ALL THE GLOBAL VARIABLES ABOVE
	public CreateNewVideo() {
		PageFactory.initElements(driver, this);
	}
	

	public boolean iscreateVideopageenabled() {
		return validatenewVideo.isDisplayed();

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



	public void enabledisplayfaq() throws InterruptedException {

		displayonhomepage.click();
		Thread.sleep(3000);
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
	public void UploadVideo() throws InterruptedException {
		((JavascriptExecutor) driver).executeScript("scroll(0,900)");
		browsevideo.sendKeys("\\\\e04tcm-vdipcfs3\\ReDir$\\sanzedahrahman\\Desktop\\fish.mp4");
	Thread.sleep(5000);
	

	//((JavascriptExecutor) driver).executeScript("scroll(0,100)");
	browsecaption.sendKeys("\\\\e04tcm-vdipcfs3\\ReDir$\\sanzedahrahman\\Desktop\\VideoCaption.txt");
	}
	


///////////////////////////////////
	public void intoVIDEOS() throws InterruptedException {
		Thread.sleep(1000);
		((JavascriptExecutor) driver).executeScript("scroll(0,2500)");
			videos.click();
		Thread.sleep(2000);
	}
	public void intocreatenewsampleVideo() throws InterruptedException {
		CreatenewVideo.click();
		Thread.sleep(1000);
	}

	public void generatekeyword() {
		((JavascriptExecutor) driver).executeScript("scroll(0,-500)");
		faqkeyword.click();

		faqkeyword.sendKeys("Video");
		faqkeyword.sendKeys(Keys.ENTER);
		faqkeyword.sendKeys(Keys.TAB);

	}


	public void completenewfaq() throws InterruptedException {
		newfaqdone.click();
		Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("scroll(0,-1000)");
	}

	public void returntoVideohomepage() throws InterruptedException {
		Thread.sleep(120000);
	//	publish.click();
		Thread.sleep(5000);
		backtohomepage.click();
	Thread.sleep(10000);

}

	public void UploadNegVideo() throws InterruptedException {
		((JavascriptExecutor) driver).executeScript("scroll(0,900)");
		browsevideo.sendKeys("\\\\E04BMK-XDVCFP2\\RedirMR$\\sanzedahrahman\\Desktop\\VideoCaption.txt");
	}
	public void UploadPosVideo() throws InterruptedException {
		Thread.sleep(3000);
		//browsevideo.clear();
		browsevideo.sendKeys("\\\\E04BMK-XDVCFP2\\RedirMR$\\sanzedahrahman\\Desktop\\fish.mp4");
	Thread.sleep(1000);
	browsecaption.sendKeys("\\\\E04BMK-XDVCFP2\\RedirMR$\\sanzedahrahman\\Desktop\\VideoCaption.txt");

	}
	public boolean itsVideoPagedisplayed() {
		return validateConstantfilter.isDisplayed();

	}
	public boolean isVideoNotUploaded() {
		return validateVideoUpload.isDisplayed();

	}
	public boolean itCreateVideodisplayed() {
		return CreatenewVideo.isDisplayed();

	}

//
//	public void searchTheFaqWith(String randomFaqTitle2) throws InterruptedException {
//		Thread.sleep(5000);
//		searchbox.sendKeys(randomFaqTitle2);
//
//	}
//
//	public static String getRandomCMSTitle() {
//		return randomCMSTitle;
//	}

	public void validateCMSVideoHomepage() throws InterruptedException {
		Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("scroll(0,-1000)");
		samhomepage.click();
		Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
	
		cmspage.click();
		Thread.sleep(2000);
		faq.click();
		Thread.sleep(2000);
		video.click();
		Thread.sleep(2000);
		searchingCMS.sendKeys(randomCMSTitle);
		searchingCMS.sendKeys(Keys.ENTER);
	}
}
