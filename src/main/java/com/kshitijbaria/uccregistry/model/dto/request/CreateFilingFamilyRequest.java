package com.kshitijbaria.uccregistry.model.dto.request;

import lombok.Data;

import java.util.List;

@Data()
public class CreateFilingFamilyRequest {
    private String filingState;
    private CreateOriginalFilingRequest originalFilingDetails;
    private List<CreateAmendmentFilingRequest> amendmentFilingDetails;
}
