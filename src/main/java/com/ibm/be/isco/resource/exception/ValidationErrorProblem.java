package com.ibm.be.isco.resource.exception;

import com.fasterxml.jackson.annotation.JsonRootName;
import java.util.List;
import lombok.Builder;
import lombok.Value;

/**
 * ValidationErrorProblem, inspired on the RFC [Problem Details for HTTP
 * APIs](https://datatracker.ietf.org/doc/html/rfc7807)
 */
@Value
@Builder(toBuilder = true)
@JsonRootName("validationErrorProblem")
public class ValidationErrorProblem {
  private String instance;

  private String type;

  private String title;

  private Integer status;

  private String detail;

  private List<ValidationErrorDTO> errorList;
}
