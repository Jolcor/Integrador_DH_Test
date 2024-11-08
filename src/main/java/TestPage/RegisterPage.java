package TestPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage extends BasePage {

    //private By register = By.xpath("//a[normalize-space(text())='register']");
    private By first_name = By.id("customer.firstName");
    private By last_name = By.id("customer.lastName");
    private By address = By.id("customer.address.street");
    private By city = By.id("customer.address.city");
    private By state = By.id("customer.address.state");
    private By zipCode = By.id("customer.address.zipCode");
    private By phoneNumber = By.id("customer.phoneNumber");
    private By snn = By.id("customer.ssn");
    private By userName = By.id("customer.username");
    private By password = By.id("customer.password");
    private By confirPasswoird = By.id("repeatedPassword");
    private By btnRegister = By.xpath("//input[@value='Register']");
    private By welcome = By.xpath("//p[normalize-space(text())='Your account was created successfully. You are now logged in.']");

    public RegisterPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void escibirNombre (String nombre) {
        this.sendKey(nombre, first_name);
    }

    public void escribirApellido (String apellido) {
        this.sendKey(apellido, last_name);
    }

    public void escribirDireccion (String direccion) {
        this.sendKey(direccion, address);
    }

    public void escribirCiudad (String ciudad) {
        this.sendKey(ciudad, city);
    }

    public void escribirEstado (String estado) {
        this.sendKey(estado, state);
    }

    public void escribirCodioPosteal (String postal) {
        this.sendKey(postal, zipCode);
    }

    public void escribirNumeroCelular (String celular) {
        this.sendKey(celular, phoneNumber);
    }

    public void escribirNumeroSeguroSocial (String seguro_solcial) {
        this.sendKey(seguro_solcial, snn);
    }

    public void escribirNombreUsuario (String usuario) {
        this.sendKey(usuario, userName);
    }

    public void escribirContrasenia (String contrasenia) {
        this.sendKey(contrasenia, password);
    }

    public void escribirConfirmarContrasenia (String confirContrasenia) {
        this.sendKey(confirContrasenia, confirPasswoird);
    }

    public void registerBtn () {
        this.click(btnRegister);
    }

    public String bienvenido () {
        System.out.println("SE VERIFICA EL MENSAJE: " + this.getText(welcome));
        return this.getText(welcome);
    }

}
