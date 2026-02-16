package com.kshitijbaria.uccregistry.model.dto.response;

import lombok.Data;

import java.util.Set;

@Data()
public class CollateralDetailsResponse {
    private String collateralText;
    private String lienType;
    private Set<String> assetTypes;
}
