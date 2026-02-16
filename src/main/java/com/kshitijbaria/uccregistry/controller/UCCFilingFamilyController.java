package com.kshitijbaria.uccregistry.controller;

import com.kshitijbaria.uccregistry.model.UCCFilingFamily;
import com.kshitijbaria.uccregistry.service.UCCFilingFamilyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/ucc_filing_families")
public class UCCFilingFamilyController {
    @Autowired
    private UCCFilingFamilyService uccFilingFamilyService;

    @GetMapping()
    public ResponseEntity<List<UCCFilingFamily>> findAll() {
        return ResponseEntity.ok(uccFilingFamilyService.findAll());
    }
}
