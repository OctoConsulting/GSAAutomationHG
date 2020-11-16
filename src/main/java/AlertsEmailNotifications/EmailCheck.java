package AlertsEmailNotifications;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import util.TestBase;

public class EmailCheck extends TestBase{
	
	
	@FindBy(xpath = "//button[text()=' Create Office ']")
	WebElement CreateOfficeTab;	
	public EmailCheck() {
		PageFactory.initElements(driver, this);
	}

	
	public static ArrayList<String> tab_handles;
public static Logger logger = LoggerFactory.getLogger(EmailCheck.class);
	public void delay(int seconds) {
		try {
			TimeUnit.SECONDS.sleep(seconds);
		} catch (InterruptedException ex) {
		}
	}
	
	public void goToFedMailInbox(String username, String password) {
		delay(3);

	   
		((JavascriptExecutor) driver).executeScript("window.open('https://mail.google.com/')");
		delay(2);

		tab_handles = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tab_handles.get(tab_handles.size() - 1));
		delay(2);
		// if (nooffetch == 1) {
		driver.findElement(By.xpath("//*[@id=\"identifierId\"]")).sendKeys(username);
		delay(3);
		driver.findElement(By.id("identifierNext")).click();
		delay(3);
		driver.findElement(By.xpath("//*[@id=\"view_container\"]/div/div/div[2]/div/div[2]/div/div[1]/div/div/button")).click();
		delay(5);
		driver.findElement(By.xpath("//*[@class='gb_Ia gbii']")).click();
		delay(3);
		driver.findElement(By.xpath("//*[contains(text(),'Octotest Account3')]")).click();
		delay(5);
	}
	public String captureTitleFromLastEmail(int emailNo) {
		delay(3);
		List<WebElement> lastMail = driver.findElements(By.className("zA"));
		logger.info("The size of email list is - " + lastMail.size());
		String emailtitle = lastMail.get(emailNo).getText();
		logger.info(".................................................................................");
		logger.info("The email subject line is-- " + emailtitle);
		logger.info("..................................................................................");
		return emailtitle;
	}
	public void RefreshMail() throws InterruptedException {
		Thread.sleep(3000);


		
		TimeUnit.MINUTES.sleep(4);
	driver.navigate().refresh();

	Thread.sleep(3000);

	}
	
public String captureToAndFromInEmail() {

	String toandFrom = driver.findElement(By.className("gE")).getText();
	logger.info("The to and from text is---------" + toandFrom);
	delay(1);
	return toandFrom;
}
public String captureXML() throws InterruptedException {
	Thread.sleep(2000);
	((JavascriptExecutor) driver).executeScript("scroll(0,500)");
	String toandFrom = driver.findElement(By.className("aQH")).getText();
	logger.info("XML SAYS---------" + toandFrom);
	delay(1);
	return toandFrom;
}

public String captureEmailMessage(int emailNo) {
	List<WebElement> lastMail = driver.findElements(By.className("zA"));

	logger.info("The size of email list is - " + lastMail.size());
	lastMail.get(emailNo).click();

	String emailbody = driver.findElement(By.className("ii")).getText();
	logger.info("..................................................................................");
	logger.info("The email message is-- " + emailbody);
	logger.info("..................................................................................");
	delay(1);

	return emailbody;
}
public void navigateBack() {
	delay(1);
	driver.navigate().back();
	delay(1);
}
public void switchTabs(int i) {
	delay(1);
	tab_handles = new ArrayList<String>(driver.getWindowHandles());
	logger.info("The size of the tab array is ---- " + tab_handles.size());
	driver.switchTo().window(tab_handles.get(tab_handles.size() - i));
	delay(1);
}
public void intoOFFICECreation() throws InterruptedException {
	CreateOfficeTab.click();
	Thread.sleep(2000);
	
}
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	