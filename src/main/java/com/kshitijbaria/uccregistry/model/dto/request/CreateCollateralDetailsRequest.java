package com.kshitijbaria.uccregistry.model.dto.request;

import lombok.Data;

import java.util.Set;

@Data()
public class CreateCollateralDetailsRequest {
    private String collateralText;
    private String lienType;
    private Set<String> assetTypes;
}
