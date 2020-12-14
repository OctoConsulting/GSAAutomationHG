package stepdefinitions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import cmsPages.Alerts;
import cmsPages.CreateNewFaq;
import cmsPages.CreateNewRN;
import cmsPages.CreateNewVideo;
import cmsPages.EditFaq1;
import cmsPages.EditFaq2Archive;
import cmsPages.ReleaseNotesFiltersPage;
import cmsPages.faqfilters;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import login.govPages.homepage;
import login.govPages.loginGov;
import login.govPages.loginpage;
import util.TestBase;

public class CMSsteps extends TestBase {
	loginpage LoginPage;
	loginGov LoginGov;
	homepage Homepage;
	faqfilters Faqfilters;
	CreateNewFaq createNewFaq;
	EditFaq1 editFaq1;
	EditFaq2Archive editFaq2;
	ReleaseNotesFiltersPage Rn;
	CreateNewRN createNewRN;
	CreateNewVideo createNewVideo;
	Alerts alerts;
	HashMap<String, String> hm = new HashMap<String, String>();
//	private String timestampA; // FOR REQUESTED SENT
//	private String timestampB; // FOR REQUEST RECEIVED
//	private String timestampC; // FOR REQUEST DELETED SENT
//	private String timestampD; // FOR REQUEST DELETED RECEIVED
//	private String timestampE; // FOR ASSIGNED SENT
//	private String timestampF; // FOR ASSIGNED RECEIVED
//	private String timestampG; // FOR ASSIGNED DELETED SENT
	private String timestampH; // FOR ASSINGED DELETED RECEIVED
	@Before
	

	public void Setup() {
		LoginPage = new loginpage();
		LoginGov = new loginGov();
		Faqfilters = new faqfilters();
		createNewFaq = new CreateNewFaq();
		editFaq1 = new EditFaq1();
		editFaq2 = new EditFaq2Archive();
		Rn = new ReleaseNotesFiltersPage();
		createNewRN = new CreateNewRN();

	}

	@Given("^CMS Content Admin user logs in$")
	public void faq_Content_Admin_user_logs_in() throws Exception {
		LoginGov = new loginGov();
		LoginGov.GeneralLogIn(prop.getProperty("Content"), prop.getProperty("password"),
				"JQRPSD2QA4NSX6UB");
	}

	@Then("^The user click on go to FAQs link$")
	public void the_user_click_on_go_to_FAQs_link() throws InterruptedException {
		Thread.sleep(1000);
	
		Faqfilters = new faqfilters();
		((JavascriptExecutor) driver).executeScript("scroll(0,2500)");
		Faqfilters.intofaq();
	}

	@And("^The user navigates to FAQs page$")
	public void the_user_navigates_to_glossary_page() throws InterruptedException {
		assertTrue("faq breadcrumb was not found/FAQ PAGE DID NOT OPEN", Faqfilters.isfaqdisplayed());

	}

	@And("^CMS The user is able to select new status$")
	public void The_user_select_new_status() throws InterruptedException {
		Faqfilters = new faqfilters();

		Faqfilters.clicknewfilter();
		assertTrue("CMS new banner was not found/new banner DID NOT OPEN", Faqfilters.isnewtitledisplayed());
	}

	@And("^CMS The user is able to deselect new filter$")
	public void the_user_deselect_new_filter() throws InterruptedException {
		Faqfilters.unchecknewfiter();
		assertTrue("CMS new banner was found/new was selected", Faqfilters.isnewnotdisplayed());

	}

	@And("^CMS The user is able to selects published filter$")
	public void the_user_selects_published_filter() throws InterruptedException {
		Faqfilters = new faqfilters();
		Faqfilters.clickpublish();
		assertTrue("CMS published  banner not was found/published was not selected", Faqfilters.ispublisheddisplayed());
	}

	@And("^CMS The user is able to deselect published filter$")
	public void the_user_deselect_published_filter() throws InterruptedException {
		Faqfilters.uncheckpublishedfiter();
		assertTrue("CMS new banner was found/published was selected", Faqfilters.ispublishednotdisplayed());

	}

	@And("^CMS The user is able to selects draft filter$")
	public void the_user_selects_draft_filter() throws InterruptedException {

		Faqfilters.clickdraftfilter();
		assertTrue("CMS draft banner was not found/draft was not selected", Faqfilters.isdraftdisplayed());
	}

