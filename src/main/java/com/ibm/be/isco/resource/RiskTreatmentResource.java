package com.ibm.be.isco.resource;

import com.ibm.be.isco.domain.service.RiskTreatmentService;
import com.ibm.be.isco.resource.api.PaginatedResultDTO;
import com.ibm.be.isco.resource.api.RiskTreatmentDTO;
import com.ibm.be.isco.resource.api.RiskTreatmentFilterDTO;
import com.ibm.be.isco.resource.api.RiskTreatmentSearchResponseDTO;
import com.ibm.be.isco.resource.mapper.RiskTreatmentMapper;
import com.ibm.be.isco.shared.swagger.ApiResponseDefaultErrors;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "RiskTreatments", description = "API for managing risk treatments")
@RestController
@RequestMapping("/api/v1/riskTreatments")
@RequiredArgsConstructor
public class RiskTreatmentResource {

  private final RiskTreatmentService personService;

  private final RiskTreatmentMapper personMapper;

  @Operation(summary = "Find persons", description = "Retrieve a paginated list of persons")
  @ApiResponse(
      responseCode = "200",
      description = "Successful operation",
      content =
          @Content(
              schema = @Schema(implementation = RiskTreatmentSearchResponseDTO.Page.class),
              mediaType = "application/json"))
  @ApiResponseDefaultErrors
  @GetMapping
  public ResponseEntity<PaginatedResultDTO<RiskTreatmentDTO>> findPersons(
      @ParameterObject @Valid @ModelAttribute RiskTreatmentFilterDTO riskTreatmentFilterDTO) {
    Pageable pageable = riskTreatmentFilterDTO.getPageable();

    return ResponseEntity.ok(
        personMapper.mapToPaginatedResult(
            personService.findRiskTreatments(
                personMapper.toDomain(riskTreatmentFilterDTO), pageable)));
  }
}
