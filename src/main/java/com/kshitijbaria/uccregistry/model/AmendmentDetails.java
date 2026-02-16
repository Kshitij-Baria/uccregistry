package com.kshitijbaria.uccregistry.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;

@Entity()
@Table(name = "amendment_details")
@Data()
public class AmendmentDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "amendment_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "filing_id", nullable = false)
    @JsonIgnore()
    private UCCFiling filing;

    @Column(nullable = false)
    private String amendmentType;

    private String affectedParty;
    private String partyAction;
    private String collateralChange;

    @CreationTimestamp()
    private Instant createdAt;

    @UpdateTimestamp()
    private Instant updatedAt;
}
