package com.ibm.be.isco.resource.exception;

import com.ibm.be.isco.resource.builder.IscoMessageBuilder;
import io.swagger.v3.oas.annotations.Hidden;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ConstraintViolationException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@RequiredArgsConstructor
@ControllerAdvice
@Slf4j
@Hidden
public class GlobalExceptionHandler {

  private final IscoMessageBuilder iscoMessageBuilder;

  @ExceptionHandler(Exception.class)
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  public ResponseEntity<ValidationErrorProblem> handleGenericException(Exception ex) {
    log.error("Generic Exception caught: {}", ex.getMessage(), ex);
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
        .body(iscoMessageBuilder.buildInternalServerErrorProblem(ex));
  }

  @ExceptionHandler(ConstraintViolationException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ResponseEntity<ValidationErrorProblem> handleConstraintViolationException(
      ConstraintViolationException ex) {
    log.debug("ConstraintViolationException caught: {}", ex.getMessage(), ex);
    return ResponseEntity.badRequest().body(iscoMessageBuilder.buildBadRequestProblem(ex));
  }

  @ExceptionHandler(EntityNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public ResponseEntity<ValidationErrorProblem> handleEntityNotFoundException(
      EntityNotFoundException ex) {
    log.debug("EntityNotFoundException caught: {}", ex.getMessage(), ex);
    return ResponseEntity.status(HttpStatus.NOT_FOUND)
        .body(iscoMessageBuilder.buildEntityNotFoundException(ex));
  }
}
