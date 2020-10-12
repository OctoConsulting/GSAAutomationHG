package FhPages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import util.TestBase;

public class FHorgPicker extends TestBase{

	@FindBy(xpath="/html/body/app/main/ng-component/div/div[2]/sam-agency-picker-v3/div[1]/div/div/sam-agency-selector/sam-label-wrapper/div/div[2]/div[2]/button")
	WebElement OrgPickerRadio;
	
	@FindBy(xpath="//table[@class=\"usa-table-borderless\"]")
	WebElement MainTable;
	@FindBy(id="dept-listbox")
	WebElement DepTable;
	@FindBy(id="dept")
	WebElement DEPT;
	@FindBy(xpath="//div[text()='097 - DEPARTMENT OF DEFENSE']")
	WebElement DEPTdod;
	@FindBy(xpath="//*[@id=\"subtier-resultItem-1\"]")
	WebElement SubtierArmy;
	@FindBy(id="subtier")
	WebElement SubtierTable;
	@FindBy(id="major")
	WebElement MajorCommand;
	@FindBy(id="subcomm")
	WebElement SubCommand;
	@FindBy(xpath="//div[text()='AMC - AMC']")
	WebElement MajorCommandChose;
	@FindBy(id="subcomm-resultItem-0")
	WebElement SubCommandChose;
	@FindBy(id="office")
	WebElement office;
	@FindBy(id="office-resultItem-0")
	WebElement officeChose;
	@FindBy(id="showInactive")
	WebElement inactive;
	@FindBy(xpath="//*[@id=\"main-container\"]/ng-component/div/div[2]/sam-agency-picker-v3/div[3]/sam-agency-modal/sam-modal/div[2]/div/div[1]/div/button")
	WebElement close;
	public static final By DeptLIST=By.xpath("//*[@id=\"dept-listbox\"]");
	public static final By Feed_Item100=By.xpath("//table[@class=\"usa-table-borderless\"]");
	public FHorgPicker() {
		PageFactory.initElements(driver, this);
	}
	public void GoToOrgPickerRadio() throws InterruptedException {
		OrgPickerRadio.click();
		Thread.sleep(3000);
		
	}
	public void EnterDept() throws InterruptedException {
		
		DEPT.sendKeys("Department of ");
		Thread.sleep(3000);
		
	}
	public void EnterDeptAsDOD() throws InterruptedException {
		DEPTdod.click();
		Thread.sleep(3000);
		
	}
	public void EnterInactive() throws InterruptedException {
		inactive.click();
		Thread.sleep(3000);
		
	}
	public void EnterSubtier() throws InterruptedException {
		SubtierTable.sendKeys("Army");
		Thread.sleep(3000);
		
	}
	public void ChooseArmy() throws InterruptedException {
		SubtierArmy.click();
		Thread.sleep(3000);
		
	}
	public void ChooseMC() throws InterruptedException {
		MajorCommand.click();
		Thread.sleep(3000);
		
	}
	public void ChooseMCFully() throws InterruptedException {
		MajorCommandChose.click();
		Thread.sleep(3000);
		
	}
	public void ChooseSCFully() throws InterruptedException {
		SubCommandChose.click();
		Thread.sleep(3000);
		
	}
	public void ChooseSC() throws InterruptedException {
		SubCommand.click();
		Thread.sleep(3000);
		
	}	public void ChooseOfficeFully() throws InterruptedException {
		officeChose.click();
		Thread.sleep(3000);
		
	}
	public void ChooseOffice() throws InterruptedException {
		office.click();
		Thread.sleep(3000);
		
	}
	public boolean L1Validation() {
		boolean verify;
		//VALIDATION FOR "YOU"
				WebElement locatorforWhereTEXTisPresent = driver.findElement(By.xpath(
						"//div[@class=\"agency-table\"]"));
		
				String Requesttext = locatorforWhereTEXTisPresent.getText();
		
				if (Requesttext.contains("DEPARTMENT OF DEFENSE"))  {
					verify = true;
				}
				
			else {
					verify = false;
						}
			
	System.out.println(Requesttext);
	return verify;
	}
	public boolean Inactive() {
		boolean verify;
		//VALIDATION FOR "YOU"
				WebElement locatorforWhereTEXTisPresent = driver.findElement(By.xpath(
						"//div[@class=\"agency-table\"]"));
		
				String Requesttext = locatorforWhereTEXTisPresent.getText();
		
				if (Requesttext.contains("*"))  {
					verify = true;
				}
				
			else {
					verify = false;
						}
			
	System.out.println(Requesttext);
	return verify;
	}
	
