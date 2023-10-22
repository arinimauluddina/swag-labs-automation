package org.example.step.checkout;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.constant.DefaultUser;
import org.example.driver.WebDriverBuilder;
import org.example.util.UserUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.testng.Assert.assertEquals;

public class CheckoutStep {
    private final WebDriver driver = WebDriverBuilder.createWebDriver();

    @Given("user do login")
    public void userDoLogin() {
        UserUtil.login(DefaultUser.STANDARD_USER, driver);
    }

    @When("User click Add to Cart button on one the product or more")
    public void user_click_add_to_cart_button_on_one_the_product_or_more() {
        WebElement addToCartButton = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        addToCartButton.click();
    }

    @And("User click Cart icon on the top right side")
    public void user_click_cart_icon_on_the_top_right_side() {
        WebElement cartIcon = driver.findElement(By.id("shopping_cart_container"));
        cartIcon.click();
    }

    @And("User check the shopping list details & click the Checkout button")
    public void user_check_the_shopping_list_details_and_click_the_checkout_button() {
        WebElement cartContainer = driver.findElement(By.cssSelector(".cart_list"));
        java.util.List<WebElement> cartItems = cartContainer.findElements(By.cssSelector(".cart_item"));

        for (WebElement cartItem : cartItems) {
            WebElement titleElement = cartItem.findElement(By.cssSelector(".inventory_item_name"));
            String title = titleElement.getText();

            WebElement descriptionElement = cartItem.findElement(By.cssSelector(".inventory_item_desc"));
            String description = descriptionElement.getText();

            WebElement priceElement = cartItem.findElement(By.cssSelector(".inventory_item_price"));
            String price = priceElement.getText();

            System.out.println("Title: " + title);
            System.out.println("Description: " + description);
            System.out.println("Price: " + price);
            System.out.println();
        }

        WebElement checkoutButton = driver.findElement(By.id("checkout"));
        checkoutButton.click();
    }

    @And("User input the buyer's information form & click Finish button")
    public void user_input_the_buyer_s_information_form_and_click_finish_button() {
        // Fill in buyer's information form
        WebElement firstNameInput = driver.findElement(By.id("first-name"));
        firstNameInput.sendKeys("Arini");

        WebElement lastNameInput = driver.findElement(By.id("last-name"));
        lastNameInput.sendKeys("M");

        WebElement postalCodeInput = driver.findElement(By.id("postal-code"));
        postalCodeInput.sendKeys("12345");

        WebElement finishButton = driver.findElement(By.id("continue"));
        finishButton.click();
    }

    @And("User double check the shopping list & click the Finish button")
    public void user_double_check_the_shopping_list_and_click_the_finish_button() {
        // Double-check shopping list
        java.util.List<WebElement> productElements = driver.findElements(By.cssSelector(".cart_item"));

        for (WebElement productElement : productElements) {
            WebElement titleElement = productElement.findElement(By.cssSelector(".inventory_item_name"));
            String title = titleElement.getText();

            WebElement descriptionElement = productElement.findElement(By.cssSelector(".inventory_item_desc"));
            String description = descriptionElement.getText();

            WebElement priceElement = productElement.findElement(By.cssSelector(".inventory_item_price"));
            String price = priceElement.getText();

            System.out.println("Title: " + title);
            System.out.println("Description: " + description);
            System.out.println("Price: " + price);
        }

        // Extract quantity, payment information, shipping information, price total, and final total
        WebElement cartItemsCount = driver.findElement(By.cssSelector(".cart_quantity"));
        String quantity = cartItemsCount.getText();

        System.out.println("Quantity: " + quantity);

        WebElement paymentInfo = driver.findElement(By.cssSelector(".summary_value_label"));
        String paymentInformation = paymentInfo.getText();

        System.out.println("Payment Information: " + paymentInformation);

        WebElement shippingInfo = driver.findElement(By.cssSelector(".summary_value_label"));
        String shippingInformation = shippingInfo.getText();

        System.out.println("Shipping Information: " + shippingInformation);

        WebElement totalPrice = driver.findElement(By.cssSelector(".summary_subtotal_label"));
        String priceTotal = totalPrice.getText();

        System.out.println("Price Total: " + priceTotal);

        WebElement finalTotal = driver.findElement(By.cssSelector(".summary_info_label.summary_total_label"));
        String total = finalTotal.getText();

        System.out.println("Total: " + total);

        WebElement finishButton = driver.findElement(By.id("finish"));
        finishButton.click();
    }

    @Then("User successfully purchased the product & direct to Checkout: Complete page")
    public void user_successfully_purchased_the_product_and_direct_to_checkout_complete_page() {
        WebElement headerElement = driver.findElement(By.cssSelector(".complete-header"));
        String header = headerElement.getText();

        System.out.println("Complete Header: " + header);

        WebElement textElement = driver.findElement(By.cssSelector(".complete-text"));
        String text = textElement.getText();

        System.out.println("Complete Text: " + text);

        assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/checkout-complete.html");
    }

    @And("user can back to homepage with click the Back Home button")
    public void user_can_back_to_homepage_with_click_the_back_home_button() {
        WebElement backHomeButton = driver.findElement(By.id("back-to-products"));
        backHomeButton.click();
    }

    @After
    public void afterTest(){
        driver.quit();
    }


}

