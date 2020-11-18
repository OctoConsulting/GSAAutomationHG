package FeedsPages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import util.TestBase;

public class FilterFeeds extends TestBase {
	@FindBy(xpath = "//a[text()='Requests']")
	WebElement requestTab;
	@FindBy(xpath = "//input[@id=\"search-keyword\"]")
	WebElement RequestBox;
	@FindBy(xpath = "//a[text()='Clear Filters']")
	WebElement ClearFilters;
	@FindBy(xpath = "//textarea[@id=\"search-requester-ac-textarea\"]")
	WebElement RequestorBox;
	@FindBy(id="1-item-0")
	WebElement requestoroption;
	@FindBy(xpath = "//textarea[@id=\"search-approver-ac-textarea\"]")
	WebElement approvertab;
	@FindBy(xpath = "//p[text()=' sanzedah.rahman+assistanceadmin@gsa.gov ']")
	WebElement approveroption;
	@FindBy(id = "federalHierarchy")
	WebElement OrganizationBox;
	@FindBy(xpath = "//textarea[@id=\"entity-ac-textarea\"]")
	WebElement EntityBox;
	@FindBy(id = "federalHierarchy_100167252")
	WebElement OrganizationOption;
	@FindBy(id="1-item-0")
	WebElement EntityOption;
	@FindBy(id="federalHierarchy_100174847")
	WebElement NEGOrganizationOption;
	@FindBy(xpath = "//input[@id=\"Role Requests\"]")
	WebElement RoleRequestFilter;
	@FindBy(xpath = "//input[@id=\"Role Assignments\"]")
	WebElement RoleAssignmentsFilter;
	@FindBy(xpath = "//a[text()='2']")
	WebElement Page2;
	@FindBy(xpath = "//a[text()='6']")
	WebElement Page6;
	@FindBy(xpath = "//input[@id=\"Pending\"]")
	WebElement PendingFilter;
	@FindBy(xpath = "//input[@id=\"Approved\"]")
	WebElement ApprovedFilter;
	@FindBy(xpath = "//input[@id=\"Rejected\"]")
	WebElement RejectedFilter;
	@FindBy(xpath = "//input[@id=\"Canceled\"]")
	WebElement CanceledFilter;
	@FindBy(xpath = "//input[@id=\"Complete\"]")
	WebElement CompleteFilter;
	// -----------------------------------
	// ISDISPLAYED TABS
	@FindBy(xpath = "//*[text()='Title Change']")
	WebElement TitlechangeTab;
	@FindBy(xpath = "//*[text()='Role Requests']")
	WebElement RoleRequestsTab;
	@FindBy(xpath = "//*[text()='Number Change']")
	WebElement NumberChangeTab;
	@FindBy(xpath = "//*[text()='Archive']")
	WebElement ArchiveTab;
	@FindBy(xpath = "//*[text()='Agency Change']")
	WebElement AgencyChangeTab;
	@FindBy(xpath = "//*[text()='Submit AL']")
	WebElement SubmitALTab;
	@FindBy(xpath = "//*[text()='Role Assignments']")
	WebElement RoleAssignmentsTab;
	@FindBy(xpath = "//*[text()='Entity']")
	WebElement EntityTab;
	@FindBy(xpath = "//*[text()='Opp Attachment Request']")
	WebElement OppAttachmentRequestTab;
	public static final By FEED_ITEM = By.className("msg-feed-item");
	public static final By FEED_ITEM2 = By.xpath("//*[@id=\"main-container\"]/msg-feed-container/msg-feed-requests/page/div/div/div[2]/div[2]/div[1]/div[3]");
	public FilterFeeds() {
		PageFactory.initElements(driver, this);
	}

	public void RoleAssignmentsFilterTab() throws InterruptedException {
		RoleAssignmentsFilter.click();
		Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("scroll(0,-600)");
		Thread.sleep(1000);
	}

	public boolean SidePresence1() throws InterruptedException {
		((JavascriptExecutor) driver).executeScript("scroll(0,800)");
		Thread.sleep(9000);
		try {
		return TitlechangeTab.isDisplayed();
		}catch(Exception ex) {
			System.out.println("working as desired");
		}
		return false;
	}
	

	public boolean SidePresenceEntity() throws InterruptedException {
	//	((JavascriptExecutor) driver).executeScript("scroll(0,-300)");
		Thread.sleep(1000);
		try {
		return EntityTab.isDisplayed();
	}catch(Exception ex) {
		System.out.println("working as desired");
	}
	return false;
}

	
	public boolean SidePresenceOppAttachment() throws InterruptedException {
	//	((JavascriptExecutor) driver).executeScript("scroll(0,900)");
		Thread.sleep(1000);
		try {
		return OppAttachmentRequestTab.isDisplayed();
		}catch(Exception ex) {
			System.out.println("working as desired");
		}
		return false;
	
	}


