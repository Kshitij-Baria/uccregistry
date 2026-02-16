package com.kshitijbaria.uccregistry.repository;

import com.kshitijbaria.uccregistry.model.UCCFilingFamily;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository()
public interface UCCFilingFamilyRepository extends JpaRepository<UCCFilingFamily, Long> {
}
