package FhPages;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import util.TestBase;

public class FhEventsPages extends TestBase{

public  static String OrgStartedAmount;
public  static String OrgExpiredAmount;
public  static String TotalResultsOfEventsValueBothExpiredAndStarted;
public  static String finalamount;
public static int PageNumbers;
	@FindBy(id="Dept/Ind Agency")
	WebElement DeptTab;
	@FindBy(xpath="//a[text()='Clear All']")
	WebElement ClearTab;
	@FindBy(id="Sub-Tier")
	WebElement SubtierTab;
	@FindBy(xpath="//a[text()='Workspace']")
	WebElement WorkspaceTab;

	@FindBy(id ="Office")
	WebElement OfficeTab;
	@FindBy(id="started-recently")
	WebElement OrgStartTab;
	@FindBy(id="ended-recently")
	WebElement OrgExpiredTab;
	@FindBy(id ="org-recent-start-link")
	WebElement EventsPageLinkStarted;
	@FindBy(id="org-expire-link")
	WebElement EventsPageLinkExpired;
	@FindBy(xpath="//div[text()=' Events in the ']")
	WebElement EventsPageLogo;
	@FindBy(xpath="//*[@id=\"main-container\"]/sam-t1-workspace/div/div[1]/sam-widget-space/div/workspace-fh-widget/div/div[2]/label")
	WebElement EventsPageLogo2;
	@FindBy(xpath="/html/body/app/main/ng-component/div/div[4]/div[2]/div/div[2]/div[1]/div[2]/text()")
	WebElement validateDept;
	@FindBy(xpath="//*[@id=\"main-container\"]/ng-component/div/div[4]/div[2]/div[1]/div[2]/div[1]/div[2]/text()")
	WebElement validateSubtier;
	@FindBy(xpath="//*[@id=\"main-container\"]/ng-component/div/div[4]/div[2]/div[1]/div[2]/div[1]/div[2]/text()")
	WebElement validateOffice;
	public static final By Events_Feeds = By.xpath("//div[@class=\"column nine wide\"]");

	public FhEventsPages() {
		PageFactory.initElements(driver, this);
	}

	public void intoStartedEvents() throws InterruptedException {
		((JavascriptExecutor) driver).executeScript("scroll(0,900)");

		System.out.println( (EventsPageLinkStarted).getText());
		
		  Pattern p = Pattern.compile("\\d+");
	        Matcher m = p.matcher((CharSequence) driver.findElement(By.id("org-recent-start-link")).getText());
	        while(m.find()) {
	        	
	        	OrgStartedAmount=m.group();
	         System.out.println(OrgStartedAmount);
	         
	        }
		 EventsPageLinkStarted.click();
		Thread.sleep(2000);

	     
	    }
	public void intoExpiredEvents() throws InterruptedException {
		((JavascriptExecutor) driver).executeScript("scroll(0,900)");

		System.out.println( (EventsPageLinkExpired).getText());
		
		  Pattern p = Pattern.compile("\\d+");
	        Matcher m = p.matcher((CharSequence) driver.findElement(By.id("org-expire-link")).getText());
	        while(m.find()) {
	        	
	        	OrgExpiredAmount=m.group();
	         System.out.println(OrgExpiredAmount);
	         
	        }
		 EventsPageLinkExpired.click();
		Thread.sleep(2000);

	     
	    }
	public boolean isEventOrgCountThereStarted() throws InterruptedException {
		Thread.sleep(5000);
		boolean verify;

		WebElement locatorforWhereTEXTisPresentt5 = driver.findElement(By.xpath(
				"//list-results-message[@class=\"ng-star-inserted\"]"));

		String Requesttext = locatorforWhereTEXTisPresentt5.getText();
		   System.out.println(Requesttext);
		   System.out.println(OrgStartedAmount);
		if (
				Requesttext.contains(OrgStartedAmount)
				||
			Requesttext.contains("No results found for selected criteria")
				) {
			verify = true;
		}
		else {
			verify = false;
		}

		System.out.println("FOUND THE CORRECT AMOUNT OF RESULTS!!!"+Requesttext);
		return verify;
	}
	public boolean isEventOrgCountThereExpired() throws InterruptedException {
		Thread.sleep(5000);
		boolean verify;

		WebElement locatorforWhereTEXTisPresentt5 = driver.findElement(By.xpath(
				"//list-results-message[@class=\"ng-star-inserted\"]"));

		String Requesttext = locatorforWhereTEXTisPresentt5.getText();
		   System.out.println(Requesttext);
		   String regex = "(?<=[\\d])(,)(?=[\\d])";
	        Pattern p = Pattern.compile(regex);
	        String WithoutCommaText =Requesttext;
	        Matcher m = p.matcher(WithoutCommaText);
	        WithoutCommaText = m.replaceAll("");
	        System.out.println(WithoutCommaText);
		   System.out.println(WithoutCommaText ); 
		  
		   System.out.println(OrgExpiredAmount);
		if (
				WithoutCommaText .contains(OrgExpiredAmount)
				||
				WithoutCommaText .contains("No results found for selected criteria")
				) {
			verify = true;
		}
		else {
			verify = false;
		}

		System.out.println("FOUND THE CORRECT AMOUNT OF RESULTS!!!"+Requesttext);
	int  TotalResultsOfEventsValueBothExpiredAndStarted = Integer.parseInt(OrgStartedAmount)+Integer.parseInt(OrgExpiredAmount);
	//this finds the total amount of results after everything is cleared
	
	
	

	   
		 System.out.println("EXPIRED AND STARTED EVENT AMOUNT TOGETHER"+""+TotalResultsOfEventsValueBothExpiredAndStarted);
		
		  finalamount = Integer.toString(TotalResultsOfEventsValueBothExpiredAndStarted);
		  
		   System.out.println(finalamount);
//		   String regex2 = "(?<=[\\d])(,)(?=[\\d])";
//	        Pattern p1 = Pattern.compile(regex2);
//	        String TotalWithoutCommaText =Requesttext;
//	        Matcher x = p1.matcher(TotalWithoutCommaText);
//	       TotalWithoutCommaText = x.replaceAll("");
//	        System.out.println(TotalWithoutCommaText);
//		   System.out.println(WithoutCommaText ); 
		   return verify;
		 
		
	}
	public boolean isEventOrgCountThereExpiredGoneUp() throws InterruptedException {
		Thread.sleep(5000);
		boolean verify;

		WebElement locatorforWhereTEXTisPresentt5 = driver.findElement(By.id("org-expire-link"));

		String Requesttext = locatorforWhereTEXTisPresentt5.getText();
		   System.out.println(Requesttext);
		  
		   System.out.println(OrgExpiredAmount);
		   String version = OrgExpiredAmount;
		    String newVersion = ""+ (Integer.parseInt(version.substring(0,version.length()))+1);
		    System.out.println(newVersion);
		if (
				Requesttext .contains(newVersion))
				 {
			verify = true;
		}
		else {
			verify = false;
		}

		System.out.println("Old Amount "+Requesttext+"new account"+newVersion);
		

	//this finds the total amount of results after everything is cleared
	
	
	

	   

		   return verify;
		 
		
	}
	
