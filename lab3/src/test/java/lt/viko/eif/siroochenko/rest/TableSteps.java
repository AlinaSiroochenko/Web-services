package lt.viko.eif.siroochenko.rest;

import io.cucumber.java.en.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class TableSteps {

    @Autowired
    private TestRestTemplate restTemplate;

    private ResponseEntity<String> response;

    @Given("the table database is initialized")
    public void theDatabaseIsInitialized() {
    }

    @When("I send a POST request to {string} with body for table")
    public void iSendAPostRequestToWithBodyForTable(String endpoint, String body) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> request = new HttpEntity<>(body, headers);
        try {
            response = restTemplate.postForEntity(endpoint, request, String.class);
        } catch (HttpClientErrorException | HttpServerErrorException e) {
            response = new ResponseEntity<>(e.getResponseBodyAsString(), e.getStatusCode());
        }
    }

    @Then("the response status should be {int} for table")
    public void theResponseStatusShouldBeForTable(int statusCode) {
        assertThat(response.getStatusCodeValue(), is(statusCode));
    }

    @Then("the response should contain the table details")
    public void theResponseShouldContainTheTableDetails() {
        String expectedResponseBody = "{\"id\":1,\"number\":1,\"seats\":4}";
        assertThat(response.getBody(), containsString(expectedResponseBody));
    }

    @When("I send a GET request to {string} for table")
    public void iSendAGetRequestToForTable(String endpoint) {
        try {
            response = restTemplate.getForEntity(endpoint, String.class);
        } catch (HttpClientErrorException | HttpServerErrorException e) {
            response = new ResponseEntity<>(e.getResponseBodyAsString(), e.getStatusCode());
        }
    }

    @Then("the response should contain the updated table details")
    public void theResponseShouldContainTheUpdatedTableDetails() {
        String expectedResponseBody = "{\"id\":1,\"number\":2,\"seats\":6}";
        assertThat(response.getBody(), containsString(expectedResponseBody));
    }

    @When("I send a PUT request to {string} with body for table")
    public void iSendAPutRequestToWithBodyForTable(String endpoint, String body) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> request = new HttpEntity<>(body, headers);
        restTemplate.put(endpoint, request);
        response = restTemplate.getForEntity(endpoint, String.class);
    }

    @When("I send a DELETE request to {string} for table")
    public void iSendADeleteRequestToForTable(String endpoint) {
        try {
            restTemplate.delete(endpoint);
            response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (HttpClientErrorException | HttpServerErrorException e) {
            response = new ResponseEntity<>(e.getResponseBodyAsString(), e.getStatusCode());
        }
    }
}
