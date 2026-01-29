package com.ibm.be.isco.domain.service;

import com.ibm.be.isco.domain.model.ThreatEventControl;
import com.ibm.be.isco.domain.model.ThreatEventControlId;
import com.ibm.be.isco.domain.repository.ThreatEventControlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ThreatEventControlService {

    private final ThreatEventControlRepository repository;

    @Autowired
    public ThreatEventControlService(ThreatEventControlRepository repository) {
        this.repository = repository;
    }

    public List<ThreatEventControl> findAll() {
        return repository.findAll();
    }

    public Optional<ThreatEventControl> findById(ThreatEventControlId id) {
        return repository.findById(id);
    }

    public ThreatEventControl save(ThreatEventControl entity) {
        return repository.save(entity);
    }

    public void deleteById(ThreatEventControlId id) {
        repository.deleteById(id);
    }

    public List<ThreatEventControl> findByThreatEventId(Long threatEventId) {
        return repository.findByThreatEventThreatEventId(threatEventId);
    }

    public List<ThreatEventControl> findByControlId(Long controlId) {
        return repository.findByControlImplementationControlId(controlId);
    }

    public List<ThreatEventControl> findByControlRelevanceBetween(Integer min, Integer max) {
        return repository.findByControlRelevanceScoreBetween(min, max);
    }
}
