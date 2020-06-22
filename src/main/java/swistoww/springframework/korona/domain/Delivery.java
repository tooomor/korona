package swistoww.springframework.korona.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "DELIVERIES")
public class Delivery {

    @Id
    @GeneratedValue(generator = "delivery_inc")
    @GenericGenerator(name = "delivery_inc", strategy = "increment")
    @Column(name = "delivery_id", updatable = false, nullable = false)
    private Integer id;
    @Column(name = "route_length")
    private Integer routeLength;

    @OneToMany(mappedBy = "delivery", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<OrderItem> items;
}
