package lt.viko.eif.siroochenko.rest;

import io.cucumber.java.en.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class OrderSteps {

    @Autowired
    private TestRestTemplate restTemplate;

    private ResponseEntity<String> response;

    @Given("the order database is initialized")
    public void theDatabaseIsInitialized() {
    }

    @When("I send a POST request to {string} with body for order")
    public void iSendAPostRequestToWithBodyForOrder(String endpoint, String body) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> request = new HttpEntity<>(body, headers);
        try {
            response = restTemplate.postForEntity(endpoint, request, String.class);
        } catch (HttpClientErrorException | HttpServerErrorException e) {
            response = new ResponseEntity<>(e.getResponseBodyAsString(), e.getStatusCode());
        }
    }

    @Then("the response status should be {int} for order")
    public void theResponseStatusShouldBeForOrder(int statusCode) {
        assertThat(response.getStatusCodeValue(), is(statusCode));
    }

    @Then("the response should contain the order details")
    public void theResponseShouldContainTheOrderDetails() {
        assertThat(response.getBody(), containsString("\"date\":\"2024-06-12"));
        assertThat(response.getBody(), containsString("\"status\":\"Pending\""));
    }

    @When("I send a GET request to {string} for order")
    public void iSendAGetRequestToForOrder(String endpoint) {
        try {
            response = restTemplate.getForEntity(endpoint, String.class);
        } catch (HttpClientErrorException | HttpServerErrorException e) {
            response = new ResponseEntity<>(e.getResponseBodyAsString(), e.getStatusCode());
        }
    }

    @Then("the response should contain the updated order details")
    public void theResponseShouldContainTheUpdatedOrderDetails() {
        assertThat(response.getBody(), containsString("\"date\":\"2024-06-13"));
        assertThat(response.getBody(), containsString("\"status\":\"Completed\""));
    }

    @When("I send a PUT request to {string} with body for order")
    public void iSendAPutRequestToWithBodyForOrder(String endpoint, String body) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> request = new HttpEntity<>(body, headers);
        restTemplate.put(endpoint, request);
        response = restTemplate.getForEntity(endpoint, String.class);
    }

    @When("I send a DELETE request to {string} for order")
    public void iSendADeleteRequestToForOrder(String endpoint) {
        try {
            restTemplate.delete(endpoint);
            response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (HttpClientErrorException | HttpServerErrorException e) {
            response = new ResponseEntity<>(e.getResponseBodyAsString(), e.getStatusCode());
        }
    }
}
