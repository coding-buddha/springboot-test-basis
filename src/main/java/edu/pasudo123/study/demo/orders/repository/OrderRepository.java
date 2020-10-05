package edu.pasudo123.study.demo.orders.repository;

import edu.pasudo123.study.demo.orders.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>, OrderRepositoryCustom {

    @Query(value = "select distinct o from Order o join fetch o.orderDishes")
    List<Order> findAllFirstOpt();
}
