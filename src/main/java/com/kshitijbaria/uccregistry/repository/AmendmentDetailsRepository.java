package com.kshitijbaria.uccregistry.repository;

import com.kshitijbaria.uccregistry.model.AmendmentDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AmendmentDetailsRepository extends JpaRepository<AmendmentDetails, Long> {
}