	public boolean SidePresence2() throws InterruptedException {
		//((JavascriptExecutor) driver).executeScript("scroll(0,700)");
		Thread.sleep(1000);
		try {
		return RoleRequestsTab.isDisplayed();
		}catch(Exception ex) {
			System.out.println("working as desired");
		}
		return false;
	}

	public boolean SidePresence3() throws InterruptedException {
		//((JavascriptExecutor) driver).executeScript("scroll(0,700)");
		Thread.sleep(1000);
		try {
		return NumberChangeTab.isDisplayed();
		}catch(Exception ex) {
			System.out.println("working as desired");
		}
		return false;
	}

	public boolean SidePresence4() throws InterruptedException {
	//	((JavascriptExecutor) driver).executeScript("scroll(0,700)");
		Thread.sleep(1000);
		try {
		return ArchiveTab.isDisplayed();
		}catch(Exception ex) {
			System.out.println("working as desired");
		}
		return false;
	}

	public boolean SidePresence5() throws InterruptedException {
	//	((JavascriptExecutor) driver).executeScript("scroll(0,700)");
		Thread.sleep(1000);
		try {
		return AgencyChangeTab.isDisplayed();
		}catch(Exception ex) {
			System.out.println("working as desired");
		}
		return false;
	}

	public boolean SidePresence6() throws InterruptedException {
		//((JavascriptExecutor) driver).executeScript("scroll(0,700)");
		Thread.sleep(1000);
		try {
		return SubmitALTab.isDisplayed();
		}catch(Exception ex) {
			System.out.println("working as desired");
		}
		return false;
	}

	public boolean SidePresence7() throws InterruptedException {
	//	((JavascriptExecutor) driver).executeScript("scroll(0,700)");
		Thread.sleep(1000);
		try {
		return RoleAssignmentsTab.isDisplayed();
		}catch(Exception ex) {
			System.out.println("working as desired");
		}
		return false;

	}

	public void UncheckRoleAssignmentsFilterTab() throws InterruptedException {
		Thread.sleep(1000);
		((JavascriptExecutor) driver).executeScript("scroll(0,600)");
		RoleAssignmentsFilter.click();
		Thread.sleep(1000);
	}

	public void PendingFilterTab() throws InterruptedException {
		PendingFilter.click();
		((JavascriptExecutor) driver).executeScript("scroll(0,-800)");
		Thread.sleep(4000);
	}

	public void UncheckPendingFilterTab() throws InterruptedException {
		((JavascriptExecutor) driver).executeScript("scroll(0,800)");
		PendingFilter.click();
		Thread.sleep(2000);
	}

	public void RejectedFilterTab() throws InterruptedException {
		RejectedFilter.click();
		Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("scroll(0,-800)");
	}

	public void UncheckRejectedFilterTab() throws InterruptedException {
		((JavascriptExecutor) driver).executeScript("scroll(0,800)");
		Thread.sleep(2000);
		RejectedFilter.click();
		Thread.sleep(2000);
	}

	public void CompleteFilterTab() throws InterruptedException {
		CompleteFilter.click();
		Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("scroll(0,-800)");
	}

	public void UncheckCompleteFilterTab() throws InterruptedException {
		((JavascriptExecutor) driver).executeScript("scroll(0,800)");
		CompleteFilter.click();
		Thread.sleep(2000);
	}

	public void ApprovedFilterTab() throws InterruptedException {
		ApprovedFilter.click();
		Thread.sleep(4000);
		((JavascriptExecutor) driver).executeScript("scroll(0,-800)");
	}
	public void ApprovedFilterTabContinuedPages() throws InterruptedException {
		
		((JavascriptExecutor) driver).executeScript("scroll(0,800)");
		driver.findElement(By.xpath("//a[text()='2']")).click();
		Thread.sleep(4000);
		((JavascriptExecutor) driver).executeScript("scroll(0,-800)");
		
	}
public void ApprovedFilterTabRandomPages() throws InterruptedException {
		
		((JavascriptExecutor) driver).executeScript("scroll(0,800)");
		driver.findElement(By.xpath("//a[text()='6']")).click();
		Thread.sleep(4000);
		((JavascriptExecutor) driver).executeScript("scroll(0,-800)");
	}

