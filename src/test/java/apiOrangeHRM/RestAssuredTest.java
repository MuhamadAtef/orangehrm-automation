package apiOrangeHRM;

import Api.TokenManager;
import com.orangeHRM.pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.http.ContentType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;



public class RestAssuredTest {

    private String baseUrl = "https://opensource-demo.orangehrmlive.com";
    private String token;
    private int createdCandidateId;



    @BeforeClass
    public void setup() {

        WebDriver driver;
        LoginPage loginPage;
        TokenManager tokenManager;

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/");

        loginPage = new LoginPage(driver);
        loginPage.login("Admin", "admin123");

        tokenManager = new TokenManager(driver);
        token = tokenManager.getAuthToken();

        System.out.println("token: " + token);

        driver.quit();

    }

    @Test(priority = 1)
    public void addCandidate() {
        Map<String, Object> body = new HashMap<>();
        body.put("firstName", "Muhammad");
        body.put("lastName", "Atef");
        body.put("email", "Muhammad.Atef+" + System.currentTimeMillis() + "@test.com");
        body.put("contactNumber", "1234567890");

        Response response = RestAssured
                .given().baseUri(baseUrl)
                .contentType(ContentType.JSON)
                .header("Cookie", "orangehrm=" + token)//header("Authorization", "Bearer " + token)
                .body(body)
                .when()
                .post("/web/index.php/api/v2/recruitment/candidates");

        System.out.println("Add Candidate Response: " + response.asString());
        Assert.assertEquals(response.statusCode(), 200);

        createdCandidateId = response.jsonPath().getInt("data.id");
    }

    @Test(priority = 2, dependsOnMethods = "addCandidate")
    public void deleteCandidate() {
        String payload = "{\"ids\":[" + createdCandidateId+ "]}";
        System.out.println("payload: "+ payload);
        Response response = RestAssured
                .given()
                .header("Cookie", "orangehrm=" + token)
                .contentType(ContentType.JSON)
                .body(payload)
                .when().delete("https://opensource-demo.orangehrmlive.com/web/index.php/api/v2/recruitment/candidates");

        System.out.println("Delete Candidate Response: " + response.asString());
        Assert.assertEquals(response.statusCode(), 200);
    }


}
