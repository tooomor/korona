package swistoww.springframework.korona.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import swistoww.springframework.korona.domain.Delivery;
import swistoww.springframework.korona.model.DeliveryDto;

@Mapper
public interface DeliveryMapper {

    DeliveryMapper INSTANCE = Mappers.getMapper(DeliveryMapper.class);

    DeliveryDto deliveryToDeliveryDto(Delivery delivery);

    Delivery deliveryDtoToDelivery(DeliveryDto deliveryDto);
}
