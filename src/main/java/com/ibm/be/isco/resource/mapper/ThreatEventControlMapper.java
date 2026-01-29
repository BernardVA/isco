package com.ibm.be.isco.resource.mapper;

import com.ibm.be.isco.domain.model.Control_implementation;
import com.ibm.be.isco.domain.model.ThreatEvent;
import com.ibm.be.isco.domain.model.ThreatEventControl;
import com.ibm.be.isco.domain.model.ThreatEventControlId;
import com.ibm.be.isco.resource.api.ThreatEventControlDTO;
import org.springframework.stereotype.Component;

@Component
public class ThreatEventControlMapper {

    public ThreatEventControlDTO toDto(ThreatEventControl entity) {
        if (entity == null) return null;
        ThreatEventControlDTO dto = new ThreatEventControlDTO();
        if (entity.getId() != null) {
            dto.setThreatEventId(entity.getId().getThreatEventId());
            dto.setControlId(entity.getId().getControlId());
        } else {
            if (entity.getThreatEvent() != null) dto.setThreatEventId(entity.getThreatEvent().getThreatEventId());
            if (entity.getControlImplementation() != null) dto.setControlId(entity.getControlImplementation().getControlId());
        }
        dto.setControlRelevanceScore(entity.getControlRelevanceScore());
        dto.setCreatedAt(entity.getCreatedAt());
        return dto;
    }

    public ThreatEventControl toEntity(ThreatEventControlDTO dto) {
        if (dto == null) return null;
        ThreatEventControl entity = new ThreatEventControl();

        ThreatEventControlId id = new ThreatEventControlId(
                dto.getThreatEventId(),
                dto.getControlId()
        );
        entity.setId(id);

        if (dto.getThreatEventId() != null) {
            ThreatEvent te = new ThreatEvent();
            te.setThreatEventId(dto.getThreatEventId());
            entity.setThreatEvent(te);
        }

        if (dto.getControlId() != null) {
            Control_implementation ci = new Control_implementation();
            ci.setControlId(dto.getControlId());
            entity.setControlImplementation(ci);
        }

        entity.setControlRelevanceScore(dto.getControlRelevanceScore());
        entity.setCreatedAt(dto.getCreatedAt());

        return entity;
    }
}