package FhPages;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import util.TestBase;

public class CreateEditDep extends TestBase {
	static String randomDepTitle;
	static String randomCgac;
	@FindBy(xpath = "//button[text()='Create Dept/Ind Agency']")
	WebElement CreateDepAgencyLink;
	@FindBy(xpath = "//button[text()=' Create Sub-Tier ']")
	WebElement CreateSubtierAgencyLink;
	@FindBy(id = "orgName-input")
	WebElement DeptAgencyName;
	@FindBy(id="org-start-date month required. Enter Month Here")
	WebElement DeptAgencyStartDate;
	@FindBy(id="org-start-date month Enter Month Here")
	WebElement DeptAgencyStartDate2;
	@FindBy(id="org-start-date year required. Enter Year Here")
	WebElement DeptAgencyStartYear;
	@FindBy(id="org-start-date year Enter Year Here")
	WebElement DeptAgencyStartYear2;
	@FindBy(id="org-start-date day required. Enter Day Here")
	WebElement DeptAgencyStartDay;
	@FindBy(id="org-start-date day Enter Day Here")
	WebElement DeptAgencyStartDay2;
	@FindBy(id="org-end-date month Enter Month Here")
	WebElement DeptAgencyEndDate;
	@FindBy(id="org-end-date day Enter Day Here")
	WebElement DeptAgencyEndDate2;
	@FindBy(id="org-end-date year Enter Year Here")
	WebElement DeptAgencyEndDate3;
	@FindBy(id="description")
	WebElement DeptAgencyDesc;
	@FindBy(id = "fpds-input")
	WebElement DeptAgencyAC;
	@FindBy(id = "cgac-input")
	WebElement DeptAgencyCgac;
	@FindBy(id = "tas2-input")
	WebElement DeptAgencyTas;
	@FindBy(xpath = "//button[text()=' Confirm ']")
	WebElement DeptAgencyConfirm;
	@FindBy(xpath = "//button[text()=' Submit ']")
	WebElement DeptAgencySubmit;
	@FindBy(id = "cfda-input")
	WebElement DeptAgencyCfda;
	@FindBy(xpath = "//button[text()=' Edit ']")
	WebElement DeptAgencyEditConfirmation;
	@FindBy(id="editDetailsButton")
	WebElement EditSection;
	@FindBy(xpath = "//a[text()='Federal Hierarchy']")
	WebElement FHBreadcrumbLink;
	@FindBy(xpath = "//input[@aria-label=\"search federal hierarchy\"]")
	WebElement FHSearch;
	@FindBy(xpath = "//a[@class=\"federal-hierarchy-org-item-title\"]")
	WebElement FHSearchDepAgency;
	@FindBy(xpath = "//button[text()='Cancel']")
	WebElement CancelDepAgency;
	@FindBy(xpath = "//a[text()='Show More']")
	WebElement ShowMoreDepAgency;
	@FindBy(xpath = "//a[text()='Show Less']")
	WebElement ShowLessDepAgency;
	@FindBy(xpath = "//h3[text()='Success']")
	WebElement SucessBanner;
	@FindBy(xpath = "//h3[text()='Success!']")
	WebElement SucessBanner2;
	
	@FindBy(xpath = "//em[text()='No End Date Available']")
	WebElement EndDateValidation;
	@FindBy(id = "Inactive")
	WebElement inactivetab;
	@FindBy(xpath = " //button[text()=' Edit ']")
	WebElement edit;
	@FindBy(xpath = " //button[text()=' Edit']")
	WebElement edit2;
	@FindBy(xpath = "//span[text()=' All date fields are required ']")
	WebElement StartDateError;
	@FindBy(xpath = " //span[text()=' The start date cannot be after the end date. ']")
	WebElement StartDateError2;
	@FindBy(xpath = " //span[text()=' The start date cannot be moved forward from the existing start date. It can only be moved back. ']")
	WebElement StartDateError3;
	@FindBy(xpath = "//span[text()=' The end date cannot be earlier than or equal to the start date. ']")
	WebElement EndDateError1;
	@FindBy(xpath = "//span[text()=' The end date can only be moved forward once an end date is provided. ']")
	WebElement EndDateError2;
	@FindBy(xpath = "//span[text()=' There is a sub-tier organization that is still active under this department. Please end date it before you end date this department. ']")
	WebElement EndDateError3;
	@FindBy(xpath = "//span[text()=' There is an office that is still active under this department. Please end date it before you end date this department. ']")
	WebElement EndDateError4;
	@FindBy(xpath = "//span[text()=' There are 2 offices that are still active under this department. Please end date them before you end date this department. ']")
	WebElement EndDateError5;
	@FindBy(xpath = "//span[text()=' There is a sub-tier organization that is still active and there are 2 sub-tier organizations that are scheduled to be active under this department. Please end date them before you end date this department. ']")
	WebElement EndDateError6;
	@FindBy(xpath = "//span[text()=' There are 2 sub-tier organizations that are still active under this department. Please end date them before you end date this department. ']")
	WebElement EndDateError7;
	@FindBy(xpath = "//span[text()=' There are 3 offices that are still active and 2 offices that are scheduled to be active under this department. Please end date them before you end date this department. ']")
	WebElement EndDateError8;
	@FindBy(xpath = "//span[text()=' The end date can only be the current date or in the future. ']")
	WebElement EndDateError9;
	@FindBy(xpath="//a[text()='Workspace']")
	WebElement WorkspaceTab;
	public CreateEditDep() {
		PageFactory.initElements(driver, this);
	}

	public void intoCreateDeptAgency() throws InterruptedException {
		CreateDepAgencyLink.click();
		Thread.sleep(2000);

	}

