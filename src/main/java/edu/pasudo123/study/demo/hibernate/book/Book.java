package edu.pasudo123.study.demo.hibernate.book;

import lombok.*;
import org.apache.logging.log4j.util.Strings;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "book")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class Book {

    private static final String DASH = "-";

    @Id
    private Long id;

    @Column(name = "name", nullable = false, columnDefinition = "VARCHAR(50)")
    private String name;

    @Column(name = "isbn", nullable = false, columnDefinition = "VARCHAR(255)")
    private String isbn;

    public Book(final Long id, final String name) {
        this.id = id;
        this.name = name;
        this.isbn = UUID.randomUUID().toString().replaceAll(DASH, Strings.EMPTY).substring(0, 20);
    }

    public void update(Book book) {
        this.id = book.getId();
        this.name = book.getName();
        this.isbn = book.getIsbn();
    }
}
