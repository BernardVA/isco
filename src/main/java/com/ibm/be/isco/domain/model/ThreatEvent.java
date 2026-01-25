package com.ibm.be.isco.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "threat_events")
public class ThreatEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "threat_event_id")
    private Long threatEventId;

    @Column(name = "threat_event_descr")
    private String threatEventDescr;

    // Note: column name contains the original typo "inititation" in the SQL
    @Column(name = "likelihood_of_inititation")
    private Float likelihoodOfInititation;

    @Column(name = "threat_strength")
    private Float threatStrength;

    public ThreatEvent() {
    }

    public Long getThreatEventId() {
        return threatEventId;
    }

    public void setThreatEventId(Long threatEventId) {
        this.threatEventId = threatEventId;
    }

    public String getThreatEventDescr() {
        return threatEventDescr;
    }

    public void setThreatEventDescr(String threatEventDescr) {
        this.threatEventDescr = threatEventDescr;
    }

    public Float getLikelihoodOfInititation() {
        return likelihoodOfInititation;
    }

    public void setLikelihoodOfInititation(Float likelihoodOfInititation) {
        this.likelihoodOfInititation = likelihoodOfInititation;
    }

    public Float getThreatStrength() {
        return threatStrength;
    }

    public void setThreatStrength(Float threatStrength) {
        this.threatStrength = threatStrength;
    }
}
