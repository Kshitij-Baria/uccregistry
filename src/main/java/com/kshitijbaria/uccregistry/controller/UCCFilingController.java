package com.kshitijbaria.uccregistry.controller;

import com.kshitijbaria.uccregistry.model.UCCFiling;
import com.kshitijbaria.uccregistry.service.UCCFilingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("/ucc_filings")
public class UCCFilingController {
    @Autowired
    private UCCFilingService uccFilingService;

    @GetMapping()
    public ResponseEntity<List<UCCFiling>> findAll() {
        return ResponseEntity.ok(uccFilingService.findAll());
    }
}
