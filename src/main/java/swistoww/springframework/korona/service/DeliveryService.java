package swistoww.springframework.korona.service;

import org.springframework.stereotype.Service;
import swistoww.springframework.korona.domain.Delivery;

import java.util.UUID;

public interface DeliveryService {
    UUID saveDelivery(Delivery delivery);

    Delivery getDeliveryById(UUID deliveryId);
}
