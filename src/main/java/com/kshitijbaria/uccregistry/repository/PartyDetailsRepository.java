package com.kshitijbaria.uccregistry.repository;

import com.kshitijbaria.uccregistry.model.PartyDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository()
public interface PartyDetailsRepository extends JpaRepository<PartyDetails, Long> {
}
