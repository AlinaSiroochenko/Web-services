package lt.viko.eif.siroochenko.restaurant.db;

import lt.viko.eif.siroochenko.restaurant.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantJPARepository extends JpaRepository<Order, Integer> {
}
