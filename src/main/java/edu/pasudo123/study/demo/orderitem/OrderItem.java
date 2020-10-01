package edu.pasudo123.study.demo.orderitem;


import edu.pasudo123.study.demo.dish.Dish;
import edu.pasudo123.study.demo.orders.Order;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@Entity
@Table(name = "order_item")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false, columnDefinition = "VARCHAR(50)", length = 50)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dish_id")
    private Dish dish;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orders_id")
    private Order order;

    public static OrderItem createOrderItem(final Dish dish) {
        OrderItem orderItem = new OrderItem();
        orderItem.dish = dish;
        orderItem.name = dish.getName();
        return orderItem;
    }

    public void setOrder(final Order order) {
        this.order = order;
    }
}
