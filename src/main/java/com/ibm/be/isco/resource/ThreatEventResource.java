package com.ibm.be.isco.resource;

import com.ibm.be.isco.domain.model.ThreatEvent;
import com.ibm.be.isco.domain.service.ThreatEventService;
import com.ibm.be.isco.resource.api.ThreatEventDTO;
import com.ibm.be.isco.resource.mapper.ThreatEventMapper;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/threat-events")
public class ThreatEventResource {

    @Autowired
    private ThreatEventService threatEventService;

    @Autowired
    private ThreatEventMapper threatEventMapper;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping
    public List<ThreatEventDTO> getAll() {
        return threatEventService.findAll().stream()
                .map(threatEventMapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ThreatEventDTO> getById(@PathVariable Long id) {
        Optional<ThreatEvent> entity = threatEventService.findById(id);
        return entity
                .map(e -> ResponseEntity.ok(threatEventMapper.toDto(e)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ThreatEventDTO create(@RequestBody ThreatEventDTO dto) {
        ThreatEvent entity = threatEventMapper.toEntity(dto);
        return threatEventMapper.toDto(threatEventService.save(entity));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ThreatEventDTO> update(@PathVariable Long id, @RequestBody ThreatEventDTO dto) {
        Optional<ThreatEvent> existing = threatEventService.findById(id);
        if (existing.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        ThreatEvent entity = threatEventMapper.toEntity(dto);
        entity.setThreatEventId(id);
        return ResponseEntity.ok(threatEventMapper.toDto(threatEventService.save(entity)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (threatEventService.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        threatEventService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    // Optional: simple search endpoint
    @GetMapping("/search")
    public List<ThreatEventDTO> search(@RequestParam("q") String q) {
        return threatEventService.searchByDescr(q).stream()
                .map(threatEventMapper::toDto)
                .collect(Collectors.toList());
    }
}
