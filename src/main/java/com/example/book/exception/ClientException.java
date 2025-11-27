package com.example.book.exception;

public class ClientException extends BusinessException {
    public ClientException(String message) {
        super("Client", message);
    }
}
