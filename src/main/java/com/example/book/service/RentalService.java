package com.example.book.service;

import com.example.book.dto.CreateRentalDto;
import com.example.book.dto.BookRentalDto;
import com.example.book.entity.Book;
import com.example.book.entity.BookRental;
import com.example.book.entity.Client;
import com.example.book.repository.BookRentalRepository;
import com.example.book.repository.BookRepository;
import com.example.book.repository.ClientRepository;
import com.example.book.validation.BookValidatorService;
import com.example.book.validation.ClientValidatorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RentalService {
    private final ClientService clientService;
    private final BookService bookService;

    private final BookRepository bookRepository;
    private final ClientRepository clientRepository;
    private final BookRentalRepository bookRentalRepository;

    private final ClientValidatorService clientValidatorService;
    private final BookValidatorService bookValidatorService;

    @Transactional
    public void createRental(CreateRentalDto createRentalDto) {
        UUID clientId = createRentalDto.getClientId();
        UUID bookId = createRentalDto.getBookId();

        clientValidatorService.ensureClientExistById(clientId);
        bookValidatorService.ensureBookExistById(bookId);

        BookRental bookRental = BookRental.builder()
                .date(LocalDate.now())
                .id(UUID.randomUUID())
                .book(bookRepository.findById(bookId).get())
                .client(clientRepository.findById(clientId).get())
                .build();
        bookRentalRepository.save(bookRental);

    }

    @Transactional(readOnly = true)
    public List<BookRentalDto> findAllRentals() {
        return bookRentalRepository.findAllWithClientAndBook().stream()
                .map(this::toDto)
                .collect(Collectors.toList());

    }

    private BookRentalDto toDto(BookRental bookRental) {
        Book book = bookRental.getBook();
        Client client = bookRental.getClient();
        return BookRentalDto.builder()
                .bookDto(bookService.toBookDto(book))
                .clientDto(clientService.toDto(client))
                .date(bookRental.getDate())
                .build();
    }
}
