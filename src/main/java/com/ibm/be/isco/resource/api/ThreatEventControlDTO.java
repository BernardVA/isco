package com.ibm.be.isco.resource.api;

import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * DTO for the junction entity threat_event_control.
 */
@Data
@JsonRootName(value = "ThreatEventControl")
public class ThreatEventControlDTO {
    private long ThreatEventControlId;
    private Long threatEventId;
    private Long controlId;
    private Integer controlRelevanceScore;
    private LocalDateTime  createdAt;
}