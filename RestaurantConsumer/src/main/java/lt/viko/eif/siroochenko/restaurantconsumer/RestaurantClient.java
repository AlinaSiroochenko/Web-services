package lt.viko.eif.siroochenko.restaurantconsumer;

import lt.viko.eif.siroochenko.restaurantconsumer.wsdl.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.SoapFaultClientException;
import org.springframework.ws.soap.client.core.SoapActionCallback;

/**
 * Client class for interacting with the restaurant web service.
 */
public class RestaurantClient extends WebServiceGatewaySupport {

    private static final Logger log = LoggerFactory.getLogger(RestaurantClient.class);

    /**
     * Retrieves a restaurant by name from the web service.
     * @param name The name of the restaurant to retrieve.
     * @return The response containing the restaurant information.
     */
    public GetRestaurantByNameResponse getRestaurantByName(String name) {

        GetRestaurantByNameRequest request = new GetRestaurantByNameRequest();
        request.setName(name);

        log.info("Requesting restaurant by name: {}", name);

        GetRestaurantByNameResponse response = null;
        try {
            response = (GetRestaurantByNameResponse) getWebServiceTemplate()
                    .marshalSendAndReceive("http://localhost:8080/ws/restaurants", request,
                            new SoapActionCallback(
                                    "http://eif.viko.lt/siroochenko/restaurantws/gen/getRestaurantByNameRequest"
                            ));
        } catch (SoapFaultClientException ex) {
            System.out.println("There is no restaurant with name: " + name);
        }

        return response;
    }

    /**
     * Retrieves a restaurant by ID from the web service.
     * @param id The ID of the restaurant to retrieve.
     * @return The response containing the restaurant information.
     */
    public GetRestaurantByIdResponse getRestaurantById(int id) {

        GetRestaurantByIdRequest request = new GetRestaurantByIdRequest();
        request.setId(id);

        log.info("Requesting restaurant by id: {}", id);

        GetRestaurantByIdResponse response = null;

        try {
            response = (GetRestaurantByIdResponse) getWebServiceTemplate()
                    .marshalSendAndReceive("http://localhost:8080/ws/restaurants", request,
                            new SoapActionCallback(
                                    "http://eif.viko.lt/siroochenko/restaurantws/gen/getRestaurantByIdRequest"
                            ));
        } catch (SoapFaultClientException ex) {
            System.out.println("There is no restaurant with id: " + id);
        }

        return response;
    }

    /**
     * Retrieves all restaurants from the web service.
     * @return The response containing all restaurant information.
     */
    public GetAllRestaurantsResponse getAllRestaurants() {

        GetAllRestaurantsRequest request = new GetAllRestaurantsRequest();

        log.info("Requesting all restaurants");

        GetAllRestaurantsResponse response = null;
        try {
            response = (GetAllRestaurantsResponse) getWebServiceTemplate()
                    .marshalSendAndReceive("http://localhost:8080/ws/restaurants", request,
                            new SoapActionCallback(
                                    "http://eif.viko.lt/siroochenko/restaurantws/gen/getAllRestaurantsRequest"
                            ));
        } catch (SoapFaultClientException ex) {
            System.out.println("There are no restaurants");
        }

        return response;
    }

    /**
     * Adds a new restaurant using the provided restaurant object.
     * @param restaurant The restaurant to add.
     * @return The response containing the result of the add operation.
     */
    public AddRestaurantResponse addRestaurant(Restaurant restaurant) {

        AddRestaurantRequest request = new AddRestaurantRequest();
        request.setRestaurant(restaurant);

        log.info("Adding restaurant: {}", restaurant);

        AddRestaurantResponse response = null;
        try {
            response = (AddRestaurantResponse) getWebServiceTemplate()
                    .marshalSendAndReceive("http://localhost:8080/ws/restaurants", request,
                            new SoapActionCallback(
                                    "http://eif.viko.lt/siroochenko/restaurantws/gen/addRestaurantRequest"
                            ));
        } catch (SoapFaultClientException ex) {
            System.out.println("Could not add restaurant: " + restaurant);
        }

        return response;
    }
}
