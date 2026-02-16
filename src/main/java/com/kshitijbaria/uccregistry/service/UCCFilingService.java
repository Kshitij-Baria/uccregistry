package com.kshitijbaria.uccregistry.service;

import com.kshitijbaria.uccregistry.model.CollateralDetails;
import com.kshitijbaria.uccregistry.model.PartyDetails;
import com.kshitijbaria.uccregistry.model.UCCFiling;
import com.kshitijbaria.uccregistry.model.UCCFilingFamily;
import com.kshitijbaria.uccregistry.model.dto.request.*;
import com.kshitijbaria.uccregistry.model.dto.response.AmendmentFilingResponse;
import com.kshitijbaria.uccregistry.model.dto.response.CollateralDetailsResponse;
import com.kshitijbaria.uccregistry.model.dto.response.OriginalFilingResponse;
import com.kshitijbaria.uccregistry.model.dto.response.PartyDetailsResponse;
import com.kshitijbaria.uccregistry.repository.UCCFilingRepository;
import com.kshitijbaria.uccregistry.service.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service()
public class UCCFilingService {
    private final UCCFilingRepository uccFilingRepository;
    private final OriginalFilingMapper originalFilingMapper;
    private final AmendmentFilingMapper amendmentFilingMapper;
    private final AmendmentDetailsService amendmentDetailsService;
    private final PartyDetailsMapper partyDetailsMapper;
    private final PartyDetailsService partyDetailsService;
    private final CollateralDetailsMapper collateralDetailsMapper;
    private final CollateralDetailsService collateralDetailsService;

    @Autowired()
    public UCCFilingService(UCCFilingRepository uccFilingRepository,
                            OriginalFilingMapper originalFilingMapper,
                            AmendmentFilingMapper amendmentFilingMapper,
                            AmendmentDetailsService amendmentDetailsService,
                            PartyDetailsMapper partyDetailsMapper,
                            PartyDetailsService partyDetailsService,
                            CollateralDetailsMapper collateralDetailsMapper,
                            CollateralDetailsService collateralDetailsService) {
        this.uccFilingRepository = uccFilingRepository;
        this.originalFilingMapper = originalFilingMapper;
        this.amendmentFilingMapper = amendmentFilingMapper;
        this.amendmentDetailsService = amendmentDetailsService;
        this.partyDetailsMapper = partyDetailsMapper;
        this.partyDetailsService = partyDetailsService;
        this.collateralDetailsMapper = collateralDetailsMapper;
        this.collateralDetailsService = collateralDetailsService;
    }

    public List<UCCFiling> findAll() {
        return uccFilingRepository.findAll();
    }

    public UCCFiling findById(Long id) {
        return uccFilingRepository.findById(id).orElse(null);
    }

    public UCCFiling save(UCCFiling filing) {
        return uccFilingRepository.save(filing);
    }

    public OriginalFilingResponse saveOriginal(UCCFiling filing) {
        // filing = save(filing);
        return originalFilingMapper.toResponse(filing);
    }

    public AmendmentFilingResponse saveAmendment(UCCFiling filing) {
        // filing = save(filing);
        return amendmentFilingMapper.toResponse(filing);
    }

    public OriginalFilingResponse saveOriginal(CreateOriginalFilingRequest createOriginalFilingRequest, UCCFilingFamily filingFamily) {
        UCCFiling filing = originalFilingMapper.toEntity(createOriginalFilingRequest, filingFamily);

        List<PartyDetails> partyDetailsList = createOriginalFilingRequest.getPartyDetailsList().stream()
                .map(createPartyDetailsRequest -> partyDetailsMapper.toEntity(createPartyDetailsRequest, filing))
                .toList();
        filing.setPartyDetailsList(partyDetailsList);

        CollateralDetails collateralDetails = collateralDetailsMapper.toEntity(createOriginalFilingRequest.getCollateralDetails(), filing);
        filing.setCollateralDetails(collateralDetails);

        return saveOriginal(filing);
    }

    public OriginalFilingResponse updateOriginal(UpdateOriginalFilingRequest updateOriginalFilingRequest, UCCFilingFamily filingFamily) {
        UCCFiling filing = originalFilingMapper.toEntity(updateOriginalFilingRequest, findById(updateOriginalFilingRequest.getId()), filingFamily);

        List<Long> partyDetailsIdList = updateOriginalFilingRequest.getPartyDetailsList().stream()
                .map(UpdatePartyDetailsRequest::getId)
                .toList();

        List<PartyDetails> existentPartyDetailsList = partyDetailsService.findAllById(partyDetailsIdList);
        xxx


        return saveOriginal(filing);
    }

    public AmendmentFilingResponse saveAmendment(CreateAmendmentFilingRequest createAmendmentFilingRequest, UCCFilingFamily filingFamily) {
        UCCFiling filing = amendmentFilingMapper.toEntity(createAmendmentFilingRequest, filingFamily);
        return saveAmendment(filing);
    }

    public AmendmentFilingResponse updateAmendment(UpdateAmendmentFilingRequest updateAmendmentFilingRequest, UCCFilingFamily filingFamily) {
        UCCFiling filing = amendmentFilingMapper.toEntity(updateAmendmentFilingRequest, findById(updateAmendmentFilingRequest.getId()), filingFamily);
        return saveAmendment(filing);
    }
}
