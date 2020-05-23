package edu.pasudo123.study.demo.dish;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@Sql(scripts = {"classpath:data/dish_insert.sql"})
@ActiveProfiles("test")
@DisplayName("요리 레파지토리는")
class DishRepositoryTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private DishRepository dishRepository;

    @Test
    @DisplayName("전체 요리를 조회한다.")
    public void Should_DishesSizeGreaterThanZero_When_FindAll(){
        // when
        final List<Dish> dishes = dishRepository.findAll();

        // then
        assertThat(dishes).hasSizeGreaterThan(0);
    }
}