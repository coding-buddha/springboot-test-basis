package edu.pasudo123.study.demo.hibernate.book;

import edu.pasudo123.study.demo.hibernate.book.repository.BookJpaRepository;
import edu.pasudo123.study.demo.hibernate.book.repository.BookSimpleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.exception.SQLGrammarException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
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

    private static final int THREAD_POOL_SIZE = 2;
    private static final Executor EXECUTOR = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

    /**
     * @param book
     */
    @Transactional
    public void multipleSave(final Book book) {
        IntStream.range(0, 2).forEach(index -> EXECUTOR.execute(() -> {
            log.info("(1) current thread name :: {}", Thread.currentThread().getName());
            Optional<Book> optional = bookJpaRepository.findById(book.getId());

            if(optional.isPresent()) {
                optional.get().update(book);
                return;
            }

            bookJpaRepository.save(book);
            log.info("(2) current thread name :: {}", Thread.currentThread().getName());
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
    }
}
