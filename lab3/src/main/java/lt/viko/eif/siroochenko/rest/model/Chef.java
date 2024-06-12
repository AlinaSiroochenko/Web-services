package lt.viko.eif.siroochenko.rest.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * Entity class representing a Chef.
 */
@Entity
public class Chef {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int experience;

    /**
     * Default constructor.
     */
    public Chef() {
    }

    /**
     * Constructs a new Chef with the specified name and experience.
     *
     * @param name the name of the chef
     * @param experience the years of experience of the chef
     */
    public Chef(String name, int experience) {
        this.name = name;
        this.experience = experience;
    }

    /**
     * Gets the ID of the chef.
     *
     * @return the ID of the chef
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the ID of the chef.
     *
     * @param id the ID to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the name of the chef.
     *
     * @return the name of the chef
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the chef.
     *
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the years of experience of the chef.
     *
     * @return the years of experience
     */
    public int getExperience() {
        return experience;
    }

    /**
     * Sets the years of experience of the chef.
     *
     * @param experience the years of experience to set
     */
    public void setExperience(int experience) {
        this.experience = experience;
    }
}
