package com.kshitijbaria.uccregistry.controller;

import com.kshitijbaria.uccregistry.model.AmendmentDetails;
import com.kshitijbaria.uccregistry.service.AmendmentDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("/amendment_details")
public class AmendmentDetailsController {
    @Autowired()
    private AmendmentDetailsService amendmentDetailsService;

    @GetMapping()
    public ResponseEntity<List<AmendmentDetails>> findAll() {
        return ResponseEntity.ok(amendmentDetailsService.findAll());
    }
}
