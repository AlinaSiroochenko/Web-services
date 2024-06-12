package lt.viko.eif.siroochenko.rest.repository;

import lt.viko.eif.siroochenko.rest.model.Chef;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for managing {@link Chef} entities.
 * This interface extends the JpaRepository interface provided by Spring Data JPA,
 * which includes basic CRUD operations and other common database interactions.
 */
public interface ChefRepository extends JpaRepository<Chef, Long> {
}
