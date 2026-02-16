package com.kshitijbaria.uccregistry.service.mapper;

import com.kshitijbaria.uccregistry.model.UCCFiling;
import com.kshitijbaria.uccregistry.model.UCCFilingFamily;
import com.kshitijbaria.uccregistry.model.dto.request.CreateOriginalFilingRequest;
import com.kshitijbaria.uccregistry.model.dto.request.UpdateOriginalFilingRequest;
import com.kshitijbaria.uccregistry.model.dto.response.CollateralDetailsResponse;
import com.kshitijbaria.uccregistry.model.dto.response.OriginalFilingResponse;
import com.kshitijbaria.uccregistry.model.dto.response.PartyDetailsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component()
public class OriginalFilingMapper {
    private final PartyDetailsMapper partyDetailsMapper;
    private final CollateralDetailsMapper collateralDetailsMapper;

    @Autowired()
    public OriginalFilingMapper(PartyDetailsMapper partyDetailsMapper, CollateralDetailsMapper collateralDetailsMapper) {
        this.partyDetailsMapper = partyDetailsMapper;
        this.collateralDetailsMapper = collateralDetailsMapper;
    }

    public UCCFiling toEntity(CreateOriginalFilingRequest createOriginalFilingRequest, UCCFilingFamily filingFamily) {
        UCCFiling filing = new UCCFiling();

        filing.setId(null);
        filing.setFilingFamily(filingFamily);
        filing.setFilingNumber(createOriginalFilingRequest.getFilingNumber());
        filing.setFilingDate(createOriginalFilingRequest.getFilingDate());
        filing.setFilingType("ORIGINAL");

        return filing;
    }

    public UCCFiling toEntity(UpdateOriginalFilingRequest updateOriginalFilingRequest, UCCFiling filing, UCCFilingFamily filingFamily) {
        filing.setFilingFamily(filingFamily);
        filing.setFilingNumber(updateOriginalFilingRequest.getFilingNumber());
        filing.setFilingDate(updateOriginalFilingRequest.getFilingDate());

        return filing;
    }

    public OriginalFilingResponse toResponse(UCCFiling filing) {
        OriginalFilingResponse originalFilingResponse = new OriginalFilingResponse();

        originalFilingResponse.setId(filing.getId());
        originalFilingResponse.setFilingNumber(filing.getFilingNumber());
        originalFilingResponse.setFilingDate(filing.getFilingDate());
        originalFilingResponse.setFilingType(filing.getFilingType());

        List<PartyDetailsResponse> partyDetailsList = filing.getPartyDetailsList().stream()
                .map(partyDetailsMapper::toResponse)
                .toList();
        originalFilingResponse.setPartyDetailsList(partyDetailsList);

        CollateralDetailsResponse collateralDetailsResponse = collateralDetailsMapper.toResponse(filing.getCollateralDetails());
        originalFilingResponse.setCollateralDetails(collateralDetailsResponse);

        originalFilingResponse.setCreatedAt(filing.getCreatedAt());
        originalFilingResponse.setUpdatedAt(filing.getUpdatedAt());

        return originalFilingResponse;
    }
}
