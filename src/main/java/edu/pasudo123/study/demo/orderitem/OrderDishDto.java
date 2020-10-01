package edu.pasudo123.study.demo.orderitem;

import lombok.Getter;

public class OrderDishDto {

    @Getter
    public static class Response {

        private final long id;
        private final String name;

        public Response(OrderDish item) {
            this.id = item.getId();
            this.name = item.getName();
        }
    }
}
