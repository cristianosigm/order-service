package cs.home.orders.model.entity;

import cs.home.orders.model.definition.OrderStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "purchase_order", schema = "purchase_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long customerId;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "orderId")
    private List<OrderItem> items;

    @NotNull
    @Builder.Default
    private BigDecimal totalPrice = BigDecimal.ZERO;

    @NotNull
    @Builder.Default
    private BigDecimal totalDiscount = BigDecimal.ZERO;

    @NotNull
    @Builder.Default
    private BigDecimal finalPrice = BigDecimal.ZERO;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;
}
