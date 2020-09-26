package io.tpd.springbootcucumber.bagextra;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import io.tpd.springbootcucumber.bagcommons.BagHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@CucumberContextConfiguration
@ContextConfiguration
public class BagExtraCucumberStepDefinitions {

    @Autowired
    private BagHttpClient bagHttpClient;

    @Given("the bag is not empty")
    public void the_bag_is_not_empty() {
        bagHttpClient.put("something");
        assertThat(bagHttpClient.getContents().isEmpty()).isFalse();
    }

    @Given("the bag is empty")
    public void the_bag_is_empty() {
        bagHttpClient.clean();
        assertThat(bagHttpClient.getContents().isEmpty()).isTrue();
    }

    @When("I empty the bag")
    public void empty_the_bag() {
        bagHttpClient.clean();
    }
}
