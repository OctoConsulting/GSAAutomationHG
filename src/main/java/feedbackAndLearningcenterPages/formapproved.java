package feedbackAndLearningcenterPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import util.TestBase;

public class formapproved extends TestBase {





@FindBy(xpath="//button[@title=\"Provide Feedback\"]")
WebElement providefeedback;
@FindBy(xpath="//a[@title=\"Form Approved OMB#3090-0297 Exp. Date 07/31/2019\"]")
WebElement form;
@FindBy(xpath="//*[@id=\"sam-footer\"]/div/div/nav/ul/li[4]/ul/li[1]/a")
WebElement directlearningcenter;

public formapproved() {
PageFactory.initElements(driver, this);

}

public void clickingprovidefeedback() throws InterruptedException {
	Thread.sleep(1000);
	providefeedback.click();
	Thread.sleep(1000);
}

public void formapprovedenter() {
	form.click();
	
}
public void directlinktolearningcenter() {
	directlearningcenter.click();
}
}

