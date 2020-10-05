package edu.pasudo123.study.demo.orders.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import edu.pasudo123.study.demo.orders.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static edu.pasudo123.study.demo.orderitem.QOrderDish.orderDish;
import static edu.pasudo123.study.demo.orders.QOrder.order;

@RequiredArgsConstructor
@Transactional(readOnly = true)
public class OrderRepositoryCustomImpl implements OrderRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    public List<Order> findAllByFetchJoin() {
        return queryFactory
                .selectFrom(order)
                .join(order.orderDishes, orderDish)
                .fetchJoin()
                .distinct()
                .fetch();
    }
}
