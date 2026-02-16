package com.kshitijbaria.uccregistry.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

@Entity()
@Table(name = "ucc_filing_family")
@Data()
public class UCCFilingFamily {
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "family_id")
    private Long id;

    private String filingState;
    private LocalDate expirationDate;
    private String filingStatus;

    @OneToMany(mappedBy = "filingFamily", cascade = CascadeType.ALL)
    private List<UCCFiling> filings;

    @CreationTimestamp()
    private Instant createdAt;

    @UpdateTimestamp()
    private Instant updatedAt;
}
