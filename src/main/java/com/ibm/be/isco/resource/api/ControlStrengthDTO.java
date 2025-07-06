package com.ibm.be.isco.resource.api;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Data;

@Data
@JsonRootName(value = "ControlStrength")
public class ControlStrengthDTO {
    private Long controlStrengthId;
    private Float score;
    private LocalDateTime calculatedAt;
    // Add other fields as needed to match your ControlStrength entity
}