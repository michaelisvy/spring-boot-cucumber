package io.tpd.springbootcucumber.bagextra;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty", "html:target/cucumber/bagextra"})
public class BagExtraCucumberIntegrationTest {
}
