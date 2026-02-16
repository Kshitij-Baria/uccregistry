package com.kshitijbaria.uccregistry.model.dto.response;

import lombok.Data;

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

@Data()
public class FilingFamilyResponse {
    private Long id;
    private String filingState;
    private LocalDate expirationDate;
    private String filingStatus;
    private OriginalFilingResponse originalFilingDetails;
    private List<AmendmentFilingResponse> amendmentFilingDetails;
    private Instant createdAt;
    private Instant updatedAt;
}
