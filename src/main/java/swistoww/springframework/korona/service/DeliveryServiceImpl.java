package swistoww.springframework.korona.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import swistoww.springframework.korona.domain.Delivery;

import swistoww.springframework.korona.domain.OrderItem;
import swistoww.springframework.korona.mappers.DeliveryMapper;
import swistoww.springframework.korona.model.DeliveryDto;
import swistoww.springframework.korona.repositories.DeliveryRepository;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class DeliveryServiceImpl implements DeliveryService {

    private final DeliveryMapper deliveryMapper;
    private final DeliveryRepository deliveryRepository;

    @Override
    public Integer saveDelivery(DeliveryDto deliveryDto) {

        Delivery delivery = Delivery.builder().routeLength(deliveryDto.getRouteLength()).build();

        List<OrderItem> orderItems = deliveryDto.getItems().stream().map(i -> OrderItem.builder()
                .productId(i.getProductId())
                .quantity(i.getQuantity())
                .warehouseId(i.getWarehouseId())
                .waypointNo(i.getWaypointNo())
                .delivery(delivery)
                .build()).collect(Collectors.toList());

        delivery.setItems(orderItems);
        log.info(delivery.toString());
        deliveryRepository.save(delivery);
        log.info("Delivery after saving: " + delivery.toString());
        return delivery.getId();
    }

    @Override
    public Delivery getDeliveryById(UUID deliveryId) {
        String id = deliveryId.toString();
//        return deliveryRepository.findById(deliveryId).orElseThrow(NoDeliveryFoiundException::new);
        return null;
    }
}
