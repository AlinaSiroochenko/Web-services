package lt.viko.eif.siroochenko.rest;

import io.cucumber.java.en.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class ChefSteps {

    @Autowired
    private TestRestTemplate restTemplate;

    private ResponseEntity<String> response;

    @Given("the chef database is initialized")
    public void theDatabaseIsInitialized() {
    }

    @When("I send a POST request to {string} with body for chef")
    public void iSendAPostRequestToWithBodyForChef(String endpoint, String body) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> request = new HttpEntity<>(body, headers);
        try {
            response = restTemplate.postForEntity(endpoint, request, String.class);
        } catch (HttpClientErrorException | HttpServerErrorException e) {
            response = new ResponseEntity<>(e.getResponseBodyAsString(), e.getStatusCode());
        }
    }

    @Then("the response status should be {int} for chef")
    public void theResponseStatusShouldBeForChef(int statusCode) {
        assertThat(response.getStatusCodeValue(), is(statusCode));
    }

    @Then("the response should contain the chef details")
    public void theResponseShouldContainTheChefDetails() {
        // Assuming the ID is not known, just checking for presence of fields
        assertThat(response.getBody(), containsString("\"name\":\"Gordon Ramsay\""));
        assertThat(response.getBody(), containsString("\"experience\":30"));
    }

    @When("I send a GET request to {string} for chef")
    public void iSendAGetRequestToForChef(String endpoint) {
        try {
            response = restTemplate.getForEntity(endpoint, String.class);
        } catch (HttpClientErrorException | HttpServerErrorException e) {
            response = new ResponseEntity<>(e.getResponseBodyAsString(), e.getStatusCode());
        }
    }

    @Then("the response should contain the updated chef details")
    public void theResponseShouldContainTheUpdatedChefDetails() {
        // Assuming the ID is not known, just checking for presence of fields
        assertThat(response.getBody(), containsString("\"name\":\"Jamie Oliver\""));
        assertThat(response.getBody(), containsString("\"experience\":25"));
    }

    @When("I send a PUT request to {string} with body for chef")
    public void iSendAPutRequestToWithBodyForChef(String endpoint, String body) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> request = new HttpEntity<>(body, headers);
        restTemplate.put(endpoint, request);
        response = restTemplate.getForEntity(endpoint, String.class);
    }

    @When("I send a DELETE request to {string} for chef")
    public void iSendADeleteRequestToForChef(String endpoint) {
        try {
            restTemplate.delete(endpoint);
            response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (HttpClientErrorException | HttpServerErrorException e) {
            response = new ResponseEntity<>(e.getResponseBodyAsString(), e.getStatusCode());
        }
    }
}
