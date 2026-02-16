package com.kshitijbaria.uccregistry.controller;

import com.kshitijbaria.uccregistry.model.CollateralDetails;
import com.kshitijbaria.uccregistry.service.CollateralDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("/collateral_details")
public class CollateralDetailsController {
    @Autowired()
    private CollateralDetailsService collateralDetailsService;

    @GetMapping()
    public ResponseEntity<List<CollateralDetails>> findAll() {
        return ResponseEntity.ok(collateralDetailsService.findAll());
    }
}
