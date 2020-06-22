package swistoww.springframework.korona.domain;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "ORDER_ITEMS")
public class OrderItem {
    @Id
    @GeneratedValue(generator = "item_inc")
    @GenericGenerator(name = "item_inc", strategy = "increment")
    @Column(name = "order_item_id", nullable = false)
    private Integer id;

    @Column(name = "product_id")
    private String productId;
    private Integer quantity;

    @Column(name = "waypoint_no")
    private Integer waypointNo;

    @Column(name = "warehouse_id")
    private String warehouseId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "delivery_id", referencedColumnName = "delivery_id", nullable = false)
    private Delivery delivery;
}
