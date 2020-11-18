package stepdefinitions;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import FeedsPages.FilterFeeds;
import FeedsPages.NewListing;
import FeedsPages.RequestRejectFeedspage;
import FeedsPages.feeds;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import login.govPages.homepage;
import login.govPages.loginGov;
import login.govPages.loginpage;
import util.TestBase;
import util.utils;

public class FeedsStepsDef extends TestBase {
	loginpage LoginPage;
	loginGov LoginGov;
	homepage Homepage;
	feeds Feeds;
	utils Utils;
	 NewListing newListing;
	RequestRejectFeedspage requestRejectFeedspage;
	FilterFeeds filterFeeds;

	private String timestampA; // FOR REQUESTED SENT
	private String timestampB; // FOR REQUEST RECEIVED
	private String timestampC; // FOR REQUEST DELETED SENT
	private String timestampD; // FOR REQUEST DELETED RECEIVED
	private String timestampE; // FOR ASSIGNED SENT
	private String timestampF; // FOR ASSIGNED RECEIVED
	private String timestampG; // FOR ASSIGNED DELETED SENT
	private String timestampH; // FOR ASSINGED DELETED RECEIVED
	private String timestampI;
	private String timestampJ;
	@Given("^a User without role signs in$")
	public void a_User_without_role_signs_in() throws Exception {
		LoginGov = new loginGov();
		LoginGov.GeneralLogIn(prop.getProperty("NoRole"), prop.getProperty("password2"), "VDPZXAM3JGMMJGHM");
	}

	@When("^this user requests assistance user role in assistance listing$")
	public void this_user_requests_assistance_user_role_in_assistance_listing() throws Exception {
		requestRejectFeedspage = new RequestRejectFeedspage();
		requestRejectFeedspage.intoRequestPage();
		requestRejectFeedspage.RequestRoleDetails();
	}

	@Then("^this request should be visible in Sent tab for the requester in their feeds with status pending and timestamp$")
	public void this_request_should_be_visible_in_Sent_tab_for_the_requester_in_their_feeds_with_status_pending_and_timestamp()
			throws Exception {
		Feeds = new feeds();
		Feeds.Maindropdown();

		Feeds.Openmorefeeds();

		Feeds.intoSent();
		//Feeds.intoPending();
		// DO VALIDATION HERE

		setTimestampA(Feeds.getLastRequestRequestTimestamp());

		System.out.println("TIMESTAMP A:" + getTimestampA());

		boolean verify;

		if (!StringUtils.isEmpty(getTimestampA())) {
			verify = true;
		} else {
			verify = false;
		}

		Assert.assertTrue(verify);
		requestRejectFeedspage.feedValidation("You", prop.getProperty("RequestedRoleName"), prop.getProperty("OrgName"), prop.getProperty("DomainName"));
     	Assert.assertTrue(verify);
		assertTrue("Pending status isnt there", Feeds.validatestatuspending());
		Thread.sleep(5000);
	}

@When("^same domain user logs in$")
public void same_domain_user_logs_in() throws Exception {
	LoginGov = new loginGov();
	LoginGov.GeneralLogIn(prop.getProperty("AssistancePMOadmin"), prop.getProperty("password2"), "5TTHNJ72VGJEQBEV");

}

@When("^this request should be visible in feeds Received for same domain user with status pending and timestamp$")
public void this_request_should_be_visible_in_feeds_Received_for_same_domain_user_with_status_pending_and_timestamp() throws Exception {
	Feeds = new feeds();
	Feeds.Maindropdown();
	Feeds.Openmorefeeds();
	Feeds.intoReceived();
	Feeds.intoPending();
	// VALIDATION
	Thread.sleep(2000);
	setTimestampB(Feeds.getLastRequestRequestTimestamp());

	System.out.println("TIMESTAMP B:" + getTimestampB());
	System.out.println("CURRENTTIME A=FOR REQUEST RECEIVED:" + getTimestampA());

	boolean verify;

	if (getTimestampA().equalsIgnoreCase(getTimestampB())) {
		verify = true;
	} else {
		verify = false;
	}

	Assert.assertTrue(verify);

	// VALIDATION FOR "PENDING"
	WebElement LocatorForTheTextWanted = driver.findElement(By.xpath("//div[text()='Pending']"));

	String adminRequesttext = LocatorForTheTextWanted.getText();

	if (adminRequesttext.contains("Pending")) {
		verify = true;
	} else {
		verify = false;
	} // To make this more consistant, check the current time again and rerun the if
		// and else statement

	Assert.assertTrue(verify);

	System.out.println(adminRequesttext);

	requestRejectFeedspage.feedValidation("Sanzedah Rahman", prop.getProperty("RequestedRoleName"), prop.getProperty("OrgName"), prop.getProperty("DomainName"));
	Assert.assertTrue(verify);
	
}

	
	@When("^non domain admin logs in$")
	public void non_domain_admin_logs_in() throws Exception {
		LoginGov = new loginGov();
		LoginGov.GeneralLogIn(prop.getProperty("ContractOppAdmin"), prop.getProperty("password2"), "PMQQFMNQHLG65M5I");
	}

	@When("^this request should NOT be visible in feeds Received for non domain admin with status pending and timestamp$")
	public void this_request_should_NOT_be_visible_in_feeds_Received_for_non_domain_admin_with_status_pending_and_timestamp() throws Exception {
		Feeds = new feeds();
		Feeds.Maindropdown();
		Feeds.Openmorefeeds();
		Feeds.intoReceived();
		Feeds.intoPending();
		Thread.sleep(2000);
		requestRejectFeedspage=new RequestRejectFeedspage();
		boolean flag = requestRejectFeedspage.NEGfeedValidation("Sanzedah Rahman", prop.getProperty("AssignedRolename"), prop.getProperty("OrgName"), prop.getProperty("DomainName"));
		Assert.assertTrue(flag);
	}

