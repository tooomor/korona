package swistoww.springframework.korona.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderItemDto {
    private UUID id;
    private UUID productId;
    private Integer quantity;
    private Integer waypointNo;
    private UUID warehouseId;
}
