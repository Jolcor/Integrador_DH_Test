package TestPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TransferPage extends BasePage {

    private By transferFunds = By.xpath("//a[normalize-space(text())='Transfer Funds']");
    private By amount = By.id("amount");
    private By account = By.id("fromAccountId");
    private By selectAccount = By.xpath("//select[@id='fromAccountId']//option[@value='13455']");
    private By toAccount = By.id("toAccountId");
    private By selectToAccount = By.xpath("//select[@id='toAccountId']//option[@value='13455']");
    private By btnTransfer = By.className("button");
    private By transferComplete = By.xpath("//h1[normalize-space(text())='Transfer Complete']");

    public TransferPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void opcionTransferencia () {
        this.click(transferFunds);
    }

    public void escribirCantidad (String cant) {
        this.sendKey(cant, amount);
    }

    public void seleccionarCuentaSalida () {
        this.click(account);
    }

    public void cuentaSalida() {
        this.click(selectAccount);
    }

    public void cuentaEntreda() {
        this.click(toAccount);
    }

    public void seleccionarCuentaEntreda () {
        this.click(selectToAccount);
    }

    public void transferirDinero () {
        this.click(btnTransfer);
    }

    public String tranferenciaExitosa () {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(transferComplete));
        String mensaje = this.getText(transferComplete);
        System.out.println("SE VERIFICA EL MENSAJE: " + mensaje);
        return mensaje;
    }
}
