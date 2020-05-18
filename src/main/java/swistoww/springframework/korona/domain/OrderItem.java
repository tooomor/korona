package swistoww.springframework.korona.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "ORDER_ITEMS")
public class OrderItem {
    @Id
    @Type(type="uuid-char")
    @Column(name = "order_item_id", length = 36, columnDefinition = "varchar", nullable = false)
    private UUID id;

    @Type(type="uuid-char")
    @Column(name = "product_id", length = 36)
    private UUID productId;
    private Integer quantity;

    @Column(name = "waypoint_no")
    private Integer waypointNo;

    @Type(type="uuid-char")
    @Column(name = "warehouse_id", length = 36)
    private UUID warehouseId;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="delivery_id", nullable = false)
    private Delivery delivery;
}
