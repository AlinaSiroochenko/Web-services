package lt.viko.eif.siroochenko.restaurant.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

/**
 * Represents a table entity with number and seats.
 * This class is annotated for persistence in a relational database using JPA.
 * It extends the {@link BaseEntity} class, inheriting its ID field.
 */
@Entity
@Table(name = "tables")
public class Tables extends BaseEntity {
    private int number;
    private int seats;

    /**
     * Default constructor.
     */
    public Tables() {
    }

    /**
     * Constructs a new Table with specified number and seats.
     *
     * @param number The number of the table.
     * @param seats The number of seats at the table.
     */
    public Tables(int number, int seats) {
        this.number = number;
        this.seats = seats;
    }

    /**
     * Returns a string representation of the table, including number and seats.
     *
     * @return A formatted string representing the table.
     */
    @Override
    public String toString() {
        return String.format("\tTable: \n" +
                "\t\tNumber: %d \n" +
                "\t\tSeats: %d \n", this.number, this.seats);
    }

    /**
     * Gets the number of the table.
     *
     * @return The number of the table.
     */
    public int getNumber() {
        return number;
    }

    /**
     * Sets the number of the table.
     *
     * @param number The new number of the table.
     */
    public void setNumber(int number) {
        this.number = number;
    }

    /**
     * Gets the number of seats at the table.
     *
     * @return The number of seats at the table.
     */
    public int getSeats() {
        return seats;
    }

    /**
     * Sets the number of seats at the table.
     *
     * @param seats The new number of seats at the table.
     */
    public void setSeats(int seats) {
        this.seats = seats;
    }
}
