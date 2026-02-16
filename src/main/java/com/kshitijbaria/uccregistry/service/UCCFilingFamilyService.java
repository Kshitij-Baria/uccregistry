package com.kshitijbaria.uccregistry.service;

import com.kshitijbaria.uccregistry.model.UCCFilingFamily;
import com.kshitijbaria.uccregistry.model.dto.request.CreateFilingFamilyRequest;
import com.kshitijbaria.uccregistry.model.dto.request.UpdateFilingFamilyRequest;
import com.kshitijbaria.uccregistry.model.dto.response.FilingFamilyResponse;
import com.kshitijbaria.uccregistry.repository.UCCFilingFamilyRepository;
import com.kshitijbaria.uccregistry.service.mapper.FilingFamilyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service()
public class UCCFilingFamilyService {
    private final UCCFilingFamilyRepository uccFilingFamilyRepository;
    private final FilingFamilyMapper filingFamilyMapper;

    @Autowired()
    public UCCFilingFamilyService(UCCFilingFamilyRepository uccFilingFamilyRepository, FilingFamilyMapper filingFamilyMapper) {
        this.uccFilingFamilyRepository = uccFilingFamilyRepository;
        this.filingFamilyMapper = filingFamilyMapper;
    }

    public List<UCCFilingFamily> findAll() {
        return uccFilingFamilyRepository.findAll();
    }

    public UCCFilingFamily findById(Long id) {
        return uccFilingFamilyRepository.findById(id).orElse(null);
    }

    public FilingFamilyResponse save(UCCFilingFamily filingFamily) {
        // filingFamily = uccFilingFamilyRepository.save(filingFamily);
        return filingFamilyMapper.toResponse(filingFamily);
    }

    public FilingFamilyResponse save(CreateFilingFamilyRequest createFilingFamilyRequest) {
        UCCFilingFamily filingFamily = filingFamilyMapper.toEntity(createFilingFamilyRequest);
        return save(filingFamily);
    }

    public FilingFamilyResponse update(UpdateFilingFamilyRequest updateFilingFamilyRequest) {
        UCCFilingFamily filingFamily = filingFamilyMapper.toEntity(updateFilingFamilyRequest, findById(updateFilingFamilyRequest.getId()));
        return save(filingFamily);
    }
}
