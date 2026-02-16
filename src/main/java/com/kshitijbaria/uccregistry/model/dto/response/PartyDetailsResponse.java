package com.kshitijbaria.uccregistry.model.dto.response;

import lombok.Data;

import java.time.Instant;

@Data()
public class PartyDetailsResponse {
    private Long id;
    private String partyName;
    private String entityType;
    private String partyRole;
    private String streetAddress;
    private String city;
    private String state;
    private String countryCode;
    private String postalCode;
    private Instant createdAt;
    private Instant updatedAt;
}
