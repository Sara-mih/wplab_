package mk.ukim.finki.wp.lab1.repository.impl;

import mk.ukim.finki.wp.lab1.repository.BookReservationRepository;
import mk.ukim.finki.wp.lab1.bootstrap.DataHolder;
import mk.ukim.finki.wp.lab1.model.BookReservation;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class InMemoryBookReservationRepository implements BookReservationRepository {

    @Override
    public BookReservation save(BookReservation reservation) {
        DataHolder.reservations.add(reservation);
        return reservation;
    }

    @Override
    public List<BookReservation> findByTitle(String title) {
        return DataHolder.reservations.stream().filter(br -> br.getBookTitle().equals(title)).toList();
    }
}
