package swistoww.springframework.korona.service;

import org.springframework.stereotype.Service;
import swistoww.springframework.korona.domain.Delivery;
import swistoww.springframework.korona.domain.NoDeliveryFoiundException;
import swistoww.springframework.korona.repositories.DeliveryRepository;

import java.util.UUID;

@Service
public class DeliveryServiceImpl implements DeliveryService {

    private final DeliveryRepository deliveryRepository;

    public DeliveryServiceImpl(DeliveryRepository deliveryRepository) {
        this.deliveryRepository = deliveryRepository;
    }

    @Override
    public UUID saveDelivery(Delivery delivery) {

        return deliveryRepository.save(delivery).getId();
    }

    @Override
    public Delivery getDeliveryById(UUID deliveryId) {
        String id = deliveryId.toString();
        return deliveryRepository.findById(deliveryId).orElseThrow(NoDeliveryFoiundException::new);
    }
}
