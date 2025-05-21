package com.ibm.be.isco.resource.api;

import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

@Data
@JsonRootName(value = "Person")
public class RiskTreatmentDTO {

  private String personNumber;

  private String language;

  private String street;

  private String houseNumber;

  private String postCode;

  private String city;

  private String country;

  public String getType() {
    return StringUtils.replace(this.getClass().getSimpleName(), "DTO", "");
  }
}
