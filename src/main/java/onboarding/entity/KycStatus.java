package onboarding.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "kyc_jobs")
public class KycStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String status; // free text like NEW, DOCS_RECEIVED, VERIFIED

    @Enumerated(EnumType.STRING)
    private KycState kycStatus; // Enum: PENDING, APPROVED, REJECTED

    // 👇 Relationship back to Customer
    @OneToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    @JsonBackReference
    private Customer customer;

    // getters & setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public KycState getKycStatus() { return kycStatus; }
    public void setKycStatus(KycState kycStatus) { this.kycStatus = kycStatus; }

    public Customer getCustomer() { return customer; }
    public void setCustomer(Customer customer) { this.customer = customer; }
}
