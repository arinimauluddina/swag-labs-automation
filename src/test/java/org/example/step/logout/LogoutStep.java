package org.example.step.logout;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.constant.DefaultUser;
import org.example.driver.WebDriverBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LogoutStep {

    private final WebDriver driver = WebDriverBuilder.createWebDriver();

    @Given("user do login")
    public void userDoLogin() {
        DefaultUser user = DefaultUser.STANDARD_USER;
        driver.get("https://www.saucedemo.com");
        driver.findElement(By.id("user-name")).sendKeys(user.getUsername());
        driver.findElement(By.id("password")).sendKeys(user.getPassword());
        driver.findElement(By.id("login-button")).click();
    }

    @When("user click menu bar")
    public void user_click_menu_bar() {
        // Find and click the logout button
        WebElement menuBar = driver.findElement(By.id("react-burger-menu-btn"));
        menuBar.click();
    }

    @When("user click the logout button")
    public void user_click_the_logout_button() {
        // Find and click the logout button
        WebElement logoutButton = driver.findElement(By.id("logout_sidebar_link"));
        logoutButton.click();
    }

    @Then("user should be logged out and redirected to the login page")
    public void user_should_be_logged_out() {
        // Verify that the user is on the login page after logout
        String currentURL = driver.getCurrentUrl();
        Assert.assertTrue(currentURL.contains("https://www.saucedemo.com/"));
    }

    @After
    public void afterTest(){
        driver.quit();
    }

}
