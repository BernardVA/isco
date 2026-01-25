package com.ibm.be.isco.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ibm.be.isco.domain.model.Control_implementation;

@Repository
// 2. Provide CRUD operations for entities, here controls.
public interface Control_implementationRepository extends JpaRepository<Control_implementation, Long> {}
