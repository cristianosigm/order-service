package cs.home.orders.api.v1;

import cs.home.orders.dto.OrderDTO;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/api/v1/orders")
public interface OrderResourceV1 {

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<OrderDTO>> findAll();

    @GetMapping("/by-customer")
    ResponseEntity<List<OrderDTO>> findByCustomerId(@RequestHeader Long customerId);
}
