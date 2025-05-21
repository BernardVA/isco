package com.ibm.be.isco.resource.builder;

import static com.ibm.be.isco.resource.builder.IscoMessageConstants.*;

import com.ibm.be.isco.resource.exception.ValidationErrorDTO;
import com.ibm.be.isco.resource.exception.ValidationErrorProblem;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ConstraintViolationException;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class IscoMessageBuilder {

  public ValidationErrorProblem buildInternalServerErrorProblem(Exception e) {
    return ValidationErrorProblem.builder()
        .title(TITLE_INTERNAL_SERVER_ERROR)
        .detail(e.getMessage())
        .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
        .type(INTERNAL_SERVER_ERROR_TYPE)
        .build();
  }

  public ValidationErrorProblem buildBadRequestProblem(ConstraintViolationException e) {
    List<ValidationErrorDTO> validationErrors =
        e.getConstraintViolations().stream()
            .map(
                violation ->
                    ValidationErrorDTO.builder()
                        .pointer(violation.getPropertyPath().toString())
                        .category(violation.getRootBeanClass().getName())
                        .code(violation.getMessage())
                        .remarks(violation.getMessage())
                        .build())
            .toList();

    return ValidationErrorProblem.builder()
        .title(TITLE_BAD_REQUEST)
        .detail(BAD_REQUEST_DETAIL_VALIDATION_FAILED)
        .status(HttpStatus.BAD_REQUEST.value())
        .type(BAD_REQUEST_TYPE)
        .errorList(validationErrors)
        .build();
  }

  public ValidationErrorProblem buildEntityNotFoundException(EntityNotFoundException e) {
    return ValidationErrorProblem.builder()
        .title(TITLE_ENTITY_NOT_FOUND)
        .detail(e.getMessage())
        .status(HttpStatus.NOT_FOUND.value())
        .type(ENTITY_NOT_FOUND_TYPE)
        .build();
  }
}
