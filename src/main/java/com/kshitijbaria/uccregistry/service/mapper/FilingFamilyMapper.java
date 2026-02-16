package com.kshitijbaria.uccregistry.service.mapper;

import com.kshitijbaria.uccregistry.model.UCCFiling;
import com.kshitijbaria.uccregistry.model.UCCFilingFamily;
import com.kshitijbaria.uccregistry.model.dto.request.CreateFilingFamilyRequest;
import com.kshitijbaria.uccregistry.model.dto.request.UpdateFilingFamilyRequest;
import com.kshitijbaria.uccregistry.model.dto.response.AmendmentFilingResponse;
import com.kshitijbaria.uccregistry.model.dto.response.FilingFamilyResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component()
public class FilingFamilyMapper {
    private final OriginalFilingMapper originalFilingMapper;
    private final AmendmentFilingMapper amendmentFilingMapper;

    @Autowired
    public FilingFamilyMapper(OriginalFilingMapper originalFilingMapper, AmendmentFilingMapper amendmentFilingMapper) {
        this.originalFilingMapper = originalFilingMapper;
        this.amendmentFilingMapper = amendmentFilingMapper;
    }

    public UCCFilingFamily toEntity(CreateFilingFamilyRequest createFilingFamilyRequest) {
        UCCFilingFamily uccFilingFamily = new UCCFilingFamily();

        uccFilingFamily.setFilingState(createFilingFamilyRequest.getFilingState());

        return uccFilingFamily;
    }

    public UCCFilingFamily toEntity(UpdateFilingFamilyRequest updateFilingFamilyRequest, UCCFilingFamily uccFilingFamily) {
        uccFilingFamily.setId(updateFilingFamilyRequest.getId());
        uccFilingFamily.setFilingState(updateFilingFamilyRequest.getFilingState());

        return uccFilingFamily;
    }

    public FilingFamilyResponse toResponse(UCCFilingFamily uccFilingFamily) {
        FilingFamilyResponse filingFamilyResponse = new FilingFamilyResponse();

        filingFamilyResponse.setId(uccFilingFamily.getId());
        filingFamilyResponse.setFilingState(uccFilingFamily.getFilingState());
        filingFamilyResponse.setExpirationDate(uccFilingFamily.getExpirationDate());
        filingFamilyResponse.setFilingStatus(uccFilingFamily.getFilingStatus());

        UCCFiling originalFilingDetails = uccFilingFamily.getFilings().stream()
                .filter(filing -> filing.getFilingType().equalsIgnoreCase("ORIGINAL"))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Filing Type Not Found"));
        filingFamilyResponse.setOriginalFilingDetails(originalFilingMapper.toResponse(originalFilingDetails));

        List<AmendmentFilingResponse> amendmentFilingDetails = uccFilingFamily.getFilings().stream()
                .filter(filing -> filing.getFilingType().equalsIgnoreCase("AMENDMENT"))
                .map(amendmentFilingMapper::toResponse)
                .toList();
        filingFamilyResponse.setAmendmentFilingDetails(amendmentFilingDetails);

        filingFamilyResponse.setCreatedAt(uccFilingFamily.getCreatedAt());
        filingFamilyResponse.setUpdatedAt(uccFilingFamily.getUpdatedAt());

        return filingFamilyResponse;
    }
}
