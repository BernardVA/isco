package com.ibm.be.isco.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ibm.be.isco.domain.model.ControlStrength;

// 2. Provide CRUD operations for entities.
public interface ControlStrengthRepository extends JpaRepository<ControlStrength, Long> {}
