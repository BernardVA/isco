package com.ibm.be.isco.resource.api;

import com.fasterxml.jackson.annotation.JsonRootName;
import java.time.LocalDateTime;
import lombok.Data;

@Data
@JsonRootName(value = "Control")
//5. Data Transfer Objects used to expose data via the API.
public class ControlDTO {
    private Long controlId;
    private Long relevance;
    private int implementation; // Changed from String to int
    private String cost;
    private LocalDateTime createdAt;
}
