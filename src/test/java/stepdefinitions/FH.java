package stepdefinitions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import FeedsPages.feeds;
import FhPages.CreateEditDep;
import FhPages.CreateEditSubtier;
import FhPages.CreateOffice;
import FhPages.EditOffice;
import FhPages.FHorgPicker;
import FhPages.FhBasics;
import FhPages.FhEventsPages;
import FhPages.FhOrgPickerValidation;
import FhPages.GeneralFHPage;
import FhPages.OfficeMove;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import login.govPages.loginGov;
import util.TestBase;

public class FH extends TestBase {
	loginGov LoginGov;
	FhBasics fhBasics;
	FHorgPicker fHorgPicker;
	FhOrgPickerValidation fhOrgPickerValidation;
	CreateEditDep createEditDep;
	CreateEditSubtier createEditSubtier;
	FhEventsPages fhEventsPages;
	CreateOffice createOffice;
	EditOffice editOffice;
	OfficeMove officeMove;
	feeds Feeds;
	GeneralFHPage generalFhPage;
	
	@Then("^FH pmo searches heirarchy$")
	public void fh_pmo_searches_heirarchy() throws Exception {
		fhBasics = new FhBasics();
		fhBasics.intoFH();
		fhBasics.SearchDEFENSE();
		boolean flag = fhBasics.DODValidation();
		Assert.assertTrue(flag);
		boolean flag2 = fhBasics.FHaCTIVE();
		Assert.assertTrue(flag2);
		fhBasics.clickActive();
		((JavascriptExecutor) driver).executeScript("scroll(0,100)");
		Thread.sleep(3000);
		fhBasics.clickInactive();
		boolean flag3 = fhBasics.FHInaCTIVE();
		Assert.assertTrue(flag3);
		fhBasics.clickInactive();
		fhBasics.clickDepTab();
		boolean flag4 = fhBasics.FHDeptTab();
		Assert.assertTrue(flag4);
		fhBasics.clickDepTab();
		fhBasics.clicksubtierTab();
		boolean flag5 = fhBasics.FHSubtierTab();
		Assert.assertTrue(flag5);
		fhBasics.clicksubtierTab();
		fhBasics.clickOfficeTab();
		boolean flag6 = fhBasics.FHOfficeTab();
		Assert.assertTrue(flag6);
		fhBasics.clearFH();
		fhBasics.SearchIAE();
		assertTrue("IAE results are not there", fhBasics.IAEDataThere());
		assertTrue("IAE RESULTS ARE NOT THERE2", fhBasics.IAEDataThere2());
		fhBasics.SearchHHR();
		assertTrue("HHR DATA IS NOT THERE", fhBasics.HHRDataThere());
		fhBasics.SearchDOLL3();
		assertTrue("DOL DATA IS NOT THERE", fhBasics.DOLDataThere());
		fhBasics.SearchGSAL2();
		assertTrue("GSA DATA IS NOT THERE", fhBasics.GSAL2DataThere());
	}

	@Then("^They will validate searches for non FH users$")
	public void they_will_validate_searches_for_non_FH_users() throws Exception {
		fhBasics = new FhBasics();
		fhBasics.intoFHnonFHmember();
		fhBasics.SearchDEFENSE();
		boolean flag = fhBasics.DODValidation();
		Assert.assertFalse(flag);
		fhBasics.clearFH();
		fhBasics.SearchIAE();
		assertTrue("IAE results are not there", fhBasics.IAEDataThere());
		assertTrue("IAE RESULTS ARE NOT THERE2", fhBasics.IAEDataThere2());
		fhBasics.SearchHHR();
		assertTrue("HHR DATA IS THERE", !fhBasics.HHRDataThere());
		fhBasics.SearchDOLL3();
		assertTrue("DOL DATA IS THERE", !fhBasics.DOLDataThere());
		fhBasics.SearchGSAL2();
		assertTrue("GSA DATA IS NOT THERE", fhBasics.GSAL2DataThere());
	}

	@Then("^They will validate searches for FH users$")
	public void they_will_validate_searches_for_FH_users() throws Exception {
		fhBasics = new FhBasics();
		fhBasics.intoFH();
		fhBasics.SearchDEFENSE();
		boolean flag = fhBasics.DODValidation();
		Assert.assertFalse(flag);
		fhBasics.clearFH();
		fhBasics.SearchIAE();
		assertTrue("IAE results are not there", fhBasics.IAEDataThere());
		assertTrue("IAE RESULTS ARE NOT THERE2", fhBasics.IAEDataThere2());
		fhBasics.SearchHHR();
		assertTrue("HHR DATA IS THERE", !fhBasics.HHRDataThere());
		fhBasics.SearchDOLL3();
		assertTrue("DOL DATA IS THERE", !fhBasics.DOLDataThere());
		fhBasics.SearchGSAL2();
		assertTrue("GSA DATA IS NOT THERE", fhBasics.GSAL2DataThere());
	}

	@Given("^a FH PMO logs in$")
	public void a_FH_PMO_logs_in() throws Exception {
		LoginGov = new loginGov();
		LoginGov.GeneralLogIn(prop.getProperty("FedHierachyPMOAdmin"), prop.getProperty("password"),
				"HDFG3SGELTYUO2T2");
	}
	@Given("^a FH PMO logs in Alpha$")
	public void a_FH_PMO_logs_in_Alpha() throws Exception {
		LoginGov = new loginGov();
		LoginGov.GeneralLogIn(prop.getProperty("FedHierachyPMOAdminAlpha"), prop.getProperty("password2"),
				"CSHPIXIAPLMNIZOS");
	}

	@Then("^FH PMO validates all appropriate functions on their landing pages\\(FH link is visible,Create dep/createL(\\d+)/L(\\d+) are applicable\\. Administrator icons are visible and Sorts and pagination is working\\)$")
	public void fh_PMO_validates_all_appropriate_functions_on_their_landing_pages_FH_link_is_visible_Create_dep_createL_L_are_applicable_Administrator_icons_are_visible_and_Sorts_and_pagination_is_working(
			int arg1, int arg2) throws Exception {
		fhBasics = new FhBasics();
		assertTrue("FH banner was NOT found/FH was selected", fhBasics.isFHthereFHuser());
		assertTrue("FH count was NOT found/FH count not selected", fhBasics.isFhCountThere());
		fhBasics.intoFH();
		assertTrue("CreateDept was found/PMO was selected", fhBasics.PMOisthere());
		assertTrue("Organizations that I administer THERE", !fhBasics.IsDeptAdminSubTierAdmin());
		assertTrue("ICON that I administer NOT THERE", fhBasics.ADiconThere());
		((JavascriptExecutor) driver).executeScript("scroll(0,400)");
		assertTrue("ICON that I administer NOT THERE", fhBasics.ADiconThere());
		((JavascriptExecutor) driver).executeScript("scroll(0,500)");
		assertTrue("ICON that I administer NOT THERE", fhBasics.ADiconThere());
		((JavascriptExecutor) driver).executeScript("scroll(0,600)");
		assertTrue("ICON that I administer NOT THERE", fhBasics.ADiconThere());
		((JavascriptExecutor) driver).executeScript("scroll(0,900)");
		assertTrue("ICON that I administer NOT THERE", fhBasics.ADiconThere());
		fhBasics.IntoRandomDepPMOvalidation();
		assertTrue("Create Subtier Option not there", fhBasics.isCreateSubtierThere());
		fhBasics.IntoRandomSubtier();
		fhBasics.IntoItemsPerPage();
		assertTrue("items per page=10 not visible", fhBasics.IsIPPworking());
		assertTrue("items per page=25 not visible", fhBasics.IsIPPworking2());
		assertTrue("items per page=50 not visible", fhBasics.IsIPPworking3());
		fhBasics.IsIPPworking25();
		assertTrue("items per page=25 not working when picked", fhBasics.IsIPPworking25Validation());
		Thread.sleep(9000);
		fhBasics.intoSort();
		assertTrue("sorting tab isnt working-decending. Name z-a", fhBasics.isSortingWorking());
		fhBasics.intoSortBy();
		fhBasics.intoSortAgencyCode();
		assertTrue("sort by Ac not working", fhBasics.isSortByACWorking());
		fhBasics.intoRandomL2();
		assertTrue("Create office option not there", fhBasics.isCreateOfficeThere());
		fhBasics.intoRandomOffices();
		fhBasics.IntoItemsPerPage();
		assertTrue("items per page=10 not visible", fhBasics.IsIPPworking());
		assertTrue("items per page=25 not visible", fhBasics.IsIPPworking2());
		assertTrue("items per page=50 not visible", fhBasics.IsIPPworking3());
		fhBasics.IsIPPworking50();
		assertTrue("items per page=50 not working when picked", fhBasics.IsIPPworking50Validation());
		fhBasics.intoArAndomOffice();
		assertTrue("Create office option not there", fhBasics.IsEditOfficeTabThere());

	}
	@Then("^FH PMO validates all appropriate functions on their landing pages\\(FH link is visible,Create dep/createL(\\d+)/L(\\d+) are applicable\\. Administrator icons are visible and Sorts and pagination is working2\\)$")
	public void fh_PMO_validates_all_appropriate_functions_on_their_landing_pages_FH_link_is_visible_Create_dep_createL_L_are_applicable_Administrator_icons_are_visible_and_Sorts_and_pagination_is_working2(
			int arg1, int arg2) throws Exception {
		fhBasics = new FhBasics();
		assertTrue("FH banner was NOT found/FH was selected", fhBasics.isFHthereFHuser());
		assertTrue("FH count was NOT found/FH count not selected", fhBasics.isFhCountThere());
		fhBasics.intoFH();
		assertTrue("CreateDept was found/PMO was selected", fhBasics.PMOisthere());
		assertTrue("Organizations that I administer THERE", !fhBasics.IsDeptAdminSubTierAdmin());
		assertTrue("ICON that I administer NOT THERE", fhBasics.ADiconThere());
		((JavascriptExecutor) driver).executeScript("scroll(0,400)");
		assertTrue("ICON that I administer NOT THERE", fhBasics.ADiconThere());
		((JavascriptExecutor) driver).executeScript("scroll(0,500)");
		assertTrue("ICON that I administer NOT THERE", fhBasics.ADiconThere());
		((JavascriptExecutor) driver).executeScript("scroll(0,600)");
		assertTrue("ICON that I administer NOT THERE", fhBasics.ADiconThere());
		((JavascriptExecutor) driver).executeScript("scroll(0,900)");
		assertTrue("ICON that I administer NOT THERE", fhBasics.ADiconThere());
		fhBasics.SearchHHR();
		fhBasics.IntoHHR();
		assertTrue("Create Subtier Option not there", fhBasics.isCreateSubtierThere());
		fhBasics.intoFederalHierarchybreadcrumb();
		fhBasics.SearchGSAL2();
		fhBasics.InGSA2();
		assertTrue("Create office option not there", fhBasics.isCreateOfficeThere());
		fhBasics.intoFederalHierarchybreadcrumb();
	}

	@When("^a user whos domain is not FH logs in$")
	public void a_user_whos_domain_is_not_FH_logs_in() throws Exception {
		LoginGov = new loginGov();
		LoginGov.GeneralLogIn(prop.getProperty("DomainAdmin"), prop.getProperty("password"), "6BSLNLLRH7HLJFMM");

	}

	@Then("^this user will validate FH link is on workspace, and No Admin rights on fh$")
	public void this_user_will_validate_FH_link_is_on_workspace_and_No_Admin_rights_on_fh() throws Exception {
		fhBasics = new FhBasics();
		assertTrue("FH banner was found/FH was selected", fhBasics.isFHthereFHuser());
		assertTrue("FH count was found/FH count selected", !fhBasics.isFhCountThere());
		fhBasics.intoFHnonFHmember();
		assertTrue("Organizations that I administer is THERE", !fhBasics.IsDeptAdminSubTierAdmin());
		boolean change = fhBasics.NONfhUser();
		Assert.assertTrue(change);
		((JavascriptExecutor) driver).executeScript("scroll(0,400)");
		assertTrue("ICON that I administer is THERE", !fhBasics.ADiconThere());
		fhBasics.intoNEGArAndomOffice();
		assertTrue("Create office option there", !fhBasics.IsEditOfficeTabThere());

	}

	@When("^a dept Admin of FH logs in$")
	public void a_dept_Admin_of_FH_logs_in() throws Exception {
		LoginGov = new loginGov();
		LoginGov.GeneralLogIn(prop.getProperty("DeptAdmin"), prop.getProperty("password2"), "6AZXNJNTYMUVWFX6");
	}

	@Then("^dept admin will validate all appropriate functions on their landing pages\\(FH link is visible, createL(\\d+)/L(\\d+) are applicable\\. Administrator icons are visible and Sorts and pagination is working\\)$")
	public void dept_admin_will_validate_all_appropriate_functions_on_their_landing_pages_FH_link_is_visible_createL_L_are_applicable_Administrator_icons_are_visible_and_Sorts_and_pagination_is_working(int arg1, int arg2) throws Exception {
	
		fhBasics = new FhBasics();
		assertTrue("FH link was found/FH was selected", fhBasics.isFHthereFHuser());
		assertTrue("FH count was NOT found/FH count not selected", fhBasics.isFhCountThere());

		fhBasics.intoFH();
		
		assertTrue("Create Subtier Option is there", !fhBasics.isCreateSubtierThere());
		assertTrue("Organizations that I administer NOT THERE", fhBasics.IsDeptAdminSubTierAdmin());
		assertTrue("ICON that I administer NOT THERE", fhBasics.ADiconThere());
		((JavascriptExecutor) driver).executeScript("scroll(0,400)");
		assertTrue("ICON that I administer NOT THERE", fhBasics.ADiconThere());
		((JavascriptExecutor) driver).executeScript("scroll(0,500)");
		assertTrue("ICON that I administer NOT THERE", fhBasics.ADiconThere());
		((JavascriptExecutor) driver).executeScript("scroll(0,600)");
		assertTrue("ICON that I administer NOT THERE", fhBasics.ADiconThere());
		((JavascriptExecutor) driver).executeScript("scroll(0,900)");
		assertTrue("ICON that I administer NOT THERE", fhBasics.ADiconThere());
		fhBasics.intoGSAL2();
		assertTrue("Create office option not there", fhBasics.isCreateOfficeThere());
		assertTrue("Create Subtier Option is there", !fhBasics.isCreateSubtierThere());
		fhBasics.intoRandomOffices();
		fhBasics.IntoItemsPerPage();
		assertTrue("items per page=10 not visible", fhBasics.IsIPPworking());
		assertTrue("items per page=25 not visible", fhBasics.IsIPPworking2());
		assertTrue("items per page=50 not visible", fhBasics.IsIPPworking3());
		fhBasics.IsIPPworking25();
		assertTrue("items per page=25 not working when picked", fhBasics.IsIPPworking25Validation2());
		fhBasics.intoSort();
		assertTrue("sorting tab isnt working-decending. Name z-a", fhBasics.isSortingWorking2());
		fhBasics.intoSortBy();
		fhBasics.intoSortAAC();
		assertTrue("sort by Ac not working", fhBasics.isSortByACWorking2());
		fhBasics.intoRandomL3ForDEPTadmin();
		assertTrue("Edit office option not there", fhBasics.IsEditOfficeTabThere());
		fhBasics.intoFederalHierarchybreadcrumb();
		fhBasics.intoFASL2();
		assertTrue("Create office option not there", fhBasics.isCreateOfficeThere());
	}

