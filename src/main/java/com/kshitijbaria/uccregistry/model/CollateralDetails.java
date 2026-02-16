package com.kshitijbaria.uccregistry.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity()
@Table(name = "collateral_details")
@Data()
public class CollateralDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "collateral_id")
    private Long id;

    @OneToOne()
    @JoinColumn(name = "filing_id", nullable = false, unique = true)
    @JsonIgnore()
    private UCCFiling filing;

    private String collateralText;
    private String lienType;

    @ElementCollection
    @CollectionTable(
            name = "collateral_asset_details",
            joinColumns = @JoinColumn(name = "collateral_id")
    )
    @Column(name = "asset_type")
    private Set<String> assetTypes;
}
