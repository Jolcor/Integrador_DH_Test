package TestPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OpenAccountPage extends BasePage{

    //Open Account
    private By NewAccountClick = By.xpath("//a[normalize-space(text())='Open New Account']");
    private By AccountType = By.id("type");
    private By savings = By.xpath("//option[@value = '1']");
    private By BtnOpenAccount = By.xpath("//input[@value='Open New Account']");
    private By AccountOpened = By.xpath("//*[contains(text(), 'Congratulations, your account is now open.')]");

    public OpenAccountPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void clickAbrirCuenta () {
        this.click(NewAccountClick);
    }

    public void clickSeleccionarTipoCuenta () {
        this.click(AccountType);
    }

    public void clickSavings () {
        this.click(savings);
    }

    public void clickBtnOpenNewAccount () {
        this.click(BtnOpenAccount);
    }

    public String cuentaCreadaExitosa () {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(AccountOpened));
        String mensaje = this.getText(AccountOpened);
        System.out.println("SE VERIFICA EL MENSAJE: " + mensaje);
        return mensaje;
    }
}
