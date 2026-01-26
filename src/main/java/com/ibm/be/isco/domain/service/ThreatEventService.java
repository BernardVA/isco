package com.ibm.be.isco.domain.service;

import com.ibm.be.isco.domain.model.ThreatEvent;
import com.ibm.be.isco.domain.repository.ThreatEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ThreatEventService {

    private final ThreatEventRepository repository;

    @Autowired
    public ThreatEventService(ThreatEventRepository repository) {
        this.repository = repository;
    }

    public List<ThreatEvent> findAll() {
        return repository.findAll();
    }

    public Optional<ThreatEvent> findById(Long id) {
        return repository.findById(id);
    }

    public ThreatEvent save(ThreatEvent threatEvent) {
        return repository.save(threatEvent);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public List<ThreatEvent> searchByDescr(String term) {
        return repository.findByThreatEventDescrContainingIgnoreCase(term);
    }
}