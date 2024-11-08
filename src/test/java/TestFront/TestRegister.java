package TestFront;

import TestPage.RegisterPage;
import Util.RegisterHelper;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import reports.ExtentFactory;

import java.time.Duration;

public class TestRegister {
    public WebDriver driver;
    public WebDriverWait wait;
    static ExtentSparkReporter info = new ExtentSparkReporter("target/Report_Register.html");
    static ExtentReports extent;

    @BeforeAll
    public static void createReport(){
        extent = ExtentFactory.getInstance();
        extent.attachReporter(info);
    }

    @BeforeEach
    public void preconditions() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofMillis(5000));
        RegisterPage registerPage = new RegisterPage(driver, wait);
        registerPage.setup();
        registerPage.url("https://parabank.parasoft.com/parabank/register.htm");
    }

    @Test
    @Tag("REGISTER")
    public void register_ok () {
        ExtentTest test = extent.createTest("Proceso de registro");
        test.log(Status.INFO, "Comienza nuestro test de register");
        RegisterPage registerPage = new RegisterPage(driver, wait);
        RegisterHelper registerHelper = new RegisterHelper(driver, wait);
        registerHelper.register();

        test.log(Status.PASS, "Se cargan los datos validos al registrar usuario");

        Assert.assertEquals("Your account was created successfully. You are now logged in.", registerPage.bienvenido());
    }

    @AfterEach
    public void close() {
        RegisterPage registerPage = new RegisterPage(driver, wait);
        registerPage.close();
    }

    @AfterAll
    public static void saveReport() {
        extent.flush();
    }
}


