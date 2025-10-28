package mk.ukim.finki.wp.lab1.bootstrap;
import jakarta.annotation.PostConstruct;
import mk.ukim.finki.wp.lab1.model.Book;
import mk.ukim.finki.wp.lab1.model.BookReservation;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class DataHolder {
    public static List<Book> books = new ArrayList<>(10);
    public static List<BookReservation> reservations = new ArrayList<>();

    @PostConstruct
    public void init() {
        for (int i = 0; i < 10; i++) {
            books.add(new Book("Pipi "+i+1, "Kids", 5.0));
        }
        reservations=new ArrayList<>();
    }
}