	@And("^CMS The user is able to deselect draft filter$")
	public void the_user_deselect_draft_filter() throws InterruptedException {
		Faqfilters.uncheckdraftfiter();
		assertTrue("CMS draft banner was found/draft was selected", Faqfilters.isdraftnotdisplayed());
	}

	@And("^CMS The user is able to selects archived filter$")
	public void the_user_selects_archived_filter() throws InterruptedException {
		Faqfilters.clickarchivedfilter();
		assertTrue("CMS archived banner was not found/archived was not selected", Faqfilters.isarchiveddisplayed());

	}

	@And("^CMS The user is able to deselect archived filter$")
	public void the_user_deselect_archived_filter() throws InterruptedException {
		Faqfilters.uncheckarchivefiter();
		assertTrue("CMS archived banner was found/archived was selected", Faqfilters.isarchivednotdisplayed());

	}

	@And("^The user CMS is able to search key word$")
	public void the_user_is_able_to_search_key_word() throws InterruptedException {
		Faqfilters.searchsamplefaq();
		assertTrue("CMS sample search box was not found/search box value was not displayed",
				Faqfilters.issearchboxsamplethere());

	}

	@Then("^The user CMS selects clear filter$")
	public void the_user_CMS_selects_clear_filter() throws Exception {
		Faqfilters.clearallfilters();

	}

	@Then("^The user CMS click on descending sort by list$")
	public void the_user_CMS_click_on_descending_sort_by_list() throws Exception {
		Faqfilters.sortdescendingorder();
	}

	@Then("^user CMS click on ascending sort by list$")
	public void user_CMS_click_on_ascendent_sort_by_list() throws Exception {
		Faqfilters.sortascendingorder();
	}

	@Then("^user Clicks on new FAQs$")
	public void user_Clicks_on_new_FAQs() throws Exception {
		createNewFaq = new CreateNewFaq();
		createNewFaq.intocreatenewsamplefaq();
		assertTrue("faq createNewFaq not found/value was not displayed", createNewFaq.iscreatefaqpageenabled());

	}

	@Then("^the user trys to submit a blank CMS$")
	public void the_user_trys_to_submit_a_blank_CMS() throws Exception {
		createNewFaq = new CreateNewFaq();
		createNewFaq.NegCreateFaq();
		assertTrue("faq createNewFaq not found/value was not displayed", createNewFaq.isCreateFaqFailed());

	}

	@Then("^The user enters Question field$")
	public void the_user_enters_Question_field() throws Exception {
		createNewFaq.generatefaq();
	}

	@Then("^The user enters the Response field$")
	public void the_user_enters_the_Response_field() throws Exception {
		createNewFaq.generatefaqresponse();

	}

	@Then("^The user enters CMS keywords fields$")
	public void the_user_enters_CMS_keywords_fields() throws Exception {
		createNewFaq.generatekeyword();
	}

	@Then("^The user clicks on display on homepage$")
	public void the_user_clicks_on_display_on_homepage() throws Exception {
		createNewFaq.enabledisplayfaq();
	}

	@Then("^The users click on CMS done button$")
	public void the_users_click_on_CMS_done_button() throws Exception {
		createNewFaq = new CreateNewFaq();
		createNewFaq.completenewfaq();
	}

	@Then("^The users click on FAQs link$")
	public void the_users_click_on_FAQs_link() throws Exception {
		
		createNewFaq.returntofaqhomepage();
		Thread.sleep(1000);

	}

	@Then("^users CMS is generated$")
	public void users_CMS_is_generated() throws Exception {
		Faqfilters = new faqfilters();
		assertTrue("CMS new banner was not found/new banner DID NOT OPEN", Faqfilters.isnewtitledisplayed());
	}

	@Given("^CMS user Clicks on actions dropdown list$")
	public void CMS_user_Clicks_on_actions_dropdown_list() throws Exception {
		editFaq1 = new EditFaq1();
		editFaq1.usingactions();

	}

	@Then("^user will click on publish$")
	public void user_will_click_on_publish() throws Exception {
		editFaq1.publishingfaq();
	}
	@Then("^user will click on publish on dropdown$")
	public void user_will_click_on_publish_on_dropdown() throws Exception {
		editFaq1.dropdownpublished();

	}
	@Then("^CMS User successfully published the new CMS$")
	public void CMS_User_successfully_published_the_new_CMS() throws Exception {

		assertTrue("CMS was not found published/value was not displayed", editFaq1.isfaqpublished());

	}