	public boolean IsCreateDeptThere() throws InterruptedException {
		return CreateDepAgencyLink.isDisplayed();
	}
	public boolean IsCreateSubtierThere() throws InterruptedException {
		return CreateSubtierAgencyLink.isDisplayed();
	}
	public void CreateDeptForEvents() throws InterruptedException {
		((JavascriptExecutor) driver).executeScript("scroll(0,200)");
		Random rand = new Random();
		float result = rand.nextFloat();
		randomDepTitle = "Test Department for events page " + result;

		DeptAgencyName.sendKeys(randomDepTitle);
		Thread.sleep(1000);

		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy ");

		// get current date time with Date()
		Date date = new Date();

		// Now format the date
		String StartDate = dateFormat.format(date);

		// Print the Date
		System.out.println(StartDate);
		

		
		
		Calendar c = Calendar.getInstance();
        c.setTime(date);

     
	
		Thread.sleep(1000);
        
        
        
    c.add(Calendar.DATE, -1);

    // convert calendar to date
    Date currentDatePlusOne = c.getTime();
  
    DeptAgencyStartDate.sendKeys(dateFormat.format(currentDatePlusOne));
    System.out.println(dateFormat.format(currentDatePlusOne));
    DeptAgencyEndDate.sendKeys((StartDate));	
		((JavascriptExecutor) driver).executeScript("scroll(0,400)");
		DeptAgencyDesc.sendKeys(
				"This set of data is for testing purposes will be deleted later [{\"id\":\"0000001\",\"name\":\"Tidy Town Taxis\" },\r\n"
						+ " {\"id\":\"0000002\",\"name\":\"Paul's Popular Pizzeria\" },\r\n"
						+ " {\"id\":\"0000003\",\"name\":\"Costalotta Coffee Shop\" }] 000003\",\"name\":\"Costalotta Coffee Shop\" },\r\n"
						+ "  {\"id\":\"0000004\",\"name\":\"Hey guess what, this is fake data\" },\r\n"
						+ "  {\"id\":\"0000005\",\"name\":\"And this is also fake data\" },\r\n"
						+ "  {\"id\":\"0000006\",\"name\":\"This data was made up\" },\r\n"
						+ "  {\"id\":\"0000007\",\"name\":\"But the app thinks it's real\" }]000003\",\"name\":\"Costalotta Coffee Shop\" },\r\n"
						+ "  {\"id\":\"0000004\",\"name\":\"Hey guess what, this is fake data\" },\r\n"
						+ "  {\"id\":\"0000005\",\"name\":\"And this is also fake data\" },\r\n"
						+ "  {\"id\":\"0000006\",\"name\":\"This data was made up\" },\r\n"
						+ "  {\"id\":\"0000007\",\"name\":\"But the app thinks it's real\" }]");

		int x = rand.nextInt(900) + 100;
		String randomAC = "o" + x;

		DeptAgencyAC.sendKeys(randomAC);
		int y = rand.nextInt(900) + 100;
		randomCgac = "" + y;

		DeptAgencyCgac.sendKeys(randomCgac);
		Thread.sleep(1000);
		((JavascriptExecutor) driver).executeScript("scroll(0,300)");

		int z = rand.nextInt(900) + 100;

		String randomTAS = "" + z;
		DeptAgencyTas.sendKeys(randomTAS);
		DeptAgencyConfirm.click();
		Thread.sleep(3000);
		DeptAgencyEditConfirmation.click();
		Thread.sleep(2000);
		DeptAgencyCfda.sendKeys("10");
		DeptAgencyConfirm.click();
		Thread.sleep(3000);
		DeptAgencySubmit.click();
		// Thread.sleep(3000);

	}

	public void CreateDept() throws InterruptedException {
		((JavascriptExecutor) driver).executeScript("scroll(0,200)");
		Random rand = new Random();
		float result = rand.nextFloat();
		randomDepTitle = "Test Department " + result;

		DeptAgencyName.sendKeys(randomDepTitle);
		Thread.sleep(1000);

		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy ");

		// get current date time with Date()
		Date date = new Date();

		// Now format the date
		String StartDate = dateFormat.format(date);

		// Print the Date
		System.out.println(StartDate);
		DeptAgencyStartDate.sendKeys(StartDate);
		Thread.sleep(1000);

		((JavascriptExecutor) driver).executeScript("scroll(0,400)");
		DeptAgencyDesc.sendKeys(
				"This set of data is for testing purposes will be deleted later [{\"id\":\"0000001\",\"name\":\"Tidy Town Taxis\" },\r\n"
						+ " {\"id\":\"0000002\",\"name\":\"Paul's Popular Pizzeria\" },\r\n"
						+ " {\"id\":\"0000003\",\"name\":\"Costalotta Coffee Shop\" }] 000003\",\"name\":\"Costalotta Coffee Shop\" },\r\n"
						+ "  {\"id\":\"0000004\",\"name\":\"Hey guess what, this is fake data\" },\r\n"
						+ "  {\"id\":\"0000005\",\"name\":\"And this is also fake data\" },\r\n"
						+ "  {\"id\":\"0000006\",\"name\":\"This data was made up\" },\r\n"
						+ "  {\"id\":\"0000007\",\"name\":\"But the app thinks it's real\" }]000003\",\"name\":\"Costalotta Coffee Shop\" },\r\n"
						+ "  {\"id\":\"0000004\",\"name\":\"Hey guess what, this is fake data\" },\r\n"
						+ "  {\"id\":\"0000005\",\"name\":\"And this is also fake data\" },\r\n"
						+ "  {\"id\":\"0000006\",\"name\":\"This data was made up\" },\r\n"
						+ "  {\"id\":\"0000007\",\"name\":\"But the app thinks it's real\" }]");

		int x = rand.nextInt(900) + 100;
		String randomAC = "S" + x;

		DeptAgencyAC.sendKeys(randomAC);
		int y = rand.nextInt(900) + 100;
		randomCgac = "" + y;

		DeptAgencyCgac.sendKeys(randomCgac);
		Thread.sleep(1000);
		((JavascriptExecutor) driver).executeScript("scroll(0,300)");

		int z = rand.nextInt(900) + 100;

		String randomTAS = "" + z;
		DeptAgencyTas.sendKeys(randomTAS);
		DeptAgencyConfirm.click();
		Thread.sleep(3000);
		DeptAgencyEditConfirmation.click();
		Thread.sleep(2000);
		DeptAgencyCfda.sendKeys("10");
		DeptAgencyConfirm.click();
		Thread.sleep(3000);
		DeptAgencySubmit.click();
		// Thread.sleep(3000);

	}

