package com.example.crudrestapi.controllers;

import com.example.crudrestapi.services.BookService;
import com.example.crudrestapi.models.Book;
import jakarta.annotation.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping()
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id) {
        return bookService.findBookById(id);
    }

    @PostMapping
    public Book addBook(@RequestBody Book book) {
        return bookService.createBook(book);
    }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book book) {
        return bookService.updateBook(id, book);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
    }

    @GetMapping("/filter")
    public List<Book> getByFilter(@RequestParam @Nullable String genre, @RequestParam  @Nullable String author, @RequestParam  @Nullable String title) {
        return bookService.findBooksByGenreAuthorTitle(genre, author, title);
    }
}
