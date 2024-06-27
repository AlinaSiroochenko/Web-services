package lt.viko.eif.siroochenko.restaurant.endpoint;

import lt.viko.eif.siroochenko.restaurant.gen.*;
import lt.viko.eif.siroochenko.restaurant.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

/**
 * Endpoint class for handling SOAP requests related to orders.
 * This class is annotated with @Endpoint to mark it as a Spring Web Service endpoint.
 */
@Endpoint
public class RestaurantEndpoint {

    private static final String NAMESPACE_URI = "http://eif.viko.lt/siroochenko/restaurant/gen";

    private final RestaurantService restaurantService;

    /**
     * Constructs a new RestaurantEndpoint with the specified RestaurantService.
     *
     * @param restaurantService The service used to handle order-related operations.
     */
    @Autowired
    public RestaurantEndpoint(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    /**
     * Handles the addOrderRequest SOAP request.
     *
     * @param request The addOrderRequest containing the order to be added.
     * @return The addOrderResponse indicating the result of the operation.
     */
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "addOrderRequest")
    @ResponsePayload
    public AddOrderResponse addOrder(@RequestPayload AddOrderRequest request) {
        long id = restaurantService.addOrder(request.getOrder());

        AddOrderResponse response = new AddOrderResponse();
        response.setOrderId(id);
        response.setResult("Order added with ID: " + id);

        return response;
    }

    /**
     * Handles the getOrderByIdRequest SOAP request.
     *
     * @param request The getOrderByIdRequest containing the ID of the order to retrieve.
     * @return The getOrderByIdResponse containing the retrieved order.
     */
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getOrderByIdRequest")
    @ResponsePayload
    public GetOrderByIdResponse getOrderById(@RequestPayload GetOrderByIdRequest request) {
        GetOrderByIdResponse response = new GetOrderByIdResponse();
        response.setOrder(restaurantService.findOrderById((int) request.getId()));

        return response;
    }

    /**
     * Handles the getAllOrdersRequest SOAP request.
     *
     * @param request The getAllOrdersRequest indicating the request to retrieve all orders.
     * @return The getAllOrdersResponse containing all the retrieved orders.
     */
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllOrdersRequest")
    @ResponsePayload
    public GetAllOrdersResponse getAllOrders(@RequestPayload GetAllOrdersRequest request) {
        GetAllOrdersResponse response = new GetAllOrdersResponse();
        response.setOrders(restaurantService.findAllOrders());

        return response;
    }
}
