package TestFront;

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
import org.testng.Assert;
import reports.ExtentFactory;

import java.time.Duration;

public class TestOpenAccount {
    public WebDriver driver;
    public WebDriverWait wait;
    static ExtentSparkReporter info = new ExtentSparkReporter("target/Report_OpenAccount.html");
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

        LoginHelper loginHelper = new LoginHelper(driver, wait);
        loginHelper.login();
    }

    @Test
    @Tag("OPENACCOUNT")
    public void OpenAccountNew () {
        ExtentTest test = extent.createTest("Proceso de Open New Account");
        test.log(Status.INFO, "Comienza nuestro test de Open Account");
        OpenAccountPage openAccountPage = new OpenAccountPage(driver, wait);

        openAccountPage.clickAbrirCuenta();
        openAccountPage.clickSeleccionarTipoCuenta();
        openAccountPage.clickSavings();
        openAccountPage.clickBtnOpenNewAccount();

        String mensajeEsperado = "Congratulations, your account is now open.";
        String mensajeActual = openAccountPage.cuentaCreadaExitosa();
        System.out.println(mensajeEsperado);
        System.out.println("Actual: "+ mensajeActual);

        Assert.assertEquals(mensajeActual, mensajeEsperado);

        test.log(Status.PASS, "Test de Open Account completado exitosamente.");
    }

    @AfterEach
    public void close() {
        OpenAccountPage openAccountPage = new OpenAccountPage(driver, wait);
        openAccountPage.close();
    }

    @AfterAll
    public static void saveReport() {
        extent.flush();
    }
}