	@When("^a subtier Admin of FH logs in$")
	public void a_subtier_Admin_of_FH_logs_in() throws Exception {
		LoginGov = new loginGov();
		LoginGov.GeneralLogIn(prop.getProperty("SubTierAdmin"), prop.getProperty("password"), "NYK55VEVXQ3FOZRC");
	}

	@Then("^subtier admin will validate all appropriate functions on their landing pages\\(FH link is visible, L(\\d+) are applicable\\. Administrator icons are visible and Sorts and pagination is working\\)$")
	public void subtier_admin_will_validate_all_appropriate_functions_on_their_landing_pages_FH_link_is_visible_L_are_applicable_Administrator_icons_are_visible_and_Sorts_and_pagination_is_working(
			int arg1) throws Exception {
		fhBasics = new FhBasics();
		assertTrue("FH link was found/FH was selected", fhBasics.isFHthereFHuser());
		assertTrue("FH count was NOT found/FH count not selected", fhBasics.isFhCountThere());

		fhBasics.intoFH();
		assertTrue("Organizations that I administer NOT THERE", fhBasics.IsDeptAdminSubTierAdmin());
		assertTrue("Create Subtier Option is there", !fhBasics.isCreateSubtierThere());
		((JavascriptExecutor) driver).executeScript("scroll(0,200)");
		assertTrue("Organizations that I administer NOT THERE", fhBasics.ADiconThere());
		((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
		fhBasics.IntoNextPage3();
		assertTrue("ICON that I administer is THERE", !fhBasics.ADiconThere());
		fhBasics.IntoNextPage1();
		fhBasics.intoGSAL2();
		assertTrue("Create office option not there", fhBasics.isCreateOfficeThere());
		assertTrue("Create Subtier Option is there", !fhBasics.isCreateSubtierThere());
		fhBasics.intoRandomOffices();
		fhBasics.IntoItemsPerPage();
		assertTrue("items per page=10 not visible", fhBasics.IsIPPworking());
		assertTrue("items per page=25 not visible", fhBasics.IsIPPworking2());
		assertTrue("items per page=50 not visible", fhBasics.IsIPPworking3());
		fhBasics.IsIPPworking25();
		assertTrue("items per page=25 not working when picked", fhBasics.IsIPPworking25Validation2());
		fhBasics.intoSort();
		assertTrue("sorting tab isnt working-decending. Name z-a", fhBasics.isSortingWorking2());
		fhBasics.intoSortBy();
		fhBasics.intoSortAAC();
		assertTrue("sort by Ac not working", fhBasics.isSortByACWorking2());
		fhBasics.intoRandomL3ForDEPTadmin();
		assertTrue("Edit office option not there", fhBasics.IsEditOfficeTabThere());
		fhBasics.intoFederalHierarchybreadcrumb();
		fhBasics.intoFASL2();
		assertTrue("Create office option is there", !fhBasics.isCreateOfficeThere());

	}

	@When("^a non fed user log in$")
	public void a_non_fed_user_log_in() throws Exception {
		LoginGov = new loginGov();
		LoginGov.GeneralLogIn(prop.getProperty("NonFedUser"), prop.getProperty("password2"), "3ZMD3LUKPE3KMBMW");
	}

	@Then("^this NonFed will validate FH link not on workspace, and No Admin rights on fh$")
	public void this_NonFed_will_validate_FH_link_not_on_workspace_and_No_Admin_rights_on_fh() throws Exception {
		fhBasics = new FhBasics();
		assertTrue("FH link was found/FH was selected", !fhBasics.isFHthereFHuser());
		assertTrue("FH link was found/FH was selected", !fhBasics.IsFhLinkThereNONfh());
		assertTrue("entity info was not found/FH was selected", fhBasics.IsEntityThere());
	}
	@Then("^a fed user with no roles signs and validates that FH widget is visible without full counts$")
	public void a_fed_user_with_no_roles_signs_and_validates_that_FH_widget_is_visible_without_full_counts() throws Exception {
		LoginGov = new loginGov();
		LoginGov.GeneralLogIn(prop.getProperty("NoRole123"), prop.getProperty("password2"), "YYC56B6I3QJMC5CH");
		fhBasics = new FhBasics();
		assertTrue("FH link was found/FH was selected",fhBasics.isFHthereFHuser());
		assertTrue("FH count was NOT found/FH count not selected", !fhBasics.isFhCountThere());
		fhBasics.intoFHnonFHmember();
		assertTrue("Organizations that I administer is THERE", !fhBasics.IsDeptAdminSubTierAdmin());
		boolean change = fhBasics.NONfhUser();
		Assert.assertTrue(change);
		((JavascriptExecutor) driver).executeScript("scroll(0,400)");
		assertTrue("ICON that I administer is THERE", !fhBasics.ADiconThere());
		fhBasics.intoNEGArAndomOffice();
		assertTrue("Create office option there", !fhBasics.IsEditOfficeTabThere());

	}

	@Then("^the user will validate departments are all in order$")
	public void the_user_will_validate_departments_are_all_in_order() throws Exception {
		fHorgPicker.EnterDept();
		// CHECK A-Z
		class EntryComp implements Comparator<String> {
			@Override
			public int compare(String e1, String e2) {
				return e1.split("-")[1].compareTo(e2.split("-")[1]);
			}
		}
		ArrayList<String> obtainedList = new ArrayList<>();
		List<WebElement> elementList = driver.findElements(By.xpath("//*[@id=\"dept-listbox\"]"));
		String[] readList = elementList.get(0).getText().split("\\n");
		for (int i = 0; i < readList.length; i += 2) {
			obtainedList.add(readList[i] + " " + readList[i + 1]);
		}
		ArrayList<String> sortedList = new ArrayList<>();
		for (String s : obtainedList) {
			sortedList.add(s);
		}
		Collections.sort(sortedList, new EntryComp());
		Assert.assertTrue(sortedList.equals(obtainedList));

		System.out.println("VALIDATION WORKIng");

		fHorgPicker.EnterDeptAsDOD();
		// validates that dept L1 is there on the top of the list.
		boolean ValidationForSearching1 = fHorgPicker.L1Validation();
		Assert.assertTrue(ValidationForSearching1);

		// check first data is l2 and then after a-z

		class EntryComp1 implements Comparator<String> {
			@Override
			public int compare(String e1, String e2) {
				System.out.println("comparing : e1:" + e1 + " e2:" + e2);
				return e1.compareTo(e2);
			}
		}

		ArrayList<String> obtainedList1 = new ArrayList<>();
		List<WebElement> elementList1 = driver.findElements(By.xpath("//div[@class=\"agency-table\"]"));
		String[] readList1 = elementList1.get(0).getText().split("\\n");
		for (int i = 0; i < readList1.length; i += 2) {
			obtainedList1.add(readList1[i] + " " + readList1[i + 1]);
		}

		obtainedList1.remove(0);
		obtainedList1.remove(0);
		ArrayList<String> sortedList1 = new ArrayList<>();
		for (String s : obtainedList1) {
			sortedList1.add(s);
		}
		assertEquals(sortedList1, obtainedList1);
		System.out.println("VALIDATION WORKIng after removal");

	}

	@Given("^a user goes to Org Picker endpoint$")
	public void a_user_goes_to_Org_Picker_endpoint() throws Exception {
		TestBase.Initial();
		fHorgPicker = new FHorgPicker();
		fHorgPicker.GoToOrgPickerRadio();
	}

	@Then("^the user will validate inactive departments are all in order$")
	public void the_user_will_validate_inactive_departments_are_all_in_order() throws Exception {
		fHorgPicker.EnterInactive();
		// check that all resuts after first has a *
		boolean ValidationForSearching6 = fHorgPicker.Inactive();
		Assert.assertTrue(ValidationForSearching6);
		fHorgPicker.EnterInactive();
		// this toggles off inactive
	}

	@Then("^the user will validate subtier are all in order$")
	public void the_user_will_validate_subtier_are_all_in_order() throws Exception {
		fHorgPicker.EnterSubtier();
		// check table is a-z

		class EntryComp11 implements Comparator<String> {
			@Override
			public int compare(String e1, String e2) {
				System.out.println("comparing : e1:" + e1 + " e2:" + e2);
				return e1.split("-")[1].compareTo(e2.split("-")[1]);
			}
		}

		ArrayList<String> obtainedList11 = new ArrayList<>();
		List<WebElement> elementList11 = driver.findElements(By.xpath("//*[@id=\"subtier-listbox\"]"));
		String[] readList11 = elementList11.get(0).getText().split("\\n");
		for (int i = 0; i < readList11.length; i += 2) {
			obtainedList11.add(readList11[i] + " " + readList11[i + 1]);
		}
		ArrayList<String> sortedList11 = new ArrayList<>();
		for (String s : obtainedList11) {
			sortedList11.add(s);
		}
		Collections.sort(sortedList11, new EntryComp11());
		Assert.assertTrue(sortedList11.equals(obtainedList11));
		System.out.println("VALIDATION WORKIng");
		fHorgPicker.ChooseArmy();
		// check that first data is l2 says subtier and the rest are a-z and NOT L2 or
		// l1 so does not say subtier or department
		boolean ValidationForSearching2 = fHorgPicker.L2Validation();
		Assert.assertTrue(ValidationForSearching2);
		boolean ValidationForSearching7 = fHorgPicker.negvalidationL2();
		Assert.assertTrue(ValidationForSearching7);
		class EntryComp111 implements Comparator<String> {
			@Override
			public int compare(String e1, String e2) {
				System.out.println("comparing : e1:" + e1 + " e2:" + e2);
				return e1.compareTo(e2);
			}
		}

		ArrayList<String> obtainedList111 = new ArrayList<>();
		List<WebElement> elementList111 = driver.findElements(By.xpath("//div[@class=\"agency-table\"]"));
		String[] readList111 = elementList111.get(0).getText().split("\\n");
		for (int i = 0; i < readList111.length; i += 2) {
			obtainedList111.add(readList111[i] + " " + readList111[i + 1]);
		}

		obtainedList111.remove(0);
		obtainedList111.remove(0);
		ArrayList<String> sortedList111 = new ArrayList<>();
		for (String s : obtainedList111) {
			sortedList111.add(s);
		}
		assertEquals(sortedList111, obtainedList111);
		System.out.println("VALIDATION WORKIng after removal");

	}

	@Then("^the user will validate major command are all in order$")
	public void the_user_will_validate_major_command_are_all_in_order() throws Exception {
		fHorgPicker.ChooseMC();
		// data should be a-z

		class EntryComp0 implements Comparator<String> {
			@Override
			public int compare(String e1, String e2) {
				return e1.split("-")[1].compareTo(e2.split("-")[1]);
			}
		}

		ArrayList<String> obtainedList0 = new ArrayList<>();
		List<WebElement> elementList0 = driver.findElements(By.xpath("//*[@id=\"major-listbox\"]"));
		String[] readList0 = elementList0.get(0).getText().split("\\n");
		for (int i = 0; i < readList0.length; i += 2) {
			obtainedList0.add(readList0[i] + " " + readList0[i + 1]);
		}

		ArrayList<String> sortedList0 = new ArrayList<>();
		for (String s : obtainedList0) {
			sortedList0.add(s);
		}
		// Collections.sort(sortedList0, new EntryComp0());
		Assert.assertTrue(sortedList0.equals(obtainedList0));
		System.out.println("VALIDATION WORKIng");

		fHorgPicker.ChooseMCFully();
		// check that first dat is the mc choosen and nothing else says amjor command,
		// subtier, department also all a-z
		boolean ValidationForSearching3 = fHorgPicker.MCValidation();
		Assert.assertTrue(ValidationForSearching3);
		boolean ValidationForSearching8 = fHorgPicker.negvalidationMC();
		Assert.assertTrue(ValidationForSearching8);
		class EntryComp11111 implements Comparator<String> {
			@Override
			public int compare(String e1, String e2) {
				System.out.println("comparing : e1:" + e1 + " e2:" + e2);
				return e1.compareTo(e2);
			}
		}

		ArrayList<String> obtainedList11111 = new ArrayList<>();
		List<WebElement> elementList11111 = driver.findElements(By.xpath("//div[@class=\"agency-table\"]"));
		String[] readList11111 = elementList11111.get(0).getText().split("\\n");
		for (int i = 0; i < readList11111.length; i += 2) {
			obtainedList11111.add(readList11111[i] + " " + readList11111[i + 1]);
		}

		obtainedList11111.remove(0);
		obtainedList11111.remove(0);
		ArrayList<String> sortedList11111 = new ArrayList<>();
		for (String s : obtainedList11111) {
			sortedList11111.add(s);
		}
		assertEquals(sortedList11111, obtainedList11111);
		System.out.println("VALIDATION WORKIng after removal");

	}

	@Then("^the user will validate sub-command are all in order$")
	public void the_user_will_validate_sub_command_are_all_in_order() throws Exception {
		fHorgPicker.ChooseSC();
		// data should be a-z
		class EntryComp5 implements Comparator<String> {
			@Override
			public int compare(String e1, String e2) {
				System.out.println("comparing : e1:" + e1 + " e2:" + e2);
				return e1.split("-")[1].compareTo(e2.split("-")[1]);
			}
		}

		ArrayList<String> obtainedList5 = new ArrayList<>();
		List<WebElement> elementList5 = driver.findElements(By.xpath("//*[@id=\"subcomm-listbox\"]"));
		String[] readList5 = elementList5.get(0).getText().split("\\n");
		for (int i = 0; i < readList5.length; i += 2) {
			obtainedList5.add(readList5[i] + " " + readList5[i + 1]);
		}
		ArrayList<String> sortedList5 = new ArrayList<>();
		for (String s : obtainedList5) {
			sortedList5.add(s);
		}
		Assert.assertTrue(sortedList5.equals(obtainedList5));
		System.out.println("VALIDATION WORKIng");
		fHorgPicker.ChooseSCFully();
		boolean ValidationForSearching4 = fHorgPicker.SCValidation();
		Assert.assertTrue(ValidationForSearching4);
		boolean ValidationForSearching9 = fHorgPicker.negvalidationSC();
		Assert.assertTrue(ValidationForSearching9);
		// check that first dat is the subcommand choosen and nothing else says sub
		// command, subtier, department also all a-z
		class EntryComp6 implements Comparator<String> {
			@Override
			public int compare(String e1, String e2) {
				System.out.println("comparing : e1:" + e1 + " e2:" + e2);
				return e1.compareTo(e2);
			}
		}

		ArrayList<String> obtainedList6 = new ArrayList<>();
		List<WebElement> elementList6 = driver.findElements(By.xpath("//div[@class=\"agency-table\"]"));
		String[] readList6 = elementList6.get(0).getText().split("\\n");
		for (int i = 0; i < readList6.length; i += 2) {
			obtainedList6.add(readList6[i] + " " + readList6[i + 1]);
		}

		obtainedList6.remove(0);
		obtainedList6.remove(0);
		ArrayList<String> sortedList6 = new ArrayList<>();
		for (String s : obtainedList6) {
			sortedList6.add(s);
		}
		assertEquals(sortedList6, obtainedList6);
		System.out.println("VALIDATION WORKIng after removal");

	}

	@Then("^the user will validate office are all in order$")
	public void the_user_will_validate_office_are_all_in_order() throws Exception {
		fHorgPicker.ChooseOffice();
		class EntryComp7 implements Comparator<String> {
			@Override
			public int compare(String e1, String e2) {
				return e1.split("-")[1].compareTo(e2.split("-")[1]);
			}
		}

		ArrayList<String> obtainedList7 = new ArrayList<>();
		List<WebElement> elementList7 = driver.findElements(By.xpath("//*[@id=\"office-listbox\"]"));
		String[] readList7 = elementList7.get(0).getText().split("\\n");
		for (int i = 0; i < readList7.length; i += 2) {
			obtainedList7.add(readList7[i] + " " + readList7[i + 1]);
		}
		ArrayList<String> sortedList7 = new ArrayList<>();
		for (String s : obtainedList7) {
			sortedList7.add(s);
		}
		// Collections.sort(sortedList7, new EntryComp7());
		Assert.assertTrue(sortedList7.equals(obtainedList7));
		System.out.println("VALIDATION WORKIng");

		fHorgPicker.ChooseOfficeFully();
		// check that first dat is the officce choosen and nothing else says sub
		// command, subtier, department also all a-z
		boolean ValidationForSearching5 = fHorgPicker.OfficeValidation();
		Assert.assertTrue(ValidationForSearching5);
		boolean ValidationForSearching10 = fHorgPicker.negvalidationSC();
		Assert.assertTrue(ValidationForSearching10);
		fHorgPicker.closePICKER();
	}

	@Given("^a contracting officer logs in within a L(\\d+)$")
	public void a_contracting_officer_logs_in_within_a_L(int arg1) throws Exception {
		LoginGov = new loginGov();
		LoginGov.GeneralLogIn(prop.getProperty("OrgpickerContrOfficer"), prop.getProperty("password2"),
				"CM47T7GD7J4K7CGK");
	}

	@When("^user creates a new Opportunity$")
	public void user_creates_a_new_Opportunity() throws Exception {
		fhOrgPickerValidation = new FhOrgPickerValidation();
		fhOrgPickerValidation.IntoOpp();
		fhOrgPickerValidation.IntoOppType();
	}

	@Then("^user can submit all appropiate details to create opportunity$")
	public void user_can_submit_all_appropiate_details_to_create_opportunity() throws Exception {
		fhOrgPickerValidation.OppGenerator();
		fhOrgPickerValidation.OppId();
		fhOrgPickerValidation.EnterDept();
		Thread.sleep(2000);
	}

	@Then("^the user search ORG through Org picker$")
	public void the_user_search_ORG_through_Org_picker() throws Exception {
		boolean ValidationForSearching1 = fhOrgPickerValidation.L1Validation();
		Assert.assertTrue(ValidationForSearching1);
		fhOrgPickerValidation.EnterDeptCHOICE();
		boolean ValidationForSearching2 = fhOrgPickerValidation.L1ValidationTable();
		Assert.assertTrue(ValidationForSearching2);

		class EntryComp1 implements Comparator<String> {
			@Override
			public int compare(String e1, String e2) {
				System.out.println("comparing : e1:" + e1 + " e2:" + e2);
				return e1.compareTo(e2);
			}
		}

		ArrayList<String> obtainedList1 = new ArrayList<>();
		List<WebElement> elementList1 = driver.findElements(By.xpath("//div[@class=\"agency-table\"]"));
		String[] readList1 = elementList1.get(0).getText().split("\\n");
		for (int i = 0; i < readList1.length; i += 2) {
			obtainedList1.add(readList1[i] + " " + readList1[i + 1]);
		}

		obtainedList1.remove(0);
		obtainedList1.remove(0);
		ArrayList<String> sortedList1 = new ArrayList<>();
		for (String s : obtainedList1) {
			sortedList1.add(s);
		}
		assertEquals(sortedList1, obtainedList1);
		System.out.println("VALIDATION WORKIng after removal");

		fhOrgPickerValidation.EnterSubtier();
		Thread.sleep(2000);
		boolean ValidationForSearching3 = fhOrgPickerValidation.L2Validation();
		Assert.assertTrue(ValidationForSearching3);
		fhOrgPickerValidation.ChooseL2();
		boolean ValidationForSearching4 = !fhOrgPickerValidation.L1ValidationTable();
		Assert.assertTrue(ValidationForSearching4);
		boolean ValidationForSearching5 = fhOrgPickerValidation.L2ValidationTable();
		Assert.assertTrue(ValidationForSearching5);
		boolean ValidationForSearching6 = !fhOrgPickerValidation.L2ValidationTable2();
		Assert.assertTrue(ValidationForSearching6);

		class EntryComp7 implements Comparator<String> {
			@Override
			public int compare(String e1, String e2) {
				System.out.println("comparing : e1:" + e1 + " e2:" + e2);
				return e1.compareTo(e2);
			}
		}

		ArrayList<String> obtainedList7 = new ArrayList<>();
		List<WebElement> elementList7 = driver.findElements(By.xpath("//div[@class=\"agency-table\"]"));
		String[] readList7 = elementList7.get(0).getText().split("\\n");
		for (int i = 0; i < readList7.length; i += 2) {
			obtainedList7.add(readList7[i] + " " + readList7[i + 1]);
		}

		obtainedList7.remove(0);
		obtainedList7.remove(0);
		ArrayList<String> sortedList7 = new ArrayList<>();
		for (String s : obtainedList7) {
			sortedList7.add(s);
		}
		assertEquals(sortedList7, obtainedList7);
		System.out.println("VALIDATION WORKIng after removal");

		fhOrgPickerValidation.ChooseOffice();
		class EntryComp9 implements Comparator<String> {
			@Override
			public int compare(String e1, String e2) {
				return e1.split("-")[1].compareTo(e2.split("-")[1]);
			}
		}

		ArrayList<String> obtainedList9 = new ArrayList<>();
		List<WebElement> elementList9 = driver.findElements(By.xpath("//*[@id=\"office-listbox\"]"));
		String[] readList9 = elementList9.get(0).getText().split("\\n");
		for (int i = 0; i < readList9.length; i += 2) {
			obtainedList9.add(readList9[i] + " " + readList9[i + 1]);
		}
		ArrayList<String> sortedList9 = new ArrayList<>();
		for (String s : obtainedList9) {
			sortedList9.add(s);
		}
		// Collections.sort(sortedList7, new EntryComp7());
		Assert.assertTrue(sortedList9.equals(obtainedList9));
		System.out.println("VALIDATION WORKIng");
		fhOrgPickerValidation.ChooseOfficeAs();
		boolean ValidationForSearching7 = !fhOrgPickerValidation.L2ValidationTable2();
		Assert.assertTrue(ValidationForSearching7);
		fhOrgPickerValidation.ChooseOfficeForSelection();
	}

	@Then("^User successfully submits opportunity and then deletes$")
	public void user_successfully_submits_opportunity_and_then_deletes() throws Exception {
		fhOrgPickerValidation.OpportunityDone();
		assertTrue("OPPortunity not successful", fhOrgPickerValidation.Successisthere());
		fhOrgPickerValidation.OpportunityDeleted();
		fhOrgPickerValidation.OpportunityDeletedok();
	}

	@When("^FH user goes into FH Homepage$")
	public void fh_user_goes_into_FH_Homepage() throws Exception {
		fhBasics = new FhBasics();
		fhBasics.intoFH();

	}

	@Then("^fh pmo creates Department$")
	public void fh_pmo_creates_Department() throws Exception {
		createEditDep = new CreateEditDep();
		createEditDep.intoCreateDeptAgency();
		createEditDep.CreateDept();
		assertTrue("NEW DEPARTMENT /AGENCY WASNT MADE", createEditDep.isSuccessBannerThere2());
	}

	@Then("^user edits Department right after creation$")
	public void user_edits_Department_right_after_creation() throws Exception {
		createEditDep.EditDepAgency();
		assertTrue("NEW DEPARTMENT /AGENCY WASNT MADE", createEditDep.isSuccessBannerThere());
	}

	@When("^Department Profile is created, user validation description option$")
	public void department_Profile_is_created_user_validation_description_option() throws Exception {
		createEditDep.ViewProfileDepAgency();
	}


	@Then("^User will do a section edit on each section for codes and header$")
	public void user_will_do_a_section_edit_on_each_section_for_codes_and_header() throws Exception {

		createEditDep.AddEndDate();
		assertTrue("NEW DEPARTMENT /AGENCY WASNT MADE", createEditDep.isSuccessBannerThere());

		createEditDep.EditCodes();
		assertTrue("NEW DEPARTMENT /AGENCY WASNT MADE", createEditDep.isSuccessBannerThere());
		createEditDep.ValidateEndDateEdit();
		assertTrue("End Date isnt there", !createEditDep.isEndDateThere());
		
	}

	@Then("^user Creates a blank Department leaving an error$")
	public void user_Creates_a_blank_Department_leaving_an_error() throws Exception {
		createEditDep = new CreateEditDep();
		createEditDep.negCreateDepAgency();
		boolean ValidationForNEG = createEditDep.NEGValidation1();
		Assert.assertTrue(ValidationForNEG);
	}

	@Then("^user Creates a Department with only a title leaving an error$")
	public void user_Creates_a_Department_with_only_a_title_leaving_an_error() throws Exception {
		createEditDep.negCreateDepAgency2();
		boolean ValidationForNEG = createEditDep.NEGValidationCgac();
		Assert.assertTrue(ValidationForNEG);
	}

	@Then("^user Creates a Department with only AC and CJAC leaving an error$")
	public void user_Creates_a_Department_with_only_CJAC_leaving_an_error() throws Exception {
		createEditDep.negCreateDepAgency3();
		boolean ValidationForNEG3 = createEditDep.NEGValidationTas();
		Assert.assertTrue(ValidationForNEG3);
	}

	@Then("^user Creates a Department with only a TAS leaving an error$")
	public void user_Creates_a_Department_with_only_a_TAS_leaving_an_error() throws Exception {
		createEditDep.negCreateDepAgency4();
		boolean ValidationForNEG4 = createEditDep.NEGValidationTas();
		Assert.assertTrue(ValidationForNEG4);
		createEditDep.negCreateDepAgency5();
		boolean ValidationForNEG5 = createEditDep.NegValidation2();
		Assert.assertTrue(ValidationForNEG5);
	}

@Then("^user Creates a Department validating start date$")
public void user_Creates_a_Department_validating_start_date() throws Exception {
	createEditDep.TestingStartDate1();
	assertTrue("Incorrect error message 1", createEditDep.StartDateValidation());
	createEditDep.TestingStartDate2();
	assertTrue("Incorrect error message 2", createEditDep.StartDateValidation2());
	createEditDep.TestingStartDate3();
	
}


@Then("^user Creates a Department validating end date$")
public void user_Creates_a_Department_validating_end_date() throws Exception {
	createEditDep.TestingEndDate1();
	assertTrue("Incorrect error message 1", createEditDep.EndDateValidation1());
	createEditDep.TestingEndDate2();

}

@Then("^user edits a Department validating start date$")
public void user_edits_a_Department_validating_start_date() throws Exception {
	createEditDep.TestingStartDate4();
	assertTrue("Incorrect error message 1", createEditDep.StartDateValidation3());
	createEditDep.TestingStartDate5();

}

@Then("^user edits a Department validating end date$")
public void user_edits_a_Department_validating_end_date() throws Exception {
	createEditDep.TestingEndDate4();
	assertTrue("Incorrect error message 1", createEditDep.EndDateValidation1());
	createEditDep.TestingEndDate5();
	assertTrue("NEW DEPARTMENT /AGENCY WASNT MADE", createEditDep.isSuccessBannerThere());
	createEditDep.TestingEndDate6();
	assertTrue("Incorrect error message 2", createEditDep.EndDateValidation2());
	createEditDep.TestingEndDate5();
	assertTrue("NEW DEPARTMENT /AGENCY WASNT MADE", createEditDep.isSuccessBannerThere());

	
}
@Then("^the user edits departments to add in a end date$")
public void the_user_edits_departments_to_add_in_a_end_date() throws Exception {
	createEditDep.intoDept1();
	createEditDep.TestingEndDate7();
	assertTrue("Incorrect error message 1", createEditDep.EndDateValidation3());
	createEditDep.TestingEndDate13();
	assertTrue("Incorrect error message 7", createEditDep.EndDateValidation9());
	createEditDep.intoDept2();
	createEditDep.TestingEndDate8();
	assertTrue("Incorrect error message 2", createEditDep.EndDateValidation4());
	createEditDep.intoDept3();
	createEditDep.TestingEndDate9();
	assertTrue("Incorrect error message 3", createEditDep.EndDateValidation5());
	createEditDep.intoDept4();
	createEditDep.TestingEndDate10();
	assertTrue("Incorrect error message 4", createEditDep.EndDateValidation6());
	createEditDep.intoDept5();
	createEditDep.TestingEndDate11();
	assertTrue("Incorrect error message 5", createEditDep.EndDateValidation7());
	createEditDep.intoDept6();
	createEditDep.TestingEndDate12();
	assertTrue("Incorrect error message 6", createEditDep.EndDateValidation8());
	
}

	@Then("^User Submits Department$")
	public void user_Submits_Department() throws Exception {
		createEditDep.negCreateDepAgency6();
	}

	@Then("^user edits a Department without a description leaving an error$")
	public void user_edits_a_Department_without_a_description_leaving_an_error() throws Exception {
		createEditDep.negCreateDepAgency7();
		boolean ValidationForNEG7 = createEditDep.NEGValidation3();
		Assert.assertTrue(ValidationForNEG7);
		createEditDep.negCreateDepAgency8();
		//boolean ValidationForNEG8 = createEditDep.NEGValidation4();
		//Assert.assertTrue(ValidationForNEG8);
	}

	@Then("^user cancels making a department$")
	public void user_cancels_making_a_department() throws Exception {
		createEditDep.negCreateDepAgency9();
		assertTrue("NEW DEPARTMENT /AGENCY isnt there", createEditDep.IsCreateSubtierThere());

	}

@Then("^FH user will create Subtier$")
public void fh_user_will_create_Subtier() throws Exception {
	createEditSubtier= new CreateEditSubtier();
	createEditSubtier.intoDept();
	createEditSubtier.CreateSubtier();
	createEditDep = new CreateEditDep();

}

@Then("^the user will edit the Subtier$")
public void the_user_will_edit_the_Subtier() throws Exception {
	Thread.sleep(8000);
	createEditSubtier.EditCodes();
}

@Then("^FH user will validate that the subtier has been created$")
public void fh_user_will_validate_that_the_subtier_has_been_created() throws Exception {
	//assertTrue("NEW Subtier WASNT MADE", createEditDep.isSuccessBannerThere2());
}
@Then("^FH user will validate that the subtier has been created after edit$")
public void fh_user_will_validate_that_the_subtier_has_been_created_after_edit() throws Exception {
	assertTrue("NEW Subtier WASNT MADE", createEditDep.isSuccessBannerThere());
}

@Then("^the user will edit and add an end date to the subtier$")
public void the_user_will_edit_and_add_an_end_date_to_the_subtier() throws Exception {
	createEditSubtier.BacktoFH();
	createEditSubtier.intoSubtier();
	createEditSubtier.AddEndDate();
}


@Then("^then the user will search the subtier and validate that its been end dated$")
public void then_the_user_will_search_the_subtier_and_validate_that_its_been_end_dated() throws Exception {
	createEditSubtier.ValidateEndDateEdit();
	assertTrue("End Date isnt there", !createEditDep.isEndDateThere());
	
}
@Then("^user attempts to submit a blank subtier$")
public void user_attempts_to_submit_a_blank_subtier() throws Exception {
	createEditSubtier= new CreateEditSubtier();
	createEditSubtier.intoDept();
	createEditSubtier.NEGCreateSubtier();
	
}

@Then("^user validates that error messages are given$")
public void user_validates_that_error_messages_are_given() throws Exception {
	boolean ValidationForNEG1 = createEditSubtier.NEGValidation1();
	Assert.assertTrue(ValidationForNEG1);
	createEditDep = new CreateEditDep();		
}

@When("^user enters some values blank for a subtier$")
public void user_enters_some_values_blank_for_a_subtier() throws Exception {
	createEditSubtier.NEGCreateSubtier2();
	boolean ValidationForNEG2 = createEditSubtier.NEGValidation2();
	Assert.assertTrue(ValidationForNEG2);
	createEditSubtier.NEGCreateSubtier6();
	boolean ValidationForNEG5 = createEditSubtier.NEGValidation8();
	Assert.assertTrue(ValidationForNEG5);
}

@Then("^the user validates the correct error messages$")
public void the_user_validates_the_correct_error_messages() throws Exception {
	createEditSubtier.NEGCreateSubtier3();
//	boolean ValidationForNEG3 = createEditSubtier.NEGValidation3();
	//Assert.assertTrue(ValidationForNEG3);
	createEditSubtier.NEGCreateSubtier7();
	boolean ValidationForNEG6 = createEditSubtier.NEGValidation7();
	Assert.assertTrue(ValidationForNEG6);
	
}

@Then("^user edits the subtier to enter blank values$")
public void user_edits_the_subtier_to_enter_blank_values() throws Exception {
createEditSubtier.NEGCreateSubtier4();
	createEditSubtier.NEGCreateSubtier5();
}
@Then("^user validates start and end date on subtier during creation$")
public void user_validates_start_and_end_date_on_subtier_during_creation() throws Exception {
	createEditSubtier.NEGCreateSubtier8();
	Assert.assertTrue("wRONG message 1", createEditSubtier.StartDate1());

	createEditSubtier.NEGCreateSubtier9();
	Assert.assertTrue("wRONG message 2", createEditSubtier.StartDate2());

	createEditSubtier.NEGCreateSubtier10();
	Assert.assertTrue("wRONG message 3", createEditSubtier.StartDate3());
	createEditSubtier.NEGCreateSubtier11();
	Assert.assertTrue("wRONG message 4", createEditSubtier.	EndDate1());
	createEditSubtier.NEGCreateSubtier12();
	Assert.assertTrue("wRONG message 5", createEditSubtier.EndDate3());
	createEditSubtier.NEGCreateSubtier13();
	Assert.assertTrue("wRONG message 6", createEditSubtier.EndDate3());
	createEditSubtier.NEGCreateSubtier14();
	Assert.assertTrue("wRONG message 7", createEditSubtier.StartDate4());
	createEditSubtier.NEGCreateSubtier15();
	Assert.assertTrue("wRONG message 8", createEditSubtier.EndDate4());
	createEditSubtier.NEGCreateSubtier16();
	Assert.assertTrue("wRONG message 9", createEditSubtier.EndDate5());
	createEditSubtier.NEGCreateSubtier17();
	Assert.assertTrue("wRONG message 10", createEditSubtier.EndDate6());
	createEditSubtier.NEGCreateSubtier18();
	Assert.assertTrue("wRONG message 11", createEditSubtier.EndDate7());


}

@Then("^user goes in FH Events page$")
public void user_goes_in_FH_Events_page() throws Exception {
	fhEventsPages=new FhEventsPages();
	
	fhEventsPages.intoStartedEvents();
	
	
}
@Then("^User validates that results shown on events page match the workspace$")
public void user_validates_that_results_shown_on_events_page_match_the_workspace() throws Exception {
	boolean OrgStartEventCountflag = fhEventsPages.isEventOrgCountThereStarted();
	Assert.assertTrue(OrgStartEventCountflag);
	
}


@Then("^the user whos domain is not FH should not have access to events$")
public void the_user_whos_domain_is_not_FH_should_not_have_access_to_events() throws Exception {
	((JavascriptExecutor) driver).executeScript("scroll(0,500)");
	fhEventsPages=new FhEventsPages();
	Assert.assertFalse("Events page is there", fhEventsPages.isEventsThere());
}


@Then("^the FH user runs filters on Events Page$")
public void the_FH_user_runs_filters_on_Events_Page() throws Exception {
	fhEventsPages.intoAndOutDept();
	boolean ValidationForEvents1 = fhEventsPages.isDepthere();
	Assert.assertTrue(ValidationForEvents1);

	fhEventsPages.intoAndOutDept();
	fhEventsPages.intoAndOutSubtier();
	boolean ValidationForEvents2 = fhEventsPages.isSubtierthere();
	Assert.assertTrue(ValidationForEvents2);
	fhEventsPages.intoAndOutSubtier();
	fhEventsPages.intoAndOutOffice();
	boolean ValidationForEvents3 = fhEventsPages.isOfficethere();
	Assert.assertTrue(ValidationForEvents3);
	fhEventsPages.intoAndOutOffice();
	fhEventsPages.intoAndOutOrgStarted();
	boolean OrgStartedflag = fhEventsPages.validateOrgStarted();
	Assert.assertTrue(OrgStartedflag);
	fhEventsPages.intoAndOutOrgExpired();
	boolean OrgExpiredflag = fhEventsPages.validateOrgExpired();
	Assert.assertTrue(OrgExpiredflag);
	

	
}
@When("^user should have events widget visible$")
public void user_should_have_events_widget_visible() throws Exception {
	fhEventsPages=new FhEventsPages();
	((JavascriptExecutor) driver).executeScript("scroll(0,800)");
	assertTrue("Events page isnt there", fhEventsPages.isEventsThere());
}

@When("^User goes back to workspace$")
public void user_goes_back_to_workspace() throws Exception {
	fhEventsPages.IntoWorkspace();
}


@Then("^the user will enter Event Expired Events Page$")
public void the_user_will_enter_Event_Expired_Events_Page() throws Exception {
	fhEventsPages.intoExpiredEvents();
	boolean OrgExpiredEventCountflag = fhEventsPages.isEventOrgCountThereExpired();
	Assert.assertTrue(OrgExpiredEventCountflag);
}
@When("^user clears all filters total count should be validated$")
public void user_clears_all_filters_total_count_should_be_validated() throws Exception {
	fhEventsPages.ClearEventsPage();
	boolean EventTotalCountflag = fhEventsPages.TotalAmountOfRecordsAFterCleared();
	Assert.assertFalse(EventTotalCountflag);
}
@Then("^user works with pagination$")
public void user_works_with_pagination() throws Exception {
	//((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
	fhEventsPages.checkpage();
	//TURN ON WHEN ITS FIXED
	boolean PaginationCheck= fhEventsPages.isPaginationWorking();
	Assert.assertTrue(PaginationCheck);
}
@Then("^fh pmo creates Department for events page check$")
public void fh_pmo_creates_Department_for_events_page_check() throws Exception {
	createEditDep = new CreateEditDep();
	createEditDep.intoCreateDeptAgency();
	createEditDep.CreateDeptForEvents();
	assertTrue("NEW DEPARTMENT /AGENCY WASNT MADE", createEditDep.isSuccessBannerThere2());
}


@Then("^user will validated that expired event count has gone up$")
public void user_will_validated_that_expired_event_count_has_gone_up() throws Exception {

	((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
	boolean AddedNewDepCount= fhEventsPages.isEventOrgCountThereExpiredGoneUp();
	//Assert.assertTrue(AddedNewDepCount);
}

@Then("^the user should be able to find the subtier to create an office$")
public void the_user_should_be_able_to_find_the_subtier_to_create_an_office() throws Exception {
	createOffice=new CreateOffice();
	createOffice.intoSubtier();
	assertTrue("Subtier NOT Found", createOffice.IsSubtierThere());
	createOffice.intoSubtier2();
	createOffice.CreateOfficeTab();
}


@Then("^the user will validate Aac requriments$")
public void the_user_will_validate_Aac_requriments() throws Exception {
	createOffice.TestingAac();
	assertTrue("Incorrect blank ERROR SHOWING", createOffice.BlankInputErrorMessageAac());
	createOffice.TestingAac2();
	assertTrue("Incorrect AAC ERROR SHOWING", createOffice.isAACworking());
	createOffice.TestingAac3();
	assertTrue("Incorrect AAC ERROR SHOWING", createOffice.isAACworking());
	createOffice.TestingAac4();
	assertTrue("Incorrect AAC ERROR SHOWING", createOffice.isAACworking());
	createOffice.TestingAac5();
	assertTrue("Incorrect AAC ERROR SHOWING", createOffice.isAACworking());
	createOffice.TestingAac6();
	assertTrue("Incorrect AAC ERROR SHOWING", createOffice.isAACworking());
	createOffice.TestingAac7();
	assertTrue("Incorrect AAC ERROR SHOWING", createOffice.isAACworking2());
	createOffice.TestingAac8();
	assertTrue("Incorrect AAC ERROR SHOWING", createOffice.isAACworking3());
	createOffice.TestingAac9();
	assertTrue("Office not made", createOffice.OfficeConfirmationPageValidation());
}
@Then("^the user will validate office name requriments$")
public void the_user_will_validate_office_name_requriments() throws Exception {
	createOffice.TestingName();
	assertTrue("Incorrect name ERROR SHOWING", createOffice.IsNameWorking());
	createOffice.TestingName2();
	assertTrue("Incorrect blank ERROR SHOWING", createOffice.BlankInputErrorMessageName());
	createOffice.TestingName3();
	assertTrue("Office not made", createOffice.OfficeConfirmationPageValidation());
}


@Then("^the user will validate start date requriments$")
public void the_user_will_validate_start_date_requriments() throws Exception {
	createOffice.TestingStartDate();
	//assertTrue("Incorrect blank ERROR SHOWING for start date", createOffice.StartDateValidation());
	createOffice.TestingStartDate2();
	assertTrue("Incorrect blank ERROR SHOWING for start date1", createOffice.StartDateValidation2());
		createOffice.TestingStartDate3();
		assertTrue("Incorrect blank ERROR SHOWING for start date2", createOffice.StartDateValidation3());
		createOffice.TestingStartDate4();
		assertTrue("Incorrect blank ERROR SHOWING for start date3", createOffice.StartDateValidation4());
		createOffice.TestingStartDate5();
		assertTrue("Incorrect blank ERROR SHOWING for start date4", createOffice.StartDateValidation5());
		
		
}


@Then("^the user should not be able to find the subtier to create an office$")
public void the_user_should_not_be_able_to_find_the_subtier_to_create_an_office() throws Exception {
	createOffice=new CreateOffice();
	createOffice.intoSubtier();
	assertTrue("Subtier NOT Found", !createOffice.IsSubtierThere());
}


@Then("^the user creates office with a positive flow$")
public void the_user_creates_office_with_a_positive_flow() throws Exception {
	createOffice.CreatePosFlow();
}

@Then("^the user will validate end date requriments$")
public void the_user_will_validate_end_date_requriments() throws Exception {
	createOffice.TestingEndDateCreationFlow();
	assertTrue("Incorrect error message", createOffice.EndDateValidation00());
	
}

@Then("^user will validate contract awards office type$")
public void user_will_validate_contract_awards_office_type() throws Exception {
	createOffice.OfficeTypes();
	assertTrue("Incorrect error message office type #1", createOffice.StartDateValidation());
	createOffice.TestingContractAwards();
	assertTrue("Incorrect error message office type #2", createOffice.EndDateValidation1());	
	createOffice.TestingContractAwards2();
	assertTrue("Incorrect error message office type #3", createOffice.EndDateValidation2());
	createOffice.TestingContractAwards3();
	assertTrue("Incorrect error message office type #4", createOffice.EndDateValidation3());
	createOffice.TestingContractAwards4();
	assertTrue("Incorrect error message office type #5", createOffice.EndDateValidation4());
	createOffice.TestingContractAwardsx();
	assertTrue("Office not made", createOffice.OfficeConfirmationPageValidation());
	
	createOffice.TestingContractAwards5();
	assertTrue("Incorrect error message office type #6", createOffice.EndDateValidation5());
	createOffice.TestingContractAwards6();
	assertTrue("Incorrect error message office type #7", createOffice.EndDateValidationSame());
	createOffice.TestingContractAwards7();
}


@Then("^user will validate financial assistance award office type$")
public void user_will_validate_financial_assistance_award_office_type() throws Exception {
	createOffice.TestingFinancialAssistanceAwards();
	assertTrue("Incorrect error message office type #7", createOffice.EndDateValidation1());
	createOffice.TestingFinancialAssistanceAwards2();
	assertTrue("Incorrect error message office type #8", createOffice.EndDateValidation2());
	createOffice.TestingFinancialAssistanceAwards3();
	assertTrue("Incorrect error message office type #9", createOffice.EndDateValidation3());
	createOffice.TestingFinancialAssistanceAwards4();
	assertTrue("Incorrect error message office type #10", createOffice.EndDateValidation4());
	createOffice.TestingFinancialAssistanceAwards5();
	assertTrue("Incorrect error message office type #11", createOffice.EndDateValidation5());
	createOffice.TestingFinancialAssistanceAwards6();
	assertTrue("Incorrect error message office type #7", createOffice.EndDateValidationSame());
	createOffice.TestingFinancialAssistanceAwards7();
}

@Then("^user will validate contract funding office type$")
public void user_will_validate_contract_funding_office_type() throws Exception {
	createOffice.TestingContractFunding();
	assertTrue("Incorrect error message office type #12", createOffice.EndDateValidation1());
	createOffice.TestingContractFunding2();
	assertTrue("Incorrect error message office type #13", createOffice.EndDateValidation2());
	createOffice.TestingContractFunding3();
	assertTrue("Incorrect error message office type #14", createOffice.EndDateValidation3());
	createOffice.TestingContractFunding4();
	assertTrue("Incorrect error message office type #15", createOffice.EndDateValidation4());
	createOffice.TestingContractFunding5();
	assertTrue("Incorrect error message office type #16", createOffice.EndDateValidation5());
	createOffice.TestingContractFunding6();
	assertTrue("Incorrect error message office type #16", createOffice.EndDateValidationSame());
	createOffice.TestingContractFunding7();
}

@Then("^user will validate financial assistance funding office type$")
public void user_will_validate_financial_assistance_funding_office_type() throws Exception {
	createOffice.TestingFinancialAssistanceFunding();
	assertTrue("Incorrect error message office type #17", createOffice.EndDateValidation1());
	createOffice.TestingFinancialAssistanceFunding2();
	assertTrue("Incorrect error message office type #18", createOffice.EndDateValidation2());
	createOffice.TestingFinancialAssistanceFunding3();
	assertTrue("Incorrect error message office type #19", createOffice.EndDateValidation3());
	createOffice.TestingFinancialAssistanceFunding4();
	assertTrue("Incorrect error message office type #20", createOffice.EndDateValidation4());
	createOffice.TestingFinancialAssistanceFunding5();
	assertTrue("Incorrect error message office type #21", createOffice.EndDateValidation5());
	createOffice.TestingFinancialAssistanceFunding6();
	assertTrue("Incorrect error message office type #7", createOffice.EndDateValidationSame());
	createOffice.TestingFinancialAssistanceFunding7();
}

@Then("^the user should be able to find an office to start an edit of a office which has a end date from creation$")
public void the_user_should_be_able_to_find_an_office_to_start_an_edit_of_a_office_which_has_a_end_date_from_creation() throws Exception {
  
	editOffice=new EditOffice();
	editOffice.intoOffice3();
	assertTrue("Incorrect error message office type #7", editOffice.OfficeSearch());

	editOffice.intoOffice4();
	
	
}


@Then("^the user will edit the office name$")
public void the_user_will_edit_the_office_name() throws Exception {
	editOffice.testingEditName();
	assertTrue("Incorrect error message office edit1", editOffice.NameValidation());

	editOffice.testingEditName2();
	assertTrue("Incorrect error message office edit2", editOffice.Confirm());

	editOffice.testingEditName3();
	assertTrue("Incorrect error message office edit3", editOffice.Confirm());

}
@Then("^user will validate office type validations match based on NOT having a office end date from creation$")
public void user_will_validate_office_type_validations_match_based_on_NOT_having_a_office_end_date_from_creation() throws Exception {
   
}

@Then("^the user will edit the office start date which has a end date from creation$")
public void the_user_will_edit_the_office_start_date_which_has_a_end_date_from_creation() throws Exception {
	editOffice.EditNameContinued();
	
	editOffice.TestingStartDate();
	assertTrue("Incorrect error message office edit1", editOffice.DateValidation());
	editOffice.TestingStartDate2();
	assertTrue("Incorrect error message office edit2", editOffice.StartDateValidation());
	editOffice.TestingStartDate3();
	assertTrue("Incorrect error message office edit2", editOffice.StartDateValidation());
	editOffice.TestingStartDate00();

	editOffice.TestingStartDate4();
	assertTrue("Incorrect error message office edit4", editOffice.StartDateValidation2());

	editOffice.TestingStartDate5();
	assertTrue("Incorrect error message office edit5", editOffice.StartDateValidation3());

	editOffice.TestingStartDate6();
	assertTrue("Incorrect error message office edit6", editOffice.StartDateValidation3());

	editOffice.TestingStartDate7();
	assertTrue("Incorrect error message office edit7", editOffice.Confirm());

	editOffice.TestingStartDate8();
	assertTrue("Incorrect error message office edit8", editOffice.StartDateValidation());

	editOffice.TestingStartDate9();
	assertTrue("Incorrect error message office edit9", editOffice.Confirm());

	
}

@Then("^the user will edit the office end date which has a end date from creation$")
public void the_user_will_edit_the_office_end_date_which_has_a_end_date_from_creation() throws Exception {
	editOffice.clearEndDate();
	assertTrue("Incorrect error message office edit1", editOffice.EndDate5());

	editOffice.TestingEndDate2();
	assertTrue("Incorrect error message office edit2", editOffice.EndDate2());

	editOffice.TestingEndDate3();
	assertTrue("Incorrect error message office edit3", editOffice.EndDate2());

	editOffice.TestingEndDate4();
	assertTrue("Incorrect error message office edit4", editOffice.EndDate3());

	editOffice.TestingEndDate5();
	assertTrue("Incorrect error message office edit5", editOffice.EndDate4());

	editOffice.TestingEndDate6();
	assertTrue("Incorrect error message office edit6", editOffice.Confirm());
	editOffice.TestingEndDate7();
	assertTrue("Incorrect error message office edit7", editOffice.EndDate5());
	editOffice.TestingEndDate8();
	assertTrue("Incorrect error message office edit8", editOffice.EndDate5());
	editOffice.TestingEndDate9();

	assertTrue("Incorrect error message office edit9", editOffice.Confirm());



}
@Then("^the user will edit the office end date which has a end date from creation on comp$")
public void the_user_will_edit_the_office_end_date_which_has_a_end_date_from_creation_on_comp() throws Exception {

	editOffice.clearEndDate();
	assertTrue("Incorrect error message office edit1", editOffice.EndDate5());

	editOffice.TestingEndDate2();
	assertTrue("Incorrect error message office edit2", editOffice.EndDate2());

	editOffice.TestingEndDate3();
	assertTrue("Incorrect error message office edit3", editOffice.EndDate2());

	editOffice.TestingEndDate4();
	assertTrue("Incorrect error message office edit4", editOffice.EndDate3());

	editOffice.TestingEndDate5();
	assertTrue("Incorrect error message office edit5", editOffice.EndDate4());

	editOffice.TestingEndDate6comp();
	assertTrue("Incorrect error message office edit6", editOffice.Confirm());
	editOffice.TestingEndDate7();
	assertTrue("Incorrect error message office edit7", editOffice.EndDate5());
	editOffice.TestingEndDate8();
	assertTrue("Incorrect error message office edit8", editOffice.EndDate5());
	editOffice.TestingEndDate9comp();

	assertTrue("Incorrect error message office edit9", editOffice.Confirm());



}

@Then("^the user should be able to find an office to start editing$")
public void the_user_should_be_able_to_find_an_office_to_start_editing() throws Exception {
	editOffice=new EditOffice();
	editOffice.intoOffice();
	assertTrue("Incorrect error message office edit1", editOffice.OfficeSearch());

	editOffice.intoOffice2();
	
}

@Then("^the user will edit the office start date which does not have a end date from creation$")
public void the_user_will_edit_the_office_start_date_which_does_not_have_a_end_date_from_creation() throws Exception {
	
	editOffice.TestingStartDate();
	assertTrue("Incorrect error message office type #1", editOffice.DateValidation());
	editOffice.TestingStartDate2();
	assertTrue("Incorrect error message office type #2", editOffice.StartDateValidation());
	editOffice.TestingStartDate3();
	assertTrue("Incorrect error message office type #3", editOffice.StartDateValidation());
	editOffice.TestingStartDate00();
	editOffice.TestingStartDate4();
	assertTrue("Incorrect error message office type #4", editOffice.StartDateValidation2());
	

	editOffice.TestingStartDate5();
	assertTrue("Incorrect error message office type #5", editOffice.StartDateValidation3());

	editOffice.TestingStartDate6();
	assertTrue("Incorrect error message office type #6", editOffice.StartDateValidation3());

	editOffice.TestingStartDate7();
	assertTrue("Incorrect error message office type #7", editOffice.Confirm());

	editOffice.TestingStartDate8();
	assertTrue("Incorrect error message office type #8", editOffice.StartDateValidation());

	editOffice.TestingStartDate9();
	assertTrue("Incorrect error message office type #9", editOffice.Confirm());
	editOffice.TestingStartDate10();
	assertTrue("Incorrect error message office type #10", editOffice.Confirm());

	
	
}

@Then("^the user will edit the office end date which does not have a end date from creation$")
public void the_user_will_edit_the_office_end_date_which_does_not_have_a_end_date_from_creation() throws Exception {
	editOffice.TestingEndDate();
	assertTrue("Incorrect error message office type #1", editOffice.EndDate());

	editOffice.TestingEndDate2();
	assertTrue("Incorrect error message office type #2", editOffice.EndDate2());

	editOffice.TestingEndDate3();
	assertTrue("Incorrect error message office type #3", editOffice.EndDate2());

	editOffice.TestingEndDate4();
	assertTrue("Incorrect error message office type #4", editOffice.EndDate3());

	editOffice.TestingEndDate5();
	assertTrue("Incorrect error message office type #5", editOffice.EndDate4());

	editOffice.TestingEndDate6();
	assertTrue("Incorrect error message office type #6", editOffice.Confirm());
	editOffice.TestingEndDate7();
	assertTrue("Incorrect error message office type #7", editOffice.EndDate());
	editOffice.TestingEndNew00();
	assertTrue("Incorrect error message office type #new1", editOffice.EndDateNewError());

	editOffice.TestingEndDateNew1();
	
	editOffice.TestingEndDateNew2();
	
	assertTrue("Incorrect error message office type #new2", editOffice.EndDateNewError2());

	editOffice.TestingEndDateNew3();
	
	assertTrue("Incorrect error message office type #new3", editOffice.EndDateNewError3());

	editOffice.EditOfficeTypesNew();
	assertTrue("Incorrect error message office type #new4", editOffice.NewEndDateError());
	editOffice.EditOfficeTypesNew2();
	assertTrue("Incorrect error message office type #new5", editOffice.NewEndDateError2());

	editOffice.EditOfficeTypesNew3();
	assertTrue("Incorrect error message office type #new4", editOffice.NewEndDateError());
	editOffice.EditOfficeTypesNew4();
	assertTrue("Incorrect error message office type #new5", editOffice.NewEndDateError2());


	editOffice.EditOfficeTypesNew5();
	assertTrue("Incorrect error message office type #new4", editOffice.NewEndDateError());
	editOffice.EditOfficeTypesNew6();
	assertTrue("Incorrect error message office type #new5", editOffice.NewEndDateError2());

	editOffice.EditOfficeTypesNew7();
	assertTrue("Incorrect error message office type #new4", editOffice.NewEndDateError());
	editOffice.EditOfficeTypesNew8();
	assertTrue("Incorrect error message office type #new5", editOffice.NewEndDateError2());

}
	@When("^user edits the contract awards office type for an office$")
	public void user_edits_the_contract_awards_office_type_for_an_office() throws Exception {
		createOffice=new CreateOffice();
		editOffice.EditOfficeTypes();
		
		assertTrue("Incorrect error message office type #2", createOffice.EndDateValidation1());	
		createOffice.TestingContractAwards2();
		assertTrue("Incorrect error message office type #3", editOffice.StartDateValidation1());
		createOffice.TestingContractAwards3();
		assertTrue("Incorrect error message office type #4", createOffice.EndDateValidation3());
		createOffice.TestingContractAwards4();
		assertTrue("Incorrect error message office type #5", createOffice.EndDateValidation4());
		editOffice.EditOfficeTypes2();
		assertTrue("Incorrect error message office type #6", editOffice.Confirm());
		editOffice.EditOfficeTypes3();
		assertTrue("Incorrect error message office type #2", createOffice.EndDateValidation1());	
		editOffice.EditOfficeTypes4();
		assertTrue("Incorrect error message office type #1", editOffice.DateValidation2());
		editOffice.EditOfficeTypes5();
		assertTrue("Incorrect error message office type #6", editOffice.Confirm());
		editOffice.EditOfficeTypes6();
		assertTrue("Incorrect error message office type #5", createOffice.EndDateValidation6());

		editOffice.EditOfficeTypes7();
		assertTrue("Incorrect error message office type #5", createOffice.EndDateValidation6());

		editOffice.EditOfficeTypes8();
		assertTrue("Incorrect error message office type #3", editOffice.EndDateValidation2());


		editOffice.EditOfficeTypes9();
		assertTrue("Incorrect error message office type #3", editOffice.EndDateValidation3());


		editOffice.EditOfficeTypes10();
		assertTrue("Incorrect error message office type #3", editOffice.DateError());
		editOffice.EditOfficeTypes11();
		assertTrue("Incorrect error message office type #6", editOffice.Confirm());




		
	}


	@When("^user edits the financial assistance awards office type for an office$")
	public void user_edits_the_financial_assistance_awards_office_type_for_an_office() throws Exception {
		editOffice.EditOfficeTypes12();
		
		assertTrue("Incorrect error message office type #2", createOffice.EndDateValidation1());	
		createOffice.TestingFinancialAssistanceAwards2();
		assertTrue("Incorrect error message office type #3", editOffice.StartDateValidation1());
		createOffice.TestingFinancialAssistanceAwards3();
		assertTrue("Incorrect error message office type #4", createOffice.EndDateValidation3());
		createOffice.TestingFinancialAssistanceAwards4();
		assertTrue("Incorrect error message office type #5", createOffice.EndDateValidation4());
		editOffice.EditOfficeTypes13();
		assertTrue("Incorrect error message office type #6", editOffice.Confirm());
		editOffice.EditOfficeTypes14();
		assertTrue("Incorrect error message office type #2", createOffice.EndDateValidation1());	
		editOffice.EditOfficeTypes15();
		assertTrue("Incorrect error message office type #1", editOffice.DateValidation2());
		editOffice.EditOfficeTypes16();
		assertTrue("Incorrect error message office type #6", editOffice.Confirm());
		editOffice.EditOfficeTypes17();
		assertTrue("Incorrect error message office type #5", createOffice.EndDateValidation6());

		editOffice.EditOfficeTypes18();
		assertTrue("Incorrect error message office type #5", createOffice.EndDateValidation6());

		editOffice.EditOfficeTypes19();
		assertTrue("Incorrect error message office type #3", editOffice.EndDateValidation2());


		editOffice.EditOfficeTypes20();
		assertTrue("Incorrect error message office type #3", editOffice.EndDateValidation3());


		editOffice.EditOfficeTypes21();
		assertTrue("Incorrect error message office type #3", editOffice.DateError());
		editOffice.EditOfficeTypes22();
		assertTrue("Incorrect error message office type #6", editOffice.Confirm());


	}

	@When("^user edits the contract funding office type for an office$")
	public void user_edits_the_contract_funding_office_type_for_an_office() throws Exception {
		editOffice.EditOfficeTypes23();
		
		assertTrue("Incorrect error message office type #2", createOffice.EndDateValidation1());	
		createOffice.TestingContractFunding2();
		assertTrue("Incorrect error message office type #3", editOffice.StartDateValidation1());
		createOffice.TestingContractFunding3();
		assertTrue("Incorrect error message office type #4", createOffice.EndDateValidation3());
		createOffice.TestingContractFunding4();
		assertTrue("Incorrect error message office type #5", createOffice.EndDateValidation4());
		editOffice.EditOfficeTypes24();
		assertTrue("Incorrect error message office type #6", editOffice.Confirm());
		editOffice.EditOfficeTypes25();
		assertTrue("Incorrect error message office type #2", createOffice.EndDateValidation1());
		editOffice.EditOfficeTypes26();
		assertTrue("Incorrect error message office type #1", editOffice.DateValidation2());
		editOffice.EditOfficeTypes27();
		assertTrue("Incorrect error message office type #6", editOffice.Confirm());
		editOffice.EditOfficeTypes28();
		assertTrue("Incorrect error message office type #5", createOffice.EndDateValidation6());

		editOffice.EditOfficeTypes29();
		assertTrue("Incorrect error message office type #5", createOffice.EndDateValidation6());

		editOffice.EditOfficeTypes30();
		assertTrue("Incorrect error message office type #3", editOffice.EndDateValidation2());

		editOffice.EditOfficeTypes31();
		assertTrue("Incorrect error message office type #3", editOffice.EndDateValidation3());

		editOffice.EditOfficeTypes32();
		assertTrue("Incorrect error message office type #3", editOffice.DateError());
		editOffice.EditOfficeTypes33();
		assertTrue("Incorrect error message office type #6", editOffice.Confirm());

	}

	@When("^user edits the financial assistance funding office type for an office$")
	public void user_edits_the_financial_assistance_funding_office_type_for_an_office() throws Exception {
		editOffice.EditOfficeTypes34();

		assertTrue("Incorrect error message office type #2", createOffice.EndDateValidation1());
		createOffice.TestingFinancialAssistanceFunding2();
		assertTrue("Incorrect error message office type #3", editOffice.StartDateValidation1());

		createOffice.TestingFinancialAssistanceFunding3();
		assertTrue("Incorrect error message office type #4", createOffice.EndDateValidation3());
		createOffice.TestingFinancialAssistanceFunding4();
		assertTrue("Incorrect error message office type #5", createOffice.EndDateValidation4());
		editOffice.EditOfficeTypes35();
		assertTrue("Incorrect error message office type #6", editOffice.Confirm());
		editOffice.EditOfficeTypes36();
		assertTrue("Incorrect error message office type #2", createOffice.EndDateValidation1());
		editOffice.EditOfficeTypes37();
		assertTrue("Incorrect error message office type #1", editOffice.DateValidation2());
		editOffice.EditOfficeTypes38();
		assertTrue("Incorrect error message office type #6", editOffice.Confirm());
		editOffice.EditOfficeTypes39();
		assertTrue("Incorrect error message office type #5", createOffice.EndDateValidation6());

		editOffice.EditOfficeTypes40();
		assertTrue("Incorrect error message office type #5", createOffice.EndDateValidation6());

		editOffice.EditOfficeTypes41();
		assertTrue("Incorrect error message office type #3", editOffice.EndDateValidation2());

		editOffice.EditOfficeTypes42();
		assertTrue("Incorrect error message office type #3", editOffice.EndDateValidation3());

		editOffice.EditOfficeTypes43();
		assertTrue("Incorrect error message office type #3", editOffice.DateError());
		editOffice.EditOfficeTypes44();
		assertTrue("Incorrect error message office type #6", editOffice.Confirm());

	}

	@Then("^user will validate office type validations match based on having a office end date from creation$")
	public void user_will_validate_office_type_validations_match_based_on_having_a_office_end_date_from_creation()
			throws Exception {

	}

	@When("^user adds in the office types for an office$")
	public void user_adds_in_the_office_types() throws Exception {
		createOffice = new CreateOffice();
		editOffice.extra2();

		assertTrue("Incorrect error message office type #2", createOffice.EndDateValidation1());
		createOffice.TestingContractAwards2();
		// THIS SHOULD NOT HAPPEN, LOGIC HAS TO BE WRITTEN
		assertTrue("Incorrect error message office type #6", editOffice.Confirm());
		editOffice.extra();

		createOffice.TestingContractAwards3();
		assertTrue("Incorrect error message office type #4", createOffice.EndDateValidation3());
		createOffice.TestingContractAwards4();
		assertTrue("Incorrect error message office type #5", createOffice.EndDateValidation4());
		editOffice.EditOfficeTypes2();
		assertTrue("Incorrect error message office type #6", editOffice.Confirm());
		editOffice.EditOfficeTypes3();
		assertTrue("Incorrect error message office type #2", createOffice.EndDateValidation1());
		editOffice.EditOfficeTypes4();
		assertTrue("Incorrect error message office type #1", editOffice.DateValidation());
		editOffice.EditOfficeTypes5();
		assertTrue("Incorrect error message office type #6", editOffice.Confirm());
		editOffice.EditOfficeTypes6();
		assertTrue("Incorrect error message office type #5", createOffice.EndDateValidation6());

		editOffice.EditOfficeTypes7();
		assertTrue("Incorrect error message office type #5", createOffice.EndDateValidation6());

		editOffice.EditOfficeTypes8();
		// THIS SHOULD NOT HAPPEN, LOGIC HAS TO BE WRITTEN
		assertTrue("Incorrect error message office type #6", editOffice.Confirm());

		editOffice.extra();

		editOffice.EditOfficeTypes9();
		// THIS SHOULD NOT HAPPEN, LOGIC HAS TO BE WRITTEN
		assertTrue("Incorrect error message office type #6", editOffice.Confirm());

		editOffice.extra();

		editOffice.EditOfficeTypes10();
		assertTrue("Incorrect error message office type #3", editOffice.DateError());
		editOffice.EditOfficeTypes11();
		assertTrue("Incorrect error message office type #6", editOffice.Confirm());

	}

	@Then("^the user adds in contracting awards office type and does validations$")
	public void the_user_adds_in_contracting_awards_office_type_and_does_validations() throws Exception {
		createOffice = new CreateOffice();
		editOffice.extra2();

		assertTrue("Incorrect error message office type #2", createOffice.EndDateValidation1());
		createOffice.TestingContractAwards2();
		// THIS SHOULD NOT HAPPEN, LOGIC HAS TO BE WRITTEN
		assertTrue("Incorrect error message office type #6", editOffice.Confirm());
		editOffice.extra();

		createOffice.TestingContractAwards3();
		assertTrue("Incorrect error message office type #4", createOffice.EndDateValidation3());
		createOffice.TestingContractAwards4();
		assertTrue("Incorrect error message office type #5", createOffice.EndDateValidation4());
		editOffice.EditOfficeTypes2();
		assertTrue("Incorrect error message office type #6", editOffice.Confirm());
		editOffice.EditOfficeTypes3();
		assertTrue("Incorrect error message office type #2", createOffice.EndDateValidation1());
		editOffice.EditOfficeTypes4();
		assertTrue("Incorrect error message office type #1", editOffice.DateValidation2());
		editOffice.EditOfficeTypes5();
		assertTrue("Incorrect error message office type #6", editOffice.Confirm());
		editOffice.EditOfficeTypes6();
		assertTrue("Incorrect error message office type #5", createOffice.EndDateValidation6());

		editOffice.EditOfficeTypes7();
		assertTrue("Incorrect error message office type #5", createOffice.EndDateValidation6());

		editOffice.EditOfficeTypes8();
		// THIS SHOULD NOT HAPPEN, LOGIC HAS TO BE WRITTEN
		
		assertTrue("Incorrect error message office type #7", editOffice.NewEndDateError3());

	//	editOffice.extra();

		editOffice.EditOfficeTypes9();
		// THIS SHOULD NOT HAPPEN, LOGIC HAS TO BE WRITTEN
		assertTrue("Incorrect error message office type #6", editOffice.Confirm());

		editOffice.extra();

		editOffice.EditOfficeTypes10();
		assertTrue("Incorrect error message office type #3", editOffice.DateError());
		editOffice.EditOfficeTypes11();
		assertTrue("Incorrect error message office type #6", editOffice.Confirm());

	}

	@Then("^the user adds in financial assistance awards office type and does validations$")
	public void the_user_adds_in_financial_assistance_awards_office_type_and_does_validations() throws Exception {		
		editOffice.extra3();
		
		assertTrue("Incorrect error message office type #2", createOffice.EndDateValidation1());	
		createOffice.TestingFinancialAssistanceAwards2();
		// THIS SHOULD NOT HAPPEN, LOGIC HAS TO BE WRITTEN
		assertTrue("Incorrect error message office type #6", editOffice.Confirm());
		editOffice.extra();
		createOffice.TestingFinancialAssistanceAwards3();
		assertTrue("Incorrect error message office type #4", createOffice.EndDateValidation3());
		createOffice.TestingFinancialAssistanceAwards4();
		assertTrue("Incorrect error message office type #5", createOffice.EndDateValidation4());
		editOffice.EditOfficeTypes13();
		assertTrue("Incorrect error message office type #6", editOffice.Confirm());
		editOffice.EditOfficeTypes14();
		assertTrue("Incorrect error message office type #2", createOffice.EndDateValidation1());	
		editOffice.EditOfficeTypes15();
		assertTrue("Incorrect error message office type #1", editOffice.DateValidation2());
		editOffice.EditOfficeTypes16();
		assertTrue("Incorrect error message office type #6", editOffice.Confirm());
		editOffice.EditOfficeTypes17();
		assertTrue("Incorrect error message office type #5", createOffice.EndDateValidation6());

		editOffice.EditOfficeTypes18();
		assertTrue("Incorrect error message office type #5", createOffice.EndDateValidation6());

		editOffice.EditOfficeTypes19();
		// THIS SHOULD NOT HAPPEN, LOGIC HAS TO BE WRITTEN
		assertTrue("Incorrect error message office type #7", editOffice.NewEndDateError3());

	//	editOffice.extra();
		editOffice.EditOfficeTypes20();
		// THIS SHOULD NOT HAPPEN, LOGIC HAS TO BE WRITTEN
		assertTrue("Incorrect error message office type #6", editOffice.Confirm());

		editOffice.extra();
		editOffice.EditOfficeTypes21();
		assertTrue("Incorrect error message office type #3", editOffice.DateError());
		editOffice.EditOfficeTypes22();
		assertTrue("Incorrect error message office type #6", editOffice.Confirm());

	}

	@Then("^the user adds in contract funding office type and does validations$")
	public void the_user_adds_in_contract_funding_office_type_and_does_validations() throws Exception {
		editOffice.extra4();

		assertTrue("Incorrect error message office type #2", createOffice.EndDateValidation1());
		createOffice.TestingContractFunding2();
		// THIS SHOULD NOT HAPPEN, LOGIC HAS TO BE WRITTEN
		assertTrue("Incorrect error message office type #6", editOffice.Confirm());
		editOffice.extra();
		createOffice.TestingContractFunding3();
		assertTrue("Incorrect error message office type #4", createOffice.EndDateValidation3());
		createOffice.TestingContractFunding4();
		assertTrue("Incorrect error message office type #5", createOffice.EndDateValidation4());
		editOffice.EditOfficeTypes24();
		assertTrue("Incorrect error message office type #6", editOffice.Confirm());
		editOffice.EditOfficeTypes25();
		assertTrue("Incorrect error message office type #2", createOffice.EndDateValidation1());
		editOffice.EditOfficeTypes26();
		assertTrue("Incorrect error message office type #1", editOffice.DateValidation2());
		editOffice.EditOfficeTypes27();
		assertTrue("Incorrect error message office type #6", editOffice.Confirm());
		editOffice.EditOfficeTypes28();
		assertTrue("Incorrect error message office type #5", createOffice.EndDateValidation6());

		editOffice.EditOfficeTypes29();
		assertTrue("Incorrect error message office type #5", createOffice.EndDateValidation6());

		editOffice.EditOfficeTypes30();
		// THIS SHOULD NOT HAPPEN, LOGIC HAS TO BE WRITTEN
		
		assertTrue("Incorrect error message office type #7", editOffice.NewEndDateError3());

		//editOffice.extra();

		editOffice.EditOfficeTypes31();
		// THIS SHOULD NOT HAPPEN, LOGIC HAS TO BE WRITTEN
		assertTrue("Incorrect error message office type #6", editOffice.Confirm());

		editOffice.extra();

		editOffice.EditOfficeTypes32();
		assertTrue("Incorrect error message office type #3", editOffice.DateError());
		editOffice.EditOfficeTypes33();
		assertTrue("Incorrect error message office type #6", editOffice.Confirm());

	}

	@Then("^the user adds in financial assistance funding office type and does validations$")
	public void the_user_adds_in_financial_assistance_funding_office_type_and_does_validations() throws Exception {
		editOffice.extra5();

		assertTrue("Incorrect error message office type #2", createOffice.EndDateValidation1());
		createOffice.TestingFinancialAssistanceFunding2();
		// THIS SHOULD NOT HAPPEN, LOGIC HAS TO BE WRITTEN
		assertTrue("Incorrect error message office type #6", editOffice.Confirm());
		editOffice.extra();
		createOffice.TestingFinancialAssistanceFunding3();
		assertTrue("Incorrect error message office type #4", createOffice.EndDateValidation3());
		createOffice.TestingFinancialAssistanceFunding4();
		assertTrue("Incorrect error message office type #5", createOffice.EndDateValidation4());
		editOffice.EditOfficeTypes35();
		assertTrue("Incorrect error message office type #6", editOffice.Confirm());
		editOffice.EditOfficeTypes36();
		assertTrue("Incorrect error message office type #2", createOffice.EndDateValidation1());
		editOffice.EditOfficeTypes37();
		assertTrue("Incorrect error message office type #1", editOffice.DateValidation2());
		editOffice.EditOfficeTypes38();
		assertTrue("Incorrect error message office type #6", editOffice.Confirm());
		editOffice.EditOfficeTypes39();
		assertTrue("Incorrect error message office type #5", createOffice.EndDateValidation6());

		editOffice.EditOfficeTypes40();
		assertTrue("Incorrect error message office type #5", createOffice.EndDateValidation6());

		editOffice.EditOfficeTypes41();
		// THIS SHOULD NOT HAPPEN, LOGIC HAS TO BE WRITTEN
	
		assertTrue("Incorrect error message office type #7", editOffice.NewEndDateError3());

		//	editOffice.extra();
		editOffice.EditOfficeTypes42();
		// THIS SHOULD NOT HAPPEN, LOGIC HAS TO BE WRITTEN
		assertTrue("Incorrect error message office type #6", editOffice.Confirm());
		editOffice.extra();
		editOffice.EditOfficeTypes43();
		assertTrue("Incorrect error message office type #3", editOffice.DateError());
		editOffice.EditOfficeTypes44();
		assertTrue("Incorrect error message office type #6", editOffice.Confirm());
	}


@When("^user searches for a department with inactive offices$")
public void user_searches_for_a_department_with_inactive_offices() throws Exception {
	fhBasics = new FhBasics();
	fhBasics.SearchLegislativeBranch();
   assertTrue("department results are not there", fhBasics.LegislativeDataThere());
   
}


@Then("^user edits the TAS code$")
public void user_edits_the_TAS_code() throws Exception {
	editOffice=new EditOffice();
	editOffice.intoLegislativeDep();
	editOffice.EditTas();
	createEditDep=new CreateEditDep();
	assertTrue("dep was edited", createEditDep.isSuccessBannerThere());

}

@Then("^user edits a inactive office to active$")
public void user_edits_a_inactive_office_to_active() throws Exception {
	Thread.sleep(3000);

	fhBasics.intoFederalHierarchybreadcrumb();

	fhBasics.SearchPOLICEPROCUREMENT();
	   assertTrue("office results are not there", fhBasics.POLICEPROCUREMENTDataThere());
		editOffice.intoInactiveOffice();
		

}

@Then("^user receives TAS error message on office edit$")
public void user_receives_TAS_error_message_on_office_edit() throws Exception {
	assertTrue("Incorrect error message TAS Neg", editOffice.TASValidation());
	editOffice.intoLegislativeDep();
	editOffice.EditTas2();
	assertTrue("dep was edited", createEditDep.isSuccessBannerThere());


}

@When("^user searches for a department with active offices$")
public void user_searches_for_a_department_with_active_offices() throws Exception {
	fhBasics.intoFederalHierarchybreadcrumb();
	fhBasics.SearchAction();
	   assertTrue("dep results are not there", fhBasics.ActionDataThere());
	   editOffice.intoActionDep();


}

@Then("^user receives TAS error message on department profile page$")
public void user_receives_TAS_error_message_on_department_profile_page() throws Exception {
	editOffice.EditTas();
	assertTrue("Incorrect error message TAS NEG", editOffice.TASValidation2());
	editOffice.EditTas3();
	assertTrue("dep was edited", createEditDep.isSuccessBannerThere());

////
		
//

			
}

@When("^a user searches a department with no tas code$")
public void a_user_searches_a_department_with_no_tas_code() throws Exception {
	fhBasics.intoFederalHierarchybreadcrumb();
	fhBasics.SearchUS();
	   assertTrue("dep results are not there", fhBasics.USDataThere());
	   editOffice.intoUSDep();
	   Thread.sleep(3000);
		editOffice.EditTas();
	
		//editOffice.EditTas();
		//assertTrue("dep was edited", createEditDep.isSuccessBannerThere());
}


@Then("^user receives correct error message when putting a invalid tas code outside aac$")
public void user_receives_correct_error_message_when_putting_a_invalid_tas_code_outside_aac() throws Exception {
	assertTrue("Incorrect error message TAS NEG", editOffice.TASValidation2());
	fhBasics.intoFederalHierarchybreadcrumb();
	
	
}

@Then("^user searches a department without offices then there is no validation for the TAS (\\d+) code update$")
public void user_searches_a_department_without_offices_then_there_is_no_validation_for_the_TAS_code_update(int arg1) throws Exception {
	fhBasics.SearchDEPT26();
	   assertTrue("dep results are not there", fhBasics.DEPT26There());

	   editOffice.intoDEP26Dep();
		editOffice.EditTas();
		assertTrue("dep was edited", createEditDep.isSuccessBannerThere());

		editOffice.EditTas2();
		assertTrue("dep was edited", createEditDep.isSuccessBannerThere());

}

@Then("^Once a TAS code is updated a user tries to create an office underneath it, make sure that the AAC gets validated against the newly added TAS Code$")
public void once_a_TAS_code_is_updated_a_user_tries_to_create_an_office_underneath_it_make_sure_that_the_AAC_gets_validated_against_the_newly_added_TAS_Code() throws Exception {
	editOffice.OfficeTasValidation();
	assertTrue("Incorrect error message TAS NEG", editOffice.TASValidation3());
	editOffice.OfficeTasValidation2();

	assertTrue("Incorrect error message office type", editOffice.Confirm2());

	fhBasics.intoFederalHierarchybreadcrumb();
	fhBasics.SearchDEPT26();
	   assertTrue("dep results are not there", fhBasics.DEPT26There());

	   editOffice.intoDEP26Dep();
		
}

@When("^user runs negative scenarios for region code$")
public void user_runs_negative_scenarios_for_region_code() throws Exception {
	editOffice.EditRegionCodeNeg();
	assertTrue("Incorrect error message office region", editOffice.Confirm());
	editOffice.EditRegionCodeNeg2();
	assertTrue("Incorrect error message office region", editOffice.Confirm());

}

@When("^user runs positive scenarios for region code$")
public void user_runs_positive_scenarios_for_region_code() throws Exception {
	editOffice.EditRegionCodePos();
	assertTrue("Incorrect error message office region", editOffice.Confirm());

	editOffice.EditRegionCodePos2();
	assertTrue("Incorrect error message office region", editOffice.Confirm());


	editOffice.EditRegionCodePos3();
	assertTrue("Incorrect error message office region", editOffice.Confirm());


	editOffice.EditRegionCodePos4();
	assertTrue("Incorrect error message office region", editOffice.Confirm());

	editOffice.EditRegionCodePos5();
	assertTrue("Incorrect error message office region", editOffice.Confirm());






}

@Then("^Super Admin can always MOVE an office between one sub-tier to another under a same department$")
public void super_Admin_can_always_MOVE_an_office_between_one_sub_tier_to_another_under_a_same_department() throws Exception {
	officeMove=new OfficeMove();

	driver.navigate().back();
	assertTrue("office move issue1",officeMove.ActionsOptions());
	officeMove.MovePermission();
	assertTrue("office move issue2",officeMove.PermissionValidation1());

	officeMove.AdminMovePermission();
	assertTrue("office move issue3",officeMove.PermissionValidation2());
	

	
}
@Then("^the RA will determine transfer permission$")
public void the_RA_will_determine_transfer_permission() throws Exception {
	((JavascriptExecutor) driver).executeScript("scroll(0,900)");
	Thread.sleep(4000);
	Feeds = new feeds();
	Feeds.SearchAUserInDirectoryMove();
}


@Then("^Department admin has the \"([^\"]*)\" permission as an permission\\.The \"([^\"]*)\" permission is available, then a department admin can MOVE an office between one sub-tier to another under a same department$")
public void department_admin_has_the_permission_as_an_permission_The_permission_is_available_then_a_department_admin_can_MOVE_an_office_between_one_sub_tier_to_another_under_a_same_department(String arg1, String arg2) throws Exception {

	officeMove=new OfficeMove();
	officeMove.SearchGSAoFFICE();
	assertTrue("office move issue1",officeMove.ActionsOptions());
	officeMove.MovePermission();
	assertTrue("office move issue2",officeMove.PermissionValidation1());

	
	officeMove.AdminMovePermission();
	assertTrue("office move issue3",officeMove.PermissionValidation3());
}
@When("^Sub-tier admin CAN NOT move an office$")
public void sub_tier_admin_CAN_NOT_move_an_office() throws Exception {
	officeMove=new OfficeMove();
	officeMove.SearchGSAoFFICE();
	assertTrue("office move issue1",officeMove.ActionsOptions());
	officeMove.MovePermission();

	assertFalse("office move issue2",officeMove.PermissionValidation1());

}
@Then("^Only active offices can be moved i\\.e\\. inactive offices and offices that are scheduled to be active cannot be moved \\(MOVE drop-down doesnt show up\\)$")
public void only_active_offices_can_be_moved_i_e_inactive_offices_and_offices_that_are_scheduled_to_be_active_cannot_be_moved_MOVE_drop_down_doesnt_show_up() throws Exception {
	officeMove=new OfficeMove();
	officeMove.SearchInactiveOffice();
	assertTrue("office move issue1",officeMove.ActionsOptions());
	officeMove.MovePermission();

	assertFalse("office move issue2",officeMove.PermissionValidation1());
	
	
	officeMove.SearchActiveOffice();
	assertTrue("office move issue1",officeMove.ActionsOptions());
	officeMove.MovePermission();

	assertTrue("office move issue2",officeMove.PermissionValidation1());
	
	officeMove.SearchToBeActiveOffice();
	assertTrue("office move issue1",officeMove.ActionsOptions());
	officeMove.MovePermission();
//THIS IS A BUG
	assertFalse("office move issue2",officeMove.PermissionValidation1());
	
}


@Then("^Offices can be moved between one active sub-tier to another under a same department\\. \\(Note: Inactive and scheduled to be active sub-tiers should not show up in the agency picker drop-down\\)$")
public void offices_can_be_moved_between_one_active_sub_tier_to_another_under_a_same_department_Note_Inactive_and_scheduled_to_be_active_sub_tiers_should_not_show_up_in_the_agency_picker_drop_down() throws Exception {
	officeMove.CheckOfficeMoveOptions();
	assertTrue("office move issue1",officeMove.ActionsOptions());
	officeMove.MovePermission();

	assertTrue("office move issue2",officeMove.PermissionValidation1());
	officeMove.AdminMovePermission();
	
	boolean Validation =officeMove.ListValidation();
	Assert.assertTrue(Validation);
	boolean Validation2 =officeMove.ListValidation2();
	Assert.assertTrue(Validation2);
	boolean Validation3 =officeMove.ListValidation3();
	Assert.assertTrue(Validation3);
	boolean Validation4 =officeMove.ListValidation4();
	Assert.assertTrue(Validation4);
	boolean Validation5 =officeMove.ListValidation5();
	Assert.assertTrue(Validation5);
	
}

@Then("^During office move, same parent sub-tier cannot be chosen\\. UI Should throw an error if a same parent sub-tier is chosen$")
public void during_office_move_same_parent_sub_tier_cannot_be_chosen_UI_Should_throw_an_error_if_a_same_parent_sub_tier_is_chosen() throws Exception {
	officeMove=new OfficeMove();

	officeMove.Negmove();
	boolean Validation6 =officeMove.NegValidation();
	Assert.assertTrue(Validation6);
}

@Then("^During move, the confirmation page should show new sub-tier's name and its agency code\\.$")
public void during_move_the_confirmation_page_should_show_new_sub_tier_s_name_and_its_agency_code() throws Exception {
	officeMove=new OfficeMove();

	officeMove.OfficeMoveFlowPOS();
	assertTrue("office move issue version",officeMove.NewOfficeVersion());
	boolean Validation6 =officeMove.BreadcrumbValidationPreMove();
	Assert.assertTrue(Validation6);
	officeMove.MovePermission();
	officeMove.AdminMovePermission();
	boolean Validation =officeMove.ListValidation();
	Assert.assertTrue(Validation);
	boolean Validation2 =officeMove.ListValidation2();
	Assert.assertTrue(Validation2);
	boolean Validation3 =officeMove.ListValidation3();
	Assert.assertTrue(Validation3);
	boolean Validation4 =officeMove.ListValidation4();
	Assert.assertTrue(Validation4);
	boolean Validation5 =officeMove.ListValidation5();
	Assert.assertTrue(Validation5);
	

	
	
}
@Then("^During move, the confirmation page should show new sub-tier's name and its agency code2\\.$")
public void during_move_the_confirmation_page_should_show_new_sub_tier_s_name_and_its_agency_code2() throws Exception {
	officeMove=new OfficeMove();

	officeMove.OfficeMoveFlowPOS0();
	assertTrue("office move issue version",officeMove.NewOfficeVersion());
	boolean Validation6 =officeMove.BreadcrumbValidationPreMove();
	Assert.assertTrue(Validation6);
	officeMove.MovePermission();
	officeMove.AdminMovePermission();
	boolean Validation =officeMove.ListValidation();
	Assert.assertTrue(Validation);
	boolean Validation2 =officeMove.ListValidation2();
	Assert.assertTrue(Validation2);
	boolean Validation3 =officeMove.ListValidation3();
	Assert.assertTrue(Validation3);
	boolean Validation4 =officeMove.ListValidation4();
	Assert.assertTrue(Validation4);
	boolean Validation5 =officeMove.ListValidation5();
	Assert.assertTrue(Validation5);
	

	
	
}

@Then("^On completion of move, the office should now reside under a new parent sub-tier i\\.e breadcrumb should be updated, office profile should now reflect the new parent sub-tier's name and the office should be available from new sub-tier's hierarchy tab\\.$")
public void on_completion_of_move_the_office_should_now_reside_under_a_new_parent_sub_tier_i_e_breadcrumb_should_be_updated_office_profile_should_now_reflect_the_new_parent_sub_tier_s_name_and_the_office_should_be_available_from_new_sub_tier_s_hierarchy_tab() throws Exception {
	officeMove.OfficeMoveFlowPOS2();
	boolean Validation00 =officeMove.ConfirmationValidation();
	Assert.assertTrue(Validation00);
	officeMove.MoveOfficeFinal();
	assertTrue("office move confirmation2",officeMove.MoveValidation());
	
	officeMove.OfficeMoveFlowPOS3();
	assertTrue("office move confirmatio3n",officeMove.isSuccessBannerThere());
	boolean Validation6 =officeMove.BreadcrumbValidationPostMove();
	Assert.assertTrue(Validation6);
	officeMove.OfficeMoveFlowPOS4();
	boolean Validation7 =officeMove.HistoryValidation();
	Assert.assertTrue(Validation7);
	boolean Validation8 =officeMove.HistoryValidation2();
	Assert.assertTrue(Validation8);
	boolean Validation9 =officeMove.HistoryValidation3();
	Assert.assertTrue(Validation9);
	boolean Validation10 =officeMove.NameValidationPostMove();
	Assert.assertTrue(Validation10);
	
	}

	// Noeditcase
	// officeMove.fh();

	@Then("^For offices that are moved, do not allow editing of start date for office and office types \\(Disable the input date field\\)\\. Unless its a offices thats not veen moved$")
	public void for_offices_that_are_moved_do_not_allow_editing_of_start_date_for_office_and_office_types_Disable_the_input_date_field_Unless_its_a_offices_thats_not_veen_moved()
			throws Exception {
		officeMove = new OfficeMove();

		officeMove.MoveEdit();
	}

	@When("^office types move on confirmation office type and start date and end date should not change unless past date$")
	public void office_types_move_on_confirmation_office_type_and_start_date_and_end_date_should_not_change_unless_past_date()
			throws Exception {
		officeMove.MoveEdit2();

		boolean Validation8 = officeMove.val();
		Assert.assertTrue(Validation8);
		boolean Validation9 = officeMove.val2();
		Assert.assertTrue(Validation9);
		boolean Validation10 = officeMove.val3();
		Assert.assertTrue(Validation10);
		boolean Validation11 = officeMove.val4();
		Assert.assertTrue(Validation11);
		officeMove.MoveEdit3();
		boolean Validation12 = officeMove.valMove();
		Assert.assertTrue(Validation12);
		boolean Validation13 = officeMove.val2Move();
		Assert.assertTrue(Validation13);
		boolean Validation14 = officeMove.val5();
		Assert.assertTrue(Validation14);
		boolean Validation15 = officeMove.val4Move();
		Assert.assertTrue(Validation15);
		boolean Validation16 = officeMove.valStartDate();
		Assert.assertTrue(Validation16);
		officeMove.MoveEdit4();
		boolean Validation7 = officeMove.HistoryValidation();
		Assert.assertTrue(Validation7);
		boolean Validation17 = officeMove.HistoryValidation2();
		Assert.assertTrue(Validation17);
		boolean Validation18 = officeMove.HistoryValidation3();
		Assert.assertTrue(Validation18);
	}

	@Then("^user validates version for office types after a move$")
	public void user_validates_version_for_office_types_after_a_move() throws Exception {
		officeMove.MoveEdit5();
		boolean Validation19 = officeMove.valMove();
		Assert.assertTrue(Validation19);
		boolean Validation20 = officeMove.val2Move();
		Assert.assertTrue(Validation20);
		boolean Validation21 = officeMove.val5();
		Assert.assertTrue(Validation21);
		boolean Validation22 = officeMove.val4Move();
		Assert.assertTrue(Validation22);
		boolean Validation23 = officeMove.valStartDate();
		Assert.assertTrue(Validation23);
		officeMove.MoveEdit4();
		assertTrue("office move confirmatio3n", officeMove.isSuccessBannerThere());

		boolean Validation71 = officeMove.HistoryValidation();
		Assert.assertTrue(Validation71);
		boolean Validation171 = officeMove.HistoryValidation2();
		Assert.assertTrue(Validation171);
		boolean Validation1711 = officeMove.HistoryValidation2();
		Assert.assertTrue(Validation1711);
		boolean Validation17111 = officeMove.HistoryValidation2();
		Assert.assertTrue(Validation17111);
		boolean Validation181 = officeMove.HistoryValidation3();
		Assert.assertTrue(Validation181);
		boolean Validation1811 = officeMove.HistoryValidation4();
		Assert.assertTrue(Validation1811);
		boolean Validation6 = officeMove.BreadcrumbValidationPostMove2();
		Assert.assertTrue(Validation6);

	}

	@When("^user picks a office with no changes and EDIT city there should be changes in the version and validate the new and old changes\\.$")
	public void user_picks_a_office_with_no_changes_and_EDIT_city_there_should_be_changes_in_the_version_and_validate_the_new_and_old_changes()
			throws Exception {
		officeMove.fh();
		officeMove.MoveEdit2();

		officeMove.MoveEdit6();
		boolean Validation711 = officeMove.HistoryValidation();
		Assert.assertTrue(Validation711);
		officeMove.MoveEdit7();

		boolean Validation7111 = officeMove.HistoryValidation();
		Assert.assertTrue(Validation7111);
		boolean Validation18111 = officeMove.HistoryValidation3();
		Assert.assertTrue(Validation18111);
		boolean Validation181111 = officeMove.HistoryValidationBeforeEdit();
		Assert.assertTrue(Validation181111);
		officeMove.VersionClick();
		assertTrue("office move history", officeMove.isHistorical());

		boolean Validation1811111 = officeMove.HistoryValidationEdit();
		Assert.assertTrue(Validation1811111);
	}

	@Then("^move THE SAME office and check the version there should be four version as current,created,updated,updated$")
	public void move_THE_SAME_office_and_check_the_version_there_should_be_four_version_as_current_created_updated_updated()
			throws Exception {
		officeMove.MoveEdit8();
		officeMove.MoveEdit4();
		boolean Validation71111 = officeMove.HistoryValidation();
		Assert.assertTrue(Validation71111);
		boolean Validation18111111 = officeMove.HistoryValidation3();
		Assert.assertTrue(Validation18111111);
		boolean Validation17111 = officeMove.HistoryValidation2();
		Assert.assertTrue(Validation17111);
		boolean Validation171111 = officeMove.HistoryValidation2();
		Assert.assertTrue(Validation171111);
	}
	

@Then("^user creates office without end date and does validations$")
public void user_creates_office_without_end_date_and_does_validations() throws Exception {
	officeMove = new OfficeMove();

	officeMove.NoEndDateVal();
	boolean Validation8 = officeMove.val();
	Assert.assertTrue(Validation8);
	boolean Validation9 = officeMove.val2();
	Assert.assertTrue(Validation9);

	boolean Validation11 = officeMove.val4();
	Assert.assertTrue(Validation11);
	officeMove.NoEndDateVal2();
	boolean Validation12 = officeMove.NoEndDateVal3();
	Assert.assertTrue(Validation12);
	boolean Validation13 = officeMove.NoEndDateVal4();
	Assert.assertTrue(Validation13);
	boolean Validation14 = officeMove.NoEndDateVal5();
	Assert.assertTrue(Validation14);
	boolean Validation15 = officeMove.NoEndDateVal6();
	Assert.assertTrue(Validation15);
	boolean Validation16 = officeMove.NoEndDateVal7();
	Assert.assertTrue(Validation16);
	boolean Validation17 = officeMove.NoEndDateVal8();
	Assert.assertTrue(Validation17);
	boolean Validation18 = officeMove.BreadcrumbValidationPreMove();
	Assert.assertTrue(Validation18);

	boolean Validation81 = officeMove.val6();
	Assert.assertTrue(Validation81);
	
	

	
}


@Then("^user will move office with no end date and do validations$")
public void user_will_move_office_with_no_end_date_and_do_validations() throws Exception {
	officeMove.NoEndDateMove();
	boolean Validation23 = officeMove.valStartDateNeg();
	Assert.assertTrue(Validation23);
	boolean Validation231 = officeMove.valStartDateNoEndDate();
	Assert.assertTrue(Validation231);
	boolean Validation2311 = officeMove.valStartDateNoEndDate2();
	Assert.assertTrue(Validation2311);
	officeMove.NoEndDateMove2();
//
	assertTrue("office move confirmatio3n", officeMove.isSuccessBannerThere());

	boolean Validation71 = officeMove.HistoryValidation();
	Assert.assertTrue(Validation71);
	boolean Validation171 = officeMove.HistoryValidation2();
	Assert.assertTrue(Validation171);
	boolean Validation181 = officeMove.HistoryValidation3();
	Assert.assertTrue(Validation181);
	boolean Validation1811 = officeMove.HistoryValidation4();
	Assert.assertFalse(Validation1811);
	boolean Validation6 = officeMove.BreadcrumbValidationPostMove2();
	Assert.assertTrue(Validation6);
	boolean Validation23111 = officeMove.valStartDateNoEndDate3();
	Assert.assertTrue(Validation23111);
	boolean Validation231111 = officeMove.valStartDateNoEndDate4();
	Assert.assertTrue(Validation231111);
	
	//
	officeMove.VersionClick();
	boolean Validation2310111 = officeMove.valStartDateNeg2();
	Assert.assertTrue(Validation2310111);
	
	boolean Validation2 = officeMove.valStartDateNeg3();
	Assert.assertTrue(Validation2);
	boolean Validation = officeMove.UpdatedVal();
	Assert.assertTrue(Validation);
	assertTrue("office move history", officeMove.isHistorical());
	officeMove.VersionClick2();
	assertTrue("office move history", officeMove.isHistorical());
	boolean Validation1065 = officeMove.NoEndDateVal70();
	Assert.assertTrue(Validation1065);

	officeMove.VersionClick3();
	assertFalse("office move history", officeMove.isHistorical());



}

@Then("^user will move office once again with no end date and validates version$")
public void user_will_move_office_once_again_with_no_end_date_and_validates_version() throws Exception {
	officeMove.NoEndDateMove0();
	boolean Validation23 = officeMove.valStartDateNeg();
	Assert.assertTrue(Validation23);
	boolean Validation231 = officeMove.valStartDateNoEndDate();
	Assert.assertTrue(Validation231);
	boolean Validation2311 = officeMove.valStartDateNoEndDate2();
	Assert.assertTrue(Validation2311);
	boolean Validation23111 = officeMove.Newl2();
	Assert.assertTrue(Validation23111);
	officeMove.NoEndDateMove2();
	assertTrue("office move confirmatio3n", officeMove.isSuccessBannerThere());

	boolean Validation71 = officeMove.HistoryValidation();
	Assert.assertTrue(Validation71);
	boolean Validation171 = officeMove.HistoryValidation2();
	Assert.assertTrue(Validation171);
	boolean Validation181 = officeMove.HistoryValidation3();
	Assert.assertTrue(Validation181);
	boolean Validation1811 = officeMove.HistoryValidation4();
	Assert.assertTrue(Validation1811);
	boolean Validation6 = officeMove.BreadcrumbValidationPostMove2();
	Assert.assertTrue(Validation6);
	boolean Validation231110 = officeMove.valStartDateNoEndDate3();
	Assert.assertTrue(Validation231110);
	boolean Validation231111 = officeMove.valStartDateNoEndDate4();
	Assert.assertTrue(Validation231111);
	
	officeMove.VersionClick();
	boolean Validation2310111 = officeMove.valStartDateNeg2();
	Assert.assertFalse(Validation2310111);
	
	boolean Validation2 = officeMove.valStartDateNeg3();
	Assert.assertTrue(Validation2);
	boolean Validation = officeMove.UpdatedVal();
	Assert.assertTrue(Validation);
	assertTrue("office move history", officeMove.isHistorical());
	
	officeMove.VersionClick2();
	assertTrue("office move history", officeMove.isHistorical());
	boolean Validation1065 = officeMove.NoEndDateVal70();
	Assert.assertTrue(Validation1065);
	officeMove.VersionClick3();
	assertFalse("office move history", officeMove.isHistorical());
}

@When("^User navigates to Department \"([^\"]*)\"$")
public void user_navigates_to_Department(String depName) throws InterruptedException  {
	generalFhPage = new GeneralFHPage();
	generalFhPage.navigateToDepartment(depName);;
}

@When("^User navigates to Subtier \"([^\"]*)\"$")
public void user_navigates_to_Subtier(String subtierName) throws InterruptedException {
	generalFhPage = new GeneralFHPage();
	generalFhPage.navigateToSubtier();
}

@When("^User creates an office with end date \"([^\"]*)\", without office type$")
public void user_creates_an_office_with_end_date_without_office_type(String endDate) throws Exception {
	generalFhPage = new GeneralFHPage();
	createOffice = new CreateOffice();
	generalFhPage.createNewOfficeWithEndDateWithoutOfficeType(endDate);
	createOffice.SubmitOffice();
}

@When("^User creates an office no end date, with \"([^\"]*)\" office type end date \"([^\"]*)\"$")
public void user_creates_an_office_no_end_date_with_office_type_end_date(String officeType, String endDate) throws Exception {
	generalFhPage = new GeneralFHPage();
	createOffice = new CreateOffice();
	generalFhPage.createNewOfficeWithOfficeType(officeType, endDate);
	createOffice.SubmitOffice();
}

@When("^User try to move newly created office to the new Subtier$")
public void user_try_to_move_newly_created_office_to_the_new_Subtier() throws InterruptedException {
	generalFhPage = new GeneralFHPage();
	generalFhPage.moveOfficeToNewSubtier();
}

@Then("^User validates error message for office move \"([^\"]*)\" is after new Subtier$")
public void user_validates_error_message_for_office_move_is_after_new_Subtier(String value) throws Exception {
	generalFhPage = new GeneralFHPage();
	assertTrue(generalFhPage.validateCannotCompleteMoveWarningMsgForOfficeEndDate(value));
}


}
