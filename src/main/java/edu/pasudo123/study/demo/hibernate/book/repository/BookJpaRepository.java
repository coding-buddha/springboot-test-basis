package edu.pasudo123.study.demo.hibernate.book.repository;

import edu.pasudo123.study.demo.hibernate.book.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookJpaRepository extends JpaRepository<Book, Long> {
}
