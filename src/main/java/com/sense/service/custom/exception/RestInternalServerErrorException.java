package com.sense.service.custom.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR) // 500
public class RestInternalServerErrorException extends RuntimeException {

    public RestInternalServerErrorException() {
    }

    public RestInternalServerErrorException(String message) {
        super(message);
    }

    public RestInternalServerErrorException(String message, Throwable cause) {
        super(message, cause);
    }

}
