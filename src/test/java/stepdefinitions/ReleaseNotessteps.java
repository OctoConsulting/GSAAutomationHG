//package stepdefinitions;
//
//import static org.junit.Assert.assertTrue;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
//
//import cucumber.api.java.Before;
//import cucumber.api.java.en.And;
//import cucumber.api.java.en.Given;
//import cucumber.api.java.en.Then;
//import cucumber.api.java.en.When;
//import faqpages.CreateNewRN;
//import faqpages.EditFaq1;
//import faqpages.faqfilters;
//import faqpages.ReleaseNotesFiltersPage;
//import junit.framework.Assert;
//import login.govPages.homepage;
//import login.govPages.loginGov;
//import login.govPages.loginpage;
//import util.TestBase;
//
//public class ReleaseNotessteps extends TestBase {
//	loginpage LoginPage;
//	loginGov LoginGov;
//	homepage Homepage;
//	ReleaseNotesFiltersPage Rn;
//	CreateNewRN createNewRN;
//	EditFaq1 editFaq1;
//
//	@Before
//	public void Setup() {
//		LoginPage = new loginpage();
//		LoginGov = new loginGov();
//		Rn = new ReleaseNotesFiltersPage();
//		createNewRN = new CreateNewRN();
//		editFaq1 = new EditFaq1();
//	}
//
//	@Then("^The user click on go to Release notes link$")
//	public void the_user_click_on_go_to_Release_notes_link() throws Exception {
//		Thread.sleep(1000);
//		((JavascriptExecutor) driver).executeScript("scroll(0,2500)");
//		Rn = new ReleaseNotesFiltersPage();
//
//		Rn.intoReleaseNotes();
//	}
//
//	@Then("^Release user is able to select new status$")
//	public void release_user_is_able_to_select_new_status() throws Exception {
//		Rn.clicknewfilter();
//		assertTrue(" new banner was not found/new banner DID NOT OPEN", Rn.isnewtitledisplayed());
//
//	}
//
//	@Then("^Release user is able to deselect new filter$")
//	public void release_user_is_able_to_deselect_new_filter() throws Exception {
//		Rn.clicknewfilter();
//		assertTrue("faq new banner was found/new was selected", Rn.isnewnotdisplayed());
//
//	}
//
//	@Then("^Release user is able to selects published filter$")
//	public void release_user_is_able_to_selects_published_filter() throws Exception {
//		Rn.clickpublish();
//		assertTrue("faq published  banner not was found/published was not selected", Rn.ispublisheddisplayed());
//	}
//
//	@Then("^Release user is able to deselect published filter$")
//	public void release_user_is_able_to_deselect_published_filter() throws Exception {
//		Rn.uncheckpublishedfiter();
//		assertTrue("faq new banner was found/published was selected", Rn.ispublishednotdisplayed());
//	}
//
//	@Then("^Release user is able to selects draft filter$")
//	public void release_user_is_able_to_selects_draft_filter() throws Exception {
//		Rn.clickdraftfilter();
//		assertTrue(" draft banner was not found/draft was not selected", Rn.isdraftdisplayed());
//	}
//
//	@Then("^Release user is able to deselect draft filter$")
//	public void release_user_is_able_to_deselect_draft_filter() throws Exception {
//		Rn.uncheckdraftfiter();
//		assertTrue(" draft banner was found/draft was selected", Rn.isdraftnotdisplayed());
//	}
//
//	@Then("^Release user is able to selects archived filter$")
//	public void release_user_is_able_to_selects_archived_filter() throws Exception {
//		Rn.clickarchivedfilter();
//		assertTrue("archived banner was not found/archived was not selected", Rn.isarchiveddisplayed());
//
//	}
//
//	@Then("^Release user is able to deselect archived filter$")
//	public void release_user_is_able_to_deselect_archived_filter() throws Exception {
//		Rn.uncheckarchivefiter();
//		assertTrue("archived banner was found/archived was selected", Rn.isarchivednotdisplayed());
//
//	}
//
//	@Then("^Release user is able to search key word$")
//	public void release_user_is_able_to_search_key_word() throws Exception {
//		Rn.searchsampleRN();
//		// assertTrue(" sample search box was not found/search box value was not
//		// displayed",
//		// Rn.issearchboxsamplethere());
//
//	}
//
//	@Then("^Release user selects clear filter$")
//	public void release_user_selects_clear_filter() throws Exception {
//		Rn.clearallfilters();
//	}
//
//	@Then("^Release user click on descending sort by list$")
//	public void release_user_click_on_descending_sort_by_list() throws Exception {
//		Rn.sortdescendingorder();
//	}
//
//	@Then("^Release click on ascending sort by list$")
//	public void release_click_on_ascending_sort_by_list() throws Exception {
//		Rn.sortascendingorder();
//	}
//
//	@When("^Click on new Release$")
//	public void click_on_new_Release() throws Exception {
//		createNewRN = new CreateNewRN();
//		createNewRN.intocreatenewsampleRN();
//	}
//
//	@When("^The user enters release field$")
//	public void the_user_enters_release_field() throws Exception {
//		createNewRN.generateRN();
//	}
//
//	@Given("^The user enters the overview field$")
//	public void the_user_enters_the_overview_field() throws Exception {
//		createNewRN.generatefaqresponse();
//	}
//
//	@Then("^The users click on Release done button$")
//	public void the_users_click_on_Release_done_button() throws Exception {
//		// did this directly because element is not being found
//		driver.findElement(By.xpath("//*[@id=\"question-done\"]")).click();
//		Thread.sleep(2000);
//		((JavascriptExecutor) driver).executeScript("scroll(0,-1000)");
//	}
//
//	@When("^The user enters the details field$")
//	public void the_user_enters_the_details_field() throws Exception {
//		createNewRN.enteroverview();
//	}
//
//	@When("^The users enters blank release note$")
//	public void the_users_enters_blank_release_note() throws Exception {
//		createNewRN.NegCreateRN();
//		assertTrue("createNewRN not found/value was not displayed", createNewRN.isCreateRNFailed());
//
//	}
//
//	@Then("^Release user enters the REVISED edit field$")
//	public void Release_user_enters_the_REVISED_edit_field() throws Exception {
//		createNewRN.editdetails();
//
//	}
//
//	@When("^The users click on Release link$")
//	public void the_users_click_on_Release_link() throws Exception {
//		// did this directly because element is not being found
//		driver.findElement(By.xpath("//*[@href=\"/cm/release?path=1\"]")).click();
//		Thread.sleep(1000);
//	}
//
//	@Then("^user will validate published Release Note$")
//	public void user_will_validate_published_Release_Note() throws Exception {
//
//		Rn.intoReleaseHomepage();
////do assert for new rn
//		System.out.println("Wednesday" + createNewRN.isTitleVisible());
//
//		assertTrue(" was not found archived/value was not displayed", createNewRN.isTitleVisible());
//
//	}
//
//	@Then("^user will validate that Release note is Archived$")
//	public void user_will_validate_that_Release_note_is_Archived() throws Exception {
//		assertTrue(" was not found archived/value was not displayed", Rn.isMadeArchived());
//
//	}
//
//	@Then("^user will validate newly published Release Note$")
//	public void user_will_validate_newly_published_Release_Note() throws Exception {
//
//		Rn.intoReleaseHomepage();
//		// do assert on edited rn
//		System.out.println("Thursday" + editFaq1.getRandomRNEditTitle());
//
//		assertTrue(" was not found archived/value was not displayed", editFaq1.isTitleVisible());
//	}
//
//	@Then("^user will return to workspace from release notes page$")
//	public void user_will_return_to_workspace_from_release_notes_page() throws Exception {
//		Rn.workspacefromRNpage();
//
//	}
//
//	@Then("^The user navigates to Glossary page$")
//	public void the_user_navigates_to_Glossary_page() throws Exception {
//		Thread.sleep(1000);
//		((JavascriptExecutor) driver).executeScript("scroll(0,2500)");
//		driver.findElement(By.xpath("//a[text()='Go to Glossary']")).click();
//		Thread.sleep(2000);
//
//	}
//
//	@And("^The Glossary user is able to search key word$")
//	public void the_Glossary_user_is_able_to_search_key_word() throws Exception {
//		Rn = new ReleaseNotesFiltersPage();
//		Rn.searchsampleGlossary();
//	}
//
//	@And("^user Clicks on new Glossary$")
//	public void user_Clicks_on_new_Glossary() throws Exception {
//		Rn = new ReleaseNotesFiltersPage();
//		Rn.intocreatenewsampleGlossary();
//	}
//
//	@Then("^The users click on Glossary link$")
//	public void the_users_click_on_FAQs_link() throws Exception {
//		Rn.returntoGlossaryhomepage();
//		Thread.sleep(1000);
//	}
//
//	@Then("^Glossary user successfully click on done button$")
//	public void faq_User_successfully_click_on_done_button() throws Exception {
//		Rn = new ReleaseNotesFiltersPage();
//		Rn.completeeditGlossary();
//	}
//
//}