package edu.pasudo123.study.demo.hibernate.book;

import edu.pasudo123.study.demo.hibernate.book.repository.BookJpaRepository;
import edu.pasudo123.study.demo.hibernate.book.repository.BookSimpleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.exception.SQLGrammarException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class BookService {

    private final BookSimpleRepository bookSimpleRepository;
    private final BookJpaRepository bookJpaRepository;
    private final EntityManager em;

    private static final int THREAD_POOL_SIZE = 2;
    private static final Executor EXECUTOR = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
    
    public void multipleSave(final Book book) {
        IntStream.range(0, 2).forEach(index -> EXECUTOR.execute(() -> {
            bookJpaRepository.save(book);
        }));
    }

    public Book save(final Book book) {
        Book book1 = new Book(book.getId(), book.getName() + "1");
        Book book2 = new Book(book.getId(), book.getName() + "2");
        Book book3 = new Book(book.getId(), book.getName() + "3");
        List<Book> books = Arrays.asList(book1, book2, book3);
        for(Book element : books) {
            bookJpaRepository.save(element);
        }

        return null;
    }

    public Book findById(final Long id) {
        return bookSimpleRepository.findById(id);
    }

    public void duplicateEntry(final Long id) {

        // 동일
        Book book1 = new Book(id, "My story");
        Book book2 = new Book(id, "My story");

        em.persist(book1);
        em.flush();
        em.clear();

        try {
            em.persist(book2);
            em.flush();
        } catch (SQLGrammarException e) {
            log.error("(1) ====> ");
            log.error("error {} ", e.getMessage());
        } catch (Exception e) {
            log.error("(2) ====> ");
            log.error("error {} ", e.getMessage());
        }
    }
}
