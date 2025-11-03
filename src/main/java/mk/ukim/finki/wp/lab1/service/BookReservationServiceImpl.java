package mk.ukim.finki.wp.lab1.service;

import mk.ukim.finki.wp.lab1.model.BookReservation;
import mk.ukim.finki.wp.lab1.repository.BookReservationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookReservationServiceImpl implements BookReservationService {
    private final BookReservationRepository bookReservationRepository;

    public BookReservationServiceImpl(BookReservationRepository bookReservationRepository) {
        this.bookReservationRepository = bookReservationRepository;
    }

    @Override
    public BookReservation placeReservation(String bookTitle, String readerName, String readerAddress, long numberOfCopies) {
        BookReservation bookReservation = new BookReservation(bookTitle, readerName, readerAddress, numberOfCopies);
        return bookReservationRepository.save(bookReservation);
    }

    @Override
    public List<BookReservation> getBookReservationsByTitle(String bookTitle) {
        return bookReservationRepository.findByTitle(bookTitle);
    }
}
