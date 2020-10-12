package FeedsPages;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import util.TestBase;

public class NewListing extends TestBase{
	public static String nameList ;
	public static String reading2;
	@FindBy(xpath ="//a[text()= ' Assistance Listing '] ")
	WebElement AssitanceListingTab;
	@FindBy(xpath="//button[text()=' Add Listing ']")
	WebElement NewListingTab;
	@FindBy(xpath="//*[@id=\"title-input\"]")
			WebElement Title;
	@FindBy(xpath="//*[@id=\"defaultpicker\"]")
	WebElement FederalAgency;
	@FindBy(xpath="//*[@id=\"programNumber-input\"]")
	WebElement CFDA;
	@FindBy(xpath="//*[@id=\"fal-form-nav-next\"]")
	WebElement next;
	@FindBy(xpath="//*[@id=\"objectives-input\"]")
	WebElement Overview;
	@FindBy(xpath="//*[@id=\"functional-codes-control-ac-textarea\"]")
	WebElement FunctionalCodes;
	@FindBy(xpath="//*[@id=\"fal-functional-codes\"]/div/sam-label-wrapper/div/div[2]/div[2]/ul/li[2]/ul/li[2]/p")
	WebElement FunctionalCodesDropdown;
	@FindBy(xpath="//*[@id=\"subjectTermsSearch-ac-textarea\"]")
	WebElement SubjectTerms;
	@FindBy(xpath="//*[@id=\"fal-subject-terms\"]/div/sam-label-wrapper/div/div[2]/div[2]/ul/li/ul/li[1]/p")
	WebElement SubjectTermsDropdown;
	@FindBy(xpath="//*[@id=\"checkbox-act_0\"]")
	WebElement Act;
	@FindBy(xpath="//*[@id=\"authorization-confirm-btn-0\"]")
	WebElement ActDone;
	@FindBy(xpath="//*[@id=\"obligations-add-btn\"]")
	WebElement NewObligationButton;
	@FindBy(xpath="//*[@id=\"fal-obligation-asst-type-autocomplete-comp\"]")
	WebElement AssistanceType;
	@FindBy(xpath="//*[@id=\"sam-autocomplete-results-kv\"]/li[2]")
	WebElement MultipleAssistanceType;
	@FindBy(xpath="//*[@id=\"radio-pFY-na\"]")
	WebElement NotSeparately1;
	@FindBy(xpath="//*[@id=\"test\"]")
	WebElement NotSeparatelyText1;
	@FindBy(xpath="//*[@id=\"financial-obligation-subform\"]/div[2]/div/div[2]/div/div[7]/samtextradiobutton/sam-fieldset-wrapper/div/fieldset/ul/li[3]/div/div[1]")
	WebElement NotSeparately2;
	@FindBy(xpath="//*[@id=\"financial-obligation-subform\"]/div[2]/div/div[2]/div/div[7]/samtextradiobutton/sam-fieldset-wrapper/div/fieldset/ul/li[3]/div/div[2]")
	WebElement NotSeparately3;
	@FindBy(xpath="//*[@id=\"authorization-add-btn\"]")
	WebElement AddAuthorization;
	@FindBy(xpath="//*[@id=\"obligations-confirm-btn\"]")
	WebElement AddObligation;
	@FindBy(xpath="//*[@id=\"fal-financial-info-accomplishments-checkbox-na\"]")
	WebElement AccomplishmentsNotApplicatin;
	@FindBy(xpath="//*[@id=\"fal-financial-info-account-identification\"]/sam-button/button")
	WebElement AddAccountIdentification;
	@FindBy(xpath="//*[@id=\"code-box0\"]")
	WebElement AccountIdentificationCode;
	@FindBy(xpath="//*[@id=\"fal-financial-info-account-identification\"]/sam-listbuilder-card/div/div[2]/div/sam-button[2]/button")
	WebElement AddCode;
	@FindBy(xpath="//*[@id=\"fal-financial-info-tafs-codes\"]/sam-button/button")
	WebElement AddTAFSCodes;
	@FindBy(xpath="//*[@id=\"treasury-dept-code\"]")
	WebElement TreasuryDept;
	@FindBy(xpath="//*[@id=\"treasury-account-main-code\"]")
	WebElement TreasuryAccount;
	@FindBy(xpath="//*[@id=\"fal-financial-info-tafs-codes\"]/sam-listbuilder-card/div/div[2]/div/sam-button[2]/button")
	WebElement AddCode2;
	@FindBy(xpath="//*[@id=\"documentation-credentials-checkbox-na\"]")
	WebElement DocumentationRequired;
	@FindBy(xpath="//*[@id=\"applicantTypes-control-ac-textarea\"]")
	WebElement ApplicantEligibility;
	@FindBy(xpath="//*[@id=\"fal-criteria-applicant-list\"]/div/sam-label-wrapper/div/div[2]/div[2]/ul/li/ul/li[1]/p")
	WebElement Multiple1;
	@FindBy(xpath="//*[@id=\"checkbox-isa\"]")
	WebElement BeneficiaryEligibility;
	@FindBy(xpath="//*[@id=\"lengthandtime-description-input\"]")
	WebElement LengthAndTimePhasingOfAssistance;
	@FindBy(xpath="//*[@id=\"awardedtypes-control\"]")
	WebElement assistanceAwarded;
	
