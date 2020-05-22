package edu.pasudo123.study.demo.dish;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class DishDto {

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    static class Response{
        String name;
        boolean vegetarian;
        int calories;
        Dish.Type type;

        public Response(Dish dish) {
            this.name = dish.getName();
            this.vegetarian = dish.isVegetarian();
            this.calories = dish.getCalories();
            this.type = dish.getType();
        }
    }
}
