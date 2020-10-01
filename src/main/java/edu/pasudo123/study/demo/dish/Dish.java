package edu.pasudo123.study.demo.dish;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "dish")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class Dish {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", unique = true, nullable = false, columnDefinition = "VARCHAR(50)", length = 50)
    private String name;

    @Column(name = "vegetarian", nullable = false, columnDefinition = "BOOLEAN")
    private boolean vegetarian;

    @Column(name = "calories", nullable = false, columnDefinition = "INT")
    private int calories;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false, columnDefinition = "ENUM('MEAT', 'FISH', 'OTHER')")
    private Type type;

    public enum Type{
        MEAT, FISH, OTHER
    }

    @Builder
    public Dish(final String name,
                final boolean vegetarian,
                final int calories,
                final Type type) {

        this.name = name;
        this.vegetarian = vegetarian;
        this.calories = calories;
        this.type = type;
    }

    public boolean isVegetarian(){
        return vegetarian;
    }
}