	@FindBy(xpath="//*[@id=\"assUsageTypes-control-ac-textarea\"]")
	WebElement UseOfAssistance;
	@FindBy(xpath="//*[@id=\"fal-criteria-ass-usage-list\"]/div/sam-label-wrapper/div/div[2]/div[2]/ul/li/ul/li[1]")
	WebElement UseOfAssistanceMultiple;
	@FindBy(xpath="//*[@id=\"assistanceusage-description-input\"]")
	WebElement specificTerms;
	@FindBy(xpath="//*[@id=\"useRestrictions-checkbox-na\"]")
	WebElement UseRestrictions;
	@FindBy(xpath="//*[@id=\"use-Discretionary-Funds-checkbox-na\"]")
	WebElement discretionaryFunds;
	@FindBy(xpath="//*[@id=\"use-Loan-Terms-checkbox-na\"]")
	WebElement loansAType;
	@FindBy(xpath="//*[@id=\"no\"]")
	WebElement Deadlines;
	@FindBy(xpath="//*[@id=\"awardProcedure-description\"]")
	WebElement AwardProcedure;
	@FindBy(xpath="//*[@id=\"approval-input\"]")
	WebElement DateRange;
	@FindBy(xpath="//*[@id=\"approval-description\"]")
	WebElement OtherApproval;
	@FindBy(xpath="//*[@id=\"header-requests\"]/ul/li[2]/a")
	WebElement RestOfNotification;
	@FindBy(xpath="//*[@id=\"renewal-input\"]")
	WebElement Renewals;
	@FindBy(xpath="//*[@id=\"renewal-description\"]")
	WebElement OtherRenewalInformation;
	@FindBy(xpath="//*[@id=\"appeals-input\"]")
	WebElement Appeals;
	@FindBy(xpath="//*[@id=\"appeals-description\"]")
	WebElement OtherAppealsInformation;
	@FindBy(xpath="//*[@id=\"audits-checkbox-na\"]")
	WebElement Audits;
	@FindBy(xpath="//*[@id=\"additional-documentation-checkbox-na\"]")
	WebElement Regulations;
	@FindBy(xpath="//button[text()=' Add Contact ']")
	WebElement AddContact;
	@FindBy(xpath="//*[@id=\"fal-contact-information-entry-0-full-name\"]")
	WebElement Name;
	@FindBy(xpath="//*[@id=\"sam-autocomplete-results-kv\"]/li")
	WebElement NameMuliple;
	@FindBy(xpath="//*[@id=\"fal-contact-information-entry-0\"]/div/fieldset/div/div/sam-button[2]/button")
	WebElement add;
	@FindBy(xpath="//*[@id=\"fal-form-nav-done\"]")
	WebElement Done1;
	@FindBy(xpath="//*[@id=\"main-container\"]/ng-component/page/div/div/div[2]/div[2]/tabs-fal/div[1]/a[3]")
	WebElement Publish; 
	@FindBy(xpath="//*[@id=\"main-container\"]/ng-component/page/div/div/div[2]/div[2]/h1")
	WebElement Listings;
	@FindBy(xpath="//button[text()=' Notify Assistance Administrator ']")
	WebElement NotifyAdmin;
	@FindBy(xpath="//span[@class=\"notification-num\"]")
	WebElement notification;
	@FindBy(xpath="//*[@id=\"header-requests\"]/ul/li[2]/a")
	WebElement ShowAll;
	@FindBy(xpath="//*[@id=\"Submit AL\"]")
	WebElement SubmitAl;
	@FindBy(xpath="//*[@id=\"Publish AL\"]")
	WebElement PublishAl;
	@FindBy(xpath="//*[@id=\"checkbox-published\"]")
	WebElement published;
	@FindBy(xpath="//*[@id=\"fal-workspace-input-search-input\"]")
	WebElement Search;
	@FindBy(xpath="//*[@id=\"main-container\"]/ng-component/page/div/div/div[2]/div[1]/sidebar/div/div[1]/sam-button/button")
	WebElement SearchButton;
	@FindBy(xpath="//*[@id=\"main-container\"]/ng-component/page/div/div/div[2]/div[2]/results/div[3]/div/assistance-program-result/div[3]/div[2]/div/div")
	String DateTimeStamp;
	@FindBy(xpath="//*[@id=\"submission-comment\"]")
	WebElement SubmissionComment;
	
