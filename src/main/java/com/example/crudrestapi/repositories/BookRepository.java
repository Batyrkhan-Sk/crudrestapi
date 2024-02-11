package com.example.crudrestapi.repositories;

import com.example.crudrestapi.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
//    List<Book> findByGenre(String genre);
//
//    List<Book> findByAuthor(String author);
//
//    List<Book> findByTitle(String title);

    List<Book> findByGenreOrAuthorOrTitle(String genre, String author, String title);
}
