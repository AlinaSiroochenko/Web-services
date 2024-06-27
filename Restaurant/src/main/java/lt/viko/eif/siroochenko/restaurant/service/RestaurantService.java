package lt.viko.eif.siroochenko.restaurant.service;

import jakarta.xml.ws.soap.SOAPFaultException;
import lt.viko.eif.siroochenko.restaurant.db.RestaurantJPARepository;
import lt.viko.eif.siroochenko.restaurant.model.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ws.soap.SoapFaultException;

import java.util.List;
import java.util.Optional;

/**
 * Service class for handling operations related to orders.
 */
@Service
public class RestaurantService {

    @Autowired
    private RestaurantJPARepository restaurantRepository;

    @Autowired
    private ModelMapper modelMapper;

    /**
     * Adds an order to the database.
     *
     * @param order The order to be added.
     * @return The ID of the added order.
     */
    public int addOrder(lt.viko.eif.siroochenko.restaurant.gen.Order order) {
        return restaurantRepository.save(convertToEntity(order)).getId();
    }

    /**
     * Finds an order by its ID.
     *
     * @param id The ID of the order to search for.
     * @return The order with the specified ID.
     * @throws SoapFaultException If no order is found with the given ID.
     */
    public lt.viko.eif.siroochenko.restaurant.gen.Order findOrderById(int id) throws SOAPFaultException {
        Optional<Order> order = this.list().stream()
                .filter(o -> o.getId() == id).findFirst();

        if (order.isEmpty()) {
            throw new SoapFaultException("No order found with ID: " + id);
        }

        return convertToDto(order.get());
    }

    /**
     * Retrieves all orders.
     *
     * @return All orders available in the database.
     */
    public lt.viko.eif.siroochenko.restaurant.gen.Orders findAllOrders() {
        lt.viko.eif.siroochenko.restaurant.gen.Orders orders =
                new lt.viko.eif.siroochenko.restaurant.gen.Orders();
        this.list().forEach(order -> orders.getOrder().add(convertToDto(order)));

        return orders;
    }

    /**
     * Retrieves a list of all orders.
     *
     * @return A list of all orders available in the database.
     */
    public List<Order> list() {
        return restaurantRepository.findAll();
    }

    /**
     * Converts an Order DTO object to its corresponding entity.
     *
     * @param order The Order DTO object to convert.
     * @return The corresponding Order entity.
     */
    private Order convertToEntity(lt.viko.eif.siroochenko.restaurant.gen.Order order) {
        Order orderEntity = modelMapper.map(order, Order.class);

        if (order.getDishes() != null && order.getDishes().getDish() != null) {
            order.getDishes().getDish()
                    .forEach(dish -> orderEntity.addDish(convertToEntity(dish)));
        }

        return orderEntity;
    }

    /**
     * Converts a Dish DTO object to its corresponding entity.
     *
     * @param dish The Dish DTO object to convert.
     * @return The corresponding Dish entity.
     */
    private Dish convertToEntity(lt.viko.eif.siroochenko.restaurant.gen.Dish dish) {
        Dish dishEntity = modelMapper.map(dish, Dish.class);
        return dishEntity;
    }

    /**
     * Converts an Order entity to its corresponding DTO object.
     *
     * @param order The Order entity to convert.
     * @return The corresponding Order DTO object.
     */
    private lt.viko.eif.siroochenko.restaurant.gen.Order convertToDto(Order order) {
        lt.viko.eif.siroochenko.restaurant.gen.Order orderDto =
                modelMapper.map(order, lt.viko.eif.siroochenko.restaurant.gen.Order.class);

        lt.viko.eif.siroochenko.restaurant.gen.Dishes dishes =
                new lt.viko.eif.siroochenko.restaurant.gen.Dishes();

        if (order.getDishes() != null) {
            order.getDishes().forEach(dish -> dishes.getDish().add(convertToDto(dish)));
        }

        orderDto.setDishes(dishes);

        return orderDto;
    }

    /**
     * Converts a Dish entity to its corresponding DTO object.
     *
     * @param dish The Dish entity to convert.
     * @return The corresponding Dish DTO object.
     */
    private lt.viko.eif.siroochenko.restaurant.gen.Dish convertToDto(Dish dish) {
        lt.viko.eif.siroochenko.restaurant.gen.Dish dishDto =
                modelMapper.map(dish, lt.viko.eif.siroochenko.restaurant.gen.Dish.class);

        return dishDto;
    }
}
