package org.example.my_bookapi_project.controller;

import org.example.my_bookapi_project.service.BookService;

public class BookController {
    public final BookService BookService;
    public BookController(BookService BookService, BookService bookService){
        this.BookService = bookService;
    }

}
