package stepdefinitions;

import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.openqa.selenium.By;

import AlertsEmailNotifications.EmailCheck;
import FhPages.CreateOffice;
import FhPages.FhBasics;
import FhPages.OfficeMove;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import login.govPages.loginGov;
import util.TestBase;

public class EmailStep extends TestBase {

	EmailCheck emailCheck;
	loginGov LoginGov;
	CreateOffice createOffice;
	FhBasics fhBasics;
	OfficeMove officeMove;

	@Given("^a User without role signs inn$")
	public void a_User_without_role_signs_inn() throws Exception {
		LoginGov = new loginGov();
		LoginGov.GeneralLogIn(prop.getProperty("NoRole"), prop.getProperty("password2"), "VDPZXAM3JGMMJGHM");
	}

	@Then("^user should receive an email \\(TROY\\) with the proper message$")
	public void user_should_receive_an_email_TROY_with_the_proper_message() throws Exception {

		createOffice = new CreateOffice();
		createOffice.CreatePosFlowMail1();
		createOffice.SubmitOffice();
		assertTrue("No office type isnt written on profile page",createOffice.ValidateNoOfficeTypeOnProfilePage());
		System.out.println("No Office Types Displayed on Profile Page");
		emailCheck = new EmailCheck();
		emailCheck.goToFedMailInbox(prop.getProperty("GMAIL_USERNAME2"), prop.getProperty("USERPASS"));
		String emailSubject = emailCheck.captureTitleFromLastEmail(0);
		String emailBody = emailCheck.captureEmailMessage(0);
		String emailToAndFrom = emailCheck.captureToAndFromInEmail();
		String emailXML = emailCheck.captureXML();

		System.out.println("subject" + emailSubject);
		System.out.println("body" + emailBody);
		System.out.println("from" + emailToAndFrom);
		System.out.println("XML" + emailXML);

		// asserting email subject
		Assert.assertEquals(true, emailSubject.contains(prop.getProperty("EMAIL_REGULAR_SENT_FROM")));
		System.out.println("" + "WORKED");
		Assert.assertEquals(true, emailSubject.contains(prop.getProperty("EMAIL_TITLE")));
		System.out.println("" + "WORKED");
		// asserting email to and from address
		Assert.assertEquals(true, emailToAndFrom.contains(prop.getProperty("EMAIL_REGULAR_SENT_FROM_DOMAIN")));
		System.out.println("" + "WORKED");
		Assert.assertEquals(true, emailToAndFrom.contains(prop.getProperty("EMAIL_Troy")));
		System.out.println("" + "WORKED");
		// asserting the email body

		Assert.assertEquals(true, emailBody.contains(prop.getProperty("EMAIL_ACTION2")));
		System.out.println("" + "WORKED");
		Assert.assertEquals(true, emailBody.contains(prop.getProperty("DEPARTMENT")));
		System.out.println("" + "WORKED");
		Assert.assertEquals(true, emailBody.contains(prop.getProperty("SUBTIER")));
		System.out.println("" + "WORKED");
		Assert.assertEquals(true, emailXML.contains("TEST ONLY.xml"));
		System.out.println("" + "WORKEDXML");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class=\"aio UKr6le\"]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@role=\"checkbox\"]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\":4\"]/div/div[1]/div[1]/div/div/div[2]/div[3]")).click();
		Thread.sleep(1000);
	}

	@Then("^user should receive an email \\(SuperAdmin\\) with the proper message$")
	public void user_should_receive_an_email_SuperAdmin_with_the_proper_message() throws Exception {

		emailCheck.RefreshMail();
		////

		String emailSubject = emailCheck.captureTitleFromLastEmail(0);
		String emailBody = emailCheck.captureEmailMessage(0);
		String emailToAndFrom = emailCheck.captureToAndFromInEmail();

		System.out.println("subject" + emailSubject);
		System.out.println("body" + emailBody);
		System.out.println("from" + emailToAndFrom);

		// asserting email subject SUPER

		// asserting email to and from address
		Assert.assertEquals(true, emailToAndFrom.contains(prop.getProperty("EMAIL_REGULAR_SENT_FROM_DOMAIN")));
		System.out.println("" + "WORKED");
		Assert.assertEquals(true, emailToAndFrom.contains(prop.getProperty("EMAIL_SuperAdmin")));
		System.out.println("" + "WORKED");
		// asserting the email body
		Assert.assertEquals(true, emailBody.contains(prop.getProperty("EMAIL_REQUESTOR_NAME")));
		System.out.println("" + "WORKED");

		Assert.assertEquals(true, emailBody.contains(prop.getProperty("EMAIL_ACTION")));
		System.out.println("" + "WORKED");
		Assert.assertEquals(true, emailBody.contains(prop.getProperty("DEPARTMENT")));
		System.out.println("" + "WORKED");
		Assert.assertEquals(true, emailBody.contains(prop.getProperty("SUBTIER")));
		System.out.println("" + "WORKED");
		driver.findElement(By.xpath("//div[@class=\"aio UKr6le\"]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@role=\"checkbox\"]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\":4\"]/div/div[1]/div[1]/div/div/div[2]/div[3]")).click();
		Thread.sleep(1000);

		emailCheck.switchTabs(2);

	}

	@Then("^the user should be able to find the subtier to create an office for a department admin$")
	public void the_user_should_be_able_to_find_the_subtier_to_create_an_office_for_a_department_admin()
			throws Exception {

		fhBasics = new FhBasics();
		createOffice = new CreateOffice();
		emailCheck = new EmailCheck();
		fhBasics.intoFASL2();
		assertTrue("Create office option not there", fhBasics.isCreateOfficeThere());
		emailCheck.intoOFFICECreation();
		createOffice.CreatePosFlowEmail2();
		createOffice.SubmitOffice();
		assertTrue("No office type isnt written on profile page",createOffice.ValidateNoOfficeTypeOnProfilePage());
		System.out.println("No Office Types Displayed on Profile Page");

	}

	@Then("^user should receive an email \\(TROY\\) with the proper message for department admin as requester$")
	public void user_should_receive_an_email_TROY_with_the_proper_message_for_department_admin_as_requester()
			throws Exception {

		emailCheck = new EmailCheck();

		emailCheck.goToFedMailInbox(prop.getProperty("GMAIL_USERNAME"), prop.getProperty("USERPASS"));
		String emailSubject = emailCheck.captureTitleFromLastEmail(0);
		String emailBody = emailCheck.captureEmailMessage(0);
		String emailToAndFrom = emailCheck.captureToAndFromInEmail();
		String emailXML = emailCheck.captureXML();

		System.out.println("subject" + emailSubject);
		System.out.println("body" + emailBody);
		System.out.println("from" + emailToAndFrom);
		System.out.println("XML" + emailXML);

		// asserting email subject
		Assert.assertEquals(true, emailSubject.contains(prop.getProperty("EMAIL_REGULAR_SENT_FROM")));
		System.out.println("" + "WORKED");
		Assert.assertEquals(true, emailSubject.contains(prop.getProperty("EMAIL_TITLE")));
		System.out.println("" + "WORKED");

		// asserting email to and from address
		Assert.assertEquals(true, emailToAndFrom.contains(prop.getProperty("EMAIL_REGULAR_SENT_FROM_DOMAIN")));
		System.out.println("" + "WORKED");
		Assert.assertEquals(true, emailToAndFrom.contains(prop.getProperty("EMAIL_Troy")));
		System.out.println("" + "WORKED");
		// asserting the email body

		Assert.assertEquals(true, emailBody.contains(prop.getProperty("EMAIL_ACTION2")));
		System.out.println("" + "WORKED");
		Assert.assertEquals(true, emailBody.contains(prop.getProperty("DEPARTMENT2")));
		System.out.println("" + "WORKED");
		Assert.assertEquals(true, emailBody.contains(prop.getProperty("SUBTIER2")));
		System.out.println("" + "WORKED");
		Assert.assertEquals(true, emailXML.contains("TEST ONLY.xml"));
		System.out.println("" + "WORKEDXML");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class=\"aio UKr6le\"]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@role=\"checkbox\"]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\":4\"]/div/div[1]/div[1]/div/div/div[2]/div[3]")).click();
		Thread.sleep(1000);

	}

	@Then("^user should receive an email \\(DepartmentAdmin\\) with the proper message$")
	public void user_should_receive_an_email_DepartmentAdmin_with_the_proper_message() throws Exception {
		emailCheck.RefreshMail();
		////

		String emailSubject2 = emailCheck.captureTitleFromLastEmail(0);
		String emailBody2 = emailCheck.captureEmailMessage(0);
		String emailToAndFrom2 = emailCheck.captureToAndFromInEmail();

		System.out.println("subject" + emailSubject2);
		System.out.println("body" + emailBody2);
		System.out.println("from" + emailToAndFrom2);

		// asserting email subject SUPER

		// asserting email to and from address
		Assert.assertEquals(true, emailToAndFrom2.contains(prop.getProperty("EMAIL_REGULAR_SENT_FROM_DOMAIN")));
		System.out.println("" + "WORKED");
		Assert.assertEquals(false, emailToAndFrom2.contains(prop.getProperty("EMAIL_SuperAdmin")));
		System.out.println("" + "WORKED");
		Assert.assertEquals(true, emailToAndFrom2.contains(prop.getProperty("EMAIL_Dep")));
		System.out.println("" + "WORKED");
		// asserting the email body
		Assert.assertEquals(true, emailBody2.contains(prop.getProperty("EMAIL_REQUESTOR_NAME")));
		System.out.println("" + "WORKED");

		Assert.assertEquals(true, emailBody2.contains(prop.getProperty("EMAIL_ACTION")));
		System.out.println("" + "WORKED");
		Assert.assertEquals(true, emailBody2.contains(prop.getProperty("DEPARTMENT2")));
		System.out.println("" + "WORKED");
		Assert.assertEquals(true, emailBody2.contains(prop.getProperty("SUBTIER2")));
		System.out.println("" + "WORKED");

		driver.findElement(By.xpath("//div[@class=\"aio UKr6le\"]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@role=\"checkbox\"]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\":4\"]/div/div[1]/div[1]/div/div/div[2]/div[3]")).click();
		Thread.sleep(1000);

		emailCheck.switchTabs(2);

	}

	@Then("^the user should be able to find the subtier to create an office for a subtier admin$")
	public void the_user_should_be_able_to_find_the_subtier_to_create_an_office_for_a_subtier_admin() throws Exception {
		fhBasics = new FhBasics();
		createOffice = new CreateOffice();
		emailCheck = new EmailCheck();
		fhBasics.intoGSAL2();
		assertTrue("Create office option not there", fhBasics.isCreateOfficeThere());
		emailCheck.intoOFFICECreation();
		createOffice.CreatePosFlowEmail2();
		createOffice.SubmitOffice();
		assertTrue("No office type isnt written on profile page",createOffice.ValidateNoOfficeTypeOnProfilePage());
		System.out.println("No Office Types Displayed on Profile Page");
	}

	@Then("^user should receive an email \\(TROY\\) with the proper message for subtier admin as requester$")
	public void user_should_receive_an_email_TROY_with_the_proper_message_for_subtier_admin_as_requester()
			throws Exception {

		emailCheck = new EmailCheck();

		emailCheck.goToFedMailInbox(prop.getProperty("GMAIL_USERNAME2"), prop.getProperty("USERPASS"));
		String emailSubject = emailCheck.captureTitleFromLastEmail(0);
		String emailBody = emailCheck.captureEmailMessage(0);
		String emailToAndFrom = emailCheck.captureToAndFromInEmail();
		String emailXML = emailCheck.captureXML();

		System.out.println("subject" + emailSubject);
		System.out.println("body" + emailBody);
		System.out.println("from" + emailToAndFrom);
		System.out.println("XML" + emailXML);

		// asserting email subject
		Assert.assertEquals(true, emailSubject.contains(prop.getProperty("EMAIL_REGULAR_SENT_FROM")));
		System.out.println("" + "WORKED");
		Assert.assertEquals(true, emailSubject.contains(prop.getProperty("EMAIL_TITLE")));
		System.out.println("" + "WORKED");

		// asserting email to and from address
		Assert.assertEquals(true, emailToAndFrom.contains(prop.getProperty("EMAIL_REGULAR_SENT_FROM_DOMAIN")));
		System.out.println("" + "WORKED");
		Assert.assertEquals(true, emailToAndFrom.contains(prop.getProperty("EMAIL_Troy")));
		System.out.println("" + "WORKED");
		// asserting the email body

		Assert.assertEquals(true, emailBody.contains(prop.getProperty("EMAIL_ACTION2")));
		System.out.println("" + "WORKED");
		Assert.assertEquals(true, emailBody.contains(prop.getProperty("DEPARTMENT2")));
		System.out.println("" + "WORKED");
		Assert.assertEquals(true, emailBody.contains(prop.getProperty("SUBTIER3")));
		System.out.println("" + "WORKED");
		Assert.assertEquals(true, emailXML.contains("TEST ONLY.xml"));
		System.out.println("" + "WORKEDXML");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class=\"aio UKr6le\"]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@role=\"checkbox\"]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\":4\"]/div/div[1]/div[1]/div/div/div[2]/div[3]")).click();
		Thread.sleep(1000);

	}

	@Then("^user should receive an email \\(SubtierAdmin\\) with the proper message$")
	public void user_should_receive_an_email_SubtierAdmin_with_the_proper_message() throws Exception {
		emailCheck.RefreshMail();
		////

		String emailSubject2 = emailCheck.captureTitleFromLastEmail(0);
		String emailBody2 = emailCheck.captureEmailMessage(0);
		String emailToAndFrom2 = emailCheck.captureToAndFromInEmail();

		System.out.println("subject" + emailSubject2);
		System.out.println("body" + emailBody2);
		System.out.println("from" + emailToAndFrom2);

		// asserting email subject SUPER

		// asserting email to and from address
		Assert.assertEquals(true, emailToAndFrom2.contains(prop.getProperty("EMAIL_REGULAR_SENT_FROM_DOMAIN")));
		System.out.println("" + "WORKED");
		Assert.assertEquals(false, emailToAndFrom2.contains(prop.getProperty("EMAIL_SuperAdmin")));
		System.out.println("" + "WORKED");
		Assert.assertEquals(true, emailToAndFrom2.contains(prop.getProperty("EMAIL_Sub")));
		System.out.println("" + "WORKED");
		// asserting the email body
		Assert.assertEquals(true, emailBody2.contains(prop.getProperty("EMAIL_REQUESTOR_NAME")));
		System.out.println("" + "WORKED");

		Assert.assertEquals(true, emailBody2.contains(prop.getProperty("EMAIL_ACTION")));
		System.out.println("" + "WORKED");
		Assert.assertEquals(true, emailBody2.contains(prop.getProperty("DEPARTMENT2")));
		System.out.println("" + "WORKED");
		Assert.assertEquals(true, emailBody2.contains(prop.getProperty("SUBTIER3")));
		System.out.println("" + "WORKED");

		driver.findElement(By.xpath("//div[@class=\"aio UKr6le\"]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@role=\"checkbox\"]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\":4\"]/div/div[1]/div[1]/div/div/div[2]/div[3]")).click();
		Thread.sleep(1000);

		emailCheck.switchTabs(2);

	}

	//////////////////////// EDIT

	@When("^the user edits the name of the office$")
	public void the_user_edits_the_name_of_the_office() throws Exception {
		createOffice.EditOfficeName();

		createOffice.SubmitOffice();
	}

	@Then("^only Troy should receive an email for the edit$")
	public void only_Troy_should_receive_an_email_for_the_edit() throws Exception {

		emailCheck.switchTabs(1);
		driver.navigate().refresh();
		String emailSubject = emailCheck.captureTitleFromLastEmail(0);
		String emailBody = emailCheck.captureEmailMessage(0);
		String emailToAndFrom = emailCheck.captureToAndFromInEmail();
		String emailXML = emailCheck.captureXML();

		System.out.println("subject" + emailSubject);
		System.out.println("body" + emailBody);
		System.out.println("from" + emailToAndFrom);
		System.out.println("XML" + emailXML);

		// asserting email subject
		Assert.assertEquals(true, emailSubject.contains(prop.getProperty("EMAIL_REGULAR_SENT_FROM")));
		System.out.println("" + "WORKED");
		Assert.assertEquals(true, emailSubject.contains(prop.getProperty("EMAIL_TITLE2")));
		System.out.println("" + "WORKED");

		// asserting email to and from address
		Assert.assertEquals(true, emailToAndFrom.contains(prop.getProperty("EMAIL_REGULAR_SENT_FROM_DOMAIN")));
		System.out.println("" + "WORKED");
		Assert.assertEquals(true, emailToAndFrom.contains(prop.getProperty("EMAIL_Troy")));
		System.out.println("" + "WORKED");
		// asserting the email body

		Assert.assertEquals(true, emailBody.contains(prop.getProperty("EMAIL_ACTION3")));
		System.out.println("" + "WORKED");
		Assert.assertEquals(true, emailXML.contains("TEST ONLY.xml"));
		System.out.println("" + "WORKEDXML");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class=\"aio UKr6le\"]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@role=\"checkbox\"]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\":4\"]/div/div[1]/div[1]/div/div/div[2]/div[3]")).click();
		Thread.sleep(1000);

		emailCheck.switchTabs(2);
	}

	@When("^the user edits the start date of the office$")
	public void the_user_edits_the_start_date_of_the_office() throws Exception {
		createOffice.EditStart();

		createOffice.SubmitOffice();
	}

	@Then("^only Troy should not receive an email for the edit$")
	public void only_Troy_should_not_receive_an_email_for_the_edit() throws Exception {

		emailCheck.switchTabs(1);
		driver.navigate().refresh();
		String emailSubject = emailCheck.captureTitleFromLastEmail(0);
		String emailBody = emailCheck.captureEmailMessage(0);
		String emailToAndFrom = emailCheck.captureToAndFromInEmail();

		System.out.println("subject" + emailSubject);
		System.out.println("body" + emailBody);
		System.out.println("from" + emailToAndFrom);

		Assert.assertEquals(false, emailBody.contains(prop.getProperty("EMAIL_ACTION3")));
		System.out.println("" + "WORKED");
		Assert.assertEquals(false, emailBody.contains(prop.getProperty("DEPARTMENT")));
		System.out.println("" + "WORKED");
		Assert.assertEquals(false, emailBody.contains(prop.getProperty("SUBTIER")));
		System.out.println("" + "WORKED");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class=\"aio UKr6le\"]")).click();
		Thread.sleep(1000);

		emailCheck.switchTabs(2);
	}

	@When("^the user edits the short name of the office$")
	public void the_user_edits_the_short_name_of_the_office() throws Exception {
		createOffice.EditOfficeShort();

		createOffice.SubmitOffice();
	}

	@When("^the user edits the region name of the office$")
	public void the_user_edits_the_region_name_of_the_office() throws Exception {
		createOffice.EditOfficeRegion();

		createOffice.SubmitOffice();
	}

	@When("^the user edits the address of the office$")
	public void the_user_edits_the_address_of_the_office() throws Exception {
		createOffice.EditOfficeAddress();

		createOffice.SubmitOffice();
	}

	@When("^the user edits office to add in a office type of the office$")
	public void the_user_edits_office_to_add_in_a_office_type_of_the_office() throws Exception {
		createOffice.EditOfficeAddType();

		createOffice.SubmitOffice();
	}

	@When("^the user edits office to add in a office type as financial funding$")
	public void the_user_edits_office_to_add_in_a_office_type_as_financial_funding() throws Exception {
		createOffice.EditOfficeAddTypeNeg();

		createOffice.SubmitOffice();
	}
	@Then("^user should receive an email \\(TROY\\) with the proper message post move$")
	public void user_should_receive_an_email_TROY_with_the_proper_message_post_move() throws Exception {
		createOffice = new CreateOffice();
		
		emailCheck = new EmailCheck();
		emailCheck.goToFedMailInbox(prop.getProperty("GMAIL_USERNAME"), prop.getProperty("USERPASS"));
		String emailSubject = emailCheck.captureTitleFromLastEmail(0);
		String emailBody = emailCheck.captureEmailMessage(0);
		String emailToAndFrom = emailCheck.captureToAndFromInEmail();
		String emailXML = emailCheck.captureXML();

		System.out.println("subject" + emailSubject);
		System.out.println("body" + emailBody);
		System.out.println("from" + emailToAndFrom);
		System.out.println("XML" + emailXML);

		// asserting email subject
		Assert.assertEquals(true, emailSubject.contains(prop.getProperty("EMAIL_REGULAR_SENT_FROM")));
		System.out.println("" + "WORKED");
		Assert.assertEquals(true, emailSubject.contains(prop.getProperty("EMAIL_TITLE3")));
		System.out.println("" + "WORKED");
		// asserting email to and from address
		Assert.assertEquals(true, emailToAndFrom.contains(prop.getProperty("EMAIL_REGULAR_SENT_FROM_DOMAIN")));
		System.out.println("" + "WORKED");
		Assert.assertEquals(true, emailToAndFrom.contains(prop.getProperty("EMAIL_Troy")));
		System.out.println("" + "WORKED");
		// asserting the email body

		Assert.assertEquals(true, emailBody.contains(prop.getProperty("EMAIL_ACTION5")));
		System.out.println("" + "WORKED");
		Assert.assertEquals(true, emailBody.contains(prop.getProperty("DEPARTMENT3")));
		System.out.println("" + "WORKED");
		Assert.assertEquals(true, emailBody.contains(prop.getProperty("SUBTIER4")));
		System.out.println("" + "WORKED");
		Assert.assertEquals(true, emailXML.contains("TEST ONLY.xml"));
		System.out.println("" + "WORKEDXML");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class=\"aio UKr6le\"]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@role=\"checkbox\"]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\":4\"]/div/div[1]/div[1]/div/div/div[2]/div[3]")).click();
		Thread.sleep(1000);
	}


	@Then("^user should receive an email \\(SuperAdmin\\) with the proper message post move$")
	public void user_should_receive_an_email_SuperAdmin_with_the_proper_message_post_move() throws Exception {
		emailCheck.RefreshMail();
		////

		String emailSubject = emailCheck.captureTitleFromLastEmail(0);
		String emailBody = emailCheck.captureEmailMessage(0);
		String emailToAndFrom = emailCheck.captureToAndFromInEmail();

		System.out.println("subject" + emailSubject);
		System.out.println("body" + emailBody);
		System.out.println("from" + emailToAndFrom);

		// asserting email subject SUPER

		// asserting email to and from address
		Assert.assertEquals(true, emailToAndFrom.contains(prop.getProperty("EMAIL_REGULAR_SENT_FROM_DOMAIN")));
		System.out.println("" + "WORKED");
		Assert.assertEquals(true, emailToAndFrom.contains(prop.getProperty("EMAIL_SuperAdmin")));
		System.out.println("" + "WORKED");
		// asserting the email body
		Assert.assertEquals(true, emailBody.contains(prop.getProperty("EMAIL_REQUESTOR_NAME")));
		System.out.println("" + "WORKED");

		Assert.assertEquals(true, emailBody.contains(prop.getProperty("EMAIL_ACTION4")));
		System.out.println("" + "WORKED");
		Assert.assertEquals(true, emailBody.contains(prop.getProperty("DEPARTMENT3")));
		System.out.println("" + "WORKED");
		Assert.assertEquals(true, emailBody.contains(prop.getProperty("SUBTIER4")));
		System.out.println("" + "WORKED");
		driver.findElement(By.xpath("//div[@class=\"aio UKr6le\"]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@role=\"checkbox\"]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\":4\"]/div/div[1]/div[1]/div/div/div[2]/div[3]")).click();
		Thread.sleep(1000);

		emailCheck.switchTabs(2);

	}

	@When("^user should receive an email \\(TROY\\) with the proper message for DepartmentAdmin as requester post move$")
	public void user_should_receive_an_email_TROY_with_the_proper_message_for_DepartmentAdmin_as_requester_post_move() throws Exception {
	
		officeMove=new OfficeMove();

		officeMove.OfficeMoveFlowPOS00();
		
		officeMove.MovePermission();
		officeMove.AdminMovePermission();
		officeMove.OfficeMoveFlowPOS2();
		
		officeMove.MoveOfficeFinal();
		
		officeMove.OfficeMoveFlowPOS3();
		
		officeMove.OfficeMoveFlowPOS4();
		
		
		
		emailCheck = new EmailCheck();

		emailCheck.goToFedMailInbox(prop.getProperty("GMAIL_USERNAME2"), prop.getProperty("USERPASS"));
		String emailSubject = emailCheck.captureTitleFromLastEmail(0);
		String emailBody = emailCheck.captureEmailMessage(0);
		String emailToAndFrom = emailCheck.captureToAndFromInEmail();
		String emailXML = emailCheck.captureXML();

		System.out.println("subject" + emailSubject);
		System.out.println("body" + emailBody);
		System.out.println("from" + emailToAndFrom);
		System.out.println("XML" + emailXML);

		// asserting email subject
		Assert.assertEquals(true, emailSubject.contains(prop.getProperty("EMAIL_REGULAR_SENT_FROM")));
		System.out.println("" + "WORKED");
		Assert.assertEquals(true, emailSubject.contains(prop.getProperty("EMAIL_TITLE3")));
		System.out.println("" + "WORKED");

		// asserting email to and from address
		Assert.assertEquals(true, emailToAndFrom.contains(prop.getProperty("EMAIL_REGULAR_SENT_FROM_DOMAIN")));
		System.out.println("" + "WORKED");
		Assert.assertEquals(true, emailToAndFrom.contains(prop.getProperty("EMAIL_Troy")));
		System.out.println("" + "WORKED");
		// asserting the email body

		Assert.assertEquals(true, emailBody.contains(prop.getProperty("EMAIL_ACTION5")));
		System.out.println("" + "WORKED");
		Assert.assertEquals(true, emailBody.contains(prop.getProperty("DEPARTMENT2")));
		System.out.println("" + "WORKED");
		Assert.assertEquals(true, emailBody.contains(prop.getProperty("SUBTIER3")));
		System.out.println("" + "WORKED");
		Assert.assertEquals(true, emailXML.contains("TEST ONLY.xml"));
		System.out.println("" + "WORKEDXML");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class=\"aio UKr6le\"]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@role=\"checkbox\"]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\":4\"]/div/div[1]/div[1]/div/div/div[2]/div[3]")).click();
		Thread.sleep(1000);

		
	}

	@Then("^user should receive an email \\(DepartmentAdmin\\) with the proper message post move$")
	public void user_should_receive_an_email_DepartmentAdmin_with_the_proper_message_post_move() throws Exception {
		emailCheck.RefreshMail();
		////

		String emailSubject2 = emailCheck.captureTitleFromLastEmail(0);
		String emailBody2 = emailCheck.captureEmailMessage(0);
		String emailToAndFrom2 = emailCheck.captureToAndFromInEmail();

		System.out.println("subject" + emailSubject2);
		System.out.println("body" + emailBody2);
		System.out.println("from" + emailToAndFrom2);

		// asserting email subject SUPER

		// asserting email to and from address
		Assert.assertEquals(true, emailToAndFrom2.contains(prop.getProperty("EMAIL_REGULAR_SENT_FROM_DOMAIN")));
		System.out.println("" + "WORKED");
		Assert.assertEquals(false, emailToAndFrom2.contains(prop.getProperty("EMAIL_SuperAdmin")));
		System.out.println("" + "WORKED");
		Assert.assertEquals(true, emailToAndFrom2.contains(prop.getProperty("EMAIL_Dep")));
		System.out.println("" + "WORKED");
		// asserting the email body
		Assert.assertEquals(true, emailBody2.contains(prop.getProperty("EMAIL_REQUESTOR_NAME")));
		System.out.println("" + "WORKED");

		Assert.assertEquals(true, emailBody2.contains(prop.getProperty("EMAIL_ACTION4")));
		System.out.println("" + "WORKED");
		Assert.assertEquals(true, emailBody2.contains(prop.getProperty("DEPARTMENT2")));
		System.out.println("" + "WORKED");
		Assert.assertEquals(true, emailBody2.contains(prop.getProperty("SUBTIER3")));
		System.out.println("" + "WORKED");

		driver.findElement(By.xpath("//div[@class=\"aio UKr6le\"]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@role=\"checkbox\"]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\":4\"]/div/div[1]/div[1]/div/div/div[2]/div[3]")).click();
		Thread.sleep(1000);

		emailCheck.switchTabs(2);
	}


}
