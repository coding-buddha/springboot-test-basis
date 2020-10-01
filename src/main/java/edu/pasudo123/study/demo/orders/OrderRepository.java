package edu.pasudo123.study.demo.orders;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query(value = "select distinct o from Order o join fetch o.orderDishes")
    List<Order> findAllFirstOpt();
}
