package lt.viko.eif.siroochenko.restaurant.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

/**
 * Represents a chef entity with name and specialty.
 * This class is annotated for persistence in a relational database using JPA.
 * It extends the {@link BaseEntity} class, inheriting its ID field.
 */
@Entity
@Table(name = "chef")
public class Chef extends BaseEntity {
    private String name;
    private String specialty;

    /**
     * Default constructor.
     */
    public Chef() {
    }

    /**
     * Constructs a new Chef with specified name and specialty.
     *
     * @param name The name of the chef.
     * @param specialty The specialty of the chef.
     */
    public Chef(String name, String specialty) {
        this.name = name;
        this.specialty = specialty;
    }

    /**
     * Returns a string representation of the chef, including name and specialty.
     *
     * @return A formatted string representing the chef.
     */
    @Override
    public String toString() {
        return String.format("\tChef: \n" +
                "\t\tName: %s \n" +
                "\t\tSpecialty: %s \n", this.name, this.specialty);
    }

    /**
     * Gets the name of the chef.
     *
     * @return The name of the chef.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the chef.
     *
     * @param name The new name of the chef.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the specialty of the chef.
     *
     * @return The specialty of the chef.
     */
    public String getSpecialty() {
        return specialty;
    }

    /**
     * Sets the specialty of the chef.
     *
     * @param specialty The new specialty of the chef.
     */
    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }
}
