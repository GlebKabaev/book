package com.example.book.repository;

import com.example.book.entity.BookRental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface BookRentalRepository extends JpaRepository<BookRental, UUID> {
    @Query("SELECT br FROM BookRental br " +
            "JOIN FETCH br.client " +
            "JOIN FETCH br.book " +
            "ORDER BY br.date DESC")
    List<BookRental> findAllWithClientAndBook();
}
