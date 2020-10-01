package edu.pasudo123.study.demo.orders;

import edu.pasudo123.study.demo.orderitem.OrderItemDto;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

public class OrderDto {

    @Getter
    public static class Response {

        private Long id;
        private String orderDate;
        private final List<OrderItemDto.Response> items;

        public Response(final Order order) {
            this.id = order.getId();
            this.orderDate = order.getOrderTime().toString();
            this.items = order.getOrderItems()
                    .stream()
                    .map(OrderItemDto.Response::new)
                    .collect(Collectors.toList());
        }
    }
}
