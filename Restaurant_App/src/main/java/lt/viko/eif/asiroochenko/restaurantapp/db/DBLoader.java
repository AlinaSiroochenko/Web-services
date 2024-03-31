/**
 * The DBLoader class provides methods for interacting with the database
 * to load customers and perform other database operations.
 */
package lt.viko.eif.asiroochenko.restaurantapp.db;

import lt.viko.eif.asiroochenko.restaurantapp.Util.HibernateUtil;
import lt.viko.eif.asiroochenko.restaurantapp.model.Chef;
import lt.viko.eif.asiroochenko.restaurantapp.model.Customer;
import lt.viko.eif.asiroochenko.restaurantapp.model.Dish;
import lt.viko.eif.asiroochenko.restaurantapp.model.Tables;
import lt.viko.eif.asiroochenko.restaurantapp.model.Order;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class DBLoader {

//    public static void main(String[] args) {
//        Customer customer1 = new Customer("John", "Smith", 1);
//        Dish dish1 = new Dish("Pasta Carbonara", 10);
//        Dish dish2 = new Dish("Steak", 8);
//        customer1.getDishes().add(dish1);
//        customer1.getDishes().add(dish2);
//        Chef chef1 = new Chef("Alice", "Johnson");
//        customer1.setChef(chef1);
//        Tables table1 = new Tables(1, 4);
//        customer1.setTables(table1);
//        Order order1 = new Order(18, "In process");
//        customer1.setOrder(order1);
//
//        Transaction transaction = null;
//        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//            transaction = session.beginTransaction();
//            session.save(customer1);
//            transaction.commit();
//            System.out.println("Customer saved successfully!");
//        } catch (Exception e) {
//            if (transaction != null) {
//                transaction.rollback();
//            }
//            e.printStackTrace();
//        }
//    }

    /**
     * Loads a list of customers from the database.
     *
     * @return List of Customer objects representing customers loaded from the database.
     */
    public static List<Customer> loadCustomers() {
        List<Customer> result = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            result = session.createQuery("from Customer", Customer.class).list();
            result.forEach(customer -> System.out.println(customer));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}