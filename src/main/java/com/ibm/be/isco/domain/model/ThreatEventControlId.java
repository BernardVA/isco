package com.ibm.be.isco.domain.model;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

/**
 * Composite key for threat_event_control (threat_event_id, control_id)
 */
@Embeddable
public class ThreatEventControlId implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long threatEventId;
    private Long controlId;

    public ThreatEventControlId() {}

    public ThreatEventControlId(Long threatEventId, Long controlId) {
        this.threatEventId = threatEventId;
        this.controlId = controlId;
    }

    public Long getThreatEventId() {
        return threatEventId;
    }

    public void setThreatEventId(Long threatEventId) {
        this.threatEventId = threatEventId;
    }

    public Long getControlId() {
        return controlId;
    }

    public void setControlId(Long controlId) {
        this.controlId = controlId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ThreatEventControlId)) return false;
        ThreatEventControlId that = (ThreatEventControlId) o;
        return Objects.equals(threatEventId, that.threatEventId) &&
               Objects.equals(controlId, that.controlId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(threatEventId, controlId);
    }
}