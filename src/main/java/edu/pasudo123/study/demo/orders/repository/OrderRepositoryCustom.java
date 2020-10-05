package edu.pasudo123.study.demo.orders.repository;

import edu.pasudo123.study.demo.orders.Order;

import java.util.List;

public interface OrderRepositoryCustom {

    public List<Order> findAllByFetchJoin();
}