	@When("^assistance admin logs in$")
	public void assistance_admin_logs_in() throws Exception {
		LoginGov = new loginGov();
		LoginGov.GeneralLogIn(prop.getProperty("AssistanceAdmin"), prop.getProperty("password2"),"MNZGL6MKR2ZTJDO6");

	}

	@Then("^this request should be visible in feeds dropdown for assistance admin$")
	public void this_request_should_be_visible_in_feeds_dropdown_for_assistance_admin() throws Exception {
		Feeds = new feeds();
		Feeds.Maindropdown();
		assertTrue("email isnt there", Feeds.validateAdminsDropdown());
		System.out.println(Feeds.validateAdminsDropdown());
		((JavascriptExecutor) driver).executeScript("scroll(0,500)");
		Feeds.Openmorefeeds();
	}

	@Then("^this request should be visible in Received tab for assistance admin with status pending and timestamp$")
	public void this_request_should_be_visible_in_Received_tab_for_assistance_admin_with_status_pending_and_timestamp()
			throws Exception {
		Feeds.intoReceived();
		Feeds.intoPending();
		// VALIDATION
		Thread.sleep(2000);
		setTimestampB(Feeds.getLastRequestRequestTimestamp());

		System.out.println("TIMESTAMP B:" + getTimestampB());
		System.out.println("CURRENTTIME A=FOR REQUEST RECEIVED:" + getTimestampA());

		boolean verify;

		if (getTimestampA().equalsIgnoreCase(getTimestampB())) {
			verify = true;
		} else {
			verify = false;
		}

		Assert.assertTrue(verify);

		// VALIDATION FOR "PENDING"
		WebElement LocatorForTheTextWanted = driver.findElement(By.xpath("//div[text()='Pending']"));

		String adminRequesttext = LocatorForTheTextWanted.getText();

		if (adminRequesttext.contains("Pending")) {
			verify = true;
		} else {
			verify = false;
		} // To make this more consistant, check the current time again and rerun the if
			// and else statement

		Assert.assertTrue(verify);

		System.out.println(adminRequesttext);

		requestRejectFeedspage.feedValidation("Sanzedah Rahman", prop.getProperty("RequestedRoleName"), prop.getProperty("OrgName"), prop.getProperty("DomainName"));
		Assert.assertTrue(verify);
	}
	

	@When("^the request is rejected by the admin$")
	public void the_request_is_rejected_by_the_admin() throws Exception {
		requestRejectFeedspage = new RequestRejectFeedspage();
		requestRejectFeedspage.RejectRole();

	}

	@Then("^rejected status with timestamp and email should be visible in feeds for assistance admin$")
	public void rejected_status_with_timestamp_and_email_should_be_visible_in_feeds_for_assistance_admin()
			throws Exception {
		requestRejectFeedspage.filterRejected();
		((JavascriptExecutor) driver).executeScript("scroll(0,200)");
		assertTrue("rejected status is there", Feeds.validatereject());

		assertTrue("email isnt there", Feeds.validateadminemail());
		// VALIDATE THE TIME
		setTimestampC(Feeds.getLastRejectedRequestTimestamp());

		System.out.println("TIMESTAMP C:=FOR REQUEST DELETED SENT" + getTimestampC());

		boolean verify;

		// verify = validateTimeStamp();
		if (getTimestampC() != null) {
			verify = true;
		} else {
			verify = false;
		}

		Assert.assertTrue(verify);
		Thread.sleep(6000);
	}

	@Then("^rejected status with timestamp and email should be visible in feeds for user who requested$")
	public void rejected_status_with_timestamp_and_email_should_be_visible_in_feeds_for_user_who_requested()
			throws Exception {
		Feeds = new feeds();
		Feeds.GoToFeedsPage();
		assertTrue("rejected status is there", Feeds.validatereject());
		assertTrue("email isnt there", Feeds.validateadminemail());
		// VALIDATE TIME
		setTimestampD(Feeds.getLastRejectedRequestTimestamp());

		System.out.println("TIMESTAMP C:" + getTimestampC());
		System.out.println("CURRENTTIME D=FOR REQUEST DELETED RECEIVED:" + getTimestampD());

		boolean verify;

		// verify = validateTimeStamp();
		if (getTimestampC().equalsIgnoreCase(getTimestampD())) {

			verify = true;
		} else {
			verify = false;
		}

		Assert.assertTrue(verify);
		Thread.sleep(5000);
	}

	@Then("^browser close$")
	public void browser_close() throws Exception {
		driver.close();
	}

	@Given("^a role admin signs in$")
	public void a_role_admin_signs_in() throws Exception {

		LoginGov = new loginGov();
		LoginGov.GeneralLogIn(prop.getProperty("DomainAdmin"), prop.getProperty("password"), "6BSLNLLRH7HLJFMM");

	}

	@When("^admin searches user$")
	public void admin_searches_user() throws Exception {
		//((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
		((JavascriptExecutor) driver).executeScript("scroll(0,900)");
		Thread.sleep(4000);
		Feeds = new feeds();
		Feeds.SearchAUserInDirectory();
	}

	@Then("^admin assigns role to a user$")
	public void admin_assigns_role_to_a_user() throws Exception {
		requestRejectFeedspage = new RequestRejectFeedspage();
		requestRejectFeedspage.AssignARole();
	}

	@Then("^the role should be in sent tab in feeds with timestamp,status approved$")
	public void the_role_should_be_in_sent_tab_in_feeds_with_timestamp_status_approved() throws Exception {
		Feeds = new feeds();
		Feeds.GoToFeedsPage();
		Feeds.intoSent();
		//Feeds.Sorttab();
		Feeds.IntoResponseDate();
		Feeds.intoRoleAssignmentsTab();

		// DO VALIDATION

		setTimestampE(Feeds.getLastRequestRequestTimestamp());

		System.out.println("TIMESTAMP E:=FOR ASSIGNED SENT" + getTimestampE());

		boolean verify;

//verify = validateTimeStamp();
		if (getTimestampE() != null) {
			verify = true;
		} else {
			verify = false;
		}

		Assert.assertTrue(verify);

//VALIDATION FOR "YOU"
		requestRejectFeedspage.feedValidation("You", prop.getProperty("AssignedRolename"), prop.getProperty("OrgName"),
				prop.getProperty("DomainName"));
		Assert.assertTrue(verify);

	}

