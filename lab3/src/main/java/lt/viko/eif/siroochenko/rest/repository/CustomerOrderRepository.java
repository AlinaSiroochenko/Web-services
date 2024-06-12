package lt.viko.eif.siroochenko.rest.repository;

import lt.viko.eif.siroochenko.rest.model.CustomerOrder;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for managing {@link CustomerOrder} entities.
 * This interface extends the JpaRepository interface provided by Spring Data JPA,
 * which includes basic CRUD operations and other common database interactions.
 */
public interface CustomerOrderRepository extends JpaRepository<CustomerOrder, Long> {
}