	@Then("^user will click on edit$")
	public void user_will_click_on_edit() throws Exception {
		editFaq1.draftfaq();
		editFaq1.editgeneratedfaq();

	}

	@Then("^CMS The user enters the REVISED edit field$")
	public void CMS_The_user_enters_the_REVISED_edit_field() throws Exception {
		editFaq1.editgeneratedquestion();
	}

	@Then("^FAQ User successfully click on done button$")
	public void faq_User_successfully_click_on_done_button() throws Exception {

		editFaq1.enabledisplayfaq();
		editFaq1.completeeditfaq();
		editFaq1.returntofaqhomepage();
	}

	@Then("^CMS User successfully makes CMS into draft$")
	public void CMS_User_successfully_makes_CMS_into_draft() throws Exception {
		assertTrue("faq was not found drafted/value was not displayed", editFaq1.isfaqdrafted());
		Thread.sleep(5000);
	}

	@Then("^the user will search the CMS$")
	public void the_user_will_search_the_CMS() throws Exception {
		createNewFaq = new CreateNewFaq();
		createNewFaq.searchTheRandomFaqTitle();

	}

	@Then("^the user will successfully find the CMS$")
	public void the_user_will_successfully_find_the_CMS() throws Exception {
		assertEquals("Did not Find FAQ", createNewFaq.getPreviouslySubmittedFaqTitle(),
				createNewFaq.getDisplayedFaqTitle());

	}

	@Then("^CMS The user successfully clicks on the archive$")
	public void CMS_The_user_successfully_clicks_on_the_archive() throws Exception {
		editFaq2 = new EditFaq2Archive();
		editFaq2.dropdownarchived();
	}

	@Then("^the CMS is archived$")
	public void the_CMS_is_archived() throws Exception {
		assertTrue("faq was not found archived/value was not displayed", editFaq2.isarchived());
		Thread.sleep(5000);
	}

	@Then("^CMS The user successfully clicks on the unarchive the CMS$")
	public void CMS_The_user_successfully_clicks_on_the_unarchive_the_CMS() throws Exception {
		editFaq2.dropdownunarchived();
	}

	@Then("^user delete generated CMS$")
	public void user_delete_generated_CMS() throws Exception {
		editFaq2.deletegeneratedfaq();
	}

