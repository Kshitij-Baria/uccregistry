package com.kshitijbaria.uccregistry.repository;

import com.kshitijbaria.uccregistry.model.CollateralDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository()
public interface CollateralDetailsRepository extends JpaRepository<CollateralDetails, Long> {
}
