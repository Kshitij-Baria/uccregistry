package com.kshitijbaria.uccregistry.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;

@Entity()
@Table(name = "party_details")
@Data()
public class PartyDetails {
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "party_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "filing_id", nullable = false)
    @JsonIgnore()
    private UCCFiling filing;

    @Column(nullable = false)
    private String partyName;

    @Column(nullable = false)
    private String entityType;

    @Column(nullable = false)
    private String partyRole;

    private String streetAddress;
    private String city;

    @Column(name = "party_state")
    private String state;
    private String countryCode;
    private String postalCode;

    @CreationTimestamp()
    private Instant createdAt;

    @UpdateTimestamp()
    private Instant updatedAt;
}
