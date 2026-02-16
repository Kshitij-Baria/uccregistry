package com.kshitijbaria.uccregistry.model.dto.request;

import lombok.Data;

import java.time.Instant;

@Data()
public class UpdateAmendmentDetailsRequest {
    private Long id;
    private String amendmentType;
    private String affectedParty;
    private String partyAction;
    private String collateralChange;
    private Instant createdAt;
    private Instant updatedAt;
}
