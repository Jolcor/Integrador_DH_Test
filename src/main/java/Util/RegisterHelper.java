package Util;

import TestPage.RegisterPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterHelper {
    public WebDriver driver;
    public WebDriverWait wait;

    public RegisterHelper(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void register() {
        RegisterPage registerPage = new RegisterPage(driver, wait);

        registerPage.escibirNombre("Jorge");
        registerPage.escribirApellido("Reales");
        registerPage.escribirDireccion("Esperanza");
        registerPage.escribirCiudad("Valledupar");
        registerPage.escribirEstado("Cesar");
        registerPage.escribirCodioPosteal("034352");
        registerPage.escribirNumeroCelular("3216549876");
        registerPage.escribirNumeroSeguroSocial("123456456");
        registerPage.escribirNombreUsuario("Ole");
        registerPage.escribirContrasenia("123456");
        registerPage.escribirConfirmarContrasenia("123456");
        registerPage.registerBtn();
    }

}
