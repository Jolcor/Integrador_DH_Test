package TestFront;

import TestPage.AccountsOverviewPage;
import TestPage.OpenAccountPage;
import Util.LoginHelper;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import reports.ExtentFactory;

import java.time.Duration;

public class TestAccountsOverview {
    public WebDriver driver;
    public WebDriverWait wait;
    static ExtentSparkReporter info = new ExtentSparkReporter("target/Report_AccountsOverview.html");
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
    @Tag("ACCOUNTSOVERVIEW")
    public void clickResumenCuenta() {
        ExtentTest test = extent.createTest("Proceso de visualización de Resumen de cuentas");
        test.log(Status.INFO, "Comienza nuestro test de Resumen de cuenta");
        AccountsOverviewPage accountsOverviewPage = new AccountsOverviewPage(driver, wait);

        accountsOverviewPage.clickAccountsOverview();

        String Actual = accountsOverviewPage.confirCuentas();
        String Expectativa = "*Balance includes deposits that may be subject to holds";

        Assert.assertEquals(Actual, Expectativa);

        accountsOverviewPage.clickCuentaColumna();

        String ActualCuenta = accountsOverviewPage.detalleCuenta();
        String ExpectativaCuenta = "CHECKING";

        Assert.assertEquals(ActualCuenta, ExpectativaCuenta);

        accountsOverviewPage.clickCuentaActivada();
        accountsOverviewPage.clickSeleccionarMes();
        accountsOverviewPage.clickTipoCuenta();
        accountsOverviewPage.clickSelecciinarTipoCuenta();
        accountsOverviewPage.clickBtnGo();
    }
}
