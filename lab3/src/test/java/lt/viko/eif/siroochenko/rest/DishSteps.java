package lt.viko.eif.siroochenko.rest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DishSteps {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private ResponseEntity<String> response;

    @Given("the dish database is initialized")
    public void theDatabaseIsInitialized() {
        jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS dishes (id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(255), price DECIMAL)");
        jdbcTemplate.execute("DELETE FROM dishes");
        jdbcTemplate.execute("INSERT INTO dishes (name, price) VALUES ('Pizza', 12.99)");
    }

    @When("I send a GET request to {string} for dish")
    public void iSendAGetRequestToForDish(String uri) {
        response = restTemplate.getForEntity(uri, String.class);
    }

    @When("I send a POST request to {string} with body for dish")
    public void iSendAPostRequestToWithBodyForDish(String uri, String body) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(body, headers);
        response = restTemplate.postForEntity(uri, entity, String.class);
    }

    @When("I send a PUT request to {string} with body for dish")
    public void iSendAPutRequestToWithBodyForDish(String uri, String body) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(body, headers);
        response = restTemplate.exchange(uri, HttpMethod.PUT, entity, String.class);
    }

    @When("I send a DELETE request to {string} for dish")
    public void iSendADeleteRequestToForDish(String uri) {
        response = restTemplate.exchange(uri, HttpMethod.DELETE, null, String.class);
    }

    @Then("the response status should be {int} for dish")
    public void theResponseStatusShouldBeForDish(int statusCode) {
        assertThat(response.getStatusCodeValue(), is(statusCode));
    }

    @Then("the response should contain the dish details")
    public void theResponseShouldContainTheDishDetails() {
        assertThat(response.getBody(), containsString("Pizza"));
        assertThat(response.getBody(), containsString("12.99"));
    }

    @Then("the response should contain the updated dish details")
    public void theResponseShouldContainTheUpdatedDishDetails() {
        assertThat(response.getBody(), containsString("Spaghetti"));
        assertThat(response.getBody(), containsString("9.99"));
    }
}
