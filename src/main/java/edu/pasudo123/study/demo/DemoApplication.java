package edu.pasudo123.study.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication /**implements CommandLineRunner **/ {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

//    @Override
//    public void run(String... args) throws Exception {
//
//        final List<Dish> menu = Arrays.asList(
//                new Dish("pork", false, 800, Dish.Type.MEAT),
//                new Dish("beef", false, 700, Dish.Type.MEAT),
//                new Dish("chicken", false, 400, Dish.Type.MEAT),
//                new Dish("french fries", true, 530, Dish.Type.OTHER),
//                new Dish("rice", true, 350, Dish.Type.OTHER),
//                new Dish("season fruit", true, 120, Dish.Type.OTHER),
//                new Dish("pizza", true, 550, Dish.Type.OTHER),
//                new Dish("prawns", false, 300, Dish.Type.FISH),
//                new Dish("salmon", false, 450, Dish.Type.FISH));
//
//        List<Dish> savedMenu = dishRepository.saveAll(menu);
//        savedMenu.forEach(System.out::println);
//    }
}
