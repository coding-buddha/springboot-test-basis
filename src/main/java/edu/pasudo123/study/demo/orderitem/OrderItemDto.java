package edu.pasudo123.study.demo.orderitem;

import lombok.Getter;

public class OrderItemDto {

    @Getter
    public static class Response {

        private final long id;
        private final String name;

        public Response(OrderItem item) {
            this.id = item.getId();
            this.name = item.getName();
        }
    }
}
