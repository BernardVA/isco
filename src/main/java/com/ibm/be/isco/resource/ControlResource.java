package com.ibm.be.isco.resource;

import com.ibm.be.isco.domain.model.Control;
import com.ibm.be.isco.domain.service.ControlService;
import com.ibm.be.isco.resource.api.ControlDTO;
import com.ibm.be.isco.resource.mapper.ControlMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/controls")

// 6. Handle HTTP requests and responses, using DTOs.
public class ControlResource {
    @Autowired
    private ControlService controlService;
    @Autowired
    private ControlMapper controlMapper;
@CrossOrigin(origins = "http://localhost:4200") // added to allow CORS requests from Angular app
    @GetMapping
    public List<ControlDTO> getAllControls() {
        return controlService.findAll().stream()
                .map(controlMapper::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping
    public ControlDTO createControl(@RequestBody ControlDTO controlDTO) {
        Control control = controlMapper.toEntity(controlDTO);
        return controlMapper.toDto(controlService.save(control));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ControlDTO> updateControl(@PathVariable Long id, @RequestBody ControlDTO controlDTO) {
        Optional<Control> existing = controlService.findById(id);
        if (existing.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Control control = controlMapper.toEntity(controlDTO);
        control.setControlId(id);
        return ResponseEntity.ok(controlMapper.toDto(controlService.save(control)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteControl(@PathVariable Long id) {
        if (controlService.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        controlService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
