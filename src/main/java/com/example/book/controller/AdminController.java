package com.example.book.controller;

import com.example.book.dto.*;
import com.example.book.service.BookService;
import com.example.book.service.ClientService;
import com.example.book.service.RentalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {
    private final BookService bookService;
    private final ClientService clientService;
    private final RentalService rentalService;

    @PostMapping("/book")
    public ResponseEntity<String> createBook(
            @RequestBody @Valid ShortBookDto book) {
        bookService.createBook(book);
        return ResponseEntity.ok("Книга успешно создана");
    }

    @PatchMapping("/book")
    public ResponseEntity<String> updateBook(
            @RequestBody @Valid BookDto book) {
        bookService.updateBook(book);
        return ResponseEntity.ok("Книга успешно обновлена");
    }

    @GetMapping("/book")
    public ResponseEntity<List<BookDto>> findAllBooks() {
        return ResponseEntity.ok(bookService.findAllBooks());
    }

    @PostMapping("/client")
    public ResponseEntity<String> createClient(
            @RequestBody @Valid ShortClientDto client) {
        clientService.createClient(client);
        return ResponseEntity.ok("Клиент успешно создан");
    }

    @PatchMapping("/client")
    public ResponseEntity<String> updateClient(
            @RequestBody @Valid ClientDto clientDto) {
        clientService.updateClient(clientDto);
        return ResponseEntity.ok("Клиент успешно обновлен");
    }

    @GetMapping("/client")
    public ResponseEntity<List<ClientDto>> findAllClients() {
        return ResponseEntity.ok(clientService.findAllClients());
    }

    @PostMapping("/rental")
    public ResponseEntity<String> createRental(
            @RequestBody @Valid CreateRentalDto createRentalDto) {
        rentalService.createRental(createRentalDto);
        return ResponseEntity.ok("Аренда успешно создана");
    }

    @GetMapping("/rental")
    public ResponseEntity<List<BookRentalDto>> findAllRentals() {

        return ResponseEntity.ok(rentalService.findAllRentals());
    }
}
