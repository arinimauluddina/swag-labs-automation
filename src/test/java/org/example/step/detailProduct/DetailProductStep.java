package org.example.step.detailProduct;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.constant.DefaultUser;
import org.example.driver.WebDriverBuilder;
import org.example.util.UserUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class DetailProductStep {

    private final WebDriver driver = WebDriverBuilder.createWebDriver();


    @Given("user do login")
    public void userDoLogin() {
        UserUtil.login(DefaultUser.STANDARD_USER, driver);
    }

    @When("the user selects a product {} as item")
    public void the_user_selects_a_product(String itemLinkId) {
        driver.findElement(By.id(itemLinkId)).click();
    }

    @Then("the user is taken to a product details page")
    public void the_user_is_taken_to_a_product_details_page() {
        // Verify if we are on the product details page
        WebElement pageTitle = driver.findElement(By.cssSelector(".inventory_details_name"));
        Assert.assertTrue(pageTitle.isDisplayed());
    }

    @Then("the product details page displays the product's name, description, and price")
    public void the_product_details_page_displays_the_product_details() {
        // Verify that product name, description, and price are displayed
        WebElement productName = driver.findElement(By.cssSelector(".inventory_details_name"));
        WebElement productDescription = driver.findElement(By.cssSelector(".inventory_details_desc"));
        WebElement productPrice = driver.findElement(By.cssSelector(".inventory_details_price"));

        Assert.assertTrue(productName.isDisplayed());
        Assert.assertTrue(productDescription.isDisplayed());
        Assert.assertTrue(productPrice.isDisplayed());
    }

    @Then("the user can click the Add to cart button")
    public void the_user_can_click_add_to_cart() {
        // Click the "Add to cart" button
        WebElement addToCartButton = driver.findElement(By.cssSelector(".btn_primary"));
        addToCartButton.click();
    }

    @Then("the number of products in the cart icon increases by 1 in the top right corner")
    public void number_of_products_in_cart_increases() {
        // Verify that the cart icon now displays "1" indicating one product is in the cart
        WebElement cartCount = driver.findElement(By.cssSelector(".shopping_cart_badge"));
        Assert.assertEquals("1", cartCount.getText());
    }

    @After
    public void afterTest(){
        driver.quit();
    }

}
