package edu.pasudo123.study.demo.transactional.service;

import edu.pasudo123.study.demo.dish.Dish;
import edu.pasudo123.study.demo.dish.DishRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

@Slf4j
@Service
@RequiredArgsConstructor
public class DoSomethingService {

    private final DishRepository dishRepository;

    @Transactional
    public void publicAccessModifierSave() {
        Dish dish = new Dish("public-coffee", false, 300, Dish.Type.OTHER);
        dish = dishRepository.save(dish);

        log.info("current transaction name : {}", TransactionSynchronizationManager.getCurrentTransactionName());

        throw new RuntimeException("force runtime exception");
    }

    @Transactional // 필요에 따라 주석처리
    public void publicToDefaultModifierSave(final String number) {
        this.defaultAccessModifierSave(number);
    }

    @Transactional // 필요에 따라 주석처리
    void defaultAccessModifierSave(final String number) {
        Dish dish = new Dish("default-coffee".concat(number), false, 300, Dish.Type.OTHER);
        dish = dishRepository.save(dish);

        throw new RuntimeException("force runtime exception");
    }

//    @Transactional
    public void publicToProtectedModifierSave(final String number) {
        this.protectedAccessModifierSave(number);
    }

    @Transactional
    protected void protectedAccessModifierSave(final String number) {
        Dish dish = new Dish("protected-coffee".concat(number), false, 300, Dish.Type.OTHER);
        dish = dishRepository.save(dish);

        throw new RuntimeException("force runtime exception");
    }

    @Transactional  // 필요에 따라 주석처리
    public void publicToPrivateModifierSave(final String number) {
        this.privateAccessModifierSave(number);
    }

    private void privateAccessModifierSave(final String number) {
        Dish dish = new Dish("private-coffee".concat(number), false, 300, Dish.Type.OTHER);
        dish = dishRepository.save(dish);

        throw new RuntimeException("force runtime exception");
    }
}
