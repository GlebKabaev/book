package com.example.book.controller;

import com.example.book.dto.BookDto;
import com.example.book.dto.UpdateBookDto;
import com.example.book.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {
    private final BookService bookService;

    @PostMapping("/book")
    public ResponseEntity<String> createBook(
            @RequestBody @Valid BookDto book) {
        bookService.createBook(book);
        return ResponseEntity.ok("Книга успешно создана");
    }
    @PatchMapping("/book")
    public ResponseEntity<String> updateBook(
            @RequestBody @Valid UpdateBookDto book) {
        bookService.updateBook(book);
        return ResponseEntity.ok("Книга успешно обновлена");
    }
}
