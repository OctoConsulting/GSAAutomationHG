package login.govPages;

import org.jboss.aerogear.security.otp.Totp;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import util.TestBase;

public class loginGov extends TestBase {
	loginpage LoginPage;
	loginGov LoginGov;
	homepage Homepage;
	
	@FindBy(id = ("user_email"))
	WebElement Email;
	@FindBy(id = ("user_password"))
	WebElement Password;
	@FindBy(xpath="//input[@type=\"submit\"and @value=\"Sign in\"]")
	WebElement Next;
	@FindBy(className = ("btn-primary"))
	WebElement Submit;
	@FindBy(xpath="//h3[text()='Workspace']")
	WebElement Workspacevalidate;

	public loginGov() {
		PageFactory.initElements(driver, this);
	}

	public void enteremail(String accountname) throws InterruptedException {
		Email.sendKeys(accountname);
		Thread.sleep(30);

	}

	public void enterpassword(String pwd) throws InterruptedException {
		Password.sendKeys(pwd);
		Thread.sleep(30);
		
	}

	public void clicknextbutton() throws InterruptedException {
		Next.click();
		Thread.sleep(30);
	}

	public static String getotp(String secretkey) {
		// String secretkey = "6BSLNLLRH7HLJFMM"; // <- this 2FA secret key.

		Totp totp = new Totp(secretkey);
		return totp.now();

	}

	public static void enterOtp(String otp) throws InterruptedException {
		driver.findElement(By.id("code")).sendKeys(otp);
		Thread.sleep(30);
	}

	public void clickOtpSubmit() throws InterruptedException {
		Submit.click();
		Thread.sleep(30);

	}

	public void OnWorkspace() throws InterruptedException {
		Workspacevalidate.isDisplayed();
		Thread.sleep(30);

	}
	public void GeneralLogIn(String email, String password, String otp) throws InterruptedException {
		TestBase.Initial();
		LoginPage=new loginpage();
		LoginPage.validateloginpage();
		String actualTitle = driver.getTitle();
		System.out.println(actualTitle);
		// String expectedTitle = "beta.SAM.gov | Home";
		// Assert.assertEquals(expectedTitle, actualTitle);
		Thread.sleep(2000);
		LoginPage.tryingtosignin();
		Thread.sleep(2000);
		LoginPage.closealert();
		LoginGov = new loginGov();
		LoginGov.enteremail(email);
		LoginGov.enterpassword(password);
		LoginGov.clicknextbutton();
		String myotp = loginGov.getotp(otp);
		loginGov.enterOtp(myotp);
		LoginGov.clickOtpSubmit();
		Thread.sleep(2000);
		LoginGov.OnWorkspace();
	}
	public void GeneralLogIn2(String email, String password, String otp) throws InterruptedException {
		TestBase.Initial();
		LoginPage=new loginpage();
		LoginPage.validateloginpage();
		String actualTitle = driver.getTitle();
		System.out.println(actualTitle);
		// String expectedTitle = "beta.SAM.gov | Home";
		// Assert.assertEquals(expectedTitle, actualTitle);
		Thread.sleep(2000);
		LoginPage.tryingtosignin();
		Thread.sleep(2000);
		LoginPage.closealert();
		LoginGov = new loginGov();
		LoginGov.enteremail(email);
		LoginGov.enterpassword(password);
		LoginGov.clicknextbutton();
		String myotp = loginGov.getotp(otp);
		loginGov.enterOtp(myotp);
		LoginGov.clickOtpSubmit();
		Thread.sleep(2000);
		LoginGov.OnWorkspace();
	}
}