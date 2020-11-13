package edu.pasudo123.study.demo.orders;

import edu.pasudo123.study.demo.orders.repository.OrderRepository;
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
        final List<Order> orders = orderRepository.findAllFirstOpt();

        return orders.stream()
                .map(order -> {
                    final OrderDto.Response response =  new OrderDto.Response(
                            order.getId(),
                            order.getOrderTime().toString(),
                            order.getOrderDishes());

                    return response;
                })
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<OrderDto.Response> findAllByQuerydsl() {
        final List<Order> orders = orderRepository.findAllByFetchJoin();

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
