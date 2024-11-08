package TestPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    public WebDriver driver;
    public WebDriverWait wait;

    public BasePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofMillis(3000));
    }

    public void setup() {
        driver.manage().window().maximize();
    }

    public void url(String url) {
        driver.get(url);
    }

    public void close() {
        driver.quit();
    }

    protected WebElement findElement(By locator) {
        return driver.findElement(locator);
    }

    protected void sendText(String inputText, By locator) {
        // Espera hasta que el elemento esté presente en el DOM y sea localizable
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        this.findElement(locator).clear(); // Llama al metodo findElement para encontrar el elemento y luego lo limpia (borra el contenido actual del campo de texto)
        this.findElement(locator).sendKeys(inputText);// Envía el texto proporcionado al campo de texto del elemento encontrado
    }

    protected void sendKey(CharSequence key, By locator) {
        this.findElement(locator).sendKeys(key);
    }

    protected void click(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        this.findElement(locator).click();
    }

    protected String getText(By locator) {
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        return this.findElement(locator).getText();
    }
}
