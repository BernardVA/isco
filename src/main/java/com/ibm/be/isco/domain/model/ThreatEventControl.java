package com.ibm.be.isco.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import java.time.LocalDateTime;

/**
 * Entity mapping for the junction table threat_event_control
 */
@Entity
@Table(name = "threat_event_control")
public class ThreatEventControl {

    @EmbeddedId
    private ThreatEventControlId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("threatEventId")
    @JoinColumn(name = "threat_event_id", referencedColumnName = "threat_event_id")
    private ThreatEvent threatEvent;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("controlId")
    @JoinColumn(name = "control_id", referencedColumnName = "control_id")
    private Control_implementation controlImplementation;

    @Column(name = "control_relevance_score")
    private Integer controlRelevanceScore;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    public ThreatEventControl() {}

    public ThreatEventControl(ThreatEventControlId id) {
        this.id = id;
    }

    public ThreatEventControlId getId() {
        return id;
    }

    public void setId(ThreatEventControlId id) {
        this.id = id;
    }

    public ThreatEvent getThreatEvent() {
        return threatEvent;
    }

    public void setThreatEvent(ThreatEvent threatEvent) {
        this.threatEvent = threatEvent;
    }

    public Control_implementation getControlImplementation() {
        return controlImplementation;
    }

    public void setControlImplementation(Control_implementation controlImplementation) {
        this.controlImplementation = controlImplementation;
    }

    public Integer getControlRelevanceScore() {
        return controlRelevanceScore;
    }

    public void setControlRelevanceScore(Integer controlRelevanceScore) {
        this.controlRelevanceScore = controlRelevanceScore;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}