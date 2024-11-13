package Util;

import TestPage.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginHelper {

    public WebDriver driver;
    public WebDriverWait wait;

    public LoginHelper(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void login() {
        LoginPage loginPage = new LoginPage(driver, wait);

        loginPage.escribirUsuario("kira");
        loginPage.escribirContrasenia("123456");
        loginPage.clikcLogin();
    }
}
