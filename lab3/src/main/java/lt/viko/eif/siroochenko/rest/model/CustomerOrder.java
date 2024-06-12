package lt.viko.eif.siroochenko.rest.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.Date;

/**
 * Entity class representing a Customer Order.
 */
@Entity
public class CustomerOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date;
    private String status;

    /**
     * Default constructor.
     */
    public CustomerOrder() {
    }

    /**
     * Constructs a new CustomerOrder with the specified date and status.
     *
     * @param date the date of the order
     * @param status the status of the order
     */
    public CustomerOrder(Date date, String status) {
        this.date = date;
        this.status = status;
    }

    /**
     * Gets the ID of the order.
     *
     * @return the ID of the order
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the ID of the order.
     *
     * @param id the ID to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the date of the order.
     *
     * @return the date of the order
     */
    public Date getDate() {
        return date;
    }

    /**
     * Sets the date of the order.
     *
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Gets the status of the order.
     *
     * @return the status of the order
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the status of the order.
     *
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }
}
