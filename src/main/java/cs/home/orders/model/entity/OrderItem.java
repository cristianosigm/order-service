package cs.home.orders.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "purchase_order_item", schema = "purchase_order")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long orderId;

    @NotNull
    private Long productId;

    @NotEmpty
    private String productName;

    @NotNull
    @Builder.Default
    private BigDecimal unitPrice = BigDecimal.ZERO;

    private Integer quantity;
}
