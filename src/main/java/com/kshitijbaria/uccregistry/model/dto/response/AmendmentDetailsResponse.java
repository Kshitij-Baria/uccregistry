package com.kshitijbaria.uccregistry.model.dto.response;

import lombok.Data;

import java.time.Instant;

@Data()
public class AmendmentDetailsResponse {
    private Long id;
    private String amendmentType;
    private String affectedParty;
    private String partyAction;
    private String collateralChange;
    private Instant createdAt;
    private Instant updatedAt;
}