	public boolean isSuccessBannerThere() {
		return SucessBanner.isDisplayed();
	}
	public boolean isSuccessBannerThere2() {
		return SucessBanner2.isDisplayed();
	}
	public void TestingStartDate1() throws InterruptedException {
		Thread.sleep(2000);

		edit.click();
		Thread.sleep(4000);
		((JavascriptExecutor) driver).executeScript("scroll(0,-700)");
		Thread.sleep(2000);

		DeptAgencyStartDay.clear();
		Thread.sleep(2000);

		DeptAgencyStartDate.clear();
		Thread.sleep(2000);

		DeptAgencyStartYear.clear();
		Thread.sleep(2000);

		((JavascriptExecutor) driver).executeScript("scroll(0,1800)");

		DeptAgencyConfirm.click();

		Thread.sleep(2000);
	
	}
	public void TestingStartDate2() throws InterruptedException {
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy ");

		Date date = new Date();
		String EndDate = dateFormat.format(date);
		
		// Now format the date
		String StartDate = dateFormat.format(date);

		DeptAgencyEndDate.sendKeys(StartDate);
		
		Calendar c = Calendar.getInstance();
        c.setTime(date);

        // manipulate date
      
    c.add(Calendar.DATE, +2);

    // convert calendar to date
    Date currentDatePlusTwo = c.getTime();

    DeptAgencyStartDate.sendKeys(dateFormat.format(currentDatePlusTwo));
		
	Thread.sleep(2000);

	((JavascriptExecutor) driver).executeScript("scroll(0,1800)");

	DeptAgencyConfirm.click();

	Thread.sleep(2000);

		
	}
	public void TestingStartDate3() throws InterruptedException {
		DeptAgencyStartDate.clear();
		DeptAgencyStartDay.clear();
		
		DeptAgencyStartYear.clear();
		DeptAgencyEndDate.clear();
		DeptAgencyEndDate2.clear();
		DeptAgencyEndDate3.clear();
		Thread.sleep(2000);
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy ");

		// get current date time with Date()
		Date date = new Date();

		// Now format the date
		String StartDate = dateFormat.format(date);

		DeptAgencyStartDate.sendKeys(StartDate);
		Thread.sleep(2000);

		((JavascriptExecutor) driver).executeScript("scroll(0,1800)");

		DeptAgencyConfirm.click();

			Thread.sleep(2000);
			((JavascriptExecutor) driver).executeScript("scroll(0,1800)");

			DeptAgencyConfirm.click();

				Thread.sleep(4000);
	}
	public void TestingStartDate4() throws InterruptedException {
		edit2.click();
		Thread.sleep(2000);

		DeptAgencyStartDate.clear();
		DeptAgencyStartDay.clear();
		
		DeptAgencyStartYear.clear();
		DeptAgencyEndDate.clear();
		DeptAgencyEndDate2.clear();
		DeptAgencyEndDate3.clear();
		Thread.sleep(2000);
	
		Thread.sleep(2000);
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy ");

		// get current date time with Date()
		Date date = new Date();

		// Now format the date
		String StartDate = dateFormat.format(date);
		Calendar c = Calendar.getInstance();
        c.setTime(date);

        // manipulate date
      
    c.add(Calendar.DATE, +2);

    // convert calendar to date
    Date currentDatePlusTwo = c.getTime();

    DeptAgencyStartDate.sendKeys(dateFormat.format(currentDatePlusTwo));
		
		Thread.sleep(2000);

		((JavascriptExecutor) driver).executeScript("scroll(0,300)");
		DeptAgencySubmit.click();
		Thread.sleep(4000);
		((JavascriptExecutor) driver).executeScript("scroll(0,300)");
		DeptAgencyDesc.click();
		Thread.sleep(2000);
		DeptAgencyEndDate.clear();
		Thread.sleep(2000);
		DeptAgencyEndDate2.clear();
		Thread.sleep(2000);
		DeptAgencyEndDate3.clear();
		DeptAgencyEndDate3.click();
		Thread.sleep(2000);
		DeptAgencySubmit.click();
		
		Thread.sleep(2000);

			
	}
	public void TestingStartDate5() throws InterruptedException {
		DeptAgencyStartDate.clear();
		DeptAgencyStartDay.clear();
		
		DeptAgencyStartYear.clear();
	
		Thread.sleep(2000);
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy ");

		// get current date time with Date()
		Date date = new Date();

		// Now format the date
		String StartDate = dateFormat.format(date);

		DeptAgencyStartDate.sendKeys(StartDate);
		Thread.sleep(2000);

		((JavascriptExecutor) driver).executeScript("scroll(0,1800)");

		DeptAgencySubmit.click();

			Thread.sleep(2000);
	}
	public void TestingEndDate1() throws InterruptedException {
		Thread.sleep(2000);

		edit.click();
		((JavascriptExecutor) driver).executeScript("scroll(0,-700)");

		DeptAgencyEndDate.clear();
		DeptAgencyEndDate2.clear();
		DeptAgencyEndDate3.clear();

		DeptAgencyEndDate.sendKeys("01102019");
		Thread.sleep(2000);

		((JavascriptExecutor) driver).executeScript("scroll(0,1800)");

		DeptAgencyConfirm.click();

			Thread.sleep(2000);
		
	}
	public void TestingEndDate2() throws InterruptedException {
		Thread.sleep(2000);
		DeptAgencyEndDate.clear();
		DeptAgencyEndDate2.clear();
		DeptAgencyEndDate3.clear();
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy ");

		Date date = new Date();
		String EndDate = dateFormat.format(date);
		

		
		Calendar c = Calendar.getInstance();
        c.setTime(date);

        // manipulate date
      
    c.add(Calendar.DATE, +1);

    // convert calendar to date
    Date currentDatePlusOne = c.getTime();

    System.out.println(dateFormat.format(currentDatePlusOne));
    DeptAgencyEndDate.sendKeys(dateFormat.format(currentDatePlusOne));
    DeptAgencyConfirm.click();

	
    ((JavascriptExecutor) driver).executeScript("scroll(0,300)");
	Thread.sleep(1000);
 	Thread.sleep(4000);
 	DeptAgencySubmit.click();

 	Thread.sleep(2000);
 	
	}
	public void TestingEndDate3() throws InterruptedException {
		Thread.sleep(2000);
		DeptAgencyEndDate.clear();
		DeptAgencyEndDate2.clear();
		DeptAgencyEndDate3.clear();
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy ");

		Date date = new Date();
		String EndDate = dateFormat.format(date);
		

		
		Calendar c = Calendar.getInstance();
        c.setTime(date);

        // manipulate date
      
    c.add(Calendar.DATE, +1);

    // convert calendar to date
    Date currentDatePlusOne = c.getTime();

    System.out.println(dateFormat.format(currentDatePlusOne));
    DeptAgencyEndDate.sendKeys(dateFormat.format(currentDatePlusOne));
    DeptAgencyConfirm.click();
	

	Thread.sleep(4000);
	DeptAgencySubmit.click();

	Thread.sleep(2000);
	
	}
	public void TestingEndDate4() throws InterruptedException {
		Thread.sleep(2000);

		edit2.click();
		Thread.sleep(2000);
		DeptAgencyEndDate.clear();
		DeptAgencyEndDate2.clear();
		DeptAgencyEndDate3.clear();

		DeptAgencyEndDate.sendKeys("01102019");
		Thread.sleep(2000);

		((JavascriptExecutor) driver).executeScript("scroll(0,500)");

		DeptAgencySubmit.click();

			Thread.sleep(2000);
		
	}
	public void TestingEndDate5() throws InterruptedException {
		Thread.sleep(2000);
		DeptAgencyEndDate.clear();
		DeptAgencyEndDate2.clear();
		DeptAgencyEndDate3.clear();
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy ");

		Date date = new Date();
		String EndDate = dateFormat.format(date);
		

		
		Calendar c = Calendar.getInstance();
        c.setTime(date);

        // manipulate date
      
    c.add(Calendar.DATE, +2);

    // convert calendar to date
    Date currentDatePlusOne = c.getTime();

    System.out.println(dateFormat.format(currentDatePlusOne));
    DeptAgencyEndDate.sendKeys(dateFormat.format(currentDatePlusOne));
    ((JavascriptExecutor) driver).executeScript("scroll(0,300)");


 	Thread.sleep(4000);
 	DeptAgencySubmit.click();

 	Thread.sleep(2000);
 	
	}
	public void TestingEndDate6() throws InterruptedException {
		Thread.sleep(2000);
		edit2.click();
		Thread.sleep(2000);
		DeptAgencyEndDate.clear();
		DeptAgencyEndDate2.clear();
		DeptAgencyEndDate3.clear();
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy ");

		Date date = new Date();
		String EndDate = dateFormat.format(date);
		

		
		Calendar c = Calendar.getInstance();
        c.setTime(date);

        // manipulate date
      
    c.add(Calendar.DATE, +1);

    // convert calendar to date
    Date currentDatePlusOne = c.getTime();

    System.out.println(dateFormat.format(currentDatePlusOne));
    DeptAgencyEndDate.sendKeys(dateFormat.format(currentDatePlusOne));
    ((JavascriptExecutor) driver).executeScript("scroll(0,300)");


 	Thread.sleep(4000);
 	DeptAgencySubmit.click();
		
	}
	public void ViewProfileDepAgency() throws InterruptedException {
		((JavascriptExecutor) driver).executeScript("scroll(0,300)");
		Thread.sleep(1000);

		boolean verify;
		// VALIDATION FOR "YOU"
		WebElement locatorforWhereTEXTisPresent = driver
				.findElement(By.xpath("/html/body/app/main/ng-component/div"));

		String Requesttext = locatorforWhereTEXTisPresent.getText();

		if (Requesttext.contains("Show More")) {
			verify = true;
		}

		else {
			verify = false;
		}

		System.out.println(Requesttext);
		Thread.sleep(6000);
		ShowMoreDepAgency.click();
		Thread.sleep(2000);

		// VALIDATION FOR "YOU"
		WebElement locatorforWhereTEXTisPresentt = driver
				.findElement(By.xpath("/html/body/app/main/ng-component/div"));

		String Requesttextt = locatorforWhereTEXTisPresentt.getText();

		if (Requesttextt.contains("Show Less")) {
		}

		else {
		}

		System.out.println(Requesttext);
		//TODO
		//ShowLessDepAgency.click();
		Thread.sleep(2000);
	}

