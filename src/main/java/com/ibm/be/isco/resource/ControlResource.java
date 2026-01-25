package com.ibm.be.isco.resource;

import com.ibm.be.isco.domain.model.Control_implementation;
import com.ibm.be.isco.domain.service.Control_implementationService;
import com.ibm.be.isco.resource.api.Control_implementationDTO;
import com.ibm.be.isco.resource.mapper.Control_implementationMapper;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/control_implementations")

// 6. Handle HTTP requests and responses, using DTOs.
public class ControlResource {
  @Autowired private Control_implementationService control_implementationService;
  @Autowired private Control_implementationMapper control_implementationMapper;

  @CrossOrigin(origins = "http://localhost:4200") // added to allow CORS requests from Angular app
  @GetMapping
  public List<Control_implementationDTO> getAllControls() {
    return control_implementationService.findAll().stream().map(control_implementationMapper::toDto).collect(Collectors.toList());
  }

  @PostMapping
  public Control_implementationDTO createControl(@RequestBody Control_implementationDTO controlDTO) {
    Control_implementation control = control_implementationMapper.toEntity(controlDTO);
    return control_implementationMapper.toDto(control_implementationService.save(control));
  }

  @PutMapping("/{id}")
  public ResponseEntity<Control_implementationDTO> updateControl(
      @PathVariable Long id, @RequestBody Control_implementationDTO controlDTO) {
    Optional<Control_implementation> existing = control_implementationService.findById(id);
    if (existing.isEmpty()) {
      return ResponseEntity.notFound().build();
    }
    Control_implementation control = control_implementationMapper.toEntity(controlDTO);
    control.setControlId(id);
    return ResponseEntity.ok(control_implementationMapper.toDto(control_implementationService.save(control)));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteControl(@PathVariable Long id) {
    if (control_implementationService.findById(id).isEmpty()) {
      return ResponseEntity.notFound().build();
    }
    control_implementationService.deleteById(id);
    return ResponseEntity.noContent().build();
  }
}