	@Then("^user will see in received tab in feeds with timestamp, status approved$")
	public void user_will_see_in_received_tab_in_feeds_with_timestamp_status_approved() throws Exception {
		Feeds = new feeds();
		Feeds.GoToFeedsPage();
		Feeds.intoReceived();
		Feeds.intoRoleAssignmentsTab();
		Feeds.Sorttab();
		Feeds.IntoResponseDate();
		// VALIDATE
		setTimestampF(Feeds.getLastRequestRequestTimestamp());

		System.out.println("TIMESTAMP E:" + getTimestampE());
		System.out.println("CURRENTTIME F=FOR ASSIGNED RECEIVED:" + getTimestampF());

		boolean verify;

		// verify = validateTimeStamp();
		if (getTimestampE().equalsIgnoreCase(getTimestampF())) {
			verify = true;
		} else {
			verify = false;
		}
		Assert.assertTrue(verify);
		assertTrue("Approved status isnt there", Feeds.validatestatusApproved());
		WebElement LocatorForTextWanted = driver.findElement(By.xpath(
				"//*[@id='main-container']/msg-feed-container/msg-feed-requests/page/div/div/div[2]/div[2]/div[1]/div[3]/div[1]"));

		requestRejectFeedspage.feedValidation("Sanzedah Rahman", prop.getProperty("AssignedRolename"),
				prop.getProperty("OrgName"), prop.getProperty("DomainName"));
		Assert.assertTrue(verify);
	}

	@When("^user from same domain signs in the role should not be in the feeds$")
	public void user_from_same_domain_signs_in_the_role_should_not_be_in_the_feeds() throws Exception {

		LoginGov = new loginGov();
		LoginGov.GeneralLogIn(prop.getProperty("ContractOppAdmin"), prop.getProperty("password2"), "PMQQFMNQHLG65M5I");
		Feeds = new feeds();
		Feeds.GoToFeedsPage();
		Feeds.intoReceived();
		Feeds.IntoResponseDate();

		requestRejectFeedspage = new RequestRejectFeedspage();
		boolean flag = requestRejectFeedspage.NEGfeedValidation("Sanzedah Rahman", prop.getProperty("AssignedRolename"),
				prop.getProperty("OrgName"), prop.getProperty("DomainName"));
		Assert.assertTrue(flag);
	}

	@Then("^the admin will delete the role$")
	public void the_admin_will_delete_the_role() throws Exception {
		requestRejectFeedspage = new RequestRejectFeedspage();
		requestRejectFeedspage.DeletingRole();
		Feeds = new feeds();
		Feeds.GoToFeedsPage();
		//Feeds.Sorttab();
		Feeds.IntoResponseDate();
		Feeds.intoSent();
		Feeds.intoRoleAssignmentsTab();
	}

	@Then("^status will be in feeds as removed$")
	public void status_will_be_in_feeds_as_removed() throws Exception {
		// VALIDATION
		boolean verify;

		WebElement LocatorForTextWanted = driver.findElement(By.xpath(
				"//*[@id='main-container']/msg-feed-container/msg-feed-requests/page/div/div/div[2]/div[2]/div[1]/div[3]/div[1]"));

		String Requesttext = LocatorForTextWanted.getText();

		if (Requesttext.contains("removed")) {
			verify = true;
		} else {
			verify = false;

		}
		// To make this more consistant, check the current time again and rerun the if
		// and else statement

		requestRejectFeedspage.feedValidation("You", prop.getProperty("AssignedRolename"), prop.getProperty("OrgName"),
				prop.getProperty("DomainName"));
		Assert.assertTrue(verify);

		setTimestampG(Feeds.getLastRequestRequestTimestamp());

		System.out.println("TIMESTAMPG=FOR ASSIGNED DELETED SENT:" + getTimestampG());

		if (getTimestampG() != null) {
			verify = true;
		} else {
			verify = false;
		}

		Assert.assertTrue(verify);
	}

	@Then("^status will be in feeds as removed for the user$")
	public void status_will_be_in_feeds_as_removed_for_the_user() throws Exception {
		Feeds = new feeds();
		Feeds.GoToFeedsPage();
		Feeds.intoReceived();
		Feeds.IntoResponseDate();
		Feeds.intoRoleAssignmentsTab();
		// VALIDATION

		boolean verify;

		WebElement LocatorForTextWanted = driver.findElement(By.xpath(
				"//*[@id='main-container']/msg-feed-container/msg-feed-requests/page/div/div/div[2]/div[2]/div[1]/div[3]/div[1]"));

		String Requesttext = LocatorForTextWanted.getText();

		if (Requesttext.contains("removed")) {
			verify = true;
		} else {
			verify = false;
		} // To make this more consistant, check the current time again and rerun the if
			// and else statement

		Assert.assertTrue(verify);

		requestRejectFeedspage.feedValidation("Sanzedah Rahman", prop.getProperty("AssignedRolename"),
				prop.getProperty("OrgName"), prop.getProperty("DomainName"));
		Assert.assertTrue(verify);

		setTimestampH(Feeds.getLastRequestRequestTimestamp());

		System.out.println("TIMESTAMP G:" + getTimestampG());
		System.out.println("CURRENTTIME H=FOR ASSINGED DELETED RECEIVED:" + getTimestampH());

		// verify = validateTimeStamp();
		if (getTimestampG().equalsIgnoreCase(getTimestampH())) {
			verify = true;
		} else {
			verify = false;
		}

		Assert.assertTrue(verify);

	}

	public String getTimestampA() {
		return timestampA;
	}

	public void setTimestampA(String timestampA) {
		this.timestampA = timestampA;
	}

	public String getTimestampB() {
		return timestampB;
	}

	public void setTimestampB(String timestampB) {
		this.timestampB = timestampB;
	}

	public String getTimestampC() {
		return timestampC;
	}

