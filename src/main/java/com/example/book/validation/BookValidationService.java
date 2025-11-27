package com.example.book.validation;

import com.example.book.dto.BookDto;
import com.example.book.entity.Book;
import com.example.book.exception.BookException;
import com.example.book.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@Service
public class BookValidationService {
    private final BookRepository bookRepository;
    private final String bookAlreadyExist;
    private final String bookNotExist;

    public BookValidationService(BookRepository bookRepository,
                                 @Value("${app.book.exception-message.already-exist}") String bookAlreadyExist,
                                 @Value("${app.book.exception-message.not-exist}") String bookNotExist) {
        this.bookRepository = bookRepository;
        this.bookAlreadyExist = bookAlreadyExist;
        this.bookNotExist = bookNotExist;
    }

    public void ensureBookNotExist(BookDto bookDto) {
        if (bookRepository.existsBookByIsbn(bookDto.getIsbn())) {
            throw new BookException(bookAlreadyExist);
        }
    }

    public void ensureBookExistById(UUID id) {
        if (!bookRepository.existsById(id)) {
            throw new BookException(bookNotExist);
        }
    }
}
