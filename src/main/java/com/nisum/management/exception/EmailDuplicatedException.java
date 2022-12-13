package com.nisum.management.exception;

import lombok.Data;

@Data
public class EmailDuplicatedException extends RuntimeException {

    public EmailDuplicatedException(String message) {
        super(message);
    }
}