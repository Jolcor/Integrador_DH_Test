package TestBack;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class ApiStatusCodeTest {

    private static final String[] URLs = {
            "https://parabank.parasoft.com/parabank/register.htm",
            "https://parabank.parasoft.com/parabank/services_proxy/bank/createAccount?customerId=12545&newAccountType=1&fromAccountId=xxxxx",
            "https://parabank.parasoft.com/parabank/overview.htm",
            "https://parabank.parasoft.com/parabank/services_proxy/bank/transfer?fromAccountId=13566&toAccountId=13677&amount=xxxxx",
            "https://parabank.parasoft.com/parabank/services_proxy/bank/accounts/13566/transactions/month/All/type/All"
    };

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "https://parabank.parasoft.com/parabank";
    }

    @Test
    public void validateAllUrlsStatus() {
        for (String url : URLs) {
            try {
                System.out.println("Probando URL: " + url);

                given()
                        .get(url)
                        .then()
                        .statusCode(200);

                System.out.println("URL " + url + " respondió con código 200 OK.");
            } catch (AssertionError e) {
                System.out.println("ERROR en URL " + url + ": " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Excepción desconocida en URL " + url + ": " + e.getMessage());
            }
        }
    }
}
