package TestPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

    //Login
    private By usernanme = By.xpath("//input[@name = 'username']");
    private By password = By.xpath("//input[@name = 'password']");
    private By login = By.xpath("//input[@value = 'Log In']");

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void escribirUsuario (String user) {
        this.sendText(user, usernanme);
    }
    public void escribirContrasenia (String contrasenia) {
        this.sendText(contrasenia, password);
    }

    public void clikcLogin () {
        this.click(login);
    }
}
