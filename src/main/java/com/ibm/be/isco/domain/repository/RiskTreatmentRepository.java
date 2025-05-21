package com.ibm.be.isco.domain.repository;

import com.ibm.be.isco.domain.model.RiskTreatment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RiskTreatmentRepository extends JpaRepository<RiskTreatment, Long> {
  Page<RiskTreatment> findByTitle(String title, Pageable pageable);
}
