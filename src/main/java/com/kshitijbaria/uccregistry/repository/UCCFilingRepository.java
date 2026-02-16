package com.kshitijbaria.uccregistry.repository;

import com.kshitijbaria.uccregistry.model.UCCFiling;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository()
public interface UCCFilingRepository extends JpaRepository<UCCFiling, Long> {
}
