package com.orangeHRM.stepdefinitions;

import com.orangeHRM.BaseTest;
import com.orangeHRM.pages.AdminPage;
import com.orangeHRM.pages.LoginPage;
import io.cucumber.java.en.*;
import org.testng.Assert;


public class UserSteps {

    LoginPage login;
    AdminPage admin;
    int initialCount=0;
    int postAddCount=0;
    int postDeleteCount=0;

    @Given("Admin logs in")
    public void adminLogsIn() {
        BaseTest.initDriver();
        BaseTest.driver.get("https://opensource-demo.orangehrmlive.com/");
        login = new LoginPage(BaseTest.driver);
        login.login("Admin", "admin123");
    }

    @And("navigates to Admin section")
    public void goToAdmin() {
        admin = new AdminPage(BaseTest.driver);
        admin.goToAdmin();
    }

    @When("the user counts current records")
    public void getInitialCount() {
        initialCount = admin.getRecordCount();
        System.out.println("initialCount = " + initialCount);
    }

    @When("adds a new user with username {string}")
    public void addNewUser(String username) throws InterruptedException {
        admin.clickAdd();
        admin.fillNewUser(username);
        admin.clickSave();
        Thread.sleep(3000); // wait for return to list
        postAddCount = admin.getRecordCount();
        System.out.println("postAddCount = " + postAddCount);
    }

    @Then("the record count should increase by 1")
    public void validateIncrement() {
        Assert.assertEquals(initialCount + 1, postAddCount);
    }

    @When("the user searches for {string}")
    public void searchUser(String username) {
        admin.searchUser(username);
    }

    @When("deletes the user {string}")
    public void deleteUser(String username) throws InterruptedException {
        admin.deleteUser(username);
        Thread.sleep(3000);
        BaseTest.refresh();
        admin.goToAdmin();
        Thread.sleep(3000);
        postDeleteCount = admin.getRecordCount();
        System.out.println("postDeleteCount = " + postDeleteCount);
    }

    @Then("the record count should decrease by 1")
    public void validateDecrement() {
        Assert.assertEquals(initialCount, postDeleteCount);
        BaseTest.quitDriver();
    }

}
