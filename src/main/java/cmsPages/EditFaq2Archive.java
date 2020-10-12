package cmsPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import util.TestBase;

public class EditFaq2Archive extends TestBase {
	@FindBy(xpath = "//span[text()='Archive']")
	WebElement dropdownarchived;
	@FindBy(xpath = "//div[text()='ARCHIVED']")
	WebElement validatearchived;
	@FindBy(xpath = "//span[text()='Unarchive']")
	WebElement dropdownunarchived;
	@FindBy(xpath = "//span[text()='Delete']")
	WebElement dropdowndelete;

// intializing the page objects/elements/
	// means DRIVER PLEASE INTILZE ALL THE GLOBAL VARIABLES ABOVE
	public EditFaq2Archive() {
		PageFactory.initElements(driver, this);
	}

	public void dropdownarchived() throws InterruptedException {
		Thread.sleep(1400);
		dropdownarchived.click();
	}

	public boolean isarchived() {
		return validatearchived.isDisplayed();
	}

	public void dropdownunarchived() throws InterruptedException {
		Thread.sleep(1400);
		dropdownunarchived.click();
	}

	public void deletegeneratedfaq() {

		dropdowndelete.click();
	}

}