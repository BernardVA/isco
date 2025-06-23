package com.ibm.be.isco.resource.mapper;

import com.ibm.be.isco.domain.model.Control;
import com.ibm.be.isco.resource.api.ControlDTO;
import org.springframework.stereotype.Component;

@Component
public class ControlMapper {
    public ControlDTO toDto(Control entity) {
        if (entity == null) return null;
        ControlDTO dto = new ControlDTO();
        dto.setControlId(entity.getControlId());
        dto.setStrength(entity.getStrength() != null ? entity.getStrength().toString() : null);
        dto.setRelevance(entity.getRelevance() != null ? entity.getRelevance().toString() : null);
        dto.setImplementation(entity.getImplementation());
        dto.setCost(entity.getCost());
        dto.setCreatedAt(entity.getCreatedAt());
        return dto;
    }

    public Control toEntity(ControlDTO dto) {
        if (dto == null) return null;
        Control entity = new Control();
        entity.setControlId(dto.getControlId());
        if (dto.getStrength() != null) entity.setStrength(Long.valueOf(dto.getStrength()));
        if (dto.getRelevance() != null) entity.setRelevance(Long.valueOf(dto.getRelevance()));
        entity.setImplementation(dto.getImplementation());
        entity.setCost(dto.getCost());
        entity.setCreatedAt(dto.getCreatedAt());
        return entity;
    }
}
