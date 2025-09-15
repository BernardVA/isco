package com.ibm.be.isco.resource.mapper;

import com.ibm.be.isco.domain.model.ControlStrength;
import com.ibm.be.isco.resource.api.ControlStrengthDTO;
import org.springframework.stereotype.Component;

@Component
// 4. Convert between entity objects and DTOs.
public class ControlStrengthMapper {
    public ControlStrengthDTO toDto(ControlStrength entity) {
        if (entity == null) return null;
        ControlStrengthDTO dto = new ControlStrengthDTO();
        dto.setControlStrengthId(entity.getControlStrengthId());
        dto.setScore(entity.getScore());
        dto.setCalculatedAt(entity.getCalculatedAt());
        return dto;
    }

    public ControlStrength toEntity(ControlStrengthDTO dto) {
        if (dto == null) return null;
        ControlStrength entity = new ControlStrength();
        entity.setControlStrengthId(dto.getControlStrengthId());
        entity.setScore(dto.getScore());
        entity.setCalculatedAt(dto.getCalculatedAt());
        return entity;
    }
}