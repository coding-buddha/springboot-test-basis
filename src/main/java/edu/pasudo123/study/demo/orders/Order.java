package edu.pasudo123.study.demo.orders;

import edu.pasudo123.study.demo.orderitem.OrderDish;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "order_time", nullable = false, columnDefinition = "DATETIME")
    private LocalDateTime orderTime;

    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<OrderDish> orderDishes = new ArrayList<>();

    public static Order createOrder(final List<OrderDish> orderDishes) {
        Order order = new Order();
        order.orderDishes.addAll(orderDishes);
        order.orderTime = LocalDateTime.now();
        order.orderDishes.forEach(orderItem -> orderItem.setOrder(order));
        return order;
    }
}