	public void UncheckApprovedFilterTab() throws InterruptedException {
		((JavascriptExecutor) driver).executeScript("scroll(0,800)");
		ApprovedFilter.click();
		Thread.sleep(4000);
	}

	public void CanceledFilterTab() throws InterruptedException {
		CanceledFilter.click();
		Thread.sleep(4000);
		((JavascriptExecutor) driver).executeScript("scroll(0,-700)");
	}

	public void UncheckCanceledFilterTab() throws InterruptedException {
		((JavascriptExecutor) driver).executeScript("scroll(0,800)");
		CanceledFilter.click();
		Thread.sleep(2000);
	}

	public void RoleRequestFilterTab() throws InterruptedException {
		((JavascriptExecutor) driver).executeScript("scroll(0,600)");
		Thread.sleep(2000);
		RoleRequestFilter.click();
		Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("scroll(0,-600)");
	}

	public void UncheckRoleRequestFilterTab() throws InterruptedException {
		((JavascriptExecutor) driver).executeScript("scroll(0,600)");
		RoleRequestFilter.click();
		Thread.sleep(2000);

	}

	public boolean RoleRequestBoxValidation(String status) {

		boolean verify = false;

		List<WebElement> locatorforWhereTEXTisPresentList = driver.findElements(FEED_ITEM);

		for (WebElement webElement : locatorforWhereTEXTisPresentList) {
			System.out.println("Test " + webElement.getText());
			String Requesttext = webElement.getText();
			// ADD IN OR REJECTED
			if (Requesttext.contains(status)) {
				verify = true;
			}

			else {
				return false;
			}

		}

		return verify;
	}

	public boolean RoleAssignmentValidation(String name, String status) {

		boolean verify = false;

		List<WebElement> locatorforWhereTEXTisPresentList = driver.findElements(FEED_ITEM);

		for (WebElement webElement : locatorforWhereTEXTisPresentList) {
			System.out.println("Test " + webElement.getText());
			String Requesttext = webElement.getText();
			// ADD IN OR REJECTED
			if (Requesttext.contains(name) && Requesttext.contains(status)) {
				verify = true;
			}

			else {
				return false;
			}

		}

		return verify;
	}

	public boolean RecievedValidation() {

		boolean verify = false;

		List<WebElement> locatorforWhereTEXTisPresentList = driver.findElements(FEED_ITEM);

		for (WebElement webElement : locatorforWhereTEXTisPresentList) {
			System.out.println("Test " + webElement.getText());
			String Requesttext = webElement.getText();
			// ADD IN OR REJECTED
			if (Requesttext.contains("Assistance")) {
				verify = true;
			}

			else {
				return false;
			}

		}

		return verify;
	}

	public boolean OrganizationValidation() {

		boolean verify = false;

		List<WebElement> locatorforWhereTEXTisPresentList = driver.findElements(FEED_ITEM);

		for (WebElement webElement : locatorforWhereTEXTisPresentList) {
			System.out.println("Test " + webElement.getText());
			String Requesttext = webElement.getText();
			// ADD IN OR REJECTED
			if (Requesttext.contains("INTEGRATED AWARD ENVIRONMENT(QD)")) {
				verify = true;
			}

			else {
				return false;
			}

		}

		return verify;
	}
	public boolean OrganizationValidation00() {

		boolean verify = false;

		List<WebElement> locatorforWhereTEXTisPresentList = driver.findElements(FEED_ITEM2);

		for (WebElement webElement : locatorforWhereTEXTisPresentList) {
			System.out.println("Test " + webElement.getText());
			String Requesttext = webElement.getText();
			// ADD IN OR REJECTED
			if (Requesttext.contains("No Request")) {
				verify = true;
			}

			else {
				return false;
			}

		}

		return verify;
	}
	public boolean EntityValidation() throws InterruptedException {
Thread.sleep(4000);
		boolean verify = false;

		List<WebElement> locatorforWhereTEXTisPresentList = driver.findElements(FEED_ITEM);

		for (WebElement webElement : locatorforWhereTEXTisPresentList) {
			System.out.println("Test " + webElement.getText());
			String Requesttext = webElement.getText();
			// ADD IN OR REJECTED
			if (Requesttext.contains("Octo Consulting Group")) {
				verify = true;
			}

			else {
				return false;
			}

		}

		return verify;
	}
	public boolean SentValidation() {

		boolean verify = false;

		List<WebElement> locatorforWhereTEXTisPresentList = driver.findElements(FEED_ITEM);

		for (WebElement webElement : locatorforWhereTEXTisPresentList) {
			System.out.println("Test " + webElement.getText());
			String Requesttext = webElement.getText();
			// ADD IN OR REJECTED
			if (Requesttext.contains("You") 
					//&& Requesttext.contains(prop.getProperty("OrgName"))
					) {
				verify = true;
			}

			else {
				return false;
			}

		}

		return verify;
	}

