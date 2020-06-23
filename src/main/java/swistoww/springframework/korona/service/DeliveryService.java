package swistoww.springframework.korona.service;

import swistoww.springframework.korona.domain.Delivery;
import swistoww.springframework.korona.model.DeliveryDto;

import java.util.UUID;

public interface DeliveryService {
    Integer saveDelivery(DeliveryDto delivery);

    DeliveryDto getDeliveryById(Integer deliveryId);
}
