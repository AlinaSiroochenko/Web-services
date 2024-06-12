package lt.viko.eif.siroochenko.rest.repository;

import lt.viko.eif.siroochenko.rest.model.Dish;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for managing {@link Dish} entities.
 * This interface extends the JpaRepository interface provided by Spring Data JPA,
 * which includes basic CRUD operations and other common database interactions.
 */
public interface DishRepository extends JpaRepository<Dish, Long> {
}
