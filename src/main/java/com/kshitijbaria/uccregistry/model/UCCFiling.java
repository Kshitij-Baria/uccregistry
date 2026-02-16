package com.kshitijbaria.uccregistry.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

@Entity()
@Table(name = "ucc_filing")
@Data()
public class UCCFiling {
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "filing_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "family_id", nullable = false)
    @JsonIgnore()
    private UCCFilingFamily filingFamily;

    private String filingNumber;
    private LocalDate filingDate;
    private String filingType;

    @OneToMany(mappedBy = "filing", cascade = CascadeType.ALL)
    private List<PartyDetails> partyDetailsList;

    @OneToMany(mappedBy = "filing", cascade = CascadeType.ALL)
    private List<AmendmentDetails> amendmentDetailsList;

    @OneToOne(mappedBy = "filing", cascade = CascadeType.ALL)
    private CollateralDetails collateralDetails;

    @CreationTimestamp()
    private Instant createdAt;

    @UpdateTimestamp()
    private Instant updatedAt;
}
