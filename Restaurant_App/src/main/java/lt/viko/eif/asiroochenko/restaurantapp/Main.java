package lt.viko.eif.asiroochenko.restaurantapp;

import lt.viko.eif.asiroochenko.restaurantapp.db.DBLoader;
import lt.viko.eif.asiroochenko.restaurantapp.menu.Menu;

import javax.xml.bind.JAXBException;

/**
 * The Main class is the entry point of the restaurant application.
 * It contains the main method which initializes the application and starts the menu processing.
 */
public class Main {

    /**
     * The main method of the application.
     * It initializes the application and starts the menu processing.
     *
     * @param args The command-line arguments.
     * @throws JAXBException If there is an error during JAXB operation.
     */
    public static void main(String[] args) throws JAXBException {
//         new DBLoader();
        Menu.processUserChoice();
    }
}
