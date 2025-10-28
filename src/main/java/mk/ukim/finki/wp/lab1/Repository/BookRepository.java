package mk.ukim.finki.wp.lab1.Repository;

import mk.ukim.finki.wp.lab1.model.Book;

import java.util.List;

public interface BookRepository {
        List<Book> findAll();
        List<Book> searchBooks(String text, Double rating);
    }

