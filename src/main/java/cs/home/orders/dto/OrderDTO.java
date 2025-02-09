package cs.home.orders.dto;

import cs.home.orders.model.definition.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDTO {

    private Long id;

    private CustomerDTO customer;

    private List<OrderItemDTO> items;

    private BigDecimal totalPrice;

    private BigDecimal totalDiscount;

    private BigDecimal finalPrice;

    @Builder.Default
    private OrderStatus status = OrderStatus.PENDING_PAYMENT;
}
