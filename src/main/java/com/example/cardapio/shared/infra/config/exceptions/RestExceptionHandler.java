package com.example.cardapio.shared.infra.config.exceptions;

import com.example.cardapio.modules.foods.exceptions.FoodNotFoundException;
import com.example.cardapio.modules.users.exceptions.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(UserNotFoundException.class)
    private ResponseEntity<ProblemDetail> userNotFoundHandler(UserNotFoundException exception) {

        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, exception.getMessage());

        return ResponseEntity.status(problemDetail.getStatus()).body(problemDetail);
    }

    @ExceptionHandler(FoodNotFoundException.class)
    private ResponseEntity<ProblemDetail> foodNotFoundException(FoodNotFoundException exception) {

        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, exception.getMessage());

        return ResponseEntity.status(problemDetail.getStatus()).body(problemDetail);
    }

}
