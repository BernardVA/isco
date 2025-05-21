package com.ibm.be.isco.resource.api;

import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.constraints.Min;
import lombok.Data;

@Data
public class PageFilterDTO {
  @Parameter(description = "The page number of the requested page.")
  @Min(value = 0, message = "Page number must be at least 0")
  private Integer pageNumber = 0;

  @Parameter(description = "Maximum number of items that are returned by one single service call.")
  @Min(value = 1, message = "Page size must be at least 1")
  private Integer pageSize = 50;
}
