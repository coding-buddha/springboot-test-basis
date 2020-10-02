package edu.pasudo123.study.demo;

import edu.pasudo123.study.demo.dish.Dish;
import edu.pasudo123.study.demo.dish.DishRepository;
import edu.pasudo123.study.demo.orderitem.OrderDish;
import edu.pasudo123.study.demo.orders.Order;
import edu.pasudo123.study.demo.orders.OrderRepository;
import edu.pasudo123.study.demo.profile.Profile;
import edu.pasudo123.study.demo.profile.ProfileDetail;
import edu.pasudo123.study.demo.profile.ProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class DemoJpaInitializer {

    private final DishRepository dishRepository;
    private final OrderRepository orderRepository;
    private final ProfileRepository profileRepository;

    public void initOneToOneExSampleEntity() {
        // profile
        Profile profile = new Profile("PARK SUNG DONG", new ProfileDetail("Tong Yeong"));
        profileRepository.save(profile);
    }

    public void initOneToManyExSampleEntity() {
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

        /** first orders **/
        List<OrderDish> firstOrderDishes = savedMenu.stream()
                .map(OrderDish::createOrderItem)
                .collect(Collectors.toList());


        Order firstOrder = Order.createOrder(firstOrderDishes);
        orderRepository.save(firstOrder);

        /** second orders **/
        List<OrderDish> secondOrderDishes = savedMenu.stream()
                .map(OrderDish::createOrderItem)
                .collect(Collectors.toList());

        Order secondOrder = Order.createOrder(secondOrderDishes);
        orderRepository.save(secondOrder);

        /** third orders **/
        List<OrderDish> thirdOrderDishes = savedMenu.stream()
                .map(OrderDish::createOrderItem)
                .collect(Collectors.toList());

        Order thirdOrder = Order.createOrder(thirdOrderDishes);
        orderRepository.save(thirdOrder);
    }
}
