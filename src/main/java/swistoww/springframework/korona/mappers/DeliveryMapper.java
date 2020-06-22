package swistoww.springframework.korona.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;
import swistoww.springframework.korona.domain.Delivery;
import swistoww.springframework.korona.model.DeliveryDto;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface DeliveryMapper {

    DeliveryMapper INSTANCE = Mappers.getMapper(DeliveryMapper.class);

    DeliveryDto deliveryToDeliveryDto(Delivery delivery);

    Delivery deliveryDtoToDelivery(DeliveryDto deliveryDto);
}
