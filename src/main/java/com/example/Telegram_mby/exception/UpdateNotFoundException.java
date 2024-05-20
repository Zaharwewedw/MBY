package com.example.Telegram_mby.exception;

import org.springframework.http.ResponseEntity;

import java.util.List;

public class UpdateNotFoundException extends RuntimeException {

    public UpdateNotFoundException(String message) {
        super(message);
    }
    public UpdateNotFoundException(ResponseEntity<List<String>> message) {
        super(message.toString());
    }

}
