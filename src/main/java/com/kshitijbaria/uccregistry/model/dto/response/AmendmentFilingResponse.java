package com.kshitijbaria.uccregistry.model.dto.response;

import lombok.Data;

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

@Data()
public class AmendmentFilingResponse {
    private Long id;
    private Long filingFamilyId;
    private String filingNumber;
    private LocalDate filingDate;
    private String filingType;
    private List<AmendmentDetailsResponse> amendmentDetailsList;
    private List<PartyDetailsResponse> partyDetailsList;
    private CollateralDetailsResponse collateralDetails;
    private Instant createdAt;
    private Instant updatedAt;
}