	public void setTimestampC(String timestampC) {
		this.timestampC = timestampC;
	}

	public String getTimestampD() {
		return timestampD;
	}

	public void setTimestampD(String timestampD) {
		this.timestampD = timestampD;
	}

	public String getTimestampE() {
		return timestampE;
	}

	public void setTimestampE(String timestampE) {
		this.timestampE = timestampE;
	}

	public String getTimestampF() {
		return timestampF;
	}

	public void setTimestampF(String timestampF) {
		this.timestampF = timestampF;
	}

	public String getTimestampG() {
		return timestampG;
	}

	public void setTimestampG(String timestampG) {
		this.timestampG = timestampG;
	}

	public String getTimestampH() {
		return timestampH;
	}

	public void setTimestampH(String timestampH) {
		this.timestampH = timestampH;
	}

	public String getTimestampI() {
		return timestampI;
	}

	public void setTimestampI(String timestampI) {
		this.timestampI = timestampI;
	}

	public String getTimestampJ() {
		return timestampJ;
	}

	public void setTimestampJ(String timestampJ) {
		this.timestampJ = timestampJ;
	}

	@Given("^a new User without role signs in$")
	public void a_new_User_without_role_signs_in() throws Exception {
		LoginGov = new loginGov();
		LoginGov.GeneralLogIn(prop.getProperty("NoRoleForContract"), prop.getProperty("password2"), "PQFTWB2UEMIRSUL4");

	}

	@When("^this user requests contract data user role in contracting opportunities$")
	public void this_user_requests_contract_data_user_role_in_contracting_opportunities() throws Exception {
		requestRejectFeedspage = new RequestRejectFeedspage();
		requestRejectFeedspage.intoRequestPage();
		requestRejectFeedspage.RequestRoleDetailsForContractingOpp();

	}

	@Then("^this request should be visible in Sent tab for the new requester in their feeds with status pending$")
	public void this_request_should_be_visible_in_Sent_tab_for_the_new_requester_in_their_feeds_with_status_pending()
			throws Exception {
		Feeds = new feeds();
		Feeds.Maindropdown();
		Feeds.Openmorefeeds();
		Feeds.intoSent();
		// Feeds.intoPending();
		// DO VALIDATION HERE

		setTimestampI(Feeds.getLastRequestRequestTimestamp());

		System.out.println("TIMESTAMP I:" + getTimestampI());

		boolean verify;

		if (!StringUtils.isEmpty(getTimestampI())) {
			verify = true;
		} else {
			verify = false;
		}

		Assert.assertTrue(verify);
		requestRejectFeedspage.feedValidation("You", prop.getProperty("RequestedRoleName2"),
				prop.getProperty("OrgName"), prop.getProperty("DomainName2"));
		Assert.assertTrue(verify);
		assertTrue("Pending status isnt there", Feeds.validatestatuspending());
		Thread.sleep(5000);

	}

	@When("^a user from a different domain as admin logs in$")
	public void a_user_from_a_different_domain_as_admin_logs_in() throws Exception {
		LoginGov = new loginGov();
		LoginGov.GeneralLogIn(prop.getProperty("AssistanceAdmin"), prop.getProperty("password2"), "MNZGL6MKR2ZTJDO6");

	}

	@When("^this request should NOT be visible in feeds Received$")
	public void this_request_should_NOT_be_visible_in_feeds_Received() throws Exception {

		Feeds = new feeds();
		Feeds.Maindropdown();
		Feeds.Openmorefeeds();
		Feeds.intoReceived();
		Feeds.intoPending();
		requestRejectFeedspage = new RequestRejectFeedspage();
		boolean flag = requestRejectFeedspage.NEGfeedValidation("null", prop.getProperty("RequestedRoleName2"),
				prop.getProperty("null"), prop.getProperty("DomainName2"));
		Assert.assertTrue(flag);
	}

	@When("^a admin from same domain logs in$")
	public void a_admin_from_same_domain_logs_in() throws Exception {
		LoginGov = new loginGov();
		LoginGov.GeneralLogIn(prop.getProperty("ContractOppAdmin"), prop.getProperty("password2"), "PMQQFMNQHLG65M5I");

	}

	@Then("^this request should be visible in feeds Received$")
	public void this_request_should_be_visible_in_feeds_Received() throws Exception {
		Feeds = new feeds();
		Feeds.Maindropdown();
		Feeds.Openmorefeeds();
		Feeds.intoReceived();
		Feeds.intoPending();
		// VALIDATION
		Thread.sleep(2000);
		setTimestampJ(Feeds.getLastRequestRequestTimestamp());

		System.out.println("TIMESTAMP I:" + getTimestampI());
		System.out.println("CURRENTTIME J=FOR REQUEST RECEIVED:" + getTimestampJ());

		boolean verify;

		if (getTimestampI().equalsIgnoreCase(getTimestampJ())) {
			verify = true;
		} else {
			verify = false;
		}

		Assert.assertTrue(verify);

		// VALIDATION FOR "PENDING"
		WebElement LocatorForTheTextWanted = driver.findElement(By.xpath("//div[text()='Pending']"));

		String adminRequesttext = LocatorForTheTextWanted.getText();

		if (adminRequesttext.contains("Pending")) {
			verify = true;
		} else {
			verify = false;
		} // To make this more consistant, check the current time again and rerun the if
			// and else statement

		Assert.assertTrue(verify);

		System.out.println(adminRequesttext);

		requestRejectFeedspage.feedValidation("sanzedah rahman", prop.getProperty("RequestedRoleName2"),
				prop.getProperty("OrgName"), prop.getProperty("DomainName2"));
		Assert.assertTrue(verify);
	}

