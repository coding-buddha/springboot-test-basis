package edu.pasudo123.study.demo.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "accounts")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", columnDefinition = "VARCHAR(50)", nullable = false)
    private String name;

    @Column(name = "age", columnDefinition = "BIGINT", nullable = false)
    private Long age;

    @Builder
    public Account(final String name, final long age) {
        this.name = name;
        this.age = age;
    }
}
