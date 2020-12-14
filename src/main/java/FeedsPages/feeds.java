package FeedsPages;

import java.util.List;

//import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import util.TestBase;

public class feeds extends TestBase{
	@FindBy(id="headerIconRequests")
	WebElement FeedsMainDropdown;
	@FindBy(className="fa-chevron-circle-right")
	WebElement FeedsMainDropdownMORE;
	@FindBy(linkText="Sent")
	WebElement SentTab;
	@FindBy (linkText="Received")
	WebElement Receivedtab;
	@FindBy(xpath="//a[text()='Requests']")
	WebElement Request;
	@FindBy(xpath="//input[@id=\"Pending\"]")
	WebElement Pending;
	@FindBy(linkText="Sent")
	WebElement Sent;
	@FindBy(id="userPicker")
	WebElement searchindirectory;
	@FindBy(xpath="//select[@id=\"sort-select\"]")
	WebElement sortingfeeds;
	@FindBy(xpath="//a[@title=\"sort\"]")
	WebElement sortingfeedsUPDOWN;
	@FindBy(xpath="//option[text()='Response Date']")
	WebElement Responsedatetab;
	@FindBy(xpath="//input[@id=\"Role Assignments\"]")
	WebElement RoleAssignment;
	@FindBy(xpath="//*[@id=\"sanzedah.rahman+dep@gsa.gov-action-button\"]")
	WebElement actions;
	@FindBy(xpath="//*[@id=\"sanzedah.rahman+norole@gsa.gov-action-button\"]")
	WebElement actions2;
	@FindBy(xpath="//span[text()='Assign Role']")
	WebElement assignrole;
	
	public static final By FEED_ITEM = By.className("msg-feed-item");
	public static final By Feed_Item2=By.xpath("//*[@id='main-container']/msg-feed-container/msg-feed-requests/page/div/div/div[2]/div[2]/div[1]/div[3]/div[1]/div[1]/span[1]");
	
	public feeds() {
		PageFactory.initElements(driver, this);
	}
	public void GoToFeedsPage() throws InterruptedException {
		Thread.sleep(3000);
		FeedsMainDropdown.click();
		Thread.sleep(3000);
		FeedsMainDropdownMORE.click();
		Thread.sleep(3000);
		SentTab.click();
		Thread.sleep(3000);
	}
	public void intoReceived() throws InterruptedException {
	Receivedtab.click();
	Thread.sleep(6000);
	}
	public void intoRoleAssignmentsTab() throws InterruptedException {
		((JavascriptExecutor) driver).executeScript("scroll(0,600)");
		RoleAssignment.click();
		Thread.sleep(3000);
		((JavascriptExecutor) driver).executeScript("scroll(0,-600)");
		Thread.sleep(3000);
	
	}
	public void intoSent() throws InterruptedException {
		Sent.click();
		Thread.sleep(4000);
		}
	public void intoRequest() throws InterruptedException {
		Request.click();
		Thread.sleep(4000);
		}
	public void Sorttab() throws InterruptedException {
		sortingfeeds.click();
		Thread.sleep(4000);
		}
	public void SorttabASCDESC() throws InterruptedException {
		sortingfeedsUPDOWN.click();
		Thread.sleep(4000);
		}
	public void IntoResponseDate() throws InterruptedException {
		Responsedatetab.click();
		Thread.sleep(8000);
		}
	
	
	public void intoPending() throws InterruptedException {
		((JavascriptExecutor) driver).executeScript("scroll(0,800)");
	Pending.click();
	Thread.sleep(2000);
	((JavascriptExecutor) driver).executeScript("scroll(0,-800)");
	}
	