	@When("^non department level\\(L(\\d+)\\) admin logs into feeds from the same domain will not see request$")
	public void non_department_level_L_admin_logs_into_feeds_from_the_same_domain_will_not_see_request(int arg1)
			throws Exception {
		LoginGov = new loginGov();
		LoginGov.GeneralLogIn(prop.getProperty("IAEUSER"), prop.getProperty("password2"), "K2JRT62D5DLMOORQ");
		Feeds = new feeds();
		Feeds.Maindropdown();
		Feeds.Openmorefeeds();
		Feeds.intoReceived();

		requestRejectFeedspage = new RequestRejectFeedspage();
		boolean flag = requestRejectFeedspage.NEGfeedValidation("null", prop.getProperty("RequestedRoleName2"),
				prop.getProperty("null"), prop.getProperty("DomainName2"));
		Assert.assertTrue(flag);
	}

	@When("^a subtier\\(L(\\d+)\\) admin logs into feeds from the same domain will not see request$")
	public void a_subtier_L_admin_logs_into_feeds_from_the_same_domain_will_not_see_request(int arg1) throws Exception {
		LoginGov = new loginGov();
		LoginGov.GeneralLogIn(prop.getProperty("L2USER"), prop.getProperty("password2"), "DFZZKO5M3IZQWJI3");
		Feeds = new feeds();
		Feeds.Maindropdown();
		Feeds.Openmorefeeds();
		Feeds.intoReceived();

		requestRejectFeedspage = new RequestRejectFeedspage();
		boolean flag = requestRejectFeedspage.NEGfeedValidation("null", prop.getProperty("RequestedRoleName2"),
				prop.getProperty("null"), prop.getProperty("DomainName2"));
		Assert.assertTrue(flag);

	}

	@When("^a user within the same domain without admin privileges logs in they will not see request$")
	public void a_user_within_the_same_domain_without_admin_privileges_logs_in_they_will_not_see_request()
			throws Exception {
		LoginGov = new loginGov();
		LoginGov.GeneralLogIn(prop.getProperty("ContractOppUser"), prop.getProperty("password2"), "INJ7FXYGRNIAEVDV");
		Feeds = new feeds();
		Feeds.Maindropdown();
		Feeds.Openmorefeeds();
		Feeds.intoReceived();
		requestRejectFeedspage = new RequestRejectFeedspage();
		boolean flag = requestRejectFeedspage.NEGfeedValidation("null", prop.getProperty("RequestedRoleName2"),
				prop.getProperty("null"), prop.getProperty("DomainName2"));
		Assert.assertTrue(flag);

	}

	@When("^User goes to feeds homepage$")
	public void user_goes_to_feeds_homepage() throws Exception {
		Feeds = new feeds();
		Feeds.Maindropdown();
		Feeds.Openmorefeeds();
		//((JavascriptExecutor) driver).executeScript("scroll(0,300)");

	}

	@Then("^User validates sent and received tabs$")
	public void user_validates_sent_and_received_tabs() throws Exception {
		filterFeeds = new FilterFeeds();
		Feeds.intoSent();
		boolean Sentflag = filterFeeds.SentValidation();
		Assert.assertTrue(Sentflag);
		Feeds.intoReceived();
		Feeds.SorttabASCDESC();
		boolean Recievedflag = filterFeeds.RecievedValidation();
		Assert.assertTrue(Recievedflag);
		Feeds.intoRequest();
	}

	@When("^User validates search request box$")
	public void user_validates_search_request_box() throws Exception {
		filterFeeds.IntoSearchBox();
		boolean RequestBoxflag = filterFeeds.SearchRequestBoxValidation("requested",
				"Assistance");
				//, prop.getProperty("OrgName"), prop.getProperty("DomainName"));
		Assert.assertTrue(RequestBoxflag);
		Thread.sleep(3000);
	}

	@When("^user clear filters for feeds$")
	public void user_clear_filters_for_feeds() throws Exception {
		filterFeeds = new FilterFeeds();
		filterFeeds.clearTHEfilters();
	}

	@Then("^User validates search requester box$")
	public void user_validates_search_requester_box() throws Exception {
		filterFeeds.IntoRequestorBox();
		boolean RequestorFlag = filterFeeds.SearchRequestorBoxValidation();
		Assert.assertTrue(RequestorFlag);
		Thread.sleep(3000);
	}

	@Then("^validates search approver box$")
	public void validates_search_approver_box() throws Exception {
		filterFeeds.IntoApproverBox();
		boolean ApproverBoxFlag = filterFeeds.SearchApproverBoxValidation();
		Assert.assertTrue(ApproverBoxFlag);
	}

	@When("^User validates search organization box$")
	public void user_validates_search_organization_box() throws Exception {
		filterFeeds.IntoOrganizationBox();
		boolean OrganizationFlag = filterFeeds.OrganizationValidation();
		Assert.assertTrue(OrganizationFlag);
	}
	@Then("^User validates search Entity box$")
	public void user_validates_search_Entity_box() throws Exception {
		Feeds = new feeds();
		Feeds.Maindropdown();
		Feeds.Openmorefeeds();
		Feeds.intoReceived();
		filterFeeds = new FilterFeeds();
		filterFeeds.IntoEntityBox();
		boolean EntityFlag = filterFeeds.EntityValidation();
		Assert.assertTrue(EntityFlag);
	}

	@Then("^user validates that a non GSA dept will not show up in request\\(DEPT OF ARGRICULTURE\\)$")
	public void user_validates_that_a_non_GSA_dept_will_not_show_up_in_request_DEPT_OF_ARGRICULTURE() throws Exception {
		filterFeeds.NEGIntoOrganizationBox();
		boolean OrganizationFlag = filterFeeds.OrganizationValidation00();
		Assert.assertTrue(OrganizationFlag);
	}

	@Then("^User validates side request type filters$")
	public void user_validates_side_request_type_filters() throws Exception {
		filterFeeds.RoleRequestFilterTab();
		boolean RoleRequestflag = filterFeeds.RoleRequestBoxValidation("requested");
		Assert.assertTrue(RoleRequestflag);
		filterFeeds.UncheckRoleRequestFilterTab();
		filterFeeds.RoleAssignmentsFilterTab();

		boolean RoleAssignmentflag = filterFeeds.RoleAssignmentValidation("you", "assigned");
		Assert.assertTrue(RoleAssignmentflag);
		filterFeeds.UncheckRoleAssignmentsFilterTab();
	}

