package com.ibm.be.isco.resource.mapper;

import com.ibm.be.isco.domain.model.RiskTreatment;
import com.ibm.be.isco.domain.model.RiskTreatmentFilter;
import com.ibm.be.isco.resource.api.PaginatedResultDTO;
import com.ibm.be.isco.resource.api.RiskTreatmentDTO;
import com.ibm.be.isco.resource.api.RiskTreatmentFilterDTO;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

@Mapper(componentModel = "spring")
public interface RiskTreatmentMapper {
  RiskTreatmentDTO toDto(RiskTreatment riskTreatment);

  RiskTreatmentFilter toDomain(RiskTreatmentFilterDTO personFilterDTO);

  default <T> PaginatedResultDTO<T> toPaginatedResultDTO(Page<T> page) {
    return PaginatedResultDTO.from(page);
  }

  default PaginatedResultDTO<RiskTreatmentDTO> mapToPaginatedResult(
      Page<RiskTreatment> serviceResult) {
    return PaginatedResultDTO.from(serviceResult.map(item -> this.toDto(item)));
  }
}
