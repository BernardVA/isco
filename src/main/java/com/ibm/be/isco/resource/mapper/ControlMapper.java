package com.ibm.be.isco.resource.mapper;

import com.ibm.be.isco.domain.model.Control;
import com.ibm.be.isco.resource.api.ControlDTO;
import org.springframework.stereotype.Component;

@Component
public class ControlMapper {
    public ControlDTO toDTO(Control entity) {
        if (entity == null) return null;
        ControlDTO dto = new ControlDTO();
        dto.setControlId(entity.getControlId());
        dto.setStrength(entity.getStrength());
        dto.setRelevance(entity.getRelevance());
        dto.setImplementation(entity.getImplementation());
        dto.setCost(entity.getCost());
        dto.setCreatedAt(entity.getCreatedAt());
        return dto;
    }

    public Control toEntity(ControlDTO dto) {
        if (dto == null) return null;
        Control entity = new Control();
        entity.setControlId(dto.getControlId());
        entity.setStrength(dto.getStrength());
        entity.setRelevance(dto.getRelevance());
        entity.setImplementation(dto.getImplementation());
        entity.setCost(dto.getCost());
        entity.setCreatedAt(dto.getCreatedAt());
        return entity;
    }
}
