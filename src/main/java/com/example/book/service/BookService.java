package com.example.book.service;

import com.example.book.dto.BookDto;
import com.example.book.dto.UpdateBookDto;
import com.example.book.entity.Book;
import com.example.book.repository.BookRepository;
import com.example.book.validation.BookValidationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    private final BookValidationService bookValidationService;

    @Transactional
    public void createBook(BookDto bookDto) {
        bookValidationService.ensureBookNotExist(bookDto);
        bookRepository.save(toEntity(bookDto));
    }

    @Transactional
    public void updateBook(UpdateBookDto updateBookDto) {
        bookValidationService.ensureBookExistById(updateBookDto.getId());
        bookRepository.save(toEntity(updateBookDto));
    }

    private Book toEntity(BookDto bookDto) {
        return Book.builder()
                .id(UUID.randomUUID())
                .isbn(bookDto.getIsbn())
                .name(bookDto.getName())
                .author(bookDto.getAuthor())
                .build();
    }

    private Book toEntity(UpdateBookDto updateBookDto) {
        return Book.builder()
                .id(updateBookDto.getId())
                .isbn(updateBookDto.getIsbn())
                .name(updateBookDto.getName())
                .author(updateBookDto.getAuthor())
                .build();
    }
}