	@Then("^Browser closes$")
	public void browser_closes() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}

	@Then("^the user will Navigate to Homepage$")
	public void the_user_will_Navigate_to_Homepage() throws Exception {
		driver.findElement(By.xpath("//img[@src=\"assets/img/sam-logo.png\" and @alt=\"beta.sam.gov logo.\"]")).click();
		Thread.sleep(3000);
		((JavascriptExecutor) driver).executeScript("scroll(0,2100)");
		Thread.sleep(5000);

	}

	@Then("^unpublished faq should not display$")
	public void unpublished_faq_should_not_display() throws Exception {
		String expectedFaqTitle = createNewFaq.getPreviouslySubmittedFaqTitle();

		hm.put("tile", expectedFaqTitle);
		assertFalse("NEW FAQ WAS DISPLAYED, was not supposed to",
				createNewFaq.isFaqDisplayedOnHomePage(expectedFaqTitle));

	}

	@Then("^published faq should display$")
	public void published_faq_should_display() throws Exception {
		for (Map.Entry m : hm.entrySet()) {
			System.out.println(m.getKey() + " " + m.getValue());
			assertTrue("NEW FAQ WAS WRONGFULLY DISPLAYED, should be displayed",
					createNewFaq.isFaqDisplayedOnHomePage((String) m.getValue()));
		}
	}

	@Then("^the user will go back to workspace from homepage$")
	public void the_user_will_go_back_to_workspace_from_homepage() throws Exception {
		// editFaq1.BacktoWorkspaceFromSamHomepage();
		((JavascriptExecutor) driver).executeScript("scroll(0,-1500)");
		// ExpandableMenu.click();
		driver.findElement(
				By.xpath("//button[@aria-label=\"Expandable links menu. Collapsed. \"and @id=\"headerIconMenu\"]"))
				.click();
		Thread.sleep(2000);
		// WorkspaceTab.click();
		driver.findElement(By.xpath("//a[@id=\"header-link-workspace\"]")).click();
	}

	@Then("^The user click on go to Release notes link$")
	public void the_user_click_on_go_to_Release_notes_link() throws Exception {
		Thread.sleep(1000);
		((JavascriptExecutor) driver).executeScript("scroll(0,2500)");
		Rn = new ReleaseNotesFiltersPage();

		Rn.intoReleaseNotes();
	}

	@Then("^Release user is able to select new status$")
	public void release_user_is_able_to_select_new_status() throws Exception {
		Rn.clicknewfilter();
		assertTrue(" new banner was not found/new banner DID NOT OPEN", Rn.isnewtitledisplayed());

	}

	@Then("^Release user is able to deselect new filter$")
	public void release_user_is_able_to_deselect_new_filter() throws Exception {
		Rn.clicknewfilter();
		assertTrue("faq new banner was found/new was selected", Rn.isnewnotdisplayed());

	}

	@Then("^Release user is able to selects published filter$")
	public void release_user_is_able_to_selects_published_filter() throws Exception {
		Rn.clickpublish();
		assertTrue("faq published  banner not was found/published was not selected", Rn.ispublisheddisplayed());
	}

	@Then("^Release user is able to deselect published filter$")
	public void release_user_is_able_to_deselect_published_filter() throws Exception {
		Rn.uncheckpublishedfiter();
		assertTrue("faq new banner was found/published was selected", Rn.ispublishednotdisplayed());
	}

	@Then("^Release user is able to selects draft filter$")
	public void release_user_is_able_to_selects_draft_filter() throws Exception {
		Rn.clickdraftfilter();
		assertTrue(" draft banner was not found/draft was not selected", Rn.isdraftdisplayed());
	}

	@Then("^Release user is able to deselect draft filter$")
	public void release_user_is_able_to_deselect_draft_filter() throws Exception {
		Rn.uncheckdraftfiter();
		assertTrue(" draft banner was found/draft was selected", Rn.isdraftnotdisplayed());
	}

	@Then("^Release user is able to selects archived filter$")
	public void release_user_is_able_to_selects_archived_filter() throws Exception {
		Rn.clickarchivedfilter();
		assertTrue("archived banner was not found/archived was not selected", Rn.isarchiveddisplayed());

	}

	@Then("^Release user is able to deselect archived filter$")
	public void release_user_is_able_to_deselect_archived_filter() throws Exception {
		Rn.uncheckarchivefiter();
		assertTrue("archived banner was found/archived was selected", Rn.isarchivednotdisplayed());

	}

	@Then("^Release user is able to search key word$")
	public void release_user_is_able_to_search_key_word() throws Exception {
		Rn.searchsampleRN();

	}

	@Then("^Release user selects clear filter$")
	public void release_user_selects_clear_filter() throws Exception {
		Rn.clearallfilters();
	}

	@Then("^Release user click on descending sort by list$")
	public void release_user_click_on_descending_sort_by_list() throws Exception {
		Rn.sortdescendingorder();
	}

	@Then("^Release click on ascending sort by list$")
	public void release_click_on_ascending_sort_by_list() throws Exception {
		Rn.sortascendingorder();
	}

	@When("^Click on new Release$")
	public void click_on_new_Release() throws Exception {
		createNewRN = new CreateNewRN();
		createNewRN.intocreatenewsampleRN();
	}

	@When("^The user enters release field$")
	public void the_user_enters_release_field() throws Exception {
		createNewRN.generateRN();
	}

	@Given("^The user enters the overview field$")
	public void the_user_enters_the_overview_field() throws Exception {
		createNewRN.generatefaqresponse();
	}

	@Then("^The users click on Release done button$")
	public void the_users_click_on_Release_done_button() throws Exception {
		// did this directly because element is not being found
		driver.findElement(By.xpath("//*[@id=\"question-done\"]")).click();
		Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("scroll(0,-1000)");
	}

	@When("^The user enters the details field$")
	public void the_user_enters_the_details_field() throws Exception {
		createNewRN.enteroverview();
	}

	@When("^The users enters blank release note$")
	public void the_users_enters_blank_release_note() throws Exception {
		createNewRN.NegCreateRN();
		assertTrue("createNewRN not found/value was not displayed", createNewRN.isCreateRNFailed());

	}

	@Then("^Release user enters the REVISED edit field$")
	public void Release_user_enters_the_REVISED_edit_field() throws Exception {
		createNewRN.editdetails();

	}

	@When("^The users click on Release link$")
	public void the_users_click_on_Release_link() throws Exception {
		// did this directly because element is not being found
		driver.findElement(By.xpath("//*[@href=\"/cm/release?path=1\"]")).click();
		Thread.sleep(1000);
	}

	@Then("^user will validate published Release Note$")
	public void user_will_validate_published_Release_Note() throws Exception {

		Rn.intoReleaseHomepage();
//do assert for new rn
		System.out.println("Wednesday" + createNewRN.isTitleVisible());

		assertTrue(" was not found archived/value was not displayed", createNewRN.isTitleVisible());

	}

	@Then("^user will validate that Release note is Archived$")
	public void user_will_validate_that_Release_note_is_Archived() throws Exception {

		assertTrue(" was not found archived/value was not displayed", Rn.isMadeArchived());

	}

	@Then("^user will validate newly published Release Note$")
	public void user_will_validate_newly_published_Release_Note() throws Exception {

		Rn.intoReleaseHomepage();
		// do assert on edited rn
		System.out.println("Thursday" + editFaq1.getRandomRNEditTitle());

		assertTrue(" was not found archived/value was not displayed", editFaq1.isTitleVisible());
	}

	@Then("^user will return to workspace from release notes page$")
	public void user_will_return_to_workspace_from_release_notes_page() throws Exception {
		Rn.workspacefromRNpage();

	}

	@Then("^The user navigates to Glossary page$")
	public void the_user_navigates_to_Glossary_page() throws Exception {
		Thread.sleep(1000);
		((JavascriptExecutor) driver).executeScript("scroll(0,2500)");
		driver.findElement(By.xpath("//strong[text()='Glossary']")).click();
		Thread.sleep(2000);

	}

	@And("^The Glossary user is able to search key word$")
	public void the_Glossary_user_is_able_to_search_key_word() throws Exception {
		Rn = new ReleaseNotesFiltersPage();
		Rn.searchsampleGlossary();
	}

	@And("^user Clicks on new Glossary$")
	public void user_Clicks_on_new_Glossary() throws Exception {
		Rn = new ReleaseNotesFiltersPage();
		Rn.intocreatenewsampleGlossary();
	}

	@Then("^The users click on Glossary link$")
	public void the_users_click_on_Glossary_link() throws Exception {
		Rn.returntoGlossaryhomepage();
		Thread.sleep(1000);
	}

	@Then("^Glossary user successfully click on done button$")
	public void Glossary_User_successfully_click_on_done_button() throws Exception {
		Rn = new ReleaseNotesFiltersPage();
		Rn.completeeditGlossary();
	}


	@Then("^The user navigates to Video page$")
	public void the_user_navigates_to_Video_page() throws Exception {
		createNewVideo = new CreateNewVideo();
		createNewVideo.intoVIDEOS();
		assertTrue("CMS new banner was found/new was selected", createNewVideo.itsVideoPagedisplayed());

		
	}

	@Then("^user Clicks on new Video$")
	public void user_Clicks_on_new_Video() throws Exception {
		assertTrue("CMS new banner was found/new was selected", createNewVideo.itCreateVideodisplayed());

		createNewVideo.intocreatenewsampleVideo();
		
	}

	@Then("^The users click on Video Breadcrumb link$")
	public void the_users_click_on_Video_Breadcrumb_link() throws Exception {
		createNewVideo.returntoVideohomepage();
		assertTrue("CMS new banner was found/new was selected", createNewVideo.itsVideoPagedisplayed());

		
	}
	
	@Then("^the user uploads a video from local$")
	public void the_user_uploads_a_video_from_local() throws Exception {
		createNewVideo.UploadNegVideo();
		assertTrue("Video wasnt not accepted", createNewVideo.isVideoNotUploaded());
		createNewVideo.UploadPosVideo();
	}
	@Given("^The user is able to search key word on videos$")
	public void the_user_is_able_to_search_key_word_on_videos() throws Exception {
		createNewVideo.generatekeyword();
		assertTrue("CMS new banner was found/new was selected", createNewVideo.itsVideoPagedisplayed());
}
	@Then("^user will see video on CMS homepage$")
	public void user_will_see_video_on_CMS_homepage() throws Exception {

		createNewVideo.validateCMSVideoHomepage();
	}
	@When("^user enters system alerts page$")
	public void user_enters_system_alerts_page() throws Exception {
	  alerts=new Alerts();
	  alerts.intoAlerts();
		assertTrue("alerts page found1", alerts.AlertsCheck());
		  
	}

