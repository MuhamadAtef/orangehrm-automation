package Api;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class TokenManager {

    private WebDriver driver;

    public TokenManager(WebDriver driver) {
        this.driver = driver;
    }

    public String getAuthToken() {
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        // You may need to adjust based on where the token is stored
//        String token = (String) js.executeScript("return window.localStorage.getItem('orangehrm.auth.token');");

        // After successful login, get the 'orangehrm' cookie
        Cookie sessionCookie = driver.manage().getCookieNamed("orangehrm");

        if (sessionCookie != null) {
            return sessionCookie.getValue();
        } else {
            throw new RuntimeException("Session cookie not found after login! Check login steps.");
        }
    }
}