	@When("^User validates side status filers$")
	public void user_validates_side_status_filers() throws Exception {
		filterFeeds.PendingFilterTab();
		boolean pendingflag = filterFeeds.validatepending();
		//Assert.assertTrue(pendingflag);
		filterFeeds.UncheckPendingFilterTab();
		filterFeeds.ApprovedFilterTab();
		boolean Approvedflag = filterFeeds.validateApproved();
		Assert.assertTrue(Approvedflag);
		filterFeeds.ApprovedFilterTabContinuedPages();
		boolean ApprovedflagContinued = filterFeeds.validateApproved();
		Assert.assertTrue(ApprovedflagContinued);
		filterFeeds.ApprovedFilterTabRandomPages();
		boolean ApprovedflagRandom = filterFeeds.validateApproved();
		Assert.assertTrue(ApprovedflagRandom);
		filterFeeds.UncheckApprovedFilterTab();
		filterFeeds.RejectedFilterTab();
		boolean Rejectedflag = filterFeeds.validateRejected();
		Assert.assertTrue(Rejectedflag);
		filterFeeds.UncheckRejectedFilterTab();
		filterFeeds.CanceledFilterTab();
		boolean Canceledflag = filterFeeds.validateCanceled();
		Assert.assertTrue(Canceledflag);
		filterFeeds.UncheckCanceledFilterTab();
		filterFeeds.CompleteFilterTab();
		boolean Completeflag = filterFeeds.validateComplete();
		Assert.assertTrue(Completeflag);
		filterFeeds.UncheckCompleteFilterTab();
	}

