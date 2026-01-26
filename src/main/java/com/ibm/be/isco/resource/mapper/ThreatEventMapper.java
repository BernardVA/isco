package com.ibm.be.isco.resource.mapper;

import com.ibm.be.isco.domain.model.ThreatEvent;
import com.ibm.be.isco.resource.api.ThreatEventDTO;
import org.springframework.stereotype.Component;

@Component
public class ThreatEventMapper {

    public ThreatEventDTO toDto(ThreatEvent entity) {
        if (entity == null) return null;
        ThreatEventDTO dto = new ThreatEventDTO();
        dto.setThreatEventId(entity.getThreatEventId());
        dto.setThreatEventDescr(entity.getThreatEventDescr());
        dto.setLikelihoodOfInititation(entity.getLikelihoodOfInititation());
        dto.setThreatStrength(entity.getThreatStrength());
        return dto;
    }

    public ThreatEvent toEntity(ThreatEventDTO dto) {
        if (dto == null) return null;
        ThreatEvent entity = new ThreatEvent();
        entity.setThreatEventId(dto.getThreatEventId());
        entity.setThreatEventDescr(dto.getThreatEventDescr());
        entity.setLikelihoodOfInititation(dto.getLikelihoodOfInititation());
        entity.setThreatStrength(dto.getThreatStrength());
        return entity;
    }
}
