package com.ibm.be.isco.resource.api;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@Data
@Builder
public class RiskTreatmentFilterDTO extends PageFilterDTO {
  private String nationalRegistrationNumber;

  public Pageable getPageable() {
    return PageRequest.of(getPageNumber(), getPageSize());
  }
}
