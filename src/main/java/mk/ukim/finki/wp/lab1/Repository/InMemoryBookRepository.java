package mk.ukim.finki.wp.lab1.Repository;
import mk.ukim.finki.wp.lab1.bootstrap.DataHolder;
import mk.ukim.finki.wp.lab1.model.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class InMemoryBookRepository implements BookRepository {
    @Override
    public List<Book> findAll() {
        return DataHolder.books;
    }


    @Override
    public List<Book> searchBooks(String text, Double rating) {
        return DataHolder.books.stream()
                .filter(book ->
                        (text == null || text.isEmpty() ||
                                book.getTitle().toLowerCase().contains(text.toLowerCase())) &&
                                (rating == null || book.getAverageRating() >= rating)
                )
                .collect(Collectors.toList());
    }
}

