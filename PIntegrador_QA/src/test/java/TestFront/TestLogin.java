package TestFront;

import TestPage.LoginPage;
import TestPage.OpenAccountPage;
import Util.LoginHelper;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import reports.ExtentFactory;

import java.time.Duration;

public class TestLogin {
    public WebDriver driver;
    public WebDriverWait wait;
    static ExtentSparkReporter info = new ExtentSparkReporter("target/Report_Login.html");
    static ExtentReports extent;

    @BeforeAll
    public static void createReport(){
        extent = ExtentFactory.getInstance();
        extent.attachReporter(info);
    }

    @BeforeEach
    public void preconditions() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofMillis(8000));
        OpenAccountPage openAccountPage = new OpenAccountPage(driver, wait);
        openAccountPage.setup();
        openAccountPage.url("https://parabank.parasoft.com/parabank/index.htm");
    }

    @Test
    @Tag("LOGIN")
    public void testLogin() {
        ExtentTest test = extent.createTest("Test de Login Específico");
        test.log(Status.INFO, "Verificación del Login");

        LoginHelper loginHelper = new LoginHelper(driver, wait);
        loginHelper.login();
    }

    @AfterEach
    public void close() {
        LoginPage loginPage = new LoginPage(driver, wait);
        loginPage.close();
    }

    @AfterAll
    public static void saveReport() {
        extent.flush();
    }
}