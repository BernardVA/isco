package com.ibm.be.isco.domain.service;

import com.ibm.be.isco.domain.repository.Control_implementationRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.be.isco.domain.model.Control_implementation;

@Service
// 3. Contain business logic and interact with repositories.
public class Control_implementationService {
  @Autowired private Control_implementationRepository control_implementationRepository;

  public List<Control_implementation> findAll() {

    return control_implementationRepository.findAll();
  }

  public Optional<Control_implementation> findById(Long id) {
    return control_implementationRepository.findById(id);
  }

  public Control_implementation save(Control_implementation control) {
    return control_implementationRepository.save(control);
  }

  public void deleteById(Long id) {
    control_implementationRepository.deleteById(id);
  }
}