	public static List<WebElement> getFeedsList() {
		return driver.findElements(FEED_ITEM);

	}
	public static List<WebElement> getFeedsRejectedList() {
		return driver.findElements(Feed_Item2);

	}
	public void SearchAUserInDirectory() throws InterruptedException {
		String noRoleUser = prop.getProperty("NoRole");
		
		searchindirectory.click();
		
		searchUserInUserPicker(noRoleUser);
		Thread.sleep(4000);
		actions2.click();
		Thread.sleep(2000);
		assignrole.click();
		Thread.sleep(3000);
		//clickAssignRole(noRoleUser);
		Thread.sleep(4000);
	}
	public void SearchAUserInDirectoryMove() throws InterruptedException {
		String DepRoleUser = prop.getProperty("DeptAdmin");
		
		searchindirectory.click();
		
		searchUserInUserPicker(DepRoleUser);
		Thread.sleep(4000);
		actions.click();
		Thread.sleep(2000);
		driver.findElement(By.id("menuitem0")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@aria-label=\"Edit Role Button\"]")).click();
		Thread.sleep(4000);
		((JavascriptExecutor) driver).executeScript("scroll(0,600)");
	}
		

	public void Maindropdown() throws InterruptedException{
		FeedsMainDropdown.click();
		Thread.sleep(4000);
		
	}
	public void Openmorefeeds() throws InterruptedException {
		FeedsMainDropdownMORE.click();
		Thread.sleep(4000);
		
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
	
	
	public static String getLastRejectedRequestTimestamp() {
		List<WebElement> RejectedfeedList = getFeedsRejectedList();
		String timestamp = RejectedfeedList.get(0).findElement(By.xpath("//div[@class=\"usa-width-one-whole msg-feed-date\"]")).getText();
		String[] truetimestamp;
		
		
		if(timestamp.contains("PM")) {
			truetimestamp = timestamp.split("PM");
		} else { truetimestamp = timestamp.split("AM");}
			
		return truetimestamp[0].toString();
	}
	

	public static void clickActions(String useremail) throws InterruptedException {
	Thread.sleep(2000);
		int itemNo = 0;
		String id = useremail.concat("-action-" + itemNo);
		driver.findElement(By.id(id)).click();
		Thread.sleep(3000);
	}
	

	public static void searchUserInUserPicker(String user) throws InterruptedException {
		driver.findElement(By.id("userPicker")).sendKeys(user);
	Thread.sleep(3000);
		driver.findElement(By.id("userPicker-resultItem-0")).click();
		Thread.sleep(3000);
	}
	
	
	
	
	public static void clickAssignRole(String useremail) throws InterruptedException {
		clickActions(useremail);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"main-container\"]/ng-component/page/div/div/div[2]/div[2]/results/div[3]/div[1]/sam-actions-dropdown/div/ul/li[1]/button/span[2]")).click();
	
	}
	
	
	public boolean validatestatuspending() {
		return driver.findElement(By.xpath("//div[text()='Pending']")).isDisplayed();
		}
	public boolean validatestatusApproved() {
		return driver.findElement(By.xpath("//div[text()='Approved']")).isDisplayed();
		}
	

public boolean validateAdminsDropdown() {
	return driver.findElement(By.xpath("//span[text()='sanzedah.rahman+norole@gsa.gov']")).isDisplayed();
}
public boolean validatereject() {
	return driver.findElement(By.xpath("//div[text()='Rejected']")).isDisplayed();
}

public boolean validateadminemail() {
	return driver.findElement(By.xpath("//div[@class=\"usa-width-one-whole msg-feed-name\"]")).isDisplayed();
	
}

public void validatingfeedsRequester(String Name, String RoleName, String OrgName, String DomainName) {
	boolean verify;
	WebElement locatorforWhereTEXTisPresent = driver.findElement(By.xpath(
			"//*[@id=\"main-container\"]/ng-component/page/div/div/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/span[1]"));

	String Requesttext = locatorforWhereTEXTisPresent.getText();

	if (Requesttext.contains(prop.getProperty("Name"))) {
		verify = true;
	} else {
		verify = false;
	}

	//Assert.assertTrue(verify);

	System.out.println(Requesttext);



}

}
