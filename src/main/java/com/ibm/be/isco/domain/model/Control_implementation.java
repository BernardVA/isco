package com.ibm.be.isco.domain.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.Data;

@Entity
@Table(name = "control_implementation")
@Data
public class Control_implementation {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "control_id")
  private Long controlId;

  @Column(name = "relevance")
  private Long relevance;

  @Column(name = "implementation")
  private int implementation;

  @Column(name = "cost")
  private String cost;

  @Column(name = "created_at")
  private LocalDateTime createdAt;
}
