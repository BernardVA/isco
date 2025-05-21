package com.ibm.be.isco.resource.exception;

import static com.fasterxml.jackson.annotation.JsonProperty.Access.READ_ONLY;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Builder;
import lombok.Value;

@Value
@Builder(toBuilder = true)
@JsonRootName("validationError")
public class ValidationErrorDTO {
  @JsonProperty(access = READ_ONLY)
  private Integer id;

  private String category;

  private String code;

  private String additionalInformation;

  private String remarks;

  private String pointer;
}
