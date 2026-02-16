package com.kshitijbaria.uccregistry.service;

import com.kshitijbaria.uccregistry.model.PartyDetails;
import com.kshitijbaria.uccregistry.model.UCCFiling;
import com.kshitijbaria.uccregistry.model.dto.request.CreatePartyDetailsRequest;
import com.kshitijbaria.uccregistry.model.dto.request.UpdatePartyDetailsRequest;
import com.kshitijbaria.uccregistry.model.dto.response.PartyDetailsResponse;
import com.kshitijbaria.uccregistry.repository.PartyDetailsRepository;
import com.kshitijbaria.uccregistry.service.mapper.PartyDetailsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service()
public class PartyDetailsService {
    private final PartyDetailsRepository partyDetailsRepository;
    private final PartyDetailsMapper partyDetailsMapper;

    @Autowired()
    public PartyDetailsService(PartyDetailsRepository partyDetailsRepository, PartyDetailsMapper partyDetailsMapper) {
        this.partyDetailsRepository = partyDetailsRepository;
        this.partyDetailsMapper = partyDetailsMapper;
    }

    public List<PartyDetails> findAll() {
        return partyDetailsRepository.findAll();
    }

    public PartyDetails findById(long id) {
        return partyDetailsRepository.findById(id).orElse(null);
    }

    public List<PartyDetails> findAllById(List<Long> ids) {
        return partyDetailsRepository.findAllById(ids);
    }

    public PartyDetailsResponse save(PartyDetails partyDetails) {
        // partyDetails = partyDetailsRepository.save(partyDetails);
        return partyDetailsMapper.toResponse(partyDetails);
    }

    public PartyDetailsResponse save(CreatePartyDetailsRequest createPartyDetailsRequest, UCCFiling filing) {
        PartyDetails partyDetails = partyDetailsMapper.toEntity(createPartyDetailsRequest, filing);
        return save(partyDetails);
    }

    public PartyDetailsResponse update(UpdatePartyDetailsRequest updatePartyDetailsRequest) {
        PartyDetails partyDetails = partyDetailsMapper.toEntity(updatePartyDetailsRequest, findById(updatePartyDetailsRequest.getId()));
        return save(partyDetails);
    }

    public List<PartyDetailsResponse> saveAll(List<PartyDetails> partyDetailsList) {
        // partyDetailsList = partyDetailsRepository.saveAll(partyDetailsList);
        return partyDetailsList.stream()
                .map(partyDetailsMapper::toResponse)
                .toList();
    }

    public List<PartyDetailsResponse> saveAll(List<CreatePartyDetailsRequest> createPartyDetailsRequestList, UCCFiling filing) {
        List<PartyDetails> partyDetailsList = createPartyDetailsRequestList.stream()
                .map(createPartyDetailsRequest -> partyDetailsMapper.toEntity(createPartyDetailsRequest, filing))
                .toList();
        return saveAll(partyDetailsList);
    }

    public List<PartyDetailsResponse> updateAll(List<UpdatePartyDetailsRequest> updatePartyDetailsRequestList) {
        List<PartyDetails> partyDetailsList = updatePartyDetailsRequestList.stream()
                .map(createPartyDetailsRequest -> partyDetailsMapper.toEntity(createPartyDetailsRequest, findById(createPartyDetailsRequest.getId())))
                .toList();
        return saveAll(partyDetailsList);
    }
}
