package com.kshitijbaria.uccregistry.model.dto.request;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data()
public class UpdateOriginalFilingRequest {
    private Long id;
    private Long filingFamilyId;
    private String filingNumber;
    private LocalDate filingDate;
    private String filingType;
    private List<UpdatePartyDetailsRequest> partyDetailsList;
    private UpdateCollateralDetailsRequest collateralDetails;
}
