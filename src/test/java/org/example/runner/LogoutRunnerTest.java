package org.example.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:features/Logout.feature",
        glue = "org.example.step.logout",
        plugin = {"pretty", "json:target/cucumber-json-report/logout-report.json"}
)

public class LogoutRunnerTest {
}
