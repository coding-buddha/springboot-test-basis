package edu.pasudo123.study.demo.orderitem;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDIshRepository extends JpaRepository<OrderDish, Long> {
}
