package mk.ukim.finki.wp.lab1.service;
import mk.ukim.finki.wp.lab1.Repository.BookRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import mk.ukim.finki.wp.lab1.model.Book;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> listAll() {
        return this.bookRepository.findAll();
    }

    @Override
    public List<Book> searchBooks(String text, Double rating) {
        return List.of();
    }
}