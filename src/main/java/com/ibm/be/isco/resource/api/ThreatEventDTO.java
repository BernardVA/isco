package com.ibm.be.isco.resource.api;

import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Data;

// 5. Data Transfer Objects used to expose data via the API.
@Data
@JsonRootName(value = "ThreatEvent")
public class ThreatEventDTO {
    private Long threatEventId;
    private String threatEventDescr;
    // Preserve column typo to match DB/Entity mapping
    private Float likelihoodOfInititation;

    private Float threatStrength;
}