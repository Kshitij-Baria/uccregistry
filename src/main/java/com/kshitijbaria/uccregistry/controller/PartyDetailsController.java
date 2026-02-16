package com.kshitijbaria.uccregistry.controller;

import com.kshitijbaria.uccregistry.model.PartyDetails;
import com.kshitijbaria.uccregistry.service.PartyDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("/party_details")
public class PartyDetailsController {
    @Autowired()
    private PartyDetailsService partyDetailsService;

    @GetMapping()
    public ResponseEntity<List<PartyDetails>> findAll() {
        return ResponseEntity.ok(partyDetailsService.findAll());
    }
}