@When("^user sets all the filters back to all$")
public void user_sets_all_the_filters_back_to_all() throws Exception {
	alerts.AlertValidatingPagination();
	  alerts.checkpage();
		//TURN ON WHEN ITS FIXED
		

}


@Then("^the user will validate pagination is working on alerts$")
public void the_user_will_validate_pagination_is_working_on_alerts() throws Exception {
	boolean PaginationCheck= alerts.isPaginationWorking();
	Assert.assertTrue(PaginationCheck);

}

@Then("^the user will validate all filters and dropdowns on alerts page$")
public void the_user_will_validate_all_filters_and_dropdowns_on_alerts_page() throws Exception {
	alerts.intoAlertsDropdown1();
	assertTrue("alerts page found2", alerts.AlertsCheck2());

	alerts.intoAlertsDropdown2();
	assertTrue("alerts page found3", alerts.AlertsCheck3());

	alerts.intoAlertsDropdown3();
	assertTrue("alerts page found4", alerts.AlertsCheck4());

	alerts.intoAlertsDropdown4();
	assertTrue("alerts page found5", alerts.AlertsCheck5());

	alerts.intoAlertsDropdown5();
	assertTrue("alerts page found6", alerts.AlertsCheck6());
	alerts.intoAlertsDropdown6();
	alerts.CreateAlerts9();
	

}

