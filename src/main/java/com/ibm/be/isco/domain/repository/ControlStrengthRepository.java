package com.ibm.be.isco.domain.repository;

import com.ibm.be.isco.domain.model.ControlStrength;
import org.springframework.data.jpa.repository.JpaRepository;
//2. Provide CRUD operations for entities.
public interface ControlStrengthRepository extends JpaRepository<ControlStrength, Long> {
}