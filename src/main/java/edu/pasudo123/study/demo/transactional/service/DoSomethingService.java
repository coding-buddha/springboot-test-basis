package edu.pasudo123.study.demo.transactional.service;

import edu.pasudo123.study.demo.dish.Dish;
import edu.pasudo123.study.demo.dish.DishRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class DoSomethingService {

    private final DishRepository dishRepository;

    // public
    @Transactional
    public void publicAccessModifierSave() {
        Dish dish = new Dish("public-coffee", false, 300, Dish.Type.OTHER);
        dish = dishRepository.save(dish);

        // 롤백 수행.
        throw new RuntimeException("force runtime exception");
    }

    @Transactional
    public void publicToDefaultModifierSave(final String number) {
        this.defaultAccessModifierSave(number);
    }

    @Transactional
    void defaultAccessModifierSave(final String number) {
        Dish dish = new Dish("default-coffee".concat(number), false, 300, Dish.Type.OTHER);
        dish = dishRepository.save(dish);

        throw new RuntimeException("force runtime exception");
    }

//    @Transactional
    public void publicToPrivateModifierSave(final String number) {
        this.defaultAccessModifierSave(number);
    }

    private void privateAccessModifierSave(final String number) {
        Dish dish = new Dish("private-coffee".concat(number), false, 300, Dish.Type.OTHER);
        dish = dishRepository.save(dish);

        throw new RuntimeException("force runtime exception");
    }
}