@When("^a user enters blank values to create a alerts for all types$")
public void a_user_enters_blank_values_to_create_a_alerts_for_all_types() throws Exception {
	alerts.NegCreateAlerts();
	assertTrue("error1", alerts.Validation());
	alerts.NegCreateAlerts2();
	assertTrue("error2", alerts.Validation());
	alerts.NegCreateAlerts3();
	assertTrue("error3", alerts.Validation());
	alerts.NegCreateAlerts4();
	assertTrue("error4", alerts.Validation());
	
}


@Then("^user creates each type of alert so user validates that they are created$")
public void user_creates_each_type_of_alert_so_user_validates_that_they_are_created() throws Exception {
	alerts.CreateAlerts5();
	assertTrue("alerts WAS not made informational", alerts.AlertsCheck3());

alerts.CreateAlerts6();
	assertTrue("alerts WAS not made error", alerts.AlertsCheck4());

	alerts.CreateAlerts7();
	assertTrue("alerts WAS  not made warning", alerts.AlertsCheck5());

	alerts.CreateAlerts8();
	assertTrue("alerts WAS not made wage", alerts.AlertsCheck6());


}

@Then("^user expires all the created alerts except one needed for validation$")
public void user_expires_all_the_created_alerts_except_one_needed_for_validation() throws Exception {
	assertTrue("alerts was not published", alerts.PublishedAlert());
	alerts.CreateAlerts10();
	assertTrue("alerts was not published", alerts.PublishedAlert());

}

@Then("^user validates that a published alert is visible on the homepage$")
public void user_validates_that_a_published_alert_is_visible_on_the_homepage() throws Exception {
	assertTrue("alerts was not published as error", alerts.PublishedAlert2());
}
@Then("^the user creates informational alert$")
public void the_user_creates_informational_alert() throws Exception {
	alerts.CreateAlerts00();
	alerts.CreateAlerts5();
	assertTrue("alerts WAS not made informational", alerts.AlertsCheck3());
}


@Then("^the user validates that informational alert is on notification feeds page$")
public void the_user_validates_that_informational_alert_is_on_notification_feeds_page() throws Exception {
	alerts.validateNotification();
	boolean flag = alerts.ValidationNotificationsName1();
	Assert.assertTrue(flag);

	Thread.sleep(5000);
	alerts.validateNotification2();
}

@Then("^the user creates error alert$")
public void the_user_creates_error_alert() throws Exception {
	alerts.CreateAlerts11();
	assertTrue("alerts WAS not made error", alerts.AlertsCheck4());
	
}

