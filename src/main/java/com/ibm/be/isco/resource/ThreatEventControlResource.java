package com.ibm.be.isco.resource;

import com.ibm.be.isco.domain.model.ThreatEventControl;
import com.ibm.be.isco.domain.model.ThreatEventControlId;
import com.ibm.be.isco.domain.service.ThreatEventControlService;
import com.ibm.be.isco.resource.api.ThreatEventControlDTO;
import com.ibm.be.isco.resource.mapper.ThreatEventControlMapper;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/threat-event-controls")
public class ThreatEventControlResource {

  @Autowired private ThreatEventControlService threatEventControlService;
  @Autowired private ThreatEventControlMapper threatEventControlMapper;

  @CrossOrigin(origins = "http://localhost:4200")
  @GetMapping
  public List<ThreatEventControlDTO> getAll() {
    return threatEventControlService.findAll()
        .stream()
        .map(threatEventControlMapper::toDto)
        .collect(Collectors.toList());
  }

  @CrossOrigin(origins = "http://localhost:4200")
  @GetMapping("/{threatEventId}/{controlId}")
  public ResponseEntity<ThreatEventControlDTO> getById(
      @PathVariable Long threatEventId, @PathVariable Long controlId) {
    ThreatEventControlId id = new ThreatEventControlId(threatEventId, controlId);
    Optional<ThreatEventControl> opt = threatEventControlService.findById(id);
    return opt.map(e -> ResponseEntity.ok(threatEventControlMapper.toDto(e)))
        .orElseGet(() -> ResponseEntity.notFound().build());
  }

  @GetMapping("/by-threat/{threatEventId}")
  public List<ThreatEventControlDTO> getByThreatEvent(@PathVariable Long threatEventId) {
    return threatEventControlService.findByThreatEventId(threatEventId)
        .stream()
        .map(threatEventControlMapper::toDto)
        .collect(Collectors.toList());
  }

  @GetMapping("/by-control/{controlId}")
  public List<ThreatEventControlDTO> getByControl(@PathVariable Long controlId) {
    return threatEventControlService.findByControlId(controlId)
        .stream()
        .map(threatEventControlMapper::toDto)
        .collect(Collectors.toList());
  }

  @PostMapping
  public ThreatEventControlDTO create(@RequestBody ThreatEventControlDTO dto) {
    ThreatEventControl entity = threatEventControlMapper.toEntity(dto);
    ThreatEventControl saved = threatEventControlService.save(entity);
    return threatEventControlMapper.toDto(saved);
  }

  @PutMapping("/{threatEventId}/{controlId}")
  public ResponseEntity<ThreatEventControlDTO> update(
      @PathVariable Long threatEventId,
      @PathVariable Long controlId,
      @RequestBody ThreatEventControlDTO dto) {
    ThreatEventControlId id = new ThreatEventControlId(threatEventId, controlId);
    if (threatEventControlService.findById(id).isEmpty()) {
      return ResponseEntity.notFound().build();
    }
    // ensure id matches path
    dto.setThreatEventId(threatEventId);
    dto.setControlId(controlId);
    ThreatEventControl entity = threatEventControlMapper.toEntity(dto);
    ThreatEventControl saved = threatEventControlService.save(entity);
    return ResponseEntity.ok(threatEventControlMapper.toDto(saved));
  }

  @DeleteMapping("/{threatEventId}/{controlId}")
  public ResponseEntity<Void> delete(
      @PathVariable Long threatEventId, @PathVariable Long controlId) {
    ThreatEventControlId id = new ThreatEventControlId(threatEventId, controlId);
    if (threatEventControlService.findById(id).isEmpty()) {
      return ResponseEntity.notFound().build();
    }
    threatEventControlService.deleteById(id);
    return ResponseEntity.noContent().build();
  }
}
