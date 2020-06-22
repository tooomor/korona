package swistoww.springframework.korona.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import swistoww.springframework.korona.domain.Delivery;

import java.util.UUID;

@Repository
public interface DeliveryRepository extends JpaRepository <Delivery, Integer> {
}
