package com.ibm.be.isco.resource.api;

import com.fasterxml.jackson.annotation.JsonRootName;
import java.time.LocalDateTime;
import lombok.Data;

@Data
@JsonRootName(value = "Control")
public class ControlDTO {
    private Long controlId;
    private String strength;
    private String relevance;
    private String implementation;
    private String cost;
    private LocalDateTime createdAt;
}
