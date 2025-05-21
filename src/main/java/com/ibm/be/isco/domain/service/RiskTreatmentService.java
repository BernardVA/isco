package com.ibm.be.isco.domain.service;

import com.ibm.be.isco.domain.model.RiskTreatment;
import com.ibm.be.isco.domain.model.RiskTreatmentFilter;
import com.ibm.be.isco.domain.repository.RiskTreatmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RiskTreatmentService {

  @Autowired private RiskTreatmentRepository riskTreatmentRepository;

  public Page<RiskTreatment> findPersons(
      RiskTreatmentFilter riskTreatmentFilter, Pageable pageable) {

    if (riskTreatmentFilter.getTitle() != null) {
      return riskTreatmentRepository.findByTitle(riskTreatmentFilter.getTitle(), pageable);
    }
    return Page.empty();
  }
}