	@Then("^user validates that all side request type are valid for Admin, SAM PMO All domain Admin, Contracting user, Contracting Admin$")
	public void user_validates_that_all_side_request_type_are_valid_for_Admin_SAM_PMO_All_domain_Admin_Contracting_user_Contracting_Admin()
			throws Exception {
		filterFeeds = new FilterFeeds();
		

		assertTrue("TAB IS NOT THERE1", filterFeeds.SidePresence1());
		assertTrue("TAB IS NOT THERE2", filterFeeds.SidePresence2());
		assertTrue("TAB IS NOT THERE3", filterFeeds.SidePresence3());
		assertTrue("TAB IS NOT THERE4", filterFeeds.SidePresence4());
		assertTrue("TAB IS NOT THERE5", filterFeeds.SidePresence5());
		assertTrue("TAB IS NOT THERE6", filterFeeds.SidePresence6());
		assertTrue("TAB IS NOT THERE7", filterFeeds.SidePresence7());
		assertTrue("TAB IS THERE-Entity", !filterFeeds.SidePresenceEntity());
		assertTrue("TAB IS THERE-Opportunities", !filterFeeds.SidePresenceOppAttachment());
		Thread.sleep(2000);
		driver.close();
		LoginGov = new loginGov();
		LoginGov.GeneralLogIn(prop.getProperty("DomainAdmin"), prop.getProperty("password"), "6BSLNLLRH7HLJFMM");
		Feeds = new feeds();
		Feeds.Maindropdown();
		Feeds.Openmorefeeds();
		assertTrue("TAB IS NOT THERE1", !filterFeeds.SidePresence1());
		assertTrue("TAB IS NOT THERE2", !filterFeeds.SidePresence2());
		((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
		assertTrue("TAB NOT THERE-OPP",!filterFeeds.SidePresenceOppAttachment());
		assertTrue("TAB IS NOT THERE3", !filterFeeds.SidePresence3());
		assertTrue("TAB IS NOT THERE4",! filterFeeds.SidePresence4());
		assertTrue("TAB IS NOT THERE5",! filterFeeds.SidePresence5());
		assertTrue("TAB IS NOT THERE6", !filterFeeds.SidePresence6());
		assertTrue("TAB IS NOT THERE7 ",! filterFeeds.SidePresence7());
		// INCLUDE NEG ENTITY FOR FIRST N SECOND SCENARIO
		((JavascriptExecutor) driver).executeScript("scroll(0,600)");
		assertTrue("TAB IS NOT THERE-ENTITY", !filterFeeds.SidePresenceEntity());

		Thread.sleep(2000);
		driver.close();
		LoginGov = new loginGov();
		LoginGov.GeneralLogIn(prop.getProperty("ContractOppUser"), prop.getProperty("password2"), "INJ7FXYGRNIAEVDV");
		Feeds = new feeds();
		Feeds.Maindropdown();
		Feeds.Openmorefeeds();
		// MAKE THESE NEG
		assertTrue("TAB IS THERE1", !filterFeeds.SidePresence1());
		assertTrue("TAB IS THERE2", !filterFeeds.SidePresence2());
		assertTrue("TAB IS THERE3", !filterFeeds.SidePresence3());
		assertTrue("TAB IS THERE4", !filterFeeds.SidePresence4());
		assertTrue("TAB IS THERE5", !filterFeeds.SidePresence5());
		assertTrue("TAB IS THERE6", !filterFeeds.SidePresence6());
		assertTrue("TAB IS NOT THERE7", !filterFeeds.SidePresence7());
		assertTrue("TAB IS THERE-ENTITY", !filterFeeds.SidePresenceEntity());
		assertTrue("TAB IS THERE-OPP", !filterFeeds.SidePresenceOppAttachment());
		Thread.sleep(3000);
		driver.close();
		LoginGov = new loginGov();
		LoginGov.GeneralLogIn(prop.getProperty("ContractOppAdmin"), prop.getProperty("password2"), "PMQQFMNQHLG65M5I");
		Feeds = new feeds();
		Feeds.Maindropdown();
		Feeds.Openmorefeeds();
		assertTrue("TAB IS THERE1", !filterFeeds.SidePresence1());
		assertTrue("TAB IS THERE2", !filterFeeds.SidePresence2());
		assertTrue("TAB IS THERE3", !filterFeeds.SidePresence3());
		assertTrue("TAB IS THERE4", !filterFeeds.SidePresence4());
		assertTrue("TAB IS THERE5", !filterFeeds.SidePresence5());
		assertTrue("TAB IS THERE6", !filterFeeds.SidePresence6());
		assertTrue("TAB IS NOT THERE7", !filterFeeds.SidePresence7());
		assertTrue("TAB IS THERE-ENTITY", !filterFeeds.SidePresenceEntity());
		assertFalse("TAB IS THERE-OPP", filterFeeds.SidePresenceOppAttachment());
		driver.close();
	}

	@Then("^this listing will be in their feeds as sent$")
	public void this_listing_will_be_in_their_feeds_as_sent() throws Throwable {
		newListing.User_unselect_published();
		newListing.Search_for_a_keyword();
		boolean ValidationForSearching1 = newListing.ValidateNewListingInListingPage();
		Assert.assertTrue(ValidationForSearching1);
		newListing.Read_the_timestamp();
		//VALIDATION FOR THE LISTING NAME COMING UP
		newListing.Click_on_the_notification();
		newListing.Click_on_Sent_tab();
		newListing.Click_on_submit_al();
		boolean ValidationForFeeds = newListing.Context_validating_in_sent_tab();
		Assert.assertTrue(ValidationForFeeds);
		newListing.Search_for_the_above_Assistance_Listings_keyword();
		//VALIDATION FOR LISTING COMING UP 
		boolean ValidationForFeeds3 = newListing.Context_validating_in_sent_tab();
		Assert.assertTrue(ValidationForFeeds3);
		
		}

@Given("^assistance user logs in per Assistance Listing$")
public void assistance_user_logs_in_per_Assistance_Listing() throws Exception {
	LoginGov = new loginGov();
	LoginGov.GeneralLogIn(prop.getProperty("AssistanceUser"), prop.getProperty("password2"),"F2M7CAF4TMDM6GM5");
}

@Then("^assistance user creates a new listing$")
public void assistance_user_creates_a_new_listing() throws Throwable {
	newListing= new NewListing();
	newListing.IntoHomepageListing();
	newListing.Clickadd_listing_button();
	newListing.HeaderInfoForListing();
	newListing.Fill_the_overview_details();
	newListing.Fill_the_authorization_details();
	newListing.Fill_the_obligations_details();
	newListing.Fill_other_Financial_Information_details();
	newListing.Fill_criteria_for_applying_details();
	newListing.Fill_applying_for_Assistance_details();
	newListing.Fill_compliance_requirements_details();
	newListing.Fill_contact_information_details();
	newListing.Click_on_submit_button();
}

@When("^a OMB Admin logs in per Assistance Listing$")
public void a_OMB_Admin_logs_in_per_Assistance_Listing() throws Exception {
	LoginGov = new loginGov();
	LoginGov.GeneralLogIn(prop.getProperty("OMBAdmin"), prop.getProperty("password2"),"2OZABT5KAFW7BGY5");
}

@Then("^there will be no request of a listing in their feeds yet$")
public void there_will_be_no_request_of_a_listing_in_their_feeds_yet() throws Throwable {
	newListing= new NewListing();
	Feeds = new feeds();
	Feeds.Maindropdown();

	((JavascriptExecutor) driver).executeScript("scroll(0,500)");
	Feeds.Openmorefeeds();
	newListing.Click_on_Recieved_tab();
	newListing.Click_on_publish_al();
	boolean ValidationForFeeds = newListing.NEGContext_validating_in_Received_tab();
	Assert.assertTrue(ValidationForFeeds);
}

@When("^assistance admin logs per Assistance Listing$")
public void assistance_admin_logs_per_Assistance_Listing() throws Exception {
	LoginGov = new loginGov();
	LoginGov.GeneralLogIn(prop.getProperty("AssistanceAdmin"), prop.getProperty("password2"),"MNZGL6MKR2ZTJDO6");
}

@Then("^assistance admin will review the listing thats fowarded to OMB$")
public void assistance_admin_will_review_the_listing_thats_fowarded_to_OMB() throws Throwable {
	newListing= new NewListing();
	
	Feeds = new feeds();
	Feeds.Maindropdown();

	((JavascriptExecutor) driver).executeScript("scroll(0,500)");
	Feeds.Openmorefeeds();

	newListing.Click_on_Recieved_tab();
	newListing.Click_on_submit_al();
	//DO VALIDATION
	boolean ValidationForFeeds = newListing.Context_validating_in_Received_tab();
	Assert.assertTrue(ValidationForFeeds);
	Thread.sleep(4000);
	newListing.intofirstlisting();
	newListing.submittoOMB();
	newListing.Enter_the_data_in_submission_comment();
	newListing.Click_on_submit_buttonAfterCommenting();
	newListing.User_unselect_published();
	newListing.Search_for_a_keyword();
	newListing.Read_the_timestamp();
	//DO VALIDATION
	boolean ValidationForSearching1 = newListing.ValidateNewListingInListingPageFORADMIN();
	Assert.assertTrue(ValidationForSearching1);
	Feeds.Maindropdown();

	((JavascriptExecutor) driver).executeScript("scroll(0,500)");
	Feeds.Openmorefeeds();
	newListing.Click_on_Sent_tab();
	newListing.Click_on_publish_al();
	
	//VALIDATION
	boolean ValidationForFeedsSent = newListing.Context_validating_in_sent_tabAndPending();
	Assert.assertTrue(ValidationForFeedsSent);
	
}

@When("^OMB Analyst logs in per Assistance Listing$")
public void omb_Analyst_logs_in_per_Assistance_Listing() throws Exception {
	LoginGov = new loginGov();
	LoginGov.GeneralLogIn(prop.getProperty("OMBAnalyst"), prop.getProperty("password2"),"5O6NQEY3O2HBCOON");
}

@Then("^the Analyst will Review the listing and approve the Listing$")
public void the_Analyst_will_Review_the_listing_and_approve_the_Listing() throws Throwable {
	newListing= new NewListing();
	Feeds = new feeds();
	Feeds.Maindropdown();

	((JavascriptExecutor) driver).executeScript("scroll(0,500)");
	Feeds.Openmorefeeds();
	newListing.Click_on_Recieved_tab();
	newListing.Click_on_publish_al();
	//VALIDATION
	boolean ValidationForFeeds = newListing.Context_validating_in_Received_tab();
	Assert.assertTrue(ValidationForFeeds);
	
	newListing.intofirstlisting();
	newListing.intofirstlistingFORPUBLISHING();
	newListing.User_unselect_published();
	newListing.Search_for_a_keyword();
	newListing.Read_the_timestamp();
	//DO VALIDATION
	boolean ValidationForSearching1 = newListing.ValidateNewListingInListingPageAsPublished();
	Assert.assertTrue(ValidationForSearching1);
	Feeds.Maindropdown();

	((JavascriptExecutor) driver).executeScript("scroll(0,500)");
	Feeds.Openmorefeeds();
	newListing.Click_on_Recieved_tab();
	newListing.Click_on_publish_al();
	
	//VALIDATION
	boolean ValidationForFeedsSent = newListing.Context_validating_in_received_tab_AsApproved();
	Assert.assertTrue(ValidationForFeedsSent);

}

@Then("^the listing will be in Feeds with status Approved for the Listing$")
public void the_listing_will_be_in_Feeds_with_status_Approved_for_the_Listing() throws Throwable {
	newListing= new NewListing();
	Feeds = new feeds();
	Feeds.Maindropdown();

	((JavascriptExecutor) driver).executeScript("scroll(0,500)");
	Feeds.Openmorefeeds();
	newListing.Click_on_Recieved_tab();
	newListing.Click_on_publish_al();
	boolean ValidationForFeedsSent = newListing.Context_validating_in_received_tab_AsApproved();
	Assert.assertTrue(ValidationForFeedsSent);
}
@Then("^the listing will be in Assistance Listing page with status Approved for the Listing$")
public void the_listing_will_be_in_Assistance_Listing_page_with_status_Approved_for_the_Listing() throws Throwable {
	newListing= new NewListing();
	newListing.IntoHomepageListing();
	newListing.User_unselect_published();
	newListing.Search_for_a_keyword();
	boolean ValidationForSearching1 = newListing.ValidateNewListingInListingPageAsPublished();
	Assert.assertTrue(ValidationForSearching1);
	newListing.Read_the_timestamp();
}

@When("^this user requests L(\\d+) OIG ofc of Investigations role$")
public void this_user_requests_L_OIG_ofc_of_Investigations_role(int arg1) throws Exception {
	requestRejectFeedspage = new RequestRejectFeedspage();
	requestRejectFeedspage.intoRequestPage();
	requestRejectFeedspage.RequestRoleDetailsForL3();
}


@Then("^this request should be visible in Sent tab for the requester for a l(\\d+) in their feeds with status pending and timestamp$")
public void this_request_should_be_visible_in_Sent_tab_for_the_requester_for_a_l_in_their_feeds_with_status_pending_and_timestamp(int arg1) throws Exception {
	Feeds = new feeds();
	Feeds.Maindropdown();

	Feeds.Openmorefeeds();

	Feeds.intoSent();
	
	driver.navigate().refresh();
	
	setTimestampA(Feeds.getLastRequestRequestTimestamp());

	System.out.println("TIMESTAMP A:" + getTimestampA());

	boolean verify;

	if (!StringUtils.isEmpty(getTimestampA())) {
		verify = true;
	} else {
		verify = false;
	}

	Assert.assertTrue(verify);
	requestRejectFeedspage.feedValidation("You", prop.getProperty("RequestedRoleName2"), prop.getProperty("OrgName"), prop.getProperty("DomainName"));
 	Assert.assertTrue(verify);
	assertTrue("Pending status isnt there", Feeds.validatestatuspending());
	requestRejectFeedspage.OFFICEValidation();	
	Assert.assertTrue(verify);
	Thread.sleep(5000);
}

@Then("^this request should be visible in recieved tab for the admin for a L(\\d+) and L(\\d+) in their feeds with status$")
public void this_request_should_be_visible_in_recieved_tab_for_the_admin_for_a_L_and_L_in_their_feeds_with_status(int arg1, int arg2) throws Exception {
	Feeds = new feeds();
	Feeds.Maindropdown();
	Feeds.Openmorefeeds();
	Feeds.intoReceived();
	Feeds.intoPending();
	// VALIDATION
	Thread.sleep(2000);
	setTimestampB(Feeds.getLastRequestRequestTimestamp());

	System.out.println("TIMESTAMP B:" + getTimestampB());
	System.out.println("CURRENTTIME A=FOR REQUEST RECEIVED:" + getTimestampA());

	boolean verify;

	if (getTimestampA().equalsIgnoreCase(getTimestampB())) {
		verify = true;
	} else {
		verify = false;
	}

	Assert.assertTrue(verify);

	// VALIDATION FOR "PENDING"
	WebElement LocatorForTheTextWanted = driver.findElement(By.xpath("//div[text()='Pending']"));

	String adminRequesttext = LocatorForTheTextWanted.getText();

	if (adminRequesttext.contains("Pending")) {
		verify = true;
	} else {
		verify = false;
	} // To make this more consistant, check the current time again and rerun the if
		// and else statement

	Assert.assertTrue(verify);

	System.out.println(adminRequesttext);

	requestRejectFeedspage.feedValidation("Sanzedah Rahman", prop.getProperty("RequestedRoleName2"), prop.getProperty("OrgName"), prop.getProperty("DomainName"));
	Assert.assertTrue(verify);
	
}

@When("^a L(\\d+) user within the same domain signs in\\(Inspector\\)$")
public void a_L_user_within_the_same_domain_signs_in_Inspector(int arg1) throws Exception {
	LoginGov = new loginGov();
	LoginGov.GeneralLogIn(prop.getProperty("L2ContractOpp"), prop.getProperty("password2"), "RBWLRH6LIBAFROJY");

}

}
