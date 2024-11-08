package TestFront;

import TestPage.OpenAccountPage;
import TestPage.RegisterPage;
import TestPage.TransferPage;
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

public class TestTransfer {
    public WebDriver driver;
    public WebDriverWait wait;
    static ExtentSparkReporter info = new ExtentSparkReporter("target/Report_Transfer.html");
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
        LoginHelper loginHelper = new LoginHelper(driver, wait);
        registerPage.setup();
        registerPage.url("https://parabank.parasoft.com/parabank/index.htm");
        loginHelper.login();
    }

    @Test
    @Tag("TRANSFER")
    public void TransferFunds() {
        ExtentTest test = extent.createTest("Proceso de Transfer Funds");
        test.log(Status.INFO, "Comienza nuestro test de Transfer Funds");
        TransferPage transferPage = new TransferPage(driver, wait);

        transferPage.opcionTransferencia();
        transferPage.escribirCantidad("16");
        transferPage.seleccionarCuentaEntreda();

        transferPage.cuentaEntreda();
        transferPage.seleccionarCuentaSalida();
        transferPage.cuentaSalida();
        transferPage.transferirDinero();

        Assert.assertEquals("Transfer Complete!", transferPage.tranferenciaExitosa());
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
