package com.sense.service.custom.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST) // 400
public class RestBadRequestException extends RuntimeException {

    public RestBadRequestException() {
    }

    public RestBadRequestException(String message) {
        super(message);
    }

    public RestBadRequestException(String message, Throwable cause) {
        super(message, cause);
    }
}
