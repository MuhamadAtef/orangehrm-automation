package com.orangeHRM.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;


public class AdminPage extends BasePage{


    public AdminPage(WebDriver driver) {
        super(driver);
    }

    private final By adminMenu = By.xpath("//span[text()='Admin']");
    private final By addButton = By.xpath("//button[normalize-space()='Add']");
    private final By recordsText = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[2]/div/span");
    private final By usernameField = By.xpath("//label[text()='Username']/following::input[1]");
    private final By empNameField = By.xpath("//label[text()='Employee Name']/following::input[1]");
    private final By userRoleDropdown = By.xpath("//label[text()='User Role']/following::div[1]");
    private final By statusDropdown = By.xpath("//label[text()='Status']/following::div[1]");
    private final By firstDropdownOption = By.xpath("//div[@role='listbox']//span");
    private final By passwordField = By.xpath("//label[text()='Password']/following::input[1]");
    private final By confirmPasswordField = By.xpath("//label[text()='Confirm Password']/following::input[1]");
    private final By saveButton = By.xpath("//button[normalize-space()='Save']");
    private final By searchUsernameField = By.xpath("//label[text()='Username']/following::input[1]");
    private final By searchButton = By.xpath("//button[normalize-space()='Search']");
    private final By searchRestButton = By.xpath("//button[normalize-space()='Reset']");
    private final By checkbox = By.xpath("(//div[@role='row']//i[contains(@class,'checkbox')])[2]");
    //private final By deleteButton = By.xpath("//button[normalize-space()='Delete']");
    private final By deleteButton = By.xpath("(//i[@class=\"oxd-icon bi-trash\"])[1]");
    private final By confirmDelete = By.xpath("//button[normalize-space()='Yes, Delete']");
    private final By toastMessage = By.className("oxd-toast");

    public void goToAdmin() {
        click(adminMenu);
    }

    public int getRecordCount() {
        waitForVisibility(recordsText);
        String text = find(recordsText).getText();
        return Integer.parseInt(text.replaceAll("[^0-9]", ""));
    }

    public void clickAdd() {
        click(addButton);
    }

    public void fillNewUser(String username) throws InterruptedException {
        selectFromDropdown(userRoleDropdown, firstDropdownOption);
        type(empNameField, "O");
        Thread.sleep(3000);
        find(empNameField).sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
        selectFromDropdown(statusDropdown, firstDropdownOption);
        type(this.usernameField, username);
        type(passwordField, "a123456789.");
        type(confirmPasswordField, "a123456789.");
    }

    public void clickSave() {
        click(saveButton);
    }

    public void searchUser(String username) {
        type(searchUsernameField, username);
        click(searchButton);
    }

    public void deleteUser(String username) throws InterruptedException {
        Thread.sleep(5000); // wait for table
        //click(checkbox);
        click(deleteButton);
        click(confirmDelete);
    }
    public void resetSearchResult() {
        waitForInvisibility(toastMessage);
        click(searchRestButton);
    }
}
