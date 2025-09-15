package com.ibm.be.isco.domain.service;

import com.ibm.be.isco.domain.model.Control;
import com.ibm.be.isco.domain.repository.ControlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
//3. Contain business logic and interact with repositories.
public class ControlService {
    @Autowired
    private ControlRepository controlRepository;

    public List<Control> findAll() {
        
        return controlRepository.findAll();
    }

    public Optional<Control> findById(Long id) {
        return controlRepository.findById(id);
    }

    public Control save(Control control) {
        return controlRepository.save(control);
    }

    public void deleteById(Long id) {
        controlRepository.deleteById(id);
    }

   
}
