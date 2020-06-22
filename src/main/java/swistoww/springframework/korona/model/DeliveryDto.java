package swistoww.springframework.korona.model;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DeliveryDto {

    private Integer id;
    @Singular
    private List<OrderItemDto> items;
    private Integer routeLength;
}
