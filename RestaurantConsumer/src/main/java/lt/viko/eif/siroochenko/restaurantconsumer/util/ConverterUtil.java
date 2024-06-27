package lt.viko.eif.siroochenko.restaurantconsumer.util;

import lt.viko.eif.siroochenko.restaurantconsumer.model.*;
import lt.viko.eif.siroochenko.restaurantconsumer.model.Chef;
import lt.viko.eif.siroochenko.restaurantconsumer.model.Dish;
import lt.viko.eif.siroochenko.restaurantconsumer.model.Restaurant;
import lt.viko.eif.siroochenko.restaurantconsumer.model.Tables;
import lt.viko.eif.siroochenko.restaurantconsumer.wsdl.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Utility class for converting between different data transfer objects (DTOs) and entities using ModelMapper.
 */
@Service
public class ConverterUtil {

    @Autowired
    private ModelMapper modelMapper;

    /**
     * Converts a Customer entity to its corresponding DTO.
     * @param customer The Customer entity to be converted.
     * @return The corresponding Customer DTO.
     */
    public Customer convertToDto(Customer customer) {
        return modelMapper.map(customer, Customer.class);
    }

    /**
     * Converts a Dish entity to its corresponding DTO.
     * @param dish The Dish entity to be converted.
     * @return The corresponding Dish DTO.
     */
    public Dish convertToDto(Dish dish) {
        return modelMapper.map(dish, Dish.class);
    }

    /**
     * Converts an Order entity to its corresponding DTO.
     * @param order The Order entity to be converted.
     * @return The corresponding Order DTO.
     */
    public Order convertToDto(Order order) {
        Order orderDto = modelMapper.map(order, Order.class);

        if (order.getDishes() != null && order.getDishes().size() > 0) {
            ArrayList<Dish> dishList = new ArrayList<>();
            order.getDishes().forEach(dish -> dishList.add(convertToDto(dish)));
            orderDto.setDishes(dishList);
        }

        return orderDto;
    }

    /**
     * Converts a Tables entity to its corresponding DTO.
     * @param table The Tables entity to be converted.
     * @return The corresponding Tables DTO.
     */
    public Tables convertToDto(Tables table) {
        return modelMapper.map(table, Tables.class);
    }

    /**
     * Converts a Chef entity to its corresponding DTO.
     * @param chef The Chef entity to be converted.
     * @return The corresponding Chef DTO.
     */
    public Chef convertToDto(Chef chef) {
        return modelMapper.map(chef, Chef.class);
    }

    /**
     * Converts a Restaurant entity to its corresponding DTO.
     * @param restaurant The Restaurant entity to be converted.
     * @return The corresponding Restaurant DTO.
     */
    public lt.viko.eif.siroochenko.restaurantconsumer.wsdl.Restaurant convertToDto(Restaurant restaurant) {
        return modelMapper.map(restaurant, lt.viko.eif.siroochenko.restaurantconsumer.wsdl.Restaurant.class);
    }

    /**
     * Converts a Customer DTO to its corresponding entity.
     * @param customer The Customer DTO to be converted.
     * @return The corresponding Customer entity.
     */
    public Customer convertToEntity(Customer customer) {
        return modelMapper.map(customer, Customer.class);
    }

    /**
     * Converts a Dish DTO to its corresponding entity.
     * @param dish The Dish DTO to be converted.
     * @return The corresponding Dish entity.
     */
    public Dish convertToEntity(Dish dish) {
        return modelMapper.map(dish, Dish.class);
    }

    /**
     * Converts an Order DTO to its corresponding entity.
     * @param order The Order DTO to be converted.
     * @return The corresponding Order entity.
     */
    public Order convertToEntity(Order order) {
        Order orderEntity = modelMapper.map(order, Order.class);

        if (order.getDishes() != null && order.getDishes().size() > 0) {
            orderEntity.setDishes(new ArrayList<>());
            order.getDishes().forEach(dishDto -> orderEntity.getDishes().add(convertToEntity(dishDto)));
        }

        return orderEntity;
    }

    /**
     * Converts a Tables DTO to its corresponding entity.
     * @param table The Tables DTO to be converted.
     * @return The corresponding Tables entity.
     */
    public Tables convertToEntity(Tables table) {
        return modelMapper.map(table, Tables.class);
    }

    /**
     * Converts a Chef DTO to its corresponding entity.
     * @param chef The Chef DTO to be converted.
     * @return The corresponding Chef entity.
     */
    public Chef convertToEntity(Chef chef) {
        return modelMapper.map(chef, Chef.class);
    }

    /**
     * Converts a Restaurant DTO to its corresponding entity.
     * @param restaurant The Restaurant DTO to be converted.
     * @return The corresponding Restaurant entity.
     */
    public Restaurant convertToEntity(lt.viko.eif.siroochenko.restaurantconsumer.wsdl.Restaurant restaurant) {
        return modelMapper.map(restaurant, Restaurant.class);
    }
}
