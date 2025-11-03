package mk.ukim.finki.wp.lab1.repository;

import mk.ukim.finki.wp.lab1.model.BookReservation;

import java.util.List;

public interface BookReservationRepository {
        BookReservation save(BookReservation reservation);
        List<BookReservation> findByTitle(String title);
    }

