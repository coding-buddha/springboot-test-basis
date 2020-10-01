package edu.pasudo123.study.demo;

import edu.pasudo123.study.demo.dish.Dish;
import edu.pasudo123.study.demo.dish.DishRepository;
import edu.pasudo123.study.demo.orderitem.OrderItem;
import edu.pasudo123.study.demo.orderitem.OrderItemRepository;
import edu.pasudo123.study.demo.orders.Order;
import edu.pasudo123.study.demo.orders.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class DemoJpaInitializer {

    private final DishRepository dishRepository;
    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;

    public void init() {
        // dishes
        final List<Dish> menu = Arrays.asList(
        new Dish("pork", false, 800, Dish.Type.MEAT),
        new Dish("beef", false, 700, Dish.Type.MEAT),
        new Dish("chicken", false, 400, Dish.Type.MEAT),
        new Dish("french fries", true, 530, Dish.Type.OTHER),
        new Dish("rice", true, 350, Dish.Type.OTHER),
        new Dish("season fruit", true, 120, Dish.Type.OTHER),
        new Dish("pizza", true, 550, Dish.Type.OTHER),
        new Dish("prawns", false, 300, Dish.Type.FISH),
        new Dish("salmon", false, 450, Dish.Type.FISH));

        List<Dish> savedMenu = dishRepository.saveAll(menu);

        /** order-items **/

        // first orders
        List<OrderItem> firstOrderItems = savedMenu.stream()
                .map(OrderItem::createOrderItem)
                .collect(Collectors.toList());


        Order firstOrder = Order.createOrder(firstOrderItems);
        orderRepository.save(firstOrder);

        // second orders
        List<OrderItem> secondOrderItems = savedMenu.stream()
                .map(OrderItem::createOrderItem)
                .collect(Collectors.toList());

        Order secondOrder = Order.createOrder(secondOrderItems);
        orderRepository.save(secondOrder);
    }
}
