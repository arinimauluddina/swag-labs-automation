package org.example.step.login;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.driver.WebDriverBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import static org.testng.Assert.assertEquals;

public class LoginStep {

    private final WebDriver driver = WebDriverBuilder.createWebDriver();

    private final String baseUrl = "https://www.saucedemo.com/";

    @Given("user on the login page")
    public void userOnLoginPage() {
        driver.get(baseUrl);
    }

    @When("user input {} {} as credentials")
    public void userInputAsCredentials(String username, String password) {
        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();
    }

    @Then("user should be redirected to the main page")
    public void userShouldBeRedirectedToTheMainPage() {
        assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
    }


    @Then("Error Message should be displayed")
    public void errorMessageShouldBeDisplayed() {
        WebElement errorElement = driver.findElement(By.cssSelector("[data-test='error']"));
        String errorMessage = errorElement.getText();
        assertEquals("Epic sadface: Sorry, this user has been locked out.", errorMessage);
    }

    @After
    public void afterTest(){
        driver.quit();
    }
}
