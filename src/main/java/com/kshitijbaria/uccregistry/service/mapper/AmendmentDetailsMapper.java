package com.kshitijbaria.uccregistry.service.mapper;

import com.kshitijbaria.uccregistry.model.AmendmentDetails;
import com.kshitijbaria.uccregistry.model.UCCFiling;
import com.kshitijbaria.uccregistry.model.dto.request.CreateAmendmentDetailsRequest;
import com.kshitijbaria.uccregistry.model.dto.request.UpdateAmendmentDetailsRequest;
import com.kshitijbaria.uccregistry.model.dto.response.AmendmentDetailsResponse;
import org.springframework.stereotype.Component;

@Component()
public class AmendmentDetailsMapper {
    public AmendmentDetails toEntity(CreateAmendmentDetailsRequest createAmendmentDetailsRequest, UCCFiling filing) {
        AmendmentDetails amendmentDetails = new AmendmentDetails();

        amendmentDetails.setId(null);
        amendmentDetails.setFiling(filing);
        amendmentDetails.setAmendmentType(createAmendmentDetailsRequest.getAmendmentType());
        amendmentDetails.setAffectedParty(createAmendmentDetailsRequest.getAffectedParty());
        amendmentDetails.setPartyAction(createAmendmentDetailsRequest.getPartyAction());
        amendmentDetails.setCollateralChange(createAmendmentDetailsRequest.getCollateralChange());

        return amendmentDetails;
    }

    public AmendmentDetails toEntity(UpdateAmendmentDetailsRequest updateAmendmentDetailsRequest, AmendmentDetails amendmentDetails) {
        amendmentDetails.setId(updateAmendmentDetailsRequest.getId());
        amendmentDetails.setAmendmentType(updateAmendmentDetailsRequest.getAmendmentType());
        amendmentDetails.setAffectedParty(updateAmendmentDetailsRequest.getAffectedParty());
        amendmentDetails.setPartyAction(updateAmendmentDetailsRequest.getPartyAction());
        amendmentDetails.setCollateralChange(updateAmendmentDetailsRequest.getCollateralChange());

        return amendmentDetails;
    }

    public AmendmentDetailsResponse toResponse(AmendmentDetails amendmentDetails) {
        AmendmentDetailsResponse amendmentDetailsResponse = new AmendmentDetailsResponse();

        amendmentDetailsResponse.setId(amendmentDetails.getId());
        amendmentDetailsResponse.setAmendmentType(amendmentDetails.getAmendmentType());
        amendmentDetailsResponse.setAffectedParty(amendmentDetails.getAffectedParty());
        amendmentDetailsResponse.setPartyAction(amendmentDetails.getPartyAction());
        amendmentDetailsResponse.setCollateralChange(amendmentDetails.getCollateralChange());
        amendmentDetailsResponse.setCreatedAt(amendmentDetails.getCreatedAt());
        amendmentDetailsResponse.setUpdatedAt(amendmentDetails.getUpdatedAt());

        return amendmentDetailsResponse;
    }
}
