package edu.pasudo123.study.demo.orders;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    @Transactional(readOnly = true)
    public List<OrderDto.Response> findAll() {
        final List<Order> orders = orderRepository.findAll();

        return orders.stream()
                .map(OrderDto.Response::new)
                .collect(Collectors.toList());

    }

    @Transactional(readOnly = true)
    public OrderDto.Response findById(final long orderId) {
        final Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new EntityNotFoundException("엔티티가 존재하지 않습니다."));

        return new OrderDto.Response(order);
    }
}
