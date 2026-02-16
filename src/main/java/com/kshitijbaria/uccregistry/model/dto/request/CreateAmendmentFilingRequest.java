package com.kshitijbaria.uccregistry.model.dto.request;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data()
public class CreateAmendmentFilingRequest {
    private Long filingFamilyId;
    private String filingNumber;
    private LocalDate filingDate;
    private List<CreateAmendmentDetailsRequest> amendmentDetailsList;
    private List<CreatePartyDetailsRequest> partyDetailsList;
    private CreateCollateralDetailsRequest collateralDetails;
}
