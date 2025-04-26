package apiOrangeHRM;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;

import java.util.HashMap;
import java.util.Map;

public class RestAssuredTest {

    private String baseUrl = "https://opensource-demo.orangehrmlive.com";
    private String token;
    private int createdCandidateId;

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = baseUrl;

        // Step 1: Login and retrieve token
        Map<String, String> loginBody = new HashMap<>();
        loginBody.put("username", "Admin");
        loginBody.put("password", "admin123");

        Response loginResponse = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body(loginBody)
                .when()
                .post("/web/index.php/api/v2/admin/login");

        System.out.println("Login Response: " + loginResponse.asString());

        // NOTE: OrangeHRM public demo site does not allow API testing. Only UI automation is possible.


    }


}
