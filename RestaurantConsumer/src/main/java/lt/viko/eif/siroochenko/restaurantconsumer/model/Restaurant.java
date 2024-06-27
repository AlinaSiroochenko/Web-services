package lt.viko.eif.siroochenko.restaurantconsumer.model;

import java.util.List;

/**
 * Represents a restaurant with its basic information and associated dishes.
 */
public class Restaurant {
    private int id;
    private String name;
    private String address;
    private List<Dish> dishes;
    private List<Tables> tables;
    private List<Order> orders;
    private Chef chef;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }

    public List<Tables> getTables() {
        return tables;
    }

    public void setTables(List<Tables> tables) {
        this.tables = tables;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public Chef getChef() {
        return chef;
    }

    public void setChef(Chef chef) {
        this.chef = chef;
    }
}