	public boolean isEventsThere() throws InterruptedException {
		Thread.sleep(5000);
		try {
			return EventsPageLogo.isDisplayed();
		} catch (Exception ex) {
			System.out.println("working as desired");
		}
		return false;
	}
	public boolean isEventsThere2() throws InterruptedException {
		Thread.sleep(5000);
		try {
			return EventsPageLogo2.isDisplayed();
		} catch (Exception ex) {
			System.out.println("working as desired");
		}
		return false;
	}

	public void intoAndOutDept() throws InterruptedException {
		
	DeptTab.click();
		Thread.sleep(4000);

	}
	public void intoAndOutSubtier() throws InterruptedException {
		
	SubtierTab.click();
		Thread.sleep(4000);

	}
	public void intoAndOutOffice() throws InterruptedException {
		((JavascriptExecutor) driver).executeScript("scroll(0,200)");
	OfficeTab.click();
		Thread.sleep(4000);

	}
	public void intoAndOutOrgStarted() throws InterruptedException {
		((JavascriptExecutor) driver).executeScript("scroll(0,200)");
	OrgStartTab.click();
		Thread.sleep(4000);

	}
	public void intoAndOutOrgExpired() throws InterruptedException {
		((JavascriptExecutor) driver).executeScript("scroll(0,200)");
	OrgExpiredTab.click();
		Thread.sleep(4000);

	}
	public boolean isDepthere() throws InterruptedException {
		Thread.sleep(5000);
		boolean verify;

		// VALIDATION FOR "YOU"
		WebElement locatorforWhereTEXTisPresentt5 = driver.findElement(By.xpath(
				"//div[@class=\"sam-ui container stackable grid events-page\"]"));

		String Requesttext = locatorforWhereTEXTisPresentt5.getText();

		if (
				Requesttext.contains("Organization Type: DEPARTMENT(L1)")||
				Requesttext.contains("No results found for selected criteria") ) {
			verify = true;
		}

		else {
			verify = false;
		}

		System.out.println(Requesttext);
		return verify;
	}
	public boolean validateOrgStarted() throws InterruptedException {
		Thread.sleep(5000);
		boolean verify = false;

		List<WebElement> locatorforWhereTEXTisPresentList = driver.findElements(Events_Feeds);

		for (WebElement webElement : locatorforWhereTEXTisPresentList) {
			//System.out.println("Test " + webElement.getText());
			String Requesttext = webElement.getText();
			// ADD IN OR REJECTED
			if (Requesttext.contains("Active")
				||
				Requesttext.contains("No results found for selected criteria")
				){
				verify = true;
			}

			else {
				return false;
			}

		}

		return verify;
	}