	public void EditDepAgency() throws InterruptedException {
		// DO VALIDATION THAT IS SAYS SHOW MORE ETC
		EditSection.click();
		Thread.sleep(4000);
		DeptAgencyDesc.clear();
		Thread.sleep(4000);
		DeptAgencyDesc.sendKeys("Data will be deleted");
		Thread.sleep(4000);
		DeptAgencySubmit.click();
		Thread.sleep(2000);
	}
	public void AddEndDate() throws InterruptedException {
		Thread.sleep(3000);
		// DO VALIDATIONS THAT SHOW MORE IS NOT THERE
		((JavascriptExecutor) driver).executeScript("scroll(0,-3800)");
		FHBreadcrumbLink.click();
		Thread.sleep(2000);
		FHSearch.sendKeys(randomDepTitle);
		FHSearch.sendKeys(Keys.ENTER);
		FHSearchDepAgency.click();
		Thread.sleep(1000);
		driver.navigate().refresh();
		Thread.sleep(2000);
		EditSection.click();
		Thread.sleep(2000);

		((JavascriptExecutor) driver).executeScript("scroll(0,300)");

		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy ");

		Date date = new Date();
		String EndDate = dateFormat.format(date);
		

		
		Calendar c = Calendar.getInstance();
        c.setTime(date);

        // manipulate date
      
    c.add(Calendar.DATE, +1);

    // convert calendar to date
    Date currentDatePlusOne = c.getTime();

    System.out.println(dateFormat.format(currentDatePlusOne));
    DeptAgencyEndDate.sendKeys(dateFormat.format(currentDatePlusOne));
		DeptAgencySubmit.click();
	
		Thread.sleep(3000);

	}


