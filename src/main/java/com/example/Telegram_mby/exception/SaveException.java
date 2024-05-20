package com.example.Telegram_mby.exception;

import org.springframework.http.ResponseEntity;

import java.util.List;

public class SaveException  extends RuntimeException {

    public SaveException (String message) {
        super(message);
    }

    public SaveException(ResponseEntity<List<String>> message) {
        super(message.toString());
    }
}
