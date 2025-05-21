package com.ibm.be.isco.resource.api;

import com.fasterxml.jackson.annotation.JsonRootName;
import java.time.LocalDateTime;
import lombok.Data;

@Data
@JsonRootName(value = "RiskTreatment")
public class RiskTreatmentDTO {

  private String riskTreatmentId;

  private String title;

  private String description;

  private LocalDateTime createdAt;
}