	public void EditCodes() throws InterruptedException {
		((JavascriptExecutor) driver).executeScript("scroll(0,3500)");
		driver.findElement(By.xpath("//*[@id=\"editCodesButton\"]"))
				.click();
		DeptAgencyCgac.clear();

		DeptAgencyCgac.sendKeys(randomCgac);
		DeptAgencyAC.clear();
		Random rand = new Random();
		int x = rand.nextInt(900) + 100;
		String randomAC = "o" + x;

		DeptAgencyAC.sendKeys(randomAC);
		
		Thread.sleep(3000);
		DeptAgencySubmit.click();
		Thread.sleep(3000);

	}

	public boolean isEndDateThere() {
		try {
			return EndDateValidation.isDisplayed();
		} catch (Exception ex) {
			System.out.println("working as desired");
		}
		return false;
	}

	public void ValidateEndDateEdit() throws InterruptedException {
		((JavascriptExecutor) driver).executeScript("scroll(0,-500)");
		FHBreadcrumbLink.click();

		Thread.sleep(2000);

		FHSearch.sendKeys(randomDepTitle);

		FHSearch.sendKeys(Keys.ENTER);
		((JavascriptExecutor) driver).executeScript("scroll(0,500)");
		inactivetab.click();
		Thread.sleep(2000);
		FHSearchDepAgency.click();
		Thread.sleep(1000);
	}

	public void negCreateDepAgency() throws InterruptedException {
		// ((JavascriptExecutor) driver).executeScript("scroll(0,-500)");
		// FHBreadcrumbLink.click();
		CreateDepAgencyLink.click();
		((JavascriptExecutor) driver).executeScript("scroll(0,2000)");
		DeptAgencyConfirm.click();
		Thread.sleep(2000);
	}

	public void negCreateDepAgency2() throws InterruptedException {
		Random rand = new Random();
		float result = rand.nextFloat();
		randomDepTitle = "Test Department " + result;

		DeptAgencyName.sendKeys(randomDepTitle);
		Thread.sleep(1000);

		((JavascriptExecutor) driver).executeScript("scroll(0,20" + "00)");
		DeptAgencyConfirm.click();

		Thread.sleep(4000);
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy ");

		// get current date time with Date()
		Date date = new Date();

		// Now format the date
		String StartDate = dateFormat.format(date);

		// Print the Date
		System.out.println(StartDate);
		// DeptAgencyStartDate.sendKeys("11/11/2011");
		Thread.sleep(1000);
		((JavascriptExecutor) driver).executeScript("scroll(0,20" + "00)");
		DeptAgencyConfirm.click();
		DeptAgencyStartDate.clear();

		DeptAgencyStartDate.sendKeys(StartDate);
		Thread.sleep(1000);
		((JavascriptExecutor) driver).executeScript("scroll(0,20" + "00)");
		DeptAgencyConfirm.click();

		Thread.sleep(4000);

		DeptAgencyDesc.sendKeys("This set of data is for testing purposes will be deleted later");
		((JavascriptExecutor) driver).executeScript("scroll(0,20" + "00)");
		DeptAgencyConfirm.click();
	}

	public void negCreateDepAgency3() throws InterruptedException {

		Thread.sleep(4000);
		Random rand = new Random();
		int x = rand.nextInt(900) + 100;
		String randomAC = "z" + x;

		DeptAgencyAC.sendKeys(randomAC);
		DeptAgencyConfirm.click();
		Thread.sleep(4000);
		DeptAgencyCgac.sendKeys("B34");
		DeptAgencyConfirm.click();
		Thread.sleep(3000);
	}

	public void negCreateDepAgency4() throws InterruptedException {
		Random rand = new Random();
		int y = rand.nextInt(900) + 100;
		randomCgac = "" + y;
		DeptAgencyCgac.clear();

		DeptAgencyCgac.sendKeys(randomCgac);
		Thread.sleep(1000);

		((JavascriptExecutor) driver).executeScript("scroll(0,300)");
		Thread.sleep(1000);
		DeptAgencyConfirm.click();
		Thread.sleep(1000);
	}

