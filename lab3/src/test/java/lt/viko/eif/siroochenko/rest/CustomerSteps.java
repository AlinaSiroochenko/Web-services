package lt.viko.eif.siroochenko.rest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CustomerSteps {

    @Autowired
    private TestRestTemplate restTemplate;

    private ResponseEntity<String> response;

    @Given("the database is initialized")
    public void theDatabaseIsInitialized() {
    }

    @When("I send a POST request to {string} with body")
    public void iSendAPostRequestToWithBody(String uri, String body) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(body, headers);
        response = restTemplate.postForEntity(uri, entity, String.class);
    }

    @When("I send a PUT request to {string} with body")
    public void iSendAPutRequestToWithBody(String uri, String body) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(body, headers);
        response = restTemplate.exchange(uri, HttpMethod.PUT, entity, String.class);
    }

    @When("I send a DELETE request to {string}")
    public void iSendADeleteRequestTo(String uri) {
        response = restTemplate.exchange(uri, HttpMethod.DELETE, null, String.class);
    }

    @Then("the response status should be {int}")
    public void theResponseStatusShouldBe(int statusCode) {
        assertThat(response.getStatusCodeValue(), is(statusCode));
    }

    @Then("the response should contain the customer details")
    public void theResponseShouldContainTheCustomerDetails() {
        assertThat(response.getBody(), containsString("name"));
        assertThat(response.getBody(), containsString("email"));
    }

    @Then("the response should contain the updated customer details")
    public void theResponseShouldContainTheUpdatedCustomerDetails() {
        assertThat(response.getBody(), containsString("name"));
        assertThat(response.getBody(), containsString("email"));
    }
}
