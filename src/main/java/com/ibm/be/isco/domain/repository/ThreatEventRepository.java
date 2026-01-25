package com.ibm.be.isco.domain.repository;

import com.ibm.be.isco.domain.model.ThreatEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ThreatEventRepository extends JpaRepository<ThreatEvent, Long> {
    // Example custom finder
        List<ThreatEvent> findByThreatEventDescrContainingIgnoreCase(String term);
}