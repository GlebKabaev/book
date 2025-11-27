package com.example.book.exception;

public class BookException extends BusinessException {
    public BookException(String message) {
        super("Book", message);
    }
}
