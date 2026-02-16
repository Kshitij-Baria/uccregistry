package com.kshitijbaria.uccregistry.model.dto.request;

import lombok.Data;

@Data()
public class UpdatePartyDetailsRequest {
    private Long id;
    private String partyName;
    private String entityType;
    private String partyRole;
    private String streetAddress;
    private String city;
    private String state;
    private String countryCode;
    private String postalCode;
}
