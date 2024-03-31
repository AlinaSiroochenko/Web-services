package lt.viko.eif.asiroochenko.restaurantapp.menu;

import lt.viko.eif.asiroochenko.restaurantapp.Util.JaxbUtilGeneric;
import lt.viko.eif.asiroochenko.restaurantapp.db.DBLoader;
import lt.viko.eif.asiroochenko.restaurantapp.db.CustomerData;
import lt.viko.eif.asiroochenko.restaurantapp.model.Customer;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.util.Scanner;

/**
 * The Menu class represents a menu for the restaurant application.
 * It provides options for interacting with customer data, such as loading customers, printing XML,
 * converting XML to POJO, generating XSD, and quitting the application.
 */
public class Menu {

    private static CustomerData customerData = new CustomerData();
    private static Scanner input = new Scanner(System.in);

    /**
     * Displays the menu options and prompts the user to make a selection.
     *
     * @return The user's choice.
     */
    public static int displayMenu() {
        System.out.println(" Make a selection ");
        System.out.println(" ----------------- ");
        System.out.printf("| 1) %20s \n", "Load customers");
        System.out.printf("| 2) %20s \n", "Print XML");
        System.out.printf("| 3) %20s \n", "Convert XML to POJO");
        System.out.printf("| 4) %20s \n", "Generate XSD");
        System.out.printf("| 5) %20s \n", "Quit");
        return input.nextInt();
    }

    /**
     * Processes the user's choice and executes the corresponding action.
     *
     * @throws JAXBException If there is an error during JAXB operation.
     */
    public static void processUserChoice() throws JAXBException {
        int userChoice;
        do {
            userChoice = displayMenu();
            switch (userChoice) {
                case 1:
                    customerData.setCustomers(DBLoader.loadCustomers());
                    break;
                case 2:
                    for (Customer customer : customerData.getCustomers()) {
                        JaxbUtilGeneric.convertToXML(customer);
                    }
                    break;
                case 3:
                    String fileName = "generated.xml";
                    Customer customer;
                    customer = JaxbUtilGeneric.convertToPOJO(new File(fileName), Customer.class);
                    System.out.println(customer);
                    break;
                case 4:
                    JaxbUtilGeneric.generateXSD(Customer.class);
                    break;
                case 5:
                    System.out.println("Thank you and goodbye!");
                    System.exit(0);
                    break;
                default:
            }
        } while (userChoice != 5);
    }
}
