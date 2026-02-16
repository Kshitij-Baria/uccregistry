package com.kshitijbaria.uccregistry.service.mapper;

import com.kshitijbaria.uccregistry.model.CollateralDetails;
import com.kshitijbaria.uccregistry.model.UCCFiling;
import com.kshitijbaria.uccregistry.model.dto.request.CreateCollateralDetailsRequest;
import com.kshitijbaria.uccregistry.model.dto.request.UpdateCollateralDetailsRequest;
import com.kshitijbaria.uccregistry.model.dto.response.CollateralDetailsResponse;
import org.springframework.stereotype.Component;

@Component()
public class CollateralDetailsMapper {
    public CollateralDetails toEntity(CreateCollateralDetailsRequest createCollateralDetailsRequest, UCCFiling filing) {
        CollateralDetails collateralDetails = new CollateralDetails();

        collateralDetails.setId(null);
        collateralDetails.setFiling(filing);
        collateralDetails.setCollateralText(createCollateralDetailsRequest.getCollateralText());
        collateralDetails.setLienType(createCollateralDetailsRequest.getLienType());
        collateralDetails.setAssetTypes(createCollateralDetailsRequest.getAssetTypes());

        return collateralDetails;
    }

    public CollateralDetails toEntity(UpdateCollateralDetailsRequest updateCollateralDetailsRequest, CollateralDetails collateralDetails) {
        collateralDetails.setCollateralText(updateCollateralDetailsRequest.getCollateralText());
        collateralDetails.setLienType(updateCollateralDetailsRequest.getLienType());
        collateralDetails.setAssetTypes(updateCollateralDetailsRequest.getAssetTypes());

        return collateralDetails;
    }

    public CollateralDetailsResponse toResponse(CollateralDetails collateralDetails) {
        CollateralDetailsResponse collateralDetailsResponse = new CollateralDetailsResponse();

        collateralDetailsResponse.setCollateralText(collateralDetails.getCollateralText());
        collateralDetailsResponse.setLienType(collateralDetails.getLienType());
        collateralDetailsResponse.setAssetTypes(collateralDetails.getAssetTypes());

        return collateralDetailsResponse;
    }
}