	public void clearTHEfilters() throws InterruptedException {
		Thread.sleep(4000);
		((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
		ClearFilters.click();
		Thread.sleep(4000);
		((JavascriptExecutor) driver).executeScript("scroll(0,-600)");
		Thread.sleep(4000);
	}

	public boolean SearchRequestBoxValidation(String status, String roleName) {
			//String orgName, String domainName) {

		boolean verify = false;

		List<WebElement> locatorforWhereTEXTisPresentList = driver.findElements(FEED_ITEM);

		for (WebElement webElement : locatorforWhereTEXTisPresentList) {
			System.out.println("Test " + webElement.getText());
			String Requesttext = webElement.getText();
			// ADD IN OR REJECTED
			if (Requesttext.contains(status) && Requesttext.contains(roleName)
					//&& Requesttext.contains(orgName)
					//&& Requesttext.contains(domainName)
					) {
				verify = true;
			}

			else {
				return false;
			}

		}

		return verify;
	}

	public boolean SearchRequestorBoxValidation() {

		boolean verify = false;

		List<WebElement> locatorforWhereTEXTisPresentList = driver.findElements(FEED_ITEM);

		for (WebElement webElement : locatorforWhereTEXTisPresentList) {
			System.out.println("Test " + webElement.getText());
			String Requesttext = webElement.getText();
			// ADD IN OR REJECTED
			if (Requesttext.contains("requested") && Requesttext.contains("sanzedah rahman")) {
				verify = true;
			}

			else {
				return false;
			}

		}

		return verify;
	}

	public boolean SearchApproverBoxValidation() {
		boolean verify = false;

		List<WebElement> locatorforWhereTEXTisPresentList = driver.findElements(FEED_ITEM);

		for (WebElement webElement : locatorforWhereTEXTisPresentList) {
			System.out.println("Test " + webElement.getText());
			String Requesttext = webElement.getText();
			// ADD IN OR REJECTED
			if (Requesttext.contains("Approved") || Requesttext.contains("Rejected")) {
				verify = true;
			}

			else {
				return false;
			}

		}

		return verify;
	}

	public boolean SideRequestTypeValidation() {

		boolean verify = false;

		List<WebElement> locatorforWhereTEXTisPresentList = driver.findElements(FEED_ITEM);

		for (WebElement webElement : locatorforWhereTEXTisPresentList) {
			System.out.println("Test " + webElement.getText());
			String Requesttext = webElement.getText();
			// ADD IN OR REJECTED
			if (Requesttext.contains("received")) {
				verify = true;
			}

			else {
				return false;
			}

		}

		return verify;
	}

	public boolean SideStatusValidation() {

		boolean verify = false;

		List<WebElement> locatorforWhereTEXTisPresentList = driver.findElements(FEED_ITEM);

		for (WebElement webElement : locatorforWhereTEXTisPresentList) {
			System.out.println("Test " + webElement.getText());
			String Requesttext = webElement.getText();
			// ADD IN OR REJECTED
			if (Requesttext.contains("received")) {
				verify = true;
			}

			else {
				return false;
			}

		}

		return verify;
	}

	public void IntoSearchBox() throws InterruptedException {

		Thread.sleep(3000);
		RequestBox.click();
		RequestBox.sendKeys("Assistance User");
		RequestBox.sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//h1[@class=\"sam-ui header ng-star-inserted\"]")).click();
		Thread.sleep(3000);

	}

	public void IntoRequestorBox() throws InterruptedException {
		((JavascriptExecutor) driver).executeScript("scroll(0,500)");
		RequestorBox.click();
		RequestorBox.sendKeys("sanzedah.rahman+norole@gsa.gov");
		Thread.sleep(3000);
		requestoroption.click();
		Thread.sleep(4000);

		driver.findElement(By.xpath("//h1[@class=\"sam-ui header ng-star-inserted\"]")).click();
		// Thread.sleep(4000);
		// ((JavascriptExecutor) driver).executeScript("scroll(0,-300)");
		Thread.sleep(3000);
	}

	public void IntoApproverBox() throws InterruptedException {
		((JavascriptExecutor) driver).executeScript("scroll(0,400)");
		approvertab.click();
		approvertab.sendKeys("Sanzedah.rahman+assistanceadmin");
		Thread.sleep(3000);
		approveroption.click();
		Thread.sleep(3000);
		((JavascriptExecutor) driver).executeScript("scroll(0,-100)");
		driver.findElement(By.xpath("//h1[@class=\"sam-ui header ng-star-inserted\"]")).click();
		Thread.sleep(3000);

	}

	public void IntoEntityBox() throws InterruptedException {
		((JavascriptExecutor) driver).executeScript("scroll(0,500)");
		EntityBox.click();
		Thread.sleep(2000);

		EntityBox.sendKeys(" octo consulting group ");
		Thread.sleep(6000);
		EntityOption.click();
		((JavascriptExecutor) driver).executeScript("scroll(0,-400)");
		driver.findElement(By.xpath("//h1[@class=\"sam-ui header ng-star-inserted\"]")).click();
		Thread.sleep(5000);

	}
	public void IntoOrganizationBox() throws InterruptedException {
		((JavascriptExecutor) driver).executeScript("scroll(0,500)");
		OrganizationBox.click();
		OrganizationBox.sendKeys("Integrated Award");
		Thread.sleep(4000);
		OrganizationOption.click();
		((JavascriptExecutor) driver).executeScript("scroll(0,-400)");
		driver.findElement(By.xpath("//h1[@class=\"sam-ui header ng-star-inserted\"]")).click();
		Thread.sleep(5000);

	}

	public void NEGIntoOrganizationBox() throws InterruptedException {
		((JavascriptExecutor) driver).executeScript("scroll(0,500)");
		OrganizationBox.click();
		OrganizationBox.sendKeys("department of argi");
		Thread.sleep(3000);
		NEGOrganizationOption.click();
		((JavascriptExecutor) driver).executeScript("scroll(0,-400)");
		driver.findElement(By.xpath("//h1[@class=\"sam-ui header ng-star-inserted\"]")).click();
		Thread.sleep(5000);

	}

	public boolean validatepending() {

		boolean verify = false;

		List<WebElement> locatorforWhereTEXTisPresentList = driver.findElements(FEED_ITEM);

		for (WebElement webElement : locatorforWhereTEXTisPresentList) {
			System.out.println("Test " + webElement.getText());
			String Requesttext = webElement.getText();
			// ADD IN OR REJECTED
			if (Requesttext.contains("Pending")) {
				verify = true;
			}

			else {
				return false;
			}

		}

		return verify;
	}

	public boolean validateRejected() {

		boolean verify = false;

		List<WebElement> locatorforWhereTEXTisPresentList = driver.findElements(FEED_ITEM);

		for (WebElement webElement : locatorforWhereTEXTisPresentList) {
			System.out.println("Test " + webElement.getText());
			String Requesttext = webElement.getText();
			// ADD IN OR REJECTED
			if (Requesttext.contains("Rejected")) {
				verify = true;
			}

			else {
				return false;
			}

		}

		return verify;
	}

	public boolean validateComplete() {

		boolean verify = false;

		List<WebElement> locatorforWhereTEXTisPresentList = driver.findElements(FEED_ITEM);

		for (WebElement webElement : locatorforWhereTEXTisPresentList) {
			System.out.println("Test " + webElement.getText());
			String Requesttext = webElement.getText();
//ADD IN OR REJECTED
			if (Requesttext.contains("Complete")) {
				verify = true;
			}

			else {
				return false;
			}

		}
		return verify;
	}

	public boolean validateApproved() {

		boolean verify = false;

		List<WebElement> locatorforWhereTEXTisPresentList = driver.findElements(FEED_ITEM);

		for (WebElement webElement : locatorforWhereTEXTisPresentList) {
			System.out.println("Test " + webElement.getText());
			String Requesttext = webElement.getText();
//ADD IN OR REJECTED
			if (Requesttext.contains("Approved")) {
				verify = true;
			}

			else {
				return false;
			}

		}
		return verify;
	}

	public boolean validateCanceled() {

		boolean verify = false;

		List<WebElement> locatorforWhereTEXTisPresentList = driver.findElements(FEED_ITEM);

		for (WebElement webElement : locatorforWhereTEXTisPresentList) {
			System.out.println("Test " + webElement.getText());
			String Requesttext = webElement.getText();
//ADD IN OR REJECTED
			if (Requesttext.contains("Canceled")) {
				verify = true;
			}

			else {
				return false;
			}

		}
		return verify;
	}

}