	public boolean L2Validation() {
		boolean verify;
		//VALIDATION FOR "YOU"
				WebElement locatorforWhereTEXTisPresent = driver.findElement(By.xpath(
						"//div[@class=\"agency-table\"]"));
		
				String Requesttext = locatorforWhereTEXTisPresent.getText();
		
				if (Requesttext.contains("DEPT OF THE ARMY"))  {
					verify = true;
				}
				
			else {
					verify = false;
						}
			
	System.out.println(Requesttext);
	return verify;
	}
	public boolean MCValidation() {
		boolean verify;
		//VALIDATION FOR "YOU"
				WebElement locatorforWhereTEXTisPresent = driver.findElement(By.xpath(
						"//div[@class=\"agency-table\"]"));
		
				String Requesttext = locatorforWhereTEXTisPresent.getText();
		
				if (Requesttext.contains("AMC"))  {
					verify = true;
				}
				
			else {
					verify = false;
						}
			
	System.out.println(Requesttext);
	return verify;
	}
	public boolean SCValidation() {
		boolean verify;
		//VALIDATION FOR "YOU"
				WebElement locatorforWhereTEXTisPresent = driver.findElement(By.xpath(
						"//div[@class=\"agency-table\"]"));
		
				String Requesttext = locatorforWhereTEXTisPresent.getText();
		
				if (Requesttext.contains("ACC"))  {
					verify = true;
				}
				
			else {
					verify = false;
						}
			
	System.out.println(Requesttext);
	return verify;
	}
	public boolean OfficeValidation() {
		boolean verify;
		//VALIDATION FOR "YOU"
				WebElement locatorforWhereTEXTisPresent = driver.findElement(By.xpath(
						"//div[@class=\"agency-table\"]"));
		
				String Requesttext = locatorforWhereTEXTisPresent.getText();
		
				if (Requesttext.contains("HQ A7K"))  {
					verify = true;
				}
				
			else {
					verify = false;
						}
			
	System.out.println(Requesttext);
	return verify;
	}


	public boolean negvalidationL2() {
		
		//VALIDATION FOR "YOU"
				WebElement locatorforWhereTEXTisPresent = driver.findElement(By.xpath(
						"//div[@class=\"agency-table\"]"));
		
				String Requesttext = locatorforWhereTEXTisPresent.getText();
		
				boolean verify;
				if (Requesttext.contains("Agency"))  {
					verify = false;
				}

				else {
					verify = true;
				}

				System.out.println(Requesttext);
				return verify;
			}



public boolean negvalidationMC() {
	
	//VALIDATION FOR "YOU"
			WebElement locatorforWhereTEXTisPresent = driver.findElement(By.xpath(
					"//div[@class=\"agency-table\"]"));
	
			String Requesttext = locatorforWhereTEXTisPresent.getText();
	
			boolean verify;
			if (Requesttext.contains("Agency")&& Requesttext.contains("Subtier")  )  {
				verify = false;
			}

			else {
				verify = true;
			}

			System.out.println(Requesttext);
			return verify;
		}

public boolean negvalidationSC() {
	
	//VALIDATION FOR "YOU"
			WebElement locatorforWhereTEXTisPresent = driver.findElement(By.xpath(
					"//div[@class=\"agency-table\"]"));
	
			String Requesttext = locatorforWhereTEXTisPresent.getText();
	
			boolean verify;
			if (Requesttext.contains("Agency")&& Requesttext.contains("Subtier")&& Requesttext.contains("Major Command"))  {
				verify = false;
			}

			else {
				verify = true;
			}

			System.out.println(Requesttext);
			return verify;
		}

public void closePICKER() {
	close.click();
}
}


















