package com.ibm.be.isco.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.Data;

@Entity
@Table(name = "risk_treatment")
@Data
public class RiskTreatment {
  @Id
  @SequenceGenerator(
      name = "risk_treatment_id_seq",
      sequenceName = "risk_treatment_id_seq",
      allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "risk_treatment_id_seq")
  private Long riskTreatmentId;

  @Column(name = "title", nullable = false)
  private String title;

  @Column(name = "description", nullable = true)
  private String description;

  @Column(name = "created_at", nullable = true)
  private LocalDateTime createdAt;
}
