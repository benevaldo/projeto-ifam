package com.api.api_user.domain.exceptions;

import java.time.ZonedDateTime;

import org.springframework.dao.EmptyResultDataAccessException;
<<<<<<< HEAD
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
=======
>>>>>>> 2e0e3f363de53c7e9f3210c3b1e6d0a6d9405525
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class AppExceptionHandler extends RuntimeException {

    @ExceptionHandler(Exception.class)
    private ResponseEntity handleException(Exception ex) {
        DefaultExceptionModel error = new DefaultExceptionModel(HttpStatus.BAD_REQUEST.value(),
                ex.getMessage(), ZonedDateTime.now());

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(EmptyResultDataAccessException.class)
    private ResponseEntity NotFoundException(Exception ex) {
        DefaultExceptionModel error = new DefaultExceptionModel(HttpStatus.NOT_FOUND.value(),
                "Usuário não encontrado", ZonedDateTime.now());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    private ResponseEntity handleValidationException(MethodArgumentNotValidException ex) {

        List<FieldError> fieldErrors = ex.getFieldErrors();

        List<String> responseErros = new ArrayList<>();

        for (FieldError fieldError : fieldErrors) {
            responseErros.add(fieldError.getDefaultMessage());
        }

        ValidationExceptionModel error = new ValidationExceptionModel(HttpStatus.BAD_REQUEST.value(),
                ZonedDateTime.now(), responseErros);
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(EmptyResultDataAccessException.class)
    private ResponseEntity handleEntityNotFoundException(EmptyResultDataAccessException ex) {
        DefaultExceptionModel error = new DefaultExceptionModel(HttpStatus.NOT_FOUND.value(),
                "Usuário não encontrado", ZonedDateTime.now());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

}
