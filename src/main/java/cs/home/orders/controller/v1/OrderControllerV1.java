package cs.home.orders.controller.v1;

import cs.home.orders.api.v1.OrderResourceV1;
import cs.home.orders.dto.OrderDTO;
import cs.home.orders.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderControllerV1 implements OrderResourceV1 {

    private final OrderService orderService;

    @Autowired
    public OrderControllerV1(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public ResponseEntity<List<OrderDTO>> findByCustomerId(Long customerId) {
        return ResponseEntity.ok(orderService.findByCustomerId(customerId));
    }

    @Override
    public ResponseEntity<List<OrderDTO>> findAll() {
        return ResponseEntity.ok(orderService.findAll());
    }
}
