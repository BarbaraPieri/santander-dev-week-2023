package me.dio.controller.exception;

import me.dio.domain.moldel.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;


@RestControllerAdvice
public class GlobalExceptionHandLer {

   private final Logger logger =  LoggerFactory.getLogger(GlobalExceptionHandLer.class);

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handLeBusinessException(IllegalArgumentException businessException){
        return new ResponseEntity<>(businessException.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handLeNotFoundException(IllegalArgumentException notFoundException){
        return new ResponseEntity<>("Resource ID notFound.", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handLeUnexpectedException(Throwable unexpectedException){
       var message= "Unexpected server error,see the log.";
        logger.error("", unexpectedException);
        return new ResponseEntity<>(message, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
