package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import pages.LoginPage;
import pages.InboxPage;
import utils.ExcelUtils;
import utils.ExtentManager;

public class GmailTests {
    WebDriver driver;
    LoginPage loginPage;
    InboxPage inboxPage;
    ExcelUtils excelUtils;
    ExtentReports extent;
    ExtentTest test;

    @BeforeClass
    public void setup() {
        // Initialize WebDriver
    	 System.setProperty("webdriver.chrome.driver", "E:\\Softwares\\Chrome drivers\\chromedriver_129.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://mail.google.com/");
        
        // Initialize Pages
        loginPage = new LoginPage(driver);
        inboxPage = new InboxPage(driver);
        
        // Initialize ExcelUtils
        excelUtils = new ExcelUtils("E:\\Eclipse Workspace\\DataDriven\\src\\test\\java\\utils\\testdata.xlsx");
        
        // Initialize ExtentReports
        extent = ExtentManager.getInstance();
    }

    @DataProvider(name = "gmailData")
    public Object[][] getData() {
        int rowCount = excelUtils.getRowCount(0);
        Object[][] data = new Object[rowCount][2];

        for (int i = 0; i < rowCount; i++) {
            data[i][0] = excelUtils.getCellData(0, i, 0); // Email
            data[i][1] = excelUtils.getCellData(0, i, 1); // Password
        }

        return data;
    }

    @Test(dataProvider = "gmailData")
    public void testLogin(String email, String password) {
        test = extent.createTest("Login Test for: " + email);

        try {
            loginPage.enterEmail(email);
            loginPage.enterPassword(password);
            
            // Add assertions to verify login success here
            // Example assertion (pseudo-code)
            // Assert.assertTrue(isLoginSuccessful());

            test.log(Status.PASS, "Login successful for: " + email);
        } catch (Exception e) {
            test.log(Status.FAIL, "Login failed for: " + email + " due to " + e.getMessage());
        }
    }

    @AfterClass
    public void tearDown() {
       // driver.quit();
        ExtentManager.flush(); // Flush the reports
    }
}
