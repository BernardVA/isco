package com.ibm.be.isco.domain.repository;

import com.ibm.be.isco.domain.model.ThreatEventControl;
import com.ibm.be.isco.domain.model.ThreatEventControlId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ThreatEventControlRepository extends JpaRepository<ThreatEventControl, ThreatEventControlId> {

    List<ThreatEventControl> findByThreatEventThreatEventId(Long threatEventId);

    List<ThreatEventControl> findByControlImplementationControlId(Long controlId);

    List<ThreatEventControl> findByControlRelevanceScoreBetween(Integer  min, Integer max);
}