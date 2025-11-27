package com.example.book.controller;

import com.example.book.dto.ClientDto;
import com.example.book.dto.ShortBookDto;
import com.example.book.dto.BookDto;
import com.example.book.dto.ShortClientDto;
import com.example.book.service.BookService;
import com.example.book.service.ClientService;
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
    public ResponseEntity<String> updateBook(
            @RequestBody @Valid ClientDto clientDto) {
        clientService.updateClient(clientDto);
        return ResponseEntity.ok("Клиент успешно обновлен");
    }


}
