package org.example.my_bookapi_project.controller;

import org.example.my_bookapi_project.service.BookService;

public class BookController {
    private final BookService bookService;
    public BookController(BookService bookService){
        this.bookService = bookService;
    }
    @PostMapping
    public ResponseEntity<BookResponse> create(@RequestBody BookRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(bookService.create(request));
    }
    @GetMapping
    public List<BookResponse> findAll() {
        return bookService.findAll();
    }
    @GetMapping("/{id}")
    public BookResponse findById(@PathVariable Long id) {
        return bookService.findById(id);
    }
    @PutMapping("/{id}")
    public BookResponse update(@PathVariable Long id,@RequestBody BookRequest request) {
        return bookService.update(id,request);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        bookService.delete(id); return ResponseEntity.noContent().build();
    }
}
