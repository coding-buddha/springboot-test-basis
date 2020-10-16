package edu.pasudo123.study.demo.hibernate.book;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/book")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @PostMapping("multi")
    public ResponseEntity<String> saveBookByMultiService(@RequestParam("id") Long id, @RequestParam("name") String name) {
        bookService.multipleSave(new Book(id, name));
        return ResponseEntity.ok().body("{\"status\":\"success\"}");
    }

    @PostMapping("sigle")
    public ResponseEntity<Book> saveBook(@RequestParam("id") Long id, @RequestParam("name") String name) {
        return ResponseEntity
                .ok()
                .body(bookService.save(new Book(id, name)));
    }

    @GetMapping("{id}")
    public ResponseEntity<Book> saveBook(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(bookService.findById(id));
    }

    @GetMapping("dup/{id}")
    public ResponseEntity<String> duplicateEntry(@PathVariable("id") Long id) {
        bookService.duplicateEntry(id);
        return ResponseEntity.ok().body("{\"status\":\"success\"}");
    }
}
