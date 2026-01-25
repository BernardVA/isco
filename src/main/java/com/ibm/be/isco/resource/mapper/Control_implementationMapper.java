package com.ibm.be.isco.resource.mapper;

import com.ibm.be.isco.domain.model.Control_implementation;
import com.ibm.be.isco.resource.api.Control_implementationDTO;
import org.springframework.stereotype.Component;

@Component
// 4. Convert between entity objects and DTOs.
public class Control_implementationMapper {
  public Control_implementationDTO toDto(Control_implementation entity) {
    if (entity == null) return null;
    Control_implementationDTO dto = new Control_implementationDTO();
    dto.setControlId(entity.getControlId());
    dto.setRelevance(entity.getRelevance());
    dto.setImplementation(entity.getImplementation());
    dto.setCost(entity.getCost());
    dto.setCreatedAt(entity.getCreatedAt());
    return dto;
  }

  public Control_implementation toEntity(Control_implementationDTO dto) {
    if (dto == null) return null;
    Control_implementation entity = new Control_implementation();
    entity.setControlId(dto.getControlId());
    if (dto.getRelevance() != null) entity.setRelevance(Long.valueOf(dto.getRelevance()));
    entity.setImplementation(dto.getImplementation());
    entity.setCost(dto.getCost());
    entity.setCreatedAt(dto.getCreatedAt());
    return entity;
  }

  public Object toDTo(Control_implementation value) {

    throw new UnsupportedOperationException("Unimplemented method 'toDTO'");
  }
}
