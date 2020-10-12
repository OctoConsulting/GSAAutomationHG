package feedbackAndLearningcenterPages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import util.TestBase;

public class learningcenterDatasets extends TestBase {
	@FindBy(xpath ="//*[@id=\"main-container\"]/ng-component/page/div/div/div[2]/div[1]/sidebar/nav/ul/li[2]/a")
	WebElement DataSets;
	@FindBy(xpath="//*[@id=\"main-container\"]/ng-component/page/div/div/div[2]/div[1]/sidebar/nav/ul/li[2]/ul/li[4]/a")
	WebElement EntityInformation;
	@FindBy(xpath="//*[@id=\"main-container\"]/ng-component/page/div/div/div[2]/div[1]/sidebar/nav/ul/li[2]/ul/li[5]/a")
	WebElement FH;
public learningcenterDatasets() {
	PageFactory.initElements(driver, this);
	}

public void Intodatasets() {
	DataSets.click();
}

public void Intoentityinfo() throws InterruptedException {
	EntityInformation.click();
	Thread.sleep(1000);
	((JavascriptExecutor) driver).executeScript("scroll(0,400)");
	
	
}
public void IntoFh() {
	FH.click();
}


}