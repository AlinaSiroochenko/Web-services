package lt.viko.eif.siroochenko.rest.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * Entity class representing a Table.
 */
@Entity
public class Tables {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int number;
    private int seats;

    /**
     * Default constructor.
     */
    public Tables() {
    }

    /**
     * Constructs a new Table with the specified number and seats.
     *
     * @param number the number of the table
     * @param seats the number of seats at the table
     */
    public Tables(int number, int seats) {
        this.number = number;
        this.seats = seats;
    }

    /**
     * Gets the ID of the table.
     *
     * @return the ID of the table
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the ID of the table.
     *
     * @param id the ID to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the number of the table.
     *
     * @return the number of the table
     */
    public int getNumber() {
        return number;
    }

    /**
     * Sets the number of the table.
     *
     * @param number the number to set
     */
    public void setNumber(int number) {
        this.number = number;
    }

    /**
     * Gets the number of seats at the table.
     *
     * @return the number of seats at the table
     */
    public int getSeats() {
        return seats;
    }

    /**
     * Sets the number of seats at the table.
     *
     * @param seats the number of seats to set
     */
    public void setSeats(int seats) {
        this.seats = seats;
    }
}