@Then("^the user validates that error alert is on notification feeds page$")
public void the_user_validates_that_error_alert_is_on_notification_feeds_page() throws Exception {

	alerts.validateNotification();
	boolean flag = alerts.ValidationNotificationsName2();
	Assert.assertTrue(flag);

	Thread.sleep(5000);
	alerts.validateNotification2();
}

@Then("^the user creates warning alert$")
public void the_user_creates_warning_alert() throws Exception {
	alerts.CreateAlerts7();
	assertTrue("alerts WAS  not made warning", alerts.AlertsCheck5());

}

@Then("^the user validates that warning alert is on notification feeds page$")
public void the_user_validates_that_warning_alert_is_on_notification_feeds_page() throws Exception {
	alerts.validateNotification();
	
	boolean flag = alerts.ValidationNotificationsName3();
	Assert.assertTrue(flag);

	alerts.validateNotification2();
}

@Then("^the user creates wage determination alert$")
public void the_user_creates_wage_determination_alert() throws Exception {
	alerts.CreateAlerts8();
	assertTrue("alerts WAS not made wage", alerts.AlertsCheck6());

}

@Then("^the user validates that wage determination alert is NOT on notification feeds page$")
public void the_user_validates_that_wage_determination_alert_is_NOT_on_notification_feeds_page() throws Exception {
	alerts.validateNotification();
	boolean flag = alerts.ValidationNotificationsName4();
	Assert.assertTrue(flag);
	alerts.validateNotification2();
	alerts.NotificationDelete();
}
@Then("^the user validates that error alert is on ALERT notification feeds page$")
public void the_user_validates_that_error_alert_is_on_ALERT_notification_feeds_page() throws Exception {
	alerts.validateNotificationForAlertsTab();
	alerts.AlertFeedPage();
	boolean flag = alerts.ValidationNotificationsName2();
	Assert.assertTrue(flag);

	Thread.sleep(5000);
	alerts.validateNotification2();
}


@Then("^the user validates that informational alert is on ALERT notification feeds page$")
public void the_user_validates_that_informational_alert_is_on_ALERT_notification_feeds_page() throws Exception {
	alerts.validateNotificationForAlertsTab();
	alerts.AlertFeedPage();
	boolean flag = alerts.ValidationNotificationsName1();
	Assert.assertTrue(flag);

	Thread.sleep(5000);
	alerts.validateNotification2();
}

@Then("^the user validates that warning alert is on ALERT notification feeds page$")
public void the_user_validates_that_warning_alert_is_on_ALERT_notification_feeds_page() throws Exception {
alerts.validateNotificationForAlertsTab();
alerts.AlertFeedPage();
	boolean flag = alerts.ValidationNotificationsName3();
	Assert.assertTrue(flag);

	alerts.validateNotification2();
}

@Then("^the user validates that wage determination alert is NOT on ALERT notification feeds page$")
public void the_user_validates_that_wage_determination_alert_is_NOT_on_ALERT_notification_feeds_page() throws Exception {
	alerts.validateNotificationForAlertsTab();
	alerts.AlertFeedPage();
	boolean flag = alerts.ValidationNotificationsName4();
	Assert.assertTrue(flag);
	alerts.validateNotification2();
	alerts.NotificationDelete();
		
}

@Then("^user runs filters including tabs and search and sort and pagination on alert feeds$")
public void user_runs_filters_including_tabs_and_search_and_sort_and_pagination_on_alert_feeds() throws Exception {

	alerts.validateNotificationForAlertsTab();
	assertTrue("alerts not found1", alerts.InformationalCheckFeeds());
	assertTrue("alerts not found2", alerts.ErrorCheckFeeds());
	assertTrue("alerts not found3", alerts.WarningCheckFeeds());
	assertTrue("alerts not found4", alerts.ActiveCheckFeeds());
	assertTrue("alerts not found5", alerts.InactiveCheckFeeds());
	assertTrue("alerts not found6", alerts.ClearFiltersCheckFeeds());
	assertTrue("alerts not found7", alerts.SortFilters());
	assertTrue("alerts not found8", alerts.SearchBox());
	//FIX
	  //alerts.checkpageNoticationAlert();
	  //boolean PaginationCheck= alerts.isPaginationWorking();
		//Assert.assertTrue(PaginationCheck);
}


}