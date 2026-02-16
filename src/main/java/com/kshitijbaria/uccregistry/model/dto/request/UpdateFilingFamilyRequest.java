package com.kshitijbaria.uccregistry.model.dto.request;

import lombok.Data;

import java.util.List;

@Data()
public class UpdateFilingFamilyRequest {
    private Long id;
    private String filingState;
    private UpdateOriginalFilingRequest originalFilingDetails;
    private List<UpdateAmendmentFilingRequest> amendmentFilingDetails;
}
