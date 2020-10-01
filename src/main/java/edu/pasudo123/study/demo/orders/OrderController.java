package edu.pasudo123.study.demo.orders;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping
    public ResponseEntity<List<OrderDto.Response>> findAll() {
        return ResponseEntity.ok().body(orderService.findAll());
    }

    @GetMapping("{orderId}")
    public ResponseEntity<OrderDto.Response> findOneById(@PathVariable("orderId") final long orderId) {
        return ResponseEntity.ok().body(orderService.findById(orderId));
    }
}
