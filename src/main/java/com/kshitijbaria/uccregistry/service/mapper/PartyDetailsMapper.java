package com.kshitijbaria.uccregistry.service.mapper;

import com.kshitijbaria.uccregistry.model.PartyDetails;
import com.kshitijbaria.uccregistry.model.UCCFiling;
import com.kshitijbaria.uccregistry.model.dto.request.CreatePartyDetailsRequest;
import com.kshitijbaria.uccregistry.model.dto.request.UpdatePartyDetailsRequest;
import com.kshitijbaria.uccregistry.model.dto.response.PartyDetailsResponse;
import org.springframework.stereotype.Component;

@Component()
public class PartyDetailsMapper {
    public PartyDetails toEntity(CreatePartyDetailsRequest createPartyDetailsRequest, UCCFiling filing) {
        PartyDetails partyDetails = new PartyDetails();

        partyDetails.setId(null);
        partyDetails.setFiling(filing);
        partyDetails.setPartyName(createPartyDetailsRequest.getPartyName());
        partyDetails.setEntityType(createPartyDetailsRequest.getEntityType());
        partyDetails.setPartyRole(createPartyDetailsRequest.getPartyRole());
        partyDetails.setStreetAddress(createPartyDetailsRequest.getStreetAddress());
        partyDetails.setCity(createPartyDetailsRequest.getCity());
        partyDetails.setState(createPartyDetailsRequest.getState());
        partyDetails.setPostalCode(createPartyDetailsRequest.getPostalCode());
        partyDetails.setCountryCode(createPartyDetailsRequest.getCountryCode());

        return partyDetails;
    }

    public PartyDetails toEntity(UpdatePartyDetailsRequest  updatePartyDetailsRequest, PartyDetails partyDetails) {
        partyDetails.setPartyName(updatePartyDetailsRequest.getPartyName());
        partyDetails.setEntityType(updatePartyDetailsRequest.getEntityType());
        partyDetails.setPartyRole(updatePartyDetailsRequest.getPartyRole());
        partyDetails.setStreetAddress(updatePartyDetailsRequest.getStreetAddress());
        partyDetails.setCity(updatePartyDetailsRequest.getCity());
        partyDetails.setState(updatePartyDetailsRequest.getState());
        partyDetails.setPostalCode(updatePartyDetailsRequest.getPostalCode());
        partyDetails.setCountryCode(updatePartyDetailsRequest.getCountryCode());

        return partyDetails;
    }

    public PartyDetailsResponse toResponse(PartyDetails partyDetails) {
        PartyDetailsResponse partyDetailsResponse = new PartyDetailsResponse();

        partyDetailsResponse.setId(partyDetails.getId());
        partyDetailsResponse.setPartyName(partyDetails.getPartyName());
        partyDetailsResponse.setEntityType(partyDetails.getEntityType());
        partyDetailsResponse.setPartyRole(partyDetails.getPartyRole());
        partyDetailsResponse.setStreetAddress(partyDetails.getStreetAddress());
        partyDetailsResponse.setCity(partyDetails.getCity());
        partyDetailsResponse.setState(partyDetails.getState());
        partyDetailsResponse.setPostalCode(partyDetails.getPostalCode());
        partyDetailsResponse.setCountryCode(partyDetails.getCountryCode());

        return partyDetailsResponse;
    }
}
