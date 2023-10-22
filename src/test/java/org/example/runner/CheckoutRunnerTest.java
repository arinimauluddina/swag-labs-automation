package org.example.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:features/Checkout.feature",
        glue = "org.example.step.checkout",
        plugin = {"pretty", "json:target/cucumber-json-report/checkout-report.json"}
)

public class CheckoutRunnerTest {

}