	public void negCreateDepAgency5() throws InterruptedException {
		DeptAgencyTas.sendKeys("L66");
		DeptAgencyConfirm.click();
		Thread.sleep(2000);
	}

	public void negCreateDepAgency6() throws InterruptedException {
		Random rand = new Random();
		int z = rand.nextInt(900) + 100;

		String randomTAS = "" + z;
		DeptAgencyTas.clear();
		DeptAgencyTas.sendKeys(randomTAS);

		Thread.sleep(3000);
		DeptAgencyConfirm.click();

		Thread.sleep(4000);
	}

	public void negCreateDepAgency7() throws InterruptedException {
	//	DeptAgencySubmit.click();
		Thread.sleep(5000);

		edit2.click();
		Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("scroll(0,300)");
		DeptAgencyDesc.clear();
		Thread.sleep(8000);
		DeptAgencyDesc.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("scroll(0,2000)");
		DeptAgencySubmit.click();
		Thread.sleep(4000);
		((JavascriptExecutor) driver).executeScript("scroll(0,2000)");
	}

	public void negCreateDepAgency8() throws InterruptedException {
		//((JavascriptExecutor) driver).executeScript("scroll(0,-400)");
		DeptAgencyStartDate.clear();
		Thread.sleep(4000);
		DeptAgencyStartDay.clear();
		Thread.sleep(4000);
		DeptAgencyStartYear.clear();
		Thread.sleep(11000);
		DeptAgencyStartDate.sendKeys("11/11/2030");
		Thread.sleep(4000);
		DeptAgencyDesc.sendKeys("Negative Test");
		((JavascriptExecutor) driver).executeScript("scroll(0,2000)");
		Thread.sleep(2000);
		DeptAgencySubmit.click();
		Thread.sleep(4000);

	}

	public void negCreateDepAgency9() throws InterruptedException {
		driver.findElement(By.xpath("//button[text()=' Edit']")).click();
		Thread.sleep(3000);
		((JavascriptExecutor) driver).executeScript("scroll(0,500)");
		Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("scroll(0,2000)");
		CancelDepAgency.click();
		Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("scroll(0,-500)");

	}

	public boolean NEGValidation1() {
		boolean verify;

		// VALIDATION FOR "YOU"
		WebElement locatorforWhereTEXTisPresentt5 = driver.findElement(By.xpath(
				"//*[@id=\"main-container\"]/ng-component/div/div/div[2]/create-org-form/div/div[2]/div/div[1]/form/section"));

		String Requesttext = locatorforWhereTEXTisPresentt5.getText();

		if (Requesttext.contains("Department/Ind. Agency name field is required.")) {
			verify = true;
		}

		else {
			verify = false;
		}

		System.out.println(Requesttext);
		return verify;
	}
	public boolean NEGValidationTas() throws InterruptedException {
		Thread.sleep(3000);
		((JavascriptExecutor) driver).executeScript("scroll(0,1500)");
		Thread.sleep(2000);
		boolean verify;

		// VALIDATION FOR "YOU"
		WebElement locatorforWhereTEXTisPresentt5 = driver.findElement(By.xpath(
				"//*[@id=\"main-container\"]/ng-component/div/div/div[2]/create-org-form/div/div[2]/div/div[2]/section/form/sam-text[4]"));

		String Requesttext = locatorforWhereTEXTisPresentt5.getText();

		if (Requesttext.contains("TAS2 code is required.")) {
			verify = true;
		}

		else {
			verify = false;
		}

		System.out.println(Requesttext);
		return verify;
	}
	public boolean NEGValidationCgac() throws InterruptedException {
		Thread.sleep(3000);
		((JavascriptExecutor) driver).executeScript("scroll(0,1200)");
		Thread.sleep(2000);
		boolean verify;

		// VALIDATION FOR "YOU"
		WebElement locatorforWhereTEXTisPresentt5 = driver.findElement(By.xpath(
				"//*[@id=\"main-container\"]/ng-component/div/div/div[2]/create-org-form/div/div[2]/div/div[2]/section/form/sam-text[1]"));

		String Requesttext = locatorforWhereTEXTisPresentt5.getText();

		if (Requesttext.contains("FPDS code is required.")) {
			verify = true;
		}

		else {
			verify = false;
		}

		System.out.println(Requesttext);
		return verify;
	}

	public boolean NEGValidation4() {
		boolean verify;

		// VALIDATION FOR "YOU"
		WebElement locatorforWhereTEXTisPresentt5 = driver.findElement(By.xpath(
				"//*[@id=\"main-container\"]/ng-component/div/div/div[2]/page/div/div/div[2]/div/create-org-form/div/div[2]/div/div[1]/form/div[1]"));

		String Requesttext = locatorforWhereTEXTisPresentt5.getText();

		if (Requesttext.contains("Start Date cannot be before today's date.")) {
			verify = true;
		}

		else {
			verify = false;
		}

		System.out.println(Requesttext);
		return verify;
	}

	public boolean NEGValidation3() {
		boolean verify;

		// VALIDATION FOR "YOU"
		WebElement locatorforWhereTEXTisPresentt5 = driver.findElement(By.xpath(
				"//*[@id=\"description-error\"]"));

		String Requesttext = locatorforWhereTEXTisPresentt5.getText();

		if (Requesttext.contains("This field cannot be empty.")) {
			verify = true;
		}

		else {
			verify = false;
		}

		System.out.println(Requesttext);
		return verify;
	}

