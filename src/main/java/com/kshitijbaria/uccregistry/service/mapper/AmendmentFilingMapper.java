package com.kshitijbaria.uccregistry.service.mapper;

import com.kshitijbaria.uccregistry.model.UCCFiling;
import com.kshitijbaria.uccregistry.model.UCCFilingFamily;
import com.kshitijbaria.uccregistry.model.dto.request.CreateAmendmentFilingRequest;
import com.kshitijbaria.uccregistry.model.dto.request.UpdateAmendmentFilingRequest;
import com.kshitijbaria.uccregistry.model.dto.response.AmendmentDetailsResponse;
import com.kshitijbaria.uccregistry.model.dto.response.AmendmentFilingResponse;
import com.kshitijbaria.uccregistry.model.dto.response.CollateralDetailsResponse;
import com.kshitijbaria.uccregistry.model.dto.response.PartyDetailsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component()
public class AmendmentFilingMapper {
    private final AmendmentDetailsMapper amendmentDetailsMapper;
    private final PartyDetailsMapper partyDetailsMapper;
    private final CollateralDetailsMapper collateralDetailsMapper;

    @Autowired()
    public AmendmentFilingMapper(AmendmentDetailsMapper amendmentDetailsMapper, PartyDetailsMapper partyDetailsMapper, CollateralDetailsMapper collateralDetailsMapper) {
        this.amendmentDetailsMapper = amendmentDetailsMapper;
        this.partyDetailsMapper = partyDetailsMapper;
        this.collateralDetailsMapper = collateralDetailsMapper;
    }

    public UCCFiling toEntity(CreateAmendmentFilingRequest createAmendmentFilingRequest, UCCFilingFamily filingFamily) {
        UCCFiling filing = new UCCFiling();

        filing.setId(null);
        filing.setFilingFamily(filingFamily);
        filing.setFilingNumber(createAmendmentFilingRequest.getFilingNumber());
        filing.setFilingDate(createAmendmentFilingRequest.getFilingDate());
        filing.setFilingType("AMENDMENT");

        return filing;
    }

    public UCCFiling toEntity(UpdateAmendmentFilingRequest updateAmendmentFilingRequest, UCCFiling filing, UCCFilingFamily filingFamily) {
        filing.setFilingFamily(filingFamily);
        filing.setFilingNumber(updateAmendmentFilingRequest.getFilingNumber());
        filing.setFilingDate(updateAmendmentFilingRequest.getFilingDate());

        return filing;
    }

    public AmendmentFilingResponse toResponse(UCCFiling filing) {
        AmendmentFilingResponse amendmentFilingResponse = new AmendmentFilingResponse();

        amendmentFilingResponse.setId(filing.getId());
        amendmentFilingResponse.setFilingNumber(filing.getFilingNumber());
        amendmentFilingResponse.setFilingDate(filing.getFilingDate());
        amendmentFilingResponse.setFilingType(filing.getFilingType());

        List<AmendmentDetailsResponse> amendmentDetailsList = filing.getAmendmentDetailsList().stream()
                .map(amendmentDetailsMapper::toResponse)
                .toList();
        amendmentFilingResponse.setAmendmentDetailsList(amendmentDetailsList);

        List<PartyDetailsResponse> partyDetailsList = filing.getPartyDetailsList().stream()
                .map(partyDetailsMapper::toResponse)
                .toList();
        amendmentFilingResponse.setPartyDetailsList(partyDetailsList);

        CollateralDetailsResponse collateralDetailsResponse = collateralDetailsMapper.toResponse(filing.getCollateralDetails());
        amendmentFilingResponse.setCollateralDetails(collateralDetailsResponse);

        amendmentFilingResponse.setCreatedAt(filing.getCreatedAt());
        amendmentFilingResponse.setUpdatedAt(filing.getUpdatedAt());

        return amendmentFilingResponse;
    }
}
