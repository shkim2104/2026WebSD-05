package org.example.my_bookapi_project.repository;

import org.example.my_bookapi_project.domain.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class MemoryBookRepository implements BookRepository {
    private final Map<Long, Book> store = new LinkedHashMap<>();
    private long sequence = 0L;
    @Override public Book save(Book book) { book.setId(++sequence); store.put(book.getId(), book); return book; }
    @Override public List<Book> findAll() { return new ArrayList<>(store.values()); }
    @Override public Optional<Book> findById(Long id) { return Optional.ofNullable(store.get(id)); }
    @Override public Book update(Book book) { store.put(book.getId(), book); return book; }
    @Override public void deleteById(Long id) { store.remove(id); }
}
