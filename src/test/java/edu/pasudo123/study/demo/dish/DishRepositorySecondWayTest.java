package edu.pasudo123.study.demo.dish;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@ActiveProfiles("test")
@DisplayName("메뉴 레파지토리에 대한 두번째 방법 테스트는")
public class DishRepositorySecondWayTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private DishRepository dishRepository;

    @Test
    @DisplayName("하나의 요리를 조회한다.")
    public void Should_DishesSizeGreaterThanZero_When_FindAll() {
        // given
        final Dish dish = new Dish("noodle", false, 330, Dish.Type.OTHER);
        testEntityManager.persistAndFlush(dish);

        // when
        final Dish foundDish = dishRepository.getOne(1L);

        // then
        assertThat(foundDish.getName()).isEqualTo("noodle");
    }
}
