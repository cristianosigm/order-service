package cs.home.orders.service;

import cs.home.orders.dto.OrderDTO;
import cs.home.orders.model.entity.Order;
import cs.home.orders.repository.OrderRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final ModelMapper mapper;

    @Autowired
    public OrderService(OrderRepository orderRepository, ModelMapper mapper) {
        this.orderRepository = orderRepository;
        this.mapper = mapper;
    }

    public List<OrderDTO> findAll() {
        return mapToDTO(orderRepository.findAll());
    }

    public List<OrderDTO> findByCustomerId(Long customerId) {
        return mapToDTO(orderRepository.findByCustomerId(customerId));
    }

    private List<OrderDTO> mapToDTO(List<Order> items) {
        return items.stream()
            .map(it -> mapper.map(it, OrderDTO.class))
            .toList();
    }
}
