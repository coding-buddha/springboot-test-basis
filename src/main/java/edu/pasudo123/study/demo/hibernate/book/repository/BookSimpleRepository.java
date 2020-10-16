package edu.pasudo123.study.demo.hibernate.book.repository;

import edu.pasudo123.study.demo.hibernate.book.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class BookSimpleRepository {

    private final EntityManager em;

    public Book save(final Book book) {
        em.persist(book);
        return book;
//        if(book.getId() == null) {
//            em.persist(book);
//            return book;
//        }
//
//        return em.merge(book);
    }

    public Book findById(Long id) {
        return em.find(Book.class, id);
    }
}