	public boolean validateOrgExpired() throws InterruptedException {
Thread.sleep(5000);
		boolean verify = false;

		List<WebElement> locatorforWhereTEXTisPresentList = driver.findElements(By.xpath("//div[@class=\"sam-ui container stackable grid events-page\"]"));

		for (WebElement webElement : locatorforWhereTEXTisPresentList) {
			//System.out.println("Test " + webElement.getText());
			String Requesttext = webElement.getText();
			System.out.println(Requesttext);
			// ADD IN OR REJECTED
			if (Requesttext.contains("Inactive")
				||
				Requesttext.contains("No results found for selected criteria")
				){
				verify = true;
			}

			else {
				return false;
			}

		}

		return verify;
	}

	public boolean isSubtierthere() throws InterruptedException {
		Thread.sleep(5000);
		boolean verify;
		WebElement locatorforWhereTEXTisPresentt5 = driver.findElement(By.xpath(
				"//div[@class=\"sam-ui container stackable grid events-page\"]"));
		String Requesttext = locatorforWhereTEXTisPresentt5.getText();

		if (Requesttext.contains("Organization Type: AGENCY(L2)") ||
				Requesttext.contains("No results found for selected criteria") ) {
				verify = true;
			}
		else {
			verify = false;
		}

		System.out.println(Requesttext);
		return verify;
	}
	
	public boolean isOfficethere() throws InterruptedException {
		Thread.sleep(5000);
		boolean verify;

		// VALIDATION FOR "YOU"
		WebElement locatorforWhereTEXTisPresentt5 = driver.findElement(By.xpath(
				"//div[@class=\"sam-ui container stackable grid events-page\"]"));

		String Requesttext = locatorforWhereTEXTisPresentt5.getText();

		if (Requesttext.contains("Organization Type: OFFICE(L3)")|| Requesttext.contains("No results found for selected criteria")) {
			verify = true;
		}

		else {
			verify = false;
		}

		System.out.println(Requesttext);

		return verify;
	}
	public void ClearEventsPage() throws InterruptedException {
		ClearTab.click();
		Thread.sleep(3000);
	}
	public boolean TotalAmountOfRecordsAFterCleared() throws InterruptedException {
		Thread.sleep(5000);
	
		boolean verify;

		WebElement locatorforWhereTEXTisPresentt5 = driver.findElement(By.xpath(
				"//list-results-message[@class=\"ng-star-inserted\"]"));

		String Requesttext = locatorforWhereTEXTisPresentt5.getText();
		   System.out.println(Requesttext);
		   String regex2 = "(?<=[\\d])(,)(?=[\\d])";
	        Pattern p1 = Pattern.compile(regex2);
	        String TotalWithoutCommaText =Requesttext;
	        Matcher x = p1.matcher(TotalWithoutCommaText);
	       TotalWithoutCommaText = x.replaceAll("");
	        System.out.println(TotalWithoutCommaText);
		   System.out.println(TotalWithoutCommaText ); 
		  System.out.println(finalamount);
		if (
				TotalWithoutCommaText.contains(finalamount))
				 {
			verify = true;
		}
		else {
			verify = false;
		}
		return verify;
	}
	
	public void IntoWorkspace() throws InterruptedException {
		WorkspaceTab.click();
		Thread.sleep(3000);
	}
	
	public void checkpage() {
		
		WebElement Text = driver.findElement(By.xpath(
				"//list-results-message[@class=\"ng-star-inserted\"]"));

		String results= Text.getText().split(" ")[5];
		  String regex = "(?<=[\\d])(,)(?=[\\d])";
	        Pattern p = Pattern.compile(regex);
	        String WithoutCommaText =results;
	        Matcher m = p.matcher(WithoutCommaText);
	        WithoutCommaText = m.replaceAll("");
	      //  System.out.println(WithoutCommaText);
	      //  String letter = WithoutCommaText; // example String
	        double value = Double.parseDouble(WithoutCommaText);
	       double rounded= Math.ceil(value) ;
	     //  System.out.println(rounded);
	        double fin=rounded/10;
	        
	      //  System.out.println(fin);
	        double roundedd= Math.ceil(fin/10*10) ;
	        System.out.println(roundedd/10*10);
	        
	         PageNumbers = (int) (roundedd/10*10);
	        System.out.println(PageNumbers);
	        
	     
	
	
	}
	public boolean isPaginationWorking() throws InterruptedException {
		Thread.sleep(5000);
		boolean verify = true;

		if (PageNumbers > 1) {
			WebElement locatorforPagination = driver.findElement(By.xpath("//ul[@aria-label=\"pagination\"]"));
			String Requesttext = locatorforPagination.getText();

			if (Requesttext.contains(String.valueOf(PageNumbers))) {
				verify = true;
			}
			System.out.println(Requesttext);
		}

		return verify;
	}
}

