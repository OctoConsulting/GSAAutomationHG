package cmsPages;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import util.TestBase;

public class Alerts extends TestBase{
	
	public static final By FEED_ITEM = By.className("msg-feed-item");
	
	public static int PageNumbers;
	
	@FindBy(xpath = "//a[@href=\"/alerts\"]")
	WebElement MoreAlerts;
	@FindBy(xpath = "//span[@class=\"fa fa-chevron-down\"]")
	WebElement Dropdown1;
	@FindBy(xpath = "//label[text()='Draft']")
	WebElement Dropdown2;
	@FindBy(xpath = "//label[text()='Expired']")
	WebElement Dropdown3;
	@FindBy(xpath = "//label[text()='Informational']")
	WebElement Dropdown4;
	@FindBy(xpath = "//label[text()='Error']")
	WebElement Dropdown5;

	@FindBy(xpath = "//label[text()='Warning']")
	WebElement Dropdown6;

	@FindBy(xpath = "//label[text()='Wage Determination']")
	WebElement Dropdown7;
	@FindBy(xpath = "//label[text()='Active']")
	WebElement Dropdown8;
	@FindBy(xpath = "//*[@id=\"main-container\"]/ng-component/div/div[3]/div[2]/sam-multiselect-dropdown/div/div[1]")
	WebElement Dropdown9;
	@FindBy(xpath = "//div[@class=\"alert-item usa-grid-full\"]")
	WebElement Dropdown10;
	@FindBy(xpath = "//button[text()='Add New Alert']")
	WebElement CreateAlert;
	@FindBy(id="alert-types")
	WebElement Type;
	@FindBy(xpath = "//option[text()='Informational']")
	WebElement Type1;
	@FindBy(xpath = "//option[text()='Error']")
	WebElement Type2;
	@FindBy(xpath = "//option[text()='Warning']")
	WebElement Type3;
	@FindBy(xpath = "//option[text()='Wage Determination']")
	WebElement Type4;
	@FindBy(id="title-input")
	WebElement Title;
	
	@FindBy(xpath="//button[text()='Confirm']")
	WebElement confirm;
	@FindBy(xpath="//button[text()='Cancel']")
	WebElement cancel;
	
	@FindBy(id="publish-date_date month Enter Month Here")
	WebElement month;
	@FindBy(id="publish-date_date day Enter Day Here")
	WebElement day;
	@FindBy(id="publish-date_date year Enter Year Here")
	WebElement year;
	@FindBy(id="end-date_date month Enter Month Here")
	WebElement enddate;
	@FindBy(id="end-date_date day Enter Day Here")
	WebElement enddate2;
	@FindBy(id="end-date_date year Enter Year Here")
	WebElement enddate3;
	@FindBy(xpath="//span[text()=' This field is required ']")
	WebElement validation;
	@FindBy(id="publish-date_time_hour")
	WebElement hour;
	@FindBy(id="publish-date_time_minute")
	WebElement minute;
	@FindBy(id="publish-date_time_am_pm")
	WebElement ampm;
	@FindBy(xpath="//option[text()='AM']")
	WebElement am;
	@FindBy(id="end-date_time_hour")
	WebElement endhour;
	@FindBy(id="end-date_time_minute")
	WebElement endminute;
	@FindBy(id="end-date_time_am_pm")
	WebElement endampm;
	@FindBy(xpath="//*[@id=\"main-container\"]/ng-component/div/div[5]/alert-edit/form/div[1]/div[2]/div[1]/div/label")
	WebElement publish;
	@FindBy(xpath="//span[text()='Edit']")
	WebElement edit;
	@FindBy(xpath="//label[text()='No End Date']")
	WebElement noenddate;
	@FindBy(xpath="//*[@id=\"main-container\"]/ng-component/div/div[6]/alert-item/div/div[1]/div[2]/sam-toggle-switch/label/div")
	WebElement expire;
	@FindBy(xpath="//button[text()=' Expire ']")
	WebElement expire2;
	@FindBy(xpath="//*[@id='element-focus']")
	WebElement beta;
	@FindBy(xpath="//a[@title=\"System Alerts\"]")
	WebElement SystemAlerts;
	@FindBy(xpath="//*[@id=\"headerIconNotifications\"]")
	WebElement NotificationAlerts;
	@FindBy(xpath="//*[@class='fa fa-chevron-circle-right']")
	WebElement NotificationAlerts2;
	@FindBy(xpath="//a[text()='Alerts']")
	WebElement AlertsTabOnFeeds;
	@FindBy(id="Informational")
	WebElement Informational;
	@FindBy(id="Error")
	WebElement error;
	@FindBy(id="Warning")
	WebElement warning;
	@FindBy(id="Active")
	WebElement active;
	@FindBy(id="Inactive")
	WebElement inactive;
	@FindBy(xpath="//a[text()='Clear Filters']")
	WebElement clear;
	@FindBy(xpath="//a[@title=\"sort\"]")
	WebElement sort;
	@FindBy(id="search-keyword")
	WebElement searchfield;
	@FindBy(xpath="//*[@id=\"primary-content\"]/div/h1")
	WebElement AlertBanner;
	
	

// intializing the page objects/elements/
	// means DRIVER PLEASE INTILZE ALL THE GLOBAL VARIABLES ABOVE
	public Alerts() {
		
		PageFactory.initElements(driver, this);
	}