	public boolean NegValidation2() {
		boolean verify;

		// VALIDATION FOR "YOU"
		WebElement locatorforWhereTEXTisPresentt5 = driver.findElement(By.xpath(
				"//*[@id=\"main-container\"]/ng-component/div/div/div[2]/create-org-form/div/div[2]/div/div[2]/section/form/sam-text[4]"));

		String Requesttext = locatorforWhereTEXTisPresentt5.getText();

		if (Requesttext.contains("Please enter only numbers")) {
			verify = true;
		}

		else {
			verify = false;
		}

		System.out.println(Requesttext);
		return verify;
	}

	public void CreateDeptAgency() throws InterruptedException {
		((JavascriptExecutor) driver).executeScript("scroll(0,200)");
		Random rand = new Random();
		float result = rand.nextFloat();
		String randomDepTitle = "Test Department "  +result;
		DeptAgencyName.sendKeys(randomDepTitle);
	
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy ");
		 
		 //get current date time with Date()
		 Date date = new Date();
		 
		 // Now format the date
		 String date1= dateFormat.format(date);
		 
		 // Print the Date
		 System.out.println(date1);
		 DeptAgencyStartDate.sendKeys(date1);
	
			((JavascriptExecutor) driver).executeScript("scroll(0,400)");
			DeptAgencyDesc.sendKeys("This set of data is for testing purposes will be deleted later");
			
			 int x = rand.nextInt(900) + 100;
				String randomAC = "B"+x;
				
				DeptAgencyAC.sendKeys(randomAC);
		 int y = rand.nextInt(900) + 100;
			String randomCgac = ""+y;
			
			DeptAgencyCgac.sendKeys(randomCgac);
			((JavascriptExecutor) driver).executeScript("scroll(0,300)");
			
			 int z  = rand.nextInt(900) + 100;
			
				String randomTAS=""+z;
				DeptAgencyTas.sendKeys(randomTAS);
	}
	public boolean StartDateValidation() throws InterruptedException {
		Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("scroll(0,700)");
		Thread.sleep(2000);
		try {

			return StartDateError.isDisplayed();
		} catch (Exception ex) {
			System.out.println("working as desired");
		}
		return false;
	}

