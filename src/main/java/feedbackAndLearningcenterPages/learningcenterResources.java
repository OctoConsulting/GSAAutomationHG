package feedbackAndLearningcenterPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import util.TestBase;

public class learningcenterResources extends TestBase {

	
	@FindBy(xpath="//*[@id=\"main-container\"]/ng-component/page/div/div/div[2]/div[1]/sidebar/nav/ul/li[3]/a")
	WebElement Resources;
	@FindBy(xpath="//*[@id=\"main-container\"]/ng-component/page/div/div/div[2]/div[1]/sidebar/nav/ul/li[3]/ul/li[1]/a")
	WebElement Assistance;
	@FindBy(xpath="//*[@id=\"main-container\"]/ng-component/page/div/div/div[2]/div[2]/ng-component/div[2]/div[1]/div[2]/a")
	WebElement Chieffinancial;
	@FindBy(xpath="//*[@id=\"main-container\"]/ng-component/page/div/div/div[2]/div[2]/ng-component/div[2]/div[1]/div[4]/a")
	WebElement Beneiftfinder;
	@FindBy(xpath="//*[@id=\"main-container\"]/ng-component/page/div/div/div[2]/div[1]/sidebar/nav/ul/li[3]/ul/li[3]/a")
	WebElement Wagedeterminations;
	@FindBy(xpath="//*[@id=\"main-container\"]/ng-component/page/div/div/div[2]/div[2]/ng-component/div/div[2]/a")
	WebElement Servicecontract;
	@FindBy(xpath="//*[@id=\"main-container\"]/ng-component/page/div/div/div[2]/div[2]/ng-component/div/div[7]/a")
	WebElement Conformances;
	@FindBy(xpath="//a[@href=\"/help/partners\"]")
	WebElement Partners;
	@FindBy(xpath="//*[@id=\"main-container\"]/ng-component/page/div/div/div[2]/div[2]/ng-component/div[2]/div[4]/div/div/div[1]/a/img")
	WebElement Disaster;
	
	
	
	public learningcenterResources() {
		PageFactory.initElements(driver, this);

		}
public void Intoresources() throws InterruptedException {
	Resources.click();
	Thread.sleep(10000);
		}
public void Intoassistance () throws InterruptedException {
	Assistance.click();
	Thread.sleep(10000);
}
public void Intochieffinancial() throws InterruptedException {
	Chieffinancial.click();
	Thread.sleep(10000);
}
public void Intobeneiftfinder() throws InterruptedException {
	Beneiftfinder.click();
	Thread.sleep(10000);
}
public void Intowagedetermination() throws InterruptedException {
	Wagedeterminations.click();
	Thread.sleep(10000);
}
public void Intoservicecontract() throws InterruptedException {
	Servicecontract.click();
	Thread.sleep(10000);
}
public void Intoconformances() throws InterruptedException {
	Conformances.click();
	Thread.sleep(10000);
}
public void Intopartners() throws InterruptedException {
	Partners.click();
	Thread.sleep(10000);


}
public void Intodisaster() throws InterruptedException {
	Disaster.click();
	Thread.sleep(10000);





}
}