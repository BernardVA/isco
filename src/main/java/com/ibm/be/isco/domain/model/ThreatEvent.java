package com.ibm.be.isco.domain.model;

import jakarta.persistence.Column;
/* 1. Represent database tables and are managed by JPA/Hibernate.*/
public class ThreatEvent {
    @Column(name = "Strength", nullable = false)
private String strength;
}
