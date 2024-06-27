package lt.viko.eif.siroochenko.restaurant.model;

import jakarta.persistence.*;

/**
 * An abstract base class for entities, providing a common ID property.
 * This class is annotated for use with JPA (Java Persistence API) for database operations.
 * The ID property is automatically generated for database entities.
 */
@MappedSuperclass
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    /**
     * Default constructor.
     */
    public BaseEntity() {
    }

    /**
     * Constructs a new BaseEntity with a specified ID.
     *
     * @param id the ID of the entity.
     */
    public BaseEntity(int id) {
        this.id = id;
    }

    /**
     * Returns the ID of this entity.
     *
     * @return the ID of the entity.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the ID of this entity.
     *
     * @param id the new ID of the entity.
     */
    public void setId(int id) {
        this.id = id;
    }
}
