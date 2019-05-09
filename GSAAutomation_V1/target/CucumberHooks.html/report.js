$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/features/negEditOffice.feature");
formatter.feature({
  "name": "Editing request office page negative scenarios.",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@NegEditReuqstoffice"
    }
  ]
});
formatter.scenario({
  "name": "Log into the GSA website as createDepartment",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@NegEditReuqstoffice"
    },
    {
      "name": "@otp"
    }
  ]
});
formatter.step({
  "name": "The user login into environment COMP_HOME_PAGE",
  "keyword": "And "
});
formatter.match({
  "location": "LoginDepartmentSubTierOfficeAdminStepDef.the_user_login_into_environment(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Click on department sign in link",
  "keyword": "And "
});
formatter.match({
  "location": "LoginDepartmentSubTierOfficeAdminStepDef.Click_on_department_on_sign_in_link1()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Click on department accept button",
  "keyword": "And "
});
formatter.match({
  "location": "LoginDepartmentSubTierOfficeAdminStepDef.Click_on_department_accept_button1()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Enters the department email id createDepartment",
  "keyword": "And "
});
formatter.match({
  "location": "LoginDepartmentSubTierOfficeAdminStepDef.the_user_enters_the_email_id1(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Enters the department password alertadminPassword1",
  "keyword": "And "
});
formatter.match({
  "location": "LoginDepartmentSubTierOfficeAdminStepDef.Enters_the_department_password(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Click on department sign in button",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginDepartmentSubTierOfficeAdminStepDef.the_user_click_on_sign_in_button1()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Receive your one time department password myEmail",
  "keyword": "And "
});
formatter.match({
  "location": "LoginDepartmentSubTierOfficeAdminStepDef.the_user_want_to_receive_your_one_time_password1(String)"
});
formatter.result({
  "error_message": "org.openqa.selenium.WebDriverException: unknown error: cannot determine loading status\nfrom no such execution context\n  (Session info: chrome\u003d74.0.3729.108)\n  (Driver info: chromedriver\u003d2.38.552522 (437e6fbedfa8762dec75e2c5b3ddb86763dc9dcb),platform\u003dWindows NT 6.1.7601 SP1 x86_64) (WARNING: The server did not provide any stacktrace information)\nCommand duration or timeout: 0 milliseconds\nBuild info: version: \u00273.11.0\u0027, revision: \u0027e59cfb3\u0027, time: \u00272018-03-11T20:26:55.152Z\u0027\nSystem info: host: \u0027I07R7C-AF1F22\u0027, ip: \u0027172.21.72.115\u0027, os.name: \u0027Windows 7\u0027, os.arch: \u0027amd64\u0027, os.version: \u00276.1\u0027, java.version: \u00271.8.0_211\u0027\nDriver info: org.openqa.selenium.remote.RemoteWebDriver\nCapabilities {acceptInsecureCerts: false, acceptSslCerts: false, applicationCacheEnabled: false, browserConnectionEnabled: false, browserName: chrome, chrome: {chromedriverVersion: 2.38.552522 (437e6fbedfa876..., userDataDir: C:\\Users\\SH359E~1\\AppData\\L...}, cssSelectorsEnabled: true, databaseEnabled: false, handlesAlerts: true, hasTouchScreen: false, javascriptEnabled: true, locationContextEnabled: true, mobileEmulationEnabled: false, nativeEvents: true, networkConnectionEnabled: false, pageLoadStrategy: normal, platform: XP, platformName: XP, rotatable: false, setWindowRect: true, takesHeapSnapshot: true, takesScreenshot: true, unexpectedAlertBehaviour: , unhandledPromptBehavior: , version: 74.0.3729.108, webStorageEnabled: true}\nSession ID: dd49120807514e749bbdca402cb9571f\n*** Element info: {Using\u003dxpath, value\u003d//*[@id\u003d\"identifierId\"]}\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance(Unknown Source)\r\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(Unknown Source)\r\n\tat java.lang.reflect.Constructor.newInstance(Unknown Source)\r\n\tat org.openqa.selenium.remote.ErrorHandler.createThrowable(ErrorHandler.java:214)\r\n\tat org.openqa.selenium.remote.ErrorHandler.throwIfResponseFailed(ErrorHandler.java:166)\r\n\tat org.openqa.selenium.remote.http.JsonHttpResponseCodec.reconstructValue(JsonHttpResponseCodec.java:40)\r\n\tat org.openqa.selenium.remote.http.AbstractHttpResponseCodec.decode(AbstractHttpResponseCodec.java:80)\r\n\tat org.openqa.selenium.remote.http.AbstractHttpResponseCodec.decode(AbstractHttpResponseCodec.java:44)\r\n\tat org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:158)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:545)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:319)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElementByXPath(RemoteWebDriver.java:421)\r\n\tat org.openqa.selenium.By$ByXPath.findElement(By.java:361)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:311)\r\n\tat net.thucydides.core.webdriver.WebDriverFacade.findElement(WebDriverFacade.java:231)\r\n\tat gov.gsa.sam.stepdefinition.LoginDepartmentSubTierOfficeAdminStepDef.the_user_want_to_receive_your_one_time_password1(LoginDepartmentSubTierOfficeAdminStepDef.java:121)\r\n\tat ✽.Receive your one time department password myEmail(src/test/resources/features/negEditOffice.feature:12)\r\n",
  "status": "failed"
});
formatter.step({
  "name": "Enters department one time access code",
  "keyword": "And "
});
formatter.match({
  "location": "LoginDepartmentSubTierOfficeAdminStepDef.Enters_department_one_time_access_code1()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "Click on department one time submit button",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginDepartmentSubTierOfficeAdminStepDef.Click_on_department_one_time_submit_button1()"
});
formatter.result({
  "status": "skipped"
});
formatter.scenario({
  "name": "Account name",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@NegEditReuqstoffice"
    },
    {
      "name": "@profile"
    }
  ]
});
formatter.step({
  "name": "Go to profile page",
  "keyword": "And "
});
formatter.match({
  "location": "LoginDepartmentSubTierOfficeAdminStepDef.Go_to_profile_page()"
});
formatter.result({
  "error_message": "org.openqa.selenium.NoSuchElementException: no such element: Unable to locate element: {\"method\":\"id\",\"selector\":\"header-profile-icon\"}\n  (Session info: chrome\u003d74.0.3729.108)\n  (Driver info: chromedriver\u003d2.38.552522 (437e6fbedfa8762dec75e2c5b3ddb86763dc9dcb),platform\u003dWindows NT 6.1.7601 SP1 x86_64) (WARNING: The server did not provide any stacktrace information)\nCommand duration or timeout: 0 milliseconds\nFor documentation on this error, please visit: http://seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00273.11.0\u0027, revision: \u0027e59cfb3\u0027, time: \u00272018-03-11T20:26:55.152Z\u0027\nSystem info: host: \u0027I07R7C-AF1F22\u0027, ip: \u0027172.21.72.115\u0027, os.name: \u0027Windows 7\u0027, os.arch: \u0027amd64\u0027, os.version: \u00276.1\u0027, java.version: \u00271.8.0_211\u0027\nDriver info: org.openqa.selenium.remote.RemoteWebDriver\nCapabilities {acceptInsecureCerts: false, acceptSslCerts: false, applicationCacheEnabled: false, browserConnectionEnabled: false, browserName: chrome, chrome: {chromedriverVersion: 2.38.552522 (437e6fbedfa876..., userDataDir: C:\\Users\\SH359E~1\\AppData\\L...}, cssSelectorsEnabled: true, databaseEnabled: false, handlesAlerts: true, hasTouchScreen: false, javascriptEnabled: true, locationContextEnabled: true, mobileEmulationEnabled: false, nativeEvents: true, networkConnectionEnabled: false, pageLoadStrategy: normal, platform: XP, platformName: XP, rotatable: false, setWindowRect: true, takesHeapSnapshot: true, takesScreenshot: true, unexpectedAlertBehaviour: , unhandledPromptBehavior: , version: 74.0.3729.108, webStorageEnabled: true}\nSession ID: dd49120807514e749bbdca402cb9571f\n*** Element info: {Using\u003did, value\u003dheader-profile-icon}\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance(Unknown Source)\r\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(Unknown Source)\r\n\tat java.lang.reflect.Constructor.newInstance(Unknown Source)\r\n\tat org.openqa.selenium.remote.ErrorHandler.createThrowable(ErrorHandler.java:214)\r\n\tat org.openqa.selenium.remote.ErrorHandler.throwIfResponseFailed(ErrorHandler.java:166)\r\n\tat org.openqa.selenium.remote.http.JsonHttpResponseCodec.reconstructValue(JsonHttpResponseCodec.java:40)\r\n\tat org.openqa.selenium.remote.http.AbstractHttpResponseCodec.decode(AbstractHttpResponseCodec.java:80)\r\n\tat org.openqa.selenium.remote.http.AbstractHttpResponseCodec.decode(AbstractHttpResponseCodec.java:44)\r\n\tat org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:158)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:545)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:319)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElementById(RemoteWebDriver.java:365)\r\n\tat org.openqa.selenium.By$ById.findElement(By.java:218)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:311)\r\n\tat net.thucydides.core.webdriver.WebDriverFacade.findElement(WebDriverFacade.java:231)\r\n\tat gov.gsa.sam.stepdefinition.LoginDepartmentSubTierOfficeAdminStepDef.Go_to_profile_page(LoginDepartmentSubTierOfficeAdminStepDef.java:581)\r\n\tat ✽.Go to profile page(src/test/resources/features/negEditOffice.feature:20)\r\n",
  "status": "failed"
});
formatter.step({
  "name": "Reading details in account details page",
  "keyword": "And "
});
formatter.match({
  "location": "CreateDepartmentStepDef.Reading_details_in_account_details_page()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "Click on the workspace",
  "keyword": "Then "
});
formatter.match({
  "location": "CreateDepartmentStepDef.Click_on_the_workspace()"
});
formatter.result({
  "status": "skipped"
});
formatter.scenario({
  "name": "My Workspace",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@NegEditReuqstoffice"
    },
    {
      "name": "@officeAdmin"
    }
  ]
});
formatter.step({
  "name": "User Click on go to department link",
  "keyword": "Given "
});