	public void intoAlerts() throws InterruptedException {
		((JavascriptExecutor) driver).executeScript("scroll(0,1900)");
		SystemAlerts.click();
		Thread.sleep(1000);
	}
	public void AlertValidatingPagination() throws InterruptedException {
		Dropdown1.click();
		Thread.sleep(1000);

		Dropdown2.click();
		Thread.sleep(1000);

		Dropdown3.click();


		Thread.sleep(1000);
		Dropdown10.click();
		Thread.sleep(1000);

	}
	public boolean AlertsCheck() throws InterruptedException {
		Thread.sleep(3000);
		boolean verify;
		driver.navigate().refresh();
		
		// VALIDATION FOR "YOU"
		WebElement locatorforWhereTEXTisPresentt5 = driver.findElement(By.xpath(
				"//div[@class=\"alert-item usa-grid-full\"]"));

		String Requesttext = locatorforWhereTEXTisPresentt5.getText();

		if (Requesttext.contains("Active")) {
			verify = true;
		}

		else {
			verify = false;
		}

		System.out.println(Requesttext);
		return verify;
	}
	public boolean AlertsCheck2() throws InterruptedException {
		Thread.sleep(3000);
		
		
		boolean verify;

		// VALIDATION FOR "YOU"
		WebElement locatorforWhereTEXTisPresentt5 = driver.findElement(By.xpath(
				"//div[@class=\"alert-item usa-grid-full\"]"));

		String Requesttext = locatorforWhereTEXTisPresentt5.getText();

		if (Requesttext.contains("Draft")) {
			verify = true;
		}

		else {
			verify = false;
		}

		System.out.println(Requesttext);
		return verify;
	}
	public boolean AlertsCheck3() throws InterruptedException {
		Thread.sleep(5000);
		;
		
		boolean verify;

		// VALIDATION FOR "YOU"
		WebElement locatorforWhereTEXTisPresentt5 = driver.findElement(By.xpath(
				"//*[@id=\"main-container\"]/ng-component/div"));

		String Requesttext = locatorforWhereTEXTisPresentt5.getText();

		if (Requesttext.contains("Informational")) {
			verify = true;
		}

		else {
			verify = false;
		}

		System.out.println(Requesttext);
		return verify;
	}
	public boolean AlertsCheck4() throws InterruptedException {
		Thread.sleep(3000);
	
		
		boolean verify;

		// VALIDATION FOR "YOU"
		WebElement locatorforWhereTEXTisPresentt5 = driver.findElement(By.xpath(
				"//*[@id=\"main-container\"]/ng-component/div/div[6]"));

		String Requesttext = locatorforWhereTEXTisPresentt5.getText();

		if (Requesttext.contains("Error")) {
			verify = true;
		}

		else {
			verify = false;
		}

		System.out.println(Requesttext);
		return verify;
	}
	public boolean AlertsCheck5() throws InterruptedException {
		Thread.sleep(3000);
	
		
		boolean verify;

		// VALIDATION FOR "YOU"
		WebElement locatorforWhereTEXTisPresentt5 = driver.findElement(By.xpath(
				"//*[@id=\"main-container\"]/ng-component/div/div[6]"));

		String Requesttext = locatorforWhereTEXTisPresentt5.getText();

		if (Requesttext.contains("Warning")) {
			verify = true;
		}

		else {
			verify = false;
		}

		System.out.println(Requesttext);
		return verify;
	}
	public boolean AlertsCheck6() throws InterruptedException {
		Thread.sleep(3000);
	
		
		boolean verify;

		// VALIDATION FOR "YOU"
		WebElement locatorforWhereTEXTisPresentt5 = driver.findElement(By.xpath(
				"//*[@id=\"main-container\"]/ng-component/div/div[6]"));

		String Requesttext = locatorforWhereTEXTisPresentt5.getText();

		if (Requesttext.contains("Wage Determination")) {
			verify = true;
		}

		else {
			verify = false;
		}

		System.out.println(Requesttext);
		return verify;
	}
	public void intoAlertsDropdown1() throws InterruptedException {
		Dropdown1.click();
		Thread.sleep(2000);

		Dropdown8.click();
		Thread.sleep(2000);
		Dropdown3.click();

		
		Thread.sleep(3000);
		Dropdown10.click();

		Thread.sleep(1000);
	}
	public void intoAlertsDropdown2() throws InterruptedException {
		Dropdown9.click();
	
		Dropdown5.click();
		Dropdown6.click();
		Dropdown7.click();
		Thread.sleep(3000);
		Dropdown10.click();
		Thread.sleep(1000);
	}
	public void intoAlertsDropdown3() throws InterruptedException {
		Dropdown9.click();
	
		Dropdown4.click();
		Dropdown5.click();
		Thread.sleep(3000);
		Dropdown10.click();
		Thread.sleep(1000);
	}
	public void intoAlertsDropdown4() throws InterruptedException {
		Dropdown9.click();
	
		Dropdown5.click();
		Dropdown6.click();
		Thread.sleep(3000);
		Dropdown10.click();
		Thread.sleep(1000);
	}
	public void intoAlertsDropdown5() throws InterruptedException {
		Dropdown9.click();
	
		Dropdown6.click();
		Thread.sleep(3000);

		Dropdown7.click();
		Thread.sleep(3000);
		Dropdown10.click();
		Thread.sleep(3000);
	}
	public void intoAlertsDropdown6() throws InterruptedException {
		Dropdown9.click();
	
		Dropdown4.click();
		Dropdown5.click();
		Dropdown6.click();

		Thread.sleep(3000);
		Dropdown10.click();
		Thread.sleep(1000);
	}
	public void NegCreateAlerts() throws InterruptedException {
		Thread.sleep(1000);

		CreateAlert.click();
		Thread.sleep(1000);

		Type.click();
		Type1.click();
		Thread.sleep(3000);
		confirm.click();
		Thread.sleep(3000);
	}
	public void NegCreateAlerts2() throws InterruptedException {
		Type.click();
		Thread.sleep(3000);

		Type2.click();
		
		Thread.sleep(3000);
		confirm.click();
		Thread.sleep(3000);
	}
	public void NegCreateAlerts3() throws InterruptedException {
		Type.click();
		Thread.sleep(3000);

		Type3.click();
		
		Thread.sleep(3000);
		confirm.click();
		Thread.sleep(3000);
	}
	public void NegCreateAlerts4() throws InterruptedException {
		Type.click();
		Thread.sleep(3000);

		Type4.click();
		
		Thread.sleep(3000);
		confirm.click();
		Thread.sleep(1000);
	}
	public void CreateAlerts5() throws InterruptedException {
		Thread.sleep(2000);
		Type.click();
		Thread.sleep(3000);
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy ");

		// get current date time with Date()
		Date date = new Date();

		// Now format the date
		String StartDate = dateFormat.format(date);

		Type1.click();
		Title.sendKeys("We are testing System alerts as a informational content");
		Thread.sleep(1000);
		
		
		WebElement editorFrame = driver.findElement(By.xpath("//*[@id=\"cke_1_contents\"]/iframe"));

		driver.switchTo().frame(editorFrame);

		WebElement body = driver.findElement(By.tagName("body"));

		body.clear(); 
		body.sendKeys("we are testing system alerts as a informational content");
	
		driver.switchTo().defaultContent();
		//description.sendKeys("we are testing system alerts as a informational content");
		Thread.sleep(2000);
		publish.click();
		Thread.sleep(3000);
		confirm.click();
		Thread.sleep(3000);
		driver.navigate().refresh();
	}
	public void CreateAlerts00() throws InterruptedException {
		CreateAlert.click();
		Thread.sleep(3000);

	}
	public void CreateAlerts6() throws InterruptedException {
		Thread.sleep(2000);
	CreateAlert.click();
		Type.click();
		Thread.sleep(1000);
		Type2.click();
		Thread.sleep(1000);
		Title.sendKeys("We are testing System alerts illustrating an error");
		Thread.sleep(4000);
		WebElement editorFrame = driver.findElement(By.xpath("/html/body/app/main/ng-component/div/div[5]/alert-edit/form/div[1]/div[1]/sam-rich-text-editor/sam-label-wrapper/div/ckeditor/div/div/div/iframe"));

		driver.switchTo().frame(editorFrame);

		WebElement body = driver.findElement(By.tagName("body"));

		body.clear(); 
		body.sendKeys("we are testing system alerts as a error content");
	
		driver.switchTo().defaultContent();
		//description.sendKeys("we are testing system alerts as a informational content");
		Thread.sleep(2000);
		publish.click();
		Thread.sleep(3000);
		

		noenddate.click();
		Thread.sleep(3000);
		Thread.sleep(1000);
		confirm.click();
		Thread.sleep(3000);
	
		
//
//		Dropdown1.click();
//		Thread.sleep(1000);
//
//		Dropdown2.click();
//		Thread.sleep(1000);
//
//		Dropdown8.click();
//		Thread.sleep(1000);
//
//		Dropdown10.click();
		Thread.sleep(1000);
	}
	/**
	 * @throws InterruptedException
	 */
	public void CreateAlerts7() throws InterruptedException {
		Thread.sleep(2000);
		CreateAlert.click();

		Type.click();
		Thread.sleep(1000);
		Type3.click();
		Title.sendKeys("testing123 we are testing system alerts as a warning content ");
Thread.sleep(1000);
		
		
		WebElement editorFrame = driver.findElement(By.xpath("/html/body/app/main/ng-component/div/div[5]/alert-edit/form/div[1]/div[1]/sam-rich-text-editor/sam-label-wrapper/div/ckeditor/div/div/div/iframe"));

		driver.switchTo().frame(editorFrame);

		WebElement body = driver.findElement(By.tagName("body"));

		body.clear(); 
		body.sendKeys("we are testing system alerts as a informational content");
	
		driver.switchTo().defaultContent();
		//description.sendKeys("we are testing system alerts as a informational content");
		Thread.sleep(3000);
		publish.click();
		Thread.sleep(3000);
		confirm.click();
		Thread.sleep(3000);

//		Dropdown1.click();
//		Thread.sleep(1000);
//
//		Dropdown2.click();
//		Thread.sleep(2000);
//
//		Dropdown8.click();
//		Thread.sleep(2000);
//
//		Dropdown10.click();
		Thread.sleep(2000);
		driver.navigate().refresh();
	}
	public void CreateAlerts8() throws InterruptedException {
		Thread.sleep(2000);
		CreateAlert.click();

		Type.click();
		Thread.sleep(1000);
		Type4.click();
		Title.sendKeys("testing123 wage determination");
Thread.sleep(1000);
		
		
WebElement editorFrame = driver.findElement(By.xpath("/html/body/app/main/ng-component/div/div[5]/alert-edit/form/div[1]/div[1]/sam-rich-text-editor/sam-label-wrapper/div/ckeditor/div/div/div/iframe"));

driver.switchTo().frame(editorFrame);

WebElement body = driver.findElement(By.tagName("body"));

body.clear(); 
body.sendKeys("we are testing system alerts as a informational content");

driver.switchTo().defaultContent();
//description.sendKeys("we are testing system alerts as a informational content");
Thread.sleep(3000);
		publish.click();
		Thread.sleep(3000);
		confirm.click();
		Thread.sleep(3000);
//
//		Dropdown1.click();
//		Thread.sleep(3000);
//
//		Dropdown2.click();
//		Thread.sleep(2000);
//
//		Dropdown8.click();
//		Thread.sleep(2000);
//
//		Dropdown10.click();
		Thread.sleep(1000);
		driver.navigate().refresh();
	}
	public void CreateAlerts9() throws InterruptedException {
		Dropdown1.click();
		Thread.sleep(1000);

		Dropdown8.click();
		Thread.sleep(1000);
		Dropdown2.click();

		
		Thread.sleep(3000);
		Dropdown10.click();

		Thread.sleep(1000);
		expire.click();
		Thread.sleep(1000);

		expire2.click();
		driver.navigate().refresh();
	}
	public boolean Validation() throws InterruptedException {
		Thread.sleep(2000);
		
		try {

			return validation.isDisplayed();
		} catch (Exception ex) {
			System.out.println("working as desired");
		}
		return false;
	}
	public boolean PublishedAlert() throws InterruptedException {
		Thread.sleep(3000);
		((JavascriptExecutor) driver).executeScript("scroll(0,-900)");

		beta.click();
		Thread.sleep(3000);
		Thread.sleep(3000);

		driver.navigate().refresh();

		Thread.sleep(3000);

		driver.navigate().refresh();

		Thread.sleep(3000);
		boolean verify;

		// VALIDATION FOR "YOU"
		WebElement locatorforWhereTEXTisPresentt5 = driver.findElement(By.xpath(
				"/html/body/app/alert-header/div/div/div"));

		String Requesttext = locatorforWhereTEXTisPresentt5.getText();

		if (Requesttext.contains("test")) {
			verify = true;
		}

		else {
			verify = false;
		}

		System.out.println(Requesttext);
		return verify;
	}
	public boolean PublishedAlert2() throws InterruptedException {

		Thread.sleep(3000);

		driver.navigate().refresh();

		Thread.sleep(3000);

		driver.navigate().refresh();

		Thread.sleep(3000);
		

		driver.navigate().refresh();

		Thread.sleep(3000);

		driver.navigate().refresh();

		Thread.sleep(3000);
		boolean verify;

		// VALIDATION FOR "YOU"
		WebElement locatorforWhereTEXTisPresentt5 = driver.findElement(By.xpath(
				"/html/body/app/alert-header/div/div/div"));

		String Requesttext = locatorforWhereTEXTisPresentt5.getText();

		if (Requesttext.contains("We are testing System alerts illustrating an error")) {
			verify = true;
		}

		else {
			verify = false;
		}

		System.out.println(Requesttext);
		return verify;
	}
	public void CreateAlerts11() throws InterruptedException {
		Thread.sleep(2000);
		CreateAlert.click();
		Type.click();
		Thread.sleep(1000);
		Type2.click();
		Title.sendKeys("We are testing System alerts illustrating an error");
Thread.sleep(1000);
		
		
		WebElement editorFrame = driver.findElement(By.xpath("/html/body/app/main/ng-component/div/div[5]/alert-edit/form/div[1]/div[1]/sam-rich-text-editor/sam-label-wrapper/div/ckeditor/div/div/div/iframe"));

		driver.switchTo().frame(editorFrame);

		WebElement body = driver.findElement(By.tagName("body"));

		body.clear(); 
		body.sendKeys("we are testing system alerts as a informational content");
	
		driver.switchTo().defaultContent();
		//description.sendKeys("we are testing system alerts as a informational content");
		Thread.sleep(3000);
		publish.click();
		Thread.sleep(3000);
		

		noenddate.click();
		Thread.sleep(3000);
		Thread.sleep(1000);
		confirm.click();
		Thread.sleep(5000);
		driver.navigate().refresh();
	}
	public void CreateAlerts10() throws InterruptedException {
		MoreAlerts.click();
		Thread.sleep(3000);

		Dropdown9.click();
		Thread.sleep(3000);
		Dropdown5.click();
		Thread.sleep(3000);

		expire.click();
		Thread.sleep(3000);
		expire2.click();
		Thread.sleep(3000);


		expire.click();
		Thread.sleep(3000);
		expire2.click();

		Thread.sleep(3000);
		expire.click();
		Thread.sleep(3000);
		expire2.click();;
		Thread.sleep(5000);
		((JavascriptExecutor) driver).executeScript("scroll(0,-900)");
		Thread.sleep(5000);
		

		CreateAlert.click();
		Type.click();
		Thread.sleep(1000);
		Type2.click();
		Title.sendKeys("We are testing System alerts illustrating an error");
Thread.sleep(1000);
		
		
		WebElement editorFrame = driver.findElement(By.xpath("/html/body/app/main/ng-component/div/div[5]/alert-edit/form/div[1]/div[1]/sam-rich-text-editor/sam-label-wrapper/div/ckeditor/div/div/div/iframe"));

		driver.switchTo().frame(editorFrame);

		WebElement body = driver.findElement(By.tagName("body"));

		body.clear(); 
		body.sendKeys("we are testing system alerts as a informational content");
	
		driver.switchTo().defaultContent();
		//description.sendKeys("we are testing system alerts as a informational content");
		Thread.sleep(3000);
		publish.click();
		Thread.sleep(3000);

		noenddate.click();
		Thread.sleep(3000);
		Thread.sleep(1000);
		confirm.click();
		Thread.sleep(5000);
				
		//beta.click();
		//driver.navigate().refresh();
		//Thread.sleep(3000);

		//driver.navigate().refresh();

		//Thread.sleep(3000);

		driver.navigate().refresh();

		Thread.sleep(3000);

		driver.navigate().refresh();

	}
	public void NotificationDelete() throws InterruptedException {
		Thread.sleep(3000);
		beta.click();
		Thread.sleep(3000);
		MoreAlerts.click();
		Thread.sleep(3000);

		Thread.sleep(3000);
		
		expire.click();
		Thread.sleep(3000);
		expire2.click();
		driver.navigate().refresh();
		Thread.sleep(3000);


		expire.click();
		Thread.sleep(3000);
		expire2.click();
		driver.navigate().refresh();
		Thread.sleep(3000);
		expire.click();
		Thread.sleep(3000);
		expire2.click();
		driver.navigate().refresh();
		Thread.sleep(3000);
		expire.click();
		Thread.sleep(3000);
		expire2.click();
		driver.navigate().refresh();

		Thread.sleep(3000);
		expire.click();
		Thread.sleep(3000);
		expire2.click();
		driver.navigate().refresh();
		Thread.sleep(3000);
		driver.navigate().refresh();
		Thread.sleep(3000);
		


	}
public void checkpage() {
		
		WebElement Text = driver.findElement(By.xpath(
				"//div[@class=\"pull-left\"]"));

		String results= Text.getText().split(" ")[3];
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
	        double fin=rounded/5;
	        
	      //  System.out.println(fin);
	        double roundedd= Math.ceil(fin/5*5) ;
	        System.out.println(roundedd/5*5);
	        
	         PageNumbers = (int) (roundedd/5*5);
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
public void checkpageNoticationAlert() throws InterruptedException {
	clear.click();
	Thread.sleep(1000);
	AlertsTabOnFeeds.click();
	Thread.sleep(1000);
	WebElement Text = driver.findElement(By.xpath(
			"//div[@class=\"pull-left p_T-3x\"]"));
	System.out.println(Text);
	String results= Text.getText().split(" ")[4];
	System.out.println(results);
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
	public boolean isPaginationWorkingAlertFeeds() throws InterruptedException {
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
	public void validateNotification() throws InterruptedException {
		Thread.sleep(4000);
		((JavascriptExecutor) driver).executeScript("scroll(0,-900)");
		Thread.sleep(3000);
		
		driver.navigate().refresh();
		
		Thread.sleep(3000);
		NotificationAlerts.click();
		Thread.sleep(3000);
		((JavascriptExecutor) driver).executeScript("scroll(0,200)");
		Thread.sleep(3000);
		NotificationAlerts2.click();
		Thread.sleep(3000);
		driver.navigate().refresh();
		
		
		
		
	}
	public void validateNotificationForAlertsTab() throws InterruptedException {
		Thread.sleep(4000);
		((JavascriptExecutor) driver).executeScript("scroll(0,-900)");
		Thread.sleep(3000);
		
		driver.navigate().refresh();
		
		Thread.sleep(3000);
		NotificationAlerts.click();
		Thread.sleep(3000);
		((JavascriptExecutor) driver).executeScript("scroll(0,200)");
		Thread.sleep(3000);
		NotificationAlerts2.click();
		Thread.sleep(3000);
		AlertsTabOnFeeds.click();
		Thread.sleep(3000);
		
		
		
	}
	public boolean AlertFeedPage() {
return AlertBanner.isDisplayed();
	}
	public boolean ValidationNotificationsName2() throws InterruptedException{
		Thread.sleep(5000);
		WebElement locatorforWhereTEXTisPresentt5 = driver.findElement(By.className("msg-feed-item"));

		String Requesttext = locatorforWhereTEXTisPresentt5.getText();
		

		boolean verify;
		if (Requesttext.contains("We are testing System alerts illustrating an error")) {
			verify = true;
		} else {
			verify = false;
		} // To make this more consistant, check the current time again and rerun the if
			// and else statement
		return verify;

		
	}
	public boolean ValidationNotificationsName1(){
		WebElement locatorforWhereTEXTisPresentt5 = driver.findElement(By.className("msg-feed-item"));

		String Requesttext = locatorforWhereTEXTisPresentt5.getText();
		

		boolean verify;
		if (Requesttext.contains("We are testing System alerts as a informational content")) {
			verify = true;
		} else {
			verify = false;
		} // To make this more consistant, check the current time again and rerun the if
			// and else statement
		return verify;

		
	}
	public boolean ValidationNotificationsName3(){
		WebElement locatorforWhereTEXTisPresentt5 = driver.findElement(By.className("msg-feed-item"));

		String Requesttext = locatorforWhereTEXTisPresentt5.getText();
		

		boolean verify;
		if (Requesttext.contains("we are testing system alerts as a warning content")) {
			verify = true;
		} else {
			verify = false;
		} // To make this more consistant, check the current time again and rerun the if
			// and else statement
		return verify;

		
	}
	public boolean ValidationNotificationsName4(){
		WebElement locatorforWhereTEXTisPresentt5 = driver.findElement(By.className("msg-feed-item"));

		String Requesttext = locatorforWhereTEXTisPresentt5.getText();
		

		boolean verify;
		if (Requesttext.contains("testing123 wage determination")) {
			verify = false;
		} else {
			verify = true;
		} // To make this more consistant, check the current time again and rerun the if
			// and else statement
		return verify;

		
	}
	public void validateNotification2() throws InterruptedException {
		
		Thread.sleep(2000);
		MoreAlerts.click();
		Thread.sleep(2000);
		
	}
	public static List<WebElement> getFeedsList() {
		return driver.findElements(FEED_ITEM);

	}
	public static String getLastRequestRequestTimestamp() {
		List<WebElement> feedList = getFeedsList();
		String timestamp = feedList.get(0).findElement(By.className("msg-feed-date")).getText();
		String[] truetimestamp;
		
		
		if(timestamp.contains("PM")) {
			truetimestamp = timestamp.split("PM");
		} else { truetimestamp = timestamp.split("AM");}
			
		return truetimestamp[0].toString();
	}
	public boolean InformationalCheckFeeds() throws InterruptedException {
		Thread.sleep(5000);
		Informational.click();
		Thread.sleep(2000);
		boolean verify;

		// VALIDATION FOR "YOU"
		WebElement locatorforWhereTEXTisPresentt5 = driver.findElement(By.xpath(
				"//*[@id='main-container']//page/div/div/div[2]/div[2]/div[1]"));

		String Requesttext = locatorforWhereTEXTisPresentt5.getText();

		if (Requesttext.contains("informational")) {
			verify = true;
		}

		else {
			verify = false;
		}

		System.out.println(Requesttext);
		return verify;
	}
	public boolean ErrorCheckFeeds() throws InterruptedException {
		Informational.click();
		Thread.sleep(2000);
		error.click();
		Thread.sleep(2000);

		boolean verify;

		// VALIDATION FOR "YOU"
		WebElement locatorforWhereTEXTisPresentt5 = driver.findElement(By.xpath(
				"//*[@id='main-container']//page/div/div/div[2]/div[2]/div[1]"));

		String Requesttext = locatorforWhereTEXTisPresentt5.getText();

		if (Requesttext.contains("error")) {
			verify = true;
		}

		else {
			verify = false;
		}

		System.out.println(Requesttext);
		return verify;
	}
	public boolean WarningCheckFeeds() throws InterruptedException {
		error.click();
		Thread.sleep(2000);
		warning.click();
		Thread.sleep(2000);


		boolean verify;

		// VALIDATION FOR "YOU"
		WebElement locatorforWhereTEXTisPresentt5 = driver.findElement(By.xpath(
				"//*[@id='main-container']//page/div/div/div[2]/div[2]/div[1]"));

		String Requesttext = locatorforWhereTEXTisPresentt5.getText();

		if (Requesttext.contains("warning")) {
			verify = true;
		}

		else {
			verify = false;
		}

		System.out.println(Requesttext);
		return verify;
	}
	public boolean ActiveCheckFeeds() throws InterruptedException {
		Thread.sleep(2000);
		warning.click();
		Thread.sleep(2000);
		active.click();
		Thread.sleep(2000);

		boolean verify;

		// VALIDATION FOR "YOU"
		WebElement locatorforWhereTEXTisPresentt5 = driver.findElement(By.xpath(
				"//*[@id='main-container']//page/div/div/div[2]/div[2]/div[1]"));

		String Requesttext = locatorforWhereTEXTisPresentt5.getText();

		if (Requesttext.contains("Inactive")) {
			verify = false;
		}

		else {
			verify = true;
		}

		System.out.println(Requesttext);
		return verify;
	}
	public boolean InactiveCheckFeeds() throws InterruptedException {
		Thread.sleep(2000);
		active.click();
		Thread.sleep(2000);
		inactive.click();
		Thread.sleep(2000);

		boolean verify;

		// VALIDATION FOR "YOU"
		WebElement locatorforWhereTEXTisPresentt5 = driver.findElement(By.xpath(
				"//*[@id='main-container']//page/div/div/div[2]/div[2]/div[1]"));

		String Requesttext = locatorforWhereTEXTisPresentt5.getText();

		if (Requesttext.contains("Inactive")) {
			verify = true;
		}

		else {
			verify = false;
		}

		System.out.println(Requesttext);
		return verify;
	}
	public boolean ClearFiltersCheckFeeds() throws InterruptedException {
		Thread.sleep(2000);
		inactive.click();
		Thread.sleep(2000);
		clear.click();
		Thread.sleep(2000);

		boolean verify;

		// VALIDATION FOR "YOU"
		WebElement locatorforWhereTEXTisPresentt5 = driver.findElement(By.xpath(
				"//*[@id='main-container']//page/div/div/div[2]/div[2]/div[1]"));

		String Requesttext = locatorforWhereTEXTisPresentt5.getText();

		if (Requesttext.contains("warning")) {
			verify = true;
		}

		else {
			verify = false;
		}

		System.out.println(Requesttext);
		return verify;
	}
	public boolean SortFilters() throws InterruptedException {
		sort.click();
		Thread.sleep(2000);

		boolean verify;

		// VALIDATION FOR "YOU"
		WebElement locatorforWhereTEXTisPresentt5 = driver.findElement(By.xpath(
				"//*[@id='main-container']//page/div/div/div[2]/div[2]/div[1]"));

		String Requesttext = locatorforWhereTEXTisPresentt5.getText();

		if (Requesttext.contains("Inactive")) {
			verify = true;
		}

		else {
			verify = false;
		}

		System.out.println(Requesttext);
		return verify;
		
		
	}
	public boolean SearchBox() throws InterruptedException {
		clear.click();
		Thread.sleep(2000);
		searchfield.sendKeys("error");
		searchfield.sendKeys(Keys.ENTER); 
		Thread.sleep(2000);

		boolean verify;
		WebElement locatorforWhereTEXTisPresentt5 = driver.findElement(By.xpath(
				"//*[@id='main-container']//page/div/div/div[2]/div[2]/div[1]"));

		String Requesttext = locatorforWhereTEXTisPresentt5.getText();

		if (Requesttext.contains("Error")) {
			verify = true;
		}

		else {
			verify = false;
		}

		System.out.println(Requesttext);
		return verify;
		
		
	}
}