	public boolean StartDateValidation2() throws InterruptedException {
		Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("scroll(0,700)");
		Thread.sleep(2000);
		try {

			return StartDateError2.isDisplayed();
		} catch (Exception ex) {
			System.out.println("working as desired");
		}
		return false;
	}
	public boolean StartDateValidation3() throws InterruptedException {
		Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("scroll(0,700)");
		Thread.sleep(2000);
		try {

			return StartDateError3.isDisplayed();
		} catch (Exception ex) {
			System.out.println("working as desired");
		}
		return false;
	}
	public boolean EndDateValidation1() throws InterruptedException {
		Thread.sleep(9000);
		((JavascriptExecutor) driver).executeScript("scroll(0,600)");

		Thread.sleep(2000);
		try {

			return EndDateError1.isDisplayed();
		} catch (Exception ex) {
			System.out.println("working as desired");
		}
		return false;
	}
	public boolean EndDateValidation2() throws InterruptedException {
		Thread.sleep(9000);
		((JavascriptExecutor) driver).executeScript("scroll(0,600)");

		Thread.sleep(2000);
		try {

			return EndDateError2.isDisplayed();
		} catch (Exception ex) {
			System.out.println("working as desired");
		}
		return false;
	}
	public void intoDept1() throws InterruptedException {
		FHBreadcrumbLink.click();
		Thread.sleep(3000);
		FHSearch.sendKeys("Action Test 1");
		FHSearch.sendKeys(Keys.ENTER);
		FHSearchDepAgency.click();
		Thread.sleep(1000);

	}
	public void TestingEndDate7() throws InterruptedException {
		edit2.click();
		Thread.sleep(2000);
		DeptAgencyEndDate.clear();
		DeptAgencyEndDate2.clear();
		DeptAgencyEndDate3.clear();
		Thread.sleep(2000);
	
		DeptAgencyEndDate.sendKeys("03212022");
		Thread.sleep(2000);

		((JavascriptExecutor) driver).executeScript("scroll(0,300)");
		Thread.sleep(2000);
		DeptAgencySubmit.click();
		Thread.sleep(6000);

		((JavascriptExecutor) driver).executeScript("scroll(0,-400)");

	}
	public boolean EndDateValidation3() throws InterruptedException {
		Thread.sleep(2000);
		try {

			return EndDateError3.isDisplayed();
		} catch (Exception ex) {
			System.out.println("working as desired");
		}
		return false;
	}
	public void TestingEndDate13() throws InterruptedException {
		Thread.sleep(2000);
		DeptAgencyEndDate.clear();
		DeptAgencyEndDate2.clear();
		DeptAgencyEndDate3.clear();
		Thread.sleep(2000);
	
		DeptAgencyEndDate.sendKeys("03202020");
		Thread.sleep(2000);

		((JavascriptExecutor) driver).executeScript("scroll(0,300)");
		Thread.sleep(2000);
		DeptAgencySubmit.click();
		Thread.sleep(6000);

		((JavascriptExecutor) driver).executeScript("scroll(0,-400)");

	}
	public boolean EndDateValidation9() throws InterruptedException {
		Thread.sleep(2000);
		try {

			return EndDateError9.isDisplayed();
		} catch (Exception ex) {
			System.out.println("working as desired");
		}
		return false;
	}
	public void intoDept2() throws InterruptedException {
		Thread.sleep(3000);
		FHBreadcrumbLink.click();
		Thread.sleep(3000);
		FHSearch.sendKeys("DEPARTMENT FOR TESTING3");
		FHSearch.sendKeys(Keys.ENTER);
		FHSearchDepAgency.click();
		Thread.sleep(1000);

	}
	public void TestingEndDate8() throws InterruptedException {
		edit2.click();
		Thread.sleep(2000);
		DeptAgencyEndDate.clear();
		DeptAgencyEndDate2.clear();
		DeptAgencyEndDate3.clear();
		Thread.sleep(2000);
	
		DeptAgencyEndDate.sendKeys("03212022");
		Thread.sleep(2000);

		((JavascriptExecutor) driver).executeScript("scroll(0,300)");
		DeptAgencySubmit.click();
		Thread.sleep(4000);

		((JavascriptExecutor) driver).executeScript("scroll(0,-400)");

	}
	public boolean EndDateValidation4() throws InterruptedException {
		
		Thread.sleep(2000);
		try {

			return EndDateError4.isDisplayed();
		} catch (Exception ex) {
			System.out.println("working as desired");
		}
		return false;
	}
	public void intoDept3() throws InterruptedException {
		Thread.sleep(3000);
		FHBreadcrumbLink.click();
		Thread.sleep(3000);
		FHSearch.sendKeys("NEEDED FOR TESTING 4");
		FHSearch.sendKeys(Keys.ENTER);
		FHSearchDepAgency.click();
		Thread.sleep(1000);

	}
	public void TestingEndDate9() throws InterruptedException {
		edit2.click();
		Thread.sleep(2000);
		DeptAgencyEndDate.clear();
		DeptAgencyEndDate2.clear();
		DeptAgencyEndDate3.clear();
		Thread.sleep(2000);
	
		DeptAgencyEndDate.sendKeys("03212022");
		Thread.sleep(2000);

		((JavascriptExecutor) driver).executeScript("scroll(0,300)");
		DeptAgencySubmit.click();
		Thread.sleep(4000);

		((JavascriptExecutor) driver).executeScript("scroll(0,-400)");

	}
	public boolean EndDateValidation5() throws InterruptedException {
	
		Thread.sleep(2000);
		try {

			return EndDateError5.isDisplayed();
		} catch (Exception ex) {
			System.out.println("working as desired");
		}
		return false;
	}
	public void intoDept4() throws InterruptedException {
		Thread.sleep(3000);
		FHBreadcrumbLink.click();
		Thread.sleep(3000);
		FHSearch.sendKeys("DEPT FOR TESTING 5");
		FHSearch.sendKeys(Keys.ENTER);
		FHSearchDepAgency.click();
		Thread.sleep(1000);

	}
	public void TestingEndDate10() throws InterruptedException {
		edit2.click();
		Thread.sleep(2000);
		DeptAgencyEndDate.clear();
		DeptAgencyEndDate2.clear();
		DeptAgencyEndDate3.clear();
		Thread.sleep(2000);
	
		DeptAgencyEndDate.sendKeys("03212022");
		Thread.sleep(2000);

		((JavascriptExecutor) driver).executeScript("scroll(0,300)");
		DeptAgencySubmit.click();
		Thread.sleep(4000);

		((JavascriptExecutor) driver).executeScript("scroll(0,-400)");

	}
	public boolean EndDateValidation6() throws InterruptedException {

		Thread.sleep(2000);
		try {

			return EndDateError6.isDisplayed();
		} catch (Exception ex) {
			System.out.println("working as desired");
		}
		return false;
	}
	public void intoDept5() throws InterruptedException {
		Thread.sleep(3000);
		FHBreadcrumbLink.click();
		Thread.sleep(3000);
		FHSearch.sendKeys("DEPARTMENT FOR TEST");
		FHSearch.sendKeys(Keys.ENTER);
		FHSearchDepAgency.click();
		Thread.sleep(1000);

	}
	public void TestingEndDate11() throws InterruptedException {
		edit2.click();
		Thread.sleep(2000);
		DeptAgencyEndDate.clear();
		DeptAgencyEndDate2.clear();
		DeptAgencyEndDate3.clear();
		Thread.sleep(2000);
	
		DeptAgencyEndDate.sendKeys("03212022");
		Thread.sleep(2000);

		((JavascriptExecutor) driver).executeScript("scroll(0,300)");
		DeptAgencySubmit.click();
		Thread.sleep(4000);

		((JavascriptExecutor) driver).executeScript("scroll(0,-400)");

	}
	public boolean EndDateValidation7() throws InterruptedException {
	
		Thread.sleep(2000);
		try {

			return EndDateError7.isDisplayed();
			//EndDateError7.isDisplayed()||
		} catch (Exception ex) {
			System.out.println("working as desired");
		}
		return false;
	}
	public void intoDept6() throws InterruptedException {
		Thread.sleep(3000);
		FHBreadcrumbLink.click();
		Thread.sleep(3000);
		FHSearch.sendKeys("DEPARTMENT FOR TEST 7");
		FHSearch.sendKeys(Keys.ENTER);
		FHSearchDepAgency.click();
		Thread.sleep(1000);

	}
	public void TestingEndDate12() throws InterruptedException {
		edit2.click();
		Thread.sleep(2000);
		DeptAgencyEndDate.clear();
		DeptAgencyEndDate2.clear();
		DeptAgencyEndDate3.clear();
		Thread.sleep(2000);
	
		DeptAgencyEndDate.sendKeys("03212022");
		Thread.sleep(2000);

		((JavascriptExecutor) driver).executeScript("scroll(0,300)");
		DeptAgencySubmit.click();
		Thread.sleep(5000);

		((JavascriptExecutor) driver).executeScript("scroll(0,-400)");

	}
	public boolean EndDateValidation8() throws InterruptedException {
	
		Thread.sleep(2000);
		try {

			return EndDateError8.isDisplayed();
		} catch (Exception ex) {
			System.out.println("working as desired");
		}
		return false;
	}
}