	@FindBy(xpath="//*[@id=\"main-container\"]/ng-component/page/div/div/div[2]/div[1]/sidebar/msg-feed-sidenav/div/ul/li[2]/ul/li[1]/a")
	WebElement SentTab;
	@FindBy(xpath="//a[text()='Received']")
	WebElement RecievedTab;
	@FindBy(xpath="//*[@id=\"search-keyword\"]")
	WebElement SearchRequest;
	@FindBy(xpath="//button[text()=' Submit ']")
	WebElement submitOMB;
	@FindBy(xpath="//button[text()=' Submit to OMB ']")
	WebElement submitOMBAfterComments;
	@FindBy(xpath="//button[text()=' Publish ']")
	WebElement publishOMB;
	@FindBy(id="programNumber-input")
	WebElement cfda;
	
@FindBy(xpath="//div[@class=\"usa-width-one-whole msg-feed-item link-hover ng-star-inserted\"]")
WebElement firstlisting;
@FindBy(xpath="//textarea[@id=\"ombrmo-input\"]")
WebElement OMBcommentforPublishing;

public NewListing() {
		PageFactory.initElements(driver, this);
	}
public void intofirstlistingFORPUBLISHING() throws InterruptedException {
	((JavascriptExecutor) driver).executeScript("scroll(0,400)");

	publishOMB.click();
	Thread.sleep(2000);
	((JavascriptExecutor) driver).executeScript("scroll(0,600)");
	Thread.sleep(2000);
	OMBcommentforPublishing.sendKeys("Done");
	Thread.sleep(3000);
	publishOMB.click();
	Thread.sleep(5000);
}
public void intofirstlisting() throws InterruptedException {
	firstlisting.click();
	Thread.sleep(2000);
	
}
public void submittoOMB() throws InterruptedException {
	submitOMB.click();
	Thread.sleep(4000);
	
}
public void Enter_the_data_in_submission_comment() throws Throwable {
	Thread.sleep(5000);
	SubmissionComment.sendKeys("Done");
	((JavascriptExecutor) driver).executeScript("scroll(0,300)");
}
public void Click_on_submit_buttonAfterCommenting() throws Throwable {
	Thread.sleep(2000);
	submitOMBAfterComments.click();
	Thread.sleep(8000);
}
public void IntoHomepageListing() throws InterruptedException {
	Thread.sleep(5000);
	
	
	Thread.sleep(2000);
	AssitanceListingTab.click();
	AssitanceListingTab.sendKeys(Keys.ENTER);
	Thread.sleep(2000);
	
}
public void Clickadd_listing_button() throws Throwable {
	Thread.sleep(8000);
	NewListingTab.click();

}
public void HeaderInfoForListing() throws InterruptedException {
	Thread.sleep(2000);

	Random r1 = new Random();
	String outputs = "";
	for (int i = 0; i < 3; i++)
		outputs += r1.nextInt(1000);
	nameList = "Test" + outputs;
	Title.sendKeys(nameList);
	Thread.sleep(2000);
	//cfda.click();
	//cfda.sendKeys("123");
	Thread.sleep(2000);

	((JavascriptExecutor) driver).executeScript("scroll(0,900)");

	next.click();
}


public void Fill_the_overview_details() throws Throwable {
	Thread.sleep(4000);
Overview.sendKeys("Hi");
Overview.sendKeys(Keys.TAB);

	((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
	Thread.sleep(2000);
FunctionalCodes.sendKeys("Resource Conservation and");
	Thread.sleep(2000);
FunctionalCodesDropdown.click();
	Thread.sleep(2000);
SubjectTerms.sendKeys("Education");
	Thread.sleep(2000);
	SubjectTermsDropdown.click();
	Thread.sleep(2000);
next.click();
}


public void Fill_the_authorization_details() throws Throwable {
	Thread.sleep(2000);
AddAuthorization.click();
	Thread.sleep(2000);
	Act.click();
	Thread.sleep(2000);
	ActDone.click();
	Thread.sleep(2000);
	next.click();
	Thread.sleep(2000);
}


public void Fill_the_obligations_details() throws Throwable {
	Thread.sleep(2000);
NewObligationButton.click();
	Thread.sleep(2000);
AssistanceType.sendKeys("Hi");
	Thread.sleep(2000);
MultipleAssistanceType.click();
NotSeparately1.click();
	Thread.sleep(2000);
NotSeparatelyText1.sendKeys("Hi");
	Thread.sleep(2000);
NotSeparatelyText1.sendKeys(Keys.TAB);
NotSeparately2.click();
	Thread.sleep(2000);

	Thread.sleep(2000);

	((JavascriptExecutor) driver).executeScript("scroll(0,500)");
	Thread.sleep(2000);

NotSeparately3.click();
	Thread.sleep(2000);

	Thread.sleep(2000);

	Thread.sleep(2000);
AddObligation.click();
	Thread.sleep(2000);
	next.click();
	Thread.sleep(2000);

}


public void Fill_other_Financial_Information_details() throws Throwable {
	Thread.sleep(2000);
AccomplishmentsNotApplicatin.click();
	Thread.sleep(2000);
	AddAccountIdentification.click();
	Thread.sleep(2000);
	AccountIdentificationCode.sendKeys("11111111111");
	Thread.sleep(2000);
	AddCode.click();
	Thread.sleep(2000);
	AddTAFSCodes.click();

	Thread.sleep(2000);
TreasuryDept.sendKeys("11");
	Thread.sleep(2000);
TreasuryAccount.sendKeys("1112");
	Thread.sleep(2000);
AddCode2.click();

	Thread.sleep(2000);
next.click();
	Thread.sleep(2000);
}


public void Fill_criteria_for_applying_details() throws Throwable {
	Thread.sleep(2000);
	DocumentationRequired.click();
	Thread.sleep(2000);
ApplicantEligibility.sendKeys("u");
	Thread.sleep(2000);
Multiple1.click();

	Thread.sleep(2000);
BeneficiaryEligibility.click();
	Thread.sleep(2000);
LengthAndTimePhasingOfAssistance.sendKeys("The  are so many stories");
	Thread.sleep(2000);
	Select drpCountry = new Select(assistanceAwarded);
	drpCountry.selectByIndex(1);
	Thread.sleep(2000);
UseOfAssistance.sendKeys("N");
	Thread.sleep(2000);
UseOfAssistanceMultiple.click();
	Thread.sleep(2000);
specificTerms.sendKeys("The  are so many stories");
	Thread.sleep(2000);
UseRestrictions.click();
	Thread.sleep(2000);
discretionaryFunds.click();
	Thread.sleep(2000);
	Thread.sleep(2000);
	loansAType.click();
	Thread.sleep(2000);
	next.click();
	Thread.sleep(2000);
}


public void Fill_applying_for_Assistance_details() throws Throwable {
	Thread.sleep(2000);
Deadlines.click();
	Thread.sleep(2000);
AwardProcedure.sendKeys("Test 123");
	Thread.sleep(2000);
	Select drpCountry = new Select(DateRange);
	Thread.sleep(2000);
	drpCountry.selectByIndex(1);
	Thread.sleep(2000);
	OtherApproval.sendKeys("Test456");
	Thread.sleep(2000);
	Select drpCountry1 = new Select(Renewals);
	Thread.sleep(2000);
	drpCountry1.selectByIndex(1);
	Thread.sleep(2000);
	OtherRenewalInformation.sendKeys("Test456");
	Thread.sleep(2000);
	Select drpCountry2 = new Select(Appeals);
	Thread.sleep(2000);
	drpCountry2.selectByIndex(1);
	Thread.sleep(2000);
	OtherAppealsInformation.sendKeys("Test789");
	Thread.sleep(2000);
	next.click();
	Thread.sleep(2000);
}


public void Fill_compliance_requirements_details() throws Throwable {
	TimeUnit.SECONDS.sleep(3);
	((JavascriptExecutor) driver).executeScript("scroll(0,500)");
	TimeUnit.SECONDS.sleep(3);
	Thread.sleep(2000);
Audits.click();
	Thread.sleep(2000);
Regulations.click();
	Thread.sleep(2000);
	Thread.sleep(2000);
	next.click();
}


public void Fill_contact_information_details() throws Throwable {
	Thread.sleep(2000);
	AddContact.click();
	Thread.sleep(2000);
	Name.sendKeys("eric");
	Thread.sleep(8000);
	NameMuliple.click();
	Thread.sleep(2000);
add.click();
	Thread.sleep(2000);
Done1.click();
	Thread.sleep(2000);
	Thread.sleep(2000);
Publish.click();
	Thread.sleep(2000);
}


public void Click_on_submit_button() throws Throwable {
	Thread.sleep(9000);
//	String NameOflisting = Listings.getText();
//
//	String str = NameOflisting.replace("\n", " ");

	Thread.sleep(4000);
	NotifyAdmin.click();
	
	Thread.sleep(11000);
	
}

public void User_unselect_published() throws Throwable {
	Thread.sleep(10000);

	((JavascriptExecutor) driver).executeScript("scroll(0,500)");
	Thread.sleep(8000);
published.click();
	Thread.sleep(2000);
}



public void Search_for_a_keyword() throws Throwable {
	Thread.sleep(5000);

Search.sendKeys(nameList);

	Thread.sleep(2000);
SearchButton.click();

((JavascriptExecutor) driver).executeScript("scroll(0,200)");
	Thread.sleep(2000);

}
public boolean ValidateNewListingInListingPage() {
	boolean verify=false;
	//VALIDATION FOR "YOU"
			WebElement locatorforWhereTEXTisPresent = driver.findElement(By.xpath(
				//ADD LOCATION OF THE ASSIsTANT PAGE 
					"//div[@class=\"sam-ui segment ng-star-inserted\"]"));
	
			String Requesttext = locatorforWhereTEXTisPresent.getText();
	
			if (Requesttext.contains(nameList) && Requesttext.contains("Draft Review")  )  {
				verify = true;
				}

				else {
					return false;
				}
			return verify;
}
public boolean ValidateNewListingInListingPageAsApproved() {
	boolean verify=false;
	//VALIDATION FOR "YOU"
			WebElement locatorforWhereTEXTisPresent = driver.findElement(By.xpath(
				//ADD LOCATION OF THE ASSIsTANT PAGE 
					"//div[@class=\"sam-ui segment ng-star-inserted\"]"));
	
			String Requesttext = locatorforWhereTEXTisPresent.getText();
	
			if (Requesttext.contains(nameList) && Requesttext.contains("Published")  )  {
				verify = true;
				}

				else {
					return false;
				}
			return verify;
}

public boolean ValidateNewListingInListingPageFORADMIN() {
	boolean verify=false;
	//VALIDATION FOR "YOU"
			WebElement locatorforWhereTEXTisPresent = driver.findElement(By.xpath(
				//ADD LOCATION OF THE ASSIsTANT PAGE 
					"//div[@class=\"sam-ui segment ng-star-inserted\"]"));
	
			String Requesttext = locatorforWhereTEXTisPresent.getText();
	
			if (Requesttext.contains(nameList) && Requesttext.contains("Pending - OMB")  )  {
				verify = true;
				}

				else {
					return false;
				}
			return verify;
}
public boolean ValidateNewListingInListingPageAsPublished() {
	boolean verify=false;
	//VALIDATION FOR "YOU"
			WebElement locatorforWhereTEXTisPresent = driver.findElement(By.xpath(
				//ADD LOCATION OF THE ASSIsTANT PAGE 
					"//div[@class=\"sam-ui segment ng-star-inserted\"]"));
	
			String Requesttext = locatorforWhereTEXTisPresent.getText();
	
			if (Requesttext.contains(nameList) && Requesttext.contains("Published")  )  {
				verify = true;
				}

				else {
					return false;
				}
			return verify;
}



public void Read_the_timestamp() throws Throwable {
//	Thread.sleep(8000);
//	//DateTimeStamp = DateTimeStamp.getText();
//
//	Thread.sleep(2000);
//
//
//	SimpleDateFormat sdf = new SimpleDateFormat("hh:mmaaa");
//	// Date dateTimePartDate = sdf.parse(dateTimePart);
//	// System.out.println(dateTimePartDate);
//
//	SimpleDateFormat sdf1 = new SimpleDateFormat("MMM dd, yyyy hh:mm aaa");
//	Date fullDateStrDate = sdf1.parse(DateTimeStamp);
//	tempDate = sdf.format(fullDateStrDate);
//	logger.info("tempDate: " + tempDate);
//	fullDateStrDate1 = sdf.parse(tempDate);
//	logger.info("fullDateStrDate1: " + fullDateStrDate1);
//
//	// System.out.println(dateTimePartDate.equals(fullDateStrDate1));
}


public void Click_on_the_notification() throws Throwable {
	Thread.sleep(6000);
notification.click();
Thread.sleep(2000);
RestOfNotification.click();
	Thread.sleep(2000);

}
public void Click_on_the_notificationForADMINS() throws Throwable {
	Thread.sleep(6000);
notification.click();
Thread.sleep(2000);
((JavascriptExecutor) driver).executeScript("scroll(0,900)");
Thread.sleep(2000);
RestOfNotification.click();
	Thread.sleep(2000);

}
public void Click_on_Sent_tab() throws Throwable {
	Thread.sleep(2000);
	//WebDriverWait wait = new WebDriverWait(driver, 30);
	//wait.until(ExpectedConditions.visibilityOfElementLocated(feedsLocators.SentTab));
SentTab.click();
	Thread.sleep(2000);
}
public void Click_on_Recieved_tab() throws Throwable {
	Thread.sleep(2000);
	//WebDriverWait wait = new WebDriverWait(driver, 30);
	//wait.until(ExpectedConditions.visibilityOfElementLocated(feedsLocators.SentTab));
RecievedTab.click();
	Thread.sleep(2000);
}

public void Click_on_submit_al() throws Throwable {
	Thread.sleep(5000);
	//WebDriverWait wait = new WebDriverWait(driver, 30);
	//wait.until(ExpectedConditions.visibilityOfElementLocated(feedsLocators.SubmitAl));
SubmitAl.click();
	Thread.sleep(2000);
}
public void Click_on_publish_al() throws Throwable {
	Thread.sleep(5000);
	//WebDriverWait wait = new WebDriverWait(driver, 30);
	//wait.until(ExpectedConditions.visibilityOfElementLocated(feedsLocators.SubmitAl));
PublishAl.click();
	Thread.sleep(2000);
}

public void Search_for_the_above_Assistance_Listings_keyword() throws Throwable{
	Thread.sleep(2000);
SearchRequest.sendKeys(nameList);
	Thread.sleep(2000);
SearchRequest.sendKeys(Keys.ENTER);
	Thread.sleep(2000);
	
}

public boolean Context_validating_in_sent_tab() throws InterruptedException {
	boolean verify=false;
	//VALIDATION FOR "YOU"
			WebElement locatorforWhereTEXTisPresent = driver.findElement(By.xpath(
				//ADD LOCATION OF THE ASSIsTANT PAGE 
					"//span[@class=\"usa-width-one-whole msg-feed-description\"]"));
	
			String Requesttext = locatorforWhereTEXTisPresent.getText();
	
			if (Requesttext.contains("You") && Requesttext.contains(nameList)  )  {
				verify = true;
				}

				else {
					return false;
				}
			return verify;
}
public boolean Context_validating_in_sent_tabAndPending() throws InterruptedException {
	boolean verify=false;
	//VALIDATION FOR "YOU"
			WebElement locatorforWhereTEXTisPresent = driver.findElement(By.xpath(
				//ADD LOCATION OF THE ASSIsTANT PAGE 
					"//div[@class=\"usa-width-one-whole msg-feed-item link-hover ng-star-inserted\"]"));
	
			String Requesttext = locatorforWhereTEXTisPresent.getText();
	
			if (Requesttext.contains("Pending")  )  {
				verify = true;
				}

				else {
					return false;
				}
			return verify;
}
public boolean Context_validating_in_received_tab_AsApproved() throws InterruptedException {
	boolean verify=false;
	//VALIDATION FOR "YOU"
			WebElement locatorforWhereTEXTisPresent = driver.findElement(By.xpath(
				//ADD LOCATION OF THE ASSIsTANT PAGE 
					"//div[@class=\"usa-width-one-whole msg-feed-item link-hover ng-star-inserted\"]"));
	
			String Requesttext = locatorforWhereTEXTisPresent.getText();
	
			if (Requesttext.contains(nameList) 
					
					&& Requesttext.contains("Approved")  
					)  {
				verify = true;
				}

				else {
					return false;
				}
			return verify;
}
public boolean Context_validating_in_Received_tab() throws InterruptedException {
	boolean verify=false;
	//VALIDATION FOR "YOU"
			WebElement locatorforWhereTEXTisPresent = driver.findElement(By.xpath(
				//ADD LOCATION OF THE ASSIsTANT PAGE 
					"//span[@class=\"usa-width-one-whole msg-feed-description\"]"));
	
			String Requesttext = locatorforWhereTEXTisPresent.getText();
	
			if (Requesttext.contains("requested") && Requesttext.contains(nameList)  )  {
				verify = true;
				}

				else {
					return false;
				}
			return verify;
}
public boolean NEGContext_validating_in_Received_tab() throws InterruptedException {
	boolean verify=false;
	//VALIDATION FOR "YOU"
			WebElement locatorforWhereTEXTisPresent = driver.findElement(By.xpath(
				//ADD LOCATION OF THE ASSIsTANT PAGE 
					"//span[@class=\"usa-width-one-whole msg-feed-description\"]"));
	
			String Requesttext = locatorforWhereTEXTisPresent.getText();
	
			if (Requesttext.contains("requested") && Requesttext.contains(nameList)  )  {
				verify = false;
				}

				else {
					return true;
				}
			return verify;
}

	
				

			}

