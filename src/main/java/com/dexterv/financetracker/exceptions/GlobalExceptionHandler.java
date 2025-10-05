package com.dexterv.financetracker.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(value={Exception.class})
    public ResponseEntity<ErrorDto> handleException(
            Exception ex,
            HttpServletRequest request
            ){
        log.error(ex.getMessage(), ex);

        ErrorDto errorDto = new ErrorDto();
        errorDto.setMessage("An unknown error occurred. " + ex.getMessage());
        errorDto.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        errorDto.setPath(request.getRequestURI());
        errorDto.setTimestamp(LocalDateTime.now());

        return new  ResponseEntity<>(errorDto, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
