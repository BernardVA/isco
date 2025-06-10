package com.ibm.be.isco.domain.model;

import jakarta.persistence.Column;

public class ThreatEvent {
    @Column(name = "Strength", nullable = false)
private String strength;
}
