package TestBack;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.junit.jupiter.api.*;
import reports.ExtentFactory;

import static io.restassured.RestAssured.given;

public class ApiStatusCodeTest {

    String baseUrl = "https://parabank.parasoft.com/parabank/";
    String customerId = "12656";
    String accountId = "13677";
    String username = "kira";
    String password = "123456";

    static ExtentSparkReporter info = new ExtentSparkReporter("target/Report_Backend.html");
    static ExtentReports extent;

    @BeforeAll
    public static void createReport(){
        extent = ExtentFactory.getInstance();
        extent.attachReporter(info);
    }

    @BeforeEach
    public void time() throws InterruptedException {
        Thread.sleep(1000);
    }

    @Test
    @Order(1)
    public void registrar() {
        given()
                .get(baseUrl + "register.htm")
                .then()
                .statusCode(200)
                .log().body();
    }

    @Test
    @Order(2)
    public void login() {
        String response = given()
                .get(baseUrl + "services/bank/" + "login/" + username + "/" + password)
                .then()
                .statusCode(200)
                .log().status()
                .log().body()
                .extract().asString();

        int tagInicio = response.indexOf("<id>") + "<id>".length();
        int tagFinal = response.indexOf("</id>");
        customerId = response.substring(tagInicio, tagFinal);

        System.out.println("Customer ID: " + customerId);
    }

    @Test
    @Order(3)
    public void crearCuenta() {
        String response = given()
                .get( baseUrl + "services/bank/customers/" + customerId + "/accounts")
                .then()
                .statusCode(200)
                .log().status()
                .log().body()
                .extract().asString();

        int tagInicio = response.indexOf("<id>") + "<id>".length();
        int tagFinal = response.indexOf("</id>");
        customerId = response.substring(tagInicio, tagFinal);

        System.out.println("Account ID: " + accountId);
    }

    @Test
    @Order(4)
    public void nuevaCuenta() {
        String response = given()
                .auth()
                .basic(username, password)
                .get( baseUrl + "services_proxy/bank/createAccount?customerId=" + customerId + "&newAccountType=1&fromAccountId=" + accountId)
                .then()
                .statusCode(200)
                .log().status()
                .log().body()
                .extract().asString();
    }

    @Test
    @Order(5)
    public void resumenCuenta() {
        given()
                .get(baseUrl + "overview.htm")
                .then()
                .statusCode(200)
                .log().status()
                .log().body();
    }

    @Test
    @Order(6)
    public void descargaFondos () {
        String amount = "200";
        given()
                .get(baseUrl + "/services_proxy/bank/transfer?fromAccountId=" + accountId + "&toAccountId=" + accountId + "&amount=" + amount)
                .then()
                .statusCode(200)
                .log().status()
                .log().body();
    }

    @Test
    @Order(7)
    public void actividadCuenta (){
        given()
                .get(baseUrl + "/services_proxy/bank/accounts/" + accountId + "/transactions/month/All/type/All")
                .then()
                .statusCode(200)
                .log().status()
                .log().body();
    }

    @AfterAll
    public static void saveReport() {
        extent.flush();
    }
}


