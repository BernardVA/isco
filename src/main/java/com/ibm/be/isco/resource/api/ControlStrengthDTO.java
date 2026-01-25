package com.ibm.be.isco.resource.api;

import com.fasterxml.jackson.annotation.JsonRootName;
import java.time.LocalDateTime;
import lombok.Data;

@Data
@JsonRootName(value = "ControlStrength")
// 5. Data Transfer Objects used to expose data via the API.
public class ControlStrengthDTO {
  private Long controlStrengthId;
  private Float score;
  private LocalDateTime calculatedAt;
  // Add other fields as needed to match your ControlStrength entity
}
