package com.ibm.be.isco.resource.api;

import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/** for swagger documentation only, since it struggles with generics, we add a static class */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RiskTreatmentSearchResponseDTO {
  // used for swagger documentation only, since it struggles with generics, we add a static class
  // Page that can be used on the api instead of the generic PaginatedResultDTO<PersonDTO>. This way
  // the generated openapi spec correctly shows the response message structure.
  @JsonRootName(value = "RiskTreatmentSearchResponse")
  public static class Page extends PaginatedResultDTO<RiskTreatmentDTO> {}
}
