package com.ibm.be.isco.resource;

import com.ibm.be.isco.domain.model.ControlStrength;
import com.ibm.be.isco.domain.service.ControlService;
import com.ibm.be.isco.domain.service.ControlStrengthService;
import com.ibm.be.isco.resource.api.ControlDTO;
import com.ibm.be.isco.resource.api.ControlStrengthDTO;
import com.ibm.be.isco.resource.mapper.ControlMapper;
import com.ibm.be.isco.resource.mapper.ControlStrengthMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/control-strengths")
public class ControlStrengthResource {
    @Autowired
    private ControlStrengthService controlStrengthService;
    @Autowired
    private ControlStrengthMapper controlStrengthMapper;

    @Autowired
    private ControlService controlService;
    @Autowired
    private ControlMapper controlMapper;

    @GetMapping
    public List<Object> getAll() {

        List<ControlDTO> listControls = controlService.findAll().stream()
                .map(controlMapper::toDto)
                .collect(Collectors.toList());
        List<ControlStrengthDTO> listControlStrengths = controlStrengthService.findAll().stream()
                .map(controlStrengthMapper::toDto)
                .collect(Collectors.toList());
        List<Object> combinedList = new java.util.ArrayList<>();
        combinedList.addAll(listControlStrengths);
        combinedList.addAll(listControls);
        return combinedList;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ControlStrengthDTO> getById(@PathVariable Long id) {
        Optional<ControlStrength> entity = controlStrengthService.findById(id);
        return entity.map(value -> ResponseEntity.ok(controlStrengthMapper.toDto(value)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ControlStrengthDTO create(@RequestBody ControlStrengthDTO dto) {
        ControlStrength entity = controlStrengthMapper.toEntity(dto);
        return controlStrengthMapper.toDto(controlStrengthService.save(entity));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ControlStrengthDTO> update(@PathVariable Long id, @RequestBody ControlStrengthDTO dto) {
        Optional<ControlStrength> existing = controlStrengthService.findById(id);
        if (existing.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        ControlStrength entity = controlStrengthMapper.toEntity(dto);
        entity.setControlStrengthId(id);
        return ResponseEntity.ok(controlStrengthMapper.toDto(controlStrengthService.save(entity)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (controlStrengthService.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        controlStrengthService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}