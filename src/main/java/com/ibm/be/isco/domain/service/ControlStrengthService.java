package com.ibm.be.isco.domain.service;

import com.ibm.be.isco.domain.model.Control;
import com.ibm.be.isco.domain.model.ControlStrength;
import com.ibm.be.isco.domain.repository.ControlRepository;
import com.ibm.be.isco.domain.repository.ControlStrengthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.time.LocalDateTime;

@Service
//3. Contain business logic and interact with repositories.
public class ControlStrengthService {

    @Autowired
    private ControlStrengthRepository controlStrengthRepository;
    @Autowired
    private ControlRepository controlRepository;

    public List<ControlStrength> findAll() {
        if (controlStrengthRepository.findAll().isEmpty()) {
            // If no control strengths exist, calculate and save a new one
            ControlStrength controlStrength = new ControlStrength();
            controlStrength.setScore(calculateControlStrength());
            controlStrength.setCalculatedAt(LocalDateTime.now());
            controlStrengthRepository.save(controlStrength);
        }

        return controlStrengthRepository.findAll();
    }

    public Optional<ControlStrength> findById(Long id) {
        return controlStrengthRepository.findById(id);
    }

    public ControlStrength save(ControlStrength controlStrength) {
        return controlStrengthRepository.save(controlStrength);
    }

    public void deleteById(Long id) {
        controlStrengthRepository.deleteById(id);
    }

    public float calculateControlStrength() {

        // Placeholder for control strength calculation logic
        List<Control> controls = controlRepository.findAll();

        long strengthTeller = 0;
        long strengthNoemer = 0;
        for (Control control : controls) {
            // Example logic: increment strength based on some criteria
            if (control.getRelevance() != null && control.getRelevance() != 0) {
                strengthTeller += control.getRelevance() * control.getImplementation(); // IRAM2 metthod, page 49
                strengthNoemer += control.getRelevance();
            }

        }

        return strengthTeller / (float) strengthNoemer; // IRAM2 method, page 49

    }
}