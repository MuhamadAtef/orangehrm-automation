package com.orangeHRM;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {

    public static WebDriver driver;

    public static void initDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().refresh();
    }
    public static void refresh() {
        driver.navigate().refresh();
    }
    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}
