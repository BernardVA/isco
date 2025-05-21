package com.ibm.be.isco.domain.exception;

import jakarta.validation.ConstraintViolation;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class BusinessException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  private final transient Set<ConstraintViolation<?>> violations;
}
