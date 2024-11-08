package TestPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AccountsOverviewPage extends BasePage {

    //Accounts Overview
    private By AccountsOverview = By.xpath("//a[normalize-space(text())='Accounts Overview']");
    private By TextConf = By.xpath("//td[normalize-space(text())='*Balance includes deposits that may be subject to holds']");
    private By AccountColumn = By.xpath("//*[contains(text(), '13899')]");
    private By TextAccount = By.xpath("//*[contains(text(), 'CHECKING')]");
    private By ActivityPeriod = By.id("month");
    private By SelectActivity = By.xpath("//select[@id='month']//option[@value='All']");
    private By Type = By.id("transactionType");
    private By SelectType = By.xpath("//select[@id='transactionType']//option[@value='All']");
    private By BtnGo = By.xpath("input[contains(text(), 'Go')]");

    public AccountsOverviewPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void clickAccountsOverview () {
        this.click(AccountsOverview);
    }

    public void clickCuentaColumna () {
        this.click(AccountColumn);
    }

    public void clickCuentaActivada () {
        this.click(ActivityPeriod);
    }

    public void clickTipoCuenta () {
        this.click(Type);
    }

    public void clickBtnGo () {
        this.click(BtnGo);
    }

    public void clickSeleccionarMes () {
        this.click(SelectActivity);
    }

    public void clickSelecciinarTipoCuenta () {
        this.click(SelectType);
    }

    public String detalleCuenta () {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(TextAccount));
        String mensaje1 = this.getText(TextAccount);
        System.out.println("SE VERIFICA LA CUENTA: " + mensaje1);
        return mensaje1;
    }

    public String confirCuentas () {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(TextConf));
        String mensaje = this.getText(TextConf);
        System.out.println("SE VERIFICA EL MENSAJE: " + mensaje);
        return mensaje;
    }
}
