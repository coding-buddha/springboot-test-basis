package edu.pasudo123.study.demo.dish;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class DishService {

    private final DishRepository dishRepository;

    @Transactional(readOnly = true)
    public List<DishDto.Response> findAll(){
        List<Dish> dishes = dishRepository.findAll();

        return dishes.stream()
                .map(DishDto.Response::new)
                .sorted(Comparator.comparingInt(dish -> dish.calories))
                .collect(Collectors.toList());
    }
}