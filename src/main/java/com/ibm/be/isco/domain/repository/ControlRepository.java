package com.ibm.be.isco.domain.repository;

import com.ibm.be.isco.domain.model.Control;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
//2. Provide CRUD operations for entities.
public interface ControlRepository extends JpaRepository<Control, Long> {
}
