package org.example.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:features/Login.feature",
        glue = "org.example.step.login",
        plugin = {"pretty", "json:target/cucumber-json-report/login-report.json"}
)
public class LoginRunnerTest {
}
