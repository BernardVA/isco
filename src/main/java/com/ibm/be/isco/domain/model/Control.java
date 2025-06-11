package com.ibm.be.isco.domain.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.Data;

@Entity
@Table(name = "control")
@Data
public class Control {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "control_id")
    private Long controlId;

    @Column(name = "strength")
    private String strength;

    @Column(name = "relevance")
    private String relevance;

    @Column(name = "implementation")
    private String implementation;

    @Column(name = "cost")
    private String cost;

    @Column(name = "created_at")
    private LocalDateTime createdAt;
}
