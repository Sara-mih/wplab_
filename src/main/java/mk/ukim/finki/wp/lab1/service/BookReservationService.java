package mk.ukim.finki.wp.lab1.service;

import mk.ukim.finki.wp.lab1.model.Book;
import mk.ukim.finki.wp.lab1.model.BookReservation;

import java.util.List;

public interface BookReservationService {
    BookReservation placeReservation(String bookTitle, String readerName, String readerAddress, long numberOfCopies);
    List<BookReservation> getBookReservationsByTitle(String bookTitle);
}
