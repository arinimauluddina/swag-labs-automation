package org.example.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:features/DetailProduct.feature",
        glue = "org.example.step.detailProduct",
        plugin = {"pretty", "json:target/cucumber-json-report/detail-product-report.json"}
)

public class DetailProductStepRunnerTest {

}
