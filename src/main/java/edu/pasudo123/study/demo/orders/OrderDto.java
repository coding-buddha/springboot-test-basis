package edu.pasudo123.study.demo.orders;

import edu.pasudo123.study.demo.orderitem.OrderDish;
import edu.pasudo123.study.demo.orderitem.OrderDishDto;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

public class OrderDto {

    @Getter
    public static class Response {

        private Long id;
        private String orderDate;
        private final List<OrderDishDto.Response> items;

        public Response(final Order order) {
            this.id = order.getId();
            this.orderDate = order.getOrderTime().toString();
            this.items = order.getOrderDishes()
                    .stream()
                    .map(OrderDishDto.Response::new)
                    .collect(Collectors.toList());
        }

        public Response(final long id, final String orderDate, final List<OrderDish> orderDishes) {
            this.id = id;
            this.orderDate = orderDate;
            this.items = orderDishes.stream()
                    .map(OrderDishDto.Response::new)
                    .collect(Collectors.toList());
        }
    }
}
